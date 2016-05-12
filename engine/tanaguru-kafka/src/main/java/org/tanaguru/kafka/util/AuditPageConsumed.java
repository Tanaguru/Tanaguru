/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tanaguru.kafka.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.xml.parsers.ParserConfigurationException;
import kafka.consumer.KafkaStream;
import org.apache.log4j.Logger;
import org.tanaguru.entity.audit.Audit;
import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.entity.parameterization.Parameter;
import org.tanaguru.entity.service.audit.AuditDataService;
import org.tanaguru.entity.service.audit.ProcessResultDataService;
import org.tanaguru.entity.service.parameterization.ParameterDataService;
import org.tanaguru.entity.service.parameterization.ParameterElementDataService;
import org.tanaguru.kafka.messaging.Consumer;
import org.tanaguru.kafka.messaging.MessagesProducer;
import org.tanaguru.service.AuditService;
import org.tanaguru.service.AuditServiceListener;
import org.xml.sax.SAXException;

/**
 *
 * @author omokeddem at oceaneconsulting
 *
 */
public class AuditPageConsumed implements AuditServiceListener {

    private ParameterDataService parameterDataService;
    private AuditService auditService;
    private ParameterElementDataService parameterElementDataService;
    private AuditDataService auditDataService;
    private ProcessResultDataService processResultDataService;
    private MessagesProducer messagesProducer;

    private String dbHost;
    private String dbPort;
    private String dbUserName;
    private String dbPassWord;
    private String dbName;

    private HashMap<Long, String> tagsByAudit = new HashMap<Long, String>();
    private HashMap<Long, String> auditHash = new HashMap<Long, String>();
    private HashMap<Long, String> auditName = new HashMap<Long, String>();
    private HashMap<Long, String> auditUrl = new HashMap<Long, String>();

    private String compaignHash;

    private MessageConsumerLimit messageConsumerLimit;

    private static final Logger logger = Logger.getLogger(AuditPageConsumed.class);

    public void setMessageConsumerLimit(MessageConsumerLimit _messageConsumerLimit) {
        this.messageConsumerLimit = _messageConsumerLimit;
        this.messageConsumerLimit.setCurrentNumberMessages(0);
    }

    public AuditPageConsumed(ParameterDataService a_parameterDataService, AuditService a_auditService,
            ParameterElementDataService a_parameterElementDataService, AuditDataService a_auditDataService,
            ProcessResultDataService a_processResultDataService, MessagesProducer a_messagesProducer,
            String a_dbHost, String a_dbPort, String a_dbUserName, String a_dbPassWord, String a_dbName) {

        parameterDataService = a_parameterDataService;
        auditService = a_auditService;
        parameterElementDataService = a_parameterElementDataService;
        auditDataService = a_auditDataService;
        processResultDataService = a_processResultDataService;

        messagesProducer = a_messagesProducer;

        dbHost = a_dbHost;
        dbPort = a_dbPort;
        dbUserName = a_dbUserName;
        dbPassWord = a_dbPassWord;
        dbName = a_dbName;

        auditService.add(this);
    }

    @Override
    public void auditCompleted(Audit audit) {
        audit = auditDataService.read(audit.getId());
        List<ProcessResult> processResultList = (List<ProcessResult>) processResultDataService.getNetResultFromAudit(audit);

//        logger.info("Audit terminated with success at " + audit.getDateOfCreation());
//        logger.info("Audit Id : " + audit.getId());
        try {
            String messageToSend = dbHost + ";" + dbPort + ";" + dbUserName + ";" + dbPassWord + ";" + dbName
                    + ";" + audit.getId() + ";" + tagsByAudit.get(audit.getId()) + ";" + auditName.get(audit.getId())
                    + ";" + auditUrl.get(audit.getId()) + ";" + auditHash.get(audit.getId()) + ";" + compaignHash + ";" + audit.getStatus();
            messagesProducer.sendMessage(messageToSend);
            tagsByAudit.remove(audit.getId());
            auditHash.remove(audit.getId());
            auditName.remove(audit.getId());
            auditUrl.remove(audit.getId());
            messageConsumerLimit.messageAudited();
        } catch (Exception ex) {
            logger.error("Producer Message Kafka ERROR : " + ex);
            messageConsumerLimit.messageAudited();
        }
    }

    @Override
    public void auditCrashed(Audit audit, Exception exception) { //To change body of generated methods, choose Tools | Templates.

        logger.error("crash (id+message): " + audit.getId() + " " + exception.fillInStackTrace());
        messageConsumerLimit.messageAudited();
    }

    public void auditPage(String message, Set<Parameter> parameters) {

        compaignHash = MessageKafka.getIdCampagne(message);
        Audit audit = auditService.auditPage(MessageKafka.getUrl(message), parameters);
        tagsByAudit.put(audit.getId(), MessageKafka.getTags(message));
        auditHash.put(audit.getId(), MessageKafka.getHashAudit(message));
        auditName.put(audit.getId(), MessageKafka.getName(message));
        auditUrl.put(audit.getId(), MessageKafka.getUrl(message));

    }
}
