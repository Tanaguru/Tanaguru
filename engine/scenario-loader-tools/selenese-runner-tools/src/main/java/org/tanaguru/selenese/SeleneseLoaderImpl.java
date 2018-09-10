package org.tanaguru.selenese;

import jp.vmi.selenium.selenese.Parser;
import jp.vmi.selenium.selenese.Runner;
import jp.vmi.selenium.selenese.Selenese;
import jp.vmi.selenium.selenese.TestProject;
import jp.vmi.selenium.selenese.command.CommandFactory;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.tanaguru.crawler.util.CrawlUtils;
import org.tanaguru.entity.parameterization.ParameterElement;
import org.tanaguru.entity.subject.WebResource;
import org.tanaguru.scenarioloader.AbstractScenarioLoader;
import org.tanaguru.scenarioloader.NewPageListener;
import org.tanaguru.selenese.tools.driver.TanaguruDriver;
import org.tanaguru.selenese.tools.factory.ProfileFactoryImpl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Map;

public class SeleneseLoaderImpl extends AbstractScenarioLoader implements NewPageListener {

    private static final Logger LOGGER = Logger.getLogger(SeleneseLoaderImpl.class);
    private ProfileFactoryImpl profileFactory;

    public SeleneseLoaderImpl(
            WebResource webResource,
            String scenario,
            ProfileFactoryImpl profileFactory) {
        super(webResource, scenario);
        this.profileFactory = profileFactory;
    }

    @Override
    public void run() {
        LOGGER.debug("Launch Scenario "   + super.scenario);

        try {
            //Initialize webdriver
            int ngAppWait = Integer.parseInt(parameterDataService.getParameter(
                    webResource.getAudit(),
                    ParameterElement.WAIT_TIME_NG_APP).getValue());

            ClassLoader classLoader = getClass().getClassLoader();
            File geckodriver = new File(classLoader.getResource("geckodriver").toURI());
            geckodriver.setExecutable(true);
            System.setProperty("webdriver.gecko.driver",
                    geckodriver.getPath());
            FirefoxBinary ffBinary = new FirefoxBinary();

            FirefoxOptions ffOptions = new FirefoxOptions();
            ffOptions.setBinary(ffBinary);
            ffOptions.setAcceptInsecureCerts(true);
            ffOptions.setHeadless(true);
            ffOptions.setProfile(profileFactory.getOnlineProfile());

            TanaguruDriver tngDriver = new TanaguruDriver(ffOptions);
            tngDriver.addNewPageListener(this);
            tngDriver.setJsScriptMap(jsScriptMap);
            tngDriver.setWaitTimeNgApp(ngAppWait);

            //Initialize runner
            Runner runner = new Runner();
            runner.setTimeout((SCENARIO_IMPLICITELY_WAIT_TIMEOUT)*1000);
            runner.setDriver(tngDriver);

            //Get scenario
            Selenese script = null;
            InputStream input = new ByteArrayInputStream(scenario.getBytes());
            CommandFactory commandFactory = new CommandFactory(runner);
            script =  Parser.parse("scenario.side", input, commandFactory);
            input.close();

            //Run scenario
            TestProject project = (TestProject)script;
            for(Selenese test : project.getSeleneseList()){
                runner.execute(test);
            }

            tngDriver.close();
        } catch (URISyntaxException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void fireNewPage(String url, String sourceCode, byte[] snapshot, Map<String, String> jsResultMap) {
        String charset = super.UTF8;
        try {
            charset = CrawlUtils.extractCharset(IOUtils.toInputStream(sourceCode));
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.fireNewSSP(url, sourceCode, snapshot, jsScriptMap, charset);
    }
}
