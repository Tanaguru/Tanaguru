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
import org.tanaguru.rules.keystore.RemarkMessageStore;
import org.tanaguru.rules.rgaa42019.test.Rgaa42019RuleImplementationTestCase;

import static org.tanaguru.rules.keystore.HtmlElementStore.TH_ELEMENT;

/**
 * Unit test class for the implementation of the rule 5-7-1 of the referential Rgaa 4-2019.
 *
 * @author edaconceicao
 */
public class Rgaa42019Rule050701Test extends Rgaa42019RuleImplementationTestCase {

    /**
     * Default constructor
     */
    public Rgaa42019Rule050701Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.tanaguru.rules.rgaa42019.Rgaa42019Rule050701");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("Rgaa42019.Test.05.07.01-3NMI-01");
        addWebResource("Rgaa42019.Test.05.07.01-3NMI-02");
        addWebResource("Rgaa42019.Test.05.07.01-3NMI-03");
        addWebResource("Rgaa42019.Test.05.07.01-3NMI-04");
        addWebResource("Rgaa42019.Test.05.07.01-3NMI-05");
        addWebResource("Rgaa42019.Test.05.07.01-3NMI-06");
        addWebResource("Rgaa42019.Test.05.07.01-3NMI-07");
        addWebResource("Rgaa42019.Test.05.07.01-4NA-01");
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------3NMI-01---------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("Rgaa42019.Test.05.07.01-3NMI-01");
        checkResultIsPreQualified(processResult, 4, 4);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_WELL_FORMED_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_WELL_FORMED_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_WELL_FORMED_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                3);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_WELL_FORMED_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                4);
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-02---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.07.01-3NMI-02");
        checkResultIsPreQualified(processResult, 4, 4);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_WELL_FORMED_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_WELL_FORMED_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_WELL_FORMED_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                3);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_WELL_FORMED_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                4);
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-03---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.07.01-3NMI-03");
        checkResultIsPreQualified(processResult, 4, 4);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_WELL_FORMED_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_WELL_FORMED_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_WELL_FORMED_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                3);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_WELL_FORMED_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                4);
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-04---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.07.01-3NMI-04");
        checkResultIsPreQualified(processResult, 4, 4);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_WELL_FORMED_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_WELL_FORMED_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_WELL_FORMED_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                3);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_WELL_FORMED_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                4);
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-05---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.07.01-3NMI-05");
        checkResultIsPreQualified(processResult, 4, 4);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_NOT_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_NOT_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_NOT_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                3);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_NOT_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                4);
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-06---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.07.01-3NMI-06");
        checkResultIsPreQualified(processResult, 4, 4);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_WELL_FORMED_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_WELL_FORMED_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_NOT_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                3);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_NOT_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                4);
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-07---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.07.01-3NMI-07");
        checkResultIsPreQualified(processResult, 4, 4);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_NOT_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_NOT_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_NOT_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                3);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.SUSPECTED_HEADERS_NOT_COVER_WHOLE_ELEMENT_MSG,
                TH_ELEMENT,
                4);


        //----------------------------------------------------------------------
        //------------------------------4NA-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.05.07.01-4NA-01"));
    }

}
