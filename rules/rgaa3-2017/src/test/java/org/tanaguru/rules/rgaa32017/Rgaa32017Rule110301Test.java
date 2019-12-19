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

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.rules.rgaa32017.test.Rgaa32017RuleImplementationTestCase;
import org.tanaguru.rules.keystore.AttributeStore;
import org.tanaguru.rules.keystore.HtmlElementStore;
import org.tanaguru.rules.keystore.RemarkMessageStore;

/**
 * Unit test class for the implementation of the rule 11-3-1 of the referential Rgaa 3-2017.
 *
 * @author jkowalczyk
 */
public class Rgaa32017Rule110301Test extends Rgaa32017RuleImplementationTestCase {

    /**
     * Default constructor
     * @param testName
     */
    public Rgaa32017Rule110301Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName("org.tanaguru.rules.rgaa32017.LabelRepetedInPageIsConsistent");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("Rgaa32017.Test.11.03.01-3NMI-01");
        addWebResource("Rgaa32017.Test.11.03.01-3NMI-02");
        addWebResource("Rgaa32017.Test.11.03.01-3NMI-03");
        addWebResource("Rgaa32017.Test.11.03.01-3NMI-04");
        addWebResource("Rgaa32017.Test.11.03.01-3NMI-05");
        addWebResource("Rgaa32017.Test.11.03.01-3NMI-06");
        addWebResource("Rgaa32017.Test.11.03.01-3NMI-07");
        addWebResource("Rgaa32017.Test.11.03.01-3NMI-08");
        addWebResource("Rgaa32017.Test.11.03.01-3NMI-09");
        addWebResource("Rgaa32017.Test.11.03.01-3NMI-10");
        addWebResource("Rgaa32017.Test.11.03.01-3NMI-11");
        addWebResource("Rgaa32017.Test.11.03.01-4NA-01");
        addWebResource("Rgaa32017.Test.11.03.01-4NA-02");
        addWebResource("Rgaa32017.Test.11.03.01-4NA-03");
        addWebResource("Rgaa32017.Test.11.03.01-4NA-04");
        addWebResource("Rgaa32017.Test.11.03.01-4NA-05");
        addWebResource("Rgaa32017.Test.11.03.01-4NA-06");
        addWebResource("Rgaa32017.Test.11.03.01-4NA-07");
        addWebResource("Rgaa32017.Test.11.03.01-4NA-08");
        addWebResource("Rgaa32017.Test.11.03.01-4NA-09");
        addWebResource("Rgaa32017.Test.11.03.01-4NA-10");

    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------3NMI-01---------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("Rgaa32017.Test.11.03.01-3NMI-01");
        checkResultIsPreQualified(processResult, 0, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_REPEATED_LABEL_PERTINENCE_MSG,
                HtmlElementStore.LABEL_ELEMENT,
                1,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2,"Field"),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR,""),
                new ImmutablePair(AttributeStore.TITLE_ATTR,"")
                );
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_REPEATED_LABEL_PERTINENCE_MSG,
                HtmlElementStore.LABEL_ELEMENT,
                2,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2,"Field"),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR,""),
                new ImmutablePair(AttributeStore.TITLE_ATTR,""));
        
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-02---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.03.01-3NMI-02");
        checkResultIsPreQualified(processResult, 0, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_REPEATED_LABEL_PERTINENCE_MSG,
                HtmlElementStore.LABEL_ELEMENT,
                1,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2,"Field"),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR,""),
                new ImmutablePair(AttributeStore.TITLE_ATTR,""));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_REPEATED_LABEL_PERTINENCE_MSG,
                HtmlElementStore.LABEL_ELEMENT,
                2,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2,"Field"),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR,""),
                new ImmutablePair(AttributeStore.TITLE_ATTR,""));
        
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-03---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.03.01-3NMI-03");
        checkResultIsPreQualified(processResult, 0, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_REPEATED_LABEL_PERTINENCE_MSG,
                HtmlElementStore.P_ELEMENT,
                1,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2,"Field"),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR,""),
                new ImmutablePair(AttributeStore.TITLE_ATTR,""));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_REPEATED_LABEL_PERTINENCE_MSG,
                HtmlElementStore.P_ELEMENT,
                2,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2,"Field"),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR,""),
                new ImmutablePair(AttributeStore.TITLE_ATTR,""));
        
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-04---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.03.01-3NMI-04");
        checkResultIsPreQualified(processResult, 0, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_REPEATED_LABEL_PERTINENCE_MSG,
                HtmlElementStore.INPUT_ELEMENT,
                1,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2,""),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR,"Field_NMI_04"),
                new ImmutablePair(AttributeStore.TITLE_ATTR,""));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_REPEATED_LABEL_PERTINENCE_MSG,
                HtmlElementStore.INPUT_ELEMENT,
                2,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2,""),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR,"Field_NMI_04"),
                new ImmutablePair(AttributeStore.TITLE_ATTR,""));
        
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-05---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.03.01-3NMI-05");
        checkResultIsPreQualified(processResult, 0, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_REPEATED_LABEL_PERTINENCE_MSG,
                HtmlElementStore.INPUT_ELEMENT,
                1,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2,""),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR,""),
                new ImmutablePair(AttributeStore.TITLE_ATTR,"Field_NMI_05"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_REPEATED_LABEL_PERTINENCE_MSG,
                HtmlElementStore.INPUT_ELEMENT,
                2,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2,""),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR,""),
                new ImmutablePair(AttributeStore.TITLE_ATTR,"Field_NMI_05"));
        
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-06---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.03.01-3NMI-06");
        checkResultIsPreQualified(processResult, 0, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_REPEATED_LABEL_PERTINENCE_MSG,
                HtmlElementStore.INPUT_ELEMENT,
                1,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2,""),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR,"Field_NMI_06"),
                new ImmutablePair(AttributeStore.TITLE_ATTR,""));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_REPEATED_LABEL_PERTINENCE_MSG,
                HtmlElementStore.INPUT_ELEMENT,
                2,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2,""),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR,""),
                new ImmutablePair(AttributeStore.TITLE_ATTR,"Field_NMI_06"));
        
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-07---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.03.01-3NMI-07");
        checkResultIsPreQualified(processResult, 0, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_REPEATED_LABEL_PERTINENCE_MSG,
                HtmlElementStore.INPUT_ELEMENT,
                1,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2,""),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR,"Field_NMI_07"),
                new ImmutablePair(AttributeStore.TITLE_ATTR,""));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_REPEATED_LABEL_PERTINENCE_MSG,
                HtmlElementStore.LABEL_ELEMENT,
                2,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2,"Field_NMI_07"),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR,""),
                new ImmutablePair(AttributeStore.TITLE_ATTR,""));
        
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-08---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.03.01-3NMI-08");
        checkResultIsPreQualified(processResult, 0, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_REPEATED_LABEL_PERTINENCE_MSG,
                HtmlElementStore.P_ELEMENT,
                1,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2,"Field_NMI_08"),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR,""),
                new ImmutablePair(AttributeStore.TITLE_ATTR,""));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_REPEATED_LABEL_PERTINENCE_MSG,
                HtmlElementStore.INPUT_ELEMENT,
                2,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2,""),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR,"Field_NMI_08"),
                new ImmutablePair(AttributeStore.TITLE_ATTR,""));
        
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-09---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.03.01-3NMI-09");
        checkResultIsPreQualified(processResult, 0, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_REPEATED_LABEL_PERTINENCE_MSG,
                HtmlElementStore.LABEL_ELEMENT,
                1,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2,"Field_NMI_09"),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR,""),
                new ImmutablePair(AttributeStore.TITLE_ATTR,""));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_REPEATED_LABEL_PERTINENCE_MSG,
                HtmlElementStore.INPUT_ELEMENT,
                2,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2,""),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR,""),
                new ImmutablePair(AttributeStore.TITLE_ATTR,"Field_NMI_09"));
        
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-10---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.03.01-3NMI-10");
        checkResultIsPreQualified(processResult, 0, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_REPEATED_LABEL_PERTINENCE_MSG,
                HtmlElementStore.P_ELEMENT,
                1,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2,"Field_NMI_10"),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR,""),
                new ImmutablePair(AttributeStore.TITLE_ATTR,""));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_REPEATED_LABEL_PERTINENCE_MSG,
                HtmlElementStore.INPUT_ELEMENT,
                2,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2,""),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR,""),
                new ImmutablePair(AttributeStore.TITLE_ATTR,"Field_NMI_10"));
        
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-11---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.03.01-3NMI-11");
        checkResultIsPreQualified(processResult, 0, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_REPEATED_LABEL_PERTINENCE_MSG,
                HtmlElementStore.P_ELEMENT,
                1,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2,"Field_NMI_11"),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR,""),
                new ImmutablePair(AttributeStore.TITLE_ATTR,""));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_REPEATED_LABEL_PERTINENCE_MSG,
                HtmlElementStore.LABEL_ELEMENT,
                2,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2,"Field_NMI_11"),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR,""),
                new ImmutablePair(AttributeStore.TITLE_ATTR,""));
               
        
        //----------------------------------------------------------------------
        //------------------------------4NA-01----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.11.03.01-4NA-01"));

        
        //----------------------------------------------------------------------
        //------------------------------4NA-02----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.11.03.01-4NA-02"));

        
        //----------------------------------------------------------------------
        //------------------------------4NA-03----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.11.03.01-4NA-03"));

        
        //----------------------------------------------------------------------
        //------------------------------4NA-04----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.11.03.01-4NA-04"));

        
        //----------------------------------------------------------------------
        //------------------------------4NA-05----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.11.03.01-4NA-05"));

        
        //----------------------------------------------------------------------
        //------------------------------4NA-06----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.11.03.01-4NA-06"));

        
        //----------------------------------------------------------------------
        //------------------------------4NA-07----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.11.03.01-4NA-07"));

        
        //----------------------------------------------------------------------
        //------------------------------4NA-08----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.11.03.01-4NA-08"));

        
        //----------------------------------------------------------------------
        //------------------------------4NA-09----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.11.03.01-4NA-09"));

        
        //----------------------------------------------------------------------
        //------------------------------4NA-10----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.11.03.01-4NA-10"));
    }

}
