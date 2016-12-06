/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tanaguru.kafka.messaging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Enumeration;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.tanaguru.entity.audit.Audit;
import org.tanaguru.entity.parameterization.Parameter;
import org.tanaguru.entity.service.parameterization.ParameterDataService;
import org.tanaguru.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.entity.service.audit.AuditDataService;
import org.tanaguru.entity.service.audit.ProcessRemarkDataService;
import org.tanaguru.entity.service.audit.ProcessResultDataService;
import org.tanaguru.entity.service.parameterization.ParameterElementDataService;
import org.tanaguru.entity.service.statistics.WebResourceStatisticsDataService;
import org.tanaguru.entity.service.subject.WebResourceDataService;
import org.tanaguru.kafka.util.AuditPageConsumed;
//import org.tanaguru.kafka.util.IPAddressValidator;
import org.tanaguru.kafka.util.MessageKafka;
import org.tanaguru.kafka.util.ParameterUtils;
import org.tanaguru.service.AuditServiceListener;
import org.springframework.context.support.DelegatingMessageSource;
import org.tanaguru.entity.service.audit.ContentDataService;
import org.tanaguru.kafka.util.ExposedResourceMessageBundleSource;

/**
 *
 * @author omokeddem at oceaneconsulting
 *
 */
@Component
//@Scope("prototype")
public class MessagesConsumer {

    private final ConsumerConnector consumer;
    private final String topic;
    private final int numThread;
    private final String messagesType;
    private ExecutorService executor;

    private AuditService auditService;
    private AuditDataService auditDataService;
    private WebResourceDataService webResourceDataService;
    private WebResourceStatisticsDataService webResourceStatisticsDataService;
    private ProcessResultDataService processResultDataService;
    private ProcessRemarkDataService processRemarkDataService;
    private ParameterDataService parameterDataService;
    private ParameterElementDataService parameterElementDataService;
    private ContentDataService contentDataService;
    private ExposedResourceMessageBundleSource referentialAw22Theme;
    private ExposedResourceMessageBundleSource referentialAw22Criterion;
    private ExposedResourceMessageBundleSource referentialAw22Rule;
    private ExposedResourceMessageBundleSource referentialRgaa2Theme;
    private ExposedResourceMessageBundleSource referentialRgaa2Criterion;
    private ExposedResourceMessageBundleSource referentialRgaa2Rule;
    private ExposedResourceMessageBundleSource referentialRgaa3Theme;
    private ExposedResourceMessageBundleSource referentialRgaa3Criterion;
    private ExposedResourceMessageBundleSource referentialRgaa3Rule;
    private ExposedResourceMessageBundleSource referentialRgaa32016Theme;
    private ExposedResourceMessageBundleSource referentialRgaa32016Criterion;
    private ExposedResourceMessageBundleSource referentialRgaa32016Rule;
    private ExposedResourceMessageBundleSource remarkMessage;

    private String ref;
    private String level;

    private MessagesProducer messagesProducer;

    private String dbHost;
    private String dbPort;
    private String dbUserName;
    private String dbPassword;
    private String dbName;
    private String dbUrl;
    private String w3cValidatorHome;
    private String java8Home;

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(MessagesConsumer.class);

    public void setAuditService(AuditService auditService) {
        this.auditService = auditService;
    }

    public void setParameterDataService(ParameterDataService parameterDataService) {
        this.parameterDataService = parameterDataService;
    }

    public void setAuditDataService(AuditDataService auditDataService) {
        this.auditDataService = auditDataService;

    }

    public void setWebResourceDataService(WebResourceDataService webResourceDataService) {
        this.webResourceDataService = webResourceDataService;
    }

    public void setWebResourceStatisticsDataService(WebResourceStatisticsDataService webResourceStatisticsDataService) {
        this.webResourceStatisticsDataService = webResourceStatisticsDataService;
    }

    public void setProcessRemarkDataService(ProcessRemarkDataService processRemarkDataService) {
        this.processRemarkDataService = processRemarkDataService;
    }

    public void setProcessResultDataService(ProcessResultDataService processResultDataService) {
        this.processResultDataService = processResultDataService;
    }

    public void setParameterElementDataService(ParameterElementDataService parameterElementDataService) {
        this.parameterElementDataService = parameterElementDataService;
    }

    public void setContentDataService(ContentDataService contentDataService) {
        this.contentDataService = contentDataService;
    }

    public void setReferentialAw22Theme(ExposedResourceMessageBundleSource referentialAw22Theme) {
        this.referentialAw22Theme = referentialAw22Theme;
    }

    public void setReferentialAw22Criterion(ExposedResourceMessageBundleSource referentialAw22Criterion) {
        this.referentialAw22Criterion = referentialAw22Criterion;
    }

    public void setReferentialAw22Rule(ExposedResourceMessageBundleSource referentialAw22Rule) {
        this.referentialAw22Rule = referentialAw22Rule;
    }

    public void setReferentialRgaa2Theme(ExposedResourceMessageBundleSource referentialRgaa2Theme) {
        this.referentialRgaa2Theme = referentialRgaa2Theme;
    }

    public void setReferentialRgaa2Criterion(ExposedResourceMessageBundleSource referentialRgaa2Criterion) {
        this.referentialRgaa2Criterion = referentialRgaa2Criterion;
    }

