///*
// * Tanaguru - Automated webpage assessment
// * Copyright (C) 2008-2017  Tanaguru.org
// *
// * This program is free software: you can redistribute it and/or modify
// * it under the terms of the GNU Affero General Public License as
// * published by the Free Software Foundation, either version 3 of the
// * License, or (at your option) any later version.
// *
// * This program is distributed in the hope that it will be useful,
// * but WITHOUT ANY WARRANTY; without even the implied warranty of
// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// * GNU Affero General Public License for more details.
// *
// * You should have received a copy of the GNU Affero General Public License
// * along with this program.  If not, see <http://www.gnu.org/licenses/>.
// *
// * Contact us by mail: tanaguru AT tanaguru DOT org
// */
//package org.tanaguru.rules.rgaa32017;
//
//import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_NATURE_OF_IMAGE_AND_ALT_PERTINENCE_MSG;
//
//import java.util.ArrayList;
//import java.util.List;
//import org.apache.commons.lang3.tuple.ImmutablePair;
//import org.tanaguru.entity.audit.ProcessResult;
//import org.tanaguru.entity.audit.TestSolution;
//import org.tanaguru.rules.rgaa32017.test.Rgaa32017RuleImplementationTestCase;
//import org.tanaguru.rules.keystore.AttributeStore;
//import org.tanaguru.rules.keystore.EvidenceStore;
//import org.tanaguru.rules.keystore.HtmlElementStore;
//import org.tanaguru.rules.keystore.RemarkMessageStore;
//
///**
// * Unit test class for the implementation of the rule 10-4-2 of the referential Rgaa 3-2017.
// *
// * @author jkowalczyk
// */
//public class Rgaa32017Rule100402Test extends Rgaa32017RuleImplementationTestCase {
//
//    /**
//     * Default constructor
//     * @param testName
//     */
//    public Rgaa32017Rule100402Test (String testName){
//        super(testName);
//    }
//
//    @Override
//    protected void setUpRuleImplementationClassName() {
//        setRuleImplementationClassName("org.tanaguru.rules.rgaa32017.Rgaa32017Rule100402");
//    }
//
//    @Override
//    protected void setUpWebResourceMap() {
////        addWebResource("Rgaa32017.Test.10.04.02-4NA-01");
////        addWebResource("Rgaa32017.Test.10.04.02-4NA-02");
////        addWebResource("Rgaa32017.Test.10.04.02-4NA-03");
//        addWebResource("Rgaa32017.Test.10.04.02-1Passed-01");
//        addWebResource("Rgaa32017.Test.10.04.02-1Passed-02");
//        addWebResource("Rgaa32017.Test.10.04.02-1Passed-03");
//        addWebResource("Rgaa32017.Test.10.04.02-1Passed-04");
//        addWebResource("Rgaa32017.Test.10.04.02-1Passed-05");
//        addWebResource("Rgaa32017.Test.10.04.02-1Passed-06");
//        addWebResource("Rgaa32017.Test.10.04.02-1Passed-07");
//        addWebResource("Rgaa32017.Test.10.04.02-1Passed-08");
//        addWebResource("Rgaa32017.Test.10.04.02-1Passed-09");
//        addWebResource("Rgaa32017.Test.10.04.02-1Passed-10");
//        addWebResource("Rgaa32017.Test.10.04.02-1Passed-11");
//        addWebResource("Rgaa32017.Test.10.04.02-1Passed-12");
//        addWebResource("Rgaa32017.Test.10.04.02-1Passed-13");
//        addWebResource("Rgaa32017.Test.10.04.02-1Passed-14");
//        addWebResource("Rgaa32017.Test.10.04.02-1Passed-15");
//        addWebResource("Rgaa32017.Test.10.04.02-1Passed-16");
//        addWebResource("Rgaa32017.Test.10.04.02-1Passed-17");
//        addWebResource("Rgaa32017.Test.10.04.02-1Passed-18");
//        addWebResource("Rgaa32017.Test.10.04.02-1Passed-19");
//        addWebResource("Rgaa32017.Test.10.04.02-1Passed-20");
//        addWebResource("Rgaa32017.Test.10.04.02-1Passed-21");
////        addWebResource("Rgaa32017.Test.10.04.02-1Passed-22");
////        addWebResource("Rgaa32017.Test.10.04.02-2Failed-01_1");
////        addWebResource("Rgaa32017.Test.10.04.02-2Failed-01_2");
////        addWebResource("Rgaa32017.Test.10.04.02-2Failed-01_3");
////        addWebResource("Rgaa32017.Test.10.04.02-2Failed-01_4");
////        addWebResource("Rgaa32017.Test.10.04.02-2Failed-02_1");
////        addWebResource("Rgaa32017.Test.10.04.02-2Failed-02_2");
////        addWebResource("Rgaa32017.Test.10.04.02-2Failed-02_3");
////        addWebResource("Rgaa32017.Test.10.04.02-2Failed-02_4");
////        addWebResource("Rgaa32017.Test.10.04.02-2Failed-02_5");
////        addWebResource("Rgaa32017.Test.10.04.02-2Failed-03_1");
////        addWebResource("Rgaa32017.Test.10.04.02-2Failed-03_2");
////        addWebResource("Rgaa32017.Test.10.04.02-2Failed-03_3");
////        addWebResource("Rgaa32017.Test.10.04.02-2Failed-03_4");
////        addWebResource("Rgaa32017.Test.10.04.02-2Failed-04_1");
////        addWebResource("Rgaa32017.Test.10.04.02-2Failed-04_4");
////        addWebResource("Rgaa32017.Test.10.04.02-2Failed-05_1");
////        addWebResource("Rgaa32017.Test.10.04.02-2Failed-05_2");
////        addWebResource("Rgaa32017.Test.10.04.02-2Failed-05_3");
////        addWebResource("Rgaa32017.Test.10.04.02-2Failed-05_4");
////        addWebResource("Rgaa32017.Test.10.04.02-2Failed-05_5");
////        addWebResource("Rgaa32017.Test.10.04.02-2Failed-06_1");
////        addWebResource("Rgaa32017.Test.10.04.02-2Failed-06_2");
////        addWebResource("Rgaa32017.Test.10.04.02-2Failed-06_3");
////        addWebResource("Rgaa32017.Test.10.04.02-2Failed-06_4");
////        addWebResource("Rgaa32017.Test.10.04.02-2Failed-06_5");
//        addWebResource("Rgaa32017.Test.10.04.02-3NMI-02");
//        
//        setUpRelatedContentMap();
//    }
//    
//    private void setUpRelatedContentMap(){
//    	    	
//        List<String> relatedContent1 = new ArrayList<>();
//        relatedContent1.add("css/Rgaa32017.Test.10.04.02-2Failed-01_1.css");
//        getRelatedContentMap().put(getWebResourceMap().get("Rgaa32017.Test.10.04.02-2Failed-01_1"), relatedContent1);
//
//        List<String> relatedContent2 = new ArrayList<>();
//        relatedContent2.add("css/Rgaa32017.Test.10.04.02-2Failed-01_2.css");
//        relatedContent2.add("css/Rgaa32017.Test.10.04.02-2Failed-01_2_1.css");
//        getRelatedContentMap().put(getWebResourceMap().get("Rgaa32017.Test.10.04.02-2Failed-01_2"), relatedContent2);
//
//        List<String> relatedContent3 = new ArrayList<>();
//        relatedContent3.add("css/Rgaa32017.Test.10.04.02-2Failed-01_3.css");
//        getRelatedContentMap().put(getWebResourceMap().get("Rgaa32017.Test.10.04.02-2Failed-01_3"), relatedContent3);
//        
//        List<String> relatedContent4 = new ArrayList<>();
//        relatedContent1.add("css/Rgaa30.Test.10.04.02-1Passed-01_1.css");
//        getRelatedContentMap().put(getWebResourceMap().get("Rgaa32017.Test.10.04.02-3NMI-02"), relatedContent4);
//        
//    }
//
//    @Override
//    protected void setProcess() {
//        //----------------------------------------------------------------------
//        //------------------------------1Passed-01------------------------------
//        //----------------------------------------------------------------------
//        checkResultIsPassed(processPageTest("Rgaa32017.Test.10.04.02-1Passed-01"),1);
//        
//        
//        //----------------------------------------------------------------------
//        //------------------------------1Passed-02------------------------------
//        //----------------------------------------------------------------------
//        checkResultIsPassed(processPageTest("Rgaa32017.Test.10.04.02-1Passed-02"),1);
//        
//        
//        //----------------------------------------------------------------------
//        //------------------------------1Passed-03------------------------------
//        //----------------------------------------------------------------------
//        checkResultIsPassed(processPageTest("Rgaa32017.Test.10.04.02-1Passed-03"),1);
//        
//        
//        //----------------------------------------------------------------------
//        //------------------------------1Passed-04------------------------------
//        //----------------------------------------------------------------------
//        checkResultIsPassed(processPageTest("Rgaa32017.Test.10.04.02-1Passed-04"),1);
//        
//        
//        //----------------------------------------------------------------------
//        //------------------------------1Passed-05------------------------------
//        //----------------------------------------------------------------------
//        checkResultIsPassed(processPageTest("Rgaa32017.Test.10.04.02-1Passed-05"),1);
//
//        
//        //----------------------------------------------------------------------
//        //------------------------------1Passed-06------------------------------
//        //----------------------------------------------------------------------
//        checkResultIsPassed(processPageTest("Rgaa32017.Test.10.04.02-1Passed-06"),1);
//        
//        
//        //----------------------------------------------------------------------
//        //------------------------------1Passed-07------------------------------
//        //----------------------------------------------------------------------
//        checkResultIsPassed(processPageTest("Rgaa32017.Test.10.04.02-1Passed-07"),1);
//        
//        
//        //----------------------------------------------------------------------
//        //------------------------------1Passed-08------------------------------
//        //----------------------------------------------------------------------
//        checkResultIsPassed(processPageTest("Rgaa32017.Test.10.04.02-1Passed-08"),2);
//        
//        
//        //----------------------------------------------------------------------
//        //------------------------------1Passed-09------------------------------
//        //----------------------------------------------------------------------
//        checkResultIsPassed(processPageTest("Rgaa32017.Test.10.04.02-1Passed-09"),1);
//        
//        
//        //----------------------------------------------------------------------
//        //------------------------------1Passed-10------------------------------
//        //----------------------------------------------------------------------
//        checkResultIsPassed(processPageTest("Rgaa32017.Test.10.04.02-1Passed-10"),6);
//        
//        
//        //----------------------------------------------------------------------
//        //------------------------------1Passed-11------------------------------
//        //----------------------------------------------------------------------
//        checkResultIsPassed(processPageTest("Rgaa32017.Test.10.04.02-1Passed-11"),1);
//        
//        
//        //----------------------------------------------------------------------
//        //------------------------------1Passed-12------------------------------
//        //----------------------------------------------------------------------
//        checkResultIsPassed(processPageTest("Rgaa32017.Test.10.04.02-1Passed-12"),2);
//        
//        
//        //----------------------------------------------------------------------
//        //------------------------------1Passed-13------------------------------
//        //----------------------------------------------------------------------
//        checkResultIsPassed(processPageTest("Rgaa32017.Test.10.04.02-1Passed-13"),2);
//        
//        
//        //----------------------------------------------------------------------
//        //------------------------------1Passed-14------------------------------
//        //----------------------------------------------------------------------
//        checkResultIsPassed(processPageTest("Rgaa32017.Test.10.04.02-1Passed-14"),2);
//        
//        
//        //----------------------------------------------------------------------
//        //------------------------------1Passed-15------------------------------
//        //----------------------------------------------------------------------
//        checkResultIsPassed(processPageTest("Rgaa32017.Test.10.04.02-1Passed-15"),1);
//        
//        
//        //----------------------------------------------------------------------
//        //------------------------------1Passed-16------------------------------
//        //----------------------------------------------------------------------
//        checkResultIsPassed(processPageTest("Rgaa32017.Test.10.04.02-1Passed-16"),1);
//        
//        
//        //----------------------------------------------------------------------
//        //------------------------------1Passed-17------------------------------
//        //----------------------------------------------------------------------
//        checkResultIsPassed(processPageTest("Rgaa32017.Test.10.04.02-1Passed-17"),1);
//        
//        
//        //----------------------------------------------------------------------
//        //------------------------------1Passed-18------------------------------
//        //----------------------------------------------------------------------
//        checkResultIsPassed(processPageTest("Rgaa32017.Test.10.04.02-1Passed-18"),1);
//        
//        
//        //----------------------------------------------------------------------
//        //------------------------------1Passed-19------------------------------
//        //----------------------------------------------------------------------
//        checkResultIsPassed(processPageTest("Rgaa32017.Test.10.04.02-1Passed-19"),1);
//        
//        
//        //----------------------------------------------------------------------
//        //------------------------------1Passed-20------------------------------
//        //----------------------------------------------------------------------
//        checkResultIsPassed(processPageTest("Rgaa32017.Test.10.04.02-1Passed-20"),1);
//        
//        
//        //----------------------------------------------------------------------
//        //------------------------------1Passed-21------------------------------
//        //----------------------------------------------------------------------
//        checkResultIsPassed(processPageTest("Rgaa32017.Test.10.04.02-1Passed-21"),1);
//        
//        
//        //----------------------------------------------------------------------
//        //------------------------------1Passed-22------------------------------
//        //----------------------------------------------------------------------
////        checkResultIsPassed(processPageTest("Rgaa32017.Test.10.04.02-1Passed-22"),1); //Faire avec des feuilles importées de style
//        
//        
//        //----------------------------------------------------------------------
//        //------------------------------1Passed-23------------------------------
//        //----------------------------------------------------------------------
////        checkResultIsPassed(processPageTest("Rgaa32017.Test.10.04.02-1Passed-23"),1); //Faire avec des feuilles importées de style en css calculés
//        
//        //----------------------------------------------------------------------
//        //------------------------------2Failed-01_1----------------------------
//        //----------------------------------------------------------------------
////        ProcessResult processResult = processPageTest("Rgaa32017.Test.10.04.02-2Failed-01_1");
////        checkResultIsFailed(processResult, 1, 1);
////        checkRemarkIsPresent(
////                processResult,
////                TestSolution.FAILED,
////                RemarkMessageStore.BAD_UNIT_TYPE_MSG,
////                "pt",
////                1,
////                true,
////                new ImmutablePair(EvidenceStore.CSS_SELECTOR_EE, "h1"),
////                new ImmutablePair(EvidenceStore.CSS_FILENAME_EE, "Rgaa32017.Test.10.04.02-2Failed-01_1.css"));
//        
//        
//        //----------------------------------------------------------------------
//        //------------------------------2Failed-01_2----------------------------
//        //----------------------------------------------------------------------
////        ProcessResult processResult = processPageTest("Rgaa32017.Test.10.04.02-2Failed-01_2");
////        checkResultIsFailed(processResult, 1, 1);
////        checkRemarkIsPresent(
////                processResult,
////                TestSolution.FAILED,
////                RemarkMessageStore.BAD_UNIT_TYPE_MSG,
////                "pt",
////                1,
////                true,
////                new ImmutablePair(EvidenceStore.CSS_SELECTOR_EE, "h1"),
////                new ImmutablePair(EvidenceStore.CSS_FILENAME_EE, "Rgaa32017.Test.10.04.02-2Failed-01_2_1.css"));
////        
//        
//        //----------------------------------------------------------------------
//        //------------------------------2Failed-01_3----------------------------
//        //----------------------------------------------------------------------
////        ProcessResult processResult = processPageTest("Rgaa32017.Test.10.04.02-2Failed-01_3");
////        checkResultIsFailed(processResult, 1, 1);
////        checkRemarkIsPresent(
////                processResult,
////                TestSolution.FAILED,
////                RemarkMessageStore.BAD_UNIT_TYPE_MSG,
////                "pt",
////                1,
////                true,
////                new ImmutablePair(EvidenceStore.CSS_SELECTOR_EE, "h1"),
////                new ImmutablePair(EvidenceStore.CSS_FILENAME_EE, "Rgaa32017.Test.10.04.02-2Failed-01_3.css"));
//
//
//        //----------------------------------------------------------------------
//        //------------------------------2Failed-01_4----------------------------
//        //----------------------------------------------------------------------
////        processResult = processPageTest("Rgaa32017.Test.10.04.02-2Failed-01_4");
////        checkResultIsFailed(processResult, 1, 1);
////        checkRemarkIsPresent(
////                processResult,
////                TestSolution.FAILED,
////                RemarkMessageStore.BAD_UNIT_TYPE_MSG,
////                "pt",
////                1,
////                true,
////                new ImmutablePair(EvidenceStore.CSS_SELECTOR_EE, "h1"),
////                new ImmutablePair(EvidenceStore.CSS_FILENAME_EE, "locale"));
//
//
//        //----------------------------------------------------------------------
//        //------------------------------2Failed-02_1----------------------------
//        //----------------------------------------------------------------------
////        processResult = processPageTest("Rgaa32017.Test.10.04.02-2Failed-02_1");
////        checkResultIsFailed(processResult, 1, 1);
////        checkRemarkIsPresent(
////                processResult,
////                TestSolution.FAILED,
////                RemarkMessageStore.BAD_UNIT_TYPE_MSG,
////                "pc",
////                1,
////                true,
////                new ImmutablePair(EvidenceStore.CSS_SELECTOR_EE, "h1"),
////                new ImmutablePair(EvidenceStore.CSS_FILENAME_EE, "locale"));
//
//
//        //----------------------------------------------------------------------
//        //------------------------------2Failed-02_2----------------------------
//        //----------------------------------------------------------------------
////        processResult = processPageTest("Rgaa32017.Test.10.04.02-2Failed-02_2");
////        checkResultIsFailed(processResult, 1, 1);
////        checkRemarkIsPresent(
////                processResult,
////                TestSolution.FAILED,
////                RemarkMessageStore.BAD_UNIT_TYPE_MSG,
////                "pc",
////                1,
////                true,
////                new ImmutablePair(EvidenceStore.CSS_SELECTOR_EE, "h1"),
////                new ImmutablePair(EvidenceStore.CSS_FILENAME_EE, "locale"));
//
//
//        //----------------------------------------------------------------------
//        //------------------------------2Failed-02_3----------------------------
//        //----------------------------------------------------------------------
////        processResult = processPageTest("Rgaa32017.Test.10.04.02-2Failed-02_3");
////        checkResultIsFailed(processResult, 1, 1);
////        checkRemarkIsPresent(
////                processResult,
////                TestSolution.FAILED,
////                RemarkMessageStore.BAD_UNIT_TYPE_MSG,
////                "pc",
////                1,
////                true,
////                new ImmutablePair(EvidenceStore.CSS_SELECTOR_EE, "h1"),
////                new ImmutablePair(EvidenceStore.CSS_FILENAME_EE, "locale"));
//
//
//        //----------------------------------------------------------------------
//        //------------------------------2Failed-02_4----------------------------
//        //----------------------------------------------------------------------
////        processResult = processPageTest("Rgaa32017.Test.10.04.02-2Failed-02_4");
////        checkResultIsFailed(processResult, 1, 1);
////        checkRemarkIsPresent(
////                processResult,
////                TestSolution.FAILED,
////                RemarkMessageStore.BAD_UNIT_TYPE_MSG,
////                "pc",
////                1,
////                true,
////                new ImmutablePair(EvidenceStore.CSS_SELECTOR_EE, "h1"),
////                new ImmutablePair(EvidenceStore.CSS_FILENAME_EE, "locale"));
//
//
//        //----------------------------------------------------------------------
//        //------------------------------2Failed-02_5----------------------------
//        //----------------------------------------------------------------------
////        processResult = processPageTest("Rgaa32017.Test.10.04.02-2Failed-02_5");
////        checkResultIsFailed(processResult, 1, 1);
////        checkRemarkIsPresent(
////                processResult,
////                TestSolution.FAILED,
////                RemarkMessageStore.BAD_UNIT_TYPE_MSG,
////                "pc",
////                1,
////                true,
////                new ImmutablePair(EvidenceStore.CSS_SELECTOR_EE, "h1"),
////                new ImmutablePair(EvidenceStore.CSS_FILENAME_EE, "locale"));
//
//
//        //----------------------------------------------------------------------
//        //------------------------------2Failed-03_1----------------------------
//        //----------------------------------------------------------------------
////        processResult = processPageTest("Rgaa32017.Test.10.04.02-2Failed-03_1");
////        checkResultIsFailed(processResult, 1, 1);
////        checkRemarkIsPresent(
////                processResult,
////                TestSolution.FAILED,
////                RemarkMessageStore.BAD_UNIT_TYPE_MSG,
////                "mm",
////                1,
////                true,
////                new ImmutablePair(EvidenceStore.CSS_SELECTOR_EE, "h1"),
////                new ImmutablePair(EvidenceStore.CSS_FILENAME_EE, "locale"));
//
//
//        //----------------------------------------------------------------------
//        //------------------------------2Failed-03_2----------------------------
//        //----------------------------------------------------------------------
////        processResult = processPageTest("Rgaa32017.Test.10.04.02-2Failed-03_2");
////        checkResultIsFailed(processResult, 1, 1);
////        checkRemarkIsPresent(
////                processResult,
////                TestSolution.FAILED,
////                RemarkMessageStore.BAD_UNIT_TYPE_MSG,
////                "mm",
////                1,
////                true,
////                new ImmutablePair(EvidenceStore.CSS_SELECTOR_EE, "h1"),
////                new ImmutablePair(EvidenceStore.CSS_FILENAME_EE, "locale"));
//
//
//        //----------------------------------------------------------------------
//        //------------------------------2Failed-03_3----------------------------
//        //----------------------------------------------------------------------
////        processResult = processPageTest("Rgaa32017.Test.10.04.02-2Failed-03_3");
////        checkResultIsFailed(processResult, 1, 1);
////        checkRemarkIsPresent(
////                processResult,
////                TestSolution.FAILED,
////                RemarkMessageStore.BAD_UNIT_TYPE_MSG,
////                "mm",
////                1,
////                true,
////                new ImmutablePair(EvidenceStore.CSS_SELECTOR_EE, "h1"),
////                new ImmutablePair(EvidenceStore.CSS_FILENAME_EE, "locale"));
//
//
//        //----------------------------------------------------------------------
//        //------------------------------2Failed-03_4----------------------------
//        //----------------------------------------------------------------------
////        processResult = processPageTest("Rgaa32017.Test.10.04.02-2Failed-03_4");
////        checkResultIsFailed(processResult, 1, 1);
////        checkRemarkIsPresent(
////                processResult,
////                TestSolution.FAILED,
////                RemarkMessageStore.BAD_UNIT_TYPE_MSG,
////                "mm",
////                1,
////                true,
////                new ImmutablePair(EvidenceStore.CSS_SELECTOR_EE, "h1"),
////                new ImmutablePair(EvidenceStore.CSS_FILENAME_EE, "locale"));
////
////
////        //----------------------------------------------------------------------
////        //------------------------------2Failed-04_1----------------------------
////        //----------------------------------------------------------------------
////        processResult = processPageTest("Rgaa32017.Test.10.04.02-2Failed-04_1");
////        checkResultIsFailed(processResult, 1, 1);
////        checkRemarkIsPresent(
////                processResult,
////                TestSolution.FAILED,
////                RemarkMessageStore.BAD_UNIT_TYPE_MSG,
////                "cm",
////                1,
////                true,
////                new ImmutablePair(EvidenceStore.CSS_SELECTOR_EE, "h1"),
////                new ImmutablePair(EvidenceStore.CSS_FILENAME_EE, "locale"));
////
////
////        //----------------------------------------------------------------------
////        //------------------------------2Failed-04_4----------------------------
////        //----------------------------------------------------------------------
////        processResult = processPageTest("Rgaa32017.Test.10.04.02-2Failed-04_4");
////        checkResultIsFailed(processResult, 1, 1);
////        checkRemarkIsPresent(
////                processResult,
////                TestSolution.FAILED,
////                RemarkMessageStore.BAD_UNIT_TYPE_MSG,
////                "cm",
////                1,
////                true,
////                new ImmutablePair(EvidenceStore.CSS_SELECTOR_EE, "h1"),
////                new ImmutablePair(EvidenceStore.CSS_FILENAME_EE, "locale"));
////
////
////
////        //----------------------------------------------------------------------
////        //------------------------------2Failed-05_1----------------------------
////        //----------------------------------------------------------------------
////        processResult = processPageTest("Rgaa32017.Test.10.04.02-2Failed-05_1");
////        checkResultIsFailed(processResult, 1, 1);
////        checkRemarkIsPresent(
////                processResult,
////                TestSolution.FAILED,
////                RemarkMessageStore.BAD_UNIT_TYPE_MSG,
////                "in",
////                1,
////                true,
////                new ImmutablePair(EvidenceStore.CSS_SELECTOR_EE, "h1"),
////                new ImmutablePair(EvidenceStore.CSS_FILENAME_EE, "locale"));
////
////
////        //----------------------------------------------------------------------
////        //------------------------------2Failed-05_2----------------------------
////        //----------------------------------------------------------------------
////        processResult = processPageTest("Rgaa32017.Test.10.04.02-2Failed-05_2");
////        checkResultIsFailed(processResult, 1, 1);
////        checkRemarkIsPresent(
////                processResult,
////                TestSolution.FAILED,
////                RemarkMessageStore.BAD_UNIT_TYPE_MSG,
////                "in",
////                1,
////                true,
////                new ImmutablePair(EvidenceStore.CSS_SELECTOR_EE, "h1"),
////                new ImmutablePair(EvidenceStore.CSS_FILENAME_EE, "locale"));
////
////
////        //----------------------------------------------------------------------
////        //------------------------------2Failed-05_3----------------------------
////        //----------------------------------------------------------------------
////        processResult = processPageTest("Rgaa32017.Test.10.04.02-2Failed-05_3");
////        checkResultIsFailed(processResult, 1, 1);
////        checkRemarkIsPresent(
////                processResult,
////                TestSolution.FAILED,
////                RemarkMessageStore.BAD_UNIT_TYPE_MSG,
////                "in",
////                1,
////                true,
////                new ImmutablePair(EvidenceStore.CSS_SELECTOR_EE, "h1"),
////                new ImmutablePair(EvidenceStore.CSS_FILENAME_EE, "locale"));
////
////
////        //----------------------------------------------------------------------
////        //------------------------------2Failed-05_4----------------------------
////        //----------------------------------------------------------------------
////        processResult = processPageTest("Rgaa32017.Test.10.04.02-2Failed-05_4");
////        checkResultIsFailed(processResult, 1, 1);
////        checkRemarkIsPresent(
////                processResult,
////                TestSolution.FAILED,
////                RemarkMessageStore.BAD_UNIT_TYPE_MSG,
////                "in",
////                1,
////                true,
////                new ImmutablePair(EvidenceStore.CSS_SELECTOR_EE, "h1"),
////                new ImmutablePair(EvidenceStore.CSS_FILENAME_EE, "locale"));
////
////
////        //----------------------------------------------------------------------
////        //------------------------------2Failed-05_5----------------------------
////        //----------------------------------------------------------------------
////        processResult = processPageTest("Rgaa32017.Test.10.04.02-2Failed-05_5");
////        checkResultIsFailed(processResult, 1, 1);
////        checkRemarkIsPresent(
////                processResult,
////                TestSolution.FAILED,
////                RemarkMessageStore.BAD_UNIT_TYPE_MSG,
////                "in",
////                1,
////                true,
////                new ImmutablePair(EvidenceStore.CSS_SELECTOR_EE, "h1"),
////                new ImmutablePair(EvidenceStore.CSS_FILENAME_EE, "locale"));
////
////
////        //----------------------------------------------------------------------
////        //------------------------------2Failed-06_1----------------------------
////        //----------------------------------------------------------------------
////        processResult = processPageTest("Rgaa32017.Test.10.04.02-2Failed-06_1");
////        checkResultIsFailed(processResult, 1, 1);
////        checkRemarkIsPresent(
////                processResult,
////                TestSolution.FAILED,
////                RemarkMessageStore.BAD_UNIT_TYPE_MSG,
////                "in",
////                1,
////                true,
////                new ImmutablePair(EvidenceStore.CSS_SELECTOR_EE, "div"),
////                new ImmutablePair(EvidenceStore.CSS_FILENAME_EE, "inline"));
////
////
////        //----------------------------------------------------------------------
////        //------------------------------2Failed-06_2----------------------------
////        //----------------------------------------------------------------------
////        processResult = processPageTest("Rgaa32017.Test.10.04.02-2Failed-06_2");
////        checkResultIsFailed(processResult, 1, 1);
////        checkRemarkIsPresent(
////                processResult,
////                TestSolution.FAILED,
////                RemarkMessageStore.BAD_UNIT_TYPE_MSG,
////                "pt",
////                1,
////                true,
////                new ImmutablePair(EvidenceStore.CSS_SELECTOR_EE, "div"),
////                new ImmutablePair(EvidenceStore.CSS_FILENAME_EE, "inline"));
////
////
////        //----------------------------------------------------------------------
////        //------------------------------2Failed-06_3----------------------------
////        //----------------------------------------------------------------------
////        processResult = processPageTest("Rgaa32017.Test.10.04.02-2Failed-06_3");
////        checkResultIsFailed(processResult, 1, 1);
////        checkRemarkIsPresent(
////                processResult,
////                TestSolution.FAILED,
////                RemarkMessageStore.BAD_UNIT_TYPE_MSG,
////                "mm",
////                1,
////                true,
////                new ImmutablePair(EvidenceStore.CSS_SELECTOR_EE, "div"),
////                new ImmutablePair(EvidenceStore.CSS_FILENAME_EE, "inline"));
////
////
////        //----------------------------------------------------------------------
////        //------------------------------2Failed-06_4----------------------------
////        //----------------------------------------------------------------------
////        processResult = processPageTest("Rgaa32017.Test.10.04.02-2Failed-06_4");
////        checkResultIsFailed(processResult, 1, 1);
////        checkRemarkIsPresent(
////                processResult,
////                TestSolution.FAILED,
////                RemarkMessageStore.BAD_UNIT_TYPE_MSG,
////                "cm",
////                1,
////                true,
////                new ImmutablePair(EvidenceStore.CSS_SELECTOR_EE, "div"),
////                new ImmutablePair(EvidenceStore.CSS_FILENAME_EE, "inline"));
//
//
////        //----------------------------------------------------------------------
////        //------------------------------2Failed-06_5----------------------------
////        //----------------------------------------------------------------------
////        ProcessResult 
////        processResult = processPageTest("Rgaa32017.Test.10.04.02-2Failed-06_5");
////        checkResultIsFailed(processResult, 1, 1);
////        checkRemarkIsPresent(
////                processResult,
////                TestSolution.FAILED,
////                RemarkMessageStore.BAD_UNIT_TYPE_MSG,
////                "px",
////                1,
////                true,
////                new ImmutablePair(EvidenceStore.CSS_SELECTOR_EE, "div"),
////                new ImmutablePair(EvidenceStore.CSS_FILENAME_EE, "inline"));
////
//        
//        //----------------------------------------------------------------------
//        //------------------------------3NMI-01---------------------------------
//        //----------------------------------------------------------------------
//        ProcessResult  processResult = processPageTest("Rgaa32017.Test.10.04.02-3NMI-02");
//        checkResultIsPreQualified(processResult,0,1);
//        checkRemarkIsPresent(
//                processResult,
//                TestSolution.NEED_MORE_INFO,
//                "UnTestedResource",
//                "EMPTY_TARGET",
//                1,
//                new ImmutablePair(EvidenceStore.ELEMENT_NAME_EE, "css/Rgaa30.Test.10.04.02-1Passed-01_1.css"));
////        //----------------------------------------------------------------------
////        //------------------------------4NA-1-----------------------------------
////        //----------------------------------------------------------------------
////        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.10.04.02-4NA-01"));
////
////
////        //----------------------------------------------------------------------
////        //------------------------------4NA-2-----------------------------------
////        //----------------------------------------------------------------------
////        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.10.04.02-4NA-02"));
////
////
////        //----------------------------------------------------------------------
////        //------------------------------4NA-3-----------------------------------
////        //----------------------------------------------------------------------
////        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.10.04.02-4NA-03"));
//    }
//
//}
