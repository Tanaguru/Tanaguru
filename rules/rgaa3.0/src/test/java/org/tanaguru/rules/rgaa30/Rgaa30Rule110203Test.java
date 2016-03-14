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
package org.tanaguru.rules.rgaa30;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.entity.audit.TestSolution;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABEL_ATTR;
import org.tanaguru.rules.keystore.HtmlElementStore;
import org.tanaguru.rules.keystore.RemarkMessageStore;
import org.tanaguru.rules.rgaa30.test.Rgaa30RuleImplementationTestCase;

/**
 * Unit test class for the implementation of the rule 11-2-3 of the referential Rgaa 3.0.
 *
 * @author
 */
public class Rgaa30Rule110203Test extends Rgaa30RuleImplementationTestCase {

    /**
     * Default constructor
     * @param testName
     */
    public Rgaa30Rule110203Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.tanaguru.rules.rgaa30.Rgaa30Rule110203");
    }

    @Override
    protected void setUpWebResourceMap() {
//        addWebResource("Rgaa30.Test.11.2.3-1Passed-01");
//        addWebResource("Rgaa30.Test.11.2.3-2Failed-01");
        addWebResource("Rgaa30.Test.11.2.3-3NMI-01");
        addWebResource("Rgaa30.Test.11.2.3-3NMI-02");
        addWebResource("Rgaa30.Test.11.2.3-3NMI-03");
        addWebResource("Rgaa30.Test.11.2.3-4NA-01");
        addWebResource("Rgaa30.Test.11.2.3-4NA-02");
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------1Passed-01------------------------------
        //----------------------------------------------------------------------
//        checkResultIsPassed(processPageTest("Rgaa30.Test.11.2.3-1Passed-01"), 1);

        //----------------------------------------------------------------------
        //------------------------------2Failed-01------------------------------
        //----------------------------------------------------------------------
//        ProcessResult processResult = processPageTest("Rgaa30.Test.11.2.3-2Failed-01");
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
        ProcessResult processResult = processPageTest("Rgaa30.Test.11.2.3-3NMI-01");
       checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
               TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.MANUAL_CHECK_ON_ELEMENTS_MSG,
                HtmlElementStore.INPUT_ELEMENT,
                1,
                new ImmutablePair(ARIA_LABEL_ATTR,"my input"));
        //----------------------------------------------------------------------
        //------------------------------3NMI-02---------------------------------
        //----------------------------------------------------------------------
         processResult = processPageTest("Rgaa30.Test.11.2.3-3NMI-02");
       checkResultIsPreQualified(processResult, 2, 2);
        checkRemarkIsPresent(
                processResult,
               TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.MANUAL_CHECK_ON_ELEMENTS_MSG,
                HtmlElementStore.INPUT_ELEMENT,
                1,
                new ImmutablePair(ARIA_LABEL_ATTR,"my input1"));
         checkRemarkIsPresent(
                processResult,
               TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.MANUAL_CHECK_ON_ELEMENTS_MSG,
                HtmlElementStore.INPUT_ELEMENT,
                2,
                new ImmutablePair(ARIA_LABEL_ATTR,"my input2"));
        //----------------------------------------------------------------------
        //------------------------------3NMI-03---------------------------------
        //----------------------------------------------------------------------
         processResult = processPageTest("Rgaa30.Test.11.2.3-3NMI-03");
       checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
               TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.MANUAL_CHECK_ON_ELEMENTS_MSG,
                HtmlElementStore.INPUT_ELEMENT,
                1,
                new ImmutablePair(ARIA_LABEL_ATTR,"my input"));


        //----------------------------------------------------------------------
        //------------------------------4NA-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa30.Test.11.2.3-4NA-01"));
        //----------------------------------------------------------------------
        //------------------------------4NA-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa30.Test.11.2.3-4NA-02"));
    }

    @Override
    protected void setConsolidate() {

        // The consolidate method can be removed when real implementation is done.
        // The assertions are automatically tested regarding the file names by 
        // the abstract parent class
//        assertEquals(TestSolution.NOT_TESTED,
//                consolidate("Rgaa30.Test.11.2.3-3NMI-01").getValue());
    }

}
