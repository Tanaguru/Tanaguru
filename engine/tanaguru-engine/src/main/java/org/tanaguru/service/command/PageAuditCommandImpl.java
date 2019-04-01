/*
 *  Tanaguru - Automated webpage assessment
 *  Copyright (C) 2008-2015  Tanaguru.org
 * 
 *  This file is part of Tanaguru.
 * 
 *  Tanaguru is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 * 
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 *  Contact us by mail: tanaguru AT tanaguru DOT org
 */

package org.tanaguru.service.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.tanaguru.entity.audit.AuditStatus;
import org.tanaguru.entity.parameterization.Parameter;
import org.tanaguru.entity.service.audit.AuditDataService;
import org.tanaguru.service.AuditServiceImpl;
import org.tanaguru.service.ScenarioLoaderService;
import org.tanaguru.util.FileNaming;
import org.tanaguru.util.http.HttpRequestHandler;

/**
 *
 * @author jkowalczyk
 */
public class PageAuditCommandImpl extends AuditCommandImpl {

    private final String pageUrl;

    private List<String> webdriverUrlListToAudit;

    ScenarioLoaderService scenarioLoaderService;

    /**
     * 
     * @param pageUrl
     * @param paramSet
     * @param auditDataService 
     */
    public PageAuditCommandImpl(
            String pageUrl,
            Set<Parameter> paramSet,
            AuditDataService auditDataService) {
        super(paramSet, auditDataService);
        this.pageUrl = FileNaming.addProtocolToUrl(pageUrl);
    }
    
     /**
     * 
     * @param pageUrl
     * @param paramSet
     * @param auditDataService 
     * @param w3cValidatorPath 
     * @param java8Path
     */
    public PageAuditCommandImpl(
            String pageUrl,
            Set<Parameter> paramSet,
            AuditDataService auditDataService,
            String w3cValidatorPath,
            String java8Path) {
        super(paramSet, auditDataService, w3cValidatorPath, java8Path);
        this.pageUrl = FileNaming.addProtocolToUrl(pageUrl);
    }

    @Override
    public void init() {
        if (HttpRequestHandler.getInstance().isUrlAccessible(pageUrl)) {
            super.init();
            createEmptyWebResource(pageUrl);
        } else {
            super.init();
            setStatusToAudit(AuditStatus.ERROR);
        }
        this.webdriverUrlListToAudit = prepareWebdriverUrlList();
    }

    @Override
    public void loadContent() {
        setStatusToAudit(AuditStatus.CONTENT_LOADING);
        scenarioLoaderService.loadUrlListContent(getAudit(), this.webdriverUrlListToAudit);

        if (getContentDataService().hasContent(getAudit())) {
            setStatusToAudit(AuditStatus.CONTENT_ADAPTING);
        } else {
            Logger.getLogger(AuditServiceImpl.class).warn("Audit has no content");
            setStatusToAudit(AuditStatus.ERROR);
        }
    }

    protected List<String> prepareWebdriverUrlList(){
        ArrayList<String> result = new ArrayList<>();
        result.add(this.pageUrl);
        return result;
    }

    protected void createEmptyWebResource(String url){
        createEmptyPageResource(url);
    }

    public void setScenarioLoaderService(ScenarioLoaderService scenarioLoaderService){
        this.scenarioLoaderService = scenarioLoaderService;
    }
}