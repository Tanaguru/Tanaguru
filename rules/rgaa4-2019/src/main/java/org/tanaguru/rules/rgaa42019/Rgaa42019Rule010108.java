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

import static org.tanaguru.rules.keystore.AttributeStore.DATA_ATTR;
import static org.tanaguru.rules.keystore.HtmlElementStore.CANVAS_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.MarkerStore.DECORATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.INFORMATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_NATURE_AND_PRESENCE_OF_ALTERNATIVE_MECHANISM_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_NATURE_OF_IMAGE;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_NATURE_OF_IMAGE_WITHOUT_TEXT_ALTERNATIVE;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_PRESENCE_OF_ALTERNATIVE_MECHANISM_FOR_INFORMATIVE_IMG_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.TEXT_ALTERNATIVE_MISSING;
import static org.tanaguru.rules.keystore.RemarkMessageStore.TEXT_ALTERNATIVE_MISSING;

import java.util.Collections;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.ruleimplementation.AbstractMarkerPageRuleImplementation;
import org.tanaguru.rules.elementchecker.IndependentChecker;
import org.tanaguru.rules.elementchecker.element.ElementPresenceChecker;
import org.tanaguru.rules.elementchecker.text.TextAlternativePresenceChecker;
import org.tanaguru.rules.elementchecker.text.TextEmptinessChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;
import org.tanaguru.rules.textbuilder.SimpleTextElementBuilder;

/**
 * Implementation of the rule 1-1-8 of the referential Rgaa4 2019.
 *
 * @see <a href="http://www.example.com/refential-descriptor.html#test-1-1-8"> 1-1-8 rule specification</a>
 *
 * @author edaconceicao
 */

public class Rgaa42019Rule010108 extends AbstractMarkerPageRuleImplementation {

    /**
     * Default constructor
     */
    public Rgaa42019Rule010108 () {
    	super(	
        		// the informative images are part of the scope
                INFORMATIVE_IMAGE_MARKER, 

                // the decorative images are not part of the scope
                DECORATIVE_IMAGE_MARKER);
    	
    	setElementSelector(new SimpleElementSelector(CANVAS_ELEMENT));
    	

		//initialize and set the checker for the marked elements
    	IndependentChecker ic = new IndependentChecker(
        				new TextAlternativePresenceChecker(
		                        new ImmutablePair(TestSolution.PASSED, ""),
		                        new ImmutablePair(TestSolution.FAILED, TEXT_ALTERNATIVE_MISSING),
		                        DATA_ATTR),
                        new TextEmptinessChecker(
                                new SimpleTextElementBuilder(),
                                new ImmutablePair(TestSolution.FAILED, TEXT_ALTERNATIVE_MISSING),
                                new ImmutablePair(TestSolution.PASSED, ""),
                                DATA_ATTR),
        				new ElementPresenceChecker(
                                new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_PRESENCE_OF_ALTERNATIVE_MECHANISM_FOR_INFORMATIVE_IMG_MSG),
                                new ImmutablePair(TestSolution.NOT_APPLICABLE,""),                                
                                DATA_ATTR,
                                TEXT_ELEMENT2));
    	setMarkerElementChecker(ic);
    	
    	
    	//initialize and set the checker for the regular elements	
    	ic = new IndependentChecker(
        				new TextAlternativePresenceChecker(
		                        new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_NATURE_OF_IMAGE),
		                        new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_NATURE_OF_IMAGE_WITHOUT_TEXT_ALTERNATIVE),
		                        DATA_ATTR),
                        new TextEmptinessChecker(
                                new SimpleTextElementBuilder(),
                                new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_NATURE_OF_IMAGE_WITHOUT_TEXT_ALTERNATIVE),
                                new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_NATURE_OF_IMAGE),
                                DATA_ATTR),
        				new ElementPresenceChecker(
                                new ImmutablePair(TestSolution.NEED_MORE_INFO,CHECK_NATURE_AND_PRESENCE_OF_ALTERNATIVE_MECHANISM_MSG),
                                new ImmutablePair(TestSolution.NOT_APPLICABLE,""),
                                DATA_ATTR,
                                TEXT_ELEMENT2));
    	setRegularElementChecker(ic);
    	
    }

}