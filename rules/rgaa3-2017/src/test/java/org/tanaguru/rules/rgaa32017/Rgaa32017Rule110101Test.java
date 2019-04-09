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

import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.entity.audit.TestSolution;

import static org.tanaguru.entity.audit.TestSolution.FAILED;
import static org.tanaguru.rules.keystore.HtmlElementStore.INPUT_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.LABEL_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.P_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.SELECT_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXTAREA_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.AttributeStore.FOR_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ID_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABEL_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABELLEDBY_ATTR;
import static org.tanaguru.rules.keystore.RemarkMessageStore.NOT_PERTINENT_TEXTUAL_CONTENT_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_TEXT_PERTINENCE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.FORM_ELEMENT_WITHOUT_LABEL_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_ARIA_LABEL_PERTINENCE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_LABEL_PERTINENCE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.FORM_NOT_REFERENCED_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_TITLE_PERTINENCE_MSG;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.rules.rgaa32017.test.Rgaa32017RuleImplementationTestCase;

/**
 * Unit test class for the implementation of the rule 11-1-1 of the referential Rgaa 3-2017.
 *
 * @author jkowalczyk
 */
public class Rgaa32017Rule110101Test extends Rgaa32017RuleImplementationTestCase {

    /**
     * Default constructor
     * @param testName
     */
    public Rgaa32017Rule110101Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName("org.tanaguru.rules.rgaa32017.Rgaa32017Rule110101");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("Rgaa32017.Test.11.01.01-2Failed-01");
        addWebResource("Rgaa32017.Test.11.01.01-2Failed-02");
        addWebResource("Rgaa32017.Test.11.01.01-2Failed-03");
        addWebResource("Rgaa32017.Test.11.01.01-2Failed-04");
        addWebResource("Rgaa32017.Test.11.01.01-2Failed-05");
        addWebResource("Rgaa32017.Test.11.01.01-2Failed-06");
        addWebResource("Rgaa32017.Test.11.01.01-2Failed-07");
        addWebResource("Rgaa32017.Test.11.01.01-2Failed-08");
        addWebResource("Rgaa32017.Test.11.01.01-2Failed-09");
        addWebResource("Rgaa32017.Test.11.01.01-2Failed-10");
        addWebResource("Rgaa32017.Test.11.01.01-2Failed-11");
        addWebResource("Rgaa32017.Test.11.01.01-2Failed-12");
        addWebResource("Rgaa32017.Test.11.01.01-2Failed-13");
        addWebResource("Rgaa32017.Test.11.01.01-2Failed-14");
//        addWebResource("Rgaa32017.Test.11.01.01-2Failed-15");
        addWebResource("Rgaa32017.Test.11.01.01-2Failed-16");
        addWebResource("Rgaa32017.Test.11.01.01-2Failed-17");
        addWebResource("Rgaa32017.Test.11.01.01-2Failed-18");
        addWebResource("Rgaa32017.Test.11.01.01-2Failed-19");
        addWebResource("Rgaa32017.Test.11.01.01-3NMI-01"); 
        addWebResource("Rgaa32017.Test.11.01.01-3NMI-02");
        addWebResource("Rgaa32017.Test.11.01.01-3NMI-03");
        addWebResource("Rgaa32017.Test.11.01.01-3NMI-04");
        addWebResource("Rgaa32017.Test.11.01.01-3NMI-05");
        addWebResource("Rgaa32017.Test.11.01.01-3NMI-06");
        addWebResource("Rgaa32017.Test.11.01.01-3NMI-07");
        addWebResource("Rgaa32017.Test.11.01.01-3NMI-08");
        addWebResource("Rgaa32017.Test.11.01.01-3NMI-09");
        addWebResource("Rgaa32017.Test.11.01.01-3NMI-10");
        addWebResource("Rgaa32017.Test.11.01.01-3NMI-11");
        addWebResource("Rgaa32017.Test.11.01.01-3NMI-12");
        addWebResource("Rgaa32017.Test.11.01.01-3NMI-13");
        addWebResource("Rgaa32017.Test.11.01.01-3NMI-14");
        addWebResource("Rgaa32017.Test.11.01.01-3NMI-15");
        addWebResource("Rgaa32017.Test.11.01.01-3NMI-16");
        addWebResource("Rgaa32017.Test.11.01.01-3NMI-17");
        addWebResource("Rgaa32017.Test.11.01.01-3NMI-18");
        addWebResource("Rgaa32017.Test.11.01.01-3NMI-19");
        addWebResource("Rgaa32017.Test.11.01.01-3NMI-20");
        addWebResource("Rgaa32017.Test.11.01.01-4NA-01");
        addWebResource("Rgaa32017.Test.11.01.01-4NA-02");

    }

    @Override
    protected void setProcess() {
        

        //----------------------------------------------------------------------
        //------------------------------2Failed-01------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("Rgaa32017.Test.11.01.01-2Failed-01");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                FAILED, 
                FORM_NOT_REFERENCED_MSG, 
                INPUT_ELEMENT, 
                1,
                new ImmutablePair(ID_ATTR, "text"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-02------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-2Failed-02");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                FAILED, 
                FORM_NOT_REFERENCED_MSG, 
                INPUT_ELEMENT, 
                1,
                new ImmutablePair(ID_ATTR, "password"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-03------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-2Failed-03");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                FAILED, 
                FORM_NOT_REFERENCED_MSG, 
                INPUT_ELEMENT, 
                1,
                new ImmutablePair(ID_ATTR, "checkbox"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-04------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-2Failed-04");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                FAILED, 
                FORM_NOT_REFERENCED_MSG, 
                INPUT_ELEMENT, 
                1,
                new ImmutablePair(ID_ATTR, "radio"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-05------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-2Failed-05");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                FAILED, 
                FORM_NOT_REFERENCED_MSG, 
                INPUT_ELEMENT, 
                1,
                new ImmutablePair(ID_ATTR, "file"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-06------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-2Failed-06");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                FAILED, 
                FORM_NOT_REFERENCED_MSG, 
                TEXTAREA_ELEMENT, 
                1,
                new ImmutablePair(ID_ATTR, "textarea"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-07------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-2Failed-07");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                FAILED, 
                FORM_NOT_REFERENCED_MSG, 
                SELECT_ELEMENT, 
                1,
                new ImmutablePair(ID_ATTR, "select"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-08------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-2Failed-08");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                FAILED, 
                FORM_ELEMENT_WITHOUT_LABEL_MSG, 
                INPUT_ELEMENT, 
                1);

        //----------------------------------------------------------------------
        //------------------------------2Failed-09------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-2Failed-09");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                FAILED, 
                NOT_PERTINENT_TEXTUAL_CONTENT_MSG, 
                P_ELEMENT, 
                1,
                new ImmutablePair(ID_ATTR, "FAILED 09"),
                new ImmutablePair(TEXT_ELEMENT2, "12@#=+"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-10------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-2Failed-10");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                FAILED, 
                FORM_ELEMENT_WITHOUT_LABEL_MSG, 
                INPUT_ELEMENT, 
                1);

        //----------------------------------------------------------------------
        //------------------------------2Failed-11------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-2Failed-11");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                FAILED, 
                FORM_NOT_REFERENCED_MSG, 
                INPUT_ELEMENT, 
                1,
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, "FAILED 11"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-12------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-2Failed-12");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                FAILED, 
                FORM_NOT_REFERENCED_MSG, 
                INPUT_ELEMENT, 
                1,
                new ImmutablePair(ID_ATTR, "FAILED 12"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-13------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-2Failed-13");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                FAILED, 
                FORM_NOT_REFERENCED_MSG, 
                SELECT_ELEMENT, 
                1,
                new ImmutablePair(ID_ATTR, "select"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-14------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-2Failed-14");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                FAILED, 
                FORM_NOT_REFERENCED_MSG, 
                TEXTAREA_ELEMENT, 
                1,
                new ImmutablePair(ID_ATTR, "FAILED 14"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-15------------------------------
        //----------------------------------------------------------------------
//        processResult = processPageTest("Rgaa32017.Test.11.01.01-2Failed-15");
//        checkResultIsFailed(processResult,1,1);
//        checkRemarkIsPresent(
//                processResult, 
//                FAILED, 
//                FORM_NOT_REFERENCED_MSG, 
//                INPUT_ELEMENT, 
//                1,
//                new ImmutablePair(ID_ATTR, "FAILED 15"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-16------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-2Failed-16");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                FAILED, 
                FORM_NOT_REFERENCED_MSG, 
                INPUT_ELEMENT, 
                1,
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, "FAILED 16"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-17------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-2Failed-17");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                FAILED, 
                FORM_NOT_REFERENCED_MSG, 
                SELECT_ELEMENT, 
                1,
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, "select"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-18------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-2Failed-18");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                FAILED, 
                FORM_NOT_REFERENCED_MSG, 
                TEXTAREA_ELEMENT, 
                1,
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, "FAILED 18"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-19------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-2Failed-19");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                FAILED, 
                FORM_NOT_REFERENCED_MSG, 
                INPUT_ELEMENT, 
                1,
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, "FAILED 19"));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-01------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-3NMI-01");
        checkResultIsPreQualified(processResult,1,1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_TITLE_PERTINENCE_MSG,
                SELECT_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR, "select title"));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-02------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-3NMI-02");
        checkResultIsPreQualified(processResult,1,1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_TITLE_PERTINENCE_MSG,
                INPUT_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR, "text input title"));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-03------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-3NMI-03");
        checkResultIsPreQualified(processResult,1,1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_ARIA_LABEL_PERTINENCE_MSG,
                INPUT_ELEMENT,
                1,
                new ImmutablePair(ARIA_LABEL_ATTR, "Telephone"));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-04------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-3NMI-04");
        checkResultIsPreQualified(processResult,1,1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_ARIA_LABEL_PERTINENCE_MSG,
                INPUT_ELEMENT,
                1,
                new ImmutablePair(ARIA_LABEL_ATTR, "Telephone"));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-05------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-3NMI-05");
        checkResultIsPreQualified(processResult,1,1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_LABEL_PERTINENCE_MSG,
                LABEL_ELEMENT,
                1,
                new ImmutablePair(FOR_ATTR, "text"),
                new ImmutablePair(TEXT_ELEMENT2, "Text:"));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-06------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-3NMI-06");
        checkResultIsPreQualified(processResult,1,1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_LABEL_PERTINENCE_MSG,
                LABEL_ELEMENT,
                1,
                new ImmutablePair(FOR_ATTR, "password"),
                new ImmutablePair(TEXT_ELEMENT2, "Password:"));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-07------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-3NMI-07");
        checkResultIsPreQualified(processResult,1,1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_LABEL_PERTINENCE_MSG,
                LABEL_ELEMENT,
                1,
                new ImmutablePair(FOR_ATTR, "checkbox"),
                new ImmutablePair(TEXT_ELEMENT2, "checkbox :"));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-08------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-3NMI-08");
        checkResultIsPreQualified(processResult,1,1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_LABEL_PERTINENCE_MSG,
                LABEL_ELEMENT,
                1,
                new ImmutablePair(FOR_ATTR, "radio"),
                new ImmutablePair(TEXT_ELEMENT2, "radio :"));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-09------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-3NMI-09");
        checkResultIsPreQualified(processResult,1,1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_LABEL_PERTINENCE_MSG,
                LABEL_ELEMENT,
                1,
                new ImmutablePair(FOR_ATTR, "file"),
                new ImmutablePair(TEXT_ELEMENT2, "file :"));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-10------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-3NMI-10");
        checkResultIsPreQualified(processResult,1,1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_LABEL_PERTINENCE_MSG,
                LABEL_ELEMENT,
                1,
                new ImmutablePair(FOR_ATTR, "textarea"),
                new ImmutablePair(TEXT_ELEMENT2, "Textarea :"));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-11------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-3NMI-11");
        checkResultIsPreQualified(processResult,1,1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_LABEL_PERTINENCE_MSG,
                LABEL_ELEMENT,
                1,
                new ImmutablePair(FOR_ATTR, "select"),
                new ImmutablePair(TEXT_ELEMENT2, "Select :"));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-12------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-3NMI-12");
        checkResultIsPreQualified(processResult,1,1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_TEXT_PERTINENCE_MSG,
                P_ELEMENT,
                1,
                new ImmutablePair(ID_ATTR, "NMI 12"),
                new ImmutablePair(TEXT_ELEMENT2, "Je suis un texte descriptif."));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-13------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-3NMI-13");
        checkResultIsPreQualified(processResult,1,1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_TEXT_PERTINENCE_MSG,
                P_ELEMENT,
                1,
                new ImmutablePair(ID_ATTR, "NMI 13"),
                new ImmutablePair(TEXT_ELEMENT2, "Je suis un texte descriptif."));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-14------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-3NMI-14");
        checkResultIsPreQualified(processResult,1,1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_TEXT_PERTINENCE_MSG,
                P_ELEMENT,
                1,
                new ImmutablePair(ID_ATTR, "NMI 14"),
                new ImmutablePair(TEXT_ELEMENT2, "Je suis un texte descriptif."));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-15------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-3NMI-15");
        checkResultIsPreQualified(processResult,1,1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_TEXT_PERTINENCE_MSG,
                P_ELEMENT,
                1,
                new ImmutablePair(ID_ATTR, "NMI 15"),
                new ImmutablePair(TEXT_ELEMENT2, "Je suis un texte descriptif."));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-16------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-3NMI-16");
        checkResultIsPreQualified(processResult,1,1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_TEXT_PERTINENCE_MSG,
                P_ELEMENT,
                1,
                new ImmutablePair(ID_ATTR, "NMI 16"),
                new ImmutablePair(TEXT_ELEMENT2, "Je suis un texte descriptif."));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-17------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-3NMI-17");
        checkResultIsPreQualified(processResult,1,1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_TEXT_PERTINENCE_MSG,
                P_ELEMENT,
                1,
                new ImmutablePair(ID_ATTR, "NMI 17"),
                new ImmutablePair(TEXT_ELEMENT2, "Je suis un texte descriptif."));
        
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-18------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-3NMI-18");
        checkResultIsPreQualified(processResult,1,1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_LABEL_PERTINENCE_MSG,
                LABEL_ELEMENT,
                1,
                new ImmutablePair(FOR_ATTR, "NMI 18"),
                new ImmutablePair(TEXT_ELEMENT2, ""));
        
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-19------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-3NMI-19");
        checkResultIsPreQualified(processResult,1,1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_TEXT_PERTINENCE_MSG,
                P_ELEMENT,
                1,
                new ImmutablePair(ID_ATTR, "NMI 19"),
                new ImmutablePair(TEXT_ELEMENT2, ""));
        
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-20------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.01-3NMI-20");
        checkResultIsPreQualified(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.NEED_MORE_INFO,
                CHECK_TEXT_PERTINENCE_MSG, 
                P_ELEMENT, 
                1,
                new ImmutablePair(ID_ATTR, "NMI 20"),
                new ImmutablePair(TEXT_ELEMENT2, "mock-image.jpg"));
        
        //----------------------------------------------------------------------
        //------------------------------4NA-01----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.11.01.01-4NA-01"));
        
        //----------------------------------------------------------------------
        //------------------------------4NA-02----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.11.01.01-4NA-02"));
    }

}