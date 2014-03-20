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
package org.opens.tanaguru.analyser;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.opens.tanaguru.entity.audit.Audit;
import org.opens.tanaguru.entity.audit.ProcessResult;
import org.opens.tanaguru.entity.factory.audit.ProcessResultFactory;
import org.opens.tanaguru.entity.parameterization.Parameter;
import org.opens.tanaguru.entity.parameterization.ParameterFamily;
import org.opens.tanaguru.entity.service.audit.AuditDataService;
import org.opens.tanaguru.entity.service.audit.ProcessResultDataService;
import org.opens.tanaguru.entity.service.parameterization.ParameterDataService;
import org.opens.tanaguru.entity.service.parameterization.ParameterFamilyDataService;
import org.opens.tanaguru.entity.service.statistics.CriterionStatisticsDataService;
import org.opens.tanaguru.entity.service.statistics.TestStatisticsDataService;
import org.opens.tanaguru.entity.service.statistics.ThemeStatisticsDataService;
import org.opens.tanaguru.entity.service.statistics.WebResourceStatisticsDataService;
import org.opens.tanaguru.entity.service.subject.WebResourceDataService;
import org.opens.tanaguru.entity.subject.Site;
import org.opens.tanaguru.entity.subject.WebResource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author enzolalay
 */
public class AnalyserFactoryImpl implements AnalyserFactory {// TODO Write javadoc

    private WebResourceStatisticsDataService webResourceStatisticsDataService;
    public WebResourceStatisticsDataService getWebResourceStatisticsDataService() {
        return webResourceStatisticsDataService;
    }

    public void setWebResourceStatisticsDataService(
            WebResourceStatisticsDataService webResourceStatisticsDataService) {
        this.webResourceStatisticsDataService = webResourceStatisticsDataService;
    }
    
    private WebResourceDataService webResourceDataService;
    public WebResourceDataService getWebResourceDataService() {
        return webResourceDataService;
    }

    public void setWebResourceDataService(
            WebResourceDataService webResourceDataService) {
        this.webResourceDataService = webResourceDataService;
    }
    
    private ThemeStatisticsDataService themeStatisticsDataService;
    public ThemeStatisticsDataService getThemeStatisticsDataService() {
        return themeStatisticsDataService;
    }

    public void setThemeStatisticsDataService(
            ThemeStatisticsDataService themeStatisticsDataService) {
    }
    
    private TestStatisticsDataService testStatisticsDataService;
    public TestStatisticsDataService getTestStatisticsDataService() {
        return testStatisticsDataService;
    }

    public void setTestStatisticsDataService(
            TestStatisticsDataService testStatisticsDataService) {
    }
    
    private CriterionStatisticsDataService criterionStatisticsDataService;
    public CriterionStatisticsDataService getCriterionStatisticsDataService() {
        return criterionStatisticsDataService;
    }

    public void setCriterionStatisticsDataService(
            CriterionStatisticsDataService criterionStatisticsDataService) {
    }
    
    private AuditDataService auditDataService;
    public AuditDataService getAuditDataService() {
        return auditDataService;
    }

    public void setAuditDataService(AuditDataService auditDataService) {
        this.auditDataService = auditDataService;
    }
    
    private ParameterDataService parameterDataService;
    public ParameterDataService getParameterDataService() {
        return parameterDataService;
    }

    public void setParameterElementDataService(ParameterDataService parameterDataService) {
        this.parameterDataService = parameterDataService;
    }
    
    private ParameterFamilyDataService parameterFamilyDataService;
    public ParameterFamilyDataService getParameterFamilyDataService() {
        return parameterFamilyDataService;
    }

    public void setParameterFamilyDataService(ParameterFamilyDataService parameterFamilyDataService) {
        this.parameterFamilyDataService = parameterFamilyDataService;
    }

    private List<String> testWeightParameterFamilyCodeList = Collections.EMPTY_LIST;
    public void setTestWeightParameterFamilyCodeList(List<String> testWeightParameterFamilyCodeList) {
        this.testWeightParameterFamilyCodeList = testWeightParameterFamilyCodeList;
    }

    private ProcessResultDataService processResultDataService;
    public ProcessResultDataService getProcessResultDataService() {
        return processResultDataService;
    }

    public void setProcessResultDataService(ProcessResultDataService processResultDataService) {
        this.processResultDataService = processResultDataService;
    }
    
    private ProcessResultFactory processResultFactory;
    public ProcessResultFactory getProcessResultFactory() {
        return processResultFactory;
    }

    public void setProcessResultFactory(ProcessResultFactory processResultFactory) {
        this.processResultFactory = processResultFactory;
    }
    
    private Collection<ParameterFamily> testWeightParameterFamilySet ;
    
    @Autowired
    public AnalyserFactoryImpl(
            AuditDataService auditDataService,
            WebResourceDataService webResourceDataService,
            TestStatisticsDataService testStatisticsDataService,
            ThemeStatisticsDataService themeStatisticsDataService,
            WebResourceStatisticsDataService webResourceStatisticsDataService, 
            CriterionStatisticsDataService criterionStatisticsDataService, 
            ParameterDataService parameterDataService,
            ParameterFamilyDataService parameterFamilyDataService,
            ProcessResultDataService processResultDataService, 
            ProcessResultFactory processResultFactory) {
        this.auditDataService = auditDataService;
        this.webResourceDataService = webResourceDataService;
        this.testStatisticsDataService = testStatisticsDataService;
        this.themeStatisticsDataService = themeStatisticsDataService;
        this.webResourceStatisticsDataService = webResourceStatisticsDataService;
        this.criterionStatisticsDataService = criterionStatisticsDataService;
        this.parameterDataService = parameterDataService;
        this.parameterFamilyDataService = parameterFamilyDataService;
        this.processResultDataService = processResultDataService;
        this.processResultFactory = processResultFactory;
    }

    @Override
    public Analyser create(WebResource webResource, Audit audit) {
        int nbOfWebResource = 1;
        if (webResource instanceof Site) {
            nbOfWebResource = 
                    webResourceDataService.getNumberOfChildWebResource(webResource).intValue();
        }
        Analyser analyser = new AnalyserImpl(
                auditDataService,
                testStatisticsDataService,
                themeStatisticsDataService,
                webResourceStatisticsDataService,
                criterionStatisticsDataService,
                processResultDataService,
                processResultFactory,
                webResource,
                getTestWeightParamSet(audit), 
                nbOfWebResource);
        return analyser;
    }

    @Override
    public Analyser create(List<ProcessResult> netResultList) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * 
     * @param audit
     * @return 
     * 
     *  the collection of test weight parameters for the given audit
     */
    private Collection<Parameter> getTestWeightParamSet(Audit audit) {
        if (testWeightParameterFamilySet == null) {
            testWeightParameterFamilySet = new HashSet<ParameterFamily>();
            for (String paramFamilyCode : testWeightParameterFamilyCodeList) {
                testWeightParameterFamilySet.add(parameterFamilyDataService.getParameterFamily(paramFamilyCode));
            }
        }
        Collection<Parameter> testWeightParamSet = new HashSet<Parameter>();
        for (ParameterFamily pf : testWeightParameterFamilySet) {
                testWeightParamSet.addAll(parameterDataService.getParameterSet(pf, audit));
        }
        return testWeightParamSet;
    }
    
}