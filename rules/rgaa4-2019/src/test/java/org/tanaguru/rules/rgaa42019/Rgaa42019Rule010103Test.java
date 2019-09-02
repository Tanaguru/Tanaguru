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
import org.tanaguru.rules.rgaa42019.test.Rgaa42019RuleImplementationTestCase;

import static org.tanaguru.rules.keystore.HtmlElementStore.INPUT_ELEMENT;
import static org.tanaguru.rules.keystore.RemarkMessageStore.TEXT_ALTERNATIVE_MISSING;
import static org.tanaguru.rules.keystore.AttributeStore.VALUE_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ALT_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABELLEDBY_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABEL_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;

import org.apache.commons.lang3.tuple.ImmutablePair;

import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_NATURE_OF_IMAGE_WITHOUT_TEXT_ALTERNATIVE;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_NATURE_OF_IMAGE;
import static org.tanaguru.rules.keystore.RemarkMessageStore.INVALID_TEXT_ALTERNATIVE_MSG;
import static org.tanaguru.rules.keystore.MarkerStore.DECORATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.INFORMATIVE_IMAGE_MARKER;

/**
 * Unit test class for the implementation of the rule 1-1-3 of the referential Rgaa 4-2019.
 *
 * @author edaconceicao
 */
public class Rgaa42019Rule010103Test extends Rgaa42019RuleImplementationTestCase {

    /**
     * Default constructor
     */
    public Rgaa42019Rule010103Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.tanaguru.rules.rgaa42019.Rgaa42019Rule010103");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("Rgaa42019.Test.01.01.03-1Passed-01",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "id-informative-image"));
        addWebResource("Rgaa42019.Test.01.01.03-1Passed-02",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "id-informative-image"));
        addWebResource("Rgaa42019.Test.01.01.03-1Passed-03",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "id-informative-image"));
        addWebResource("Rgaa42019.Test.01.01.03-1Passed-04",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "id-informative-image"));
        addWebResource("Rgaa42019.Test.01.01.03-2Failed-01",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "id-informative-image"));
        addWebResource("Rgaa42019.Test.01.01.03-2Failed-02",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "id-informative-image"));
        addWebResource("Rgaa42019.Test.01.01.03-2Failed-03");
        addWebResource("Rgaa42019.Test.01.01.03-3NMI-01");
        addWebResource("Rgaa42019.Test.01.01.03-3NMI-02");
        addWebResource("Rgaa42019.Test.01.01.03-3NMI-03");
        addWebResource("Rgaa42019.Test.01.01.03-3NMI-04");
        addWebResource("Rgaa42019.Test.01.01.03-3NMI-05");
        addWebResource("Rgaa42019.Test.01.01.03-4NA-01",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
        addWebResource("Rgaa42019.Test.01.01.03-4NA-02",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
        addWebResource("Rgaa42019.Test.01.01.03-4NA-03",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
        addWebResource("Rgaa42019.Test.01.01.03-4NA-04",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
        addWebResource("Rgaa42019.Test.01.01.03-4NA-05");
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------1Passed-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.01.01.03-1Passed-01"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.01.01.03-1Passed-02"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-03------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.01.01.03-1Passed-03"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-04------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.01.01.03-1Passed-04"), 1);

        //----------------------------------------------------------------------
        //------------------------------2Failed-01------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("Rgaa42019.Test.01.01.03-2Failed-01");
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
        processResult = processPageTest("Rgaa42019.Test.01.01.03-2Failed-02");
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
        processResult = processPageTest("Rgaa42019.Test.01.01.03-2Failed-03");
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
        processResult = processPageTest("Rgaa42019.Test.01.01.03-3NMI-01");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE,
                INPUT_ELEMENT,
                1,
                new ImmutablePair(VALUE_ATTR, "Send"),
                new ImmutablePair(ALT_ATTR, ""));

        //----------------------------------------------------------------------
        //------------------------------3NMI-02---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.01.03-3NMI-02");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE,
                INPUT_ELEMENT,
                1,
                new ImmutablePair(VALUE_ATTR, "Send"),
                new ImmutablePair(ARIA_LABEL_ATTR, ""));

        //----------------------------------------------------------------------
        //------------------------------3NMI-03---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.01.03-3NMI-03");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE,
                INPUT_ELEMENT,
                1,
                new ImmutablePair(VALUE_ATTR, "Send"),
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, "NMI-03"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-04---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.01.03-3NMI-04");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE,
                INPUT_ELEMENT,
                1,
                new ImmutablePair(VALUE_ATTR, "Send"),
                new ImmutablePair(TITLE_ATTR, ""));

        //----------------------------------------------------------------------
        //------------------------------3NMI-05---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.01.03-3NMI-05");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE_WITHOUT_TEXT_ALTERNATIVE,
                INPUT_ELEMENT,
                1,
                new ImmutablePair(VALUE_ATTR, "Send"));


        //----------------------------------------------------------------------
        //------------------------------4NA-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.01.01.03-4NA-01"));

        //----------------------------------------------------------------------
        //------------------------------4NA-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.01.01.03-4NA-02"));

        //----------------------------------------------------------------------
        //------------------------------4NA-03------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.01.01.03-4NA-03"));

        //----------------------------------------------------------------------
        //------------------------------4NA-04------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.01.01.03-4NA-04"));

        //----------------------------------------------------------------------
        //------------------------------4NA-05------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.01.01.03-4NA-05"));
    }
}
