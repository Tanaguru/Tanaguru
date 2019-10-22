package org.tanaguru.factory;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.tanaguru.crawler.Crawler;
import org.tanaguru.crawler.CrawlerFactory;
import org.tanaguru.crawler.TanaguruCrawlerControllerImpl;
import org.tanaguru.entity.audit.Audit;

import java.io.File;
import java.util.Date;

public class TanaguruCrawlerControllerFactory implements CrawlerFactory {
    private String outputDir;
    private int maxDepth;
    private int maxDocument;
    private Long maxDuration;
    private String exclusionRegex;
    private String inclusionRegex;

    public void setOutputDir(String outputDir){
        this.outputDir = outputDir;
    }

    public void setMaxDepth(int maxDepth){
        this.maxDepth = maxDepth;
    }

    public void setMaxDocument(int maxDocument){
        this.maxDocument = maxDocument;
    }

    public void setMaxDuration(Long maxDuration){
        this.maxDuration = maxDuration;
    }

    public void setExclusionRegex(String exclusionRegex){
        this.exclusionRegex = exclusionRegex;
    }

    public void setInclusionRegex(String inclusionRegex){
        this.inclusionRegex = inclusionRegex;
    }

    public Crawler create(Audit audit) {
        TanaguruCrawlerControllerImpl controller = null;
        CrawlConfig crawlerConfig = new CrawlConfig();
        String auditDir = String.valueOf(new Date().getTime());

        File outDir = new File(outputDir);
        if(!outDir.exists()){
            outDir.mkdirs();
        }

        if(!outDir.canWrite()){
            outDir.setWritable(true);
        }

        crawlerConfig.setCrawlStorageFolder(outputDir + auditDir);
        crawlerConfig.setMaxPagesToFetch(maxDocument);
        crawlerConfig.setMaxDepthOfCrawling(maxDepth);
        crawlerConfig.setIncludeHttpsPages(true);

        try {
            crawlerConfig.validate();
            PageFetcher pageFetcher = new PageFetcher(crawlerConfig);
            RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
            RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
            controller = new TanaguruCrawlerControllerImpl(
                    crawlerConfig,
                    pageFetcher,
                    robotstxtServer,
                    maxDuration.longValue(),
                    exclusionRegex,
                    inclusionRegex);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return controller;
    }


}
