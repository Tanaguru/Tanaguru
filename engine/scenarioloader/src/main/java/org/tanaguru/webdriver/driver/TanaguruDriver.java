package org.tanaguru.webdriver.driver;

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
import java.util.*;

public class TanaguruDriver implements WebDriver, JavascriptExecutor {
    private static final Logger LOGGER = Logger.getLogger(TanaguruDriver.class);

    List<NewPageListener> newPageListenerList;
    private Map<String, String> jsScriptMap;
    private int waitTimeNgApp = 500;
    private boolean preventDefaultPageFiringEvent = false;

    private RemoteWebDriver driver;

    private String beforeclickUrl;
    private ArrayList<String> visitedUrl;

    public TanaguruDriver(FirefoxOptions ffOptions) {
        this.driver = new FirefoxDriver(ffOptions);
        this.newPageListenerList = new ArrayList<>();

        visitedUrl = new ArrayList<>();
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
            if(!preventDefaultPageFiringEvent){
                fireNewPage(url, true, null);
            }
        } catch (JavaScriptException e) {
            LOGGER.error("Javascript exception on page : " + url + "\n"
                    + e.getMessage());
        } catch (TimeoutException e){
            LOGGER.error("Timeout exception opening page : " + url + "\n"
                    + e.getMessage());
            if(!preventDefaultPageFiringEvent){
                fireNewPage(url, true, null);
            }
        } catch (WebDriverException e) {
            LOGGER.error("Webdriver exception opening page : " + url + "\n"
                    + e.getMessage());
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
            LOGGER.error(e.getMessage());
        }
        return driver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        try {
            Thread.sleep(this.waitTimeNgApp);
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
        }
        return driver.findElement(by);
    }

    public void fireNewPage(String url, boolean preventUrlMultipleAudit, String label) {
        waitForJStoLoad();

        if(!preventUrlMultipleAudit || !visitedUrl.contains(url)){
            this.beforeclickUrl = url;

            visitedUrl.add(0, url);
            LOGGER.info("Successfully loaded page, firing new page : " + url);
            Map<String, String> jsScriptResult = executeScriptMap();
            String source = getPageSource();
            for (NewPageListener newPageListener : newPageListenerList) {
                newPageListener.fireNewPage(url, source, null, jsScriptResult, label);
            }
        }else{
            LOGGER.info("Successfully loaded page, already visited : " + url);
        }
    }

    public String getPageSource() {
        Object doctype = null;

        LOGGER.debug("Getting page source...");
        String pageSource = driver.getPageSource();
        LOGGER.debug("Page source loaded successfully");

        try {
            LOGGER.debug("Computing page doctype...");
            String getDoctypeStr = IOUtils.toString(TanaguruDriver.class.getClassLoader()
                    .getResourceAsStream("getDoctype.js"));
            String jsCommand = getDoctypeStr;
            doctype = executeScript(jsCommand);
            LOGGER.info("Page doctype computed successfully");
        } catch (IOException e) {
            LOGGER.error("Get doctype has failed\n" +
                    e.getMessage());
        } catch (JavaScriptException e){
            LOGGER.error("Get doctype has failed\n" +
                    e.getMessage());
        }
        return pageSource + (doctype == null ? "" : doctype.toString());
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
                Object scriptResult = null;
                try {
                    LOGGER.debug("Executing " + entry.getKey());
                    scriptResult = executeScript(entry.getValue());
                    LOGGER.info(entry.getKey() + " executed");
                } catch (WebDriverException wde) {
                    LOGGER.error("Webdriver exception " + entry.getKey() + " has failed" + "\n"
                            + wde.getMessage());
                } catch (JavaScriptException e){
                    LOGGER.error("Javascript exception " + entry.getKey() + " has failed" + "\n"
                            + e.getMessage());
                }finally {
                    jsScriptResult.put(entry.getKey(), scriptResult == null ? "" : scriptResult.toString());
                }
            }
        }
        return jsScriptResult;
    }

    public void setWaitTimeNgApp(int waitTimeNgApp) {
        this.waitTimeNgApp = waitTimeNgApp;
    }

    public boolean isPreventDefaultPageFiringEvent() {
        return preventDefaultPageFiringEvent;
    }

    public void setPreventDefaultPageFiringEvent(boolean preventDefaultPageFiringEvent) {
        this.preventDefaultPageFiringEvent = preventDefaultPageFiringEvent;
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

    public void onSeleneseClick() {
        String url = getCurrentUrl();
        //Ignore anchors
        int ignoreIndex = url.indexOf("#");
        url = ignoreIndex != -1 ? url.substring(0, ignoreIndex) : url;
        if(!preventDefaultPageFiringEvent){
            fireNewPage(url, true, null);
        }
    }
}
