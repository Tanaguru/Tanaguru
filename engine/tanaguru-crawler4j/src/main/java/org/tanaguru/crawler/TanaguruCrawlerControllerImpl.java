package org.tanaguru.crawler;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.apache.log4j.Logger;

import java.util.*;

public class TanaguruCrawlerControllerImpl extends CrawlController{
    private static final Logger LOGGER = Logger.getLogger(TanaguruCrawlerControllerImpl.class);
    private static final int NUMBER_OF_CRAWLER = 10;

    protected List<String> result = new ArrayList<>();

    protected long maxCrawlTime = 100000L;
    protected int crawlingPagesToFetch = 10000;

    public void run(){
        super.start(TanaguruCrawlerImpl.class, NUMBER_OF_CRAWLER);
    }

    public TanaguruCrawlerControllerImpl(CrawlConfig crawlerConfig, PageFetcher pageFetcher, RobotstxtServer robotstxtServer) throws Exception {
        super(crawlerConfig, pageFetcher, robotstxtServer);
    }

    public List<String> getResult() {
        return result;
    }
}
