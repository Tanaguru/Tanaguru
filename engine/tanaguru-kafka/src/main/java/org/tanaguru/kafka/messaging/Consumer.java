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
import org.tanaguru.kafka.util.MessageEvent;
import org.tanaguru.kafka.util.MessageKafka;
import org.tanaguru.kafka.util.MessageRest;
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
    private String messagesType;

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

    public Consumer(KafkaStream a_stream, int a_threadNumber, String a_messagesType, ParameterDataService a_parameterDataService, AuditService a_auditService,
            ParameterElementDataService a_parameterElementDataService, AuditDataService a_auditDataService,
            ProcessResultDataService a_processResultDataService, AuditPageConsumed a_auditPageConsumed,
            String a_ref, String a_level) {
        m_threadNumber = a_threadNumber;
        m_stream = a_stream;
        messagesType = a_messagesType;

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
        String referentiel = "";
        String level = "";
        ConsumerIterator<byte[], byte[]> it = m_stream.iterator();
        while (it.hasNext()) {

            if (messagesType.equals("Event") && messageConsumerLimit.getCurrentNumberMessagesEvent() < 3) {
                String message = new String(it.next().message(), StandardCharsets.UTF_8);
                logger.debug("[AUDIT][IN] A message have been received..." + message);

                if (MessageEvent.isValide(message)) {
                    messageConsumerLimit.messageEventConsumed();
                    logger.debug("number of messages from consumer Event : " + messageConsumerLimit.getCurrentNumberMessagesEvent());
                    logger.debug("[AUDIT][IN] URL received Event..." + MessageEvent.getUrl(message));
                    if (MessageEvent.getReferentiel(message).equals("")) {
                        referentiel = ref;
                    } else {
                        referentiel = MessageEvent.getReferentiel(message);
                    }
                    if (MessageEvent.getLevel(message).equals("")) {
                        level = this.level;
                    } else {
                        level = MessageEvent.getLevel(message);
                    }

                    Set<Parameter> paramSet = ParameterUtils.getParameterSetFromAuditLevel(referentiel,
                            level, parameterElementDataService, parameterDataService);

                    Set<Parameter> parameters = ParameterUtils.getAuditPageParameterSet(paramSet, parameterElementDataService, parameterDataService);

                    auditPageConsumed.auditPageEvent(message, parameters, referentiel, level);
                }
            } else if (messagesType.equals("Rest") && messageConsumerLimit.getCurrentNumberMessagesRest() < 3) {
                String message = new String(it.next().message(), StandardCharsets.UTF_8);
                logger.debug("[AUDIT][IN] A message have been received..." + message);
                if (MessageRest.isValide(message)) {
                    messageConsumerLimit.messageRestConsumed();
                    logger.debug("number of messages from consumer Rest : " + messageConsumerLimit.getCurrentNumberMessagesRest());
                    logger.debug("[AUDIT][IN] URL received Rest ..." + MessageRest.getUrl(message));
                    if (MessageRest.getReferentiel(message).equals("")) {
                        referentiel = ref;
                    } else {
                        referentiel = MessageRest.getReferentiel(message);
                    }
                    if (MessageRest.getLevel(message).equals("")) {
                        level = this.level;
                    } else {
                        level = MessageRest.getLevel(message);
                    }

                    Set<Parameter> paramSet = ParameterUtils.getParameterSetFromAuditLevel(referentiel,
                            level, parameterElementDataService, parameterDataService);

                    Set<Parameter> parameters = ParameterUtils.getAuditPageParameterSet(paramSet, parameterElementDataService, parameterDataService);

                    logger.debug("getTblMarker ..." + MessageRest.getDtTblMarker(message));
                    logger.debug("getCplxTblMarker ..." + MessageRest.getCplxTblMarker(message));
                    logger.debug("getPrTblMarker ..." + MessageRest.getPrTblMarker(message));
                    logger.debug("getDcrImgMarker ..." + MessageRest.getDcrImgMarker(message));
                    logger.debug("getInfImgMarker ..." + MessageRest.getInfImgMarker(message));

                    logger.debug("getScreenWidth ..." + MessageRest.getScreenWidth(message));
                    logger.debug("getScreenHeight ..." + MessageRest.getScreenHeight(message));
                    logger.debug("getDescriptionRef ..." + MessageRest.getDescriptionRef(message));
                    logger.debug("getHtmlTags ..." + MessageRest.getHtmlTags(message));

                    ParameterUtils.initializePAInputOptions(MessageRest.getDtTblMarker(message), MessageRest.getCplxTblMarker(message), MessageRest.getPrTblMarker(message),
                            MessageRest.getDcrImgMarker(message), MessageRest.getInfImgMarker(message), MessageRest.getScreenWidth(message).toString(),
                            MessageRest.getScreenHeight(message).toString(), parameters);

                    auditPageConsumed.auditPageRest(message, parameters, referentiel, level);
                }
            }
        }
        logger.error("Shutting down Thread: " + m_threadNumber);
    }
}
