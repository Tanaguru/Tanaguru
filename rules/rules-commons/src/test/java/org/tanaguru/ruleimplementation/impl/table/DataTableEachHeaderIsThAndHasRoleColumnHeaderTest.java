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

import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.ruleimplementation.CommonRuleImplementationTestCase;

import static org.tanaguru.rules.keystore.HtmlElementStore.*;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_USAGE_OF_COLUMN_HEADERS_MSG;


/**
 * Unit test class for the implementation of the rule 5-6-1 of the referential Rgaa 4-2019.
 *
 * @author edaconceicao
 */
public class DataTableEachHeaderIsThAndHasRoleColumnHeaderTest extends CommonRuleImplementationTestCase {

    /**
     * Default constructor
     */
    public DataTableEachHeaderIsThAndHasRoleColumnHeaderTest(String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.tanaguru.ruleimplementation.impl.table.DataTableEachHeaderIsThAndHasRoleColumnHeader");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("DataTableEachHeaderIsThAndHasRoleColumnHeader-3NMI-01");
        addWebResource("DataTableEachHeaderIsThAndHasRoleColumnHeader-3NMI-02");
        addWebResource("DataTableEachHeaderIsThAndHasRoleColumnHeader-3NMI-03");
        addWebResource("DataTableEachHeaderIsThAndHasRoleColumnHeader-3NMI-04");
        addWebResource("DataTableEachHeaderIsThAndHasRoleColumnHeader-4NA-01");
        addWebResource("DataTableEachHeaderIsThAndHasRoleColumnHeader-4NA-02");
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------3NMI-01---------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("DataTableEachHeaderIsThAndHasRoleColumnHeader-3NMI-01");
        checkResultIsPreQualified(processResult, 2, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_USAGE_OF_COLUMN_HEADERS_MSG,
                THEAD_ELEMENT,
                1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_USAGE_OF_COLUMN_HEADERS_MSG,
                TR_ELEMENT,
                2);
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-02---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("DataTableEachHeaderIsThAndHasRoleColumnHeader-3NMI-02");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_USAGE_OF_COLUMN_HEADERS_MSG,
                TR_ELEMENT,
                1);
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-03---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("DataTableEachHeaderIsThAndHasRoleColumnHeader-3NMI-03");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_USAGE_OF_COLUMN_HEADERS_MSG,
                TR_ELEMENT,
                1);
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-04---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("DataTableEachHeaderIsThAndHasRoleColumnHeader-3NMI-04");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_USAGE_OF_COLUMN_HEADERS_MSG,
                SPAN_ELEMENT,
                1);


        //----------------------------------------------------------------------
        //------------------------------4NA-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("DataTableEachHeaderIsThAndHasRoleColumnHeader-4NA-01"));

        //----------------------------------------------------------------------
        //------------------------------4NA-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("DataTableEachHeaderIsThAndHasRoleColumnHeader-4NA-02"));
    }
}
