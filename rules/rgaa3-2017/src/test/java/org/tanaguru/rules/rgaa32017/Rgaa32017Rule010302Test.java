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
import org.tanaguru.rules.keystore.HtmlElementStore;
import org.tanaguru.rules.rgaa32017.test.Rgaa32017RuleImplementationTestCase;
import org.tanaguru.rules.keystore.RemarkMessageStore;
import static org.tanaguru.rules.keystore.MarkerStore.DECORATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.INFORMATIVE_IMAGE_MARKER;
import static org.tanaguru.entity.audit.TestSolution.NEED_MORE_INFO;
import static org.tanaguru.rules.keystore.AttributeStore.ABSENT_ATTRIBUTE_VALUE;
import static org.tanaguru.rules.keystore.AttributeStore.ALT_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.HREF_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABEL_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABELLEDBY_ATTR;
import static org.tanaguru.rules.keystore.HtmlElementStore.AREA_ELEMENT;
import static org.tanaguru.rules.keystore.RemarkMessageStore.AREA_TEXT_NOT_IDENTICAL_TO_ALT_WITH_ARIA_LABELLEDBY_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.ARIA_LABELLEDBY_NOT_IDENTICAL_TO_ALT_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.ARIA_LABEL_NOT_IDENTICAL_TO_ALT_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_ALT_PERTINENCE_OF_INFORMATIVE_IMG_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.INFORMATIVE_AREA_TEXT_NOT_IDENTICAL_TO_ALT_WITH_ARIA_LABELLEDBY_MSG;

/**
 * Unit test class for the implementation of the rule 1-3-2 of the referential Rgaa 3-2017.
 *
 * @author jkowalczyk
 */
public class Rgaa32017Rule010302Test extends Rgaa32017RuleImplementationTestCase {

