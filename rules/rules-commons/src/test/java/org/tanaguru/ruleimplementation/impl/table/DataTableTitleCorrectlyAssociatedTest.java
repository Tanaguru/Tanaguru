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
package org.tanaguru.ruleimplementation.impl.table;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.ruleimplementation.CommonRuleImplementationTestCase;

import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABEL_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;
import static org.tanaguru.rules.keystore.HtmlElementStore.DIV_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.TABLE_ELEMENT;
import static org.tanaguru.rules.keystore.RemarkMessageStore.WRONG_TITLE_ASSOCIATION_WITH_TABLE;

/**
 * Unit test class for the implementation of the rule 5-4-1 of the referential Rgaa 4-2019.
 *
 * @author edaconceicao
 */
public class DataTableTitleCorrectlyAssociatedTest extends CommonRuleImplementationTestCase {

    /**
     * Default constructor
     */
    public DataTableTitleCorrectlyAssociatedTest(String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.tanaguru.ruleimplementation.impl.table.DataTableTitleCorrectlyAssociated");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("DataTableTitleCorrectlyAssociated-1Passed-01");
        addWebResource("DataTableTitleCorrectlyAssociated-1Passed-02");
        addWebResource("DataTableTitleCorrectlyAssociated-1Passed-03");
        addWebResource("DataTableTitleCorrectlyAssociated-1Passed-04");
        addWebResource("DataTableTitleCorrectlyAssociated-2Failed-01");
        addWebResource("DataTableTitleCorrectlyAssociated-2Failed-02");
        addWebResource("DataTableTitleCorrectlyAssociated-2Failed-03");
        addWebResource("DataTableTitleCorrectlyAssociated-2Failed-04");
        addWebResource("DataTableTitleCorrectlyAssociated-4NA-01");
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------1Passed-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("DataTableTitleCorrectlyAssociated-1Passed-01"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("DataTableTitleCorrectlyAssociated-1Passed-02"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-03------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("DataTableTitleCorrectlyAssociated-1Passed-03"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-04------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("DataTableTitleCorrectlyAssociated-1Passed-04"), 1);


        //----------------------------------------------------------------------
        //------------------------------2Failed-01------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("DataTableTitleCorrectlyAssociated-2Failed-01");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                WRONG_TITLE_ASSOCIATION_WITH_TABLE,
                TABLE_ELEMENT,
                1,
                new ImmutablePair(ARIA_LABEL_ATTR, "caption"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-02------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("DataTableTitleCorrectlyAssociated-2Failed-02");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                WRONG_TITLE_ASSOCIATION_WITH_TABLE,
                TABLE_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR, "caption"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-03------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("DataTableTitleCorrectlyAssociated-2Failed-03");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                WRONG_TITLE_ASSOCIATION_WITH_TABLE,
                DIV_ELEMENT,
                1,
                new ImmutablePair(ARIA_LABEL_ATTR, "caption"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-04------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("DataTableTitleCorrectlyAssociated-2Failed-04");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                WRONG_TITLE_ASSOCIATION_WITH_TABLE,
                DIV_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR, "caption"));

        //----------------------------------------------------------------------
        //------------------------------4NA-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("DataTableTitleCorrectlyAssociated-4NA-01"));
    }
}
