/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2011  Open-S Company
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
 * Contact us by mail: open-s AT open-s DOT com
 */
package org.opens.tanaguru.processing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;
import javax.xml.xpath.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.opens.tanaguru.contentadapter.css.CSSOMDeclaration;
import org.opens.tanaguru.contentadapter.css.CSSOMRule;
import org.opens.tanaguru.entity.audit.*;
import org.opens.tanaguru.entity.factory.audit.EvidenceElementFactory;
import org.opens.tanaguru.entity.factory.audit.ProcessRemarkFactory;
import org.opens.tanaguru.entity.factory.audit.SourceCodeRemarkFactory;
import org.opens.tanaguru.entity.service.audit.EvidenceDataService;
import org.opens.tanaguru.service.ProcessRemarkService;
import org.w3c.css.sac.ConditionalSelector;
import org.w3c.css.sac.DescendantSelector;
import org.w3c.css.sac.ElementSelector;
import org.w3c.css.sac.Selector;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.flute.parser.selectors.ClassConditionImpl;
import org.w3c.flute.parser.selectors.IdConditionImpl;

/**
 * 
 * @author jkowalczyk
 */
public class ProcessRemarkServiceImpl implements ProcessRemarkService {

    private static final Logger LOGGER = Logger.getLogger(ProcessRemarkServiceImpl.class);
    private static final String CSS_SELECTOR_EVIDENCE = "Css-Selector";
    private static final String CSS_FILENAME_EVIDENCE = "Css-Filename";
    private static final String START_COMMENT_OCCURENCE = "<!--";
    private static final String END_COMMENT_OCCURENCE = "-->";
    private XPath xpath = XPathFactory.newInstance().newXPath();
    private Document document;
    private org.jsoup.nodes.Document jsoupDocument;

    /**
     * 
     * @param processRemarkFactory
     * @param sourceCodeRemarkFactory
     * @param evidenceElementFactory
     * @param evidenceDataService
     */
    public ProcessRemarkServiceImpl(
            ProcessRemarkFactory processRemarkFactory,
            SourceCodeRemarkFactory sourceCodeRemarkFactory,
            EvidenceElementFactory evidenceElementFactory,
            EvidenceDataService evidenceDataService) {
        super();
        this.processRemarkFactory = processRemarkFactory;
        this.sourceCodeRemarkFactory = sourceCodeRemarkFactory;
        this.evidenceElementFactory = evidenceElementFactory;
        this.evidenceDataService = evidenceDataService;
    }

    /**
     * 
     * @param document
     */
    public void setDocument(Document document) {
        this.document = document;
    }
    
    public void setJsoupDocument(org.jsoup.nodes.Document document) {
        this.jsoupDocument = document;
    }
    
    private Collection<ProcessRemark> remarkSet;
    @Override
    public Collection<ProcessRemark> getRemarkList() {
        return this.remarkSet;
    }
    
    private List<String> evidenceElementList = new ArrayList<String>();
    @Override
    public void addEvidenceElement(String element) {
        if (!evidenceElementList.contains(element)) {
            evidenceElementList.add(element);
        }
    }

    @Override
    public void setEvidenceElementList(Collection<String> element) {
        evidenceElementList.addAll(element);
    }
    private ProcessRemarkFactory processRemarkFactory;

    public ProcessRemarkFactory getProcessRemarkFactory() {
        return processRemarkFactory;
    }

    public void setProcessRemarkFactory(ProcessRemarkFactory processRemarkFactory) {
        this.processRemarkFactory = processRemarkFactory;
    }
    private SourceCodeRemarkFactory sourceCodeRemarkFactory;

    public SourceCodeRemarkFactory getSourceCodeRemarkFactory() {
        return sourceCodeRemarkFactory;
    }

    public void setSourceCodeRemarkFactory(SourceCodeRemarkFactory sourceCodeRemarkFactory) {
        this.sourceCodeRemarkFactory = sourceCodeRemarkFactory;
    }
    private EvidenceElementFactory evidenceElementFactory;

    @Override
    public EvidenceElementFactory getEvidenceElementFactory() {
        return evidenceElementFactory;
    }

    public void setEvidenceElementFactory(EvidenceElementFactory evidenceElementFactory) {
        this.evidenceElementFactory = evidenceElementFactory;
    }
    private EvidenceDataService evidenceDataService;

    @Override
    public EvidenceDataService getEvidenceDataService() {
        return evidenceDataService;
    }