    /**
     * Default constructor
     * @param testName
     */
    public Rgaa32017Rule010302Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName("org.tanaguru.rules.rgaa32017.Rgaa32017Rule010302");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("Rgaa32017.Test.01.03.02-2Failed-01",
                    createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "class-informative-area"));
        addWebResource("Rgaa32017.Test.01.03.02-2Failed-02",
                    createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "class-informative-area"));
        addWebResource("Rgaa32017.Test.01.03.02-2Failed-03",
                    createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "class-informative-area"));
        addWebResource("Rgaa32017.Test.01.03.02-2Failed-04",
                    createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "class-informative-area"));
        addWebResource("Rgaa32017.Test.01.03.02-2Failed-05",
                    createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "class-informative-area"),
                    createParameter("Rules", DECORATIVE_IMAGE_MARKER, "class-decorative-area"));
        addWebResource("Rgaa32017.Test.01.03.02-2Failed-06",
                    createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "class-informative-area"));
        addWebResource("Rgaa32017.Test.01.03.02-2Failed-07",
                    createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "class-informative-area"));
        addWebResource("Rgaa32017.Test.01.03.02-2Failed-08");
        addWebResource("Rgaa32017.Test.01.03.02-2Failed-09");
        addWebResource("Rgaa32017.Test.01.03.02-2Failed-10");
        addWebResource("Rgaa32017.Test.01.03.02-2Failed-11",
                	createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "class-informative-area"),
                	createParameter("Rules", DECORATIVE_IMAGE_MARKER, "class-decorative-area"));
        addWebResource("Rgaa32017.Test.01.03.02-2Failed-12");
        addWebResource("Rgaa32017.Test.01.03.02-2Failed-13",
                	createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "class-informative-area"));
        addWebResource("Rgaa32017.Test.01.03.02-2Failed-14",
        			createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "class-informative-area"));
        addWebResource("Rgaa32017.Test.01.03.02-3NMI-01",
        			createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "class-informative-area"));
        addWebResource("Rgaa32017.Test.01.03.02-3NMI-02",
                	createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "class-informative-area"));
        addWebResource("Rgaa32017.Test.01.03.02-3NMI-03",
                	createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "class-informative-area"));
        addWebResource("Rgaa32017.Test.01.03.02-3NMI-04",
                    createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "class-informative-area"));
        addWebResource("Rgaa32017.Test.01.03.02-3NMI-05");
        addWebResource("Rgaa32017.Test.01.03.02-3NMI-06");
        addWebResource("Rgaa32017.Test.01.03.02-3NMI-07");
        addWebResource("Rgaa32017.Test.01.03.02-3NMI-08");
        addWebResource("Rgaa32017.Test.01.03.02-4NA-01");
        addWebResource("Rgaa32017.Test.01.03.02-4NA-02");
        addWebResource("Rgaa32017.Test.01.03.02-4NA-03");
        addWebResource("Rgaa32017.Test.01.03.02-4NA-04");
        
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------2Failed-01------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("Rgaa32017.Test.01.03.02-2Failed-01");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.NOT_PERTINENT_ALT_MSG,
                HtmlElementStore.AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, "mock-area.html"),
                new ImmutablePair(HREF_ATTR, "mock-area.html"));        
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-02------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.02-2Failed-02");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.NOT_PERTINENT_ALT_MSG,
                HtmlElementStore.AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, "mock-image.jpeg"),
                new ImmutablePair(HREF_ATTR, "mock-area.html"));        
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-03------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.02-2Failed-03");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.NOT_PERTINENT_ALT_MSG,
                HtmlElementStore.AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, "--><--"),
                new ImmutablePair(HREF_ATTR, "mock-area.html"));        
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-04------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.02-2Failed-04");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.NOT_PERTINENT_ALT_MSG,
                HtmlElementStore.AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, ""),
                new ImmutablePair(HREF_ATTR, "mock-area.html"));        
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-05------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.02-2Failed-05");
        checkResultIsFailed(processResult, 4, 4);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.NOT_PERTINENT_ALT_MSG,
                HtmlElementStore.AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, ""),
                new ImmutablePair(HREF_ATTR, "mock-area1.html"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_ALT_PERTINENCE_OF_INFORMATIVE_IMG_MSG,
                HtmlElementStore.AREA_ELEMENT,
                2,
                new ImmutablePair(ALT_ATTR, "Informative area alternative"),
                new ImmutablePair(HREF_ATTR, "mock-area2.html"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.NOT_PERTINENT_ALT_MSG,
                HtmlElementStore.AREA_ELEMENT,
                3,
                new ImmutablePair(ALT_ATTR, "mock-area3.html"),
                new ImmutablePair(HREF_ATTR, "mock-area3.html"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_NATURE_OF_IMAGE_AND_ALT_PERTINENCE_MSG,
                HtmlElementStore.AREA_ELEMENT,
                4,
                new ImmutablePair(ALT_ATTR, "not identified area alternative"),
                new ImmutablePair(HREF_ATTR, "mock-area4.html"));        

        //----------------------------------------------------------------------
        //------------------------------2Failed-06------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.02-2Failed-06");
        checkResultIsFailed(processResult, 1, 2);
        checkRemarkIsPresent(
                processResult,
                NEED_MORE_INFO,
                CHECK_ALT_PERTINENCE_OF_INFORMATIVE_IMG_MSG,
                AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, "Alternative"),
                new ImmutablePair(HREF_ATTR, "mock-area.html"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.TITLE_NOT_IDENTICAL_TO_ALT_MSG,
                HtmlElementStore.AREA_ELEMENT,
                2,
                new ImmutablePair(ALT_ATTR, "Alternative"),
                new ImmutablePair(TITLE_ATTR, "Title"),
                new ImmutablePair(HREF_ATTR, "mock-area.html"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-07------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.02-2Failed-07");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.NOT_PERTINENT_ALT_MSG,
                HtmlElementStore.AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, "+-*/"),
                new ImmutablePair(HREF_ATTR, "mock-area.html"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-08------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.02-2Failed-08");
        checkResultIsFailed(processResult, 1,  1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.NOT_PERTINENT_ALT_MSG,
                HtmlElementStore.AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, "mock-area.html"),
                new ImmutablePair(HREF_ATTR, "mock-area.html"));        

        //----------------------------------------------------------------------
        //------------------------------2Failed-09------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.02-2Failed-09");
        checkResultIsFailed(processResult, 1,  1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.NOT_PERTINENT_ALT_MSG,
                HtmlElementStore.AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, "mock-image.jpeg"),
                new ImmutablePair(HREF_ATTR, "mock-area.html"));        

        //----------------------------------------------------------------------
        //------------------------------2Failed-10------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.02-2Failed-10");
        checkResultIsFailed(processResult, 1,  1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.NOT_PERTINENT_ALT_MSG,
                HtmlElementStore.AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, "#!/;'(|"),
                new ImmutablePair(HREF_ATTR, "mock-area.html"));  
        

        //----------------------------------------------------------------------
        //------------------------------2Failed-11---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.02-2Failed-11");
        checkResultIsFailed(processResult, 3,  3);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_ALT_PERTINENCE_OF_INFORMATIVE_IMG_MSG,
                HtmlElementStore.AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, "Informative area alternative"),
                new ImmutablePair(HREF_ATTR, "mock-area2.html"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.NOT_PERTINENT_ALT_MSG,
                HtmlElementStore.AREA_ELEMENT,
                2,
                new ImmutablePair(ALT_ATTR, "mock-area3.html"),
                new ImmutablePair(HREF_ATTR, "mock-area3.html"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_NATURE_OF_IMAGE_AND_ALT_PERTINENCE_MSG,
                HtmlElementStore.AREA_ELEMENT,
                3,
                new ImmutablePair(ALT_ATTR, "not identified area alternative"),
                new ImmutablePair(HREF_ATTR, "mock-area4.html"));                
        
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-12---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.02-2Failed-12");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.NOT_PERTINENT_ALT_MSG,
                HtmlElementStore.AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, "mock-area.html"),
                new ImmutablePair(HREF_ATTR, "mock-area.html"));                 
        
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-13---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.02-2Failed-13");
        checkResultIsFailed(processResult, 1, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_ALT_PERTINENCE_OF_INFORMATIVE_IMG_MSG,
                HtmlElementStore.AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, "Alternative"),
                new ImmutablePair(HREF_ATTR, "mock-area.html"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.ARIA_LABEL_NOT_IDENTICAL_TO_ALT_MSG,
                HtmlElementStore.AREA_ELEMENT,
                2,
                new ImmutablePair(ALT_ATTR, "Alternative"),
                new ImmutablePair(ARIA_LABEL_ATTR, "aria-label"),
                new ImmutablePair(HREF_ATTR, "mock-area.html"));                 
        
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-14---------------------------------
        //----------------------------------------------------------------------
    	processResult = processPageTest("Rgaa32017.Test.01.03.02-2Failed-14");
        checkResultIsFailed(processResult, 1, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_ALT_PERTINENCE_OF_INFORMATIVE_IMG_MSG,
                HtmlElementStore.AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, "Alternative"),
                new ImmutablePair(HREF_ATTR, "mock-area.html"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.INFORMATIVE_AREA_TEXT_NOT_IDENTICAL_TO_ALT_WITH_ARIA_LABELLEDBY_MSG,
                HtmlElementStore.AREA_ELEMENT,
                2,
                new ImmutablePair(ALT_ATTR, "Alternative"),
                new ImmutablePair(ARIA_LABELLEDBY_ATTR, "Failed 14")); 
        
        

        //----------------------------------------------------------------------
        //------------------------------3NMI-01------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.02-3NMI-01");
        checkResultIsPreQualified(processResult, 1,  1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_ALT_PERTINENCE_OF_INFORMATIVE_IMG_MSG,
                HtmlElementStore.AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, "informative-area-alternative"),
                new ImmutablePair(HREF_ATTR, "mock-area.html"));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-02------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.02-3NMI-02");
        checkResultIsPreQualified(processResult, 1,  1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_ALT_PERTINENCE_OF_INFORMATIVE_IMG_MSG,
                HtmlElementStore.AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, "informative-area-alternative"),
                new ImmutablePair(HREF_ATTR, "mock-area.html"));        

        //----------------------------------------------------------------------
        //------------------------------3NMI-03------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.02-3NMI-03");
        checkResultIsPreQualified(processResult, 1,  1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_ALT_PERTINENCE_OF_INFORMATIVE_IMG_MSG,
                HtmlElementStore.AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, "informative-area-alternative"),
                new ImmutablePair(HREF_ATTR, "mock-area.html"));        

        //----------------------------------------------------------------------
        //------------------------------3NMI-04------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.02-3NMI-04");
        checkResultIsPreQualified(processResult, 1,  1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_ALT_PERTINENCE_OF_INFORMATIVE_IMG_MSG,
                HtmlElementStore.AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, "HOLA"),
                new ImmutablePair(HREF_ATTR, "mock-area.html"));    

        //----------------------------------------------------------------------
        //------------------------------3NMI-05---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.02-3NMI-05");
        checkResultIsPreQualified(processResult, 1,  1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_NATURE_OF_IMAGE_AND_ALT_PERTINENCE_MSG,
                HtmlElementStore.AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, "Not identified area alternative"),
                new ImmutablePair(HREF_ATTR, "mock-area.html")); 
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-06------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.02-3NMI-06");
        checkResultIsPreQualified(processResult, 1,  1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_NATURE_OF_IMAGE_AND_ALT_PERTINENCE_MSG,
                HtmlElementStore.AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, "informative-area-alternative"),
                new ImmutablePair(HREF_ATTR, "mock-area.html"));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-07------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.02-3NMI-07");
        checkResultIsPreQualified(processResult, 1,  1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_NATURE_OF_IMAGE_AND_ALT_PERTINENCE_MSG,
                HtmlElementStore.AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, "informative-area-alternative"),
                new ImmutablePair(HREF_ATTR, "mock-area.html"));        

        //----------------------------------------------------------------------
        //------------------------------3NMI-08------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.01.03.02-3NMI-08");
        checkResultIsPreQualified(processResult, 1,  1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_NATURE_OF_IMAGE_AND_ALT_PERTINENCE_MSG,
                HtmlElementStore.AREA_ELEMENT,
                1,
                new ImmutablePair(ALT_ATTR, "Alternative"),
                new ImmutablePair(HREF_ATTR, "mock-area.html")); 
        
        
        //----------------------------------------------------------------------
        //------------------------------4NA-01----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.01.03.02-4NA-01"));        
        
        //----------------------------------------------------------------------
        //------------------------------4NA-02----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.01.03.02-4NA-02"));        
        
        //----------------------------------------------------------------------
        //------------------------------4NA-03----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.01.03.02-4NA-03"));        
        
        //----------------------------------------------------------------------
        //------------------------------4NA-03----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.01.03.02-4NA-03"));        
        
        //----------------------------------------------------------------------
        //------------------------------4NA-04----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.01.03.02-4NA-04"));
    }

}
