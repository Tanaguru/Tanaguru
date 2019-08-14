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

import static org.tanaguru.rules.keystore.CssLikeQueryStore.LEGEND_WITHIN_FIELDSET_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_LEGEND_PERTINENCE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.NOT_PERTINENT_LEGEND_MSG;

import org.tanaguru.ruleimplementation.AbstractNotTestedRuleImplementation;
import org.tanaguru.ruleimplementation.AbstractPageRuleWithSelectorAndCheckerImplementation;
import org.tanaguru.rules.elementchecker.pertinence.TextPertinenceChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;

/**
 * Implementation of the rule 11-7-1 of the referential Rgaa4 2019.
 *
 * @see <a href="http://www.example.com/refential-descriptor.html#test-11-7-1"> 11-7-1 rule specification</a>
 *
 * @author edaconceicao
 */

public class Rgaa42019Rule110701 extends AbstractPageRuleWithSelectorAndCheckerImplementation {

    /**
     * Default constructor
     */
    public Rgaa42019Rule110701 () {
    	super (
                new SimpleElementSelector(LEGEND_WITHIN_FIELDSET_CSS_LIKE_QUERY), 
                new TextPertinenceChecker(
                   // check emptiness
                   true, 
                   // no comparison with other attributes
                   null, 
                   // no comparison with blacklist
                   null, 
                   //  message associated with element when not pertinent
                   NOT_PERTINENT_LEGEND_MSG, 
                   //message associated with element when pertinence cannot be determined
                   CHECK_LEGEND_PERTINENCE_MSG,
                   // evidence elements
                   TEXT_ELEMENT2)
           );
    }

}