/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tanaguru.rules.elementchecker.element;

import java.util.ArrayList;
import java.util.Collection;
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
public class ForbiddenParentElementChecker extends ElementCheckerImpl {

   // private final Collection<String> childElementNames = new ArrayList<>();
    private final Collection<String> forbiddenParentsElementTags = new ArrayList<String>() {
        {
            add("article");
            add("aside");
            add("main");
            add("nav");
            add("section");
        }
    };

    /**
     * Constructor.
     *
     * @param childElementName
     * @param detectedSolutionPair
     * @param notDetectedSolutionPair
     * @param eeAttributeNameList
     */
    public ForbiddenParentElementChecker(
//            String childElementName,
            Pair<TestSolution, String> detectedSolutionPair,
            Pair<TestSolution, String> notDetectedSolutionPair,
            String... eeAttributeNameList) {
        super(detectedSolutionPair, notDetectedSolutionPair, eeAttributeNameList);
        //this.childElementNames.add(childElementName);
    }

    /**
     * Constructor.
     *
     * @param childElementName
     * @param detectedSolutionPair
     * @param notDetectedSolutionPair
     *
     */
    public ForbiddenParentElementChecker(
            String childElementName,
            Pair<TestSolution, String> detectedSolutionPair,
            Pair<TestSolution, String> notDetectedSolutionPair) {
        this( detectedSolutionPair, notDetectedSolutionPair, null);
       // this.childElementNames.add(childElementName);
    }

    @Override
    protected void doCheck(SSPHandler sspHandler,
            Elements elements,
            TestSolutionHandler testSolutionHandler) {
        for (Element elementToTest : elements) {
            checkChildElementPresence(elementToTest, elements, testSolutionHandler);
        }
    }

    private void checkChildElementPresence(
            Element elementToTest,
            Elements elements,
            TestSolutionHandler testSolutionHandler) {
//        System.out.println("#++++> inside of ForbiddenParentElementChecker elements.size "+elements.size());
        
        if (elements.isEmpty()) {
            testSolutionHandler.addTestSolution(TestSolution.NOT_APPLICABLE);
            return;
        }
        TestSolution testSolution = TestSolution.NEED_MORE_INFO;//init
       // for (Element el : elements) {
            //System.out.println(" element hello1 "+el.toString());
         if  (isForbiddenParent(elementToTest.parents())){
//              System.out.println("#++++> inside of ForbiddenParentElementChecker 1 is  :"+ isForbiddenParent(elementToTest.parents()));
//         System.out.println(" element has forbidden parent "+elementToTest.toString());
         
           testSolution = setTestSolution(testSolution, getFailureSolution());
                addSourceCodeRemark(getFailureSolution(),elementToTest, getFailureMsgCode());
             
         }
         else{
//             System.out.println("#++++> inside of ForbiddenParentElementChecker 2 is :"+ isForbiddenParent(elementToTest.parents()));
             testSolution = setTestSolution(testSolution, getSuccessSolution());
                addSourceCodeRemark(getSuccessSolution(),elementToTest, getSuccessMsgCode());
         }

          testSolutionHandler.addTestSolution(testSolution);

    }

    private boolean isForbiddenParent(Elements parents) {
        boolean exists = false;
//        System.out.println("===> p1 "+  exists);
        if (parents.isEmpty()) {
//            System.out.println("===> p2 "+exists);
            return false;
        } else {
            for (Element e : parents) {
//                System.out.println("===> p3 "+exists);
                if (forbiddenParentsElementTags.contains(e.tagName())) {
                   //System.out.println(" element having forbidden parent (meth) "+e.tagName());
                     
                    exists = true;
//                     System.out.println("===> after forbidden test "+exists);
                }
            }
            return exists;
        }
    }
}