    public void setEvidenceDataService(EvidenceDataService evidenceDataService) {
        this.evidenceDataService = evidenceDataService;
    }
    private Map<Integer, String> sourceCodeWithLine = null;
            
    private Map<Integer, String> rawSourceCodeWithLine = null;
            
    /**
     * Local map of evidence to avoid multiple access to database
     */
    private Map<String, Evidence> evidenceMap =
            new HashMap<String, Evidence>();

    @Override
    public void initializeService(Document document, String adaptedContent) {
        if (document != null) {
            this.document = document;
        }
        if (adaptedContent != null && sourceCodeWithLine == null) {
            initializeSourceCodeMap(adaptedContent);
        }
        // call the reset service to instanciated local remarks collection
        // and evidence elements collection
        resetService();
    }
    
    /**
     * The initialisation of the jquery like should be called once for each 
     * tested SSP. It stores the current document and initialised a map with the
     * source where each key is the line number. This map is then used to 
     * retrieve the line number of an element.
     * 
     * @param document
     * @param adaptedContent 
     */
    @Override
    public void initializeService(org.jsoup.nodes.Document document, String adaptedContent) {
        Date beginDate = null;

        if (document != null && jsoupDocument == null) {
            this.jsoupDocument = document;
        }
        if (LOGGER.isDebugEnabled()) {
            beginDate = new Date();
            LOGGER.debug("Initialising source Map by line");
        }
        if (adaptedContent != null && rawSourceCodeWithLine == null) {
            initializeRawSourceCodeMap(adaptedContent);
        }
        if (LOGGER.isDebugEnabled()) {
            Date endDate = new Date();
            LOGGER.debug("initialisation of source map by line took " 
                    + (endDate.getTime()-beginDate.getTime()) +"ms");
        }
        // call the reset service to instanciated local remarks collection
        // and evidence elements collection
        resetService();
    }

    @Override
    public void resetService() {
        remarkSet = new LinkedHashSet<ProcessRemark>();
        evidenceElementList = new LinkedList<String>();
    }

    @Override
    public ProcessRemark createProcessRemark(
            TestSolution processResult,
            String messageCode) {
        return processRemarkFactory.create(processResult, messageCode);
    }

    @Override
    public void addProcessRemark(TestSolution processResult, String messageCode) {
        remarkSet.add(processRemarkFactory.create(processResult, messageCode));
    }

    @Override
    public void addSourceCodeRemark(TestSolution processResult, Node node,
            String messageCode, String attributeName) {
        remarkSet.add(createSourceCodeRemark(
                processResult,
                node,
                messageCode,
                attributeName));
    }
    
    @Override
    public void addSourceCodeRemarkOnElement(TestSolution processResult, Element element,
            String messageCode) {
        remarkSet.add(createSourceCodeRemark(
                processResult,
                element,
                messageCode));
    }

    @Override
    public void addSourceCodeRemarkOnElement(
            TestSolution processResult, 
            Element element,
            String messageCode, 
            Collection<EvidenceElement> evidenceElementList) {
        SourceCodeRemark remark = sourceCodeRemarkFactory.create();
        remark.setIssue(processResult);
        remark.setMessageCode(messageCode);
        if (element != null) {
            remark.setLineNumber(searchElementLineNumber(element));
            remark.setTarget(element.nodeName());
            remark.setSnippet(getSnippetFromElement(element));
        } else {
            remark.setLineNumber(-1);
        }
        if (CollectionUtils.isNotEmpty(evidenceElementList)) {
            for (EvidenceElement ee : evidenceElementList) {
                remark.addElement(ee);
                ee.setProcessRemark(remark);
            }
        }
        remarkSet.add(remark);
    }
    
    @Override
    public void addSourceCodeRemark(
            TestSolution processResult, 
            Node node,
            String messageCode, 
            Collection<EvidenceElement> evidenceElementList) {
        SourceCodeRemark remark = sourceCodeRemarkFactory.create();
        remark.setIssue(processResult);
        remark.setMessageCode(messageCode);
        if (node != null) {
            remark.setLineNumber(searchNodeLineNumber(node));
        } else {
            remark.setLineNumber(-1);
        }
        for (EvidenceElement element : evidenceElementList) {
            remark.addElement(element);
            element.setProcessRemark(remark);
        }
        remarkSet.add(remark);
    }

