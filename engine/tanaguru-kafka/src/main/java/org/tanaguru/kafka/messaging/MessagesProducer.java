/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tanaguru.kafka.messaging;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import org.apache.log4j.Logger;

/**
 *
 * @author omokeddem at oceaneconsulting
 *
 */
public class MessagesProducer {

    public Producer<String, String> producer;
    public String topic;
    
     private static final Logger logger = Logger.getLogger(MessagesProducer.class);

    public MessagesProducer(String broker_list, String zookeeper, String topic_) {

        Properties props = new Properties();
        props.put("metadata.broker.list", broker_list);
        props.put("zk.connect", zookeeper);
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("request.required.acks", "1");
        props.put("request.timeout.ms","50000");
        topic = topic_;
        ProducerConfig config = new ProducerConfig(props);

        producer = new Producer<String, String>(config);
    }

    public void sendMessage(String message)
            throws ParserConfigurationException, SAXException, IOException,
            URISyntaxException {

        try {
            KeyedMessage<String, String> data = new KeyedMessage<String, String>(
                    topic,message, message);
            producer.send(data);
        } catch (Exception e) {
            logger.error("Error sending message Kafka");
        }
    }

    public void killProducer() {
        producer.close();
    }
}
