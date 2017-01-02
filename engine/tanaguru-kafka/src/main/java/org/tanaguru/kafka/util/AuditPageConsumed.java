/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tanaguru.kafka.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import javax.xml.parsers.ParserConfigurationException;
import kafka.consumer.KafkaStream;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.tanaguru.entity.audit.Audit;
import org.tanaguru.entity.audit.AuditStatus;
import org.tanaguru.entity.audit.EvidenceElement;
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
import org.tanaguru.kafka.messaging.Consumer;
import org.tanaguru.kafka.messaging.MessagesProducer;
import org.tanaguru.service.AuditService;
import org.tanaguru.service.AuditServiceListener;
import org.xml.sax.SAXException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.tanaguru.entity.audit.Content;
import org.tanaguru.entity.audit.RelatedContent;
import org.tanaguru.entity.audit.SSP;
import org.tanaguru.entity.dao.audit.ContentDAO;
import org.tanaguru.entity.service.audit.ContentDataService;
import org.tanaguru.entity.service.statistics.TestStatisticsDataService;

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
    private ContentDataService contentDataService;

    private TestStatisticsDataService testStatisticsDataService;

    private MessagesProducer messagesProducer;
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
    private HashMap<Long, Boolean> auditDescriptionRef = new HashMap<Long, Boolean>();
    private HashMap<Long, Integer> auditScreenWidth = new HashMap<Long, Integer>();
    private HashMap<Long, Integer> auditScreenHeight = new HashMap<Long, Integer>();
    private HashMap<Long, Boolean> auditHtmlTags = new HashMap<Long, Boolean>();

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
            ContentDataService a_contentDataService, MessagesProducer a_messagesProducer,
            ExposedResourceMessageBundleSource a_referentialAw22Theme, ExposedResourceMessageBundleSource a_referentialAw22Criterion,
            ExposedResourceMessageBundleSource a_referentialAw22Rule,
            ExposedResourceMessageBundleSource a_referentialRgaa2Theme, ExposedResourceMessageBundleSource a_referentialRgaa2Criterion,
            ExposedResourceMessageBundleSource a_referentialRgaa2Rule,
            ExposedResourceMessageBundleSource a_referentialRgaa3Theme, ExposedResourceMessageBundleSource a_referentialRgaa3Criterion,
            ExposedResourceMessageBundleSource a_referentialRgaa3Rule,
            ExposedResourceMessageBundleSource a_referentialRgaa32016Theme, ExposedResourceMessageBundleSource a_referentialRgaa32016Criterion,
            ExposedResourceMessageBundleSource a_referentialRgaa32016Rule,
            ExposedResourceMessageBundleSource a_remarkMessage,
            String a_dbHost, String a_dbPort, String a_dbUserName, String a_dbPassWord, String a_dbName) {

        parameterDataService = a_parameterDataService;
        auditService = a_auditService;
        parameterElementDataService = a_parameterElementDataService;
        auditDataService = a_auditDataService;
        processResultDataService = a_processResultDataService;
        webResourceDataService = a_webResourceDataService;
        webResourceStatisticsDataService = a_webResourceStatisticsDataService;
        processRemarkDataService = a_processRemarkDataService;
        contentDataService = a_contentDataService;
        messagesProducer = a_messagesProducer;
        referentialAw22Theme = a_referentialAw22Theme;
        referentialAw22Criterion = a_referentialAw22Criterion;
        referentialAw22Rule = a_referentialAw22Rule;
        referentialRgaa2Theme = a_referentialRgaa2Theme;
        referentialRgaa2Criterion = a_referentialRgaa2Criterion;
        referentialRgaa2Rule = a_referentialRgaa2Rule;
        referentialRgaa3Theme = a_referentialRgaa3Theme;
        referentialRgaa3Criterion = a_referentialRgaa3Criterion;
        referentialRgaa3Rule = a_referentialRgaa3Rule;
        referentialRgaa32016Theme = a_referentialRgaa32016Theme;
        referentialRgaa32016Criterion = a_referentialRgaa32016Criterion;
        referentialRgaa32016Rule = a_referentialRgaa32016Rule;
        remarkMessage = a_remarkMessage;

        dbHost = a_dbHost;
        dbPort = a_dbPort;
        dbUserName = a_dbUserName;
        dbPassWord = a_dbPassWord;
        dbName = a_dbName;

        auditService.add(this);
    }

    public Map<String, String> getMessages(ExposedResourceMessageBundleSource messageSource, Locale locale) {
        Properties properties = messageSource.getMessages(locale);
        Map<String, String> messagesMap = new HashMap<String, String>();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                messagesMap.put(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        return messagesMap;
    }

    public JSONObject getDescriptionFromRef(String Ref, String language, String entity, Boolean htmlTags) throws JSONException {
        JSONObject result = new JSONObject();

        Map<String, String> allMessages = null;
        switch (Ref) {
            case "Rgaa32016":
                switch (entity) {
                    case "Theme":
                        if (language.equals("fr")) {
                            allMessages = getMessages(referentialRgaa32016Theme, Locale.FRENCH);
                        } else if (language.equals("en")) {
                            allMessages = getMessages(referentialRgaa32016Theme, Locale.ENGLISH);
                        } else if (language.equals("es_fr") || language.equals("es_en")) {
                            allMessages = getMessages(referentialRgaa32016Theme, new Locale("es"));
                        }
                        break;
                    case "Criterion":
                        if (language.equals("fr") || language.equals("es_fr")) {
                            allMessages = getMessages(referentialRgaa32016Criterion, Locale.FRENCH);
                        } else if (language.equals("en") || language.equals("es_en")) {
                            allMessages = getMessages(referentialRgaa32016Criterion, Locale.ENGLISH);
                        }
                        break;
                    case "Rule":
                        if (language.equals("fr") || language.equals("es_fr")) {
                            allMessages = getMessages(referentialRgaa32016Rule, Locale.FRENCH);
                        } else if (language.equals("en") || language.equals("es_en")) {
                            allMessages = getMessages(referentialRgaa32016Rule, Locale.ENGLISH);
                        }
                        break;
                }
                break;
            case "Rgaa30":
                switch (entity) {
                    case "Theme":
                        if (language.equals("fr")) {
                            allMessages = getMessages(referentialRgaa3Theme, Locale.FRENCH);
                        } else if (language.equals("en")) {
                            allMessages = getMessages(referentialRgaa3Theme, Locale.ENGLISH);
                        } else if (language.equals("es_fr") || language.equals("es_en")) {
                            allMessages = getMessages(referentialRgaa3Theme, new Locale("es"));
                        }
                        break;
                    case "Criterion":
                        if (language.equals("fr") || language.equals("es_fr")) {
                            allMessages = getMessages(referentialRgaa3Criterion, Locale.FRENCH);
                        } else if (language.equals("en") || language.equals("es_en")) {
                            allMessages = getMessages(referentialRgaa3Criterion, Locale.ENGLISH);
                        }
                        break;
                    case "Rule":
                        if (language.equals("fr") || language.equals("es_fr")) {
                            allMessages = getMessages(referentialRgaa3Rule, Locale.FRENCH);
                        } else if (language.equals("en") || language.equals("es_en")) {
                            allMessages = getMessages(referentialRgaa3Rule, Locale.ENGLISH);
                        }
                        break;
                }
                break;
            case "Rgaa2":
                switch (entity) {
                    case "Theme":
                        if (language.equals("fr")) {
                            allMessages = getMessages(referentialRgaa2Theme, Locale.FRENCH);
                        } else if (language.equals("en")) {
                            allMessages = getMessages(referentialRgaa2Theme, Locale.ENGLISH);
                        } else if (language.equals("es_fr") || language.equals("es_en")) {
                            allMessages = getMessages(referentialRgaa2Theme, new Locale("es"));
                        }
                        break;
                    case "Criterion":
                        if (language.equals("fr") || language.equals("es_fr")) {
                            allMessages = getMessages(referentialRgaa2Criterion, Locale.FRENCH);
                        } else if (language.equals("en") || language.equals("es_en")) {
                            allMessages = getMessages(referentialRgaa2Criterion, Locale.ENGLISH);
                        }
                        break;
                    case "Rule":
                        if (language.equals("fr") || language.equals("es_fr")) {
                            allMessages = getMessages(referentialRgaa2Rule, Locale.FRENCH);
                        } else if (language.equals("en") || language.equals("es_en")) {
                            allMessages = getMessages(referentialRgaa2Rule, Locale.ENGLISH);
                        }
                        break;
                }
                break;
            case "Aw22":
                switch (entity) {
                    case "Theme":
                        if (language.equals("fr")) {
                            allMessages = getMessages(referentialAw22Theme, Locale.FRENCH);
                        } else if (language.equals("en")) {
                            allMessages = getMessages(referentialAw22Theme, Locale.ENGLISH);
                        } else if (language.equals("es_fr") || language.equals("es_en")) {
                            allMessages = getMessages(referentialAw22Theme, new Locale("es"));
                        }
                        break;
                    case "Criterion":
                        if (language.equals("fr") || language.equals("es_fr")) {
                            allMessages = getMessages(referentialAw22Criterion, Locale.FRENCH);
                        } else if (language.equals("en") || language.equals("es_en")) {
                            allMessages = getMessages(referentialAw22Criterion, Locale.ENGLISH);
                        }
                        break;
                    case "Rule":
                        if (language.equals("fr") || language.equals("es_fr")) {
                            allMessages = getMessages(referentialAw22Rule, Locale.FRENCH);
                        } else if (language.equals("en") || language.equals("es_en")) {
                            allMessages = getMessages(referentialAw22Rule, Locale.ENGLISH);
                        }
                        break;
                }
                break;
        }
        for (Map.Entry<String, String> entrySet : allMessages.entrySet()) {
            String key = entrySet.getKey();
            String value;
            if (htmlTags) {
                value = StringEscapeUtils.unescapeHtml4(entrySet.getValue());
            } else {
                value = Jsoup.parse(entrySet.getValue()).text();
            }
            result.put(key, value);
        }
        return result;
    }

    public JSONObject createAuditJson(Audit audit) throws JSONException, ParseException, URISyntaxException {

        JSONObject auditJson = new JSONObject();
        String language = auditLanguage.get(audit.getId());
        Boolean descriptionRef = auditDescriptionRef.get(audit.getId());
        String ref = auditRef.get(audit.getId());
        Boolean htmlTags = auditHtmlTags.get(audit.getId());
        auditJson.put("url", auditUrl.get(audit.getId()));
        auditJson.put("status", audit.getStatus());
        auditJson.put("ref", ref);
        auditJson.put("level", auditLevel.get(audit.getId()));
        auditJson.put("language", auditLanguage.get(audit.getId()));
        auditJson.put("screen_width", auditScreenWidth.get(audit.getId()));
        auditJson.put("screen_height", auditScreenHeight.get(audit.getId()));

        if (audit.getStatus() == AuditStatus.COMPLETED) {
            List<ProcessResult> processResultList = (List<ProcessResult>) processResultDataService.getNetResultFromAudit(audit);

            WebResourceStatistics webResourceStatistics = webResourceStatisticsDataService.getWebResourceStatisticsByWebResource(audit.getSubject());

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

            JSONArray remarkArray = new JSONArray();
            JSONArray testPassedArray = new JSONArray();
            JSONArray testNAArray = new JSONArray();
            JSONArray testNTArray = new JSONArray();

            JSONObject themesFr = new JSONObject();
            JSONObject themesEn = new JSONObject();
            JSONObject themesEs = new JSONObject();
            JSONObject criterionsFr = new JSONObject();
            JSONObject criterionsEn = new JSONObject();
            JSONObject testsFr = new JSONObject();
            JSONObject testsEn = new JSONObject();
            if (descriptionRef) {
                if (language.equals("fr") || language.equals("all")) {
                    themesFr = getDescriptionFromRef(ref, "fr", "Theme", htmlTags);
                }
                if (language.equals("en") || language.equals("all")) {
                    themesEn = getDescriptionFromRef(ref, "en", "Theme", htmlTags);
                }
                if (language.equals("es_fr") || language.equals("es_en") || language.equals("all")) {
                    themesEs = getDescriptionFromRef(ref, "es_en", "Theme", htmlTags);
                }
                if (language.equals("fr") || language.equals("es_fr") || language.equals("all")) {
                    testsFr = getDescriptionFromRef(ref, "fr", "Rule", htmlTags);
                    criterionsFr = getDescriptionFromRef(ref, "fr", "Criterion", htmlTags);
                }
                if (language.equals("en") || language.equals("es_en") || language.equals("all")) {
                    testsEn = getDescriptionFromRef(ref, "en", "Rule", htmlTags);
                    criterionsEn = getDescriptionFromRef(ref, "en", "Criterion", htmlTags);
                }
            }
            for (ProcessResult result : processResultList) {
                if (result.getTest().getLabel().equals("8.2.1")) {

                    auditJson.put("nb_w3c_invalidated", result.getElementCounter());
                }
                // create testPassed object from ProcessResult
                JSONObject testPassedObject = new JSONObject();
                if (result.getValue().toString().equals("PASSED")) {
                    putTests(result, testPassedObject);
                    testPassedArray.put(testPassedObject);
                }

                JSONObject testNTObject = new JSONObject();
                if (result.getValue().toString().equals("NOT_TESTED")) {
                    putTests(result, testNTObject);
                    testNTArray.put(testNTObject);
                }

                // create testNA object from ProcessResult 
                JSONObject testNAObject = new JSONObject();
                if (result.getValue().toString().equals("NOT_APPLICABLE")) {
                    putTests(result, testNAObject);
                    testNAArray.put(testNAObject);
                }
                // get remark from processResult & create array of remark
                int nbrRemarkW3c = 0;
                Set<ProcessRemark> processRemarkList = (Set<ProcessRemark>) processRemarkDataService.findProcessRemarksFromProcessResult(result, -1);
                for (ProcessRemark processRemark : processRemarkList) {

                    if (result.getTest().getLabel().equals("8.2.1")) {
                        if (nbrRemarkW3c < 10) {
                            nbrRemarkW3c++;
                        } else {
                            break;
                        }
                    }

                    JSONObject remarkObject = new JSONObject();
                    String remark_fr, remark_en, remark_es;
                    if (htmlTags) {
                        remark_fr = StringEscapeUtils.unescapeHtml4(remarkMessage.getMessage(processRemark.getMessageCode(), processRemark instanceof SourceCodeRemark ? new Object[]{((SourceCodeRemark) processRemark).getTarget()} : null, Locale.FRENCH));
                        remark_en = StringEscapeUtils.unescapeHtml4(remarkMessage.getMessage(processRemark.getMessageCode(), processRemark instanceof SourceCodeRemark ? new Object[]{((SourceCodeRemark) processRemark).getTarget()} : null, Locale.ENGLISH));
                        remark_es = StringEscapeUtils.unescapeHtml4(remarkMessage.getMessage(processRemark.getMessageCode(), processRemark instanceof SourceCodeRemark ? new Object[]{((SourceCodeRemark) processRemark).getTarget()} : null, new Locale("es")));
                    } else {
                        remark_fr = Jsoup.parse(remarkMessage.getMessage(processRemark.getMessageCode(), processRemark instanceof SourceCodeRemark ? new Object[]{((SourceCodeRemark) processRemark).getTarget()} : null, Locale.FRENCH)).text();
                        remark_en = Jsoup.parse(remarkMessage.getMessage(processRemark.getMessageCode(), processRemark instanceof SourceCodeRemark ? new Object[]{((SourceCodeRemark) processRemark).getTarget()} : null, Locale.ENGLISH)).text();
                        remark_es = Jsoup.parse(remarkMessage.getMessage(processRemark.getMessageCode(), processRemark instanceof SourceCodeRemark ? new Object[]{((SourceCodeRemark) processRemark).getTarget()} : null, new Locale("es"))).text();
                    }
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
                        //remarkObject.put("target", ((SourceCodeRemark) processRemark).getTarget());
                        remarkObject.put("line_number", ((SourceCodeRemark) processRemark).getLineNumber());
                        StringBuilder snippet = new StringBuilder("");
                        if (((SourceCodeRemark) processRemark).getSnippet() != null) {
                            String snippetDirty = ((SourceCodeRemark) processRemark).getSnippet();
                            if (htmlTags) {
                                snippet.append(StringEscapeUtils.unescapeHtml4(StringEscapeUtils.unescapeHtml4(snippetDirty.replace("\t", ""))));
                            } else {
                                snippet.append(snippetDirty.replace("\t", ""));
                            }
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
                    putTests(result, remarkObject);

                    remarkArray.put(remarkObject);
                }
            }
            auditJson.put("remarks", remarkArray);
            auditJson.put("test_passed", testPassedArray);
            auditJson.put("test_na", testNAArray);
            auditJson.put("test_nt", testNTArray);
            if (themesFr.length() != 0) {
                auditJson.put("themes_description_fr", themesFr);
            }
            if (themesEn.length() != 0) {
                auditJson.put("themes_description_en", themesEn);
            }
            if (themesEs.length() != 0) {
                auditJson.put("themes_description_es", themesEs);
            }
            if (criterionsFr.length() != 0) {
                auditJson.put("criterions_description_fr", criterionsFr);
            }
            if (criterionsEn.length() != 0) {
                auditJson.put("criterions_description_en", criterionsEn);
            }
            if (testsFr.length() != 0) {
                auditJson.put("tests_description_fr", testsFr);
            }
            if (testsEn.length() != 0) {
                auditJson.put("tests_description_en", testsEn);
            }
        }
        return auditJson;
    }

    public void putTests(ProcessResult result, JSONObject remarkObject) throws JSONException {
        String codeTest = result.getTest().getCode();
        String codeCriterion = result.getTest().getCriterion().getCode();
        String codeTheme = result.getTest().getCriterion().getTheme().getCode();
        remarkObject.put("theme", codeTheme);
        remarkObject.put("test", codeTest);
        remarkObject.put("criterion", codeCriterion);
    }

    @Override
    public void auditCompleted(Audit audit
    ) {
        try {
            if (auditType.get(audit.getId()) != null) {
                String messageToSend = "";
                audit = auditDataService.read(audit.getId());
                logger.debug("Audit terminated with success at " + audit.getDateOfCreation());

                if (auditType.get(audit.getId()).equals("Rest")) {
                    JSONObject auditJson = createAuditJson(audit);
                    messageToSend = auditHash.get(audit.getId()) + Separator + auditJson;
                    auditUrl.remove(audit.getId());
                    auditType.remove(audit.getId());
                    auditRef.remove(audit.getId());
                    auditLevel.remove(audit.getId());
                    auditLanguage.remove(audit.getId());
                    auditDescriptionRef.remove(audit.getId());
                    auditScreenWidth.remove(audit.getId());
                    auditScreenHeight.remove(audit.getId());
                    auditHtmlTags.remove(audit.getId());
                    auditHash.remove(audit.getId());
                    messageConsumerLimit.messageRestAudited();

                } else if (auditType.get(audit.getId()).equals("Event")) {

                    messageConsumerLimit.messageEventAudited();
                    int nbrW3cValidated = 0;
                    if (audit.getStatus() == AuditStatus.COMPLETED) {
                        List<ProcessResult> processResultList = (List<ProcessResult>) processResultDataService.getNetResultFromAudit(audit);
                        for (ProcessResult result : processResultList) {
                            if (result.getTest().getLabel().equals("8.2.1")) {
                                nbrW3cValidated = result.getElementCounter();
                            }
                        }
                    }
                    messageToSend = dbHost + ";" + dbPort + ";" + dbUserName + ";" + dbPassWord + ";" + dbName
                            + ";" + audit.getId() + ";" + tagsByAudit.get(audit.getId()) + ";" + auditName.get(audit.getId())
                            + ";" + auditUrl.get(audit.getId()) + ";" + auditHash.get(audit.getId()) + ";" + compaignHash + ";" + nbrW3cValidated
                            + ";" + auditRef.get(audit.getId()) + ";" + audit.getStatus();

                    tagsByAudit.remove(audit.getId());
                    auditHash.remove(audit.getId());
                    auditName.remove(audit.getId());
                    auditUrl.remove(audit.getId());
                    auditType.remove(audit.getId());
                    auditRef.remove(audit.getId());
                    auditLevel.remove(audit.getId());
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
        if (auditType.get(audit.getId()) != null) {
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
            auditDescriptionRef.remove(audit.getId());
            auditScreenWidth.remove(audit.getId());
            auditScreenHeight.remove(audit.getId());
            auditHtmlTags.remove(audit.getId());
        }
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
        auditDescriptionRef.put(audit.getId(), MessageRest.getDescriptionRef(message));
        auditScreenWidth.put(audit.getId(), MessageRest.getScreenWidth(message));
        auditScreenHeight.put(audit.getId(), MessageRest.getScreenHeight(message));
        auditHtmlTags.put(audit.getId(), MessageRest.getHtmlTags(message));
    }
}
