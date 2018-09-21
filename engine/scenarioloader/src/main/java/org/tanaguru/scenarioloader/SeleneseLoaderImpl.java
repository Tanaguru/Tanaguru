package org.tanaguru.scenarioloader;

import jp.vmi.selenium.selenese.Parser;
import jp.vmi.selenium.selenese.Runner;
import jp.vmi.selenium.selenese.Selenese;
import jp.vmi.selenium.selenese.TestProject;
import jp.vmi.selenium.selenese.command.CommandFactory;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.tanaguru.entity.parameterization.ParameterElement;
import org.tanaguru.entity.subject.WebResource;
import org.tanaguru.exception.ScenarioLoaderException;
import org.tanaguru.selenese.SeleneseHelper;
import org.tanaguru.tools.CrawlUtils;
import org.tanaguru.webdriver.driver.TanaguruDriver;
import org.tanaguru.webdriver.factory.ProfileFactoryImpl;
import org.tanaguru.webdriver.factory.TanaguruDriverFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class SeleneseLoaderImpl extends AbstractScenarioLoader implements NewPageListener {

    private static final Logger LOGGER = Logger.getLogger(SeleneseLoaderImpl.class);
    private ProfileFactoryImpl profileFactory;
    TanaguruDriver tngDriver;

    public SeleneseLoaderImpl(
            WebResource webResource,
            ProfileFactoryImpl profileFactory) {
        super(webResource);
        this.profileFactory = profileFactory;
    }

    @Override
    public void run(String scenario) {
        if(!SeleneseHelper.isScenarioValid(scenario)){
            LOGGER.error("Invalid selenese scenario");
            throw new ScenarioLoaderException(new Exception("Scenario does not match selenese scenario syntax"));
        }

        LOGGER.debug("Launch Scenario "   + scenario);
        initTanaguruDriver();
        try {
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
            endTanaguruDriver();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void run(List<String> urlList){
        initTanaguruDriver();
        for(String url : urlList){
            tngDriver.get(url);
        }
        endTanaguruDriver();
    }

    private void initTanaguruDriver(){
        //Initialize webdriver
        int ngAppWait = Integer.parseInt(parameterDataService.getParameter(
                webResource.getAudit(),
                ParameterElement.WAIT_TIME_NG_APP).getValue());
        tngDriver = new TanaguruDriverFactory(jsScriptMap, ngAppWait, profileFactory).createFirefoxTanaguruWebDriver();
        tngDriver.addNewPageListener(this);
    }

    private void endTanaguruDriver(){
        tngDriver.close();
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
