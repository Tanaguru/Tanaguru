/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2015  Tanaguru.org
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
package org.tanaguru.rules.rgaa42019;

import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.entity.audit.ProcessResult;

import static org.tanaguru.rules.keystore.AttributeStore.ID_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ROLE_ATTR;
import static org.tanaguru.rules.keystore.HtmlElementStore.DIV_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.IMG_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.P_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.SPAN_ELEMENT;
import static org.tanaguru.rules.keystore.RemarkMessageStore.ALT_IMG_FORM_LABEL_EMPTY;
import static org.tanaguru.rules.keystore.RemarkMessageStore.ARIA_FORM_LABEL_EMPTY;
import static org.tanaguru.rules.keystore.RemarkMessageStore.ARIA_FORM_LABEL_MISSING;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.rules.rgaa42019.test.Rgaa42019RuleImplementationTestCase;

/**
 * Unit test class for the implementation of the rule 7-1-1 of the referential Rgaa 4-2019.
 *
 * @author edaconceicao
 */
public class Rgaa42019Rule070101Test extends Rgaa42019RuleImplementationTestCase {

    /**
     * Default constructor
     */
    public Rgaa42019Rule070101Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.tanaguru.rules.rgaa42019.Rgaa42019Rule070101");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("Rgaa42019.Test.07.01.01-1Passed-01");
        addWebResource("Rgaa42019.Test.07.01.01-1Passed-02");
        addWebResource("Rgaa42019.Test.07.01.01-1Passed-03");
        addWebResource("Rgaa42019.Test.07.01.01-1Passed-04");
        addWebResource("Rgaa42019.Test.07.01.01-1Passed-05");
        addWebResource("Rgaa42019.Test.07.01.01-1Passed-06");
        addWebResource("Rgaa42019.Test.07.01.01-1Passed-07");
        addWebResource("Rgaa42019.Test.07.01.01-1Passed-08");
        addWebResource("Rgaa42019.Test.07.01.01-1Passed-09");
        addWebResource("Rgaa42019.Test.07.01.01-1Passed-10");
        addWebResource("Rgaa42019.Test.07.01.01-1Passed-11");
        addWebResource("Rgaa42019.Test.07.01.01-1Passed-12");
        addWebResource("Rgaa42019.Test.07.01.01-1Passed-13");
        addWebResource("Rgaa42019.Test.07.01.01-1Passed-14");
        addWebResource("Rgaa42019.Test.07.01.01-1Passed-15");
        addWebResource("Rgaa42019.Test.07.01.01-1Passed-16");
        addWebResource("Rgaa42019.Test.07.01.01-2Failed-01");
        addWebResource("Rgaa42019.Test.07.01.01-2Failed-02");
        addWebResource("Rgaa42019.Test.07.01.01-2Failed-03");
        addWebResource("Rgaa42019.Test.07.01.01-2Failed-04");
        addWebResource("Rgaa42019.Test.07.01.01-2Failed-05");
        addWebResource("Rgaa42019.Test.07.01.01-2Failed-06");
        addWebResource("Rgaa42019.Test.07.01.01-2Failed-07");
        addWebResource("Rgaa42019.Test.07.01.01-2Failed-08");
        addWebResource("Rgaa42019.Test.07.01.01-2Failed-09");
        addWebResource("Rgaa42019.Test.07.01.01-2Failed-10");
        addWebResource("Rgaa42019.Test.07.01.01-2Failed-11");
        addWebResource("Rgaa42019.Test.07.01.01-2Failed-12");
        addWebResource("Rgaa42019.Test.07.01.01-2Failed-13");
        addWebResource("Rgaa42019.Test.07.01.01-2Failed-14");
        addWebResource("Rgaa42019.Test.07.01.01-2Failed-15");
        addWebResource("Rgaa42019.Test.07.01.01-2Failed-16");
        addWebResource("Rgaa42019.Test.07.01.01-2Failed-17");
        addWebResource("Rgaa42019.Test.07.01.01-2Failed-18");
        addWebResource("Rgaa42019.Test.07.01.01-2Failed-19");
        addWebResource("Rgaa42019.Test.07.01.01-2Failed-20");
        addWebResource("Rgaa42019.Test.07.01.01-4NA-01");
        addWebResource("Rgaa42019.Test.07.01.01-4NA-02");
        addWebResource("Rgaa42019.Test.07.01.01-4NA-03");
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------1Passed-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.07.01.01-1Passed-01"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.07.01.01-1Passed-02"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-03------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.07.01.01-1Passed-03"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-04------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.07.01.01-1Passed-04"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-05------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.07.01.01-1Passed-05"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-06------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.07.01.01-1Passed-06"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-07------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.07.01.01-1Passed-07"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-08------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.07.01.01-1Passed-08"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-09------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.07.01.01-1Passed-09"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-10------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.07.01.01-1Passed-10"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-11------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.07.01.01-1Passed-11"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-12------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.07.01.01-1Passed-12"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-13------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.07.01.01-1Passed-13"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-14------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.07.01.01-1Passed-14"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-15------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.07.01.01-1Passed-15"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-16------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.07.01.01-1Passed-16"), 1);
        
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-01------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("Rgaa42019.Test.07.01.01-2Failed-01");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                ARIA_FORM_LABEL_EMPTY,
                SPAN_ELEMENT,
                1,
                new ImmutablePair(ROLE_ATTR, "checkbox"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-02------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.07.01.01-2Failed-02");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                ARIA_FORM_LABEL_EMPTY,
                SPAN_ELEMENT,
                1,
                new ImmutablePair(ROLE_ATTR, "checkbox"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-03------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.07.01.01-2Failed-03");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                ARIA_FORM_LABEL_EMPTY,
                P_ELEMENT,
                1,
                new ImmutablePair(ID_ATTR, "FAILED 03"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-04------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.07.01.01-2Failed-04");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                ALT_IMG_FORM_LABEL_EMPTY,
                IMG_ELEMENT,
                1,
                new ImmutablePair(ROLE_ATTR, "checkbox"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-05------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.07.01.01-2Failed-05");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                ARIA_FORM_LABEL_EMPTY,
                DIV_ELEMENT,
                1,
                new ImmutablePair(ROLE_ATTR, "radio"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-06------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.07.01.01-2Failed-06");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                ARIA_FORM_LABEL_EMPTY,
                DIV_ELEMENT,
                1,
                new ImmutablePair(ROLE_ATTR, "radio"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-07------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.07.01.01-2Failed-07");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                ARIA_FORM_LABEL_EMPTY,
                P_ELEMENT,
                1,
                new ImmutablePair(ID_ATTR, "FAILED 07"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-08------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.07.01.01-2Failed-08");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                ALT_IMG_FORM_LABEL_EMPTY,
                IMG_ELEMENT,
                1,
                new ImmutablePair(ROLE_ATTR, "radio"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-09------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.07.01.01-2Failed-09");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                ARIA_FORM_LABEL_EMPTY,
                DIV_ELEMENT,
                1,
                new ImmutablePair(ROLE_ATTR, "textbox"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-10------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.07.01.01-2Failed-10");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                ARIA_FORM_LABEL_EMPTY,
                DIV_ELEMENT,
                1,
                new ImmutablePair(ROLE_ATTR, "textbox"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-11------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.07.01.01-2Failed-11");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                ARIA_FORM_LABEL_EMPTY,
                P_ELEMENT,
                1,
                new ImmutablePair(ID_ATTR, "FAILED 11"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-12------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.07.01.01-2Failed-12");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                ALT_IMG_FORM_LABEL_EMPTY,
                IMG_ELEMENT,
                1,
                new ImmutablePair(ROLE_ATTR, "textbox"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-13------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.07.01.01-2Failed-13");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                ARIA_FORM_LABEL_EMPTY,
                DIV_ELEMENT,
                1,
                new ImmutablePair(ROLE_ATTR, "combobox"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-14------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.07.01.01-2Failed-14");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                ARIA_FORM_LABEL_EMPTY,
                DIV_ELEMENT,
                1,
                new ImmutablePair(ROLE_ATTR, "combobox"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-15------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.07.01.01-2Failed-15");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                ARIA_FORM_LABEL_EMPTY,
                P_ELEMENT,
                1,
                new ImmutablePair(ID_ATTR, "FAILED 15"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-16------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.07.01.01-2Failed-16");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                ALT_IMG_FORM_LABEL_EMPTY,
                IMG_ELEMENT,
                1,
                new ImmutablePair(ROLE_ATTR, "combobox"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-17------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.07.01.01-2Failed-17");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                ARIA_FORM_LABEL_MISSING,
                SPAN_ELEMENT,
                1,
                new ImmutablePair(ROLE_ATTR, "checkbox"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-18------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.07.01.01-2Failed-18");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                ARIA_FORM_LABEL_MISSING,
                DIV_ELEMENT,
                1,
                new ImmutablePair(ROLE_ATTR, "radio"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-19------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.07.01.01-2Failed-19");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                ARIA_FORM_LABEL_MISSING,
                DIV_ELEMENT,
                1,
                new ImmutablePair(ROLE_ATTR, "textbox"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-20------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.07.01.01-2Failed-20");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                ARIA_FORM_LABEL_MISSING,
                DIV_ELEMENT,
                1,
                new ImmutablePair(ROLE_ATTR, "combobox"));



        //----------------------------------------------------------------------
        //------------------------------4NA-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.07.01.01-4NA-01"));
        
        //----------------------------------------------------------------------
        //------------------------------4NA-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.07.01.01-4NA-02"));
        
        //----------------------------------------------------------------------
        //------------------------------4NA-03------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.07.01.01-4NA-03"));
    }

}
