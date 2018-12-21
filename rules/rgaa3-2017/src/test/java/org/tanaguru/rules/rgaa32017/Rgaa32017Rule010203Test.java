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
import org.tanaguru.entity.audit.*;
import static org.tanaguru.rules.keystore.AttributeStore.DATA_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_HIDDEN_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABEL_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABELLEDBY_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_DESCRIBEDBY_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;
import static org.tanaguru.rules.keystore.HtmlElementStore.IMG_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.OBJECT_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.MarkerStore.DECORATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.INFORMATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_ELEMENT_WITH_EMPTY_ALT_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_ELEMENT_WITH_NOT_EMPTY_ALT_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITH_NOT_EMPTY_ALT_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_IMG_OR_CHILDREN_WITH_ARIA_ATTRIBUTE;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_IMG_OR_CHILD_WITH_TITLE_ATTRIBUTE;
import static org.tanaguru.rules.keystore.RemarkMessageStore.SUSPECTED_DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.SUSPECTED_DECORATIVE_IMG_WITH_ARIA_ATTRIBUTE_DETECTED_ON_ELEMENT_OR_CHILD;
import static org.tanaguru.rules.keystore.RemarkMessageStore.SUSPECTED_DECORATIVE_IMG_WITH_NOT_EMPTY_TEXT_ALT_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.SUSPECTED_DECORATIVE_IMG_WITH_TITLE_ATTRIBUTE_ON_ELEMENT_OR_CHILD;
import static org.tanaguru.rules.keystore.RemarkMessageStore.SUSPECTED_WELL_FORMATED_DECORATIVE_IMG;

import org.tanaguru.rules.rgaa32017.test.Rgaa32017RuleImplementationTestCase;

/**
 * Unit test class for the implementation of the rule 1-2-3 of the referential Rgaa 3-2017.
 *
 * @author jkowalczyk
 */
public class Rgaa32017Rule010203Test extends Rgaa32017RuleImplementationTestCase {

