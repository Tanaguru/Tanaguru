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
import org.tanaguru.rules.keystore.HtmlElementStore;
import org.tanaguru.rules.keystore.RemarkMessageStore;
import org.tanaguru.entity.audit.ProcessResult;

import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.rules.rgaa42019.test.Rgaa42019RuleImplementationTestCase;

/**
 * Unit test class for the implementation of the rule 11-2-2 of the referential Rgaa 4-2019.
 *
 * @author edaconceicao
 */
public class Rgaa42019Rule110202Test extends Rgaa42019RuleImplementationTestCase {

    /**
     * Default constructor
     */
    public Rgaa42019Rule110202Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.tanaguru.rules.rgaa42019.Rgaa42019Rule110202");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("Rgaa42019.Test.11.02.02-3NMI-01");
        addWebResource("Rgaa42019.Test.11.02.02-3NMI-02");
        addWebResource("Rgaa42019.Test.11.02.02-3NMI-03");
        addWebResource("Rgaa42019.Test.11.02.02-3NMI-04");
        addWebResource("Rgaa42019.Test.11.02.02-3NMI-05");
        addWebResource("Rgaa42019.Test.11.02.02-3NMI-06");
        addWebResource("Rgaa42019.Test.11.02.02-3NMI-07");
        addWebResource("Rgaa42019.Test.11.02.02-4NA-01");
        addWebResource("Rgaa42019.Test.11.02.02-4NA-02");
        addWebResource("Rgaa42019.Test.11.02.02-4NA-03");
        addWebResource("Rgaa42019.Test.11.02.02-4NA-04");
        addWebResource("Rgaa42019.Test.11.02.02-4NA-05");
        addWebResource("Rgaa42019.Test.11.02.02-4NA-06");
        addWebResource("Rgaa42019.Test.11.02.02-4NA-07");

    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------3NMI-01---------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("Rgaa42019.Test.11.02.02-3NMI-01");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_TITLE_ATTR_PERTINENCE_MSG,
                HtmlElementStore.INPUT_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR,"input title"));
       
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-02---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.11.02.02-3NMI-02");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_TITLE_ATTR_PERTINENCE_MSG,
                HtmlElementStore.INPUT_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR,"input title"));
        
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-03---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.11.02.02-3NMI-03");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_TITLE_ATTR_PERTINENCE_MSG,
                HtmlElementStore.INPUT_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR,"input title"));
        
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-04---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.11.02.02-3NMI-04");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_TITLE_ATTR_PERTINENCE_MSG,
                HtmlElementStore.INPUT_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR,"input title"));
        
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-05---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.11.02.02-3NMI-05");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_TITLE_ATTR_PERTINENCE_MSG,
                HtmlElementStore.INPUT_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR,"input title"));
        
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-06---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.11.02.02-3NMI-06");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_TITLE_ATTR_PERTINENCE_MSG,
                HtmlElementStore.TEXTAREA_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR,"input title"));
        
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-07---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.11.02.02-3NMI-07");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_TITLE_ATTR_PERTINENCE_MSG,
                HtmlElementStore.SELECT_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR,"input title"));

        
        //----------------------------------------------------------------------
        //------------------------------4NA-01----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.11.02.02-4NA-01"));
        

        //----------------------------------------------------------------------
        //------------------------------4NA-02----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.11.02.02-4NA-02"));
        

        //----------------------------------------------------------------------
        //------------------------------4NA-03----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.11.02.02-4NA-03"));
        

        //----------------------------------------------------------------------
        //------------------------------4NA-04----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.11.02.02-4NA-04"));

        
        //----------------------------------------------------------------------
        //------------------------------4NA-05----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.11.02.02-4NA-05"));
        

        //----------------------------------------------------------------------
        //------------------------------4NA-06----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.11.02.02-4NA-06"));
        

        //----------------------------------------------------------------------
        //------------------------------4NA-07----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.11.02.02-4NA-07"));
    }

}
