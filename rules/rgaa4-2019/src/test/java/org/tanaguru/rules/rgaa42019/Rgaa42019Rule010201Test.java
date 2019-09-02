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
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.rules.rgaa42019.test.Rgaa42019RuleImplementationTestCase;

import static org.tanaguru.rules.keystore.HtmlElementStore.IMG_ELEMENT;
import static org.tanaguru.rules.keystore.RemarkMessageStore.INVALID_TEXT_ALTERNATIVE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_NATURE_OF_IMAGE;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_NATURE_OF_IMAGE_WITH_TEXT_ALTERNATIVE;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITH_TEXT_ALTERNATIVE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITHOUT_ROLE_PRESENTATION_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.SUSPECTED_DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.SUSPECTED_DECORATIVE_ELEMENT_WITHOUT_ROLE_PRESENTATION_MSG;
import static org.tanaguru.rules.keystore.MarkerStore.DECORATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.INFORMATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.AttributeStore.ALT_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABELLEDBY_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABEL_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.SRC_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_HIDDEN_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ROLE_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ABSENT_ATTRIBUTE_VALUE;

/**
 * Unit test class for the implementation of the rule 1-2-1 of the referential Rgaa 4-2019.
 *
 * @author edaconceicao
 */
public class Rgaa42019Rule010201Test extends Rgaa42019RuleImplementationTestCase {

