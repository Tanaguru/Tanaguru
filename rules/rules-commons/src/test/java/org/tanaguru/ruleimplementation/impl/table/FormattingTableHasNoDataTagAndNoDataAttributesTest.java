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
import org.tanaguru.rules.keystore.HtmlElementStore;
import org.tanaguru.rules.keystore.RemarkMessageStore;

import static org.tanaguru.rules.keystore.MarkerStore.PRESENTATION_TABLE_MARKER;

/**
 * Unit test class for the implementation of the rule 5-8-1 of the referential Rgaa 4-2019.
 *
 * @author edaconceicao
 */
public class FormattingTableHasNoDataTagAndNoDataAttributesTest extends CommonRuleImplementationTestCase {

    /**
     * Default constructor
     */
    public FormattingTableHasNoDataTagAndNoDataAttributesTest(String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.tanaguru.ruleimplementation.impl.table.FormattingTableHasNoDataTagAndNoDataAttributes");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("FormattingTableHasNoDataTagAndNoDataAttributes-1Passed-01",
	                createParameter("Rules", PRESENTATION_TABLE_MARKER, "id-presentation-table"));
	    addWebResource("FormattingTableHasNoDataTagAndNoDataAttributes-2Failed-01",
	                createParameter("Rules", PRESENTATION_TABLE_MARKER, "id-presentation-table"));
	    addWebResource("FormattingTableHasNoDataTagAndNoDataAttributes-2Failed-02",
	                createParameter("Rules", PRESENTATION_TABLE_MARKER, "id-presentation-table"));
	    addWebResource("FormattingTableHasNoDataTagAndNoDataAttributes-2Failed-03",
	                createParameter("Rules", PRESENTATION_TABLE_MARKER, "id-presentation-table"));
	    addWebResource("FormattingTableHasNoDataTagAndNoDataAttributes-2Failed-04",
	                createParameter("Rules", PRESENTATION_TABLE_MARKER, "id-presentation-table"));
	    addWebResource("FormattingTableHasNoDataTagAndNoDataAttributes-2Failed-05",
	                createParameter("Rules", PRESENTATION_TABLE_MARKER, "id-presentation-table"));
	    addWebResource("FormattingTableHasNoDataTagAndNoDataAttributes-2Failed-06",
	                createParameter("Rules", PRESENTATION_TABLE_MARKER, "id-presentation-table"));
	    addWebResource("FormattingTableHasNoDataTagAndNoDataAttributes-2Failed-07",
	                createParameter("Rules", PRESENTATION_TABLE_MARKER, "id-presentation-table"));
	    addWebResource("FormattingTableHasNoDataTagAndNoDataAttributes-2Failed-08",
	                createParameter("Rules", PRESENTATION_TABLE_MARKER, "id-presentation-table"));
	    addWebResource("FormattingTableHasNoDataTagAndNoDataAttributes-2Failed-09",
                	createParameter("Rules", PRESENTATION_TABLE_MARKER, "id-presentation-table"));
	    addWebResource("FormattingTableHasNoDataTagAndNoDataAttributes-2Failed-10",
                	createParameter("Rules", PRESENTATION_TABLE_MARKER, "class-presentation-table"));
	    addWebResource("FormattingTableHasNoDataTagAndNoDataAttributes-3NMI-01");
	    addWebResource("FormattingTableHasNoDataTagAndNoDataAttributes-3NMI-02");
	    addWebResource("FormattingTableHasNoDataTagAndNoDataAttributes-3NMI-03");
	    addWebResource("FormattingTableHasNoDataTagAndNoDataAttributes-3NMI-04");
	    addWebResource("FormattingTableHasNoDataTagAndNoDataAttributes-3NMI-05");
	    addWebResource("FormattingTableHasNoDataTagAndNoDataAttributes-3NMI-06");
	    addWebResource("FormattingTableHasNoDataTagAndNoDataAttributes-3NMI-07");
	    addWebResource("FormattingTableHasNoDataTagAndNoDataAttributes-3NMI-08");
	    addWebResource("FormattingTableHasNoDataTagAndNoDataAttributes-3NMI-09");
	    addWebResource("FormattingTableHasNoDataTagAndNoDataAttributes-3NMI-10");
	    addWebResource("FormattingTableHasNoDataTagAndNoDataAttributes-3NMI-11");
	    addWebResource("FormattingTableHasNoDataTagAndNoDataAttributes-4NA-01");
	
	}
	
	@Override
	protected void setProcess() {
	    //----------------------------------------------------------------------
	    //------------------------------1Passed-01------------------------------
	    //----------------------------------------------------------------------
	    checkResultIsPassed(processPageTest("FormattingTableHasNoDataTagAndNoDataAttributes-1Passed-01"),1);        
	    
	    //----------------------------------------------------------------------
	    //------------------------------2Failed-01------------------------------
	    //----------------------------------------------------------------------
	    ProcessResult processResult = processPageTest("FormattingTableHasNoDataTagAndNoDataAttributes-2Failed-01");
	    checkResultIsFailed(processResult, 1, 1);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.FAILED,
	            RemarkMessageStore.PRESENTATION_TABLE_WITH_FORBIDDEN_MARKUP_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            1);        
	    
	    //----------------------------------------------------------------------
	    //------------------------------2Failed-02------------------------------
	    //----------------------------------------------------------------------
	    processResult = processPageTest("FormattingTableHasNoDataTagAndNoDataAttributes-2Failed-02");
	    checkResultIsFailed(processResult, 1, 1);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.FAILED,
	            RemarkMessageStore.PRESENTATION_TABLE_WITH_FORBIDDEN_MARKUP_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            1);        
	    
	    //----------------------------------------------------------------------
	    //------------------------------2Failed-03------------------------------
	    //----------------------------------------------------------------------
	    processResult = processPageTest("FormattingTableHasNoDataTagAndNoDataAttributes-2Failed-03");
	    checkResultIsFailed(processResult, 1, 1);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.FAILED,
	            RemarkMessageStore.PRESENTATION_TABLE_WITH_FORBIDDEN_MARKUP_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            1);        
	    
	    //----------------------------------------------------------------------
	    //------------------------------2Failed-04------------------------------
	    //----------------------------------------------------------------------
	    processResult = processPageTest("FormattingTableHasNoDataTagAndNoDataAttributes-2Failed-04");
	    checkResultIsFailed(processResult, 1, 1);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.FAILED,
	            RemarkMessageStore.PRESENTATION_TABLE_WITH_FORBIDDEN_MARKUP_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            1);        
	    
	    //----------------------------------------------------------------------
	    //------------------------------2Failed-05------------------------------
	    //----------------------------------------------------------------------
	    processResult = processPageTest("FormattingTableHasNoDataTagAndNoDataAttributes-2Failed-05");
	    checkResultIsFailed(processResult, 1, 1);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.FAILED,
	            RemarkMessageStore.PRESENTATION_TABLE_WITH_FORBIDDEN_MARKUP_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            1);        
	    
	    //----------------------------------------------------------------------
	    //------------------------------2Failed-06------------------------------
	    //----------------------------------------------------------------------
	    processResult = processPageTest("FormattingTableHasNoDataTagAndNoDataAttributes-2Failed-06");
	    checkResultIsFailed(processResult, 1, 1);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.FAILED,
	            RemarkMessageStore.PRESENTATION_TABLE_WITH_FORBIDDEN_MARKUP_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            1);        
	    
	    //----------------------------------------------------------------------
	    //------------------------------2Failed-07------------------------------
	    //----------------------------------------------------------------------
	    processResult = processPageTest("FormattingTableHasNoDataTagAndNoDataAttributes-2Failed-07");
	    checkResultIsFailed(processResult, 1, 1);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.FAILED,
	            RemarkMessageStore.PRESENTATION_TABLE_WITH_FORBIDDEN_MARKUP_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            1);        
	    
	    //----------------------------------------------------------------------
	    //------------------------------2Failed-08------------------------------
	    //----------------------------------------------------------------------
	    processResult = processPageTest("FormattingTableHasNoDataTagAndNoDataAttributes-2Failed-08");
	    checkResultIsFailed(processResult, 1, 1);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.FAILED,
	            RemarkMessageStore.PRESENTATION_TABLE_WITH_FORBIDDEN_MARKUP_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            1);        
	    
	    //----------------------------------------------------------------------
	    //------------------------------2Failed-09------------------------------
	    //----------------------------------------------------------------------
	    processResult = processPageTest("FormattingTableHasNoDataTagAndNoDataAttributes-2Failed-09");
	    checkResultIsFailed(processResult, 1, 1);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.FAILED,
	            RemarkMessageStore.PRESENTATION_TABLE_WITH_FORBIDDEN_MARKUP_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            1);        
	
	    //----------------------------------------------------------------------
	    //------------------------------2Failed-10------------------------------
	    //----------------------------------------------------------------------
	    processResult = processPageTest("FormattingTableHasNoDataTagAndNoDataAttributes-2Failed-10");
	    checkResultIsFailed(processResult, 18, 17);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.FAILED,
	            RemarkMessageStore.PRESENTATION_TABLE_WITH_FORBIDDEN_MARKUP_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            1);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.FAILED,
	            RemarkMessageStore.PRESENTATION_TABLE_WITH_FORBIDDEN_MARKUP_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            2);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.FAILED,
	            RemarkMessageStore.PRESENTATION_TABLE_WITH_FORBIDDEN_MARKUP_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            3);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.FAILED,
	            RemarkMessageStore.PRESENTATION_TABLE_WITH_FORBIDDEN_MARKUP_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            4);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.FAILED,
	            RemarkMessageStore.PRESENTATION_TABLE_WITH_FORBIDDEN_MARKUP_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            5);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.FAILED,
	            RemarkMessageStore.PRESENTATION_TABLE_WITH_FORBIDDEN_MARKUP_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            6);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.FAILED,
	            RemarkMessageStore.PRESENTATION_TABLE_WITH_FORBIDDEN_MARKUP_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            7);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.NEED_MORE_INFO,
	            RemarkMessageStore.CHECK_TABLE_IS_DATA_TABLE_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            8);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.NEED_MORE_INFO,
	            RemarkMessageStore.CHECK_TABLE_IS_DATA_TABLE_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            9);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.NEED_MORE_INFO,
	            RemarkMessageStore.CHECK_TABLE_IS_DATA_TABLE_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            10);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.NEED_MORE_INFO,
	            RemarkMessageStore.CHECK_TABLE_IS_DATA_TABLE_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            11);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.NEED_MORE_INFO,
	            RemarkMessageStore.CHECK_TABLE_IS_DATA_TABLE_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            12);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.NEED_MORE_INFO,
	            RemarkMessageStore.CHECK_TABLE_IS_DATA_TABLE_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            13);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.NEED_MORE_INFO,
	            RemarkMessageStore.CHECK_TABLE_IS_DATA_TABLE_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            14);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.NEED_MORE_INFO,
	            RemarkMessageStore.CHECK_TABLE_IS_DATA_TABLE_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            15);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.NEED_MORE_INFO,
	            RemarkMessageStore.CHECK_TABLE_IS_DATA_TABLE_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            16);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.NEED_MORE_INFO,
	            RemarkMessageStore.CHECK_TABLE_IS_PRESENTATION_TABLE_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            17);
	    
	    //----------------------------------------------------------------------
	    //------------------------------3NMI-01---------------------------------
	    //----------------------------------------------------------------------
	    processResult = processPageTest("FormattingTableHasNoDataTagAndNoDataAttributes-3NMI-01");
	    checkResultIsPreQualified(processResult, 1,  1);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.NEED_MORE_INFO,
	            RemarkMessageStore.CHECK_TABLE_IS_PRESENTATION_TABLE_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            1);
	    
	    //----------------------------------------------------------------------
	    //------------------------------3NMI-02---------------------------------
	    //----------------------------------------------------------------------
	    processResult = processPageTest("FormattingTableHasNoDataTagAndNoDataAttributes-3NMI-02");
	    checkResultIsPreQualified(processResult, 1,  1);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.NEED_MORE_INFO,
	            RemarkMessageStore.CHECK_TABLE_IS_DATA_TABLE_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            1);
	    
	    //----------------------------------------------------------------------
	    //------------------------------3NMI-03---------------------------------
	    //----------------------------------------------------------------------
	    processResult = processPageTest("FormattingTableHasNoDataTagAndNoDataAttributes-3NMI-03");
	    checkResultIsPreQualified(processResult, 1,  1);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.NEED_MORE_INFO,
	            RemarkMessageStore.CHECK_TABLE_IS_DATA_TABLE_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            1);
	    
	    //----------------------------------------------------------------------
	    //------------------------------3NMI-04---------------------------------
	    //----------------------------------------------------------------------
	    processResult = processPageTest("FormattingTableHasNoDataTagAndNoDataAttributes-3NMI-04");
	    checkResultIsPreQualified(processResult, 1,  1);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.NEED_MORE_INFO,
	            RemarkMessageStore.CHECK_TABLE_IS_DATA_TABLE_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            1);
	    
	    //----------------------------------------------------------------------
	    //------------------------------3NMI-05---------------------------------
	    //----------------------------------------------------------------------
	    processResult = processPageTest("FormattingTableHasNoDataTagAndNoDataAttributes-3NMI-05");
	    checkResultIsPreQualified(processResult, 1,  1);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.NEED_MORE_INFO,
	            RemarkMessageStore.CHECK_TABLE_IS_DATA_TABLE_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            1);
	    
	    //----------------------------------------------------------------------
	    //------------------------------3NMI-06---------------------------------
	    //----------------------------------------------------------------------
	    processResult = processPageTest("FormattingTableHasNoDataTagAndNoDataAttributes-3NMI-06");
	    checkResultIsPreQualified(processResult, 1,  1);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.NEED_MORE_INFO,
	            RemarkMessageStore.CHECK_TABLE_IS_DATA_TABLE_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            1);
	    
	    //----------------------------------------------------------------------
	    //------------------------------3NMI-07---------------------------------
	    //----------------------------------------------------------------------
	    processResult = processPageTest("FormattingTableHasNoDataTagAndNoDataAttributes-3NMI-07");
	    checkResultIsPreQualified(processResult, 1,  1);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.NEED_MORE_INFO,
	            RemarkMessageStore.CHECK_TABLE_IS_DATA_TABLE_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            1);
	    
	    //----------------------------------------------------------------------
	    //------------------------------3NMI-08---------------------------------
	    //----------------------------------------------------------------------
	    processResult = processPageTest("FormattingTableHasNoDataTagAndNoDataAttributes-3NMI-08");
	    checkResultIsPreQualified(processResult, 1,  1);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.NEED_MORE_INFO,
	            RemarkMessageStore.CHECK_TABLE_IS_DATA_TABLE_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            1);
	    
	    //----------------------------------------------------------------------
	    //------------------------------3NMI-09---------------------------------
	    //----------------------------------------------------------------------
	    processResult = processPageTest("FormattingTableHasNoDataTagAndNoDataAttributes-3NMI-09");
	    checkResultIsPreQualified(processResult, 1,  1);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.NEED_MORE_INFO,
	            RemarkMessageStore.CHECK_TABLE_IS_DATA_TABLE_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            1);
	    
	    //----------------------------------------------------------------------
	    //------------------------------3NMI-10---------------------------------
	    //----------------------------------------------------------------------
	    processResult = processPageTest("FormattingTableHasNoDataTagAndNoDataAttributes-3NMI-10");
	    checkResultIsPreQualified(processResult, 1,  1);
	    checkRemarkIsPresent(
	            processResult,
	            TestSolution.NEED_MORE_INFO,
	            RemarkMessageStore.CHECK_TABLE_IS_DATA_TABLE_MSG,
	            HtmlElementStore.TABLE_ELEMENT,
	            1);
	    
	    //----------------------------------------------------------------------
	    //------------------------------3NMI-11---------------------------------
	    //----------------------------------------------------------------------
	    processResult = processPageTest("FormattingTableHasNoDataTagAndNoDataAttributes-3NMI-11");
	    checkResultIsPreQualified(processResult, 2,  2);
	
	    //----------------------------------------------------------------------
	    //------------------------------4NA-01------------------------------
	    //----------------------------------------------------------------------
	    checkResultIsNotApplicable(processPageTest("FormattingTableHasNoDataTagAndNoDataAttributes-4NA-01"));
	
	
	}
}
