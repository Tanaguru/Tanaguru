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

import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.rules.rgaa32017.test.Rgaa32017RuleImplementationTestCase;

/**
 * Unit test class for the implementation of the rule 11-1-3 of the referential Rgaa 3-2017.
 *
 * @author jkowalczyk
 */
public class Rgaa32017Rule110104Test extends Rgaa32017RuleImplementationTestCase {

 

    public Rgaa32017Rule110104Test(String testName) {
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName("org.tanaguru.rules.rgaa32017.Rgaa32017Rule110104");
    }

    @Override
    protected void setUpWebResourceMap() {
        
        addWebResource("Rgaa32017.Test.11.01.04-3NMI-01");
        addWebResource("Rgaa32017.Test.11.01.04-3NMI-02");
        addWebResource("Rgaa32017.Test.11.01.04-3NMI-03");
        addWebResource("Rgaa32017.Test.11.01.04-3NMI-04");
        addWebResource("Rgaa32017.Test.11.01.04-3NMI-05");
        addWebResource("Rgaa32017.Test.11.01.04-3NMI-06");
        addWebResource("Rgaa32017.Test.11.01.04-4NA-01");
        addWebResource("Rgaa32017.Test.11.01.04-4NA-02");
        addWebResource("Rgaa32017.Test.11.01.04-4NA-03");
        addWebResource("Rgaa32017.Test.11.01.04-4NA-04");
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------3NMI-01---------------------------------
        //----------------------------------------------------------------------        
    	ProcessResult processResult = processPageTest("Rgaa32017.Test.11.01.04-3NMI-01");
        checkResultIsPreQualified(processResult, 6, 6);
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-02---------------------------------
        //----------------------------------------------------------------------        
    	processResult = processPageTest("Rgaa32017.Test.11.01.04-3NMI-02");
        checkResultIsPreQualified(processResult, 10, 10);
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-03---------------------------------
        //----------------------------------------------------------------------        
    	processResult = processPageTest("Rgaa32017.Test.11.01.04-3NMI-03");
        checkResultIsPreQualified(processResult, 19, 12);
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-04---------------------------------
        //----------------------------------------------------------------------        
    	processResult = processPageTest("Rgaa32017.Test.11.01.04-3NMI-04");
        checkResultIsPreQualified(processResult, 6, 6);
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-05---------------------------------
        //----------------------------------------------------------------------        
    	processResult = processPageTest("Rgaa32017.Test.11.01.04-3NMI-05");
        checkResultIsPreQualified(processResult, 10, 10);
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-06---------------------------------
        //----------------------------------------------------------------------        
    	processResult = processPageTest("Rgaa32017.Test.11.01.04-3NMI-06");
        checkResultIsPreQualified(processResult, 19, 12);
        
        

        //----------------------------------------------------------------------
        //------------------------------4NA-01----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.11.01.04-4NA-01"));

        //----------------------------------------------------------------------
        //------------------------------4NA-02----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.11.01.04-4NA-02"),6);

        //----------------------------------------------------------------------
        //------------------------------4NA-03----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.11.01.04-4NA-03"),10);

        //----------------------------------------------------------------------
        //------------------------------4NA-04----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.11.01.04-4NA-04"),19);

    }
    
}