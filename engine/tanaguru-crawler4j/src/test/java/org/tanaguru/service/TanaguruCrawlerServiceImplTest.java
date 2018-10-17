package org.tanaguru.service;

import junit.framework.TestCase;
import org.tanaguru.crawler.CrawlerFactory;
import org.tanaguru.entity.audit.Audit;
import org.tanaguru.entity.audit.AuditImpl;
import org.tanaguru.entity.parameterization.*;
import org.tanaguru.entity.service.parameterization.ParameterDataService;
import org.tanaguru.factory.TanaguruCrawlerControllerFactory;
import org.tanaguru.service.mock.MockParameterDataService;

import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

public class TanaguruCrawlerServiceImplTest extends TestCase {
    private static final String FULL_SITE_CRAWL_URL_KEY = "full-site-crawl-url";
    private static final String ROBOTS_RESTRICTED_CRAWL_URL_KEY =
            "robots-restricted-crawl-url";
    private static final String SITES_URL_BUNDLE_NAME = "sites-url";

    private static final String PAGE_NAME_LEVEL1 = "page-1.html";
    private static final String PAGE_NAME_LEVEL2 = "page-2.html";
    private static final String FORBIDDEN_PAGE_NAME = "page-access-forbidden-for-robots.html";
    private final ResourceBundle bundle =
            ResourceBundle.getBundle(SITES_URL_BUNDLE_NAME);
    private CrawlerService crawlerService;
    private CrawlerFactory crawlerFactory;
    private ParameterDataService mockParameterDataService;

    public TanaguruCrawlerServiceImplTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mockParameterDataService = new MockParameterDataService();

        crawlerFactory = new TanaguruCrawlerControllerFactory();

        crawlerService = new TanaguruCrawlerServiceImpl();
        crawlerService.setCrawlerFactory(crawlerFactory);
        crawlerService.setParameterDataService(mockParameterDataService);
        crawlerFactory.setOutputDir("/tmp/");
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     *
     * @param siteUrl
     * @param depth
     * @param exclusionRegex
     * @param inlusionRegex
     * @param maxDuration
     * @param maxDocuments
     * @param proxyHost
     * @param proxyPort
     * @return
     */
    private List<String> initialiseAndLaunchCrawl(
            String siteUrl,
            int depth,
            String exclusionRegex,
            String inclusionRegex,
            long maxDuration,
            int maxDocuments) {
        Audit audit = new AuditImpl();

        audit.setParameterSet(setCrawlParameters(String.valueOf(depth),exclusionRegex, inclusionRegex, String.valueOf(maxDuration), String.valueOf(maxDocuments)));
        return  crawlerService.getUrlListByCrawlingFromUrl(audit, siteUrl);
    }

    public void testCrawl_SiteWithDepthLevel0Option() {
        System.out.println("crawl_full_site_With_Depth_Level0_Option");
        String siteUrl = bundle.getString(FULL_SITE_CRAWL_URL_KEY);
        List<String> contentList = initialiseAndLaunchCrawl(siteUrl, 0, "", "", 86400L, 10000);
        assertEquals(1, contentList.size());
        assertTrue(contentList.contains(siteUrl));
    }

    public void testCrawl_SiteWithDepthLevel1Option() {
        System.out.println("crawl_full_site_With_Depth_Level1_Option");
        String siteUrl = bundle.getString(FULL_SITE_CRAWL_URL_KEY);
        List<String> contentList = initialiseAndLaunchCrawl(siteUrl, 1, "", "", 86400L, 10000);
        assertEquals(3, contentList.size());
        assertTrue(contentList.contains(siteUrl));
        assertTrue(contentList.contains(siteUrl + PAGE_NAME_LEVEL1));
        assertTrue(contentList.contains(siteUrl + FORBIDDEN_PAGE_NAME));
    }

    public void testCrawl_SiteWithRegexpExclusionOption() {
        System.out.println("crawl_full_site_With_Regexp_Exclusion_Option");
        String siteUrl = bundle.getString(FULL_SITE_CRAWL_URL_KEY);
        List<String> contentList = initialiseAndLaunchCrawl(siteUrl, 4, ".html", "", 86400L, 10000);
        assertEquals(1, contentList.size());
        assertTrue(contentList.contains(siteUrl));
    }

