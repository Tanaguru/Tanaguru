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

import static org.tanaguru.rules.keystore.RemarkMessageStore.TITLE_NOT_IDENTICAL_PLACEHOLDER;
import static org.tanaguru.rules.keystore.HtmlElementStore.INPUT_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.KEYGEN_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.OPTION_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.OPTGROUP_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.SELECT_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.DATALIST_ELEMENT;
import static org.tanaguru.rules.keystore.AttributeStore.PLACEHOLDER_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;

import org.apache.commons.lang3.tuple.ImmutablePair;

import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.rules.rgaa32017.test.Rgaa32017RuleImplementationTestCase;

/**
 * Unit test class for the implementation of the rule 11-1-3 of the referential Rgaa 3-2017.
 *
 * @author jkowalczyk
 */
public class Rgaa32017Rule110105Test extends Rgaa32017RuleImplementationTestCase {

    /**
     * Default constructor
     * @param testName
     */
    public Rgaa32017Rule110105Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName("org.tanaguru.rules.rgaa32017.Rgaa32017Rule110105");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("Rgaa32017.Test.11.01.05-1Passed-01");
        addWebResource("Rgaa32017.Test.11.01.05-1Passed-02");
        addWebResource("Rgaa32017.Test.11.01.05-1Passed-03");
        addWebResource("Rgaa32017.Test.11.01.05-1Passed-04");
        addWebResource("Rgaa32017.Test.11.01.05-1Passed-05");
        addWebResource("Rgaa32017.Test.11.01.05-1Passed-06");
        addWebResource("Rgaa32017.Test.11.01.05-1Passed-07");
        addWebResource("Rgaa32017.Test.11.01.05-1Passed-08");
        addWebResource("Rgaa32017.Test.11.01.05-1Passed-09");
        addWebResource("Rgaa32017.Test.11.01.05-1Passed-10");
        addWebResource("Rgaa32017.Test.11.01.05-1Passed-11");
        addWebResource("Rgaa32017.Test.11.01.05-1Passed-12");
        addWebResource("Rgaa32017.Test.11.01.05-2Failed-01");
        addWebResource("Rgaa32017.Test.11.01.05-2Failed-02");
        addWebResource("Rgaa32017.Test.11.01.05-2Failed-03");
        addWebResource("Rgaa32017.Test.11.01.05-2Failed-04");
        addWebResource("Rgaa32017.Test.11.01.05-2Failed-05");
        addWebResource("Rgaa32017.Test.11.01.05-2Failed-06");
        addWebResource("Rgaa32017.Test.11.01.05-4NA-01");
    }

    @Override
    protected void setProcess() {
    	//----------------------------------------------------------------------
        //------------------------------1Passed-01---------------------------------
        //----------------------------------------------------------------------
    	checkResultIsPassed(processPageTest("Rgaa32017.Test.11.01.05-1Passed-01"),1);
    	
    	//----------------------------------------------------------------------
        //------------------------------1Passed-02---------------------------------
        //----------------------------------------------------------------------
    	checkResultIsPassed(processPageTest("Rgaa32017.Test.11.01.05-1Passed-02"),1);
    	
    	//----------------------------------------------------------------------
        //------------------------------1Passed-03---------------------------------
        //----------------------------------------------------------------------
    	checkResultIsPassed(processPageTest("Rgaa32017.Test.11.01.05-1Passed-03"),1);
    	
    	//----------------------------------------------------------------------
        //------------------------------1Passed-04---------------------------------
        //----------------------------------------------------------------------
    	checkResultIsPassed(processPageTest("Rgaa32017.Test.11.01.05-1Passed-04"),1);
    	
    	//----------------------------------------------------------------------
        //------------------------------1Passed-05---------------------------------
        //----------------------------------------------------------------------
    	checkResultIsPassed(processPageTest("Rgaa32017.Test.11.01.05-1Passed-05"),2);
    	
    	//----------------------------------------------------------------------
        //------------------------------1Passed-06---------------------------------
        //----------------------------------------------------------------------
    	checkResultIsPassed(processPageTest("Rgaa32017.Test.11.01.05-1Passed-06"),2);
    	
    	//----------------------------------------------------------------------
        //------------------------------1Passed-07---------------------------------
        //----------------------------------------------------------------------
    	checkResultIsPassed(processPageTest("Rgaa32017.Test.11.01.05-1Passed-07"),2);
    	
    	//----------------------------------------------------------------------
        //------------------------------1Passed-08---------------------------------
        //----------------------------------------------------------------------
    	checkResultIsPassed(processPageTest("Rgaa32017.Test.11.01.05-1Passed-08"),2);
    	
    	//----------------------------------------------------------------------
        //------------------------------1Passed-09---------------------------------
        //----------------------------------------------------------------------
    	checkResultIsPassed(processPageTest("Rgaa32017.Test.11.01.05-1Passed-09"),1);
    	
    	//----------------------------------------------------------------------
        //------------------------------1Passed-10---------------------------------
        //----------------------------------------------------------------------
    	checkResultIsPassed(processPageTest("Rgaa32017.Test.11.01.05-1Passed-10"),1);
    	
    	//----------------------------------------------------------------------
        //------------------------------1Passed-11---------------------------------
        //----------------------------------------------------------------------
    	checkResultIsPassed(processPageTest("Rgaa32017.Test.11.01.05-1Passed-11"),1);
    	
    	//----------------------------------------------------------------------
        //------------------------------1Passed-12---------------------------------
        //----------------------------------------------------------------------
    	checkResultIsPassed(processPageTest("Rgaa32017.Test.11.01.05-1Passed-12"),1);
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-01------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("Rgaa32017.Test.11.01.05-2Failed-01");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                TITLE_NOT_IDENTICAL_PLACEHOLDER, 
                DATALIST_ELEMENT, 
                1,
                new ImmutablePair(PLACEHOLDER_ATTR, "videogame characters"),
                new ImmutablePair(TITLE_ATTR, "characters"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-02------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.05-2Failed-02");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                TITLE_NOT_IDENTICAL_PLACEHOLDER, 
                SELECT_ELEMENT, 
                1,
                new ImmutablePair(PLACEHOLDER_ATTR, "FAILURE 04"),
                new ImmutablePair(TITLE_ATTR, "FAILED 04"));

        
        //----------------------------------------------------------------------
        //------------------------------2Failed-03------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.05-2Failed-03");
        checkResultIsFailed(processResult,2,2);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                TITLE_NOT_IDENTICAL_PLACEHOLDER, 
                OPTGROUP_ELEMENT, 
                1,
                new ImmutablePair(PLACEHOLDER_ATTR, "big dog"),
                new ImmutablePair(TITLE_ATTR, "dog"));
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                TITLE_NOT_IDENTICAL_PLACEHOLDER, 
                OPTGROUP_ELEMENT, 
                2,
                new ImmutablePair(PLACEHOLDER_ATTR, "little cat"),
                new ImmutablePair(TITLE_ATTR, "cat"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-04------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.05-2Failed-04");
        checkResultIsFailed(processResult,2,2);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                TITLE_NOT_IDENTICAL_PLACEHOLDER, 
                OPTION_ELEMENT, 
                1,
                new ImmutablePair(PLACEHOLDER_ATTR, "big dog"),
                new ImmutablePair(TITLE_ATTR, "dog"));
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                TITLE_NOT_IDENTICAL_PLACEHOLDER, 
                OPTION_ELEMENT, 
                2,
                new ImmutablePair(PLACEHOLDER_ATTR, "little cat"),
                new ImmutablePair(TITLE_ATTR, "cat"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-05------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.05-2Failed-05");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                TITLE_NOT_IDENTICAL_PLACEHOLDER, 
                KEYGEN_ELEMENT, 
                1,
                new ImmutablePair(PLACEHOLDER_ATTR, "secureform"),
                new ImmutablePair(TITLE_ATTR, "security"));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-06------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.11.01.05-2Failed-06");
        checkResultIsFailed(processResult,1,1);
        checkRemarkIsPresent(
                processResult, 
                TestSolution.FAILED, 
                TITLE_NOT_IDENTICAL_PLACEHOLDER, 
                INPUT_ELEMENT, 
                1,
                new ImmutablePair(PLACEHOLDER_ATTR, "mymainlabel"),
                new ImmutablePair(TITLE_ATTR, "mylabel"));

        //----------------------------------------------------------------------
        //------------------------------4NA-A01---------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.11.01.05-4NA-01"));
    }

}