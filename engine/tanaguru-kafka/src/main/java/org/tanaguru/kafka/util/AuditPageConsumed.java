/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tanaguru.kafka.util;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.tanaguru.entity.audit.Audit;
import org.tanaguru.entity.audit.AuditStatus;
import org.tanaguru.entity.audit.ProcessRemark;
import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.entity.audit.SourceCodeRemark;
import org.tanaguru.entity.parameterization.Parameter;
import org.tanaguru.entity.service.audit.AuditDataService;
import org.tanaguru.entity.service.audit.ProcessResultDataService;
import org.tanaguru.entity.service.parameterization.ParameterDataService;
import org.tanaguru.entity.service.parameterization.ParameterElementDataService;
import org.tanaguru.entity.service.audit.ProcessRemarkDataService;
import org.tanaguru.entity.service.statistics.WebResourceStatisticsDataService;
import org.tanaguru.entity.service.subject.WebResourceDataService;
import org.tanaguru.entity.statistics.WebResourceStatistics;
import org.tanaguru.kafka.messaging.MessagesProducer;
import org.tanaguru.service.AuditService;
import org.tanaguru.service.AuditServiceListener;

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
    private ProcessRemarkDataService processRemarkDataService;
    private WebResourceStatisticsDataService webResourceStatisticsDataService;
    private WebResourceDataService webResourceDataService;
    private MessagesProducer messagesProducer;
    private ReloadableResourceBundleMessageSource messageSource;

    private String dbHost;
    private String dbPort;
    private String dbUserName;
    private String dbPassWord;
    private String dbName;

    private HashMap<Long, String> auditType = new HashMap<Long, String>();
    private HashMap<Long, String> tagsByAudit = new HashMap<Long, String>();
    private HashMap<Long, String> auditHash = new HashMap<Long, String>();
    private HashMap<Long, String> auditName = new HashMap<Long, String>();
    private HashMap<Long, String> auditUrl = new HashMap<Long, String>();
    private HashMap<Long, String> auditRef = new HashMap<Long, String>();
    private HashMap<Long, String> auditLevel = new HashMap<Long, String>();
    private HashMap<Long, String> auditLanguage = new HashMap<Long, String>();

    private String compaignHash;

    private MessageConsumerLimit messageConsumerLimit;

    private final char Separator = ((char) 007);

    private static final Logger logger = Logger.getLogger(AuditPageConsumed.class);

    public void setMessageConsumerLimit(MessageConsumerLimit _messageConsumerLimit) {
        this.messageConsumerLimit = _messageConsumerLimit;
        this.messageConsumerLimit.setCurrentNumberMessagesEvent(0);
        this.messageConsumerLimit.setCurrentNumberMessagesRest(0);
    }

    public AuditPageConsumed(ParameterDataService a_parameterDataService, AuditService a_auditService,
            ParameterElementDataService a_parameterElementDataService, AuditDataService a_auditDataService,
            ProcessResultDataService a_processResultDataService, WebResourceDataService a_webResourceDataService,
            WebResourceStatisticsDataService a_webResourceStatisticsDataService, ProcessRemarkDataService a_processRemarkDataService,
            MessagesProducer a_messagesProducer, ReloadableResourceBundleMessageSource a_messageSource, String a_dbHost, String a_dbPort, String a_dbUserName, String a_dbPassWord, String a_dbName) {

        parameterDataService = a_parameterDataService;
        auditService = a_auditService;
        parameterElementDataService = a_parameterElementDataService;
        auditDataService = a_auditDataService;
        processResultDataService = a_processResultDataService;
        webResourceDataService = a_webResourceDataService;
        webResourceStatisticsDataService = a_webResourceStatisticsDataService;
        processRemarkDataService = a_processRemarkDataService;

        messagesProducer = a_messagesProducer;
        messageSource = a_messageSource;

        dbHost = a_dbHost;
        dbPort = a_dbPort;
        dbUserName = a_dbUserName;
        dbPassWord = a_dbPassWord;
        dbName = a_dbName;

        auditService.add(this);
    }

    public JSONObject createAuditJson(Audit audit) throws JSONException {

        JSONObject auditJson = new JSONObject();
        String language = auditLanguage.get(audit.getId());

        auditJson.put("url", auditUrl.get(audit.getId()));
        auditJson.put("status", audit.getStatus());
        auditJson.put("ref", auditRef.get(audit.getId()));
        auditJson.put("level", auditLevel.get(audit.getId()));
        auditJson.put("language", auditLanguage.get(audit.getId()));
        if (audit.getStatus() == AuditStatus.COMPLETED) {
            List<ProcessResult> processResultList = (List<ProcessResult>) processResultDataService.getNetResultFromAudit(audit);
            WebResourceStatistics webResourceStatistics = webResourceStatisticsDataService.getWebResourceStatisticsByWebResource(audit.getSubject());
            int rank = audit.getSubject().getRank();
            auditJson.put("score", webResourceStatistics.getRawMark());
            auditJson.put("nb_passed", webResourceStatistics.getNbOfPassed());
            auditJson.put("nb_failed", webResourceStatistics.getNbOfFailed());
            auditJson.put("nb_nmi", webResourceStatistics.getNbOfNmi());
            auditJson.put("nb_na", webResourceStatistics.getNbOfNa());
            auditJson.put("nb_failed_occurences", webResourceStatistics.getNbOfFailedOccurences());
            auditJson.put("nb_detected", webResourceStatistics.getNbOfDetected());
            auditJson.put("http_status_code", webResourceStatistics.getHttpStatusCode());
            auditJson.put("nb_suspected", webResourceStatistics.getNbOfSuspected());
            auditJson.put("nb_not_tested", webResourceStatistics.getNbOfNotTested());

//            JSONArray testArray = new JSONArray();
            JSONArray remarkArray = new JSONArray();
            JSONArray testPassedArray = new JSONArray();
            JSONArray testNAArray = new JSONArray();
            JSONObject themesFr = new JSONObject();
            JSONObject themesEn = new JSONObject();
            JSONObject themesEs = new JSONObject();
            JSONObject criterionsFr = new JSONObject();
            JSONObject criterionsEn = new JSONObject();
            JSONObject testsFr = new JSONObject();
            JSONObject testsEn = new JSONObject();

            for (ProcessResult result : processResultList) {
                // create testPassed object from ProcessResult
                JSONObject testPassedObject = new JSONObject();
                if (result.getValue().toString().equals("PASSED")) {
                    putDescriptionLanguage(result, testPassedObject, themesFr, themesEn, themesEs, criterionsFr, criterionsEn, testsFr, testsEn, language);
                    testPassedArray.put(testPassedObject);
                }

                // create testNA object from ProcessResult 
                JSONObject testNAObject = new JSONObject();
                if (result.getValue().toString().equals("NOT_APPLICABLE")) {
                    putDescriptionLanguage(result, testNAObject, themesFr, themesEn, themesEs, criterionsFr, criterionsEn, testsFr, testsEn, language);
                    testNAArray.put(testNAObject);
                }
                // get remark from processResult & create array of remark
                Set<ProcessRemark> processRemarkList = (Set<ProcessRemark>) processRemarkDataService.findProcessRemarksFromProcessResult(result, -1);
                for (ProcessRemark processRemark : processRemarkList) {
                    JSONObject remarkObject = new JSONObject();
                    String remark_fr = StringEscapeUtils.unescapeHtml4(messageSource.getMessage(processRemark.getMessageCode(), null, Locale.FRENCH));
                    String remark_en = StringEscapeUtils.unescapeHtml4(messageSource.getMessage(processRemark.getMessageCode(), null, Locale.ENGLISH));
                    String remark_es = StringEscapeUtils.unescapeHtml4(messageSource.getMessage(processRemark.getMessageCode(), null, new Locale("es")));
                    if (processRemark instanceof SourceCodeRemark) {
                        remarkObject.put("issue", processRemark.getIssue());
                        if (language.equals("fr") || language.equals("all")) {
                            remarkObject.put("message_fr", remark_fr);
                        }
                        if (language.equals("en") || language.equals("all")) {
                            remarkObject.put("message_en", remark_en);
                        }
                        if (language.equals("es_fr") || language.equals("es_en") || language.equals("all")) {
                            remarkObject.put("message_es", remark_es);
                        }
                        remarkObject.put("target", ((SourceCodeRemark) processRemark).getTarget());
                        remarkObject.put("line_number", ((SourceCodeRemark) processRemark).getLineNumber());
                        StringBuilder snippet = new StringBuilder("");
                        if (((SourceCodeRemark) processRemark).getSnippet() != null) {
                            String snippetDirty = ((SourceCodeRemark) processRemark).getSnippet();
                            snippet.append(StringEscapeUtils.unescapeHtml4(snippetDirty));
                        }
                        remarkObject.put("snippet", snippet);
                    } else {
                        remarkObject.put("issue", processRemark.getIssue());
                        if (language.equals("fr") || language.equals("all")) {
                            remarkObject.put("message_fr", remark_fr);
                        }
                        if (language.equals("en") || language.equals("all")) {
                            remarkObject.put("message_en", remark_en);
                        }
                        if (language.equals("es_fr") || language.equals("es_en") || language.equals("all")) {
                            remarkObject.put("message_es", remark_es);
                        }
                    }
                    putDescriptionLanguage(result, remarkObject, themesFr, themesEn, themesEs, criterionsFr, criterionsEn, testsFr, testsEn, language);
                    remarkArray.put(remarkObject);
                }
            }
            auditJson.put("remarks", remarkArray);
            auditJson.put("test_passed", testPassedArray);
            auditJson.put("test_na", testNAArray);
            if(themesFr.length()!=0)
            auditJson.put("themes_description_fr", themesFr);
            if(themesEn.length()!=0)
            auditJson.put("themes_description_en", themesEn);
            if(themesEs.length()!=0)
            auditJson.put("themes_description_es", themesEs);
            if(criterionsFr.length()!=0)
            auditJson.put("criterions_description_fr", criterionsFr);
            if(criterionsEn.length()!=0)
            auditJson.put("criterions_description_en", criterionsEn);
            if(testsFr.length()!=0)
            auditJson.put("tests_description_fr", testsFr);
            if(testsEn.length()!=0)
            auditJson.put("tests_description_en", testsEn);   
        }
        return auditJson;
    }

    public void putDescriptionLanguage(ProcessResult result, JSONObject remarkObject, JSONObject themesFr, JSONObject themesEn, JSONObject themesEs,
            JSONObject criterionsFr, JSONObject criterionsEn, JSONObject testsFr, JSONObject testsEn, String language) throws JSONException {
        String codeTest = result.getTest().getCode();
        String codeCriterion = result.getTest().getCriterion().getCode();
        String codeTheme = result.getTest().getCriterion().getTheme().getCode();
        if (language.equals("fr") || language.equals("all")) {
            remarkObject.put("theme", codeTheme);
            themesFr.put(codeTheme, StringEscapeUtils.unescapeHtml4(messageSource.getMessage(codeTheme, null, Locale.FRENCH)));
        }
        if (language.equals("en") || language.equals("all")) {
            remarkObject.put("theme", codeTheme);
            themesEn.put(codeTheme, StringEscapeUtils.unescapeHtml4(messageSource.getMessage(codeTheme, null, Locale.ENGLISH)));
        }
        if (language.equals("es_fr") || language.equals("es_en") || language.equals("all")) {
            remarkObject.put("theme", codeTheme);
            themesEs.put(codeTheme, messageSource.getMessage(codeTheme, null, new Locale("es")));
        }
        if (language.equals("fr") || language.equals("es_fr") || language.equals("all")) {
            remarkObject.put("test", codeTest);
            testsFr.put(codeTest, StringEscapeUtils.unescapeHtml4(messageSource.getMessage(codeTest, null, Locale.FRENCH)));
            remarkObject.put("criterion", codeCriterion);
            criterionsFr.put(codeCriterion, StringEscapeUtils.unescapeHtml4(messageSource.getMessage(codeCriterion, null, Locale.FRENCH)));
        }
        if (language.equals("en") || language.equals("es_en") || language.equals("all")) {
            remarkObject.put("test", codeTest);
            testsEn.put(codeTest, StringEscapeUtils.unescapeHtml4(messageSource.getMessage(codeTest, null, Locale.ENGLISH)));
            remarkObject.put("criterion", codeCriterion);
            criterionsEn.put(codeCriterion, StringEscapeUtils.unescapeHtml4(messageSource.getMessage(codeCriterion, null, Locale.ENGLISH)));
        }
    }

    @Override
    public void auditCompleted(Audit audit
    ) {
        try {
            if (auditType.get(audit.getId()) != null) {
                String messageToSend = "";
                audit = auditDataService.read(audit.getId());

                if (auditType.get(audit.getId()).equals("Rest")) {
                    JSONObject auditJson = createAuditJson(audit);
                    messageToSend = auditHash.get(audit.getId()) + Separator + auditJson;
                    auditUrl.remove(audit.getId());
                    auditType.remove(audit.getId());
                    auditRef.remove(audit.getId());
                    auditLevel.remove(audit.getId());
                    auditLanguage.remove(audit.getId());
                    auditHash.remove(audit.getId());
                    messageConsumerLimit.messageRestAudited();
                } else if (auditType.get(audit.getId()).equals("Event")) {

                    messageToSend = dbHost + ";" + dbPort + ";" + dbUserName + ";" + dbPassWord + ";" + dbName
                            + ";" + audit.getId() + ";" + tagsByAudit.get(audit.getId()) + ";" + auditName.get(audit.getId())
                            + ";" + auditUrl.get(audit.getId()) + ";" + auditHash.get(audit.getId()) + ";" + compaignHash + ";" + audit.getStatus();

                    tagsByAudit.remove(audit.getId());
                    auditHash.remove(audit.getId());
                    auditName.remove(audit.getId());
                    auditUrl.remove(audit.getId());
                    auditType.remove(audit.getId());
                    auditRef.remove(audit.getId());
                    auditLevel.remove(audit.getId());
                    messageConsumerLimit.messageEventAudited();
                }
                messagesProducer.sendMessage(messageToSend);
            }
        } catch (Exception ex) {
            logger.error("Producer Message Kafka ERROR : " + ex);
        }
    }

    @Override
    public void auditCrashed(Audit audit, Exception exception
    ) { //To change body of generated methods, choose Tools | Templates.
        logger.error("crash (id+message): " + audit.getId() + " " + exception.toString());
        if (auditType.get(audit.getId()).equals("Event")) {
            messageConsumerLimit.messageEventAudited();
        } else if (auditType.get(audit.getId()).equals("Rest")) {
            messageConsumerLimit.messageRestAudited();
        }
        tagsByAudit.remove(audit.getId());
        auditHash.remove(audit.getId());
        auditName.remove(audit.getId());
        auditUrl.remove(audit.getId());
        auditType.remove(audit.getId());
        auditRef.remove(audit.getId());
        auditLevel.remove(audit.getId());
        auditLanguage.remove(audit.getId());
    }

    public void auditPageEvent(String message, Set<Parameter> parameters, String ref, String level) {
        compaignHash = MessageEvent.getIdCampagne(message);
        Audit audit = auditService.auditPage(MessageEvent.getUrl(message), parameters);
        auditType.put(audit.getId(), "Event");
        tagsByAudit.put(audit.getId(), MessageEvent.getTags(message));
        auditHash.put(audit.getId(), MessageEvent.getHashAudit(message));
        auditName.put(audit.getId(), MessageEvent.getName(message));
        auditUrl.put(audit.getId(), MessageEvent.getUrl(message));
        auditRef.put(audit.getId(), ref);
        auditLevel.put(audit.getId(), level);
    }

    public void auditPageRest(String message, Set<Parameter> parameters, String ref, String level) {
        Audit audit = auditService.auditPage(MessageRest.getUrl(message), parameters);
        auditType.put(audit.getId(), "Rest");
        auditUrl.put(audit.getId(), MessageRest.getUrl(message));
        auditRef.put(audit.getId(), ref);
        auditLevel.put(audit.getId(), level);
        auditHash.put(audit.getId(), MessageRest.getHashAudit(message));
        auditLanguage.put(audit.getId(), MessageRest.getLanguage(message));
    }
}