    public void testCrawl_SiteWithRegexpInclusionOption() {
        System.out.println("crawl_full_site_With_Regexp_Inclusion_Option");
        String siteUrl = bundle.getString(FULL_SITE_CRAWL_URL_KEY)+"page-1.html";
        List<String> contentList = initialiseAndLaunchCrawl(siteUrl, 2, "", "page-", 86400L, 10000);
        assertEquals(3, contentList.size());
        assertTrue(contentList.contains(siteUrl));
        assertTrue(contentList.contains(bundle.getString(FULL_SITE_CRAWL_URL_KEY) + PAGE_NAME_LEVEL2));
        assertTrue(contentList.contains(bundle.getString(FULL_SITE_CRAWL_URL_KEY) + FORBIDDEN_PAGE_NAME));
    }

    public void testCrawl_SiteWithRegexpInclusionOption2() {
        System.out.println("crawl_full_site_With_Regexp_Inclusion_Option 2");
        String siteUrl = bundle.getString(FULL_SITE_CRAWL_URL_KEY)+"page-1.html";
        List<String> contentList = initialiseAndLaunchCrawl(siteUrl, 2, "", "page-\\d", 86400L, 10);
        assertEquals(2, contentList.size());
        assertTrue(contentList.contains(siteUrl));
        assertTrue(contentList.contains(bundle.getString(FULL_SITE_CRAWL_URL_KEY) + PAGE_NAME_LEVEL2));
    }

    public void testCrawl_SiteWithRegexpInclusionOption3() {
        System.out.println("crawl_full_site_With_Regexp_Inclusion_Option 3");
        String siteUrl = bundle.getString(FULL_SITE_CRAWL_URL_KEY);
        List<String> contentList = initialiseAndLaunchCrawl(siteUrl, 2, "", "page-\\d", 86400L, 10);
        assertEquals(3, contentList.size());
        assertTrue(contentList.contains(siteUrl));
        assertTrue(contentList.contains(siteUrl + PAGE_NAME_LEVEL1));
        assertTrue(contentList.contains(siteUrl + PAGE_NAME_LEVEL2));
    }

    public void testCrawl_SiteWithRegexpExclusionOption2() {
        System.out.println("crawl_full_site_With_Regexp_Exclusion_Option2");
        String siteUrl = bundle.getString(FULL_SITE_CRAWL_URL_KEY);
        List<String> contentList = initialiseAndLaunchCrawl(siteUrl, 4, "robot", "", 86400L, 10000);
        assertEquals(3, contentList.size());
        assertTrue(contentList.contains(siteUrl));
        assertTrue(contentList.contains(siteUrl + PAGE_NAME_LEVEL1));
        assertTrue(contentList.contains(siteUrl + PAGE_NAME_LEVEL2));
    }

    public void testCrawl_SiteWithRegexpExclusionOption3() {
        System.out.println("crawl_full_site_With_Regexp_Exclusion_Option3");
        String siteUrl = bundle.getString(FULL_SITE_CRAWL_URL_KEY);
        List<String> contentList = initialiseAndLaunchCrawl(siteUrl, 4, "robot;page-2", "", 86400L, 10000);
        assertEquals(2, contentList.size());
        assertTrue(contentList.contains(siteUrl));
        assertTrue(contentList.contains(siteUrl + PAGE_NAME_LEVEL1));
    }

    /**
     * * Test the crawl of a site without robots.txt file
     */
    public void testCrawl_Site() {
        System.out.println("crawl_full_site");
        String siteUrl = bundle.getString(FULL_SITE_CRAWL_URL_KEY);
        List<String> contentList = initialiseAndLaunchCrawl(siteUrl, 3, "", "", 86400L, 10000);
        assertEquals(4, contentList.size());
        assertTrue(contentList.contains(siteUrl));
        assertTrue(contentList.contains(siteUrl + PAGE_NAME_LEVEL1));
        assertTrue(contentList.contains(siteUrl + PAGE_NAME_LEVEL2));
        assertTrue(contentList.contains(siteUrl + FORBIDDEN_PAGE_NAME));
    }

