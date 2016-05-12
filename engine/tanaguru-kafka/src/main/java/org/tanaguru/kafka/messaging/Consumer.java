/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tanaguru.kafka.messaging;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import org.tanaguru.entity.audit.Audit;
import org.tanaguru.entity.parameterization.Parameter;

import org.apache.log4j.Logger;
import org.tanaguru.entity.audit.Audit;
import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.entity.parameterization.Parameter;
import org.tanaguru.entity.service.audit.AuditDataService;
import org.tanaguru.entity.service.audit.ProcessResultDataService;
import org.tanaguru.entity.service.parameterization.ParameterDataService;
import org.tanaguru.entity.service.parameterization.ParameterElementDataService;
import org.tanaguru.kafka.util.AuditPageConsumed;
import org.tanaguru.kafka.util.MessageConsumerLimit;
import org.tanaguru.kafka.util.MessageKafka;
import org.tanaguru.service.AuditService;
import org.tanaguru.kafka.util.ParameterUtils;
import org.tanaguru.service.AuditServiceListener;

/**
 *
 * @author omokeddem at oceaneconsulting
 *
 */
public class Consumer implements Runnable {

    private KafkaStream m_stream;
    private int m_threadNumber;

    private ParameterDataService parameterDataService;
    private AuditService auditService;
    private ParameterElementDataService parameterElementDataService;
    private AuditDataService auditDataService;
    private ProcessResultDataService processResultDataService;

    private AuditPageConsumed auditPageConsumed;

    private String ref;
    private String level;

    private MessageConsumerLimit messageConsumerLimit;
    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(Consumer.class);

    public Consumer(KafkaStream a_stream, int a_threadNumber, ParameterDataService a_parameterDataService, AuditService a_auditService,
            ParameterElementDataService a_parameterElementDataService, AuditDataService a_auditDataService,
            ProcessResultDataService a_processResultDataService, AuditPageConsumed a_auditPageConsumed,
            String a_ref, String a_level) {
        m_threadNumber = a_threadNumber;
        m_stream = a_stream;

        parameterDataService = a_parameterDataService;
        auditService = a_auditService;
        parameterElementDataService = a_parameterElementDataService;
        auditDataService = a_auditDataService;
        processResultDataService = a_processResultDataService;
        auditPageConsumed = a_auditPageConsumed;

        ref = a_ref;
        level = a_level;
        
        messageConsumerLimit = new MessageConsumerLimit();
        
        auditPageConsumed.setMessageConsumerLimit(messageConsumerLimit);
    }

    public void run() {
        ConsumerIterator<byte[], byte[]> it = m_stream.iterator();
        while (it.hasNext()) {
            if (messageConsumerLimit.getCurrentNumberMessages() < 3) {
                messageConsumerLimit.messageConsumed();
                String message = new String(it.next().message(), StandardCharsets.UTF_8);

                logger.info("[AUDIT][IN] A message have been received..." + message);

                if (MessageKafka.isMessageKafka(message)) {

                //1- log in db message and type of audit
                    //2- format message to objet audit
                    logger.info("[AUDIT][IN] URL received..." + MessageKafka.getUrl(message));

                    Set<Parameter> paramSet = ParameterUtils.getParameterSetFromAuditLevel(MessageKafka.getReferentiel(message),
                            MessageKafka.getLevel(message), parameterElementDataService, parameterDataService);

                    Set<Parameter> parameters = ParameterUtils.getAuditPageParameterSet(paramSet, parameterElementDataService, parameterDataService);

                    auditPageConsumed.auditPage(message, parameters);
                }
            }
        }
        logger.info("Shutting down Thread: " + m_threadNumber);
    }
}
