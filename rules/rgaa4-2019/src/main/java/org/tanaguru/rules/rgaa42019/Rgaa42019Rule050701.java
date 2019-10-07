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

import java.util.Collections;

import static org.tanaguru.rules.keystore.AttributeStore.ROLE_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.SCOPE_ATTR;
import static org.tanaguru.rules.keystore.HtmlElementStore.TH_ELEMENT;
import static org.tanaguru.entity.audit.TestSolution.NEED_MORE_INFO;
import static org.tanaguru.entity.audit.TestSolution.FAILED;
import static org.tanaguru.entity.audit.TestSolution.PASSED;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.ruleimplementation.AbstractPageRuleWithSelectorAndCheckerImplementation;
import org.tanaguru.rules.elementchecker.IndependentChecker;
import org.tanaguru.rules.elementchecker.attribute.AttributePresenceChecker;
import org.tanaguru.rules.elementchecker.attribute.AttributeWithValuePresenceChecker;
import org.tanaguru.rules.elementchecker.attribute.IdUnicityChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;
import org.tanaguru.rules.keystore.RemarkMessageStore;

/**
 * Implementation of the rule 5-7-1 of the referential Rgaa4 2019.
 *
 * @see <a href="http://www.example.com/refential-descriptor.html#test-5-7-1"> 5-7-1 rule specification</a>
 *
 * @author edaconceicao
 */

public class Rgaa42019Rule050701 extends AbstractPageRuleWithSelectorAndCheckerImplementation {

    /**
     * Default constructor
     */
    public Rgaa42019Rule050701 () {
        super(new SimpleElementSelector(TH_ELEMENT),
        		new IndependentChecker(
        				new IdUnicityChecker(""),
        				new AttributePresenceChecker(
        						SCOPE_ATTR,
        						new ImmutablePair(TestSolution.PASSED,""),
        						new ImmutablePair(TestSolution.FAILED,"")),
        				new AttributeWithValuePresenceChecker(
        						ROLE_ATTR,
        						"rowheader",
        						new ImmutablePair(TestSolution.PASSED,""),
        						new ImmutablePair(TestSolution.FAILED,"")),
        				new AttributeWithValuePresenceChecker(
        						ROLE_ATTR,
        						"columnheader",
        						new ImmutablePair(TestSolution.PASSED,""),
        						new ImmutablePair(TestSolution.FAILED,""))));
        
        IndependentChecker ic = (IndependentChecker) getElementChecker();
        ic.addCheckMessageFromSolution(
        		PASSED,
		        Collections.singletonMap(
		                NEED_MORE_INFO, 
		                RemarkMessageStore.SUSPECTED_HEADERS_WELL_FORMED_COVER_WHOLE_ELEMENT_MSG));
        ic.addCheckMessageFromSolution(
        		FAILED,
		        Collections.singletonMap(
		                NEED_MORE_INFO, 
		                RemarkMessageStore.SUSPECTED_HEADERS_NOT_COVER_WHOLE_ELEMENT_MSG));
    }

}