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
package org.tanaguru.scenarioloader;

import java.util.List;
import java.util.Map;

import org.tanaguru.entity.audit.Content;
import org.tanaguru.entity.service.audit.ContentDataService;
import org.tanaguru.entity.service.audit.PreProcessResultDataService;
import org.tanaguru.entity.service.parameterization.ParameterDataService;
import org.tanaguru.entity.service.subject.WebResourceDataService;
import org.tanaguru.entity.subject.WebResource;
import org.tanaguru.util.factory.DateFactory;

/**
 * 
 * @author jkowalczyk
 */
public interface ScenarioLoader {

    /**
     *
     * @return
     */
    List<Content> getResult();

    /**
     *
     */
    void run(String scenario);

    void run(List<String> urlList);

    /**
     * 
     * @param webResource
     */
    void setWebResource(WebResource webResource);

    void setContentDataService(ContentDataService contentDataService);

    void setDateFactory(DateFactory dateFactory);

    void setWebResourceDataService(WebResourceDataService webResourceDataService);

    void setPreProcessResultDataService(PreProcessResultDataService preProcessResultDataService);

    void setJsScriptMap(Map<String,String> jsScriptMap);

    void setPageLoadDriverTimeout(int pageLoadDriverTimeout);

    void setParameterDataService(ParameterDataService parameterDataService);
}