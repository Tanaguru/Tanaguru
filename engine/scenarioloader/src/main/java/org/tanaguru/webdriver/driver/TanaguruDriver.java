package org.tanaguru.webdriver.driver;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.url.WebURL;
import net.sourceforge.htmlunit.corejs.javascript.JavaScriptException;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tanaguru.scenarioloader.NewPageListener;

import java.io.IOException;
import java.net.ConnectException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class TanaguruDriver implements WebDriver, JavascriptExecutor {
    private static final Logger LOGGER = Logger.getLogger(TanaguruDriver.class);

    List<NewPageListener> newPageListenerList;
    private Map<String, String> jsScriptMap;
    private int waitTimeNgApp = 500;
    private RemoteWebDriver driver;

    public TanaguruDriver(FirefoxOptions ffOptions) {
        driver = new FirefoxDriver(ffOptions);
        this.newPageListenerList = new ArrayList<>();
    }

    public void setJsScriptMap(Map<String, String> jsScriptMap) {
        this.jsScriptMap = jsScriptMap;
    }

    public void addNewPageListener(NewPageListener newPageListener) {
        this.newPageListenerList.add(newPageListener);
    }

    @Override
    public void get(String url) {
        try {
            driver.get(url);
            waitForJStoLoad();
            LOGGER.debug("Successfully loaded page : " + url);

        } catch (JavaScriptException e) {
            LOGGER.warn("Javascript error on page : " + url);
            LOGGER.warn(e.getMessage());
        } finally {
            fireNewPage(url);
        }
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        try {
            Thread.sleep(this.waitTimeNgApp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        try {
            Thread.sleep(this.waitTimeNgApp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElement(by);
    }

    public void fireNewPage(String url) {
        Map<String, String> jsScriptResult = executeScriptMap();
        String source = getPageSource();
        for (NewPageListener newPageListener : newPageListenerList) {
            newPageListener.fireNewPage(url, source, null, jsScriptResult);
        }
    }

    public String getPageSource() {
        Object doctype = null;
        try {
            String getDoctypeStr = IOUtils.toString(TanaguruDriver.class.getClassLoader()
                    .getResourceAsStream("getDoctype.js"));
            String jsCommand = getDoctypeStr + "return getDoctype();";
            doctype = executeScript(jsCommand);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JavaScriptException e){
            LOGGER.warn("Get doctype has failed");
            LOGGER.warn(e.getMessage());
        }
        return doctype == null ? "" : doctype.toString() + driver.getPageSource();
    }

    @Override
    public void close() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }

    @Override
    public void quit() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public Options manage() {
        return driver.manage();
    }

    private Map<String, String> executeScriptMap() {
        Map<String, String> jsScriptResult = new HashMap<>();
        if (jsScriptMap != null) {

            for (Map.Entry<String, String> entry : jsScriptMap.entrySet()) {
                try {
                    Object scriptResult = executeScript(entry.getValue());
                    jsScriptResult.put(entry.getKey(), scriptResult == null ? "" : scriptResult.toString());
                } catch (WebDriverException wde) {
                    LOGGER.warn("Script " + entry.getKey() + " has failed");
                    LOGGER.warn(wde.getMessage());
                } catch (JavaScriptException e){
                    LOGGER.warn("Script " + entry.getKey() + " has failed");
                    LOGGER.warn(e.getMessage());
                }
            }
            LOGGER.debug("Js executed");
        }
        return jsScriptResult;
    }

    public void setWaitTimeNgApp(int waitTimeNgApp) {
        this.waitTimeNgApp = waitTimeNgApp;
    }

    public boolean waitForJStoLoad() {

        WebDriverWait wait = new WebDriverWait(driver, 30);


        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

    @Override
    public Object executeScript(String s, Object... objects) {
            return driver.executeScript(s, objects);
    }

    @Override
    public Object executeAsyncScript(String s, Object... objects) {
        return driver.executeAsyncScript(s, objects);
    }
}
