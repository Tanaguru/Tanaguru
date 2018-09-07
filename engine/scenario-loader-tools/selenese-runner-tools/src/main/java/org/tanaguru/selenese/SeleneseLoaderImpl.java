package org.tanaguru.selenese;

import jp.vmi.selenium.selenese.Parser;
import jp.vmi.selenium.selenese.Runner;
import jp.vmi.selenium.selenese.Selenese;
import jp.vmi.selenium.selenese.TestProject;
import jp.vmi.selenium.selenese.command.CommandFactory;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.tanaguru.crawler.util.CrawlUtils;
import org.tanaguru.entity.subject.WebResource;
import org.tanaguru.scenarioloader.AbstractScenarioLoader;
import org.tanaguru.scenarioloader.NewPageListener;
import org.tanaguru.selenese.tools.ProfileFactoryImpl;
import org.tanaguru.selenese.tools.TanaguruDriver;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

            RemoteWebDriver tngDriver = new TanaguruDriver(ffOptions);
            ((TanaguruDriver) tngDriver).addNewPageListener(this);
            ((TanaguruDriver) tngDriver).setJsScriptMap(jsScriptMap);

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
