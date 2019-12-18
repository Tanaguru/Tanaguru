/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2017  Tanaguru.org
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
import org.jsoup.nodes.Element;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.ruleimplementation.AbstractMarkerPageRuleImplementation;
import org.tanaguru.ruleimplementation.ElementHandler;
import org.tanaguru.ruleimplementation.ElementHandlerImpl;
import org.tanaguru.rules.elementchecker.CompositeChecker;
import org.tanaguru.rules.elementchecker.attribute.AttributeWithValuePresenceChecker;
import org.tanaguru.rules.elementchecker.text.TextAlternativePresenceChecker;
import org.tanaguru.rules.elementchecker.text.TextEmptinessChecker;
import org.tanaguru.rules.elementselector.ImageElementSelector;
import org.tanaguru.rules.textbuilder.SimpleTextElementBuilder;

import java.util.Collections;

import static org.tanaguru.entity.audit.TestSolution.NEED_MORE_INFO;
import static org.tanaguru.entity.audit.TestSolution.PASSED;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_HIDDEN_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.DATA_ATTR;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.OBJECT_TYPE_IMG_NOT_IN_LINK_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.MarkerStore.DECORATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.INFORMATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.RemarkMessageStore.*;


public class DecorativeImageObjectWithoutLegendHasAriaHiddenTrueAndNoAltTextAndNoTextUsedAsAltText extends AbstractMarkerPageRuleImplementation {


	/**
    * Contains all the decorative IMGECT elements without the "img" role
    */
    private final ElementHandler<Element> decorativeObjElementsWithoutAriaHidden
            = new ElementHandlerImpl();
    /**
    * Contains all the  IMGECT elements without the "img" role.
    */
    private final ElementHandler<Element> objElementsWithoutAriaHidden
            = new ElementHandlerImpl();
    /**
    *Contains all the IMGECT element with title attribute or child with title attribute
    */
    private final ElementHandler<Element> titleAttrOnObjOrChild
            = new ElementHandlerImpl();
     /**
    *Contains all the decorative IMGECT element with title attribute or child with title attribute
    */
    private final ElementHandler<Element> titleAttrOnDecorativeObjOrChild
            = new ElementHandlerImpl();
    /**
    *Contains suspected decorative IMGECT elements
    */
    private final ElementHandler<Element> decorativeObjElements
            = new ElementHandlerImpl();

    /**
    *Suspected decorative IMGECT elements
    */
    private final ElementHandler<Element> suspectedDecorativeObjElements
            = new ElementHandlerImpl();
    /**
    *Contains IMGECT elements with desc or title child
    */
    private final ElementHandler<Element> objElementsWithDescOrTitleChild
            = new ElementHandlerImpl();
    /**
    *Contains decorative IMGECT elements with desc or title child
    */
    private final ElementHandler<Element> decorativeObjElementsWithDescOrTitleChild
            = new ElementHandlerImpl();
    /*
    *Contains  IMGECT elements with arria attribute or on child
    */
    private final ElementHandler<Element> ariaAttrOnObjOrChild
            = new ElementHandlerImpl();
    /*
    *Contains decorative IMGECT elements with arria attribute or on child
    */
    private final ElementHandler<Element> ariaAttrOnDecorativeObjOrChild
            = new ElementHandlerImpl();


    /**
     * Constructor
     */
    public DecorativeImageObjectWithoutLegendHasAriaHiddenTrueAndNoAltTextAndNoTextUsedAsAltText() {
        super(	// the decorative images are part of the scope
                DECORATIVE_IMAGE_MARKER, 
                
                // the informative images are not part of the scope
                INFORMATIVE_IMAGE_MARKER); 
        
        setElementSelector(new ImageElementSelector(OBJECT_TYPE_IMG_NOT_IN_LINK_CSS_LIKE_QUERY, true, false));
    	
        
        // *************************** Marker Element
    	CompositeChecker ec = new CompositeChecker(
    			new AttributeWithValuePresenceChecker(
	                    // attribute name
	                    ARIA_HIDDEN_ATTR,
	                    //attribute value 
	                    "true",
	                    // solution when detected
	                    new ImmutablePair(TestSolution.PASSED, ""),
	                    // solution when not detected
	                    new ImmutablePair(TestSolution.FAILED, DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG),
	                    // evidence elements
                        DATA_ATTR),
    			
    			new TextEmptinessChecker(
                        // the text element builder
                        new SimpleTextElementBuilder(),
                        // solution when text is empty
                        new ImmutablePair(TestSolution.PASSED, ""), 
                        // solution when text is not empty
                        new ImmutablePair(TestSolution.FAILED, DECORATIVE_ELEMENT_WITH_NOT_EMPTY_ALT_MSG),
                        // evidence elements
                        TEXT_ELEMENT2,
                        DATA_ATTR),
				new TextAlternativePresenceChecker(
                        new ImmutablePair(TestSolution.FAILED, DECORATIVE_ELEMENT_WITH_TEXT_ALTERNATIVE_MSG),
                        new ImmutablePair(TestSolution.PASSED, "")
                )
			);
    	ec.setIsOrCombinaison(false);
    	setMarkerElementChecker(ec);
    	
    	
    	// *************************  No marker element
    	CompositeChecker cc = new CompositeChecker(
    			new AttributeWithValuePresenceChecker(
	                    // attribute name
	                    ARIA_HIDDEN_ATTR,
	                    //attribute value 
	                    "true",
	                    // solution when detected
	                    new ImmutablePair(TestSolution.PASSED, ""),
	                    // solution when not detected
	                    new ImmutablePair(TestSolution.NEED_MORE_INFO, SUSPECTED_DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG),
	                    // evidence elements
			            DATA_ATTR),
    			new TextEmptinessChecker(
			            // the text element builder
			            new SimpleTextElementBuilder(),
			            // solution when text is empty
			            new ImmutablePair(TestSolution.PASSED, ""),
			            // solution when text is not empty
			            new ImmutablePair(TestSolution.NEED_MORE_INFO, SUSPECTED_DECORATIVE_IMG_WITH_NOT_EMPTY_TEXT_ALT_MSG),
			            // evidence elements
			            TEXT_ELEMENT2,
			            DATA_ATTR),
                new TextAlternativePresenceChecker(
                        true,
                        // failed when text alternative found
                        new ImmutablePair(TestSolution.NEED_MORE_INFO,CHECK_NATURE_OF_IMAGE_WITH_TEXT_ALTERNATIVE),
                        // passed when text alternative is not found, empty message
                        new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_NATURE_OF_IMAGE)
                )
        );
    	cc.addCheckMessageFromSolution(
                 PASSED,
                 Collections.singletonMap(
                        NEED_MORE_INFO, 
                     	SUSPECTED_WELL_FORMATED_DECORATIVE_IMG));
    	cc.setIsOrCombinaison(false);
    	setRegularElementChecker(cc);	
			     
    }
}