/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2016  Tanaguru.org
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
package org.tanaguru.rules.rgaa32016;

import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.rules.rgaa32016.test.Rgaa32016RuleImplementationTestCase;

/**
 * Unit test class for the implementation of the rule 3-3-3 of the referential Rgaa 3-2016.
 *
 * @author jkowalczyk
 */
public class Rgaa32016Rule030303Test extends Rgaa32016RuleImplementationTestCase {

    /**
     * Default constructor
     * @param testName
     */
    public Rgaa32016Rule030303Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName("org.tanaguru.rules.rgaa32016.Rgaa32016Rule030303");
    }

    @Override
    protected void setUpWebResourceMap() {
//        addWebResource("Rgaa32016.Test.03.03.03-1Passed-01");
//        addWebResource("Rgaa32016.Test.03.03.03-2Failed-01");
        addWebResource("Rgaa32016.Test.03.03.03-3NMI-01");
//        addWebResource("Rgaa32016.Test.03.03.03-4NA-01");

    }

    @Override
    protected void setProcess() {
//        assertEquals(TestSolution.PASSED,
//                processPageTest("Rgaa32016.Test.03.03.03-1Passed-01").getValue());
//        assertEquals(TestSolution.FAILED,
//                processPageTest("Rgaa32016.Test.03.03.03-2Failed-01").getValue());
        assertEquals(TestSolution.NOT_TESTED,
                processPageTest("Rgaa32016.Test.03.03.03-3NMI-01").getValue());
//        assertEquals(TestSolution.NOT_APPLICABLE,
//                processPageTest("Rgaa32016.Test.03.03.03-4NA-01").getValue());

    }

    @Override
    protected void setConsolidate() {
//        assertEquals(TestSolution.PASSED,
//                consolidate("Rgaa32016.Test.03.03.03-1Passed-01").getValue());
//        assertEquals(TestSolution.FAILED,
//                consolidate("Rgaa32016.Test.03.03.03-2Failed-01").getValue());
        assertEquals(TestSolution.NOT_TESTED,
                consolidate("Rgaa32016.Test.03.03.03-3NMI-01").getValue());
//        assertEquals(TestSolution.NOT_APPLICABLE,
//                consolidate("Rgaa32016.Test.03.03.03-4NA-01").getValue());
    }

}
