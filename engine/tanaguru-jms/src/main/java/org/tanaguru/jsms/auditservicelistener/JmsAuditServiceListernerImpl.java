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
package org.tanaguru.jsms.auditservicelistener;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tanaguru.entity.audit.Audit;
import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.entity.parameterization.Parameter;
import org.tanaguru.entity.service.audit.AuditDataService;
import org.tanaguru.entity.service.audit.ProcessRemarkDataService;
import org.tanaguru.entity.service.audit.ProcessResultDataService;
import org.tanaguru.entity.service.parameterization.ParameterDataService;
import org.tanaguru.entity.service.parameterization.ParameterElementDataService;
import org.tanaguru.entity.service.statistics.WebResourceStatisticsDataService;
import org.tanaguru.entity.service.subject.WebResourceDataService;
import org.tanaguru.jms.service.api.JmsMessageSender;
import org.tanaguru.model.AuditModel;
import org.tanaguru.service.AuditService;
import org.tanaguru.service.AuditServiceListener;

/**
 *
 * @author mkebri
 *
 */
@Component
public class JmsAuditServiceListernerImpl implements AuditServiceListener {

    public String idCodeAudit = null;

    @Autowired
    private JmsMessageSender jmsMessageSenderImpl;

    public static final Logger LOGGER = Logger.getLogger(JmsAuditServiceListernerImpl.class);
    public List<Long> listOfAuditLauchedFromHere = new ArrayList<>();

//    @Autowired
//    ParameterDataService parameterDataService;
    //@Autowired
    // private AuditService auditService;
    private AuditService auditService = null;
    private AuditDataService auditDataService = null;
    private WebResourceDataService webResourceDataService = null;
    private WebResourceStatisticsDataService webResourceStatisticsDataService = null;
    private ProcessResultDataService processResultDataService = null;
    private ProcessRemarkDataService processRemarkDataService = null;
    private ParameterDataService parameterDataService = null;
    private ParameterElementDataService parameterElementDataService = null;

    public void setAuditService(AuditService auditService) {
        this.auditService = auditService;
    }

    @Autowired
    public JmsAuditServiceListernerImpl(AuditService auditService,
            AuditDataService auditDataService,
            WebResourceDataService webResourceDataService,
            WebResourceStatisticsDataService webResourceStatisticsDataService,
            ProcessResultDataService processResultDataService,
            ProcessRemarkDataService processRemarkDataService,
            ParameterDataService parameterDataService,
            ParameterElementDataService parameterElementDataService) {

        this.auditService = auditService;
        this.auditService = auditService;
        this.auditDataService = auditDataService;
        this.webResourceDataService = webResourceDataService;
        this.webResourceStatisticsDataService = webResourceStatisticsDataService;
        this.processResultDataService = processResultDataService;
        this.processRemarkDataService = processRemarkDataService;
        this.parameterDataService = parameterDataService;
        this.parameterElementDataService = parameterElementDataService;
        auditService.add(this);
    }

    public Long launchAuditOnJmsMessageReceived(AuditModel auditmodel, Set<Parameter> parameters) {
        idCodeAudit = auditmodel.getIdCode();   // save the value of the idCodeAudit  in the global variable 

        Audit audit = auditService.auditPage(auditmodel.getUrl(), parameters);

        //  Audit auditSc = auditService.auditScenario(url, url, parameters)
        listOfAuditLauchedFromHere.add(audit.getId());
        return audit.getId();
    }

