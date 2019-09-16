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

import static org.tanaguru.rules.keystore.AttributeStore.SUMMARY_ATTR;
import static org.tanaguru.rules.keystore.HtmlElementStore.TABLE_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.CAPTION_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.DIV_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.MarkerStore.COMPLEX_TABLE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.DATA_TABLE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.PRESENTATION_TABLE_MARKER;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_CAPTION_PERTINENCE_FOR_COMPLEX_TABLE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_NATURE_OF_TABLE_AND_SUMMARY_PERTINENCE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_SUMMARY_PERTINENCE_FOR_DATA_TABLE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_SUMMARY_TEXT_PERTINENCE_FOR_COMPLEX_TABLE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_TABLE_IS_COMPLEX_AND_CAPTION_PERTINENCE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_TABLE_IS_COMPLEX_AND_SUMMARY_TEXT_PERTINENCE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_TABLE_IS_COMPLEX_FOR_NOT_PERTINENT_CAPTION_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_TABLE_IS_COMPLEX_FOR_NOT_PERTINENT_SUMMARY_TEXT_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.NOT_PERTINENT_CAPTION_FOR_COMPLEX_TABLE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.NOT_PERTINENT_SUMMARY_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.NOT_PERTINENT_SUMMARY_TEXT_FOR_COMPLEX_TABLE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_NATURE_OF_TABLE_FOR_NOT_PERTINENT_SUMMARY_MSG;

/**
 * Unit test class for the implementation of the rule 5-2-1 of the referential Rgaa 4-2019.
 *
 * @author edaconceicao
 */
public class Rgaa42019Rule050201Test extends Rgaa42019RuleImplementationTestCase {

