package org.tanaguru.scenarioloader;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.tanaguru.entity.audit.Audit;
import org.tanaguru.entity.audit.Content;
import org.tanaguru.entity.audit.PreProcessResult;
import org.tanaguru.entity.audit.SSP;
import org.tanaguru.entity.service.audit.ContentDataService;
import org.tanaguru.entity.service.audit.PreProcessResultDataService;
import org.tanaguru.entity.service.parameterization.ParameterDataService;
import org.tanaguru.entity.service.subject.WebResourceDataService;
import org.tanaguru.entity.subject.Page;
import org.tanaguru.entity.subject.Site;
import org.tanaguru.entity.subject.WebResource;
import org.tanaguru.util.factory.DateFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class AbstractScenarioLoader implements ScenarioLoader {
    private static final Logger LOGGER = Logger.getLogger(AbstractScenarioLoader.class);
    protected static final String UTF8 = "UTF-8";
    protected final List<Content> result = new ArrayList<>();

    protected String scenario;
    protected WebResource webResource;
    protected Map<String, String> jsScriptMap;
    protected int pageLoadDriverTimeout;
    protected int pageRank = 1;
    protected List<SSPInfo> sspInfoList = new LinkedList<>();

    protected ContentDataService contentDataService;
    protected ParameterDataService parameterDataService;
    protected DateFactory dateFactory;
    protected WebResourceDataService webResourceDataService;
    protected PreProcessResultDataService preProcessResultDataService;


    public AbstractScenarioLoader(
            WebResource webResource,
            String scenario) {
        this.webResource = webResource;
        this.scenario = scenario;
    }

    @Override
    public List<Content> getResult() {
        return result;
    }

    @Override
    public void setWebResource(WebResource webResource){
        this.webResource = webResource;
    }

    @Override
    public void setContentDataService(ContentDataService contentDataService){
        this.contentDataService = contentDataService;
    }

    @Override
    public void setDateFactory(DateFactory dateFactory){
        this.dateFactory = dateFactory;
    }

    @Override
    public void setWebResourceDataService(WebResourceDataService webResourceDataService){
        this.webResourceDataService = webResourceDataService;
    }

    @Override
    public void setPreProcessResultDataService(PreProcessResultDataService preProcessResultDataService){
        this.preProcessResultDataService = preProcessResultDataService;
    }

    @Override
    public void setJsScriptMap(Map<String,String> jsScriptMap){
        this.jsScriptMap = jsScriptMap;
    }

    @Override
    public void setPageLoadDriverTimeout(int pageLoadDriverTimeout){
        this.pageLoadDriverTimeout = pageLoadDriverTimeout;
    }

    @Override
    public void setParameterDataService(ParameterDataService parameterDataService){
        this.parameterDataService = parameterDataService;
    }

    /**
     *
     * @param url
     * @param sourceCode
     */
    protected void fireNewSSP(
            String url,
            String sourceCode,
            byte[] snapshotContent,
            Map<String, String> jsScriptMap,
            String charset) {

        LOGGER.debug("fire New SSP " + url);
        if (StringUtils.isEmpty(sourceCode)) {
            LOGGER.debug("Emtpy SSP " + url + " not saved");
            return;
        }

        Page page = getWebResource(url);
        SSP ssp = contentDataService.getSSP(
                dateFactory.createDate(),
                url,
                sourceCode,
                page,
                HttpStatus.SC_OK);
        ssp.setCharset(charset);
        contentDataService.saveOrUpdate(ssp);
        result.add(ssp);

//        if (snapshotContent != null) {
//            Snapshot snapshot = snapshotFactory.create(
//                    page,
//                    snapshotContent);
//            snapshotDataService.saveOrUpdate(snapshot);
//        }

        Audit audit = null;
        if (page.getAudit() != null) {
            audit = page.getAudit();
        } else if (page.getParent().getAudit() != null) {
            audit = page.getParent().getAudit();
        }
        for (Map.Entry<String, String> entry : jsScriptMap.entrySet()) {
            PreProcessResult ppr = preProcessResultDataService.getPreProcessResult(
                    entry.getKey(),
                    entry.getValue(),
                    audit,
                    page);
            preProcessResultDataService.saveOrUpdate(ppr);
        }
    }

    /**
     *
     * @param url
     * @return the page instance for a given URL
     */
    private Page getWebResource(String url) {
        Page page = null;
        if (webResource instanceof Page) {
            if (!StringUtils.equals(url, webResource.getURL())) {
                webResource.setURL(url);
            }
            page = (Page)webResource;
            page.setRank(1);
        } else if (webResource instanceof Site) {
            page = webResourceDataService.createPage(url);
            page.setRank(pageRank);
            pageRank++;
            ((Site) webResource).addChild(page);
        }
        page = (Page) webResourceDataService.saveOrUpdate(page);
        return page;
    }

    /**
     * Inner class that handle an Url and its source code
     */
    private class SSPInfo {

        private String url;
        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        private String sourceCode;
        public String getSourceCode() {
            return sourceCode;
        }

        public void setSourceCode(String sourceCode) {
            this.sourceCode = sourceCode;
        }

        public SSPInfo(String url, String sourceCode) {
            this.url = url;
            this.sourceCode = sourceCode;
        }
    }
}
