package org.tanaguru.factory;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.tanaguru.crawler.Crawler;
import org.tanaguru.crawler.CrawlerFactory;
import org.tanaguru.crawler.TanaguruCrawlerControllerImpl;
import org.tanaguru.entity.audit.Audit;
import java.util.Date;

public class TanaguruCrawlerControllerFactory implements CrawlerFactory {
    private String outputDir = System.getProperty("user.dir") + "/output/crawler4j/";
    private int maxDepth = 20;
    private int maxDocument = 100000;
    private long maxDuration = 86400L;

    public void setOutputDir(String outputDir){
        this.outputDir = outputDir;
    }

    public void setMaxDepth(int maxDepth){
        this.maxDepth = maxDepth;
    }

    public void setMaxDocument(int maxDocument){
        this.maxDocument = maxDocument;
    }

    public void setMaxDuration(long maxDuration){
        this.maxDuration = maxDuration;
    }

    public Crawler create(Audit audit) {
        TanaguruCrawlerControllerImpl controller = null;
        CrawlConfig crawlerConfig = new CrawlConfig();
        String auditDir = String.valueOf(new Date().getTime());
        crawlerConfig.setCrawlStorageFolder(outputDir + auditDir);
        crawlerConfig.setMaxPagesToFetch(maxDocument);
        crawlerConfig.setMaxDepthOfCrawling(maxDepth);

        try {
            crawlerConfig.validate();
            PageFetcher pageFetcher = new PageFetcher(crawlerConfig);
            RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
            RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
            controller = new TanaguruCrawlerControllerImpl(crawlerConfig, pageFetcher, robotstxtServer, maxDuration);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return controller;
    }


}