    /**
     * Default constructor
     */
    public Rgaa42019Rule010201Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.tanaguru.rules.rgaa42019.Rgaa42019Rule010201");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("Rgaa42019.Test.01.02.01-1Passed-01",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
        addWebResource("Rgaa42019.Test.01.02.01-1Passed-02",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
        addWebResource("Rgaa42019.Test.01.02.01-1Passed-03",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
        addWebResource("Rgaa42019.Test.01.02.01-1Passed-04",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
        addWebResource("Rgaa42019.Test.01.02.01-1Passed-05",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
        addWebResource("Rgaa42019.Test.01.02.01-2Failed-01",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
        addWebResource("Rgaa42019.Test.01.02.01-2Failed-02",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
        addWebResource("Rgaa42019.Test.01.02.01-2Failed-03",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
        addWebResource("Rgaa42019.Test.01.02.01-2Failed-04",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
        addWebResource("Rgaa42019.Test.01.02.01-2Failed-05",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
        addWebResource("Rgaa42019.Test.01.02.01-2Failed-06",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
        addWebResource("Rgaa42019.Test.01.02.01-2Failed-07",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
//        addWebResource("Rgaa42019.Test.01.02.01-2Failed-08",
//                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
        addWebResource("Rgaa42019.Test.01.02.01-2Failed-09");
        addWebResource("Rgaa42019.Test.01.02.01-3NMI-01");
        addWebResource("Rgaa42019.Test.01.02.01-3NMI-02");
        addWebResource("Rgaa42019.Test.01.02.01-3NMI-03");
        addWebResource("Rgaa42019.Test.01.02.01-3NMI-04");
        addWebResource("Rgaa42019.Test.01.02.01-3NMI-05");
        addWebResource("Rgaa42019.Test.01.02.01-3NMI-06");
        addWebResource("Rgaa42019.Test.01.02.01-3NMI-07");
        addWebResource("Rgaa42019.Test.01.02.01-3NMI-08");
        addWebResource("Rgaa42019.Test.01.02.01-3NMI-09");
        addWebResource("Rgaa42019.Test.01.02.01-3NMI-10");
        addWebResource("Rgaa42019.Test.01.02.01-3NMI-11");
        addWebResource("Rgaa42019.Test.01.02.01-3NMI-12");
        addWebResource("Rgaa42019.Test.01.02.01-4NA-01",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "id-informative-image"));
        addWebResource("Rgaa42019.Test.01.02.01-4NA-02",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "id-informative-image"));
        addWebResource("Rgaa42019.Test.01.02.01-4NA-03",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "id-informative-image"));
        addWebResource("Rgaa42019.Test.01.02.01-4NA-04");
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------1Passed-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.01.02.01-1Passed-01"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.01.02.01-1Passed-02"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-03------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.01.02.01-1Passed-03"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-04------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.01.02.01-1Passed-04"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-05------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.01.02.01-1Passed-05"), 1);

        //----------------------------------------------------------------------
        //------------------------------2Failed-01------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("Rgaa42019.Test.01.02.01-2Failed-01");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                DECORATIVE_ELEMENT_WITH_TEXT_ALTERNATIVE_MSG,
                IMG_ELEMENT,
                1,
                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"),
                new ImmutablePair(ALT_ATTR, "text alternative"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-02------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.02.01-2Failed-02");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                DECORATIVE_ELEMENT_WITH_TEXT_ALTERNATIVE_MSG,
                IMG_ELEMENT,
                1,
                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"),
                new ImmutablePair(ARIA_LABEL_ATTR, "text alternative"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-03------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.02.01-2Failed-03");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                DECORATIVE_ELEMENT_WITH_TEXT_ALTERNATIVE_MSG,
                IMG_ELEMENT,
                1,
                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"),
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, "FAILED-03"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-04------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.02.01-2Failed-04");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                DECORATIVE_ELEMENT_WITH_TEXT_ALTERNATIVE_MSG,
                IMG_ELEMENT,
                1,
                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"),
                new ImmutablePair(TITLE_ATTR, "text alternative"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-05------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.02.01-2Failed-05");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                INVALID_TEXT_ALTERNATIVE_MSG,
                IMG_ELEMENT,
                1,
                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"),
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, "text alternative"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-06------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.02.01-2Failed-06");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                DECORATIVE_ELEMENT_WITHOUT_ROLE_PRESENTATION_MSG,
                IMG_ELEMENT,
                1,
                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"),
                new ImmutablePair(ROLE_ATTR, "logo"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-07------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.02.01-2Failed-07");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG,
                IMG_ELEMENT,
                1,
                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"),
                new ImmutablePair(ARIA_HIDDEN_ATTR, "false"));

//        //----------------------------------------------------------------------
//        //------------------------------2Failed-08------------------------------
//        //----------------------------------------------------------------------
//        processResult = processPageTest("Rgaa42019.Test.01.02.01-2Failed-08");
//        checkResultIsFailed(processResult, 1, 1);
//        checkRemarkIsPresent(
//                processResult,
//                TestSolution.FAILED,
//                DECORATIVE_ELEMENT_WITH_TEXT_ALTERNATIVE_MSG,
//                IMG_ELEMENT,
//                1,
//                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-09------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.02.01-2Failed-09");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                INVALID_TEXT_ALTERNATIVE_MSG,
                IMG_ELEMENT,
                1,
                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"),
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, "text alternative"));


        //----------------------------------------------------------------------
        //------------------------------3NMI-01---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.02.01-3NMI-01");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE,
                IMG_ELEMENT,
                1,
                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-02---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.02.01-3NMI-02");
        checkResultIsPreQualified(processResult, 1, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE,
                IMG_ELEMENT,
                1,
                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"),
                new ImmutablePair(ARIA_HIDDEN_ATTR, "true"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE,
                IMG_ELEMENT,
                2,
                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-03---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.02.01-3NMI-03");
        checkResultIsPreQualified(processResult, 1, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE,
                IMG_ELEMENT,
                1,
                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"),
                new ImmutablePair(ROLE_ATTR, "presentation"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE,
                IMG_ELEMENT,
                2,
                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-04---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.02.01-3NMI-04");
        checkResultIsPreQualified(processResult, 1, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE,
                IMG_ELEMENT,
                1,
                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"),
                new ImmutablePair(ROLE_ATTR, "presentation"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE,
                IMG_ELEMENT,
                2,
                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-05---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.02.01-3NMI-05");
        checkResultIsPreQualified(processResult, 1, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE,
                IMG_ELEMENT,
                1,
                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"),
                new ImmutablePair(ARIA_HIDDEN_ATTR, "true"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE,
                IMG_ELEMENT,
                2,
                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-06---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.02.01-3NMI-06");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE_WITH_TEXT_ALTERNATIVE,
                IMG_ELEMENT,
                1,
                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"),
                new ImmutablePair(ALT_ATTR, "text alternative"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-07---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.02.01-3NMI-07");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE_WITH_TEXT_ALTERNATIVE,
                IMG_ELEMENT,
                1,
                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"),
                new ImmutablePair(ARIA_LABEL_ATTR, "text alternative"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-08---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.02.01-3NMI-08");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE_WITH_TEXT_ALTERNATIVE,
                IMG_ELEMENT,
                1,
                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"),
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, "NMI-08"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-09---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.02.01-3NMI-09");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE_WITH_TEXT_ALTERNATIVE,
                IMG_ELEMENT,
                1,
                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"),
                new ImmutablePair(TITLE_ATTR, "text alternative"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-10---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.02.01-3NMI-10");
        checkResultIsPreQualified(processResult, 1, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                SUSPECTED_DECORATIVE_ELEMENT_WITHOUT_ROLE_PRESENTATION_MSG,
                IMG_ELEMENT,
                1,
                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"),
                new ImmutablePair(ROLE_ATTR, "logo"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE,
                IMG_ELEMENT,
                2,
                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-11---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.02.01-3NMI-11");
        checkResultIsPreQualified(processResult, 1, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                SUSPECTED_DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG,
                IMG_ELEMENT,
                1,
                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"),
                new ImmutablePair(ARIA_HIDDEN_ATTR, "false"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE,
                IMG_ELEMENT,
                2,
                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-12---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.02.01-3NMI-12");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE,
                IMG_ELEMENT,
                1,
                new ImmutablePair(SRC_ATTR, "mock-decorative-image.jpg"));
        
        //----------------------------------------------------------------------
        //------------------------------4NA-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.01.02.01-4NA-01"));
        
        //----------------------------------------------------------------------
        //------------------------------4NA-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.01.02.01-4NA-02"));
        
        //----------------------------------------------------------------------
        //------------------------------4NA-03------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.01.02.01-4NA-03"));
        
        //----------------------------------------------------------------------
        //------------------------------4NA-04------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.01.02.01-4NA-04"));
    }
}
