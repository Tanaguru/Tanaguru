package org.tanaguru.tools;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.tanaguru.entity.audit.Content;
import org.tanaguru.entity.audit.SSP;

import java.net.URI;
import java.net.URISyntaxException;

public class CrawlerHelper {

    private static final Logger LOGGER = Logger.getLogger(CrawlerHelper.class);

    private static final String OPEN_HTML_TAG = "<html";
    private static final String END_HTML_TAG = "</html>";
    private static final int RETRIEVE_WINDOW = 1000;
    private static final int REL_CANONICAL_PAGE_FAKE_HTTP_STATUS = 900;
    private static final String REL_CANONICAL_CSS_LIKE_QUERY =
            "head link[rel=canonical][href]";
    private static final String BASE_CSS_LIKE_QUERY = "head base[href]";

    public static boolean isRelCanonicalPage(Content content) {
        // @TODO make this implementation cleaner
        if (! (content instanceof SSP)) {
            return false;
        }
        if (StringUtils.isBlank(((SSP)content).getSource())) {
            return false;
        }
        Elements relCanonical = Jsoup.parse(((SSP)content).getSource()).select(REL_CANONICAL_CSS_LIKE_QUERY);

        if (relCanonical.isEmpty() || relCanonical.size() > 1) {
            return false;
        }
        // At this step, we are sure that the rel canonical is defined and
        // is unique
        String href = relCanonical.first().attr("href");
        if (href.equals(".")) {
            return false;
        }
        if (href.endsWith("/")) {
            href = href.substring(0, href.length() - 1);
        }
        if (href.startsWith("/")) {
            Elements base = Jsoup.parse(((SSP) content).getSource()).select(BASE_CSS_LIKE_QUERY);
            if (!base.isEmpty()) {
                if (StringUtils.endsWith(base.first().attr("href"), "/")) {
                    href = StringUtils.join(base.first().attr("href"), href.substring(1));
                } else {
                    href = StringUtils.join(base.first().attr("href") + href);
                }
                LOGGER.debug("(BASE CASE) The concat href " + href);
            } else {
                URI contractUri;
                try {
                    contractUri = new URI(content.getURI());
                    href = StringUtils.join(contractUri.getScheme(), "://", contractUri.getHost(), href);
                    LOGGER.debug("(NORMAL CASE) The concat href " + href);
                } catch (URISyntaxException ex) {
                    LOGGER.error("Error when creating uri object with url " + content.getURI());
                }
            }
        }
        if (href.contains("//")) {
            href = href.substring(href.indexOf("//") + 2);
        }
        String currentUrl = content.getURI();
        if (currentUrl.endsWith("/")) {
            currentUrl = currentUrl.substring(0, currentUrl.length() -1 );
        }
        if (currentUrl.contains("//")) {
            currentUrl = currentUrl.substring(currentUrl.indexOf("//") +2 );
        }
        if (currentUrl.equals(href)) {
            LOGGER.info("rel canonical present but points to itself " + content.getURI());
            return false;
        }
        return true;
    }

    /**
     * This methods enables to get the type of resource from its uri.
     * In case of unreachable resource (404/403 errors), the return content is
     * a html page. So we can't use the content type of the returned page to
     * determine the type of the content we try to reach. In this case, we use
     * the uri extension, based-on regular expressions.
     * @param uri
     * @return
     */
    public static String getContentTypeFromUnreacheableResource(String uri) {
        return "HTML";
    }
}
