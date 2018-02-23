//package org.tanaguru.jms.messaging;
//
//import java.util.Set;
//
//import javax.jms.JMSException;
//import javax.jms.Session;
//import javax.jms.TextMessage;
//
//import org.apache.log4j.Logger;
//import org.tanaguru.entity.parameterization.Parameter;
//import org.tanaguru.entity.service.parameterization.ParameterDataService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.listener.SessionAwareMessageListener;
//import org.springframework.stereotype.Component;
//import org.tanaguru.entity.parameterization.ParameterElement;
//import org.tanaguru.entity.service.parameterization.ParameterElementDataService;
//import org.tanaguru.jms.util.ParameterUtils;
//import org.tanaguru.jms.util.ParameterUtilsAudit;
//import org.tanaguru.jsms.auditservicelistener.JmsAuditServiceListernerImpl;
//
///**
// * Session aware JMS message listener linked to audit out-coming queue.
// *
// *
// */
////@Component
//public class AuditListener implements SessionAwareMessageListener<TextMessage> {
//    
//   @Autowired
//    ParameterDataService parameterDataService;
//
//   @Autowired
//   JmsAuditServiceListernerImpl jmsAuditServiceListernerImpl; 
//   
//   
//   @Autowired
//    ParameterElementDataService parameterElementDataService;
//
//    /**
//     * logger
//     */
//    private static final Logger LOGGER = Logger.getLogger(AuditListener.class);
//
//	//private static Logger logger = LoggerFactory.getLogger(AuditListener.class);
//    /**
//     * Handle a message , within a JMS session.
//     */
//    @Override
//    public void onMessage(TextMessage pageURL, Session session) throws JMSException {
//
//       LOGGER.info("[AUDIT][IN] A message have been received...");
//
//        if (pageURL instanceof TextMessage) {
//
//            LOGGER.info("[AUDIT][IN] A message have been received..." + pageURL.getText());
//			//1- log in db message and type of audit
//            //2- format message to objet audit
//
//            LOGGER.info("Initialize parameters...");
//            //get parameters from DB
////            ParameterUtils.initParametersMap(parameterDataService);
////            //get default set of parameters
////            Set<Parameter> parameters = ParameterUtils.getDefaultParametersForPA();
////            //set option values
////            ParameterUtils.initializePAInputOptions("AW22;Ar", null, null, null, null, parameters);
//
//
//
//
//        ParameterElement levelParameterElement = parameterElementDataService.getParameterElement("LEVEL");
//        Parameter levelParameter = parameterDataService.getParameter(levelParameterElement, "Rgaa32016;LEVEL_2");
//        Set<Parameter> paramSet = parameterDataService.getDefaultParameterSet();
//        paramSet = parameterDataService.updateParameter(paramSet, levelParameter);
//
//        Set<Parameter> parameters = ParameterUtilsAudit.getAuditPageParameterSet(paramSet, parameterElementDataService, parameterDataService);
//
//        ParameterUtilsAudit.initializePAInputOptions(
//                "DATA_TABLE_MARKER",
//                "COMPLEX_TABLE_MARKER",
//                "PRESENTATION_TABLE_MARKER",
//                "DECORATIVE_IMAGE_MARKER",
//                "INFORMATIVE_IMAGE_MARKER",
//                "1200",
//                "960",
//                parameters);
//
//
//
//
////            LOGGER.info("Launch audit page service...");
//
//            //launch audit 
//            Long idAudit = jmsAuditServiceListernerImpl.launchAuditOnJmsMessageReceived(pageURL, parameters);
//            //3- persist audit information on db observatoire	
//           // Long idAudit = audit.getId();
//
//            LOGGER.info("Audit launched " + idAudit);
//
//        }
//    }
//}
