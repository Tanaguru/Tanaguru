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

import static org.tanaguru.rules.keystore.AttributeStore.ALT_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABELLEDBY_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABEL_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.DATA_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;
import static org.tanaguru.rules.keystore.HtmlElementStore.EMBED_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_NATURE_AND_PRESENCE_OF_ALTERNATIVE_MECHANISM_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_NATURE_OF_IMAGE;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_NATURE_OF_IMAGE_WITHOUT_TEXT_ALTERNATIVE;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_PRESENCE_OF_ALTERNATIVE_MECHANISM_FOR_INFORMATIVE_IMG_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.INVALID_TEXT_ALTERNATIVE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.TEXT_ALTERNATIVE_MISSING;
import static org.tanaguru.rules.keystore.MarkerStore.DECORATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.INFORMATIVE_IMAGE_MARKER;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.rules.rgaa42019.test.Rgaa42019RuleImplementationTestCase;

/**
 * Unit test class for the implementation of the rule 1-1-7 of the referential Rgaa 4-2019.
 *
 * @author edaconceicao
 */
public class Rgaa42019Rule010107Test extends Rgaa42019RuleImplementationTestCase {

    /**
     * Default constructor
     */
    public Rgaa42019Rule010107Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.tanaguru.rules.rgaa42019.Rgaa42019Rule010107");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("Rgaa42019.Test.01.01.07-1Passed-01",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "id-informative-image"));
        addWebResource("Rgaa42019.Test.01.01.07-1Passed-02",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "id-informative-image"));
        addWebResource("Rgaa42019.Test.01.01.07-1Passed-03",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "id-informative-image"));        
        addWebResource("Rgaa42019.Test.01.01.07-3NMI-01",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "id-informative-image"));
        addWebResource("Rgaa42019.Test.01.01.07-3NMI-02",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "id-informative-image"));
        addWebResource("Rgaa42019.Test.01.01.07-3NMI-03");
        addWebResource("Rgaa42019.Test.01.01.07-3NMI-04");
        addWebResource("Rgaa42019.Test.01.01.07-3NMI-05");
        addWebResource("Rgaa42019.Test.01.01.07-3NMI-06");
        addWebResource("Rgaa42019.Test.01.01.07-3NMI-07");
        addWebResource("Rgaa42019.Test.01.01.07-4NA-01",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
        addWebResource("Rgaa42019.Test.01.01.07-4NA-02",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
        addWebResource("Rgaa42019.Test.01.01.07-4NA-03",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
        addWebResource("Rgaa42019.Test.01.01.07-4NA-04");
    }

    @Override
    protected void setProcess() {    	
    	//----------------------------------------------------------------------
        //------------------------------1Passed-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.01.01.07-1Passed-01"), 1);
    	
    	//----------------------------------------------------------------------
        //------------------------------1Passed-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.01.01.07-1Passed-02"), 1);
    	
    	//----------------------------------------------------------------------
        //------------------------------1Passed-03------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("Rgaa42019.Test.01.01.07-1Passed-03"), 1);
//        //----------------------------------------------------------------------
//        //------------------------------3NMI-01---------------------------------
//        //----------------------------------------------------------------------
//    	ProcessResult processResult = processPageTest("Rgaa42019.Test.01.01.07-3NMI-01");
//        checkResultIsPreQualified(processResult, 1, 1);
//        checkRemarkIsPresent(
//                processResult,
//                TestSolution.NEED_MORE_INFO,
//                CHECK_PRESENCE_OF_ALTERNATIVE_MECHANISM_FOR_INFORMATIVE_IMG_MSG,
//                EMBED_ELEMENT,
//                1,
//                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
//                new ImmutablePair(TEXT_ELEMENT2, ""));
        
//        //----------------------------------------------------------------------
//        //------------------------------3NMI-02---------------------------------
//        //----------------------------------------------------------------------
//    	processResult = processPageTest("Rgaa42019.Test.01.01.07-3NMI-02");
//        checkResultIsPreQualified(processResult, 1, 1);
//        checkRemarkIsPresent(
//                processResult,
//                TestSolution.NEED_MORE_INFO,
//                CHECK_PRESENCE_OF_ALTERNATIVE_MECHANISM_FOR_INFORMATIVE_IMG_MSG,
//                EMBED_ELEMENT,
//                1,
//                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
//                new ImmutablePair(TEXT_ELEMENT2, ""));
        
//        //----------------------------------------------------------------------
//        //------------------------------3NMI-03---------------------------------
//        //----------------------------------------------------------------------
//        processResult = processPageTest("Rgaa42019.Test.01.01.07-3NMI-03");
//        checkResultIsPreQualified(processResult, 1, 1);
//        checkRemarkIsPresent(
//                processResult,
//                TestSolution.NEED_MORE_INFO,
//                CHECK_PRESENCE_OF_ALTERNATIVE_MECHANISM_FOR_INFORMATIVE_IMG_MSG,
//                EMBED_ELEMENT,
//                1,
//                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
//                new ImmutablePair(TEXT_ELEMENT2, ""));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-01---------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("Rgaa42019.Test.01.01.07-3NMI-01");
        checkResultIsPreQualified(processResult, 1, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                INVALID_TEXT_ALTERNATIVE_MSG,
                EMBED_ELEMENT,
                1,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
                new ImmutablePair(ALT_ATTR, "text alternative"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_PRESENCE_OF_ALTERNATIVE_MECHANISM_FOR_INFORMATIVE_IMG_MSG,
                EMBED_ELEMENT,
                2,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
                new ImmutablePair(TEXT_ELEMENT2, ""));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-02---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.01.07-3NMI-02");
        checkResultIsPreQualified(processResult, 1, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                TEXT_ALTERNATIVE_MISSING,
                EMBED_ELEMENT,
                1,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_PRESENCE_OF_ALTERNATIVE_MECHANISM_FOR_INFORMATIVE_IMG_MSG,
                EMBED_ELEMENT,
                2,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
                new ImmutablePair(TEXT_ELEMENT2, ""));
                
        //----------------------------------------------------------------------
        //------------------------------3NMI-03---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.01.07-3NMI-03");
        checkResultIsPreQualified(processResult, 1, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE,
                EMBED_ELEMENT,
                1,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
                new ImmutablePair(ARIA_LABEL_ATTR, ""));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_AND_PRESENCE_OF_ALTERNATIVE_MECHANISM_MSG,
                EMBED_ELEMENT,
                2,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
                new ImmutablePair(TEXT_ELEMENT2, ""));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-04---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.01.07-3NMI-04");
        checkResultIsPreQualified(processResult, 1, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE,
                EMBED_ELEMENT,
                1,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, "NMI-07"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_AND_PRESENCE_OF_ALTERNATIVE_MECHANISM_MSG,
                EMBED_ELEMENT,
                2,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
                new ImmutablePair(TEXT_ELEMENT2, ""));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-05---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.01.07-3NMI-05");
        checkResultIsPreQualified(processResult, 1, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE,
                EMBED_ELEMENT,
                1,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
                new ImmutablePair(TITLE_ATTR, ""));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_AND_PRESENCE_OF_ALTERNATIVE_MECHANISM_MSG,
                EMBED_ELEMENT,
                2,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
                new ImmutablePair(TEXT_ELEMENT2, ""));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-06---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.01.07-3NMI-06");
        checkResultIsPreQualified(processResult, 1, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                INVALID_TEXT_ALTERNATIVE_MSG,
                EMBED_ELEMENT,
                1,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
                new ImmutablePair(ALT_ATTR, "text alternative"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_AND_PRESENCE_OF_ALTERNATIVE_MECHANISM_MSG,
                EMBED_ELEMENT,
                2,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
                new ImmutablePair(TEXT_ELEMENT2, ""));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-07---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa42019.Test.01.01.07-3NMI-07");
        checkResultIsPreQualified(processResult, 1, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE_WITHOUT_TEXT_ALTERNATIVE,
                EMBED_ELEMENT,
                1,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_AND_PRESENCE_OF_ALTERNATIVE_MECHANISM_MSG,
                EMBED_ELEMENT,
                2,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
                new ImmutablePair(TEXT_ELEMENT2, ""));


        //----------------------------------------------------------------------
        //------------------------------4NA-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.01.01.07-4NA-01"));

        //----------------------------------------------------------------------
        //------------------------------4NA-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.01.01.07-4NA-02"));

        //----------------------------------------------------------------------
        //------------------------------4NA-03------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.01.01.07-4NA-03"));

        //----------------------------------------------------------------------
        //------------------------------4NA-04------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa42019.Test.01.01.07-4NA-04"));
    }
}