    @Override
    public void addCssCodeRemark(TestSolution processResult,
            CSSOMRule rule, String messageCode, String attrName, String fileName) {// XXX
        SourceCodeRemark remark = sourceCodeRemarkFactory.create();
        remark.setIssue(processResult);
        remark.setMessageCode(messageCode);
        // This a fake sourceCode Remark, the line number cannot be found
        // we use a sourceCodeRemark here to add evidence elements
        remark.setLineNumber(-1);
        EvidenceElement evidenceElement = evidenceElementFactory.create();
        evidenceElement.setProcessRemark(remark);
        evidenceElement.setValue(attrName);
        evidenceElement.setEvidence(getEvidence(DEFAULT_EVIDENCE));
        remark.addElement(evidenceElement);
        try {
            String selectorValue = computeSelector(rule);
            if (selectorValue != null) {
                EvidenceElement cssSelectorEvidenceElement = evidenceElementFactory.create();
                cssSelectorEvidenceElement.setProcessRemark(remark);
                cssSelectorEvidenceElement.setValue(selectorValue);
                cssSelectorEvidenceElement.setEvidence(getEvidence(CSS_SELECTOR_EVIDENCE));
                remark.addElement(cssSelectorEvidenceElement);
            }
            if (fileName != null) {
                EvidenceElement fileNameEvidenceElement = evidenceElementFactory.create();
                fileNameEvidenceElement.setProcessRemark(remark);
                fileNameEvidenceElement.setValue(fileName);
                fileNameEvidenceElement.setEvidence(getEvidence(CSS_FILENAME_EVIDENCE));
                remark.addElement(fileNameEvidenceElement);
            }
        } catch (ClassCastException ex) {
            LOGGER.error(ex.getMessage());
        }
        remarkSet.add(remark);
    }
    
    @Override
    public void addCssCodeRemark(TestSolution processResult,
            String selectorValue, 
            String messageCode, 
            String attrName, 
            String fileName) {// XXX
        SourceCodeRemark remark = sourceCodeRemarkFactory.create();
        remark.setIssue(processResult);
        remark.setMessageCode(messageCode);
        // This a fake sourceCode Remark, the line number cannot be found
        // we use a sourceCodeRemark here to add evidence elements
        remark.setLineNumber(-1);
        EvidenceElement evidenceElement = evidenceElementFactory.create();
        evidenceElement.setProcessRemark(remark);
        evidenceElement.setValue(attrName);
        evidenceElement.setEvidence(getEvidence(DEFAULT_EVIDENCE));
        remark.addElement(evidenceElement);
        try {
            if (selectorValue != null) {
                EvidenceElement cssSelectorEvidenceElement = evidenceElementFactory.create();
                cssSelectorEvidenceElement.setProcessRemark(remark);
                cssSelectorEvidenceElement.setValue(selectorValue);
                cssSelectorEvidenceElement.setEvidence(getEvidence(CSS_SELECTOR_EVIDENCE));
                remark.addElement(cssSelectorEvidenceElement);
            }
            if (fileName != null) {
                EvidenceElement fileNameEvidenceElement = evidenceElementFactory.create();
                fileNameEvidenceElement.setProcessRemark(remark);
                fileNameEvidenceElement.setValue(fileName);
                fileNameEvidenceElement.setEvidence(getEvidence(CSS_FILENAME_EVIDENCE));
                remark.addElement(fileNameEvidenceElement);
            }
        } catch (ClassCastException ex) {
            LOGGER.error(ex.getMessage());
        }
        remarkSet.add(remark);
    }

