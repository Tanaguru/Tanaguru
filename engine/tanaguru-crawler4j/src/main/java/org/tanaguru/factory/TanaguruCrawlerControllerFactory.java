package org.tanaguru.factory;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.tanaguru.crawler.TanaguruCrawlerControllerImpl;

import java.util.Date;

public class TanaguruCrawlerControllerFactory {
    private String outputDir = System.getProperty("user.dir") + "/output/crawler4j/";

    public TanaguruCrawlerControllerImpl create(Long maxCrawlTime, int maxCrawPages) {
        TanaguruCrawlerControllerImpl controller = null;
        CrawlConfig crawlerConfig = new CrawlConfig();
        String auditDir = String.valueOf(new Date().getTime());
        crawlerConfig.setCrawlStorageFolder(outputDir + auditDir);
        crawlerConfig.setMaxPagesToFetch(maxCrawPages);

        try {
            crawlerConfig.validate();
            PageFetcher pageFetcher = new PageFetcher(crawlerConfig);
            RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
            RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
            controller = new TanaguruCrawlerControllerImpl(crawlerConfig, pageFetcher, robotstxtServer);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return controller;
    }
}
