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
import static org.tanaguru.rules.keystore.AttributeStore.ALT_ATTR;
import static org.tanaguru.rules.keystore.HtmlElementStore.IMG_ELEMENT;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_AT_RESTITUTION_OF_ALTERNATIVE_OF_INFORMATIVE_IMAGE_MSG;
import org.tanaguru.rules.rgaa32017.test.Rgaa32017RuleImplementationTestCase;

/**
 * Unit test class for the implementation of the rule 1-3-13 of the referential Rgaa 3-2017.
 *
 * @author
 */
public class Rgaa32017Rule010313Test extends Rgaa32017RuleImplementationTestCase {

    /**
     * Default constructor
     * @param testName
     */
    public Rgaa32017Rule010313Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.tanaguru.rules.rgaa32017.Rgaa32017Rule010313");
    }

    @Override
    protected void setUpWebResourceMap() {
        
//        addWebResource("Rgaa32017.Test.1.3.13-3NMI-01");
//        addWebResource("Rgaa32017.Test.1.3.13-3NMI-02");
//        addWebResource("Rgaa32017.Test.1.3.13-3NMI-03");
//        addWebResource("Rgaa32017.Test.1.3.13-3NMI-04");
        addWebResource("Rgaa32017.Test.1.3.13-4NA-01");
    }

    @Override
    protected void setProcess() {



        //----------------------------------------------------------------------
        //------------------------------3NMI-01---------------------------------
        //----------------------------------------------------------------------
//        ProcessResult processResult = processPageTest("Rgaa32017.Test.1.3.13-3NMI-01");
////        checkResultIsNotTested(processResult); // temporary result to make the result buildable before implementation
//        checkResultIsPreQualified(processResult, 1, 1);
//        checkRemarkIsPresent(
//                processResult,
//                TestSolution.NEED_MORE_INFO,
//                CHECK_AT_RESTITUTION_OF_ALTERNATIVE_OF_INFORMATIVE_IMAGE_MSG,
//                IMG_ELEMENT,
//                1,
//                new ImmutablePair(ALT_ATTR, ""));

        



        //----------------------------------------------------------------------
        //--------------------------------3NMI-02-------------------------------
        //----------------------------------------------------------------------
        
        
//        ProcessResult processResult = processPageTest("Rgaa32017.Test.1.3.13-3NMI-02");
//        checkResultIsPreQualified(processResult, 1, 1);
//        checkRemarkIsPresent(
//                processResult,
//                TestSolution.NEED_MORE_INFO,
//                CHECK_AT_RESTITUTION_OF_ALTERNATIVE_OF_INFORMATIVE_IMAGE_MSG,
//                IMG_ELEMENT,
//                1,
//                new ImmutablePair(ALT_ATTR, "image mock to test"));
        





        //----------------------------------------------------------------------
        //--------------------------------3NMI-03-------------------------------
        //----------------------------------------------------------------------
        
        
//        ProcessResult processResult = processPageTest("Rgaa32017.Test.1.3.13-3NMI-03");
//        checkResultIsPreQualified(processResult, 1, 1);
//        checkRemarkIsPresent(
//                processResult,
//                TestSolution.NEED_MORE_INFO,
//                CHECK_AT_RESTITUTION_OF_ALTERNATIVE_OF_INFORMATIVE_IMAGE_MSG,
//                IMG_ELEMENT,
//                1,
//                new ImmutablePair(ALT_ATTR, "1234567812345678123456781234567812345678123456781234567812345678"));
        





        //----------------------------------------------------------------------
        //--------------------------------3NMI-04-------------------------------
        //----------------------------------------------------------------------
        
        
//        ProcessResult processResult = processPageTest("Rgaa32017.Test.1.3.13-3NMI-04");
//        checkResultIsPreQualified(processResult, 1, 1);
//        checkRemarkIsPresent(
//                processResult,
//                TestSolution.NEED_MORE_INFO,
//                CHECK_AT_RESTITUTION_OF_ALTERNATIVE_OF_INFORMATIVE_IMAGE_MSG,
//                IMG_ELEMENT,
//                1,
//                new ImmutablePair(ALT_ATTR, "123456781234567812345678123456781234567812345678123456781234567812345678"));



        //----------------------------------------------------------------------
        //------------------------------4NA-01------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.1.3.13-4NA-01"));
    }

//    @Override
//    protected void setConsolidate() {
//
//        // The consolidate method can be removed when real implementation is done.
//        // The assertions are automatically tested regarding the file names by 
//        // the abstract parent class
//        assertEquals(TestSolution.NOT_TESTED,
//                consolidate("Rgaa32017.Test.1.3.13-3NMI-01").getValue());
//    }

}
