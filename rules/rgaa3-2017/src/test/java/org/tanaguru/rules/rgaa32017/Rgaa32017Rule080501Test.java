/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2017  Tanaguru.org
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
package org.tanaguru.rules.rgaa32017;


import static org.tanaguru.rules.keystore.AttributeStore.ABSENT_ATTRIBUTE_VALUE;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.TITLE_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.NO_TITLE_IN_HTML_PAGE;
import static org.tanaguru.rules.keystore.RemarkMessageStore.MULTIPLE_TITLE_TAG_IN_THE_BODY_MSG;
import org.apache.commons.lang3.tuple.ImmutablePair;

import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.rules.keystore.RemarkMessageStore;
import org.tanaguru.rules.rgaa32017.test.Rgaa32017RuleImplementationTestCase;

/**
 * Unit test class for the implementation of the rule 8-5-1 of the referential Rgaa 3-2017.
 *
 * @author jkowalczyk
 */
public class Rgaa32017Rule080501Test extends Rgaa32017RuleImplementationTestCase {

    /**
     * Default constructor
     * @param testName
     */
    public Rgaa32017Rule080501Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName("org.tanaguru.rules.rgaa32017.Rgaa32017Rule080501");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("Rgaa32017.Test.08.05.01-1Passed-01");
        addWebResource("Rgaa32017.Test.08.05.01-2Failed-01");
        addWebResource("Rgaa32017.Test.08.05.01-2Failed-02");
        addWebResource("Rgaa32017.Test.08.05.01-2Failed-03");

    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------1Passed-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.08.05.01-1Passed-01"),1);        
        
        
        //----------------------------------------------------------------------
        //----------------------------2Failed-01--------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("Rgaa32017.Test.08.05.01-2Failed-01");
        checkResultIsFailed(processResult, 0, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.TITLE_TAG_MISSING_MSG,
                NO_TITLE_IN_HTML_PAGE,
                1,
                new ImmutablePair(TEXT_ELEMENT2, ABSENT_ATTRIBUTE_VALUE));
        
        
        //----------------------------------------------------------------------
        //----------------------------2Failed-02--------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.08.05.01-2Failed-02");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.TITLE_TAG_IN_THE_BODY_MSG,
                TITLE_CSS_LIKE_QUERY,
                1,
                new ImmutablePair(TEXT_ELEMENT2, "Rgaa32017 Test.8.5.1 Failed 02"));
        

        //----------------------------------------------------------------------
        //----------------------------2Failed-03--------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.08.05.01-2Failed-03");
        checkResultIsFailed(processResult, 2, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                MULTIPLE_TITLE_TAG_IN_THE_BODY_MSG,
                TITLE_CSS_LIKE_QUERY,
                1,
                new ImmutablePair(TEXT_ELEMENT2, "Rgaa32017 Test.8.5.1 Failed 03"));

        
    }

}