    @Override
    public void addSourceCodeRemark(
            TestSolution processResult,
            Node node,
            String messageCode,
            String elementType,
            String elementName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 
     * @param node
     * @return
     */
    private int searchNodeLineNumber(Node node) {
        int nodeIndex = getNodeIndex(node);
        int lineNumber = 0;
        boolean found = false;
        boolean isWithinComment = false;
        Iterator<Map.Entry<Integer, String>> iter = sourceCodeWithLine.entrySet().iterator();
        String codeLine;
        while (iter.hasNext() && !found) {
            Map.Entry<Integer, String> entry = iter.next();
            int myLineNumber = entry.getKey();
            int index = 0;
            while (index != -1) {
                codeLine = entry.getValue().toLowerCase();
                int characterPositionOri = index;
                index = codeLine.indexOf("<" + node.getNodeName().toLowerCase() + ">",
                        index);
                if (index == -1) {
                    index = codeLine.indexOf("<" + node.getNodeName().toLowerCase() + " ",
                            characterPositionOri);
                }
                int startCommentIndex = codeLine.indexOf(
                        START_COMMENT_OCCURENCE, characterPositionOri);
                int endCommentIndex = codeLine.indexOf(
                        END_COMMENT_OCCURENCE, characterPositionOri);
                if (index != -1) { // if an occurence of the tag is found
                    if (!isWithinComment
                            && !(startCommentIndex != -1 && index > startCommentIndex)
                            && !(endCommentIndex != -1 && index < endCommentIndex)) { // if a comment is not currently opened or a comment is found on the current line and the occurence is not within
                        if (nodeIndex == 0) {
                            found = true;
                            lineNumber = myLineNumber;
                            break;
                        }
                        nodeIndex--;
                    }
                    index += node.getNodeName().length();
                }
                // if a "start comment" occurence is found on the line,
                // the boolean isWithinComment is set to true. Thus, while a
                // "end comment" is not found, all the occurences of the
                // wanted node will be ignored
                if (!isWithinComment && startCommentIndex != -1 && endCommentIndex == -1) {
                    isWithinComment = true;
                } else if (isWithinComment && endCommentIndex != -1 && startCommentIndex < endCommentIndex) {
                    isWithinComment = false;
                }
            }
        }
        return lineNumber;
    }
    
    /**
     * 
     * @param node
     * @return
     */
    private int searchElementLineNumber(Element element) {
        int nodeIndex = getElementIndex(element);
        int lineNumber = 0;
        boolean found = false;
        boolean isWithinComment = false;
        Iterator<Map.Entry<Integer, String>> iter = rawSourceCodeWithLine.entrySet().iterator();
        String codeLine;
        while (iter.hasNext() && !found) {
            Map.Entry<Integer, String> entry = iter.next();
            int myLineNumber = entry.getKey();
            int index = 0;
            while (index != -1) {
                codeLine = entry.getValue().toLowerCase();
                int characterPositionOri = index;
                index = codeLine.indexOf("<" + element.nodeName() + ">",
                        index);
                if (index == -1) {
                    index = codeLine.indexOf("<" + element.nodeName() + " ",
                            characterPositionOri);
                }
                int startCommentIndex = codeLine.indexOf(
                        START_COMMENT_OCCURENCE, characterPositionOri);
                int endCommentIndex = codeLine.indexOf(
                        END_COMMENT_OCCURENCE, characterPositionOri);
                if (index != -1) { // if an occurence of the tag is found
                    if (!isWithinComment
                            && !(startCommentIndex != -1 && index > startCommentIndex)
                            && !(endCommentIndex != -1 && index < endCommentIndex)) { // if a comment is not currently opened or a comment is found on the current line and the occurence is not within
                        if (nodeIndex == 0) {
                            found = true;
                            lineNumber = myLineNumber;
                            break;
                        }
                        nodeIndex--;
                    }
                    index += element.nodeName().length();
                }
                // if a "start comment" occurence is found on the line,
                // the boolean isWithinComment is set to true. Thus, while a
                // "end comment" is not found, all the occurences of the
                // wanted node will be ignored
                if (!isWithinComment && startCommentIndex != -1 && endCommentIndex == -1) {
                    isWithinComment = true;
                } else if (isWithinComment && endCommentIndex != -1 && startCommentIndex < endCommentIndex) {
                    isWithinComment = false;
                }
            }
        }
        return lineNumber;
    }

    /**
     * This methods search the line where the current node is present in
     * the source code
     * @param node
     * @return
     */
    private int getNodeIndex(Node node) {
        try {
            XPathExpression xPathExpression = xpath.compile("//" + node.getNodeName().toUpperCase());
            Object result = xPathExpression.evaluate(document,
                    XPathConstants.NODESET);
            NodeList nodeList = (NodeList) result;
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node current = nodeList.item(i);
                if (current.equals(node)) {
                    return i;
                }
            }
        } catch (XPathExpressionException ex) {
            LOGGER.error("Error occured while searching index of a node "+
                    ex.getMessage());
            throw new RuntimeException(ex);
        }
        return -1;
    }
    
