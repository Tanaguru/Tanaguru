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
package org.tanaguru.ruleimplementation.impl.image;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.ruleimplementation.CommonRuleImplementationTestCase;

import static org.tanaguru.rules.keystore.AttributeStore.*;
import static org.tanaguru.rules.keystore.HtmlElementStore.CANVAS_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.MarkerStore.DECORATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.INFORMATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.RemarkMessageStore.*;

/**
 * Unit test class for the implementation of the rule 1-1-8 of the referential Rgaa 4-2019.
 *
 * @author edaconceicao
 */
public class InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanismTest extends CommonRuleImplementationTestCase {

    /**
     * Default constructor
     */
    public InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanismTest(String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.tanaguru.ruleimplementation.impl.image.InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-1Passed-01",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "id-informative-image"));
        addWebResource("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-1Passed-02",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "id-informative-image"));
        addWebResource("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-1Passed-03",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "id-informative-image"));
        addWebResource("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-3NMI-01",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "id-informative-image"));
        addWebResource("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-3NMI-02",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "id-informative-image"));
        addWebResource("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-3NMI-03");
        addWebResource("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-3NMI-04");
        addWebResource("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-3NMI-05");
        addWebResource("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-3NMI-06");
        addWebResource("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-3NMI-07");
        addWebResource("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-3NMI-08");
        addWebResource("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-3NMI-09",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "id-informative-image"));
        addWebResource("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-4NA-01",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
        addWebResource("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-4NA-02",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
        addWebResource("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-4NA-03",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
        addWebResource("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-4NA-04");
    }

    @Override
    protected void setProcess() {
    	//----------------------------------------------------------------------
        //------------------------------1Passed-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-1Passed-01"), 1);
        
    	//----------------------------------------------------------------------
        //------------------------------1Passed-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-1Passed-02"), 1);
        
    	//----------------------------------------------------------------------
        //------------------------------1Passed-03------------------------------
        //----------------------------------------------------------------------
        checkResultIsPassed(processPageTest("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-1Passed-03"), 1);
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-01---------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-3NMI-01");
        checkResultIsPreQualified(processResult, 1, 3);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                INVALID_TEXT_ALTERNATIVE_MSG,
                CANVAS_ELEMENT,
                1,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
                new ImmutablePair(ALT_ATTR, "text alternative"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                TEXT_ALTERNATIVE_MISSING,
                CANVAS_ELEMENT,
                2,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_PRESENCE_OF_ALTERNATIVE_MECHANISM_FOR_INFORMATIVE_IMG_MSG,
                CANVAS_ELEMENT,
                3,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
                new ImmutablePair(TEXT_ELEMENT2, ""));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-02---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-3NMI-02");
        checkResultIsPreQualified(processResult, 1, 3);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                TEXT_ALTERNATIVE_MISSING,
                CANVAS_ELEMENT,
                1,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                TEXT_ALTERNATIVE_MISSING,
                CANVAS_ELEMENT,
                2,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_PRESENCE_OF_ALTERNATIVE_MECHANISM_FOR_INFORMATIVE_IMG_MSG,
                CANVAS_ELEMENT,
                3,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
                new ImmutablePair(TEXT_ELEMENT2, ""));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-03---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-3NMI-03");
        checkResultIsPreQualified(processResult, 1, 3);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE,
                CANVAS_ELEMENT,
                1,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
                new ImmutablePair(ARIA_LABEL_ATTR, "text alternative"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE_WITHOUT_TEXT_ALTERNATIVE,
                CANVAS_ELEMENT,
                2,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_AND_PRESENCE_OF_ALTERNATIVE_MECHANISM_MSG,
                CANVAS_ELEMENT,
                3,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
                new ImmutablePair(TEXT_ELEMENT2, ""));

        //----------------------------------------------------------------------
        //------------------------------3NMI-04---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-3NMI-04");
        checkResultIsPreQualified(processResult, 1, 3);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE,
                CANVAS_ELEMENT,
                1,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, "NMI-08"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE_WITHOUT_TEXT_ALTERNATIVE,
                CANVAS_ELEMENT,
                2,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_AND_PRESENCE_OF_ALTERNATIVE_MECHANISM_MSG,
                CANVAS_ELEMENT,
                3,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
                new ImmutablePair(TEXT_ELEMENT2, ""));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-05---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-3NMI-05");
        checkResultIsPreQualified(processResult, 1, 3);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                INVALID_TEXT_ALTERNATIVE_MSG,
                CANVAS_ELEMENT,
                1,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
                new ImmutablePair(TITLE_ATTR, "text alternative"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE_WITHOUT_TEXT_ALTERNATIVE,
                CANVAS_ELEMENT,
                2,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_AND_PRESENCE_OF_ALTERNATIVE_MECHANISM_MSG,
                CANVAS_ELEMENT,
                3,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
                new ImmutablePair(TEXT_ELEMENT2, ""));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-06---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-3NMI-06");
        checkResultIsPreQualified(processResult, 1, 3);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE_WITHOUT_TEXT_ALTERNATIVE,
                CANVAS_ELEMENT,
                1,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE,
                CANVAS_ELEMENT,
                2,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_AND_PRESENCE_OF_ALTERNATIVE_MECHANISM_MSG,
                CANVAS_ELEMENT,
                3,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
                new ImmutablePair(TEXT_ELEMENT2, ""));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-07---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-3NMI-07");
        checkResultIsPreQualified(processResult, 1, 3);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                INVALID_TEXT_ALTERNATIVE_MSG,
                CANVAS_ELEMENT,
                1,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
                new ImmutablePair(ALT_ATTR, "text alternative"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE_WITHOUT_TEXT_ALTERNATIVE,
                CANVAS_ELEMENT,
                2,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_AND_PRESENCE_OF_ALTERNATIVE_MECHANISM_MSG,
                CANVAS_ELEMENT,
                3,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
                new ImmutablePair(TEXT_ELEMENT2, ""));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-08---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-3NMI-08");
        checkResultIsPreQualified(processResult, 1, 3);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE_WITHOUT_TEXT_ALTERNATIVE,
                CANVAS_ELEMENT,
                1,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE_WITHOUT_TEXT_ALTERNATIVE,
                CANVAS_ELEMENT,
                2,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_AND_PRESENCE_OF_ALTERNATIVE_MECHANISM_MSG,
                CANVAS_ELEMENT,
                3,
                new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
                new ImmutablePair(TEXT_ELEMENT2, ""));

	      //----------------------------------------------------------------------
	      //------------------------------3NMI-09---------------------------------
	      //----------------------------------------------------------------------
	      processResult = processPageTest("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-3NMI-09");
	      checkResultIsPreQualified(processResult, 1, 3);
	      checkRemarkIsPresent(
	              processResult,
	              TestSolution.FAILED,
	              INVALID_TEXT_ALTERNATIVE_MSG,
	              CANVAS_ELEMENT,
	              1,
	              new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
	              new ImmutablePair(TITLE_ATTR, "text alternative"));
	      checkRemarkIsPresent(
	              processResult,
	              TestSolution.FAILED,
	              TEXT_ALTERNATIVE_MISSING,
	              CANVAS_ELEMENT,
	              2,
	              new ImmutablePair(DATA_ATTR, "TheEarth.gif"));
	      checkRemarkIsPresent(
	              processResult,
	              TestSolution.NEED_MORE_INFO,
	              CHECK_PRESENCE_OF_ALTERNATIVE_MECHANISM_FOR_INFORMATIVE_IMG_MSG,
	              CANVAS_ELEMENT,
	              3,
	              new ImmutablePair(DATA_ATTR, "TheEarth.gif"),
	              new ImmutablePair(TEXT_ELEMENT2, ""));


        //----------------------------------------------------------------------
        //------------------------------4NA-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-4NA-01"));

        //----------------------------------------------------------------------
        //------------------------------4NA-02------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-4NA-02"));

        //----------------------------------------------------------------------
        //------------------------------4NA-03------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-4NA-03"));

        //----------------------------------------------------------------------
        //------------------------------4NA-04------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism-4NA-04"));
    }
}
