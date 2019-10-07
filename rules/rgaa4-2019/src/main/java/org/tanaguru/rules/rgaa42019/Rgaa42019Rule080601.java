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

import static org.tanaguru.rules.keystore.CssLikeQueryStore.TITLE_WITHIN_HEAD_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_TITLE_PERTINENCE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.NOT_PERTINENT_TITLE_MSG;

import org.tanaguru.ruleimplementation.AbstractPageRuleWithSelectorAndCheckerImplementation;
import org.tanaguru.rules.elementchecker.pertinence.TextPertinenceChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;

/**
 * Implementation of the rule 8-6-1 of the referential Rgaa4 2019.
 *
 * @see <a href="http://www.example.com/refential-descriptor.html#test-8-6-1"> 8-6-1 rule specification</a>
 *
 * @author edaconceicao
 */

public class Rgaa42019Rule080601 extends AbstractPageRuleWithSelectorAndCheckerImplementation {

    /* Title blacklisted nomenclature */
    private static final String TITLE_BLACKLIST_NOM = "UnexplicitPageTitle";
    

    /**
     * Default constructor
     */
    public Rgaa42019Rule080601 () {
    	super(
            new SimpleElementSelector(TITLE_WITHIN_HEAD_CSS_LIKE_QUERY),
            new TextPertinenceChecker(
                // check emptiness
                true, 
                // no comparison with other attribute
                null, 
                // blacklist nomenclature name
                TITLE_BLACKLIST_NOM, 
                // not pertinent message
                NOT_PERTINENT_TITLE_MSG, 
                // manual check message
                CHECK_TITLE_PERTINENCE_MSG,
                // evidence elements
                TEXT_ELEMENT2
            )
        );
    }

}