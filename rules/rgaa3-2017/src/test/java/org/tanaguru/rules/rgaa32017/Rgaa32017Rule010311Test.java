/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tanaguru.rules.rgaa32017;

import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.rules.rgaa32017.test.Rgaa32017RuleImplementationTestCase;

/**
 *
 * @author tanaguru
 */
public class Rgaa32017Rule010311Test extends Rgaa32017RuleImplementationTestCase {

    public Rgaa32017Rule010311Test(String testName) {
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName("org.tanaguru.rules.rgaa32017.Rgaa32017Rule010311");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("Rgaa32017.Test.1.3.11-3NMI-01");
        addWebResource("Rgaa32017.Test.1.3.11-4NA-01");
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------1passed-01---------------------------------
        //----------------------------------------------------------------------
        //checkResultIsPassed(processPageTest("Rgaa32017.Test.1.3.11-3NMI-01"), 2);
        
        
         //------------------------------3NMI-02---------------------------------
        
       ProcessResult processResult = processPageTest("Rgaa32017.Test.1.3.11-3NMI-01");
        checkResultIsPreQualified(processResult, 2, 2);
        
        //------------------------------4NA-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.1.3.11-4NA-01"));

    }
    
}
