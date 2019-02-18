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
import org.tanaguru.ruleimplementation.AbstractPageRuleWithSelectorAndCheckerImplementation;
import org.tanaguru.rules.elementchecker.CompositeChecker;
import org.tanaguru.rules.elementchecker.attribute.AttributePresenceChecker;
import org.tanaguru.rules.elementchecker.text.TextNotIdenticalToAttributeChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;
import org.tanaguru.rules.textbuilder.TextAttributeOfElementBuilder;

import static org.tanaguru.entity.audit.TestSolution.FAILED;
import static org.tanaguru.entity.audit.TestSolution.PASSED;
import static org.tanaguru.rules.keystore.AttributeStore.PLACEHOLDER_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.FORM_WITH_TITLE_ATTR_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.RemarkMessageStore.TITLE_NOT_IDENTICAL_PLACEHOLDER;

/**
 *
 * @author tanaguru
 */

/**
 * Implementation of the rule 11.01.05 of the referential Rgaa 3-2017.
 *
 * For more details about the implementation, refer to <a href="http://tanaguru-rules-rgaa3.readthedocs.org/en/latest/Rule-11-01-05">the rule 11.01.05 design page.</a>
 * @see <a href="http://references.modernisation.gouv.fr/referentiel-technique-0#test-11-10-10"> 11.01.05 rule specification</a>
 */

public class Rgaa32017Rule110105 extends AbstractPageRuleWithSelectorAndCheckerImplementation {

    /**
     * Default constructor
     */
    //FORM_ARIA_CSS_LIKE_QUERY
    public Rgaa32017Rule110105 () {
       super(new SimpleElementSelector(FORM_WITH_TITLE_ATTR_CSS_LIKE_QUERY),
    		   new CompositeChecker(
    				   new AttributePresenceChecker(
    	    				   PLACEHOLDER_ATTR,
    	                       new ImmutablePair(FAILED, ""), // the attribute exists but we need to know if it's identical to the title
    	    				   new ImmutablePair(PASSED,""), // the attribute doesn't exist so it's passed
    	    				   PLACEHOLDER_ATTR),
		    		   new TextNotIdenticalToAttributeChecker(
		                       new TextAttributeOfElementBuilder(PLACEHOLDER_ATTR),
		                       new TextAttributeOfElementBuilder(TITLE_ATTR),
		                       new ImmutablePair(PASSED,""), // placeholder == title - passed
		                       new ImmutablePair(FAILED, TITLE_NOT_IDENTICAL_PLACEHOLDER), // placeholder != title - failed
		                       // evidence elements
		                       PLACEHOLDER_ATTR, 
		                       TITLE_ATTR)));
    }

}