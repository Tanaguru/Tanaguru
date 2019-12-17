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
import static org.tanaguru.rules.keystore.HtmlElementStore.INPUT_ELEMENT;
import static org.tanaguru.rules.keystore.RemarkMessageStore.*;

/**
 * Unit test class for the implementation of the rule 1-1-3 of the referential Rgaa 4-2019.
 *
 * @author edaconceicao
 */
public class ImageInputHasAltTextTest extends CommonRuleImplementationTestCase {

    /**
     * Default constructor
     */
    public ImageInputHasAltTextTest(String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.tanaguru.ruleimplementation.impl.image.ImageInputHasAltText");
    }

    @Override
    protected void setUpWebResourceMap() {

        addWebResource("ImageInputHasAltText-2Failed-01");
        addWebResource("ImageInputHasAltText-2Failed-02");
        addWebResource("ImageInputHasAltText-2Failed-03");
        addWebResource("ImageInputHasAltText-3NMI-01");
        addWebResource("ImageInputHasAltText-3NMI-02");
        addWebResource("ImageInputHasAltText-3NMI-03");
        addWebResource("ImageInputHasAltText-3NMI-04");
        addWebResource("ImageInputHasAltText-4NA-01");
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------2Failed-01------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("ImageInputHasAltText-2Failed-01");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                TEXT_ALTERNATIVE_MISSING,
                INPUT_ELEMENT,
                1,
                new ImmutablePair(VALUE_ATTR, "Send"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-02------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("ImageInputHasAltText-2Failed-02");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                INVALID_TEXT_ALTERNATIVE_MSG,
                INPUT_ELEMENT,
                1,
                new ImmutablePair(VALUE_ATTR, "Send"),
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, "FAILED-02"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-03------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("ImageInputHasAltText-2Failed-03");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                INVALID_TEXT_ALTERNATIVE_MSG,
                INPUT_ELEMENT,
                1,
                new ImmutablePair(VALUE_ATTR, "Send"),
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, "FAILED-03"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-01---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("ImageInputHasAltText-3NMI-01");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE_WITH_TEXT_ALTERNATIVE,
                INPUT_ELEMENT,
                1,
                new ImmutablePair(VALUE_ATTR, "Send"),
                new ImmutablePair(ALT_ATTR, "NMI-01"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-02---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("ImageInputHasAltText-3NMI-02");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE_WITH_TEXT_ALTERNATIVE,
                INPUT_ELEMENT,
                1,
                new ImmutablePair(VALUE_ATTR, "Send"),
                new ImmutablePair(ARIA_LABEL_ATTR, "NMI-02"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-03---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("ImageInputHasAltText-3NMI-03");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE_WITH_TEXT_ALTERNATIVE,
                INPUT_ELEMENT,
                1,
                new ImmutablePair(VALUE_ATTR, "Send"),
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, "NMI-03"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-04---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("ImageInputHasAltText-3NMI-04");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE_WITH_TEXT_ALTERNATIVE,
                INPUT_ELEMENT,
                1,
                new ImmutablePair(VALUE_ATTR, "Send"),
                new ImmutablePair(TITLE_ATTR, "NMI-04"));


        //----------------------------------------------------------------------
        //------------------------------4NA-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("ImageInputHasAltText-4NA-01"));
    }
}
