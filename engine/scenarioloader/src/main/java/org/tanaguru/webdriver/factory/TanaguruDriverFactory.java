package org.tanaguru.webdriver.factory;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.tanaguru.webdriver.driver.TanaguruDriver;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Map;

public class TanaguruDriverFactory {
    private Map<String, String> jsScriptMap;
    private int ngAppWait;
    private ProfileFactoryImpl profileFactory;

    public TanaguruDriverFactory(Map<String, String> jsScriptMap,
                                 int ngAppWait,
                                 ProfileFactoryImpl profileFactory){
        this.jsScriptMap = jsScriptMap;
        this.ngAppWait = ngAppWait > 500 ? ngAppWait : 500;
        this.profileFactory = profileFactory;
    }

    public TanaguruDriverFactory(Map<String, String> jsScriptMap,
                                 ProfileFactoryImpl profileFactory){
        this.jsScriptMap = jsScriptMap;
        this.ngAppWait = 500;
        this.profileFactory = profileFactory;
    }

    public TanaguruDriver createFirefoxTanaguruWebDriver(){
        ClassLoader classLoader = getClass().getClassLoader();
        File geckodriver = null;
        try {
            geckodriver = new File(classLoader.getResource("geckodriver").toURI());
            geckodriver.setExecutable(true);
            System.setProperty("webdriver.gecko.driver",
                    geckodriver.getPath());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        FirefoxBinary ffBinary = new FirefoxBinary();
        FirefoxOptions ffOptions = new FirefoxOptions();
        ffOptions.setBinary(ffBinary);
        ffOptions.setAcceptInsecureCerts(true);
        ffOptions.setHeadless(true);
        ffOptions.setProfile(profileFactory.getOnlineProfile());

        TanaguruDriver tngDriver = new TanaguruDriver(ffOptions);
        tngDriver.setJsScriptMap(jsScriptMap);
        tngDriver.setWaitTimeNgApp(ngAppWait);

        return tngDriver;
    }
}
