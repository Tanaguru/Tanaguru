/*
 *  Tanaguru - Automated webpage assessment
 *  Copyright (C) 2008-2015  Tanaguru.org
 * 
 *  This file is part of Tanaguru.
 * 
 *  Tanaguru is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 * 
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 *  Contact us by mail: tanaguru AT tanaguru DOT org
 */
package org.tanaguru.sebuilder;

import com.sebuilder.interpreter.Script;
import com.sebuilder.interpreter.Step;
import com.sebuilder.interpreter.factory.ScriptFactory;
import com.sebuilder.interpreter.factory.ScriptFactory.SuiteException;
import com.sebuilder.interpreter.factory.TestRunFactory;
import com.sebuilder.interpreter.steptype.Get;
import java.io.IOException;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.tanaguru.crawler.util.CrawlUtils;
import org.tanaguru.entity.parameterization.ParameterElement;
import org.tanaguru.entity.subject.WebResource;
import org.tanaguru.exception.ScenarioLoaderException;
import org.tanaguru.scenarioloader.AbstractScenarioLoader;
import org.tanaguru.scenarioloadertools.FirefoxDriverObjectPool;
import org.tanaguru.scenarioloadertools.ProfileFactory;
import org.tanaguru.sebuilder.interpreter.NewPageListener;
import org.tanaguru.sebuilder.interpreter.exception.TestRunException;
import org.tanaguru.sebuilder.interpreter.factory.TgStepTypeFactory;
import org.tanaguru.sebuilder.interpreter.factory.TgTestRunFactory;

/**
 *
 * @author jkowalczyk
 */
public class SeBuilderLoaderImpl extends AbstractScenarioLoader implements NewPageListener {

    private static final Logger LOGGER = Logger.getLogger(SeBuilderLoaderImpl.class);

    private int implicitelyWaitDriverTimeout = 1;

    private static final int SCENARIO_IMPLICITELY_WAIT_TIMEOUT = 60;

    /** The script factory instance */
    private final ScriptFactory scriptFactory = new ScriptFactory();




    private FirefoxDriverObjectPool firefoxDriverObjectPool;

    public FirefoxDriverObjectPool getFirefoxDriverObjectPool() {
        return firefoxDriverObjectPool;
    }

    public void setFirefoxDriverObjectPool(FirefoxDriverObjectPool firefoxDriverObjectPool) {
        this.firefoxDriverObjectPool = firefoxDriverObjectPool;
    }


    public SeBuilderLoaderImpl(
            WebResource webResource,
            String scenario) {
        super(webResource, scenario);
    }

    @Override
    public void run() {
        try {
            LOGGER.debug("Launch Scenario "   + scenario );
            FirefoxProfile firefoxProfile;
            if (isScenarioOnlyLoadPage(scenario)) {
                LOGGER.debug("Audit page script");
                firefoxProfile = profileFactory.getOnlineProfile();
            } else {
                LOGGER.debug("Scenario script, images are loaded and implicitly "
                        + "wait timeout set");
                implicitelyWaitDriverTimeout = SCENARIO_IMPLICITELY_WAIT_TIMEOUT;
                firefoxProfile = profileFactory.getScenarioProfile();
            }

            Script script = getScriptFromScenario(scenario, firefoxProfile);
            try {
                if (script.run()) {
                    LOGGER.debug(webResource.getURL()  + " succeeded");
                } else {
                    LOGGER.debug(webResource.getURL() + " failed");
                }
            } catch (TestRunException tre) {
                // The TestRunException is caught but not as runtime, to audit
                // at least pages already fetched
                LOGGER.warn(tre.getMessage());
            } catch (RuntimeException re) {
                LOGGER.warn(re.getMessage());
                throw new ScenarioLoaderException(re);
            }
            profileFactory.shutdownFirefoxProfile(firefoxProfile);
        } catch (IOException | JSONException | SuiteException ex) {
            LOGGER.warn(ex.getMessage());
            throw new ScenarioLoaderException(ex);
        }
    }

    
    @Override
    public void fireNewPage(
            String url, 
            String sourceCode, 
            byte[] snapshot, 
            Map<String, String> jsScriptMap) {
        String charset = super.UTF8;
        try {
            charset = CrawlUtils.extractCharset(IOUtils.toInputStream(sourceCode));
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.fireNewSSP(url, sourceCode, snapshot, jsScriptMap, charset);
    }



    /**
     *
     * @param firefoxProfile
     * @return an initialised instance of TestRunFactory
     */
    private TestRunFactory initTestRunFactory (FirefoxProfile firefoxProfile){
        TgTestRunFactory testRunFactory = new TgTestRunFactory();
        testRunFactory.addNewPageListener(this);
        testRunFactory.setFirefoxProfile(firefoxProfile);
        testRunFactory.setJsScriptMap(jsScriptMap);
        if (implicitelyWaitDriverTimeout != -1) {
            testRunFactory.setImplicitlyWaitDriverTimeout(implicitelyWaitDriverTimeout);
        }
        testRunFactory.setPageLoadDriverTimeout(pageLoadDriverTimeout);

        testRunFactory.setScreenHeight(
                Integer.valueOf(
                        parameterDataService.getParameter(
                                webResource.getAudit(), ParameterElement.SCREEN_HEIGHT_KEY).getValue()));
        testRunFactory.setScreenWidth(
                Integer.valueOf(
                        parameterDataService.getParameter(
                                webResource.getAudit(), ParameterElement.SCREEN_WIDTH_KEY).getValue()));
        testRunFactory.setWaitTimeNgApp(
                Integer.valueOf(
                        parameterDataService.getParameter(
                                webResource.getAudit(), ParameterElement.WAIT_TIME_NG_APP).getValue()));
//      ((TgTestRunFactory)testRunFactory).setFirefoxDriverObjectPool(firefoxDriverObjectPool);
        return testRunFactory;
    }

    /**
     *
     * @param scenario
     * @param firefoxProfile
     * @return an initialised Script ready to be run.
     *
     * @throws IOException
     * @throws JSONException
     */
    private Script getScriptFromScenario(String scenario, FirefoxProfile firefoxProfile) throws IOException, JSONException, SuiteException {
        scriptFactory.setTestRunFactory(initTestRunFactory(firefoxProfile));
        scriptFactory.setStepTypeFactory(new TgStepTypeFactory());
        return scriptFactory.parse(scenario);
    }

    /**
     * Parse the steps of the scenario to determine whether it only contains
     * Get steps.
     *
     * @param scenario
     * @return
     * @throws IOException
     * @throws JSONException
     */
    private boolean isScenarioOnlyLoadPage(String scenario)  throws IOException, JSONException, SuiteException{
        Script script = scriptFactory.parse(scenario);
        for (Step step : script.steps) {
            if (!(step.type instanceof Get)) {
                return false;
            }
        }
        return true;
    }

}