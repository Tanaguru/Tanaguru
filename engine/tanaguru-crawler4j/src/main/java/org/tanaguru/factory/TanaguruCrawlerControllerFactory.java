package org.tanaguru.factory;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.tanaguru.crawler.TanaguruCrawlerControllerImpl;
import org.tanaguru.entity.audit.Audit;
import org.tanaguru.entity.service.parameterization.ParameterDataService;
import java.util.Date;

public class TanaguruCrawlerControllerFactory {
    private String outputDir = System.getProperty("user.dir") + "/output/crawler4j/";

    private ParameterDataService parameterDataService;
    public void setParameterDataService(ParameterDataService parameterDataService) {
        this.parameterDataService = parameterDataService;
    }

    public TanaguruCrawlerControllerFactory(ParameterDataService parameterDataService){
        this.parameterDataService = parameterDataService;
    }

    public TanaguruCrawlerControllerImpl create(Audit audit) {
        TanaguruCrawlerControllerImpl controller = null;
        CrawlConfig crawlerConfig = new CrawlConfig();
        String auditDir = String.valueOf(new Date().getTime());
        crawlerConfig.setCrawlStorageFolder(outputDir + auditDir);
        crawlerConfig.setMaxPagesToFetch(getMaxNumberOfCrawlPageFromAuditParameter(audit));
        crawlerConfig.setMaxDepthOfCrawling(getMaxDepthOfCrawlPageFromAuditParameter(audit));

        try {
            crawlerConfig.validate();
            PageFetcher pageFetcher = new PageFetcher(crawlerConfig);
            RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
            RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
            controller = new TanaguruCrawlerControllerImpl(crawlerConfig, pageFetcher, robotstxtServer, getTimeOfCrawlPageFromAuditParameter(audit));


        } catch (Exception e) {
            e.printStackTrace();
        }

        return controller;
    }

    private int getMaxNumberOfCrawlPageFromAuditParameter(Audit audit) {
        try {
            if (parameterDataService.getParameter(audit, "MAX_DOCUMENTS") != null) {
                return Integer.valueOf(parameterDataService.getParameter(audit, "MAX_DOCUMENTS").getValue());
            }
        } catch (NumberFormatException nfe) {
            return -1;
        }
        return -1;
    }

    private int getMaxDepthOfCrawlPageFromAuditParameter(Audit audit) {
        try {
            if (parameterDataService.getParameter(audit, "DEPTH") != null) {
                return Integer.valueOf(parameterDataService.getParameter(audit, "DEPTH").getValue());
            }
        } catch (NumberFormatException nfe) {
            return -1;
        }
        return -1;
    }

    private long getTimeOfCrawlPageFromAuditParameter(Audit audit) {
        try {
            if (parameterDataService.getParameter(audit, "MAX_DURATION") != null) {
                return 1000L * Long.valueOf(parameterDataService.getParameter(audit, "MAX_DURATION").getValue());
            }
        } catch (NumberFormatException nfe) {
            return -1;
        }
        return -1;
    }
}
