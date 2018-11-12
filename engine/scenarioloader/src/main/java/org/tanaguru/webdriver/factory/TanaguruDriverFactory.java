package org.tanaguru.webdriver.factory;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.tanaguru.webdriver.driver.TanaguruDriver;

import java.io.File;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class TanaguruDriverFactory {
    private Map<String, String> jsScriptMap = new HashMap<>();
    private int ngAppWait = 500;
    private ProfileFactoryImpl profileFactory;
    private String geckodriverPath;

    private TanaguruDriverFactory(){}

    public void setJsScriptMap(Map<String, String> jsScriptMap) {
        this.jsScriptMap = jsScriptMap;
    }

    public void setProfileFactory(ProfileFactoryImpl profileFactory) {
        this.profileFactory = profileFactory;
    }

    public void setNgAppWait(int ngAppWait) {
        this.ngAppWait = ngAppWait;
    }

    @Autowired
    public void setGeckodriverPath(String geckodriverPath) {
        this.geckodriverPath = geckodriverPath;
    }

    public TanaguruDriver createFirefoxTanaguruWebDriver(){
        File geckodriver = new File(geckodriverPath);
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
        tngDriver.setJsScriptMap(jsScriptMap);
        tngDriver.setWaitTimeNgApp(ngAppWait);

        return tngDriver;
    }

    public static TanaguruDriverFactory getInstance(){
        return TanaguruDriverFactoryHolder.INSTANCE;
    }

    private static class TanaguruDriverFactoryHolder{
        private static final TanaguruDriverFactory INSTANCE = new TanaguruDriverFactory();
    }
}
