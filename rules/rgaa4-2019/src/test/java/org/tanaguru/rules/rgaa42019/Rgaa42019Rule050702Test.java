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

import static org.tanaguru.rules.keystore.AttributeStore.SCOPE_ATTR;
import static org.tanaguru.rules.keystore.HtmlElementStore.TH_ELEMENT;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_USAGE_OF_SCOPE_ROW_OR_COL_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.WRONG_SCOPE_VALUE_MSG;

/**
 * Unit test class for the implementation of the rule 5-7-2 of the referential Rgaa 4-2019.
 *
 * @author edaconceicao
 */
public class Rgaa42019Rule050702Test extends Rgaa42019RuleImplementationTestCase {

    /**
     * Default constructor
     */
    public Rgaa42019Rule050702Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.tanaguru.rules.rgaa42019.Rgaa42019Rule050702");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("Rgaa42019.Test.05.07.02-2Failed-01");
        addWebResource("Rgaa42019.Test.05.07.02-3NMI-01");
        addWebResource("Rgaa42019.Test.05.07.02-3NMI-02");
        addWebResource("Rgaa42019.Test.05.07.02-3NMI-03");
        addWebResource("Rgaa42019.Test.05.07.02-4NA-01");
        addWebResource("Rgaa42019.Test.05.07.02-4NA-02");
        addWebResource("Rgaa42019.Test.05.07.02-4NA-03");
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------2Failed-01------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("Rgaa42019.Test.05.07.02-2Failed-01");
        checkResultIsFailed(processResult, 4, 4);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                WRONG_SCOPE_VALUE_MSG,
                TH_ELEMENT,
                1,
                new ImmutablePair(SCOPE_ATTR, ""));
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                WRONG_SCOPE_VALUE_MSG,
                TH_ELEMENT,
                2,
                new ImmutablePair(SCOPE_ATTR, ""));
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                WRONG_SCOPE_VALUE_MSG,
                TH_ELEMENT,
                3,
                new ImmutablePair(SCOPE_ATTR, "wrong scope value1"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                WRONG_SCOPE_VALUE_MSG,
                TH_ELEMENT,
                4,
                new ImmutablePair(SCOPE_ATTR, "wrong scope value2"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-01---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.07.02-3NMI-01");
        checkResultIsPreQualified(processResult, 2, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_USAGE_OF_SCOPE_ROW_OR_COL_MSG,
                TH_ELEMENT,
                1,
                new ImmutablePair(SCOPE_ATTR, "col"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_USAGE_OF_SCOPE_ROW_OR_COL_MSG,
                TH_ELEMENT,
                2,
                new ImmutablePair(SCOPE_ATTR, "col"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-02---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.07.02-3NMI-02");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_USAGE_OF_SCOPE_ROW_OR_COL_MSG,
                TH_ELEMENT,
                1,
                new ImmutablePair(SCOPE_ATTR, "row"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-03---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.07.02-3NMI-03");
        checkResultIsPreQualified(processResult, 4, 4);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_USAGE_OF_SCOPE_ROW_OR_COL_MSG,
                TH_ELEMENT,
                1,
                new ImmutablePair(SCOPE_ATTR, "col"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_USAGE_OF_SCOPE_ROW_OR_COL_MSG,
                TH_ELEMENT,
                2,
                new ImmutablePair(SCOPE_ATTR, "col"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_USAGE_OF_SCOPE_ROW_OR_COL_MSG,
                TH_ELEMENT,
                3,
                new ImmutablePair(SCOPE_ATTR, "row"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_USAGE_OF_SCOPE_ROW_OR_COL_MSG,
                TH_ELEMENT,
                4,
                new ImmutablePair(SCOPE_ATTR, "row"));


        //----------------------------------------------------------------------
        //------------------------------4NA-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.05.07.02-4NA-01"));

        //----------------------------------------------------------------------
        //------------------------------4NA-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.05.07.02-4NA-02"),4);

        //----------------------------------------------------------------------
        //------------------------------4NA-03------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.05.07.02-4NA-03"));
    }
}
