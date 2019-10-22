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
import org.tanaguru.entity.audit.Audit;
import org.tanaguru.entity.parameterization.Parameter;
import org.tanaguru.entity.service.parameterization.ParameterDataService;

import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 *
 * @author rcharre
 */
@XmlTransient
public class TanaguruCrawlerServiceImpl implements CrawlerService{
    private static final Logger LOGGER = Logger.getLogger(TanaguruCrawlerServiceImpl.class);
    private static final String BEGIN_REGEX = "(?i)(.*)(";
    private static final String END_REGEX = ")(.*)$";
    private static final String OR_SEPARATOR_REGEX = "|";

    @Autowired
    private ParameterDataService parameterDataService;
    public void setParameterDataService(ParameterDataService parameterDataService) {
        this.parameterDataService = parameterDataService;
    }

    @Autowired
    private CrawlerFactory crawlerFactory;
    public void setCrawlerFactory(CrawlerFactory crawlerFactory){
        this.crawlerFactory = crawlerFactory;
    }

    public List<String> getUrlListByCrawlingFromUrlList(Audit audit, List<String> urlList){
        crawlerFactory.setMaxDepth(getMaxDepthOfCrawlPageFromAuditParameter(audit));
        crawlerFactory.setMaxDocument(getMaxNumberOfCrawlPageFromAuditParameter(audit));
        crawlerFactory.setMaxDuration(getTimeOfCrawlPageFromAuditParameter(audit));
        crawlerFactory.setExclusionRegex(getExclusionRegexFromAuditParameter(audit));
        crawlerFactory.setInclusionRegex(getInclusionRegexFromAuditParameter(audit));

        Crawler tngCrawler = crawlerFactory.create(audit);
        for(String url : urlList){
            tngCrawler.addSeed(url);
        }
        tngCrawler.run();
        tngCrawler.waitUntilFinish();
        return tngCrawler.getResult();
    }

    public List<String> getUrlListByCrawlingFromUrl(Audit audit, String url){
        crawlerFactory.setMaxDepth(getMaxDepthOfCrawlPageFromAuditParameter(audit));
        crawlerFactory.setMaxDocument(getMaxNumberOfCrawlPageFromAuditParameter(audit));
        crawlerFactory.setMaxDuration(getTimeOfCrawlPageFromAuditParameter(audit));
        crawlerFactory.setExclusionRegex(getExclusionRegexFromAuditParameter(audit));
        crawlerFactory.setInclusionRegex(getInclusionRegexFromAuditParameter(audit));

        Crawler tngCrawler = crawlerFactory.create(audit);

        tngCrawler.addSeed(url);
        tngCrawler.run();
        tngCrawler.waitUntilFinish();
        return tngCrawler.getResult();
    }

    private int getMaxNumberOfCrawlPageFromAuditParameter(Audit audit) {
        try {
            Parameter max_documents = parameterDataService.getParameter(audit, "MAX_DOCUMENTS");
            if (max_documents != null) {
                return Integer.valueOf(max_documents.getValue());
            }
        } catch (NumberFormatException nfe) {
            return -1;
        }
        return -1;
    }

    private int getMaxDepthOfCrawlPageFromAuditParameter(Audit audit) {
        try {
            Parameter depth = parameterDataService.getParameter(audit, "DEPTH");
            if (depth != null) {
                return Integer.valueOf(depth.getValue());
            }
        } catch (NumberFormatException nfe) {
            return -1;
        }
        return -1;
    }

    private long getTimeOfCrawlPageFromAuditParameter(Audit audit) {
        try {
            Parameter timeOfCrawl = parameterDataService.getParameter(audit, "MAX_DURATION");
            if (timeOfCrawl != null) {
                return 1000L * Long.valueOf(timeOfCrawl.getValue());
            }
        } catch (NumberFormatException nfe) {
            return -1;
        }
        return -1;
    }

    private String getExclusionRegexFromAuditParameter(Audit audit) {
        Parameter exclusionRegexp = parameterDataService.getParameter(audit, "EXCLUSION_REGEXP");
        return exclusionRegexp != null ?
                buildRegexFromString(exclusionRegexp.getValue()) :
                "";
    }

    private String getInclusionRegexFromAuditParameter(Audit audit) {
        Parameter inclusionRegexp = parameterDataService.getParameter(audit, "INCLUSION_REGEXP");
        return inclusionRegexp != null ?
                buildRegexFromString(inclusionRegexp.getValue()) :
                "";
    }

    private String buildRegexFromString(String rawRegexList){
        String result = "";
        if (rawRegexList != null && !rawRegexList.isEmpty()){
            String[] regexList = rawRegexList.split(";");
            StringBuilder resultBuilder = new StringBuilder();
            resultBuilder.append(BEGIN_REGEX);
            boolean firstOccrurence = true;
            for(String regexPart : regexList){
                if(!firstOccrurence){
                    resultBuilder.append(OR_SEPARATOR_REGEX);
                }else{
                    firstOccrurence = false;
                }
                resultBuilder.append(regexPart);
            }
            resultBuilder.append(END_REGEX);
            result = resultBuilder.toString();
        }
        return result;
    }
}