    /**
     * This methods search the line where the current node is present in
     * the source code
     * @param node
     * @return
     */
    private int getElementIndex(Element element) {
        Elements elements = jsoupDocument.getElementsByTag(element.tagName());
        for (int i = 0; i < elements.size(); i++) {
            Element current = elements.get(i);
            if (current.equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Initialisation of a local map that handles each source code line, 
     * keyed by the line number
     * 
     * @param adaptedContent
     */
    private void initializeSourceCodeMap(String adaptedContent) {
        sourceCodeWithLine = new LinkedHashMap<Integer, String>();
        int lineNumber = 1;
        StringReader sr = new StringReader(adaptedContent);
        BufferedReader br = new BufferedReader(sr);
        String line;
        try {
            while ((line = br.readLine()) != null) {
                sourceCodeWithLine.put(lineNumber, line);
                lineNumber++;
            }
        } catch (IOException ex) {
            LOGGER.error("Error occured while initialize source code map "+
                    ex.getMessage());
        }
    }
    
    /**
     * Initialisation of a local map that handles each source code line, 
     * keyed by the line number
     * 
     * @param adaptedContent
     */
    private void initializeRawSourceCodeMap(String rawSource) {
        rawSourceCodeWithLine = new LinkedHashMap<Integer, String>();
        int lineNumber = 1;
        StringReader sr = new StringReader(rawSource);
        BufferedReader br = new BufferedReader(sr);
        String line;
        try {
            while ((line = br.readLine()) != null) {
                rawSourceCodeWithLine.put(lineNumber, line);
                lineNumber++;
            }
        } catch (IOException ex) {
            LOGGER.error("Error occured while initialize raw source code map "+
                    ex.getMessage());
        }
    }

    @Override
    public EvidenceElement getEvidenceElement(String evidenceCode, String evidenceValue) {
        EvidenceElement evidenceElement = evidenceElementFactory.create();
        evidenceElement.setValue(StringUtils.trim(evidenceValue));
        evidenceElement.setEvidence(getEvidence(evidenceCode));
        return evidenceElement;
    }

    @Override
    public SourceCodeRemark createSourceCodeRemark(
            TestSolution processResult,
            Node node,
            String messageCode,
            String elementName) {
        SourceCodeRemark remark = sourceCodeRemarkFactory.create();
        remark.setIssue(processResult);
        remark.setMessageCode(messageCode);

        remark.setLineNumber(searchNodeLineNumber(node));

        EvidenceElement evidenceElement = evidenceElementFactory.create();
        evidenceElement.setProcessRemark(remark);
        evidenceElement.setValue(elementName);
        evidenceElement.setEvidence(getEvidence(DEFAULT_EVIDENCE));
        for (String attr : evidenceElementList) {
            if (node.getAttributes().getNamedItem(attr) != null) {
                EvidenceElement evidenceElementSup = evidenceElementFactory.create();
                evidenceElementSup.setProcessRemark(remark);
                evidenceElementSup.setValue(node.getAttributes().getNamedItem(attr).getNodeValue());
                evidenceElementSup.setEvidence(getEvidence(attr));
                remark.addElement(evidenceElementSup);
            }
        }
        remark.addElement(evidenceElement);
        return remark;
    }
    
    @Override
    public SourceCodeRemark createSourceCodeRemark(
            TestSolution processResult,
            Element element,
            String messageCode) {
        SourceCodeRemark remark = sourceCodeRemarkFactory.create();
        remark.setIssue(processResult);
        remark.setMessageCode(messageCode);
        remark.setLineNumber(searchElementLineNumber(element));
        remark.setTarget(element.nodeName());
        remark.setSnippet(getSnippetFromElement(element));
        for (String attr : evidenceElementList) {
            EvidenceElement evidenceElementSup;
            if (StringUtils.equalsIgnoreCase(attr, "text")) {
                evidenceElementSup = getEvidenceElement(attr, element.text());
            } else {
                evidenceElementSup = getEvidenceElement(attr, element.attr(attr));
            }
            remark.addElement(evidenceElementSup);
        }
        return remark;
    }

    @Override
    public void addConsolidationRemark(
            TestSolution processResult,
            String messageCode,
            String value,
            String url) {
        remarkSet.add(createConsolidationRemark(
                processResult,
                messageCode,
                value,
                url));
    }

    @Override
    public void addProcessRemark(
            TestSolution processResult,
            String messageCode,
            Collection<EvidenceElement> evidenceElementList) {
        remarkSet.add(createProcessRemark(
                processResult,
                messageCode,
                evidenceElementList));
    }

    @Override
    public ProcessRemark createProcessRemark(
            TestSolution processResult,
            String messageCode,
            Collection<EvidenceElement> evidenceElementList) {
        ProcessRemark remark = processRemarkFactory.create();
        remark.setIssue(processResult);
        remark.setMessageCode(messageCode);
        for (EvidenceElement element : evidenceElementList) {
            remark.addElement(element);
            element.setProcessRemark(remark);
        }
        return remark;
    }

    @Override
    public ProcessRemark createConsolidationRemark(
            TestSolution processResult,
            String messageCode,
            String value,
            String url) {
        ProcessRemark remark = processRemarkFactory.create();
        remark.setIssue(processResult);
        remark.setMessageCode(messageCode);

        if (value != null) {
            EvidenceElement evidenceElement = evidenceElementFactory.create();
            evidenceElement.setProcessRemark(remark);
            evidenceElement.setValue(value);
            evidenceElement.setEvidence(getEvidence(DEFAULT_EVIDENCE));
            remark.addElement(evidenceElement);
        }
        if (url != null) {
            EvidenceElement evidenceElement = evidenceElementFactory.create();
            evidenceElement.setProcessRemark(remark);
            evidenceElement.setValue(url);
            evidenceElement.setEvidence(getEvidence(URL_EVIDENCE));
            remark.addElement(evidenceElement);
        }
        return remark;
    }

    /**
     * Return an evidence instance for a given code. This method avoids multiple
     * access to mysql databases, by maintaining a map. 
     * @param code
     * @return
     */
    public Evidence getEvidence(String code) {
        if (evidenceMap.containsKey(code)) {
            return evidenceMap.get(code);
        } else {
            Evidence evidence = evidenceDataService.findByCode(code);
            evidenceMap.put(code, evidence);
            return evidence;
        }
    }
    
    private String getSnippetFromElement(Element element) {
        String elementHtml = StringEscapeUtils.escapeHtml4(StringUtil.normaliseWhitespace(element.outerHtml()));
        if (elementHtml.length() > SNIPPET_MAX_LENGTH) {
            return elementHtml.substring(0, SNIPPET_MAX_LENGTH);
        }
        return elementHtml;
    }
    
    private String computeSelector(CSSOMRule rule) {
        StringBuilder selectorValue = new StringBuilder();
        Selector selector = rule.getSelectors().get(0).getSelector();
        CSSOMDeclaration cssomDeclaration = null;
        if (rule.getSelectors().get(0).getOwnerDeclaration() != null) {
            cssomDeclaration = rule.getSelectors().get(0).getOwnerDeclaration().get(0);
        }
        if (selector instanceof DescendantSelector) {
            selectorValue.append(computeDescendantSelector((DescendantSelector)selector));
        } else if  (selector instanceof ConditionalSelector) {
            selectorValue.append(computeConditionalSelector((ConditionalSelector)selector));
        } else {
            selectorValue.append(computeElementSelector(selector, cssomDeclaration));
        }
        return selectorValue.toString();
    }

    private String computeDescendantSelector(DescendantSelector ds) {
        StringBuilder selectorValue = new StringBuilder();
        if (ds != null) {
            if (ds.getAncestorSelector() != null && ds.getAncestorSelector() instanceof DescendantSelector) {
                selectorValue.append(computeDescendantSelector((DescendantSelector)ds.getAncestorSelector()));
            } else if (ds.getAncestorSelector() != null && ds.getAncestorSelector() instanceof ConditionalSelector) {
                selectorValue.append(computeConditionalSelector((ConditionalSelector)ds.getAncestorSelector()));
            }
            if (ds.getSimpleSelector() != null && ds.getSimpleSelector() instanceof ConditionalSelector) {
                selectorValue.append(computeConditionalSelector((ConditionalSelector)ds.getSimpleSelector()));
            }
            else if(ds.getSimpleSelector() != null && ds.getSimpleSelector() instanceof ElementSelector) {
                selectorValue.append(computeElementSelector(ds.getSimpleSelector(), null));
            } 
        }
        return selectorValue.toString();
    }

    private String computeConditionalSelector(ConditionalSelector cs) {
         StringBuilder selectorValue = new StringBuilder();
        if (cs.getCondition() instanceof IdConditionImpl) {
            selectorValue.append("#");
            selectorValue.append(((IdConditionImpl)cs.getCondition()).getValue());
            selectorValue.append(' ');
        } else if (cs.getCondition() instanceof ClassConditionImpl) {
            selectorValue.append(".");
            selectorValue.append(((ClassConditionImpl)cs.getCondition()).getValue());
            selectorValue.append(' ');
        }
         return selectorValue.toString();
    }

    private String computeElementSelector(Selector es, CSSOMDeclaration cssomDeclaration) {
         StringBuilder selectorValue = new StringBuilder();
        if (es instanceof ElementSelector) {
            selectorValue.append(' ');
            selectorValue.append(((ElementSelector)es).getLocalName());
            selectorValue.append(' ');
        }
         return selectorValue.toString();
    }

}