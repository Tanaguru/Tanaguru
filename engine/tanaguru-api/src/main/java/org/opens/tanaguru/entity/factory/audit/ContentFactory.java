/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2011  Open-S Company
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
 * Contact us by mail: open-s AT open-s DOT com
 */
package org.opens.tanaguru.entity.factory.audit;

import org.opens.tanaguru.sdk.entity.factory.GenericFactory;
import java.util.Date;

import org.opens.tanaguru.entity.audit.Content;
import org.opens.tanaguru.entity.audit.ImageContent;
import org.opens.tanaguru.entity.audit.JavascriptContent;
import org.opens.tanaguru.entity.audit.RelatedContent;
import org.opens.tanaguru.entity.subject.Page;
import org.opens.tanaguru.entity.audit.SSP;
import org.opens.tanaguru.entity.audit.StylesheetContent;

/**
 * 
 * @author jkowalczyk
 */
public interface ContentFactory extends GenericFactory<Content> {

    /**
     *
     * @param uri
     * @return
     */
    SSP createSSP(String uri);

    /**
     *
     * @param uri
     * @param page
     * @return
     */
    SSP createSSP(String uri,Page page);

    /**
     *
     * @param dateOfLoading
     * @param uri
     * @return
     */
    SSP createSSP(Date dateOfLoading, String uri);

    /**
     *
     * @param dateOfLoading
     * @param uri
     * @param sourceCode
     * @param page
     * @return
     */
    SSP createSSP(Date dateOfLoading, String uri, String sourceCode, Page page);

    /**
     *
     * @param dateOfLoading
     * @param uri
     * @param httpStatusCode
     * @return
     */
    SSP createSSP(Date dateOfLoading, String uri, int httpStatusCode);

    /**
     *
     * @param dateOfLoading
     * @param uri
     * @param sourceCode
     * @param page
     * @param httpStatusCode
     * @return
     */
    SSP createSSP(Date dateOfLoading, String uri, String sourceCode, Page page, int httpStatusCode);

    /**
     *
     * @param uri
     * @param ssp
     * @return
     */
    StylesheetContent createStylesheetContent(String uri, SSP ssp);

    /**
     *
     * @param dateOfLoading
     * @param uri
     * @param ssp
     * @param sourceCode
     * @return
     */
    StylesheetContent createStylesheetContent(Date dateOfLoading, String uri, SSP ssp, String sourceCode);

    /**
     *
     * @param dateOfLoading
     * @param uri
     * @param ssp
     * @param sourceCode
     * @param httpStatusCode
     * @return
     */
    StylesheetContent createStylesheetContent(Date dateOfLoading, String uri, SSP ssp, String sourceCode, int httpStatusCode);

    /**
     *
     * @param dateOfLoading
     * @param uri
     * @param ssp
     * @param sourceCode
     * @return
     */
    JavascriptContent createJavascriptContent(Date dateOfLoading, String uri, SSP ssp, String sourceCode);

    /**
     *
     * @param dateOfLoading
     * @param uri
     * @param ssp
     * @param sourceCode
     * @param httpStatusCode
     * @return
     */
    JavascriptContent createJavascriptContent(Date dateOfLoading, String uri, SSP ssp, String sourceCode, int httpStatusCode);

    /**
     *
     * @param dateOfLoading
     * @param uri
     * @param ssp
     * @param binaryContent
     * @return
     */
    ImageContent createImageContent(Date dateOfLoading, String uri, SSP ssp, byte[] binaryContent);

    /**
     *
     * @param uri
     * @param ssp
     * @return
     */
    ImageContent createImageContent(String uri, SSP ssp);

    /**
     *
     * @param dateOfLoading
     * @param uri
     * @param ssp
     * @param binaryContent
     * @param httpStatusCode
     * @return
     */
    ImageContent createImageContent(Date dateOfLoading, String uri, SSP ssp, byte[] binaryContent, int httpStatusCode);

    /**
     * 
     * @param uri
     * @param ssp
     * @return
     */
    RelatedContent createRelatedContent(String uri, SSP ssp);

}