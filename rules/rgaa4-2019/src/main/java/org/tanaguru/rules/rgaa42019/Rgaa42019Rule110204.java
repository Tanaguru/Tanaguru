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

import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABELLEDBY_ATTR;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.INPUT_ELEMENT_WITH_ARIA_INSIDE_FORM_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.RemarkMessageStore.MANUAL_CHECK_ON_ELEMENTS_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.NOT_PERTINENT_TEXTUAL_CONTENT_MSG;

import org.tanaguru.ruleimplementation.AbstractPageRuleWithSelectorAndCheckerImplementation;
import org.tanaguru.rules.elementchecker.pertinence.AttributePertinenceChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;

/**
 * Implementation of the rule 11-2-4 of the referential Rgaa4 2019.
 *
 * @see <a href="http://www.example.com/refential-descriptor.html#test-11-2-4"> 11-2-4 rule specification</a>
 *
 * @author edaconceicao
 */

public class Rgaa42019Rule110204 extends AbstractPageRuleWithSelectorAndCheckerImplementation {

    /**
     * Default constructor
     */
    public Rgaa42019Rule110204 () {
    	super(
                new SimpleElementSelector(INPUT_ELEMENT_WITH_ARIA_INSIDE_FORM_CSS_LIKE_QUERY),
                new AttributePertinenceChecker(
                		ARIA_LABELLEDBY_ATTR,
                        // check emptiness
                		true, 
                        // no comparison with other attribute
                        null,
                        // no comparison with blacklist
                        null,
                        NOT_PERTINENT_TEXTUAL_CONTENT_MSG,
                        // manual check message
                        MANUAL_CHECK_ON_ELEMENTS_MSG,
                        // evidence element
                        ARIA_LABELLEDBY_ATTR)
            );
    }

}