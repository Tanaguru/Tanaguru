/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2015  Tanaguru.org
 *
 * This file is part of Tanaguru.
 *
 * Tanaguru is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact us by mail: tanaguru AT tanaguru DOT org
 */
package org.tanaguru.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.tanaguru.crawler.Crawler;
import org.tanaguru.crawler.CrawlerFactory;
import org.tanaguru.crawler.TanaguruCrawlerControllerImpl;
import org.tanaguru.entity.audit.Audit;
import org.tanaguru.entity.service.parameterization.ParameterDataService;
import org.tanaguru.factory.TanaguruCrawlerControllerFactory;


import javax.xml.bind.annotation.XmlTransient;
import java.util.*;

/**
 *
 * @author rcharre
 */
@XmlTransient
public class TanaguruCrawlerServiceImpl{
    private static final Logger LOGGER = Logger.getLogger(TanaguruCrawlerServiceImpl.class);

    @Autowired
    private ParameterDataService parameterDataService;
    public void setParameterDataService(ParameterDataService parameterDataService) {
        this.parameterDataService = parameterDataService;
    }

    public List<String> getUrlListByCrawlingFromUrlList(Audit audit, List<String> urlList){
        TanaguruCrawlerControllerFactory crawlerFactory = new TanaguruCrawlerControllerFactory();
        crawlerFactory.setMaxDepth(getMaxDepthOfCrawlPageFromAuditParameter(audit));
        crawlerFactory.setMaxDocument(getMaxNumberOfCrawlPageFromAuditParameter(audit));
        crawlerFactory.setMaxDuration(getTimeOfCrawlPageFromAuditParameter(audit));

        Crawler tngCrawler = crawlerFactory.create(audit);
        for(String url : urlList){
            tngCrawler.addSeed(url);
        }
        tngCrawler.run();
        tngCrawler.waitUntilFinish();
        return tngCrawler.getResult();
    }

    public List<String> getUrlListByCrawlingFromUrl(Audit audit, String url){
        TanaguruCrawlerControllerFactory crawlerFactory = new TanaguruCrawlerControllerFactory();
        crawlerFactory.setMaxDepth(getMaxDepthOfCrawlPageFromAuditParameter(audit));
        crawlerFactory.setMaxDocument(getMaxNumberOfCrawlPageFromAuditParameter(audit));
        crawlerFactory.setMaxDuration(getTimeOfCrawlPageFromAuditParameter(audit));

        Crawler tngCrawler = crawlerFactory.create(audit);

        tngCrawler.addSeed(url);
        tngCrawler.run();
        tngCrawler.waitUntilFinish();
        return tngCrawler.getResult();
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
