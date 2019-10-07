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

import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.entity.reference.Test;
import org.tanaguru.ruleimplementation.AbstractDetectionPageRuleImplementation;
import org.tanaguru.rules.elementselector.SimpleElementSelector;
import org.tanaguru.rules.elementchecker.helper.RuleCheckHelper;

import static org.tanaguru.rules.keystore.CssLikeQueryStore.CHANGE_CONTEXT_SCRIPT_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CONTEXT_CHANGED_SCRIPT_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.NO_PATTERN_DETECTED_MSG;

/**
 * Implementation of the rule 7-4-1 of the referential Rgaa4 2019.
 *
 * @see <a href="http://www.example.com/refential-descriptor.html#test-7-4-1"> 7-4-1 rule specification</a>
 *
 * @author edaconceicao
 */

public class Rgaa42019Rule070401 extends AbstractDetectionPageRuleImplementation {

    /**
     * Default constructor
     */
    public Rgaa42019Rule070401 () {
    	super(
                new SimpleElementSelector(CHANGE_CONTEXT_SCRIPT_CSS_LIKE_QUERY),
                // solution when at least one element is found
                TestSolution.NEED_MORE_INFO,
                // solution when no element is found
                TestSolution.NEED_MORE_INFO,
                // detected message
                CONTEXT_CHANGED_SCRIPT_MSG,
                // not detected message (set 
                null
            );
    }
    
    @Override
    public void setTest(Test test) {
        super.setTest(test);
        // set the not detected message after instanciation to make it
        // rule-specific
        getElementPresenceChecker().setMessageCodeOnElementNotDetected(
                RuleCheckHelper.specifyMessageToRule(
                    NO_PATTERN_DETECTED_MSG, 
                    this.getTest().getCode()));
    }

}