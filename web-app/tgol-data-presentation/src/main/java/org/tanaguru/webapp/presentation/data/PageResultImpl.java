/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2015 Tanaguru.org
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
package org.tanaguru.webapp.presentation.data;

import java.io.Serializable;
import java.util.ResourceBundle;
import org.tanaguru.webapp.util.TgolEscapeUrl;
import org.tanaguru.webapp.util.TgolKeyStore;

/**
 * This class handles basics displayable data about a page result
 * @author jkowalczyk
 */
public class PageResultImpl implements PageResult, Serializable {

    private String label;
    private int rank;
    private String rawMark;
    private Long id;
    private String httpStatusCode;
    private String weightedMark;
    private String pageResultUrl;
    private String url;

    public static final String REQUEST_PARAMETER =
            "?"+TgolKeyStore.WEBRESOURCE_ID_KEY+"=";

    public static final String REPRESENTATION_BUNDLE_NAME = "url";

    private final ResourceBundle representationBundle =
            ResourceBundle.getBundle(REPRESENTATION_BUNDLE_NAME);

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public final void setUrl(String url) {
        this.url = TgolEscapeUrl.escapeUrl(url);
    }


    @Override
    public String getPageResultUrl() {
        return pageResultUrl;
    }

    @Override
    public void setPageResultUrl(String pageResultUrl) {
        this.pageResultUrl = pageResultUrl;
    }


    @Override
    public String getWeightedMark() {
        return weightedMark;
    }

    @Override
    public void setWeightedMark(String weightedMark) {
        this.weightedMark= weightedMark;
    }


    @Override
    public String getHttpStatusCode() {
        return httpStatusCode;
    }

    @Override
    public void setHttpStatusCode(String httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String getRawMark() {
        return rawMark;
    }

    @Override
    public void setRawMark(String rawMark) {
        this.rawMark = rawMark;
    }

    @Override
    public int getRank() {
        return rank;
    }

    @Override
    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Default Constructor
     */
    public PageResultImpl (String url, Integer rank,Float weightedMark, Float rawMark, Long webResourceId, String httpStatusCode, String label) {
        pageResultUrl = representationBundle.getString(TgolKeyStore.RESULT_PAGE_NAME_KEY)+
                REQUEST_PARAMETER+
                webResourceId;
        this.id = webResourceId;
        this.url = url;
        if (rawMark < 0) {
            this.weightedMark = "-1";
            this.rawMark = "-1";
        } else {
            this.weightedMark = String.valueOf(Float.valueOf(weightedMark).intValue());
            this.rawMark = String.valueOf(Float.valueOf(rawMark).intValue());
        }
        this.httpStatusCode = String.valueOf(httpStatusCode);
        this.rank = rank;
        this.label = label;
    }

}