    /**
     * Default constructor
     */
    public Rgaa42019Rule050201Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.tanaguru.rules.rgaa42019.Rgaa42019Rule050201");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("Rgaa42019.Test.05.02.01-2Failed-01",
                createParameter("Rules", COMPLEX_TABLE_MARKER, "class-complex-table"));
        addWebResource("Rgaa42019.Test.05.02.01-2Failed-02",
                createParameter("Rules", COMPLEX_TABLE_MARKER, "class-complex-table"));
        addWebResource("Rgaa42019.Test.05.02.01-2Failed-03",
                createParameter("Rules", COMPLEX_TABLE_MARKER, "class-complex-table"));
        addWebResource("Rgaa42019.Test.05.02.01-2Failed-04",
                createParameter("Rules", COMPLEX_TABLE_MARKER, "class-complex-table"));
        addWebResource("Rgaa42019.Test.05.02.01-2Failed-05",
                createParameter("Rules", COMPLEX_TABLE_MARKER, "class-complex-table"));
        addWebResource("Rgaa42019.Test.05.02.01-2Failed-06",
                createParameter("Rules", COMPLEX_TABLE_MARKER, "class-complex-table"));
        addWebResource("Rgaa42019.Test.05.02.01-3NMI-01",
                createParameter("Rules", COMPLEX_TABLE_MARKER, "class-complex-table"));
        addWebResource("Rgaa42019.Test.05.02.01-3NMI-02",
                createParameter("Rules", COMPLEX_TABLE_MARKER, "class-complex-table"));
        addWebResource("Rgaa42019.Test.05.02.01-3NMI-03",
                createParameter("Rules", COMPLEX_TABLE_MARKER, "class-complex-table"));
        addWebResource("Rgaa42019.Test.05.02.01-3NMI-04");
        addWebResource("Rgaa42019.Test.05.02.01-3NMI-05");
        addWebResource("Rgaa42019.Test.05.02.01-3NMI-06");
        addWebResource("Rgaa42019.Test.05.02.01-3NMI-07");
        addWebResource("Rgaa42019.Test.05.02.01-3NMI-08");
        addWebResource("Rgaa42019.Test.05.02.01-3NMI-09");
        addWebResource("Rgaa42019.Test.05.02.01-4NA-01");
        addWebResource("Rgaa42019.Test.05.02.01-4NA-02",
                createParameter("Rules", PRESENTATION_TABLE_MARKER, "class-presentation-table"));
        addWebResource("Rgaa42019.Test.05.02.01-4NA-03",
                createParameter("Rules", PRESENTATION_TABLE_MARKER, "class-presentation-table"));
        addWebResource("Rgaa42019.Test.05.02.01-4NA-04",
                createParameter("Rules", PRESENTATION_TABLE_MARKER, "class-presentation-table"));
        addWebResource("Rgaa42019.Test.05.02.01-4NA-05",
        		createParameter("Rules", DATA_TABLE_MARKER, "class-data-table"));
        addWebResource("Rgaa42019.Test.05.02.01-4NA-06",
        		createParameter("Rules", DATA_TABLE_MARKER, "class-data-table"));
        addWebResource("Rgaa42019.Test.05.02.01-4NA-07",
        		createParameter("Rules", DATA_TABLE_MARKER, "class-data-table"));
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------2Failed-01------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("Rgaa42019.Test.05.02.01-2Failed-01");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                NOT_PERTINENT_CAPTION_FOR_COMPLEX_TABLE_MSG,
                CAPTION_ELEMENT,
                1,
                new ImmutablePair(TEXT_ELEMENT2, ""));

        //----------------------------------------------------------------------
        //------------------------------2Failed-02------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.02.01-2Failed-02");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                NOT_PERTINENT_SUMMARY_MSG,
                TABLE_ELEMENT,
                1,
                new ImmutablePair(SUMMARY_ATTR, ""));

        //----------------------------------------------------------------------
        //------------------------------2Failed-03------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.02.01-2Failed-03");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                NOT_PERTINENT_SUMMARY_TEXT_FOR_COMPLEX_TABLE_MSG,
                DIV_ELEMENT,
                1,
                new ImmutablePair(TEXT_ELEMENT2, ""));

        //----------------------------------------------------------------------
        //------------------------------2Failed-04------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.02.01-2Failed-04");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                NOT_PERTINENT_CAPTION_FOR_COMPLEX_TABLE_MSG,
                CAPTION_ELEMENT,
                1,
                new ImmutablePair(TEXT_ELEMENT2, "1_##"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-05------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.02.01-2Failed-05");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                NOT_PERTINENT_SUMMARY_MSG,
                TABLE_ELEMENT,
                1,
                new ImmutablePair(SUMMARY_ATTR, "1_##"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-06------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.02.01-2Failed-06");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                NOT_PERTINENT_SUMMARY_TEXT_FOR_COMPLEX_TABLE_MSG,
                DIV_ELEMENT,
                1,
                new ImmutablePair(TEXT_ELEMENT2, "1_##"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-01---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.02.01-3NMI-01");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_CAPTION_PERTINENCE_FOR_COMPLEX_TABLE_MSG,
                CAPTION_ELEMENT,
                1,
                new ImmutablePair(TEXT_ELEMENT2, "complex table summary"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-02---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.02.01-3NMI-02");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_SUMMARY_PERTINENCE_FOR_DATA_TABLE_MSG,
                TABLE_ELEMENT,
                1,
                new ImmutablePair(SUMMARY_ATTR, "Mock complex data table"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-03---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.02.01-3NMI-03");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_SUMMARY_TEXT_PERTINENCE_FOR_COMPLEX_TABLE_MSG,
                DIV_ELEMENT,
                1,
                new ImmutablePair(TEXT_ELEMENT2, "Mock complex data table"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-04---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.02.01-3NMI-04");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_TABLE_IS_COMPLEX_AND_CAPTION_PERTINENCE_MSG,
                CAPTION_ELEMENT,
                1,
                new ImmutablePair(TEXT_ELEMENT2, "complex table summary"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-05---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.02.01-3NMI-05");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_TABLE_AND_SUMMARY_PERTINENCE_MSG,
                TABLE_ELEMENT,
                1,
                new ImmutablePair(SUMMARY_ATTR, "Mock complex data table"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-06---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.02.01-3NMI-06");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_TABLE_IS_COMPLEX_AND_SUMMARY_TEXT_PERTINENCE_MSG,
                DIV_ELEMENT,
                1,
                new ImmutablePair(TEXT_ELEMENT2, "Mock complex data table"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-07---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.02.01-3NMI-07");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_TABLE_IS_COMPLEX_FOR_NOT_PERTINENT_CAPTION_MSG,
                CAPTION_ELEMENT,
                1,
                new ImmutablePair(TEXT_ELEMENT2, ""));

        //----------------------------------------------------------------------
        //------------------------------3NMI-08---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.02.01-3NMI-08");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_TABLE_FOR_NOT_PERTINENT_SUMMARY_MSG,
                TABLE_ELEMENT,
                1,
                new ImmutablePair(SUMMARY_ATTR, ""));

        //----------------------------------------------------------------------
        //------------------------------3NMI-09---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.02.01-3NMI-09");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_TABLE_IS_COMPLEX_FOR_NOT_PERTINENT_SUMMARY_TEXT_MSG,
                DIV_ELEMENT,
                1,
                new ImmutablePair(TEXT_ELEMENT2, ""));


        //----------------------------------------------------------------------
        //------------------------------4NA-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.05.02.01-4NA-01"));

        //----------------------------------------------------------------------
        //------------------------------4NA-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.05.02.01-4NA-02"));

        //----------------------------------------------------------------------
        //------------------------------4NA-03------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.05.02.01-4NA-03"));

        //----------------------------------------------------------------------
        //------------------------------4NA-04------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.05.02.01-4NA-04"));

        //----------------------------------------------------------------------
        //------------------------------4NA-05------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.05.02.01-4NA-05"));

        //----------------------------------------------------------------------
        //------------------------------4NA-06------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.05.02.01-4NA-06"));

        //----------------------------------------------------------------------
        //------------------------------4NA-07------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.05.02.01-4NA-07"));
    }
}