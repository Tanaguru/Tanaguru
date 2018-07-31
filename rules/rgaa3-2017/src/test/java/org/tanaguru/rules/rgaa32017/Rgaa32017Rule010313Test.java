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
import org.tanaguru.rules.keystore.AttributeStore;
import org.tanaguru.rules.keystore.HtmlElementStore;
import static org.tanaguru.rules.keystore.MarkerStore.DECORATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.INFORMATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.RemarkMessageStore.ALTERNATIVE_TOO_LONG_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_ALT_PERTINENCE_OF_INFORMATIVE_IMG_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_NATURE_OF_IMAGE_AND_ALT_LENGTH_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_NATURE_OF_IMAGE_AND_ALT_PERTINENCE_MSG;
import org.tanaguru.rules.rgaa32017.test.Rgaa32017RuleImplementationTestCase;

/**
 * Unit test class for the implementation of the rule 1-3-13 of the referential Rgaa 3-2017.
 *
 * @author
 */
public class Rgaa32017Rule010313Test extends Rgaa32017RuleImplementationTestCase {

    /**
     * Default constructor
     * @param testName
     */
    public Rgaa32017Rule010313Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.tanaguru.rules.rgaa32017.Rgaa32017Rule010313");
    }

    @Override
    protected void setUpWebResourceMap() {
//        addWebResource("Rgaa32017.Test.1.3.13-1Passed-01");
    //    addWebResource("Rgaa32017.Test.1.3.13-2Failed-01");
       addWebResource("Rgaa32017.Test.1.3.13-3NMI-01");
       addWebResource("Rgaa32017.Test.1.3.13-3NMI-02");
       addWebResource("Rgaa32017.Test.1.3.13-3NMI-03", 
                  createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "informative-image"));
        addWebResource("Rgaa32017.Test.1.3.13-3NMI-04",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "informative-image"));

        addWebResource("Rgaa32017.Test.1.3.13-4NA-01");
        addWebResource("Rgaa32017.Test.1.3.13-4NA-02",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "decorative-image"));
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------1Passed-01------------------------------
        //----------------------------------------------------------------------
//        checkResultIsPassed(processPageTest("Rgaa32017.Test.1.3.13-1Passed-01"), 1);

        //----------------------------------------------------------------------
        //------------------------------2Failed-01------------------------------
        //----------------------------------------------------------------------
//        ProcessResult processResult = processPageTest("Rgaa32017.Test.1.3.13-2Failed-01");
//        checkResultIsFailed(processResult, 1, 1);
//        checkRemarkIsPresent(
//                processResult,
//                TestSolution.FAILED,
//                ALT_MISSING_MSG,
//                "img",
//                1);

        //----------------------------------------------------------------------
        //------------------------------3NMI-01---------------------------------
        //----------------------------------------------------------------------
        ProcessResult  processResult = processPageTest("Rgaa32017.Test.1.3.13-3NMI-01");
        checkResultIsPreQualified(processResult,1,1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE_AND_ALT_PERTINENCE_MSG,
                HtmlElementStore.IMG_ELEMENT,
                1,
                new ImmutablePair(AttributeStore.ALT_ATTR, "Alt length less than than 80 char ..."));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-02---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.3.13-3NMI-02");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE_AND_ALT_LENGTH_MSG,
                HtmlElementStore.IMG_ELEMENT,
                1,
                new ImmutablePair(AttributeStore.ALT_ATTR, "1234567891234567891234567891234567891234567891234567891234567891234567891234567891234567899999999999"));
        //----------------------------------------------------------------------
        //------------------------------3NMI-03---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.3.13-3NMI-03");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_ALT_PERTINENCE_OF_INFORMATIVE_IMG_MSG,
                HtmlElementStore.IMG_ELEMENT,
                1,
                new ImmutablePair(AttributeStore.ALT_ATTR, "Alt length less than than 80 char ..."));
        //----------------------------------------------------------------------
        //------------------------------3NMI-04---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.3.13-3NMI-04");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                ALTERNATIVE_TOO_LONG_MSG,
                HtmlElementStore.IMG_ELEMENT,
                1,
                new ImmutablePair(AttributeStore.ALT_ATTR, "1234567891234567891234567891234567891234567891234567891234567891234567891234567891234567899999999999"));


        //----------------------------------------------------------------------
        //------------------------------4NA-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.1.3.13-4NA-01"));
        //----------------------------------------------------------------------
        //------------------------------4NA-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.1.3.13-4NA-02"));
    }

//    @Override
//    protected void setConsolidate() {
//
//        // The consolidate method can be removed when real implementation is done.
//        // The assertions are automatically tested regarding the file names by 
//        // the abstract parent class
//        assertEquals(TestSolution.NOT_TESTED,
//                consolidate("Rgaa32017.Test.1.3.13-3NMI-01").getValue());
//    }

}
