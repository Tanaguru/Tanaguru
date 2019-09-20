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
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABEL_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ID_ATTR;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.DATA_TABLE_WITH_TITLE_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.HtmlElementStore.CAPTION_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.RemarkMessageStore.WRONG_TITLE_ASSOCIATION_WITH_TABLE;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.ruleimplementation.AbstractPageRuleWithSelectorAndCheckerImplementation;
import org.tanaguru.rules.elementchecker.CompositeChecker;
import org.tanaguru.rules.elementchecker.IndependentChecker;
import org.tanaguru.rules.elementchecker.attribute.AttributeLinkedToElementTextPresenceChecker;
import org.tanaguru.rules.elementchecker.attribute.AttributeOnChildElementPresenceChecker;
import org.tanaguru.rules.elementchecker.attribute.AttributePresenceChecker;
import org.tanaguru.rules.elementchecker.element.ChildElementPresenceChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;

/**
 * Implementation of the rule 5-4-1 of the referential Rgaa4 2019.
 *
 * @see <a href="http://www.example.com/refential-descriptor.html#test-5-4-1"> 5-4-1 rule specification</a>
 *
 * @author edaconceicao
 */

public class Rgaa42019Rule050401 extends AbstractPageRuleWithSelectorAndCheckerImplementation {

    /**
     * Default constructor
     */
    public Rgaa42019Rule050401 () {
        super(
        		new SimpleElementSelector(DATA_TABLE_WITH_TITLE_CSS_LIKE_QUERY),
        		
        		new IndependentChecker(
        				new ChildElementPresenceChecker(
        						CAPTION_ELEMENT,
		        				new ImmutablePair(TestSolution.PASSED,""),
		        				new ImmutablePair(TestSolution.NOT_APPLICABLE, "")),
        				new AttributeLinkedToElementTextPresenceChecker(
        						ARIA_LABELLEDBY_ATTR,
        						ID_ATTR,
		        				new ImmutablePair(TestSolution.PASSED,""),
		        				new ImmutablePair(TestSolution.NOT_APPLICABLE, ""))));
        
        
        IndependentChecker ic = (IndependentChecker) getElementChecker();
        CompositeChecker cc = new CompositeChecker(
				new AttributePresenceChecker(
						ARIA_LABEL_ATTR,
        				new ImmutablePair(TestSolution.FAILED, WRONG_TITLE_ASSOCIATION_WITH_TABLE),
        				new ImmutablePair(TestSolution.PASSED,""),ARIA_LABEL_ATTR),
				new AttributePresenceChecker(
						TITLE_ATTR,
        				new ImmutablePair(TestSolution.FAILED, WRONG_TITLE_ASSOCIATION_WITH_TABLE),
        				new ImmutablePair(TestSolution.PASSED,""),TITLE_ATTR));
        cc.setIsOrCombinaison(false);
        ic.addChecker(cc);
    }

}