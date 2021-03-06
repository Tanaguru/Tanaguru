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
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.rules.keystore.AttributeStore;
import org.tanaguru.rules.keystore.HtmlElementStore;
import static org.tanaguru.rules.keystore.MarkerStore.DECORATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.INFORMATIVE_IMAGE_MARKER;
import org.tanaguru.rules.keystore.RemarkMessageStore;
import org.tanaguru.rules.rgaa32017.test.Rgaa32017RuleImplementationTestCase;

/**
 * Unit test class for the implementation of the rule 1-6-7 of the referential Rgaa 3-2017.
 *
 * @author
 */
public class Rgaa32017Rule010607Test extends Rgaa32017RuleImplementationTestCase {

    /**
     * Default constructor
     * @param testName
     */
    public Rgaa32017Rule010607Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.tanaguru.rules.rgaa32017.Rgaa32017Rule010607");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("Rgaa32017.Test.1.6.7-3NMI-01",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "informative-image"));
        addWebResource("Rgaa32017.Test.1.6.7-3NMI-02");
        addWebResource("Rgaa32017.Test.1.6.7-3NMI-03",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "informative-image"));
        addWebResource("Rgaa32017.Test.1.6.7-3NMI-04");
        addWebResource("Rgaa32017.Test.1.6.7-3NMI-05",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "informative-image"));
        addWebResource("Rgaa32017.Test.1.6.7-3NMI-06");
        addWebResource("Rgaa32017.Test.1.6.7-4NA-01");
        addWebResource("Rgaa32017.Test.1.6.7-4NA-02");
        addWebResource("Rgaa32017.Test.1.6.7-4NA-03");
        addWebResource("Rgaa32017.Test.1.6.7-4NA-04",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "decorative-image"));
        addWebResource("Rgaa32017.Test.1.6.7-4NA-05");
        addWebResource("Rgaa32017.Test.1.6.7-4NA-06");

    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //-------------------------------3NMI-01--------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("Rgaa32017.Test.1.6.7-3NMI-01");
        checkResultIsPreQualified(processResult, 1,  1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_AT_RESTITUTION_OF_DESC_OF_INFORMATIVE_IMG_MSG,
                HtmlElementStore.SVG_ELEMENT,
                1,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2, "mock svg"),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR, AttributeStore.ABSENT_ATTRIBUTE_VALUE));
        
        //----------------------------------------------------------------------
        //-------------------------------3NMI-01--------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.6.7-3NMI-02");
        checkResultIsPreQualified(processResult, 1,  1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_NATURE_OF_IMAGE_AND_AT_RESTITUTION_OF_PERTINENCE_MSG,
                HtmlElementStore.SVG_ELEMENT,
                1,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2, "mock svg"),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR, AttributeStore.ABSENT_ATTRIBUTE_VALUE));
       
        //----------------------------------------------------------------------
        //-------------------------------3NMI-03--------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.6.7-3NMI-03");
        checkResultIsPreQualified(processResult, 1,  1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_AT_RESTITUTION_OF_DESC_OF_INFORMATIVE_IMG_MSG,
                HtmlElementStore.SVG_ELEMENT,
                1,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2, ""),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR, "mock svg"));
        
        //----------------------------------------------------------------------
        //-------------------------------3NMI-04--------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.6.7-3NMI-04");
        checkResultIsPreQualified(processResult, 1,  1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_NATURE_OF_IMAGE_AND_AT_RESTITUTION_OF_PERTINENCE_MSG,
                HtmlElementStore.SVG_ELEMENT,
                1,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2, ""),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR, "mock svg"));
       
        //----------------------------------------------------------------------
        //-------------------------------3NMI-05--------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.6.7-3NMI-05");
        checkResultIsPreQualified(processResult, 1,  1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_AT_RESTITUTION_OF_DESC_OF_INFORMATIVE_IMG_MSG,
                HtmlElementStore.SVG_ELEMENT,
                1,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2, "mock svg"),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR, "svg label"));
        
        //----------------------------------------------------------------------
        //-------------------------------3NMI-06--------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.6.7-3NMI-06");
        checkResultIsPreQualified(processResult, 1,  1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_NATURE_OF_IMAGE_AND_AT_RESTITUTION_OF_PERTINENCE_MSG,
                HtmlElementStore.SVG_ELEMENT,
                1,
                new ImmutablePair(HtmlElementStore.TEXT_ELEMENT2, "mock svg"),
                new ImmutablePair(AttributeStore.ARIA_LABEL_ATTR, "svg label"));
        
        //----------------------------------------------------------------------
        //------------------------------4NA-01----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.1.6.7-4NA-01"));        

        //----------------------------------------------------------------------
        //------------------------------4NA-02----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.1.6.7-4NA-02"));        

        //----------------------------------------------------------------------
        //------------------------------4NA-03----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.1.6.7-4NA-03"));

        //----------------------------------------------------------------------
        //------------------------------4NA-04----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.1.6.7-4NA-04"));

        //----------------------------------------------------------------------
        //------------------------------4NA-05----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.1.6.7-4NA-05"));

        //----------------------------------------------------------------------
        //------------------------------4NA-06----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.1.6.7-4NA-06"));
    }

}
