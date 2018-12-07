/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tanaguru.rules.elementchecker.element;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
public class SiblingElementsPresenceChecker extends ElementCheckerImpl {

    /**
     * The minimum number of children required. Default is 8
     */
    private int minimumNumberOfChildRequired = 1;

    /**
     * The child elements to search
     */
    private final Collection<String> childTextualElementNames = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param siblingTextualElementName
     * @param detectedSolutionPair
     * @param notDetectedSolutionPair
     * @param eeAttributeNameList
     */
    public SiblingElementsPresenceChecker(
            List<String> siblingTextualElementName,
            Pair<TestSolution, String> detectedSolutionPair,
            Pair<TestSolution, String> notDetectedSolutionPair,
            String... eeAttributeNameList) {
        super(detectedSolutionPair, notDetectedSolutionPair, eeAttributeNameList);
        this.childTextualElementNames.addAll(siblingTextualElementName);
    }

    @Override
    public void doCheck(
            SSPHandler sspHandler,
            Elements elements,
            TestSolutionHandler testSolutionHandler) {
//        for (String elementToTest : childTextualElementNames) {
//            checkChildElementPresence(elementToTest, elements, testSolutionHandler);
//        }
        checkChildElementPresence(childTextualElementNames, elements, testSolutionHandler);
    }

    /**
     * This methods checks whether elements have a child element of a given
     * type.
     *
     * @param elementToTest
     * @param elements
     * @param testSolutionHandler
     */
    private void checkChildElementPresence(
            Collection<String> elementsToTest,
            //  Element currentTestedElement,
            Elements elements,
            TestSolutionHandler testSolutionHandler) {
        // parent holds the parent element of our sibling elements
        Element parent = null;
        Elements siblingElements = null;

        if (elements.isEmpty()) {
            testSolutionHandler.addTestSolution(TestSolution.NOT_APPLICABLE);
            return;
        }

        TestSolution testSolution = TestSolution.PASSED;

        for (Element el : elements) {

            parent = el.parent();
            siblingElements = parent.children();

            if (parent == null) { //if no parent witch means no body tag neither html tag ==> test not applicable  incorrect html code !
                testSolutionHandler.addTestSolution(TestSolution.NOT_APPLICABLE);
                return;
            } else if (siblingElements.size() <= 1) {
                testSolution = setTestSolution(testSolution, getFailureSolution());
                addSourceCodeRemark(getFailureSolution(), el, getFailureMsgCode());
            } else {

                boolean flag = false;
                for (Element sEl : siblingElements) {
                    for (String elementToTest : elementsToTest) {
                        if (sEl.getElementsByTag(elementToTest).size() >= 1) {
                            flag = true;
                        }
                    }
                }
                if (flag) {
                    testSolution = setTestSolution(testSolution, getSuccessSolution());
                    addSourceCodeRemark(getSuccessSolution(), el, getSuccessMsgCode());

                }

//                testSolution = setTestSolution(testSolution, getFailureSolution());
//                addSourceCodeRemark(getFailureSolution(), el, getFailureMsgCode());
//            }
//            
//            
//
//            if (el.getElementsByTag(elementToTest).size() >= minimumNumberOfChildRequired) {
//                elements.indexOf(el);
//                testSolution = setTestSolution(testSolution, getSuccessSolution());
//                addSourceCodeRemark(getSuccessSolution(), el, getSuccessMsgCode());
//
//            } else {
//
//                testSolution = setTestSolution(testSolution, getFailureSolution());
//                addSourceCodeRemark(getFailureSolution(), el, getFailureMsgCode());
//
            }
        }

        testSolutionHandler.addTestSolution(testSolution);
    }

}
