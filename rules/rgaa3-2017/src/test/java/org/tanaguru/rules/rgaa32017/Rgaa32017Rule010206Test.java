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
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_HIDDEN_ATTR;
import org.tanaguru.rules.keystore.HtmlElementStore;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.MarkerStore.DECORATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.INFORMATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_ELEMENT_WITH_EMPTY_ALT_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_ELEMENT_WITH_NOT_EMPTY_ALT_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITH_NOT_EMPTY_ALT_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.SUSPECTED_DECORATIVE_EMB_WITH_ARIA_ATTRIBUTE_DETECTED;
import static org.tanaguru.rules.keystore.RemarkMessageStore.SUSPECTED_INFORMATIVE_EMB_WITH_ARIA_ATTRIBUTE_NOT_DETECTED;
import org.tanaguru.rules.rgaa32017.test.Rgaa32017RuleImplementationTestCase;

/**
 * Unit test class for the implementation of the rule 1-2-6 of the referential Rgaa 3-2017.
 *
 * @author
 */
public class Rgaa32017Rule010206Test extends Rgaa32017RuleImplementationTestCase {

    /**
     * Default constructor
     * @param testName
     */
    public Rgaa32017Rule010206Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.tanaguru.rules.rgaa32017.Rgaa32017Rule010206");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("Rgaa32017.Test.1.2.6-1Passed-01",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
        addWebResource("Rgaa32017.Test.1.2.6-1Passed-02",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "class-decorative-image"));
        addWebResource("Rgaa32017.Test.1.2.6-1Passed-03",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "role-decorative-image"));
        addWebResource("Rgaa32017.Test.1.2.6-1Passed-04",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image;class-decorative-image;role-decorative-image"));
        addWebResource("Rgaa32017.Test.1.2.6-1Passed-05",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image;class-decorative-image"));
        addWebResource("Rgaa32017.Test.1.2.6-2Failed-01",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
        addWebResource("Rgaa32017.Test.1.2.6-2Failed-02",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "class-decorative-image"));
        addWebResource("Rgaa32017.Test.1.2.6-2Failed-03",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "role-decorative-image"));
        addWebResource("Rgaa32017.Test.1.2.6-2Failed-04",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image;class-decorative-image;role-decorative-image"));
        addWebResource("Rgaa32017.Test.1.2.6-3NMI-01");
        addWebResource("Rgaa32017.Test.1.2.6-3NMI-02");
        addWebResource("Rgaa32017.Test.1.2.6-4NA-01");
        addWebResource("Rgaa32017.Test.1.2.6-4NA-02",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "informative-image"));
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------1Passed-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.1.2.6-1Passed-01"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.1.2.6-1Passed-02"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-03------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.1.2.6-1Passed-03"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-04------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.1.2.6-1Passed-04"), 3);
        
        //----------------------------------------------------------------------
        //------------------------------1Passed-05------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa32017.Test.1.2.6-1Passed-05"), 2);

        //----------------------------------------------------------------------
        //------------------------------2Failed-01------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("Rgaa32017.Test.1.2.6-2Failed-01");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG,
                HtmlElementStore.EMBED_ELEMENT,
                1,
                new ImmutablePair(ARIA_HIDDEN_ATTR, AttributeStore.ABSENT_ATTRIBUTE_VALUE));

        //----------------------------------------------------------------------
        //------------------------------2Failed-02------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.2.6-2Failed-02");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG,
                HtmlElementStore.EMBED_ELEMENT,
                1,
               new ImmutablePair(ARIA_HIDDEN_ATTR, AttributeStore.ABSENT_ATTRIBUTE_VALUE));

        //----------------------------------------------------------------------
        //------------------------------2Failed-03------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.2.6-2Failed-03");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG,
                HtmlElementStore.EMBED_ELEMENT,
                1,
                 new ImmutablePair(ARIA_HIDDEN_ATTR, AttributeStore.ABSENT_ATTRIBUTE_VALUE));

        //----------------------------------------------------------------------
        //------------------------------2Failed-04------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.2.6-2Failed-04");
        checkResultIsFailed(processResult, 3, 3);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG,
                HtmlElementStore.EMBED_ELEMENT,
                1,
                new ImmutablePair(ARIA_HIDDEN_ATTR, AttributeStore.ABSENT_ATTRIBUTE_VALUE));

        //----------------------------------------------------------------------
        //------------------------------3NMI-01---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.2.6-3NMI-01");
        checkResultIsPreQualified(processResult, 2, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                SUSPECTED_INFORMATIVE_EMB_WITH_ARIA_ATTRIBUTE_NOT_DETECTED,
                HtmlElementStore.EMBED_ELEMENT,
                1,
               new ImmutablePair(ARIA_HIDDEN_ATTR, AttributeStore.ABSENT_ATTRIBUTE_VALUE));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                SUSPECTED_DECORATIVE_EMB_WITH_ARIA_ATTRIBUTE_DETECTED,
                HtmlElementStore.EMBED_ELEMENT,
                2,
                new ImmutablePair(ARIA_HIDDEN_ATTR, "true"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-02---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.1.2.6-3NMI-02");
        checkResultIsPreQualified(processResult, 2, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                SUSPECTED_INFORMATIVE_EMB_WITH_ARIA_ATTRIBUTE_NOT_DETECTED,
                HtmlElementStore.EMBED_ELEMENT,
                1,
                new ImmutablePair(ARIA_HIDDEN_ATTR, AttributeStore.ABSENT_ATTRIBUTE_VALUE));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                SUSPECTED_INFORMATIVE_EMB_WITH_ARIA_ATTRIBUTE_NOT_DETECTED,
                HtmlElementStore.EMBED_ELEMENT,
                2,
               new ImmutablePair(ARIA_HIDDEN_ATTR, "false"));


        //----------------------------------------------------------------------
        //------------------------------4NA-01----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.1.2.6-4NA-01"));

        //----------------------------------------------------------------------
        //------------------------------4NA-02----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.1.2.6-4NA-02"));
    }

}
