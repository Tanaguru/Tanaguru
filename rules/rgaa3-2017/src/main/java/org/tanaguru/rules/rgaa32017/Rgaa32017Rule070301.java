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

import static org.tanaguru.entity.audit.TestSolution.PASSED;
import static org.tanaguru.entity.audit.TestSolution.FAILED;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.ELEMENT_WITH_ROLE_ATTR_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.RemarkMessageStore.TABINDEX_DETECTED_MSG;
import static org.tanaguru.rules.keystore.AttributeStore.TABINDEX_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ROLE_ATTR;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.ruleimplementation.AbstractPageRuleWithSelectorAndCheckerImplementation;
import org.tanaguru.rules.elementchecker.attribute.AttributePresenceChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;

/**
 * Implementation of the rule 7.3.1 of the referential Rgaa 3-2017.
 *
 * For more details about the implementation, refer to <a href="http://tanaguru-rules-rgaa3.readthedocs.org/en/latest/Rule-7-3-1">the rule 7.3.1 design page.</a>
 * @see <a href="http://references.modernisation.gouv.fr/referentiel-technique-0#test-7-3-1"> 7.3.1 rule specification</a>
 */

public class Rgaa32017Rule070301 extends AbstractPageRuleWithSelectorAndCheckerImplementation {
	    
    /**
     * Default constructor
     */
    public Rgaa32017Rule070301 () {
        super(
        		new SimpleElementSelector(ELEMENT_WITH_ROLE_ATTR_CSS_LIKE_QUERY),        		
		        new AttributePresenceChecker(
		        		TABINDEX_ATTR, 
		                // IF DETECTED
		        		new ImmutablePair(FAILED, TABINDEX_DETECTED_MSG),
		                // IF NOT DETECTED
		        		new ImmutablePair(PASSED,""),
		                // evidence elements
		                ROLE_ATTR,TABINDEX_ATTR));
    }

}