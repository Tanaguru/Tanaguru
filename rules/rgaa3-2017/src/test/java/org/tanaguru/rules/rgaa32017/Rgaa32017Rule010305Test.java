/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tanaguru.rules.rgaa32017;

import static org.tanaguru.entity.audit.TestSolution.NEED_MORE_INFO;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABELLEDBY_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABEL_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;
import static org.tanaguru.rules.keystore.HtmlElementStore.OBJECT_ELEMENT;
import static org.tanaguru.rules.keystore.MarkerStore.DECORATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.INFORMATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_OBJ_IMG_ARIA_LABELLEDBY_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.INFORMATIVE_OBJ_NOT_INDENTICAL_ARIA_LABELLEDBY_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.SUSPECTED_INFORMATIVE_OBJ_WITH_LABELLEDBY_DETECTED;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.rules.keystore.HtmlElementStore;
import org.tanaguru.rules.keystore.RemarkMessageStore;
import org.tanaguru.rules.rgaa32017.test.Rgaa32017RuleImplementationTestCase;

/**
 *
 * @author tanaguru
 */
public class Rgaa32017Rule010305Test extends Rgaa32017RuleImplementationTestCase{

    public Rgaa32017Rule010305Test(String testName) {
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName("org.tanaguru.rules.rgaa32017.Rgaa32017Rule010305");
    }

