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
package org.tanaguru.ruleimplementation.impl.table;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.ruleimplementation.AbstractMarkerPageRuleImplementation;
import org.tanaguru.rules.elementchecker.IndependentChecker;
import org.tanaguru.rules.elementchecker.attribute.AttributeLinkedToElementTextPresenceChecker;
import org.tanaguru.rules.elementchecker.attribute.AttributePresenceChecker;
import org.tanaguru.rules.elementchecker.element.ChildElementPresenceChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;
import org.tanaguru.rules.keystore.HtmlElementStore;

import static org.tanaguru.rules.keystore.AttributeStore.*;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.DATA_TABLE_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.MarkerStore.*;
import static org.tanaguru.rules.keystore.RemarkMessageStore.*;

/**
 * Implementation of the rule 5-1-1 of the referential Rgaa4 2019.
 *
 * @see <a href="http://www.example.com/refential-descriptor.html#test-5-1-1"> 5-1-1 rule specification</a>
 *
 * @author edaconceicao
 */

public class ComplexDataTableHasSummary extends AbstractMarkerPageRuleImplementation {

    /**
     * Default constructor
     */
    public ComplexDataTableHasSummary() {
    	super(
                new SimpleElementSelector(DATA_TABLE_CSS_LIKE_QUERY), 

                // the complex tables are part of the scope
                new String[]{COMPLEX_TABLE_MARKER},

                // the data and presentation tables are not part of the scope
                new String[]{PRESENTATION_TABLE_MARKER, DATA_TABLE_MARKER},

                // checker for elements identified by marker
                new IndependentChecker(
                		new IndependentChecker(
                				//If attribute present, supposed the site is not in HTML5 so can be
                				//not applicable if not present
                				new AttributePresenceChecker(
                					SUMMARY_ATTR,
    				                new ImmutablePair(TestSolution.PASSED, ""),
    				                new ImmutablePair(TestSolution.NOT_APPLICABLE,"")),
                				//In HTML5, the table element should have a caption child element
                				new ChildElementPresenceChecker(
				                    HtmlElementStore.CAPTION_ELEMENT, 
				                    // the child element is supposed to appear at least once
				                    1,
				                    new ImmutablePair(TestSolution.PASSED, ""),
				                    new ImmutablePair(TestSolution.FAILED, CAPTION_MISSING_ON_COMPLEX_TABLE_MSG))),
                		new AttributeLinkedToElementTextPresenceChecker(
                				ARIA_DESCRIBEDBY_ATTR,
                				ID_ATTR,
			                    new ImmutablePair(TestSolution.PASSED, ""),
			                    new ImmutablePair(TestSolution.FAILED, SUMMARY_TEXT_MISSING_MSG),
			                    ID_ATTR,
			                    TEXT_ELEMENT2)),
                
                // checker for elements not identified by marker 
                new IndependentChecker(
                		new IndependentChecker(
		        				//If attribute present, supposed the site is not in HTML5 so can be
		        				//not applicable if not present
		        				new AttributePresenceChecker(
		        					SUMMARY_ATTR,
					                new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_NATURE_OF_TABLE_WITH_SUMMARY_MSG),
					                new ImmutablePair(TestSolution.NOT_APPLICABLE,""),SUMMARY_ATTR),
		        				//In HTML5, the table element should have a caption child element
		        				new ChildElementPresenceChecker(
		        	                HtmlElementStore.CAPTION_ELEMENT, 
		        	                // the child element is supposed to appear at least once
		        	                1,
		        	                new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_TABLE_WITH_CAPTION_IS_COMPLEX_MSG ),
		        	                new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_TABLE_WITHOUT_CAPTION_IS_NOT_COMPLEX_MSG))),
		        		new AttributeLinkedToElementTextPresenceChecker(
		        				ARIA_DESCRIBEDBY_ATTR,
		        				ID_ATTR,
			                    new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_NATURE_OF_TABLE_WITH_SUMMARY_TEXT_MSG),
			                    new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_NATURE_OF_TABLE_WITHOUT_SUMMARY_TEXT_MSG),
			                    ID_ATTR,
			                    TEXT_ELEMENT2)));
    }

}