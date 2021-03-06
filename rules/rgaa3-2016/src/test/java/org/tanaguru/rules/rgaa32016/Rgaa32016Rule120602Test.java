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

import org.tanaguru.entity.audit.IndefiniteResult;
import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.entity.subject.Page;
import org.tanaguru.entity.subject.Site;
import org.tanaguru.rules.rgaa32016.test.Rgaa32016RuleImplementationTestCase;

/**
 * Unit test class for the implementation of the rule 12-6-2 of the referential Rgaa 3-2016.
 *
 * @author jkowalczyk
 */
public class Rgaa32016Rule120602Test extends Rgaa32016RuleImplementationTestCase {

    /**
     * Default constructor
     * @param testName
     */
    public Rgaa32016Rule120602Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName("org.tanaguru.rules.rgaa32016.Rgaa32016Rule120602");
    }

    @Override
    protected void setUpWebResourceMap() {
        getWebResourceMap().put("Rgaa32016.Test.12.06.02-4NA-01",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "rgaa32016/Rgaa32016Rule120602/Rgaa32016.Test.12.06.02-3NMI-01.html"));

        Site site = getWebResourceFactory().createSite("file:Site-NotTested");
        getWebResourceMap().put("Rgaa32016.Test.12.06.02-5NT-01", site);

        Page page = getWebResourceFactory().createPage(getTestcasesFilePath() +
                "rgaa32016/Rgaa32016Rule120602/Rgaa32016.Test.12.06.02-3NMI-01.html");
        site.addChild(page);
        getWebResourceMap().put("Rgaa32016.Test.12.06.02-5NT-01-page1",page);

        page = getWebResourceFactory().createPage(getTestcasesFilePath() +
                "rgaa32016/Rgaa32016Rule120602/Rgaa32016.Test.12.06.02-3NMI-01.html");
        site.addChild(page);
        getWebResourceMap().put("Rgaa32016.Test.12.06.02-5NT-01-page1",page);
    }

    @Override
    protected void setProcess() {
        ProcessResult pr = processPageTest("Rgaa32016.Test.12.06.02-4NA-01");
        assertTrue(pr instanceof IndefiniteResult);
        assertEquals(getWebResourceMap().get("Rgaa32016.Test.12.06.02-4NA-01"),pr.getSubject());
        assertEquals("mock-result", pr.getValue());
        
        process("Rgaa32016.Test.12.06.02-5NT-01");

    }

    @Override
    protected void setConsolidate() {
        assertEquals(TestSolution.NOT_APPLICABLE,
                consolidate("Rgaa32016.Test.12.06.02-4NA-01").getValue());
        assertEquals(TestSolution.NOT_TESTED,
                consolidate("Rgaa32016.Test.12.06.02-5NT-01").getValue());
    }

}
