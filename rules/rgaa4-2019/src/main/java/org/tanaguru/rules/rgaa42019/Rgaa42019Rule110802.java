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

import static org.tanaguru.rules.keystore.AttributeStore.LABEL_ATTR;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.OPTGROUP_WITHIN_SELECT_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.RemarkMessageStore.OPTGROUP_WITHOUT_LABEL_MSG;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.ruleimplementation.AbstractNotTestedRuleImplementation;
import org.tanaguru.ruleimplementation.AbstractPageRuleWithSelectorAndCheckerImplementation;
import org.tanaguru.rules.elementchecker.attribute.AttributePresenceChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;

/**
 * Implementation of the rule 11-8-2 of the referential Rgaa4 2019.
 *
 * @see <a href="http://www.example.com/refential-descriptor.html#test-11-8-2"> 11-8-2 rule specification</a>
 *
 * @author edaconceicao
 */

public class Rgaa42019Rule110802 extends AbstractPageRuleWithSelectorAndCheckerImplementation {

    /**
     * Default constructor
     */
    public Rgaa42019Rule110802 () {
    	super(
                new SimpleElementSelector(OPTGROUP_WITHIN_SELECT_CSS_LIKE_QUERY), 
                new AttributePresenceChecker(
                    // the attribute to search
                    LABEL_ATTR, 
                    // passed when attribute is found, empty message
                    new ImmutablePair(TestSolution.PASSED, ""),
                    // failed when attribute is not found
                    new ImmutablePair(TestSolution.FAILED, OPTGROUP_WITHOUT_LABEL_MSG)
                )
            );
    }

}