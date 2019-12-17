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
package org.tanaguru.ruleimplementation.impl.image;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.ruleimplementation.CommonRuleImplementationTestCase;

import static org.tanaguru.rules.keystore.AttributeStore.*;
import static org.tanaguru.rules.keystore.HtmlElementStore.AREA_ELEMENT;
import static org.tanaguru.rules.keystore.MarkerStore.DECORATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.INFORMATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.RemarkMessageStore.*;

/**
 * Unit test class for the implementation of the rule 1-1-2 of the referential Rgaa 4-2019.
 *
 * @author edaconceicao
 */
public class AreaOfInformativeImageHasAltTextTest extends CommonRuleImplementationTestCase {

    /**
     * Default constructor
     */
    public AreaOfInformativeImageHasAltTextTest(String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.tanaguru.ruleimplementation.impl.image.AreaOfInformativeImageHasAltText");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("AreaOfInformativeImageHasAltText-1Passed-01",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "id-informative-image"));
        addWebResource("AreaOfInformativeImageHasAltText-1Passed-02",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "id-informative-image"));
        addWebResource("AreaOfInformativeImageHasAltText-2Failed-01",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "id-informative-image"));
        addWebResource("AreaOfInformativeImageHasAltText-2Failed-02",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "id-informative-image"));
        addWebResource("AreaOfInformativeImageHasAltText-2Failed-03",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "id-informative-image"));
        addWebResource("AreaOfInformativeImageHasAltText-2Failed-04");
        addWebResource("AreaOfInformativeImageHasAltText-2Failed-05");
        addWebResource("AreaOfInformativeImageHasAltText-3NMI-01");
        addWebResource("AreaOfInformativeImageHasAltText-3NMI-02");
        addWebResource("AreaOfInformativeImageHasAltText-3NMI-03");
        addWebResource("AreaOfInformativeImageHasAltText-4NA-01");
        addWebResource("AreaOfInformativeImageHasAltText-4NA-02",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
        addWebResource("AreaOfInformativeImageHasAltText-4NA-03",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------1Passed-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("AreaOfInformativeImageHasAltText-1Passed-01"), 2);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("AreaOfInformativeImageHasAltText-1Passed-02"), 2);

        //----------------------------------------------------------------------
        //------------------------------2Failed-01------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("AreaOfInformativeImageHasAltText-2Failed-01");
        checkResultIsFailed(processResult, 2, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                TEXT_ALTERNATIVE_MISSING,
                AREA_ELEMENT,
                1,
                new ImmutablePair(HREF_ATTR, "mock-link.fr"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                TEXT_ALTERNATIVE_MISSING,
                AREA_ELEMENT,
                2,
                new ImmutablePair(HREF_ATTR, "mock-link.fr"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-02------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("AreaOfInformativeImageHasAltText-2Failed-02");
        checkResultIsFailed(processResult, 2, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                INVALID_TEXT_ALTERNATIVE_MSG,
                AREA_ELEMENT,
                1,
                new ImmutablePair(HREF_ATTR, "mock-link.fr"),
        		new ImmutablePair(ARIA_LABELLEDBY_ATTR, "FAILED-02"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                INVALID_TEXT_ALTERNATIVE_MSG,
                AREA_ELEMENT,
                2,
                new ImmutablePair(HREF_ATTR, "mock-link.fr"),
        		new ImmutablePair(ARIA_LABELLEDBY_ATTR, "FAILED-02"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-03------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("AreaOfInformativeImageHasAltText-2Failed-03");
        checkResultIsFailed(processResult, 2, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                INVALID_TEXT_ALTERNATIVE_MSG,
                AREA_ELEMENT,
                1,
                new ImmutablePair(HREF_ATTR, "mock-link.fr"),
                new ImmutablePair(TITLE_ATTR, ""));
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                INVALID_TEXT_ALTERNATIVE_MSG,
                AREA_ELEMENT,
                2,
                new ImmutablePair(HREF_ATTR, "mock-link.fr"),
                new ImmutablePair(TITLE_ATTR, ""));

        //----------------------------------------------------------------------
        //------------------------------2Failed-04------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("AreaOfInformativeImageHasAltText-2Failed-04");
        checkResultIsFailed(processResult, 2, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                INVALID_TEXT_ALTERNATIVE_MSG,
                AREA_ELEMENT,
                1,
                new ImmutablePair(HREF_ATTR, "mock-link.fr"),
        		new ImmutablePair(ARIA_LABELLEDBY_ATTR, "FAILED-04"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                INVALID_TEXT_ALTERNATIVE_MSG,
                AREA_ELEMENT,
                2,
                new ImmutablePair(HREF_ATTR, "mock-link.fr"),
        		new ImmutablePair(ARIA_LABELLEDBY_ATTR, "FAILED-04"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-05------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("AreaOfInformativeImageHasAltText-2Failed-05");
        checkResultIsFailed(processResult, 2, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                INVALID_TEXT_ALTERNATIVE_MSG,
                AREA_ELEMENT,
                1,
                new ImmutablePair(HREF_ATTR, "mock-link.fr"),
                new ImmutablePair(TITLE_ATTR, ""));
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                INVALID_TEXT_ALTERNATIVE_MSG,
                AREA_ELEMENT,
                2,
                new ImmutablePair(HREF_ATTR, "mock-link.fr"),
                new ImmutablePair(TITLE_ATTR, ""));

        //----------------------------------------------------------------------
        //------------------------------3NMI-01---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("AreaOfInformativeImageHasAltText-3NMI-01");
        checkResultIsPreQualified(processResult, 2, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE,
                AREA_ELEMENT,
                1,
                new ImmutablePair(HREF_ATTR, "mock-link.fr"),
                new ImmutablePair(ALT_ATTR, ""));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE,
                AREA_ELEMENT,
                2,
                new ImmutablePair(HREF_ATTR, "mock-link.fr"),
                new ImmutablePair(ALT_ATTR, ""));

        //----------------------------------------------------------------------
        //------------------------------3NMI-02---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("AreaOfInformativeImageHasAltText-3NMI-02");
        checkResultIsPreQualified(processResult, 2, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE,
                AREA_ELEMENT,
                1,
                new ImmutablePair(HREF_ATTR, "mock-link.fr"),
                new ImmutablePair(ARIA_LABEL_ATTR, ""));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE,
                AREA_ELEMENT,
                2,
                new ImmutablePair(HREF_ATTR, "mock-link.fr"),
                new ImmutablePair(ARIA_LABEL_ATTR, ""));

        //----------------------------------------------------------------------
        //------------------------------3NMI-03---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("AreaOfInformativeImageHasAltText-3NMI-03");
        checkResultIsPreQualified(processResult, 2, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE_WITHOUT_TEXT_ALTERNATIVE,
                AREA_ELEMENT,
                1,
                new ImmutablePair(HREF_ATTR, "mock-link.fr"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE_WITHOUT_TEXT_ALTERNATIVE,
                AREA_ELEMENT,
                2,
                new ImmutablePair(HREF_ATTR, "mock-link.fr"));


        //----------------------------------------------------------------------
        //------------------------------4NA-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("AreaOfInformativeImageHasAltText-4NA-01"));

        //----------------------------------------------------------------------
        //------------------------------4NA-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("AreaOfInformativeImageHasAltText-4NA-02"));

        //----------------------------------------------------------------------
        //------------------------------4NA-03------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("AreaOfInformativeImageHasAltText-4NA-03"));
    }
}
