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

import static org.tanaguru.rules.keystore.CssLikeQueryStore.ROLE_IMG_LIKE_QUERY;
import static org.tanaguru.rules.keystore.HtmlElementStore.IMG_ELEMENT;
import static org.tanaguru.rules.keystore.MarkerStore.DECORATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.INFORMATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_NATURE_OF_IMAGE;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_NATURE_OF_IMAGE_WITH_TEXT_ALTERNATIVE;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITH_TEXT_ALTERNATIVE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITHOUT_ROLE_PRESENTATION_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.SUSPECTED_DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.SUSPECTED_DECORATIVE_ELEMENT_WITHOUT_ROLE_PRESENTATION_MSG;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_HIDDEN_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ROLE_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.SRC_ATTR;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.ruleimplementation.AbstractMarkerPageRuleImplementation;
import org.tanaguru.rules.elementchecker.CompositeChecker;
import org.tanaguru.rules.elementchecker.IndependentChecker;
import org.tanaguru.rules.elementchecker.attribute.AttributePresenceChecker;
import org.tanaguru.rules.elementchecker.attribute.AttributeWithValuePresenceChecker;
import org.tanaguru.rules.elementchecker.text.TextAlternativePresenceChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;

/**
 * Implementation of the rule 1-2-1 of the referential Rgaa4 2019.
 *
 * @see <a href="http://www.example.com/refential-descriptor.html#test-1-2-1"> 1-2-1 rule specification</a>
 *
 * @author edaconceicao
 */

public class Rgaa42019Rule010201 extends AbstractMarkerPageRuleImplementation {

    /**
     * Default constructor
     */
    public Rgaa42019Rule010201 () {
    	super(new SimpleElementSelector(IMG_ELEMENT+","+ROLE_IMG_LIKE_QUERY), 

                // the decorative images are not part of the scope
                DECORATIVE_IMAGE_MARKER, 
        		
        		// the informative images are part of the scope
                INFORMATIVE_IMAGE_MARKER, 

        		new IndependentChecker(        				
        				new CompositeChecker(
        						//Check first if the attribute presence before to check its value
        						new AttributePresenceChecker(
        								ARIA_HIDDEN_ATTR, 
        								new ImmutablePair(TestSolution.PASSED, ""),
        		                        new ImmutablePair(TestSolution.NOT_APPLICABLE, "")),
        						//Compare the attribute value with the value expected
        						new AttributeWithValuePresenceChecker(
        								ARIA_HIDDEN_ATTR,
        								"true",
        								new ImmutablePair(TestSolution.PASSED, ""),
        		                        new ImmutablePair(TestSolution.FAILED, DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG),
        		                        SRC_ATTR,
        		                        ARIA_HIDDEN_ATTR)),
        				
        				new CompositeChecker(
        						//Check first if the attribute presence before to check its value
        						new AttributePresenceChecker(
        								ROLE_ATTR, 
        								new ImmutablePair(TestSolution.PASSED, ""),
        		                        new ImmutablePair(TestSolution.NOT_APPLICABLE, "")),
        						//Compare the attribute value with the value expected
        						new AttributeWithValuePresenceChecker(
        								ROLE_ATTR,
        								"presentation",
        								new ImmutablePair(TestSolution.PASSED, ""),
        		                        new ImmutablePair(TestSolution.FAILED, DECORATIVE_ELEMENT_WITHOUT_ROLE_PRESENTATION_MSG),
        		                        SRC_ATTR,
        		                        ROLE_ATTR)),
        				
        				new TextAlternativePresenceChecker(
        						true,
		                        // failed when text alternative found 
		                        new ImmutablePair(TestSolution.FAILED, DECORATIVE_ELEMENT_WITH_TEXT_ALTERNATIVE_MSG),
		                        // passed when text alternative is not found, empty message
		                        new ImmutablePair(TestSolution.PASSED, ""))),
        		
        		
        		
        		new IndependentChecker(
        				new CompositeChecker(
        						//Check first if the attribute presence before to check its value
        						new AttributePresenceChecker(
        								ARIA_HIDDEN_ATTR, 
        								new ImmutablePair(TestSolution.PASSED, ""),
        		                        new ImmutablePair(TestSolution.NOT_APPLICABLE, "")),
        						//Compare the attribute value with the value expected
        						new AttributeWithValuePresenceChecker(
        								ARIA_HIDDEN_ATTR,
        								"true",
        		                        new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_NATURE_OF_IMAGE),
        		                        new ImmutablePair(TestSolution.NEED_MORE_INFO, SUSPECTED_DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG),   
        		                        SRC_ATTR,     		                        
        		                        ARIA_HIDDEN_ATTR)),
        				
        				new CompositeChecker(
        						//Check first if the attribute presence before to check its value
        						new AttributePresenceChecker(
        								ROLE_ATTR, 
        								new ImmutablePair(TestSolution.PASSED, ""),
        		                        new ImmutablePair(TestSolution.NOT_APPLICABLE, "")),
        						//Compare the attribute value with the value expected
        						new AttributeWithValuePresenceChecker(
        								ROLE_ATTR,
        								"presentation",
        		                        new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_NATURE_OF_IMAGE),
        		                        new ImmutablePair(TestSolution.NEED_MORE_INFO, SUSPECTED_DECORATIVE_ELEMENT_WITHOUT_ROLE_PRESENTATION_MSG),
        		                        SRC_ATTR,
        		                        ROLE_ATTR)),
        				
        				new TextAlternativePresenceChecker(
        						true,
                                // failed when text alternative found 
                                new ImmutablePair(TestSolution.NEED_MORE_INFO,CHECK_NATURE_OF_IMAGE_WITH_TEXT_ALTERNATIVE),
                                // passed when text alternative is not found, empty message
                                new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_NATURE_OF_IMAGE))));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}