/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2017  Tanaguru.org
 *
 * This program is free software: you can redistribute it and/or modify
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
 * Contact us by mail: tanaguru AT tanaguru DOT org
 */
package org.tanaguru.rules.rgaa32017;

import org.tanaguru.entity.audit.TestSolution;

import static org.tanaguru.rules.keystore.AttributeStore.PLACEHOLDER_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;
import static org.tanaguru.rules.keystore.HtmlElementStore.INPUT_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXTAREA_ELEMENT;
import static org.tanaguru.rules.keystore.RemarkMessageStore.TITLE_NOT_IDENTICAL_PLACEHOLDER;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.rules.rgaa32017.test.Rgaa32017RuleImplementationTestCase;

/**
 * Unit test class for the implementation of the rule 11-10-10 of the referential Rgaa 3-2017.
 *
 * @author
 */
public class Rgaa32017Rule111010Test extends Rgaa32017RuleImplementationTestCase {

    /**
     * Default constructor
     * @param testName
     */
    public Rgaa32017Rule111010Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.tanaguru.rules.rgaa32017.Rgaa32017Rule111010");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("Rgaa32017.Test.11.10.10-1Passed-01");
        addWebResource("Rgaa32017.Test.11.10.10-1Passed-02");
        addWebResource("Rgaa32017.Test.11.10.10-1Passed-03");
        addWebResource("Rgaa32017.Test.11.10.10-1Passed-04");
        addWebResource("Rgaa32017.Test.11.10.10-1Passed-05");
        addWebResource("Rgaa32017.Test.11.10.10-1Passed-06");
        addWebResource("Rgaa32017.Test.11.10.10-1Passed-07");
        addWebResource("Rgaa32017.Test.11.10.10-1Passed-08");
        addWebResource("Rgaa32017.Test.11.10.10-1Passed-09");
        addWebResource("Rgaa32017.Test.11.10.10-1Passed-10");
        addWebResource("Rgaa32017.Test.11.10.10-1Passed-11");
        addWebResource("Rgaa32017.Test.11.10.10-1Passed-12");
        addWebResource("Rgaa32017.Test.11.10.10-1Passed-13");
        addWebResource("Rgaa32017.Test.11.10.10-1Passed-14");
        addWebResource("Rgaa32017.Test.11.10.10-1Passed-15");
        addWebResource("Rgaa32017.Test.11.10.10-1Passed-16");
        addWebResource("Rgaa32017.Test.11.10.10-2Failed-01");
        addWebResource("Rgaa32017.Test.11.10.10-2Failed-02");
        addWebResource("Rgaa32017.Test.11.10.10-2Failed-03");
        addWebResource("Rgaa32017.Test.11.10.10-2Failed-04");
        addWebResource("Rgaa32017.Test.11.10.10-2Failed-05");
        addWebResource("Rgaa32017.Test.11.10.10-2Failed-06");
        addWebResource("Rgaa32017.Test.11.10.10-2Failed-07");
        addWebResource("Rgaa32017.Test.11.10.10-2Failed-08");
        addWebResource("Rgaa32017.Test.11.10.10-4NA-01");
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------1Passed-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.11.10.10-1Passed-01"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.11.10.10-1Passed-02"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-03------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.11.10.10-1Passed-03"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-04------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.11.10.10-1Passed-04"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-05------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.11.10.10-1Passed-05"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-06------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.11.10.10-1Passed-06"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-07------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.11.10.10-1Passed-07"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-08------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.11.10.10-1Passed-08"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-09------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.11.10.10-1Passed-09"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-10------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.11.10.10-1Passed-10"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-11------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.11.10.10-1Passed-11"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-12------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.11.10.10-1Passed-12"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-13------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.11.10.10-1Passed-13"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-14------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.11.10.10-1Passed-14"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-15------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.11.10.10-1Passed-15"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-16------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.11.10.10-1Passed-16"), 1);

        //----------------------------------------------------------------------
        //------------------------------2Failed-01------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("Rgaa32017.Test.11.10.10-2Failed-01");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                TITLE_NOT_IDENTICAL_PLACEHOLDER, 
                TEXTAREA_ELEMENT, 
                1,
                new ImmutablePair(PLACEHOLDER_ATTR, "FAILURE 01"),
                new ImmutablePair(TITLE_ATTR, "FAILED 01"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-02------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.10.10-2Failed-02");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                TITLE_NOT_IDENTICAL_PLACEHOLDER, 
                INPUT_ELEMENT, 
                1,
                new ImmutablePair(PLACEHOLDER_ATTR, "FAILURE 02"),
                new ImmutablePair(TITLE_ATTR, "FAILED 02"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-03------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.10.10-2Failed-03");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                TITLE_NOT_IDENTICAL_PLACEHOLDER, 
                INPUT_ELEMENT, 
                1,
                new ImmutablePair(PLACEHOLDER_ATTR, "FAILURE 03"),
                new ImmutablePair(TITLE_ATTR, "FAILED 03"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-04------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.10.10-2Failed-04");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                TITLE_NOT_IDENTICAL_PLACEHOLDER, 
                INPUT_ELEMENT, 
                1,
                new ImmutablePair(PLACEHOLDER_ATTR, "FAILURE 04"),
                new ImmutablePair(TITLE_ATTR, "FAILED 04"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-05------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.10.10-2Failed-05");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                TITLE_NOT_IDENTICAL_PLACEHOLDER, 
                INPUT_ELEMENT, 
                1,
                new ImmutablePair(PLACEHOLDER_ATTR, "FAILURE 05"),
                new ImmutablePair(TITLE_ATTR, "FAILED 05"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-06------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.10.10-2Failed-06");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                TITLE_NOT_IDENTICAL_PLACEHOLDER, 
                INPUT_ELEMENT, 
                1,
                new ImmutablePair(PLACEHOLDER_ATTR, "FAILURE 06"),
                new ImmutablePair(TITLE_ATTR, "FAILED 06"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-07------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.10.10-2Failed-07");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                TITLE_NOT_IDENTICAL_PLACEHOLDER, 
                INPUT_ELEMENT, 
                1,
                new ImmutablePair(PLACEHOLDER_ATTR, "FAILURE 07"),
                new ImmutablePair(TITLE_ATTR, "FAILED 07"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-08------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.10.10-2Failed-08");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                TITLE_NOT_IDENTICAL_PLACEHOLDER, 
                INPUT_ELEMENT, 
                1,
                new ImmutablePair(PLACEHOLDER_ATTR, "FAILURE 08"),
                new ImmutablePair(TITLE_ATTR, "FAILED 08"));



        //----------------------------------------------------------------------
        //------------------------------4NA-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.11.10.10-4NA-01"));
    }
}
