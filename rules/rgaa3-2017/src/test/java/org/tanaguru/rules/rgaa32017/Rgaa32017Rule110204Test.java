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

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.entity.audit.ProcessResult;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABELLEDBY_ATTR;
import org.tanaguru.rules.keystore.HtmlElementStore;
import org.tanaguru.rules.keystore.RemarkMessageStore;
import org.tanaguru.rules.rgaa32017.test.Rgaa32017RuleImplementationTestCase;

/**
 * Unit test class for the implementation of the rule 11-2-4 of the referential Rgaa 3-2017.
 *
 * @author
 */
public class Rgaa32017Rule110204Test extends Rgaa32017RuleImplementationTestCase {

    /**
     * Default constructor
     * @param testName
     */
    public Rgaa32017Rule110204Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.tanaguru.rules.rgaa32017.Rgaa32017Rule110204");
    }

    @Override
    protected void setUpWebResourceMap() {
//        addWebResource("Rgaa32017.Test.11.2.4-1Passed-01");
//        addWebResource("Rgaa32017.Test.11.2.4-2Failed-01");
        addWebResource("Rgaa32017.Test.11.2.4-3NMI-01");
        addWebResource("Rgaa32017.Test.11.2.4-3NMI-02");
        addWebResource("Rgaa32017.Test.11.2.4-3NMI-03");
        addWebResource("Rgaa32017.Test.11.2.4-3NMI-04");
        addWebResource("Rgaa32017.Test.11.2.4-4NA-01");
        addWebResource("Rgaa32017.Test.11.2.4-4NA-02");
        addWebResource("Rgaa32017.Test.11.2.4-4NA-03");
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------1Passed-01------------------------------
        //----------------------------------------------------------------------
//        checkResultIsPassed(processPageTest("Rgaa32017.Test.11.2.4-1Passed-01"), 1);

        //----------------------------------------------------------------------
        //------------------------------2Failed-01------------------------------
        //----------------------------------------------------------------------
//        ProcessResult processResult = processPageTest("Rgaa32017.Test.11.2.4-2Failed-01");
//        checkResultIsFailed(processResult, 1, 1);
//        checkRemarkIsPresent(
//                processResult,
//                TestSolution.FAILED,
//                "#MessageHere",
//                "#CurrentElementHere",
//                1,
//                new ImmutablePair("#ExtractedAttributeAsEvidence", "#ExtractedAttributeValue"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-01---------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("Rgaa32017.Test.11.2.4-3NMI-01");
         checkResultIsPreQualified(processResult, 1, 1);
         checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.MANUAL_CHECK_ON_ELEMENTS_MSG,
                HtmlElementStore.INPUT_ELEMENT,
                1,
                new ImmutablePair(ARIA_LABELLEDBY_ATTR,"my labelledby"));
        //----------------------------------------------------------------------
        //------------------------------3NMI-02---------------------------------
        //----------------------------------------------------------------------
          processResult = processPageTest("Rgaa32017.Test.11.2.4-3NMI-02");
         checkResultIsPreQualified(processResult, 2, 2);
         checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.MANUAL_CHECK_ON_ELEMENTS_MSG,
                HtmlElementStore.INPUT_ELEMENT,
                1,
                new ImmutablePair(ARIA_LABELLEDBY_ATTR,"my labelledby"));
         checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.MANUAL_CHECK_ON_ELEMENTS_MSG,
                HtmlElementStore.INPUT_ELEMENT,
                2,
                new ImmutablePair(ARIA_LABELLEDBY_ATTR,"my labelledby2"));
        //----------------------------------------------------------------------
        //------------------------------3NMI-03---------------------------------
        //----------------------------------------------------------------------
          processResult = processPageTest("Rgaa32017.Test.11.2.4-3NMI-03");
         checkResultIsPreQualified(processResult, 1, 1);
         checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.MANUAL_CHECK_ON_ELEMENTS_MSG,
                HtmlElementStore.INPUT_ELEMENT,
                1,
                new ImmutablePair(ARIA_LABELLEDBY_ATTR,"my labelledby"));
        //----------------------------------------------------------------------
        //------------------------------3NMI-04---------------------------------
        //----------------------------------------------------------------------
          processResult = processPageTest("Rgaa32017.Test.11.2.4-3NMI-04");
         checkResultIsPreQualified(processResult, 1, 1);
         checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.MANUAL_CHECK_ON_ELEMENTS_MSG,
                HtmlElementStore.INPUT_ELEMENT,
                1,
                new ImmutablePair(ARIA_LABELLEDBY_ATTR,"my labelledby"));

        //----------------------------------------------------------------------
        //------------------------------4NA-01------------------------------
        //----------------------------------------------------------------------
         checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.11.2.4-4NA-01"));
        //----------------------------------------------------------------------
        //------------------------------4NA-02------------------------------
        //----------------------------------------------------------------------
         checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.11.2.4-4NA-02"));
        //----------------------------------------------------------------------
        //------------------------------4NA-03------------------------------
        //----------------------------------------------------------------------
         checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.11.2.4-4NA-03"));
    }

    @Override
    protected void setConsolidate() {

        // The consolidate method can be removed when real implementation is done.
        // The assertions are automatically tested regarding the file names by 
        // the abstract parent class
//        assertEquals(TestSolution.NOT_TESTED,
//                consolidate("Rgaa32017.Test.11.2.4-3NMI-01").getValue());
    }

}
