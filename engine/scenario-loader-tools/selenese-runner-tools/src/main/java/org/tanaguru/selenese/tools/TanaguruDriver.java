package org.tanaguru.selenese.tools;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.tanaguru.scenarioloader.NewPageListener;
import org.tanaguru.selenese.SeleneseLoaderImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TanaguruDriver extends FirefoxDriver {
    private static final Logger LOGGER = Logger.getLogger(SeleneseLoaderImpl.class);

    List<NewPageListener> newPageListenerList;
    private Map<String, String> jsScriptMap;

    public TanaguruDriver(FirefoxOptions ffOptions){
        super(ffOptions);
        this.newPageListenerList = new ArrayList<>();
    }

    public void setJsScriptMap(Map<String, String> jsScriptMap){
        this.jsScriptMap = jsScriptMap;
    }

    public void addNewPageListener(NewPageListener newPageListener){
        this.newPageListenerList.add(newPageListener);
    }

    @Override
    public void get(String url) {
        try {
            super.get(url);
        }catch (TimeoutException e){
            LOGGER.debug("Timeout, DOM can be incomplete.");
        }finally {
            fireNewPage();
        }
    }

    private void fireNewPage(){
        for(NewPageListener newPageListener : newPageListenerList){
            newPageListener.fireNewPage(getCurrentUrl(), getPageSource(), null, executeScripts());
        }
    }

    public String getPageSource(){
        String doctype = "";
        try {
            String getDoctypeStr = IOUtils.toString(SeleneseLoaderImpl.class.getClassLoader()
                    .getResourceAsStream("getDoctype.js"));
            JavascriptExecutor js = (JavascriptExecutor) this;
            String jsCommand = getDoctypeStr + "return getDoctype();";
            doctype = (String) js.executeScript(jsCommand);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doctype + super.getPageSource();
    }

    private Map<String, String> executeScripts(){
        Map<String, String> jsScriptResult = new HashMap<>();
        if(jsScriptMap != null){
            for (Map.Entry<String, String> entry : jsScriptMap.entrySet()) {
                try {
                    jsScriptResult.put(entry.getKey(), executeScript(entry.getValue()).toString());
                } catch (WebDriverException wde) {
                    LOGGER.warn("Script " + entry.getKey() + " has failed");
                    LOGGER.warn(wde.getMessage());
                }
            }
            LOGGER.debug("Js executed");
        }
        return jsScriptResult;
    }
}
