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

import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;
import static org.tanaguru.rules.keystore.HtmlElementStore.FRAME_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.IFRAME_ELEMENT;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_TITLE_OF_FRAME_PERTINENCE_MSG2;
import static org.tanaguru.rules.keystore.RemarkMessageStore.NOT_PERTINENT_TITLE_OF_FRAME_MSG2;

/**
 * Unit test class for the implementation of the rule 2-2-1 of the referential Rgaa 4-2019.
 *
 * @author edaconceicao
 */
public class Rgaa42019Rule020201Test extends Rgaa42019RuleImplementationTestCase {

    /**
     * Default constructor
     */
    public Rgaa42019Rule020201Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.tanaguru.rules.rgaa42019.Rgaa42019Rule020201");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("Rgaa42019.Test.02.02.01-2Failed-01");
//        addWebResource("Rgaa42019.Test.02.02.01-2Failed-02");
        addWebResource("Rgaa42019.Test.02.02.01-2Failed-03");
//        addWebResource("Rgaa42019.Test.02.02.01-2Failed-04");
        addWebResource("Rgaa42019.Test.02.02.01-3NMI-01");
//        addWebResource("Rgaa42019.Test.02.02.01-3NMI-02");
        addWebResource("Rgaa42019.Test.02.02.01-4NA-01");
        addWebResource("Rgaa42019.Test.02.02.01-4NA-02");
        addWebResource("Rgaa42019.Test.02.02.01-4NA-03");
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------2Failed-01------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("Rgaa42019.Test.02.02.01-2Failed-01");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                NOT_PERTINENT_TITLE_OF_FRAME_MSG2,
                IFRAME_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR, ""));

        //frame elements deprecated so not detected
//        //----------------------------------------------------------------------
//        //------------------------------2Failed-02------------------------------
//        //----------------------------------------------------------------------
//        processResult = processPageTest("Rgaa42019.Test.02.02.01-2Failed-02");
//        checkResultIsFailed(processResult, 2, 2);
//        checkRemarkIsPresent(
//                processResult,
//                TestSolution.FAILED,
//                NOT_PERTINENT_TITLE_OF_FRAME_MSG2,
//                FRAME_ELEMENT,
//                1,
//                new ImmutablePair(TITLE_ATTR, ""));
//        checkRemarkIsPresent(
//                processResult,
//                TestSolution.FAILED,
//                NOT_PERTINENT_TITLE_OF_FRAME_MSG2,
//                FRAME_ELEMENT,
//                2,
//                new ImmutablePair(TITLE_ATTR, ""));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-03------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.02.02.01-2Failed-03");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                NOT_PERTINENT_TITLE_OF_FRAME_MSG2,
                IFRAME_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR, "mock-iframe.html"));


        //frame elements deprecated so not detected
//        //----------------------------------------------------------------------
//        //------------------------------2Failed-04------------------------------
//        //----------------------------------------------------------------------
//        processResult = processPageTest("Rgaa42019.Test.02.02.01-2Failed-04");
//        checkResultIsFailed(processResult, 2, 2);
//        checkRemarkIsPresent(
//                processResult,
//                TestSolution.FAILED,
//                NOT_PERTINENT_TITLE_OF_FRAME_MSG2,
//                FRAME_ELEMENT,
//                1,
//                new ImmutablePair(TITLE_ATTR, "mock-iframe.html"));
//        checkRemarkIsPresent(
//                processResult,
//                TestSolution.FAILED,
//                NOT_PERTINENT_TITLE_OF_FRAME_MSG2,
//                FRAME_ELEMENT,
//                2,
//                new ImmutablePair(TITLE_ATTR, "mock-iframe.html"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-01---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.02.02.01-3NMI-01");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_TITLE_OF_FRAME_PERTINENCE_MSG2,
                IFRAME_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR, "mock iframe title relevant"));

        //frame elements deprecated so not detected
//        //----------------------------------------------------------------------
//        //------------------------------3NMI-02---------------------------------
//        //----------------------------------------------------------------------
//        processResult = processPageTest("Rgaa42019.Test.02.02.01-3NMI-02");
//        checkResultIsPreQualified(processResult, 2, 2);
//        checkRemarkIsPresent(
//                processResult,
//                TestSolution.NEED_MORE_INFO,
//                CHECK_TITLE_OF_FRAME_PERTINENCE_MSG2,
//                FRAME_ELEMENT,
//                1,
//                new ImmutablePair(TITLE_ATTR, "mock frame title relevant"));
//        checkRemarkIsPresent(
//                processResult,
//                TestSolution.NEED_MORE_INFO,
//                CHECK_TITLE_OF_FRAME_PERTINENCE_MSG2,
//                FRAME_ELEMENT,
//                2,
//                new ImmutablePair(TITLE_ATTR, "mock frame title relevant"));


        //----------------------------------------------------------------------
        //------------------------------4NA-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.02.02.01-4NA-01"));

        //----------------------------------------------------------------------
        //------------------------------4NA-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.02.02.01-4NA-02"));

        //----------------------------------------------------------------------
        //------------------------------4NA-03------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.02.02.01-4NA-03"));
    }
}
