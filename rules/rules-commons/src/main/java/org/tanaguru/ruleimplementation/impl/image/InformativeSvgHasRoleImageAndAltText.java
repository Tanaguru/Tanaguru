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
package org.tanaguru.ruleimplementation.impl.image;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.ruleimplementation.AbstractMarkerPageRuleImplementation;
import org.tanaguru.rules.elementchecker.CompositeChecker;
import org.tanaguru.rules.elementchecker.attribute.AttributeWithValuePresenceChecker;
import org.tanaguru.rules.elementchecker.text.TextAlternativePresenceChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;

import java.util.Collections;

import static org.tanaguru.rules.keystore.AttributeStore.ROLE_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.XMLNS_ATTR;
import static org.tanaguru.rules.keystore.HtmlElementStore.SVG_ELEMENT;
import static org.tanaguru.rules.keystore.MarkerStore.DECORATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.INFORMATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.RemarkMessageStore.*;

/**
 * Implementation of the rule 1-1-5 of the referential Rgaa4 2019.
 *
 * @see <a href="http://www.example.com/refential-descriptor.html#test-1-1-5"> 1-1-5 rule specification</a>
 *
 * @author edaconceicao
 */

public class InformativeSvgHasRoleImageAndAltText extends AbstractMarkerPageRuleImplementation {

    /**
     * Default constructor
     */
    public InformativeSvgHasRoleImageAndAltText() {
    	super(
        		// the informative images are part of the scope
                INFORMATIVE_IMAGE_MARKER, 

                // the decorative images are not part of the scope
                DECORATIVE_IMAGE_MARKER); 
    	

    	//initialize the selector
    	setElementSelector(new SimpleElementSelector(SVG_ELEMENT));
        		
    	
    	//initialize and set the checker for the marked elements
    	setMarkerElementChecker(new CompositeChecker(
        				new AttributeWithValuePresenceChecker(
        						ROLE_ATTR,
        						"img",
        						new ImmutablePair(TestSolution.PASSED, ""),
        						new ImmutablePair(TestSolution.FAILED, SVG_WITHOUT_ROLE_IMAGE_MSG),
        						ROLE_ATTR),
        				new TextAlternativePresenceChecker(
                        // when text alternative is found 
                        new ImmutablePair(TestSolution.PASSED, ""),
                        // when attribute is not found 
                        new ImmutablePair(TestSolution.FAILED, TEXT_ALTERNATIVE_MISSING),
                        XMLNS_ATTR)));
        
    	
    	
    	//initialize the checker for the regular elements	
    	CompositeChecker cc = 
    			new CompositeChecker(
        				new AttributeWithValuePresenceChecker(
        						ROLE_ATTR,
        						"img",
        						new ImmutablePair(TestSolution.PASSED, ""),
        						new ImmutablePair(TestSolution.NEED_MORE_INFO, SUSPECTED_INFORMATIVE_SVG_ROLE_IMAGE_MISSING_ON_SVG),
        						ROLE_ATTR),
        				new TextAlternativePresenceChecker(
                        // when text alternative is found 
                        new ImmutablePair(TestSolution.PASSED, ""),
                        // when attribute is not found 
                        new ImmutablePair(TestSolution.NEED_MORE_INFO,CHECK_NATURE_OF_IMAGE_WITHOUT_TEXT_ALTERNATIVE),XMLNS_ATTR));
    	
    	//set the message for the suspected passed elements
    	cc.addCheckMessageFromSolution(
    			TestSolution.PASSED, 
    			Collections.singletonMap(TestSolution.NEED_MORE_INFO, CHECK_NATURE_OF_IMAGE));
    	
    	//set the checker for the regular elements
    	setRegularElementChecker(cc);    	
    }
}