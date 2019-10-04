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
public class AttributeWithValuesChecker extends ElementCheckerImpl {


    /**
     * the attribute the test is about
     */
    private final String attributeName;

    /**
     * the attribute values the test is about
     */
    private final String attributeValue1;
    private final String attributeValue2;

    /**
     * This flag determines whether each source code remark have to be related
     * with the element or the attribute itself. Default is false
     */
    private boolean createSourceCodeRemarkOnAttribute = false;

    /**
     *
     * @param attributeName
     * @param attributeValue1
     * @param attributeValue2
     * @param detectedSolutionPair
     * @param notDetectedSolutionPair
     * @param eeAttributeNameList
     */
    public AttributeWithValuesChecker(
            String attributeName,
            String attributeValue1,
            String attributeValue2,
            Pair<TestSolution,String> detectedSolutionPair,
            Pair<TestSolution,String> notDetectedSolutionPair,
            String... eeAttributeNameList) {
        super(detectedSolutionPair, notDetectedSolutionPair, eeAttributeNameList);
        this.attributeName = attributeName;
        this.attributeValue1 = attributeValue1;
        this.attributeValue2 = attributeValue2;
        
    }
    

    
    @Override
    public void doCheck(
            SSPHandler sspHandler,
            Elements elements,
            TestSolutionHandler testSolutionHandler) {
        checkAttributeWithValues(
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
    private void checkAttributeWithValues(
            Elements elements,
            TestSolutionHandler testSolutionHandler) {
        if (elements.isEmpty()) {
            testSolutionHandler.addTestSolution(TestSolution.NOT_APPLICABLE);
            return;
        }

        TestSolution testSolution = TestSolution.NOT_APPLICABLE;

        for (Element el : elements) {
//            if 
//                     ((el.hasAttr(attributeName) && !el.attr(attributeName).equals(attributeValue1))
//                    || (el.hasAttr(attributeName) && !el.attr(attributeName).equals(attributeValue2))) {

                
                
                 if  ( !((el.attr(attributeName).equals(attributeValue1)) || el.attr(attributeName).equals(attributeValue2))){
//                  
//                  
//                  }

                testSolution = setTestSolution(testSolution, getFailureSolution());
                createSourceCodeRemark(getFailureSolution(), el, getFailureMsgCode());
                
            } 
           else {
               testSolution = setTestSolution(testSolution, getSuccessSolution());
               createSourceCodeRemark(getSuccessSolution(), el, getSuccessMsgCode());
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
  
