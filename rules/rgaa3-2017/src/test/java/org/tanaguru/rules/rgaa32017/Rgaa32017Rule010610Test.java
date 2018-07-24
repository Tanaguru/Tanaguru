/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tanaguru.rules.rgaa32017;
import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.entity.audit.TestSolution;
import static org.tanaguru.rules.keystore.HtmlElementStore.AREA_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.CANVAS_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.EMBED_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.IMG_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.OBJECT_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.SVG_ELEMENT;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_IMG_TAGS_MSG;
import org.tanaguru.rules.rgaa32017.test.Rgaa32017RuleImplementationTestCase;
 
/**
 *
 * @author tanaguru
 */
public class Rgaa32017Rule010610Test extends Rgaa32017RuleImplementationTestCase{
 
    public Rgaa32017Rule010610Test(String testName) {
        super(testName);
    }
 
    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName("org.tanaguru.rules.rgaa32017.Rgaa32017Rule010610");
    }
 
    @Override
    protected void setUpWebResourceMap() {
        addWebResource("Rgaa32017.Test.1.6.10-3NMI-01");
        //        addWebResource("Rgaa32017.Test.1.6.10-4NA-01"); //ok
    }
 
    @Override
    protected void setProcess() {
        //------------------------------3NMI-01---------------------------------
        
        ProcessResult processResult = processPageTest("Rgaa32017.Test.1.6.10-3NMI-01");
        checkResultIsPreQualified(processResult, 6, 6); 
        
        
        //For the <object>
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_IMG_TAGS_MSG,
                OBJECT_ELEMENT,
                1);
        
        
        //For the <embed>
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_IMG_TAGS_MSG,
                EMBED_ELEMENT,
                2);
       
        
        //For the <canvas>
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_IMG_TAGS_MSG,
                CANVAS_ELEMENT,
                3);
        
        
        //For the <img>
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_IMG_TAGS_MSG,
                IMG_ELEMENT,
                4);
        
        
        //For the <area>
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_IMG_TAGS_MSG,
                AREA_ELEMENT,
                5);
        
        
        //For the <svg>
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_IMG_TAGS_MSG,
                SVG_ELEMENT,
                6);
        
        
        //------------------------------4NA-01------------------------------
        //----------------------------------------------------------------------
//        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.1.6.10-4NA-01")); //ok
 
    }
    
}