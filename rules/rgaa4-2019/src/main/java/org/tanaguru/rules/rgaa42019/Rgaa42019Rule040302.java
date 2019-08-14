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

import static org.tanaguru.rules.keystore.AttributeStore.KIND_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.KIND_VALUE;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.MEDIA_ONLY_VIDEO_TRANS_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_KIND_VALUE_MSG;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.ruleimplementation.AbstractPageRuleWithSelectorAndCheckerImplementation;
import org.tanaguru.rules.elementchecker.attribute.AttributeWithValueOnChildElementPresenceChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;

/**
 * Implementation of the rule 4-3-2 of the referential Rgaa4 2019.
 *
 * @see <a href="http://www.example.com/refential-descriptor.html#test-4-3-2"> 4-3-2 rule specification</a>
 *
 * @author edaconceicao
 */

public class Rgaa42019Rule040302 extends AbstractPageRuleWithSelectorAndCheckerImplementation {

    /**
     * Default constructor
     */
    public Rgaa42019Rule040302 () {
    	super(new SimpleElementSelector(MEDIA_ONLY_VIDEO_TRANS_CSS_LIKE_QUERY),
                new AttributeWithValueOnChildElementPresenceChecker(
                        KIND_ATTR,
                        KIND_VALUE,
                        new ImmutablePair(TestSolution.PASSED, ""),
                        // the set is empty 
                        new ImmutablePair(TestSolution.FAILED, CHECK_KIND_VALUE_MSG)));
    }

}