    /**
     * Default constructor
     * @param testName
     */
    public Rgaa32017Rule010203Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName("org.tanaguru.rules.rgaa32017.Rgaa32017Rule010203");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("Rgaa32017.Test.1.2.3-1Passed-01",
                    createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-object"));
        addWebResource("Rgaa32017.Test.1.2.3-1Passed-02",
                    createParameter("Rules", DECORATIVE_IMAGE_MARKER, "class-decorative-object"));
        addWebResource("Rgaa32017.Test.1.2.3-1Passed-03",
                    createParameter("Rules", DECORATIVE_IMAGE_MARKER, "role-decorative-object"));
        addWebResource("Rgaa32017.Test.1.2.3-1Passed-04",
                    createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-object;class-decorative-object;role-decorative-object"));
        addWebResource("Rgaa32017.Test.1.2.3-1Passed-05",
                    createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-object"),
                    createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "class-informative-object"));
        addWebResource("Rgaa32017.Test.1.2.3-2Failed-01",
                    createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-object"));
        addWebResource("Rgaa32017.Test.1.2.3-2Failed-02",
                    createParameter("Rules", DECORATIVE_IMAGE_MARKER, "class-decorative-object"));
        addWebResource("Rgaa32017.Test.1.2.3-2Failed-03",
                    createParameter("Rules", DECORATIVE_IMAGE_MARKER, "role-decorative-object"));
        addWebResource("Rgaa32017.Test.1.2.3-2Failed-04",
                    createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-object;class-decorative-object;role-decorative-object"));
        addWebResource("Rgaa32017.Test.1.2.3-2Failed-05",
                    createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-object"),
                    createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "class-informative-object"));
        addWebResource("Rgaa32017.Test.1.2.3-2Failed-06",
                	createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-object"));
        addWebResource("Rgaa32017.Test.1.2.3-2Failed-07",
            		createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-object"));
        addWebResource("Rgaa32017.Test.1.2.3-2Failed-08",
            		createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-object"));
        addWebResource("Rgaa32017.Test.1.2.3-2Failed-09",
            		createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-object"));
        addWebResource("Rgaa32017.Test.1.2.3-2Failed-10",
            		createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-object"));
        addWebResource("Rgaa32017.Test.1.2.3-2Failed-11",
            		createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-object"));
        addWebResource("Rgaa32017.Test.1.2.3-3NMI-01");
        addWebResource("Rgaa32017.Test.1.2.3-3NMI-02");
        addWebResource("Rgaa32017.Test.1.2.3-3NMI-03",
                    createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "class-informative-object"));
        addWebResource("Rgaa32017.Test.1.2.3-3NMI-04",
                    createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "class-informative-object"));
        addWebResource("Rgaa32017.Test.1.2.3-3NMI-05",
                    createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-object"));
        addWebResource("Rgaa32017.Test.1.2.3-3NMI-06",
                    createParameter("Rules", DECORATIVE_IMAGE_MARKER, "class-decorative-object"));
        addWebResource("Rgaa32017.Test.1.2.3-3NMI-07");
        addWebResource("Rgaa32017.Test.1.2.3-3NMI-08");
        addWebResource("Rgaa32017.Test.1.2.3-3NMI-09");
        addWebResource("Rgaa32017.Test.1.2.3-3NMI-10");
        addWebResource("Rgaa32017.Test.1.2.3-3NMI-11");
        addWebResource("Rgaa32017.Test.1.2.3-3NMI-12");
        addWebResource("Rgaa32017.Test.1.2.3-3NMI-13");
        addWebResource("Rgaa32017.Test.1.2.3-4NA-01");
        addWebResource("Rgaa32017.Test.1.2.3-4NA-02");
        addWebResource("Rgaa32017.Test.1.2.3-4NA-03");
        addWebResource("Rgaa32017.Test.1.2.3-4NA-04");
        addWebResource("Rgaa32017.Test.1.2.3-4NA-05");
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------1Passed-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.1.2.3-1Passed-01"),1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.1.2.3-1Passed-02"),1);
        
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-03------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.1.2.3-1Passed-03"),1);
        
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-04------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.1.2.3-1Passed-04"),3);

        
        //----------------------------------------------------------------------
        //------------------------------1Passed-05------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.1.2.3-1Passed-05"),1);

        
        //----------------------------------------------------------------------
        //------------------------------2Failed-01------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("Rgaa32017.Test.1.2.3-2Failed-01");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG, 
                OBJECT_ELEMENT, 
                1, 
                new ImmutablePair(DATA_ATTR, "mock_image.gif"));


        //----------------------------------------------------------------------
        //------------------------------2Failed-02------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.2.3-2Failed-02");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG, 
                OBJECT_ELEMENT, 
                1, 
                new ImmutablePair(DATA_ATTR, "mock_image.gif"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-03------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.2.3-2Failed-03");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG, 
                OBJECT_ELEMENT, 
                1, 
                new ImmutablePair(DATA_ATTR, "mock_image.gif"));
        

        //----------------------------------------------------------------------
        //------------------------------2Failed-04------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.2.3-2Failed-04");
        checkResultIsFailed(processResult, 3, 3);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG, 
                OBJECT_ELEMENT, 
                1, 
                new ImmutablePair(DATA_ATTR, "mock_image1.gif"));
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG, 
                OBJECT_ELEMENT, 
                2, 
                new ImmutablePair(DATA_ATTR, "mock_image2.gif"));
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG, 
                OBJECT_ELEMENT, 
                3, 
                new ImmutablePair(DATA_ATTR, "mock_image3.gif"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-05------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.2.3-2Failed-05");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG, 
                OBJECT_ELEMENT, 
                1, 
                new ImmutablePair(DATA_ATTR, "mock_image1.gif"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-06------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.2.3-2Failed-06");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                DECORATIVE_ELEMENT_WITH_NOT_EMPTY_ALT_MSG, 
                OBJECT_ELEMENT, 
                1, 
                new ImmutablePair(TEXT_ELEMENT2, "Not empty text"),
                new ImmutablePair(DATA_ATTR, "mock_image.gif"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-07------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.2.3-2Failed-07");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                DECORATIVE_IMG_OR_CHILDREN_WITH_ARIA_ATTRIBUTE, 
                OBJECT_ELEMENT, 
                1, 
                new ImmutablePair(ARIA_LABEL_ATTR, "mock image"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-08------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.2.3-2Failed-08");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                DECORATIVE_IMG_OR_CHILDREN_WITH_ARIA_ATTRIBUTE, 
                OBJECT_ELEMENT, 
                1, 
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, "mock image"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-09------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.2.3-2Failed-09");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                DECORATIVE_IMG_OR_CHILDREN_WITH_ARIA_ATTRIBUTE, 
                OBJECT_ELEMENT, 
                1, 
                new ImmutablePair(ARIA_DESCRIBEDBY_ATTR, "mock image"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-10------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.2.3-2Failed-10");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                DECORATIVE_IMG_OR_CHILD_WITH_TITLE_ATTRIBUTE, 
                OBJECT_ELEMENT, 
                1, 
                new ImmutablePair(TITLE_ATTR, "mock image"));

        //----------------------------------------------------------------------
        //------------------------------2Failed-11------------------------------
        //----------------------------------------------------------------------
    	processResult = processPageTest("Rgaa32017.Test.1.2.3-2Failed-11");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                DECORATIVE_IMG_OR_CHILD_WITH_TITLE_ATTRIBUTE, 
                IMG_ELEMENT, 
                1, 
                new ImmutablePair(TITLE_ATTR, "mock image"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-01---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.2.3-3NMI-01");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.NEED_MORE_INFO, 
                SUSPECTED_WELL_FORMATED_DECORATIVE_IMG, 
                OBJECT_ELEMENT, 
                1);

        //----------------------------------------------------------------------
        //------------------------------3NMI-02---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.2.3-3NMI-02");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.NEED_MORE_INFO, 
                SUSPECTED_WELL_FORMATED_DECORATIVE_IMG, 
                OBJECT_ELEMENT, 
                1);

        //----------------------------------------------------------------------
        //------------------------------3NMI-03---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.2.3-3NMI-03");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.NEED_MORE_INFO, 
                SUSPECTED_WELL_FORMATED_DECORATIVE_IMG, 
                OBJECT_ELEMENT, 
                1);

        //----------------------------------------------------------------------
        //------------------------------3NMI-04---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.2.3-3NMI-04");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.NEED_MORE_INFO, 
                SUSPECTED_WELL_FORMATED_DECORATIVE_IMG, 
                OBJECT_ELEMENT, 
                1);

        //----------------------------------------------------------------------
        //------------------------------3NMI-05---------------------------------
        //----------------------------------------------------------------------
    	processResult = processPageTest("Rgaa32017.Test.1.2.3-3NMI-05");
        checkResultIsPreQualified(processResult, 2, 1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.NEED_MORE_INFO, 
                SUSPECTED_WELL_FORMATED_DECORATIVE_IMG, 
                OBJECT_ELEMENT, 
                1);

        //----------------------------------------------------------------------
        //------------------------------3NMI-06---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.2.3-3NMI-06");
        checkResultIsPreQualified(processResult, 2, 1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.NEED_MORE_INFO, 
                SUSPECTED_WELL_FORMATED_DECORATIVE_IMG, 
                OBJECT_ELEMENT, 
                1);

        //----------------------------------------------------------------------
        //------------------------------3NMI-07------------------------------
        //----------------------------------------------------------------------
    	processResult = processPageTest("Rgaa32017.Test.1.2.3-3NMI-07");
    	checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.NEED_MORE_INFO, 
                SUSPECTED_DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG, 
                OBJECT_ELEMENT, 
                1, 
                new ImmutablePair(DATA_ATTR, "mock_image.gif"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-08------------------------------
        //----------------------------------------------------------------------
    	processResult = processPageTest("Rgaa32017.Test.1.2.3-3NMI-08");
    	checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.NEED_MORE_INFO, 
                SUSPECTED_DECORATIVE_IMG_WITH_NOT_EMPTY_TEXT_ALT_MSG, 
                OBJECT_ELEMENT, 
                1, 
                new ImmutablePair(TEXT_ELEMENT2, "There is some text."),
                new ImmutablePair(DATA_ATTR, "mock_image.gif"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-09------------------------------
        //----------------------------------------------------------------------
    	processResult = processPageTest("Rgaa32017.Test.1.2.3-3NMI-09");
    	checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.NEED_MORE_INFO, 
                SUSPECTED_DECORATIVE_IMG_WITH_ARIA_ATTRIBUTE_DETECTED_ON_ELEMENT_OR_CHILD, 
                OBJECT_ELEMENT, 
                1, 
                new ImmutablePair(ARIA_LABEL_ATTR, "mock image"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-10------------------------------
        //----------------------------------------------------------------------
    	processResult = processPageTest("Rgaa32017.Test.1.2.3-3NMI-10");
    	checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.NEED_MORE_INFO, 
                SUSPECTED_DECORATIVE_IMG_WITH_ARIA_ATTRIBUTE_DETECTED_ON_ELEMENT_OR_CHILD, 
                OBJECT_ELEMENT, 
                1, 
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, "mock image"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-11------------------------------
        //----------------------------------------------------------------------
    	processResult = processPageTest("Rgaa32017.Test.1.2.3-3NMI-11");
    	checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.NEED_MORE_INFO, 
                SUSPECTED_DECORATIVE_IMG_WITH_ARIA_ATTRIBUTE_DETECTED_ON_ELEMENT_OR_CHILD, 
                OBJECT_ELEMENT, 
                1, 
                new ImmutablePair(ARIA_DESCRIBEDBY_ATTR, "mock image"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-12------------------------------
        //----------------------------------------------------------------------
    	processResult = processPageTest("Rgaa32017.Test.1.2.3-3NMI-12");
    	checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.NEED_MORE_INFO, 
                SUSPECTED_DECORATIVE_IMG_WITH_TITLE_ATTRIBUTE_ON_ELEMENT_OR_CHILD, 
                OBJECT_ELEMENT, 
                1, 
                new ImmutablePair(TITLE_ATTR, "mock image"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-13------------------------------
        //----------------------------------------------------------------------
    	processResult = processPageTest("Rgaa32017.Test.1.2.3-3NMI-13");
    	checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.NEED_MORE_INFO, 
                SUSPECTED_DECORATIVE_IMG_WITH_TITLE_ATTRIBUTE_ON_ELEMENT_OR_CHILD, 
                IMG_ELEMENT, 
                1, 
                new ImmutablePair(TITLE_ATTR, "mock image"));
        
        //----------------------------------------------------------------------
        //------------------------------4NA-01----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.1.2.3-4NA-01"));
        
        
        //----------------------------------------------------------------------
        //------------------------------4NA-02----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.1.2.3-4NA-02"));
        
        
        //----------------------------------------------------------------------
        //------------------------------4NA-03----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.1.2.3-4NA-03"));
        
        
        //----------------------------------------------------------------------
        //------------------------------4NA-04----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.1.2.3-4NA-04"));
        
        
        //----------------------------------------------------------------------
        //------------------------------4NA-05----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.1.2.3-4NA-05"));
    }

}