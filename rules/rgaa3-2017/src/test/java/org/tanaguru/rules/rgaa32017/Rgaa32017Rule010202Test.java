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
import org.tanaguru.entity.audit.*;
import static org.tanaguru.rules.keystore.AttributeStore.ABSENT_ATTRIBUTE_VALUE;
import static org.tanaguru.rules.keystore.AttributeStore.ALT_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ROLE_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABEL_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABELLEDBY_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_DESCRIBEDBY_ATTR;
import org.tanaguru.rules.rgaa32017.test.Rgaa32017RuleImplementationTestCase;
import static org.tanaguru.rules.keystore.HtmlElementStore.AREA_ELEMENT;
import static org.tanaguru.rules.keystore.MarkerStore.DECORATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.INFORMATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITH_ARIA_DESCRIBEDBY_ATTR_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITH_ARIA_LABELLEDBY_ATTR_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITH_ARIA_LABEL_ATTR_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITH_ROLE_ATTR_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITH_TITLE_ATTR_MSG;

import org.tanaguru.rules.keystore.RemarkMessageStore;

/**
 * Unit test class for the implementation of the rule 1-2-2 of the referential
 * Rgaa 3-2017.
 *
 * @author jkowalczyk
 */
public class Rgaa32017Rule010202Test extends Rgaa32017RuleImplementationTestCase {

    /**
     * Default constructor
     *
     * @param testName
     */
    public Rgaa32017Rule010202Test(String testName) {
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName("org.tanaguru.rules.rgaa32017.Rgaa32017Rule010202");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("Rgaa32017.Test.01.02.02-1Passed-01",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-1Passed-02",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "class-decorative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-1Passed-03",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-area;class-decorative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-1Passed-04",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-area"),
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "class-informative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-2Failed-01",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-2Failed-02",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "class-decorative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-2Failed-03",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "role-decorative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-2Failed-04",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-area;class-decorative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-2Failed-05",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-area"),
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "class-informative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-2Failed-06",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "class-decorative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-2Failed-07",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "class-decorative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-2Failed-08",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "class-decorative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-2Failed-09",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "class-decorative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-2Failed-10",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "class-decorative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-2Failed-11",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "class-decorative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-3NMI-01");
        addWebResource("Rgaa32017.Test.01.02.02-3NMI-02");
        addWebResource("Rgaa32017.Test.01.02.02-3NMI-03",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "class-informative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-3NMI-04",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "class-informative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-3NMI-05",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "class-decorative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-3NMI-06",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-3NMI-07",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-3NMI-08",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-3NMI-09",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-3NMI-10",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-3NMI-11",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-4NA-01");
        addWebResource("Rgaa32017.Test.01.02.02-4NA-02");
        addWebResource("Rgaa32017.Test.01.02.02-4NA-03");
        addWebResource("Rgaa32017.Test.01.02.02-4NA-04");
        addWebResource("Rgaa32017.Test.01.02.02-4NA-05",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-4NA-06",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "class-decorative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-4NA-07",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "role-decorative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-4NA-08",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-area;class-decorative-area;role-decorative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-4NA-09",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-area"),
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "class-informative-area"));
        addWebResource("Rgaa32017.Test.01.02.02-4NA-10");

    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------1Passed-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.01.02.02-1Passed-01"), 1);

        //----------------------------------------------------------------------
        //------------------------------1Passed-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.01.02.02-1Passed-02"), 1);

        //----------------------------------------------------------------------
        //------------------------------1Passed-03------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.01.02.02-1Passed-03"), 2);

        //----------------------------------------------------------------------
        //------------------------------1Passed-04------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.01.02.02-1Passed-04"), 1);

