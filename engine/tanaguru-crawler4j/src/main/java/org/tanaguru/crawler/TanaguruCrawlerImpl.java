package org.tanaguru.crawler;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;
import org.apache.log4j.Logger;
import java.util.Date;
import java.util.regex.Pattern;


public class TanaguruCrawlerImpl extends WebCrawler {
    private final Pattern BLACKLIST = Pattern.compile(".*(\\.(mp3|mp4|zip|gz|txt|css|js|xml|jpg|jpeg|png|gif))$");
    private static final int HTTP_SUCCESS_RETURN_CODE = 200;

    private final Logger LOGGER = Logger.getLogger(TanaguruCrawlerImpl.class);
    private long startedTime;

    @Override
    public void onStart(){
        startedTime = new Date().getTime();
    }


    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        TanaguruCrawlerControllerImpl controller = (TanaguruCrawlerControllerImpl)myController;
        boolean toVisit = ! BLACKLIST.matcher(href).matches()
                && (
                        controller.getExclusionRegex().pattern().isEmpty()
                        || !controller.getExclusionRegex().matcher(url.getURL()).matches()
                    )
                && (
                        controller.getInclusionRegex().pattern().isEmpty()
                        || controller.getInclusionRegex().matcher(url.getURL()).matches()
                )
                && url.getDomain().equals(referringPage.getWebURL().getDomain());

        if(!toVisit){
            LOGGER.debug("Not visiting : " + url);
        }

        return toVisit;
    }

    @Override
    public void visit(Page page) {
        LOGGER.info("Visiting page : " + page.getWebURL());

        if(page.getStatusCode() != HTTP_SUCCESS_RETURN_CODE
                || ! page.getContentType().contains("text/html")){
            LOGGER.error("Page content does not match html");
            return;
        }
        String url = page.getWebURL().getURL();
        ((TanaguruCrawlerControllerImpl)myController).addResult(url);

        onAfterVisit(page);
    }


    private void onAfterVisit(Page page){
        if(new Date().getTime() - startedTime >= ((TanaguruCrawlerControllerImpl)myController).getMaxCrawlTime()){
            LOGGER.info("[CRAWLER - " + this.getMyId() + "] Crawler time over, stop crawling...");
            myController.shutdown();
        }
    }

}

