package org.tanaguru.scenarioloader;

import jp.vmi.selenium.selenese.Parser;
import jp.vmi.selenium.selenese.Runner;
import jp.vmi.selenium.selenese.Selenese;
import jp.vmi.selenium.selenese.TestProject;
import jp.vmi.selenium.selenese.command.CommandFactory;
import jp.vmi.selenium.selenese.command.ICommand;
import jp.vmi.selenium.selenese.command.ICommandFactory;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.springframework.beans.factory.annotation.Autowired;
import org.tanaguru.entity.parameterization.ParameterElement;
import org.tanaguru.exception.ScenarioLoaderException;
import org.tanaguru.selenese.SeleneseHelper;
import org.tanaguru.selenese.command.TanaguruAudit;
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
            CommandFactory cf = runner.getCommandFactory();
            cf.registerCommandFactory(new ICommandFactory() {
                @Override
                public ICommand newCommand(int index, String name, String... args) {
                    ICommand res;
                    switch (name){
                        case "tanaguru audit" :
                            res = new TanaguruAudit(index, name, args);
                            break;
                        default:
                            res = null;
                    }

                    return res;
                }
            });

            runner.setTimeout((SCENARIO_IMPLICITELY_WAIT_TIMEOUT)*1000);
            runner.setDriver(tngDriver);

            //Get scenario
            Selenese script = null;
            InputStream input = new ByteArrayInputStream(scenario.getBytes());
            script =  Parser.parse("scenario.side", input, cf);
            input.close();

            //Run scenario
            TestProject project = (TestProject)script;
            for(Selenese test : project.getSeleneseList()){
                runner.execute(test);
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        } finally {
            endTanaguruDriver();
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

    @Autowired
    public void setProfileFactory(ProfileFactoryImpl profileFactory) {
        this.profileFactory = profileFactory;
    }

    private void initTanaguruDriver(){
        //Initialize webdriver
        int ngAppWait = Integer.parseInt(parameterDataService.getParameter(
                webResource.getAudit(),
                ParameterElement.WAIT_TIME_NG_APP).getValue());
        int windowWidth = Integer.parseInt(parameterDataService.getParameter(
                webResource.getAudit(),
                ParameterElement.SCREEN_WIDTH_KEY).getValue());

        int windowHeight = Integer.parseInt(parameterDataService.getParameter(
                webResource.getAudit(),
                ParameterElement.SCREEN_HEIGHT_KEY).getValue());

        TanaguruDriverFactory tngDriverFactory = TanaguruDriverFactory.getInstance();
        tngDriverFactory.setJsScriptMap(jsScriptMap);
        tngDriverFactory.setNgAppWait(ngAppWait);
        tngDriverFactory.setProfileFactory(profileFactory);

        tngDriver = tngDriverFactory.createFirefoxTanaguruWebDriver();
        tngDriver.manage().window().setSize(new Dimension(windowWidth, windowHeight));
        tngDriver.addNewPageListener(this);
    }

    private void endTanaguruDriver(){
        tngDriver.quit();
    }

    @Override
    public void fireNewPage(String url, String sourceCode, byte[] snapshot, Map<String, String> jsResultMap) {
        String charset = super.UTF8;
        try {
            charset = CrawlUtils.extractCharset(IOUtils.toInputStream(sourceCode));
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.fireNewSSP(url, sourceCode, snapshot, jsResultMap, charset);
    }
}