    /**
     * Test the crawl of a page
     */
    public void testCrawl_Page() {
        System.out.println("crawl_page");
        String siteUrl = bundle.getString(FULL_SITE_CRAWL_URL_KEY);
        Audit audit = new AuditImpl();
        audit.setParameterSet(setCrawlParameters("3", "", "", "", ""));
        List<String> contentList = crawlerService.getUrlListByCrawlingFromUrl(audit, siteUrl);
        assertEquals(1, contentList.size());
        assertTrue(contentList.contains(siteUrl));
        assertFalse(contentList.contains(siteUrl + PAGE_NAME_LEVEL1));
        assertFalse(contentList.contains(siteUrl + PAGE_NAME_LEVEL2));
        assertFalse(contentList.contains(siteUrl + FORBIDDEN_PAGE_NAME));
    }

    /**
     * Test the crawl of a site with robots.txt file
     */
    public void testCrawl_Site_With_Robots() {
        System.out.println("crawl_site_with_robots");
        String siteUrl = bundle.getString(ROBOTS_RESTRICTED_CRAWL_URL_KEY);
        List<String> contentList = initialiseAndLaunchCrawl(siteUrl, 3, "", "", 86400L, 10000);
        assertEquals(3, contentList.size());
        assertTrue(contentList.contains(siteUrl));
        assertTrue(contentList.contains(siteUrl + PAGE_NAME_LEVEL1));
        assertTrue(contentList.contains(siteUrl + PAGE_NAME_LEVEL2));
        assertFalse(contentList.contains(siteUrl + FORBIDDEN_PAGE_NAME));
    }

    /**
     *
     * @param depth
     * @param exclusionRegexp
     * @param inclusionRegexp
     * @param maxDuration
     * @param maxDocuments
     * @param proxyHost
     * @param proxyPort
     * @return The set of Parameters regarding options set as argument
     */
    private Set<Parameter> setCrawlParameters(
            String depth,
            String exclusionRegexp,
            String inclusionRegexp,
            String maxDuration,
            String maxDocuments) {
        Set<Parameter> crawlParameters = new HashSet<>();
        ParameterFamily pf = new ParameterFamilyImpl();
        pf.setParameterFamilyCode("CRAWLER");

        //DEPTH
        ParameterElement ped = new ParameterElementImpl();
        ped.setParameterElementCode("DEPTH");
        Parameter pedValue = new ParameterImpl();
        pedValue.setParameterElement(ped);
        pedValue.setValue(depth);
        crawlParameters.add(pedValue);

        //EXCLUSION_REGEX
        ParameterElement peer = new ParameterElementImpl();
        peer.setParameterElementCode("EXCLUSION_REGEX");
        Parameter peerValue = new ParameterImpl();
        peerValue.setParameterElement(peer);
        peerValue.setValue(exclusionRegexp);
        crawlParameters.add(peerValue);

        //INCLUSION_REGEX
        ParameterElement peir = new ParameterElementImpl();
        peir.setParameterElementCode("INCLUSION_REGEX");
        Parameter peirValue = new ParameterImpl();
        peirValue.setParameterElement(peir);
        peirValue.setValue(inclusionRegexp);
        crawlParameters.add(peirValue);

        //MAX_DURATION
        ParameterElement pemdu = new ParameterElementImpl();
        pemdu.setParameterElementCode("MAX_DURATION");
        Parameter pemduValue = new ParameterImpl();
        pemduValue.setParameterElement(pemdu);
        pemduValue.setValue(maxDuration);
        crawlParameters.add(pemduValue);

        //MAX_DOCUMENTS
        ParameterElement pemdo = new ParameterElementImpl();
        pemdo.setParameterElementCode("MAX_DOCUMENTS");
        Parameter pemdoValue = new ParameterImpl();
        pemdoValue.setParameterElement(pemdo);
        pemdoValue.setValue(maxDocuments);
        crawlParameters.add(pemdoValue);

        System.setProperty("proxyHost", "");
        System.setProperty("proxyPort", "");
        System.setProperty("proxyUser", "");
        System.setProperty("proxyPassword", "");

        return crawlParameters;
    }
}