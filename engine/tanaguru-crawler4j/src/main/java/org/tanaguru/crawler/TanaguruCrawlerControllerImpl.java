package org.tanaguru.crawler;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TanaguruCrawlerControllerImpl extends CrawlController implements Crawler{
    private static final Logger LOGGER = Logger.getLogger(TanaguruCrawlerControllerImpl.class);
    private static final int NUMBER_OF_CRAWLER = 10;
    private List<String> result = new ArrayList<>();

    private long maxCrawlTime;
    private Pattern exclusionRegex;
    private Pattern inclusionRegex;

    public void run(){
        super.start(TanaguruCrawlerImpl.class, NUMBER_OF_CRAWLER);
    }

    public TanaguruCrawlerControllerImpl(CrawlConfig crawlerConfig,
                                         PageFetcher pageFetcher,
                                         RobotstxtServer robotstxtServer,
                                         long maxCrawlTime,
                                         String exclusionRegex,
                                         String inclusionRegex) throws Exception {
        super(crawlerConfig, pageFetcher, robotstxtServer);
        this.maxCrawlTime = maxCrawlTime;
        this.exclusionRegex = Pattern.compile(exclusionRegex);
        this.inclusionRegex = Pattern.compile(inclusionRegex);
    }

    public List<String> getResult() {
        return result;
    }
    public void addResult(String url) {
        result.add(url);
    }

    public Pattern getExclusionRegex(){return exclusionRegex;}
    public Pattern getInclusionRegex(){return inclusionRegex;}
    public long getMaxCrawlTime(){return maxCrawlTime;}
}
