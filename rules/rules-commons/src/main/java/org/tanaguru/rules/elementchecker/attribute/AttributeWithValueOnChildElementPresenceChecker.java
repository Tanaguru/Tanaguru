/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package org.tanaguru.rules.elementchecker.attribute;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.processor.SSPHandler;
import org.tanaguru.ruleimplementation.TestSolutionHandler;
import org.tanaguru.rules.elementchecker.ElementCheckerImpl;

/**
*
* @author tanaguru
*/ 
public class AttributeWithValueOnChildElementPresenceChecker extends  ElementCheckerImpl{

   
    /**
     * the attribute the test is about
     */
    private final String attributeName;

    /**
     * the attribute value the test is about
     */
    private final String attributeValue;

    /**
     * This flag determines whether each source code remark have to be related
     * with the element or the attribute itself. Default is false
     */
    private boolean createSourceCodeRemarkOnAttribute = false;

    /**
     *
     * @param attributeName
     * @param attributeValue
     * @param detectedSolutionPair
     * @param notDetectedSolutionPair
     * @param eeAttributeNameList
     */
    public AttributeWithValueOnChildElementPresenceChecker(
            String attributeName,
            String attributeValue,
            Pair<TestSolution,String> detectedSolutionPair,
            Pair<TestSolution,String> notDetectedSolutionPair,
            String... eeAttributeNameList) {
        super(detectedSolutionPair, notDetectedSolutionPair, eeAttributeNameList);
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
    }
    
    /**
     * Use constructor with Pair instead
     * @param attributeName
     * @param attributeValue
     * @param detectedSolution
     * @param notDetectedSolution
     * @param messageCodeOnAttrDetected
     * @param messageCodeOnAttrNotDetected
     * @param eeAttributeNameList
     */
    @Deprecated
    public AttributeWithValueOnChildElementPresenceChecker(
            String attributeName,
            String attributeValue,
            TestSolution detectedSolution,
            TestSolution notDetectedSolution,
            String messageCodeOnAttrDetected,
            String messageCodeOnAttrNotDetected,
            String... eeAttributeNameList) {
        this(
                attributeName,
                attributeValue,
                new ImmutablePair(detectedSolution,messageCodeOnAttrDetected), 
                new ImmutablePair(notDetectedSolution,messageCodeOnAttrNotDetected),
                eeAttributeNameList);
    }

        /**
     *
     * @param attributeName
     * @param attributeValue
     * @param detectedSolutionPair
     * @param notDetectedSolutionPair
     * @param createSourceCodeRemarkOnAttribute
     * @param eeAttributeNameList
     */
    public AttributeWithValueOnChildElementPresenceChecker(
            String attributeName,
            String attributeValue,
            Pair<TestSolution,String> detectedSolutionPair,
            Pair<TestSolution,String> notDetectedSolutionPair,
            boolean createSourceCodeRemarkOnAttribute,
            String... eeAttributeNameList) {
        super(detectedSolutionPair, notDetectedSolutionPair, eeAttributeNameList);
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
        this.createSourceCodeRemarkOnAttribute = createSourceCodeRemarkOnAttribute;
    }
    
    /**
     *
     * @param attributeName
     * @param attributeValue
     * @param detectedSolution
     * @param notDetectedSolution
     * @param messageCodeOnAttrDetected
     * @param messageCodeOnAttrNotDetected
     * @param createSourceCodeRemarkOnAttribute
     * @param eeAttributeNameList
     */
    public AttributeWithValueOnChildElementPresenceChecker(
            String attributeName,
            String attributeValue,
            TestSolution detectedSolution,
            TestSolution notDetectedSolution,
            String messageCodeOnAttrDetected,
            String messageCodeOnAttrNotDetected,
            boolean createSourceCodeRemarkOnAttribute,
            String... eeAttributeNameList) {
        this(
                attributeName,
                attributeValue,
                new ImmutablePair(detectedSolution,messageCodeOnAttrDetected), 
                new ImmutablePair(notDetectedSolution,messageCodeOnAttrNotDetected),
                createSourceCodeRemarkOnAttribute,
                eeAttributeNameList);
    }
    
    @Override
    public void doCheck(
            SSPHandler sspHandler,
            Elements elements,
            TestSolutionHandler testSolutionHandler) {
        checkChildElementWithValueAttributePresence(
                elements,
                testSolutionHandler);
    }

    /**
     * This methods checks whether a given attribute is present for a set of
     * elements
     *
     * @param elements
     * @param testSolutionHandler
     */
    private void checkAttributeWithValuePresence(
            Elements elements,
            TestSolutionHandler testSolutionHandler) {

        if (elements.isEmpty()) {
            testSolutionHandler.addTestSolution(TestSolution.NOT_APPLICABLE);
            return;
        }

        TestSolution testSolution = TestSolution.PASSED;

        for (Element el : elements) {
            if (!el.hasAttr(attributeName)
                    || (el.hasAttr(attributeName) && !el.attr(attributeName).equals(attributeValue))) {

                testSolution = setTestSolution(testSolution, getFailureSolution());
                createSourceCodeRemark(getFailureSolution(), el, getFailureMsgCode());
                
            } else if (StringUtils.isNotBlank(getSuccessMsgCode())) {
                testSolution = setTestSolution(testSolution, getSuccessSolution());

                createSourceCodeRemark(getSuccessSolution(), el, getSuccessMsgCode());
            }
        }

        testSolutionHandler.addTestSolution(testSolution);

    }
    
    
     /**
     * This methods checks whether elements have a child element of with a given 
     * attribute.
     * 
     * @param elements
     * @param testSolutionHandler 
     */
    private void checkChildElementWithValueAttributePresence (
            Elements elements, 
            TestSolutionHandler testSolutionHandler) {
        if (elements.isEmpty()) {
            testSolutionHandler.addTestSolution(TestSolution.NOT_APPLICABLE);
            return;
        }

        TestSolution testSolution = TestSolution.PASSED;

        for (Element el : elements) {

            if (!el.getElementsByAttributeValue(attributeName,attributeValue).isEmpty()) {

                Elements mySet2 = el.getElementsByAttribute("img[dir]"); 
                
                testSolution = setTestSolution(testSolution, getSuccessSolution());
                addSourceCodeRemark(getSuccessSolution(),el, getSuccessMsgCode());
                
            } else {
                
                testSolution = setTestSolution(testSolution, getFailureSolution());
                addSourceCodeRemark(getFailureSolution(),el, getFailureMsgCode());

            }
        }

        testSolutionHandler.addTestSolution(testSolution);
    }
    
    
    

    /**
     *
    * @param testSolution
     * @param element
     * @param message
     */
    private void createSourceCodeRemark(TestSolution testSolution, Element element, String message) {
        if (createSourceCodeRemarkOnAttribute) {
            addSourceCodeRemarkOnAttribute(
                    testSolution,
                    element,
                    message,
                    attributeName);
        } else {
            addSourceCodeRemark(
                    testSolution,
                    element,
                    message);
        }
    }
    
}