    @Override
    protected void setUpWebResourceMap() {
    	addWebResource("Rgaa32017.Test.01.03.05-1Passed-01",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "object-informative-image"));
    	addWebResource("Rgaa32017.Test.01.03.05-1Passed-02",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "object-informative-image"));
    	addWebResource("Rgaa32017.Test.01.03.05-1Passed-03",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "object-informative-image"));
    	addWebResource("Rgaa32017.Test.01.03.05-1Passed-04",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "object-informative-image"));
    	addWebResource("Rgaa32017.Test.01.03.05-1Passed-05",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "object-informative-image"));
    	addWebResource("Rgaa32017.Test.01.03.05-1Passed-06",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "object-informative-image"));
    	addWebResource("Rgaa32017.Test.01.03.05-1Passed-07",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "object-informative-image"));
    	addWebResource("Rgaa32017.Test.01.03.05-1Passed-08",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "object-informative-image"));
    	addWebResource("Rgaa32017.Test.01.03.05-2Failed-01",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "object-informative-image"));
    	addWebResource("Rgaa32017.Test.01.03.05-2Failed-02",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "object-informative-image"));
    	addWebResource("Rgaa32017.Test.01.03.05-2Failed-03",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "object-informative-image"));
    	addWebResource("Rgaa32017.Test.01.03.05-2Failed-04",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "object-informative-image"));
    	addWebResource("Rgaa32017.Test.01.03.05-2Failed-05",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "object-informative-image"));
    	addWebResource("Rgaa32017.Test.01.03.05-2Failed-06",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "object-informative-image"));
    	addWebResource("Rgaa32017.Test.01.03.05-2Failed-07",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "object-informative-image"));
    	addWebResource("Rgaa32017.Test.01.03.05-2Failed-08",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "object-informative-image"));
        addWebResource("Rgaa32017.Test.01.03.05-3NMI-01");
        addWebResource("Rgaa32017.Test.01.03.05-3NMI-02");
        addWebResource("Rgaa32017.Test.01.03.05-3NMI-03");
        addWebResource("Rgaa32017.Test.01.03.05-3NMI-04");
        addWebResource("Rgaa32017.Test.01.03.05-4NA-01");
        addWebResource("Rgaa32017.Test.01.03.05-4NA-02");
        addWebResource("Rgaa32017.Test.01.03.05-4NA-03");
        addWebResource("Rgaa32017.Test.01.03.05-4NA-04",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "decorative-object"));
        addWebResource("Rgaa32017.Test.01.03.05-4NA-05",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "decorative-object"));
    }

    @Override
    protected void setProcess() {
        

    	//----------------------------------------------------------------------
        //------------------------------1Passed-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.01.03.05-1Passed-01"), 1);
    	

        //----------------------------------------------------------------------
        //------------------------------1Passed-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.01.03.05-1Passed-02"), 1);
    	

        //----------------------------------------------------------------------
        //------------------------------1Passed-03------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.01.03.05-1Passed-03"), 1);
    	

        //----------------------------------------------------------------------
        //------------------------------1Passed-04------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.01.03.05-1Passed-04"), 3);
    	

        //----------------------------------------------------------------------
        //------------------------------1Passed-05------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.01.03.05-1Passed-05"), 1);
    	

        //----------------------------------------------------------------------
        //------------------------------1Passed-06------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.01.03.05-1Passed-06"), 1);
    	

        //----------------------------------------------------------------------
        //------------------------------1Passed-07------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.01.03.05-1Passed-07"), 1);
    	

        //----------------------------------------------------------------------
        //------------------------------1Passed-08------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.01.03.05-1Passed-08"), 3);
        
        

        //----------------------------------------------------------------------
        //------------------------------2Failed-01------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("Rgaa32017.Test.01.03.05-2Failed-01");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.INFORMATIVE_OBJ_NOT_INDENTICAL_ATTR_MSG,
                HtmlElementStore.OBJECT_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR, "earth picture"),
                new ImmutablePair(ARIA_LABEL_ATTR, "image"));           
        

        //----------------------------------------------------------------------
        //------------------------------2Failed-02------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.05-2Failed-02");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.INFORMATIVE_OBJ_NOT_INDENTICAL_ATTR_MSG,
                HtmlElementStore.OBJECT_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR, "earth picture"),
                new ImmutablePair(ARIA_LABEL_ATTR, "image"));             
        

        //----------------------------------------------------------------------
        //------------------------------2Failed-03------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.05-2Failed-03");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.INFORMATIVE_OBJ_NOT_INDENTICAL_ATTR_MSG,
                HtmlElementStore.OBJECT_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR, "earth picture"),
                new ImmutablePair(ARIA_LABEL_ATTR, "image"));             
        

        //----------------------------------------------------------------------
        //------------------------------2Failed-04------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.05-2Failed-04");
        checkResultIsFailed(processResult, 3, 3);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.INFORMATIVE_OBJ_NOT_INDENTICAL_ATTR_MSG,
                HtmlElementStore.OBJECT_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR, "earth picture"),
                new ImmutablePair(ARIA_LABEL_ATTR, "image"));    
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.INFORMATIVE_OBJ_NOT_INDENTICAL_ATTR_MSG,
                HtmlElementStore.OBJECT_ELEMENT,
                2,
                new ImmutablePair(TITLE_ATTR, "earth picture"),
                new ImmutablePair(ARIA_LABEL_ATTR, "image")); 
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.INFORMATIVE_OBJ_NOT_INDENTICAL_ATTR_MSG,
                HtmlElementStore.OBJECT_ELEMENT,
                3,
                new ImmutablePair(TITLE_ATTR, "earth picture"),
                new ImmutablePair(ARIA_LABEL_ATTR, "image"));          
        

        //----------------------------------------------------------------------
        //------------------------------2Failed-05------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.05-2Failed-05");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.INFORMATIVE_OBJ_NOT_INDENTICAL_ARIA_LABELLEDBY_MSG,
                HtmlElementStore.OBJECT_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR, "earth picture"),
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, "txt FAILED 05"));             
        

        //----------------------------------------------------------------------
        //------------------------------2Failed-06------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.05-2Failed-06");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.INFORMATIVE_OBJ_NOT_INDENTICAL_ARIA_LABELLEDBY_MSG,
                HtmlElementStore.OBJECT_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR, "earth picture"),
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, "txt FAILED 06"));             
        

        //----------------------------------------------------------------------
        //------------------------------2Failed-07------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.05-2Failed-07");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.INFORMATIVE_OBJ_NOT_INDENTICAL_ARIA_LABELLEDBY_MSG,
                HtmlElementStore.OBJECT_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR, "earth picture"),
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, "txt FAILED 07"));             
        

        //----------------------------------------------------------------------
        //------------------------------2Failed-08------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.05-2Failed-08");
        checkResultIsFailed(processResult, 3, 3);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.INFORMATIVE_OBJ_NOT_INDENTICAL_ARIA_LABELLEDBY_MSG,
                HtmlElementStore.OBJECT_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR, "earth picture"),
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, "txt FAILED 08")); 
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.INFORMATIVE_OBJ_NOT_INDENTICAL_ARIA_LABELLEDBY_MSG,
                HtmlElementStore.OBJECT_ELEMENT,
                2,
                new ImmutablePair(TITLE_ATTR, "earth picture"),
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, "txt FAILED 08"));  
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.INFORMATIVE_OBJ_NOT_INDENTICAL_ARIA_LABELLEDBY_MSG,
                HtmlElementStore.OBJECT_ELEMENT,
                3,
                new ImmutablePair(TITLE_ATTR, "earth picture"),
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, "txt FAILED 08"));   
        
        
        
       //----------------------------------------------------------------------
       //------------------------------3NMI-01---------------------------------
       //----------------------------------------------------------------------
       processResult = processPageTest("Rgaa32017.Test.01.03.05-3NMI-01");
       checkResultIsPreQualified(processResult, 1, 1);
       checkRemarkIsPresent(
                processResult,
                NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_INFORMATIVE_OBJ_DETECTED,
                OBJECT_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR, "earth picture"),
                new ImmutablePair(ARIA_LABEL_ATTR, "earth picture"));
        
        
        
       //----------------------------------------------------------------------
       //------------------------------3NMI-02---------------------------------
       //----------------------------------------------------------------------
       processResult = processPageTest("Rgaa32017.Test.01.03.05-3NMI-02");
       checkResultIsPreQualified(processResult, 1, 1);
       checkRemarkIsPresent(
                processResult,
                NEED_MORE_INFO,
                RemarkMessageStore.CHECK_OBJ_IMG_ARIA_MSG,
                OBJECT_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR, "earth picture"),
                new ImmutablePair(ARIA_LABEL_ATTR, "image"));
        
        
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-03---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.05-3NMI-03");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_INFORMATIVE_OBJ_WITH_LABELLEDBY_DETECTED,
                OBJECT_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR, "earth picture"),
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, "txt NMI 03"));
        
        
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-04---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.05-3NMI-04");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                NEED_MORE_INFO,
                RemarkMessageStore.CHECK_OBJ_IMG_ARIA_LABELLEDBY_MSG,
                OBJECT_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR, "earth picture"),
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, "txt NMI 04"));       
        
        
        
        
        //----------------------------------------------------------------------        
        //------------------------------4NA-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.01.03.05-4NA-01"));
             
        
        //----------------------------------------------------------------------        
        //------------------------------4NA-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.01.03.05-4NA-02"));
             
        
        //----------------------------------------------------------------------        
        //------------------------------4NA-03------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.01.03.05-4NA-03"));
             
        
        //----------------------------------------------------------------------        
        //------------------------------4NA-04------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.01.03.05-4NA-04"));
             
        
        //----------------------------------------------------------------------        
        //------------------------------4NA-05------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.01.03.05-4NA-05"));
        

    }
    
}
