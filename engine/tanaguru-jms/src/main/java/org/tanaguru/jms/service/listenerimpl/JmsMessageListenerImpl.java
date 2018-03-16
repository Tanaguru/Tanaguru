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
package org.tanaguru.jms.service.listenerimpl;

import java.util.Set;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.tanaguru.entity.parameterization.Parameter;
import org.tanaguru.entity.parameterization.ParameterElement;
import org.tanaguru.entity.service.parameterization.ParameterDataService;
import org.tanaguru.entity.service.parameterization.ParameterElementDataService;
import org.tanaguru.jms.service.api.JmsMesageListener;
import org.tanaguru.jms.util.ParameterUtilsAudit;
import org.tanaguru.jsms.auditservicelistener.JmsAuditServiceListernerImpl;
import org.tanaguru.model.AuditModel;

/**
 *
 * @author mkebri
 */
@Component
public class JmsMessageListenerImpl implements JmsMesageListener {

    private final static Logger LOGGER = Logger.getLogger(JmsMessageListenerImpl.class);

    @Autowired
    ParameterDataService parameterDataService;

    @Autowired
    JmsAuditServiceListernerImpl jmsAuditServiceListernerImpl;

    @Autowired
    ParameterElementDataService parameterElementDataService;

    /**
     * Handle a message , within a JMS session.
     */
    @Override
    public void onMessage(Message message, Session session) {
        LOGGER.info("Message to audit received ! ok  ");
        if (message instanceof TextMessage) {
            LOGGER.info("Message type TextMessage  ");
        } else if (message instanceof ObjectMessage) {

            LOGGER.info("Message is of type ObjectMessage ");
            try {
                LOGGER.info("Message id: " + message.getJMSMessageID());
            } catch (JMSException ex) {
                java.util.logging.Logger.getLogger(JmsMessageListenerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            AuditModel auditModel = null;
            try {
                auditModel = (AuditModel) ((ObjectMessage) message).getObject();
            } catch (JMSException ex) {
                LOGGER.debug("Exception on jms getObject: " + ex);
            }
            try {
                LOGGER.info("## ===> :  Msg id =  " + message.getJMSMessageID());
            } catch (JMSException ex) {
                java.util.logging.Logger.getLogger(JmsMessageListenerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            LOGGER.info("## ===> :  Audit url  =  " + auditModel.getUrl());

            LOGGER.info("Initialize parameters...");

            ParameterElement levelParameterElement = parameterElementDataService.getParameterElement("LEVEL");
            Parameter levelParameter = parameterDataService.getParameter(levelParameterElement, "Rgaa32017;LEVEL_2");
            Set<Parameter> paramSet = parameterDataService.getDefaultParameterSet();
            paramSet = parameterDataService.updateParameter(paramSet, levelParameter);

            Set<Parameter> parameters = ParameterUtilsAudit.getAuditPageParameterSet(paramSet, parameterElementDataService, parameterDataService);

            ParameterUtilsAudit.initializePAInputOptions(
                    "DATA_TABLE_MARKER",
                    "COMPLEX_TABLE_MARKER",
                    "PRESENTATION_TABLE_MARKER",
                    "DECORATIVE_IMAGE_MARKER",
                    "INFORMATIVE_IMAGE_MARKER",
                    "1200",
                    "960",
                    parameters);

            LOGGER.info("Audit launched by calling  jmsAuditServiceListernerImpl ");
//            LOGGER.info("Launch audit page service...");
            //launch audit 
            Long idAudit = this.jmsAuditServiceListernerImpl.launchAuditOnJmsMessageReceived(auditModel, parameters);
            //3- persist audit information on db observatoire	
            // Long idAudit = audit.getId();

            LOGGER.info("onMessage from listener Tanaguru terminateur id Audit is " + idAudit);

        }
    }

}