        //----------------------------------------------------------------------
        //------------------------------2Failed-01------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("Rgaa32017.Test.01.02.02-2Failed-01");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.DECORATIVE_ELEMENT_WITH_NOT_EMPTY_ALT_MSG,
                AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, "Not empty alt"),
                new ImmutablePair(TITLE_ATTR, ABSENT_ATTRIBUTE_VALUE)
                );

        //------------------------------2Failed-02------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.02.02-2Failed-02");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.DECORATIVE_ELEMENT_WITH_NOT_EMPTY_ALT_MSG,
                AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, "Not empty alt"),
                new ImmutablePair(TITLE_ATTR, ABSENT_ATTRIBUTE_VALUE));

        //----------------------------------------------------------------------
        //------------------------------2Failed-03------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.02.02-2Failed-03");
        checkResultIsFailed(processResult, 1, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.DECORATIVE_ELEMENT_WITH_NOT_EMPTY_ALT_MSG,
                AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, "Not empty alt"),
                new ImmutablePair(TITLE_ATTR, ABSENT_ATTRIBUTE_VALUE));
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.DECORATIVE_ELEMENT_WITH_ROLE_ATTR_MSG,
                AREA_ELEMENT,
                2,
                new ImmutablePair(ROLE_ATTR, "role-decorative-area"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-04------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.02.02-2Failed-04");
        checkResultIsFailed(processResult, 2, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.DECORATIVE_ELEMENT_WITH_NOT_EMPTY_ALT_MSG,
                AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, "Not empty alt"),
                new ImmutablePair(TITLE_ATTR, ABSENT_ATTRIBUTE_VALUE));
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.DECORATIVE_ELEMENT_WITH_NOT_EMPTY_ALT_MSG,
                AREA_ELEMENT,
                2,
                new ImmutablePair(ALT_ATTR, "Not empty alt"),
                new ImmutablePair(TITLE_ATTR, ABSENT_ATTRIBUTE_VALUE));

        //----------------------------------------------------------------------
        //------------------------------2Failed-05------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.02.02-2Failed-05");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.DECORATIVE_ELEMENT_WITH_NOT_EMPTY_ALT_MSG,
                AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, "Not empty alt"),
                new ImmutablePair(TITLE_ATTR, ABSENT_ATTRIBUTE_VALUE));

        //----------------------------------------------------------------------
        //------------------------------2Failed-06------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.02.02-2Failed-06");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.DECORATIVE_ELEMENT_WITH_TITLE_ATTR_MSG,
                AREA_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR, "title attribute"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-07------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.02.02-2Failed-07");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.DECORATIVE_ELEMENT_WITH_TITLE_ATTR_MSG,
                AREA_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR, ""));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-08------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.02.02-2Failed-08");
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.DECORATIVE_ELEMENT_WITH_ARIA_LABEL_ATTR_MSG,
                AREA_ELEMENT,
                1,
                new ImmutablePair(ARIA_LABEL_ATTR, ""));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-09------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.02.02-2Failed-09");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.DECORATIVE_ELEMENT_WITH_ARIA_LABELLEDBY_ATTR_MSG,
                AREA_ELEMENT,
                1,
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, ""));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-10------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.02.02-2Failed-10");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.DECORATIVE_ELEMENT_WITH_ARIA_DESCRIBEDBY_ATTR_MSG,
                AREA_ELEMENT,
                1,
                new ImmutablePair(ARIA_DESCRIBEDBY_ATTR, ""));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-11------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.02.02-2Failed-11");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.DECORATIVE_ELEMENT_WITH_ROLE_ATTR_MSG,
                AREA_ELEMENT,
                1,
                new ImmutablePair(ROLE_ATTR, "img"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-01---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.02.02-3NMI-01");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_ELEMENT_WITH_NOT_EMPTY_ALT_MSG,
                AREA_ELEMENT,
                1);

        //----------------------------------------------------------------------
        //------------------------------3NMI-02---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.02.02-3NMI-02");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_ELEMENT_WITH_EMPTY_ALT_MSG,
                AREA_ELEMENT,
                1);

        //----------------------------------------------------------------------
        //------------------------------3NMI-03---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.02.02-3NMI-03");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_ELEMENT_WITH_NOT_EMPTY_ALT_MSG,
                AREA_ELEMENT,
                1);

        //----------------------------------------------------------------------
        //------------------------------3NMI-04---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.02.02-3NMI-04");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_ELEMENT_WITH_EMPTY_ALT_MSG,
                AREA_ELEMENT,
                1);

        //----------------------------------------------------------------------
        //------------------------------3NMI-05---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.02.02-3NMI-05");
        checkResultIsPreQualified(processResult, 2, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_ELEMENT_WITH_NOT_EMPTY_ALT_MSG,
                AREA_ELEMENT,
                1);

        //----------------------------------------------------------------------
        //------------------------------3NMI-06---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.02.02-3NMI-06");
        checkResultIsPreQualified(processResult, 2, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_ELEMENT_WITH_EMPTY_ALT_MSG,
                AREA_ELEMENT,
                1);

        //----------------------------------------------------------------------
        //------------------------------3NMI-07---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.02.02-3NMI-07");
        checkResultIsPreQualified(processResult, 2, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_ELEMENT_WITH_NOT_EMPTY_ALT_MSG,
                AREA_ELEMENT,
                1);

        //----------------------------------------------------------------------
        //------------------------------3NMI-08---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.02.02-3NMI-08");
        checkResultIsPreQualified(processResult, 2, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_NATURE_OF_IMAGE_WITH_NOT_EMPTY_ALT_MSG,
                AREA_ELEMENT,
                1);

        //----------------------------------------------------------------------
        //------------------------------3NMI-09---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.02.02-3NMI-09");
        checkResultIsPreQualified(processResult, 2, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_NATURE_OF_IMAGE_WITH_NOT_EMPTY_ALT_MSG,
                AREA_ELEMENT,
                1);

        //----------------------------------------------------------------------
        //------------------------------3NMI-10---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.02.02-3NMI-10");
        checkResultIsPreQualified(processResult, 2, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_NATURE_OF_IMAGE_WITH_NOT_EMPTY_ALT_MSG,
                AREA_ELEMENT,
                1);

        //----------------------------------------------------------------------
        //------------------------------3NMI-11---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.02.02-3NMI-11");
        checkResultIsPreQualified(processResult, 2, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_NATURE_OF_IMAGE_WITH_NOT_EMPTY_ALT_MSG,
                AREA_ELEMENT,
                1);

        //----------------------------------------------------------------------
        //------------------------------4NA-01----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.01.02.02-4NA-01"));

        //----------------------------------------------------------------------
        //------------------------------4NA-02----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.01.02.02-4NA-02"));

        //----------------------------------------------------------------------
        //------------------------------4NA-03----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.01.02.02-4NA-03"));

        //----------------------------------------------------------------------
        //------------------------------4NA-04----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.01.02.02-4NA-04"));

        //----------------------------------------------------------------------
        //------------------------------4NA-05----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.01.02.02-4NA-05"));

        //----------------------------------------------------------------------
        //------------------------------4NA-06----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.01.02.02-4NA-06"));

        //----------------------------------------------------------------------
        //------------------------------4NA-07----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.01.02.02-4NA-07"));

        //----------------------------------------------------------------------
        //------------------------------4NA-08----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.01.02.02-4NA-08"));

        //----------------------------------------------------------------------
        //------------------------------4NA-09----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.01.02.02-4NA-09"));

        //----------------------------------------------------------------------
        //------------------------------4NA-10----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.01.02.02-4NA-10"));
    }

}