    public void setReferentialRgaa2Rule(ExposedResourceMessageBundleSource referentialRgaa2Rule) {
        this.referentialRgaa2Rule = referentialRgaa2Rule;
    }

    public void setReferentialRgaa3Theme(ExposedResourceMessageBundleSource referentialRgaa3Theme) {
        this.referentialRgaa3Theme = referentialRgaa3Theme;
    }

    public void setReferentialRgaa3Criterion(ExposedResourceMessageBundleSource referentialRgaa3Criterion) {
        this.referentialRgaa3Criterion = referentialRgaa3Criterion;
    }

    public void setReferentialRgaa3Rule(ExposedResourceMessageBundleSource referentialRgaa3Rule) {
        this.referentialRgaa3Rule = referentialRgaa3Rule;
    }

    public void setReferentialRgaa32016Theme(ExposedResourceMessageBundleSource referentialRgaa32016Theme) {
        this.referentialRgaa32016Theme = referentialRgaa32016Theme;
    }

    public void setReferentialRgaa32016Criterion(ExposedResourceMessageBundleSource referentialRgaa32016Criterion) {
        this.referentialRgaa32016Criterion = referentialRgaa32016Criterion;
    }

    public void setReferentialRgaa32016Rule(ExposedResourceMessageBundleSource referentialRgaa32016Rule) {
        this.referentialRgaa32016Rule = referentialRgaa32016Rule;
    }

    public void setRemarkMessage(ExposedResourceMessageBundleSource remarkMessage) {
        this.remarkMessage = remarkMessage;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setMessagesProducer(MessagesProducer messagesProducer) {
        this.messagesProducer = messagesProducer;
    }

    public void setDbUserName(String username) {
        this.dbUserName = username;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public void setDbUrl(String mysqlUrl) {
        this.dbUrl = mysqlUrl;
        this.dbPort = MessageKafka.getDbPort(dbUrl);
        this.dbName = MessageKafka.getDbName(dbUrl);
        this.dbHost = MessageKafka.getDbHost(dbUrl);
    }

    public MessagesConsumer(String a_zookeeper, String a_groupId, String a_topic, int a_numThreads, String a_messagesType) throws MalformedURLException, IOException {
        this.consumer = kafka.consumer.Consumer
                .createJavaConsumerConnector(createConsumerConfig(a_zookeeper, a_groupId));

        this.topic = a_topic;
        this.numThread = a_numThreads;
        this.messagesType = a_messagesType;
    }

    public void shutdown() {
        if (consumer != null) {
            consumer.shutdown();
        }
        if (executor != null) {
            executor.shutdown();
        }
        try {
            if (!executor.awaitTermination(5000, TimeUnit.MILLISECONDS)) {
                logger.error("Timed out waiting for consumer threads to shut down, exiting uncleanly");
            }
        } catch (InterruptedException e) {
            logger.error("Interrupted during shutdown, exiting uncleanly");
        }
    }

    public void createStreamConsumed(String topic, int numThread, String messagesType) {
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic, new Integer(numThread));
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer
                .createMessageStreams(topicCountMap);
        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topic);

        // now launch all the threads
        //
        AuditPageConsumed auditPageConsumed = new AuditPageConsumed(parameterDataService, auditService, parameterElementDataService,
                auditDataService, processResultDataService, webResourceDataService, webResourceStatisticsDataService, processRemarkDataService, contentDataService,
                messagesProducer, referentialAw22Theme, referentialAw22Criterion, referentialAw22Rule,
                referentialRgaa2Theme, referentialRgaa2Criterion, referentialRgaa2Rule,
                referentialRgaa3Theme, referentialRgaa3Criterion, referentialRgaa3Rule,
                referentialRgaa32016Theme, referentialRgaa32016Criterion, referentialRgaa32016Rule,
                remarkMessage, dbHost, dbPort, dbUserName, dbPassword, dbName);

        executor = Executors.newFixedThreadPool(numThread);

        // now create an object to consume the messages
        //
        int threadNumber = 0;
        Consumer consumer = null;
        for (final KafkaStream stream : streams) {
            consumer = new Consumer(stream, threadNumber, messagesType, parameterDataService, auditService,
                    parameterElementDataService, auditDataService, processResultDataService, auditPageConsumed, ref, level);
            ExecutorService es = Executors.newCachedThreadPool();
            es.execute(consumer);
            es.shutdown();
            try {
                boolean finshed = es.awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            threadNumber++;
        }
    }

    public void messageConsumed() throws Exception {
        if (topic != null && !topic.equals("")) {
            createStreamConsumed(topic, numThread, messagesType);
        }
    }

    private static ConsumerConfig createConsumerConfig(String a_zookeeper,
            String a_groupId) {
        Properties props = new Properties();
        props.put("zookeeper.connect", a_zookeeper);
        props.put("group.id", a_groupId);
        props.put("partition.assignment.strategy", "roundrobin");
        props.put("zookeeper.session.timeout.ms", "2000");
        props.put("rebalance.backoff.ms", "2000");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "300");
        //props.put("auto.offset.reset", "smallest");

        return new ConsumerConfig(props);
    }

}
