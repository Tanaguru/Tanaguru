/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package org.tanaguru.rules.elementchecker;

import org.apache.commons.lang3.tuple.Pair;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.processor.SSPHandler;
import org.tanaguru.ruleimplementation.TestSolutionHandler;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_UNICITY_MAIN_ARIA_MSG;


/**
 *
 * @author tanaguru
 */
public class RoleMainElementChecker extends ElementCheckerImpl {

    public RoleMainElementChecker(String... eeAttributeNameList) {
        super(eeAttributeNameList);
    }

    public RoleMainElementChecker(Pair<TestSolution, String> successSolutionPair, Pair<TestSolution, String> failureSolutionPair, String... eeAttributeNameList) {
        super(successSolutionPair, failureSolutionPair, eeAttributeNameList);
    }

        @Override
    protected void doCheck(SSPHandler sspHandler, Elements elements, TestSolutionHandler testSolutionHandler) {
        doCheckDocumentStructure(sspHandler, elements, testSolutionHandler);

    }

    private void doCheckDocumentStructure(SSPHandler sspHandler, Elements elements, TestSolutionHandler testSolutionHandler) {
        //Element main

        TestSolution testSolution = TestSolution.NEED_MORE_INFO; // initialization
        Element el;
        if (elements.isEmpty()) {// there is more than one element main
            // el = elements.get(0);
            testSolution = setTestSolution(testSolution, TestSolution.FAILED);
            //addSourceCodeRemark(testSolution, null, CHECK_MAIN_ELEMENT_MULTIPLE_MISSING_MSG);//pré-qualifié - 
           
        } else if (elements.size() == 1) {
            el = elements.get(0);
             
            testSolution = setTestSolution(testSolution, TestSolution.NEED_MORE_INFO);
            
            
                addSourceCodeRemark(testSolution, el, getSuccessMsgCode());//pré-qualifié +
               
            
        } 
        else if (elements.size() > 1) {
            el = elements.get(0);
            testSolution = setTestSolution(testSolution, TestSolution.FAILED);
            addSourceCodeRemark(TestSolution.FAILED, el, CHECK_UNICITY_MAIN_ARIA_MSG);
            
        }
        testSolutionHandler.addTestSolution(testSolution);
    
    
    }

}
