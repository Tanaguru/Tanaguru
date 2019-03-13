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
package org.tanaguru.webapp.presentation.factory.impl;

import org.tanaguru.entity.reference.Scope;
import org.tanaguru.entity.service.audit.ProcessResultDataService;
import org.tanaguru.entity.service.subject.WebResourceDataService;
import org.tanaguru.entity.subject.WebResource;
import org.tanaguru.webapp.presentation.data.PageResult;
import org.tanaguru.webapp.presentation.data.PageResultImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.tanaguru.webapp.presentation.factory.PageResultFactory;

/**
 * As a factory, this class return an initialized instance of PageResult
 * @author jkowalczyk
 */
public class PageResultFactoryImpl implements PageResultFactory {

    private ProcessResultDataService processResultDataService;

    @Autowired
    private WebResourceDataService webResourceDataService;

    public ProcessResultDataService getProcessResultDataService() {
        return processResultDataService;
    }


    @Autowired
    public void setProcessResultDataService(ProcessResultDataService processResultDataService) {
        this.processResultDataService = processResultDataService;
    }

    private Scope scope;
    @Override
    public Scope getScope() {
        return scope;
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    /**
     * The unique shared instance of PageResultFactoryImpl
     */
    private static PageResultFactory pageResultFactory;

    /**
     * Default private constructor
     */
    protected PageResultFactoryImpl() {}

    public static synchronized PageResultFactory getInstance() {
        if (pageResultFactory == null) {
            pageResultFactory = new PageResultFactoryImpl();
        }
        return pageResultFactory;
    }

    /**
     * 
     * @param url
     * @param rank
     * @param weightedMark
     * @param rawMark
     * @param webResourceId
     * @param httpStatusCode
     * @return
     */
    @Override
    public PageResult getPageResult(
            String url,
            Integer rank,
            Float weightedMark,
            Float rawMark,
            Long webResourceId,
            String httpStatusCode){
        WebResource webResource = webResourceDataService.read(webResourceId);
        return new PageResultImpl(url, rank, weightedMark, rawMark, webResourceId, httpStatusCode, webResource.getLabel());
    }

}