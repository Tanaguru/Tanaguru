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
package org.opens.tgol.entity.dao.tanaguru.subject;


import java.util.Collection;
import org.opens.tanaguru.entity.audit.ProcessResult;
import org.opens.tanaguru.entity.reference.Criterion;
import org.opens.tanaguru.entity.reference.Scope;
import org.opens.tanaguru.entity.reference.Test;
import org.opens.tanaguru.entity.subject.WebResource;
import org.opens.tanaguru.sdk.entity.dao.GenericDAO;
import org.opens.tgol.presentation.data.PageResult;


/**
 * This interface adds more primitives to the WebResourceDAO interface defined
 * in the tanaguru API
 *
 * @author jkowalczyk
 */
public interface TgolWebResourceDAO extends GenericDAO<WebResource, Long> {

    /**
     *
     * @param webresourceId
     * @return
     *          the id of the parent webresource for a given webresource.
     */
    Long retrieveParentWebResourceId(Long webresourceId);

    /**
     *
     * @param webResourceId
     * @return
     */
    WebResource ligthRead(Long webResourceId);

    /**
     *
     * @param parentWebresource
     * @return
     */
    Long retrieveChildWebResourceCount(WebResource parentWebresource);

    /**
     *
     * @param webResource
     * @param scope
     * @return
     */
    Collection<ProcessResult> retrieveProcessResultListByWebResourceAndScope(
            WebResource webResource,
            Scope scope);
    
    /**
     *
     * @param webResource
     * @param criterion
     * @return
     */
    Collection<ProcessResult> retrieveProcessResultListByWebResourceAndCriterion(
            WebResource webResource,
            Criterion criterion);
    
    /**
     *
     * @param webResource
     * @param test
     * @return
     */
    Collection<ProcessResult> retrieveProcessResultListByWebResourceAndTest(
            WebResource webResource,
            Test test);

    /**
     * 
     * @param webResource
     * @param scope
     * @param theme
     * @param testSolutions
     * @return
     */
    Collection<ProcessResult> retrieveProcessResultListByWebResourceAndScope(
            WebResource webResource,
            Scope scope,
            String theme,
            Collection<String> testSolutions);

    /**
     *
     * @param webResource
     * @return
     */
    Collection<PageResult> retrieveChildUrlList(WebResource webResource);

    /**
     *
     * @param webResource
     * @param scope
     * @return
     */
    boolean hasAuditSiteScopeTest(WebResource webResource, Scope scope);

}