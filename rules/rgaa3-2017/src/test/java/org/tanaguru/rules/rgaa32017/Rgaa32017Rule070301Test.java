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
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.rules.rgaa32017.test.Rgaa32017RuleImplementationTestCase;
import static org.tanaguru.rules.keystore.AttributeStore.*;
import static org.tanaguru.rules.keystore.HtmlElementStore.*;
import static org.tanaguru.rules.keystore.RemarkMessageStore.TABINDEX_DETECTED_MSG;

/**
 * Unit test class for the implementation of the rule 7-3-1 of the referential Rgaa 3-2017.
 *
 * @author
 */
public class Rgaa32017Rule070301Test extends Rgaa32017RuleImplementationTestCase {	 
	 
    /**
     * Default constructor
     * @param testName
     */
    public Rgaa32017Rule070301Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.tanaguru.rules.rgaa32017.Rgaa32017Rule070301");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("Rgaa32017.Test.7.3.1-1Passed-01");
        addWebResource("Rgaa32017.Test.7.3.1-1Passed-02");
        addWebResource("Rgaa32017.Test.7.3.1-1Passed-03");
        addWebResource("Rgaa32017.Test.7.3.1-1Passed-04");
        addWebResource("Rgaa32017.Test.7.3.1-2Failed-01");
        addWebResource("Rgaa32017.Test.7.3.1-2Failed-02");
        addWebResource("Rgaa32017.Test.7.3.1-2Failed-03");
        addWebResource("Rgaa32017.Test.7.3.1-2Failed-04");
        addWebResource("Rgaa32017.Test.7.3.1-4NA-01");
        addWebResource("Rgaa32017.Test.7.3.1-4NA-02");
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------1Passed-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.7.3.1-1Passed-01"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.7.3.1-1Passed-02"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-03------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.7.3.1-1Passed-03"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-04------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.7.3.1-1Passed-04"), 1);

        //----------------------------------------------------------------------
        //------------------------------2Failed-01------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("Rgaa32017.Test.7.3.1-2Failed-01");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                TABINDEX_DETECTED_MSG,
                SPAN_ELEMENT,
                1,
                new ImmutablePair(ROLE_ATTR, "checkbox"),
                new ImmutablePair(TABINDEX_ATTR, "0"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-02------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.7.3.1-2Failed-02");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                TABINDEX_DETECTED_MSG,
                DIV_ELEMENT,
                1,
                new ImmutablePair(ROLE_ATTR, "combobox"),
                new ImmutablePair(TABINDEX_ATTR, "0"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-03------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.7.3.1-2Failed-03");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                TABINDEX_DETECTED_MSG,
                DIV_ELEMENT,
                1,
                new ImmutablePair(ROLE_ATTR, "textbox"),
                new ImmutablePair(TABINDEX_ATTR, "0"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-04------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.7.3.1-2Failed-04");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                TABINDEX_DETECTED_MSG,
                DIV_ELEMENT,
                1,
                new ImmutablePair(ROLE_ATTR, "radio"),
                new ImmutablePair(TABINDEX_ATTR, "0"));


        //----------------------------------------------------------------------
        //------------------------------4NA-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.7.3.1-4NA-01"));
        
        //----------------------------------------------------------------------
        //------------------------------4NA-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.7.3.1-4NA-02"));
    }
}
