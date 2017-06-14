
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
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_FOOTER_ELEMENT_ARIA_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_HEADER_ELEMENT_ARIA_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_SEARCH_ELEMENT_ARIA_MSG;


/**
 *
 * @author tanaguru
 */
public class RoleStructureElementChecker extends ElementCheckerImpl {

    public RoleStructureElementChecker(String... eeAttributeNameList) {
        super(eeAttributeNameList);
    }

    public RoleStructureElementChecker(Pair<TestSolution, String> successSolutionPair, Pair<TestSolution, String> failureSolutionPair, String... eeAttributeNameList) {
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
            testSolution = setTestSolution(testSolution, TestSolution.NEED_MORE_INFO);
            //addSourceCodeRemark(testSolution, null, CHECK_MAIN_ELEMENT_MULTIPLE_MISSING_MSG);//pré-qualifié - 
           
        } else if (elements.size() == 1) {
            el = elements.get(0);
             
            testSolution = setTestSolution(testSolution, TestSolution.NEED_MORE_INFO);
            
            if (el.attr("role").equals("banner")){
                addSourceCodeRemark(testSolution, el, CHECK_HEADER_ELEMENT_ARIA_MSG);//pré-qualifié +
               
            }
            else  if (el.attr("role").equals("contentinfo")){
                addSourceCodeRemark(testSolution, el, CHECK_FOOTER_ELEMENT_ARIA_MSG);//pré-qualifié +
               
            }
            else  if (el.attr("role").equals("search")){
                addSourceCodeRemark(testSolution, el, CHECK_SEARCH_ELEMENT_ARIA_MSG);//pré-qualifié +
               
            }
        } 
        else if (elements.size() > 1) {
            el = elements.get(0);
            testSolution = setTestSolution(testSolution, TestSolution.FAILED);
            addSourceCodeRemark(TestSolution.FAILED, el, getFailureMsgCode());
            
        }
        testSolutionHandler.addTestSolution(testSolution);
    
    
    }

}
