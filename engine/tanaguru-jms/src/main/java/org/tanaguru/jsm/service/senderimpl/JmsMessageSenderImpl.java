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
package org.tanaguru.jsm.service.senderimpl;

import java.io.Serializable;
import java.util.logging.Level;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.apache.activemq.command.ActiveMQQueue;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.tanaguru.jms.service.api.JmsMessageSender;
import org.tanaguru.model.AuditModel;

/**
 *
 * @author mkebri
 */
@Service
public class JmsMessageSenderImpl implements JmsMessageSender {

    public static final Logger LOGGER = Logger.getLogger(JmsMessageSenderImpl.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void setJmsTemplate(JmsTemplate template) {
        this.jmsTemplate = template;
    }

    public JmsTemplate getJmsTemplate() {

        return this.jmsTemplate;
    }

    /**
     * send text to default destination
     *
     * @param text
     */
    @Override
    public void sendResult(final String text) {

        this.jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                Message message = session.createTextMessage(text);
                //set ReplyTo header of Message, pretty much like the concept of email.
                message.setJMSReplyTo(new ActiveMQQueue("auditResultQueue"));
                return message;
            }
        });
    }

    /**
     * send ObjectMessage to default destination: result of the audit
     *
     * @param ObjectMessage
     */
    @Override
    public void sendResult(final AuditModel auditModelResult) {

        LOGGER.info("Inside the sendResult in JmsMessageSenderImpl ");
        this.jmsTemplate.send("auditResultQueue", new MessageCreator() {
            @Override
            public Message createMessage(final Session session) {
                LOGGER.info("Niveau 1 ");

                Message message = null;
                try {
//     LOGGER.info("Niveau 2 "+ jsonObject.getString("RawMark : "));
                    message = session.createObjectMessage((Serializable) auditModelResult);
                } catch (JMSException ex) {
                    java.util.logging.Logger.getLogger(JmsMessageSenderImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                LOGGER.info("Just exit  the sendResult in JmsMessageSenderImpl ");
                return message;
            }
        });
    }

    /**
     * Simplify the send by using convertAndSend
     *
     * @param text
     */
    @Override
    public void sendText(final String text) {
        this.jmsTemplate.convertAndSend(text);
    }

    /**
     * Send text message to a specified destination
     *
     * @param dest
     * @param text
     */
    @Override
    public void send(final Destination dest, final String text) {

        this.jmsTemplate.send(dest, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                Message message = session.createTextMessage(text);
                return message;
            }
        });
    }

    public void sendToR(final JSONObject jsonObject) {

        this.jmsTemplate.send("auditResultQueue", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {

                Message message = session.createObjectMessage((Serializable) jsonObject);
                //set ReplyTo header of Message, pretty much like the concept of email.
                message.setJMSReplyTo(new ActiveMQQueue("auditResultQueue"));
                return message;
            }
        });
    }

}
