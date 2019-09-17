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
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.rules.rgaa42019.test.Rgaa42019RuleImplementationTestCase;

import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABEL_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;
import static org.tanaguru.rules.keystore.HtmlElementStore.CAPTION_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.DIV_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.P_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.TABLE_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.RemarkMessageStore.TABLE_TITLE_RELEVANT_CONTENT;
import static org.tanaguru.rules.keystore.RemarkMessageStore.TABLE_TITLE_NOT_RELEVANT_CONTENT;

/**
 * Unit test class for the implementation of the rule 5-5-1 of the referential Rgaa 4-2019.
 *
 * @author edaconceicao
 */
public class Rgaa42019Rule050501Test extends Rgaa42019RuleImplementationTestCase {

    /**
     * Default constructor
     */
    public Rgaa42019Rule050501Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.tanaguru.rules.rgaa42019.Rgaa42019Rule050501");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("Rgaa42019.Test.05.05.01-2Failed-01");
        addWebResource("Rgaa42019.Test.05.05.01-2Failed-02");
        addWebResource("Rgaa42019.Test.05.05.01-2Failed-03");
        addWebResource("Rgaa42019.Test.05.05.01-2Failed-04");
        addWebResource("Rgaa42019.Test.05.05.01-2Failed-05");
        addWebResource("Rgaa42019.Test.05.05.01-2Failed-06");
        addWebResource("Rgaa42019.Test.05.05.01-2Failed-07");
        addWebResource("Rgaa42019.Test.05.05.01-3NMI-01");
        addWebResource("Rgaa42019.Test.05.05.01-3NMI-02");
        addWebResource("Rgaa42019.Test.05.05.01-3NMI-03");
        addWebResource("Rgaa42019.Test.05.05.01-3NMI-04");
        addWebResource("Rgaa42019.Test.05.05.01-3NMI-05");
        addWebResource("Rgaa42019.Test.05.05.01-3NMI-06");
        addWebResource("Rgaa42019.Test.05.05.01-3NMI-07");
        addWebResource("Rgaa42019.Test.05.05.01-4NA-01");
        addWebResource("Rgaa42019.Test.05.05.01-4NA-02");
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------2Failed-01------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("Rgaa42019.Test.05.05.01-2Failed-01");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                TABLE_TITLE_NOT_RELEVANT_CONTENT,
                CAPTION_ELEMENT,
                1,
                new ImmutablePair(TEXT_ELEMENT2, ""));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-02------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.05.01-2Failed-02");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                TABLE_TITLE_NOT_RELEVANT_CONTENT,
                P_ELEMENT,
                1,
                new ImmutablePair(TEXT_ELEMENT2, ""));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-03------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.05.01-2Failed-03");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                TABLE_TITLE_NOT_RELEVANT_CONTENT,
                TABLE_ELEMENT,
                1,
                new ImmutablePair(ARIA_LABEL_ATTR, ""));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-04------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.05.01-2Failed-04");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                TABLE_TITLE_NOT_RELEVANT_CONTENT,
                TABLE_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR, ""));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-05------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.05.01-2Failed-05");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                TABLE_TITLE_NOT_RELEVANT_CONTENT,
                P_ELEMENT,
                1,
                new ImmutablePair(TEXT_ELEMENT2, ""));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-06------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.05.01-2Failed-06");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                TABLE_TITLE_NOT_RELEVANT_CONTENT,
                DIV_ELEMENT,
                1,
                new ImmutablePair(ARIA_LABEL_ATTR, ""));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-07------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.05.01-2Failed-07");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                TABLE_TITLE_NOT_RELEVANT_CONTENT,
                DIV_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR, ""));

        //----------------------------------------------------------------------
        //------------------------------3NMI-01---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.05.01-3NMI-01");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                TABLE_TITLE_RELEVANT_CONTENT,
                CAPTION_ELEMENT,
                1,
                new ImmutablePair(TEXT_ELEMENT2, "Title table element"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-02---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.05.01-3NMI-02");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                TABLE_TITLE_RELEVANT_CONTENT,
                P_ELEMENT,
                1,
                new ImmutablePair(TEXT_ELEMENT2, "Title table element"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-03---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.05.01-3NMI-03");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                TABLE_TITLE_RELEVANT_CONTENT,
                TABLE_ELEMENT,
                1,
                new ImmutablePair(ARIA_LABEL_ATTR, "Title table element"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-04---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.05.01-3NMI-04");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                TABLE_TITLE_RELEVANT_CONTENT,
                TABLE_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR, "Title table element"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-05---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.05.01-3NMI-05");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                TABLE_TITLE_RELEVANT_CONTENT,
                P_ELEMENT,
                1,
                new ImmutablePair(TEXT_ELEMENT2, "Title table element"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-06---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.05.01-3NMI-06");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                TABLE_TITLE_RELEVANT_CONTENT,
                DIV_ELEMENT,
                1,
                new ImmutablePair(ARIA_LABEL_ATTR, "Title table element"));

        //----------------------------------------------------------------------
        //------------------------------3NMI-07--------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.05.05.01-3NMI-07");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                TABLE_TITLE_RELEVANT_CONTENT,
                DIV_ELEMENT,
                1,
                new ImmutablePair(TITLE_ATTR, "Title table element"));


        //----------------------------------------------------------------------
        //------------------------------4NA-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.05.05.01-4NA-01"));

        //----------------------------------------------------------------------
        //------------------------------4NA-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.05.05.01-4NA-02"));
    }
}
