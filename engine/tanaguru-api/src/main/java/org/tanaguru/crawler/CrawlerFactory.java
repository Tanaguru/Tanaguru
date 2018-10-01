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
package org.tanaguru.crawler;

import java.util.Set;

import org.tanaguru.entity.audit.Audit;
import org.tanaguru.entity.parameterization.Parameter;

/**
 *
 * @author enzolalay
 */
public interface CrawlerFactory {

    /**
     * The output directory needed by the crawler to create temporary files
     * during the crawl.
     */
    void setOutputDir(String outputDir);

    /**
     * Set the crawling max duration in second
     * @param maxDuration
     */
    void setMaxDuration(long maxDuration);

    /**
     * Set the crawling max document to crawl
     * @param maxDocument
     */
    void setMaxDocument(int maxDocument);

    /**
     * Set the crawling max depth level
     * @param maxDepth
     */
    void setMaxDepth(int maxDepth);

    void setInclusionRegex(String inclusionRegex);

    void setExclusionRegex(String exclusionRegex);
    
    /**
     *
     * @return
     *      an initialised implementation of the crawler interface
     */
    Crawler create(Audit audit);
}