    @Override
    public void auditCompleted(Audit audit) {

        if (listOfAuditLauchedFromHere.contains(audit.getId())) {
            LOGGER.info(" Audit  id : " + audit.getId() + " on JMS call terminated");

            audit = auditDataService.read(audit.getId());
            List<ProcessResult> processResultList = (List<ProcessResult>) processResultDataService.getNetResultFromAudit(audit);
            LOGGER.info("");
            LOGGER.info("RawMark : " + webResourceStatisticsDataService.getWebResourceStatisticsByWebResource(audit.getSubject()).getRawMark() + "%");
            LOGGER.info("WeightedMark : " + webResourceStatisticsDataService.getWebResourceStatisticsByWebResource(audit.getSubject()).getMark() + "%");
            LOGGER.info("Nb Passed : " + webResourceStatisticsDataService.getWebResourceStatisticsByWebResource(audit.getSubject()).getNbOfPassed());
            LOGGER.info("Nb Failed test : " + webResourceStatisticsDataService.getWebResourceStatisticsByWebResource(audit.getSubject()).getNbOfInvalidTest());
            LOGGER.info("Nb Failed occurences : " + webResourceStatisticsDataService.getWebResourceStatisticsByWebResource(audit.getSubject()).getNbOfFailedOccurences());
            LOGGER.info("Nb Pre-qualified : " + webResourceStatisticsDataService.getWebResourceStatisticsByWebResource(audit.getSubject()).getNbOfNmi());
            LOGGER.info("Nb Not Applicable : " + webResourceStatisticsDataService.getWebResourceStatisticsByWebResource(audit.getSubject()).getNbOfNa());
            LOGGER.info("Nb Not Tested : " + webResourceStatisticsDataService.getWebResourceStatisticsByWebResource(audit.getSubject()).getNbOfNotTested());

            JSONObject jSonAuditObject = new JSONObject();
            try {
                // jSonAuditObject.put(string, processResultList)
                jSonAuditObject.put("RawMark : ", webResourceStatisticsDataService.getWebResourceStatisticsByWebResource(audit.getSubject()).getRawMark());
                jSonAuditObject.put("WeightedMark : ", webResourceStatisticsDataService.getWebResourceStatisticsByWebResource(audit.getSubject()).getMark());
                jSonAuditObject.put("Nb Passed : ", webResourceStatisticsDataService.getWebResourceStatisticsByWebResource(audit.getSubject()).getNbOfPassed());
                jSonAuditObject.put("Nb Failed test : ", webResourceStatisticsDataService.getWebResourceStatisticsByWebResource(audit.getSubject()).getNbOfInvalidTest());
                jSonAuditObject.put("Nb Failed occurences : ", webResourceStatisticsDataService.getWebResourceStatisticsByWebResource(audit.getSubject()).getNbOfFailedOccurences());
                jSonAuditObject.put("Nb Pre-qualified : ", webResourceStatisticsDataService.getWebResourceStatisticsByWebResource(audit.getSubject()).getNbOfNmi());
                jSonAuditObject.put("Nb Not Applicable : ", webResourceStatisticsDataService.getWebResourceStatisticsByWebResource(audit.getSubject()).getNbOfNa());
                jSonAuditObject.put("Nb Not Tested : ", webResourceStatisticsDataService.getWebResourceStatisticsByWebResource(audit.getSubject()).getNbOfNotTested());

                StringBuilder str = new StringBuilder();
                str.append(audit.getId());
                str.append('#');
                str.append(webResourceStatisticsDataService.getWebResourceStatisticsByWebResource(audit.getSubject()).getRawMark());
                str.append('#');
                str.append(idCodeAudit);

                /**
                 * @TODO something send resultAudit object to ActiveMq
                 */
                LOGGER.info(" Befor sending result to Mq");
                jmsMessageSenderImpl.sendResult(str.toString());
                //  jmsMessageSenderImpl.sendToR(jSonAuditObject);
                LOGGER.info(" After sending message to Mq");
            } catch (JSONException ex) {
                LOGGER.error(ex);
            }
            listOfAuditLauchedFromHere.remove(audit.getId());
        }
    }

    @Override
    public void auditCrashed(Audit audit, Exception exception) {
        if (listOfAuditLauchedFromHere.contains(audit.getId())) {
            LOGGER.error(" Audit with id : " + audit.getId() + " on JMS call Crashed ");
            listOfAuditLauchedFromHere.remove(audit.getId());
        }
    }

    public void sendJmsJsonAuditResult(JSONObject jSONObject) {

    }

}
