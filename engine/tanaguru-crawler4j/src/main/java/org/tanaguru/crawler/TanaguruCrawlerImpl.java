package org.tanaguru.crawler;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;

import java.util.Date;
import java.util.regex.Pattern;


public class TanaguruCrawlerImpl extends WebCrawler {
    private final Pattern FILTERS = Pattern.compile(".*(\\.(|mp3|mp4|zip|gz))$");
    private long startedTime;

    @Override
    public void onStart(){
        startedTime = new Date().getTime();
    }


    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        return !FILTERS.matcher(href).matches()
                && url.getDomain().equals(referringPage.getWebURL().getDomain());
    }

    @Override
    public void visit(Page page) {
        onBeforeVisit(page);
        String url = page.getWebURL().getURL();
        ((TanaguruCrawlerControllerImpl)myController).result.add(url);
    }

    public void onBeforeVisit(Page page){
        if(new Date().getTime() - startedTime >= ((TanaguruCrawlerControllerImpl)myController).maxCrawlTime){
            this.getThread().interrupt();
        }
    }

}

