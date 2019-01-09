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

package org.tanaguru.rules.rgaa32017;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.jsoup.nodes.Element;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.processor.SSPHandler;
import org.tanaguru.ruleimplementation.AbstractMarkerPageRuleImplementation;
import org.tanaguru.ruleimplementation.ElementHandler;
import org.tanaguru.ruleimplementation.ElementHandlerImpl;
import org.tanaguru.ruleimplementation.TestSolutionHandler;
import org.tanaguru.rules.elementchecker.CompositeChecker;
import org.tanaguru.rules.elementchecker.ElementChecker;
import org.tanaguru.rules.elementchecker.attribute.AttributeOnChildElementPresenceChecker;
import org.tanaguru.rules.elementchecker.attribute.AttributePresenceChecker;
import org.tanaguru.rules.elementchecker.attribute.AttributeWithValuePresenceChecker;
import org.tanaguru.rules.elementchecker.element.ElementPresenceChecker;
import org.tanaguru.rules.elementchecker.text.TextEmptinessChecker;
import org.tanaguru.rules.elementselector.ImageElementSelector;
import org.tanaguru.rules.keystore.RemarkMessageStore;
import org.tanaguru.rules.textbuilder.SimpleTextElementBuilder;

import static org.tanaguru.entity.audit.TestSolution.FAILED;
import static org.tanaguru.entity.audit.TestSolution.NEED_MORE_INFO;
import static org.tanaguru.entity.audit.TestSolution.NOT_APPLICABLE;
import static org.tanaguru.entity.audit.TestSolution.PASSED;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_DESCRIBEDBY_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_HIDDEN_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABELLEDBY_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABEL_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.DATA_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.ARIA_DESCRIBEDBY_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.ARIA_LABELLEDBY_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.ARIA_LABEL_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.NOT_EMPTY_ARIA_TITLE_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.OBJECT_TYPE_IMG_NOT_IN_LINK_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.HtmlElementStore.TITLE_ELEMENT;
import static org.tanaguru.rules.keystore.MarkerStore.DECORATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.INFORMATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITH_NOT_EMPTY_ALT_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.SUSPECTED_DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.SUSPECTED_DECORATIVE_IMG_WITH_NOT_EMPTY_TEXT_ALT_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_IMG_OR_CHILDREN_WITH_ARIA_ATTRIBUTE;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_IMG_OR_CHILD_WITH_TITLE_ATTRIBUTE;
import static org.tanaguru.rules.keystore.RemarkMessageStore.SUSPECTED_DECORATIVE_IMG_WITH_ARIA_ATTRIBUTE_DETECTED_ON_ELEMENT_OR_CHILD;
import static org.tanaguru.rules.keystore.RemarkMessageStore.SUSPECTED_DECORATIVE_IMG_WITH_TITLE_ATTRIBUTE_ON_ELEMENT_OR_CHILD;
import static org.tanaguru.rules.keystore.RemarkMessageStore.SUSPECTED_WELL_FORMATED_DECORATIVE_IMG;

import java.util.Collections;


/**
 * Implementation of the rule 1.2.3 of the referential Rgaa 3-2017.
 * <br/>
 * For more details about the implementation, refer to <a href="http://tanaguru-rules-rgaa3.readthedocs.org/en/latest/Rule-1-2-3">the rule 1.2.3 design page.</a>
 * @see <a href="http://references.modernisation.gouv.fr/referentiel-technique-0#test-1-2-3"> 1.2.3 rule specification</a>
 *
 */
public class Rgaa32017Rule010203 extends AbstractMarkerPageRuleImplementation {
	
	
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
    public Rgaa32017Rule010203() {
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
    			new AttributePresenceChecker(
    					ARIA_LABEL_ATTR,
    					new ImmutablePair(FAILED, DECORATIVE_IMG_OR_CHILDREN_WITH_ARIA_ATTRIBUTE),
    					new ImmutablePair(PASSED, ""),
		                ARIA_LABEL_ATTR),
         
			          //checker sur la présence de l'attribut aria-labelledby
    			new AttributePresenceChecker(
			            ARIA_LABELLEDBY_ATTR,
			            new ImmutablePair(FAILED, DECORATIVE_IMG_OR_CHILDREN_WITH_ARIA_ATTRIBUTE),
			            new ImmutablePair(PASSED, ""),
			            ARIA_LABELLEDBY_ATTR),
			          
    			//checker sur la présence de l'attribut aria-describedby
			    new AttributePresenceChecker(
			            ARIA_DESCRIBEDBY_ATTR,
			            new ImmutablePair(FAILED, DECORATIVE_IMG_OR_CHILDREN_WITH_ARIA_ATTRIBUTE),
			            new ImmutablePair(PASSED, ""),
			            ARIA_DESCRIBEDBY_ATTR),
			    
			    //checker la présence de l'attribut title sur les elements enfant de object
			    new AttributeOnChildElementPresenceChecker(
		          		TITLE_ATTR,
		                new ImmutablePair(FAILED, DECORATIVE_IMG_OR_CHILD_WITH_TITLE_ATTRIBUTE),
		                new ImmutablePair(PASSED, ""),
		                TITLE_ATTR),
			    
			    //checker la presence de l'attribut title 
			    new AttributePresenceChecker(
			    		TITLE_ATTR,
		               	new ImmutablePair(TestSolution.FAILED, DECORATIVE_IMG_OR_CHILD_WITH_TITLE_ATTRIBUTE),
		               	new ImmutablePair(TestSolution.PASSED, ""),
		               	TITLE_ATTR));
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
    			new AttributePresenceChecker(
		                ARIA_LABEL_ATTR,
		                new ImmutablePair(TestSolution.NEED_MORE_INFO, SUSPECTED_DECORATIVE_IMG_WITH_ARIA_ATTRIBUTE_DETECTED_ON_ELEMENT_OR_CHILD),
		                new ImmutablePair(TestSolution.PASSED, ""),
		                ARIA_LABEL_ATTR),
		          
    			//checker sur la présence de l'attribut aria-labelledby
    			new AttributePresenceChecker(
		                ARIA_LABELLEDBY_ATTR,
		                new ImmutablePair(TestSolution.NEED_MORE_INFO, SUSPECTED_DECORATIVE_IMG_WITH_ARIA_ATTRIBUTE_DETECTED_ON_ELEMENT_OR_CHILD),
		                new ImmutablePair(TestSolution.PASSED, ""),
		                ARIA_LABELLEDBY_ATTR),
		          
    			//checker sur la présence de l'attribut aria-describedby
    			new AttributePresenceChecker(
		                ARIA_DESCRIBEDBY_ATTR,
		                new ImmutablePair(TestSolution.NEED_MORE_INFO, SUSPECTED_DECORATIVE_IMG_WITH_ARIA_ATTRIBUTE_DETECTED_ON_ELEMENT_OR_CHILD),
		                new ImmutablePair(TestSolution.PASSED, ""),
		                ARIA_DESCRIBEDBY_ATTR),
    			
			    //checker la présence de l'attribut title sur les elements enfant de object
    			new AttributeOnChildElementPresenceChecker(
		            	TITLE_ATTR,
		                new ImmutablePair(NEED_MORE_INFO, SUSPECTED_DECORATIVE_IMG_WITH_TITLE_ATTRIBUTE_ON_ELEMENT_OR_CHILD),
		                new ImmutablePair(PASSED, ""),
		                TITLE_ATTR),
			    
			    //checker la presence de l'attribut title
    			new AttributePresenceChecker(
	    				TITLE_ATTR,
		                new ImmutablePair(NEED_MORE_INFO, SUSPECTED_DECORATIVE_IMG_WITH_TITLE_ATTRIBUTE_ON_ELEMENT_OR_CHILD),
		                new ImmutablePair(TestSolution.PASSED, ""),
		                TITLE_ATTR));
    	cc.addCheckMessageFromSolution(
                 PASSED,
                 Collections.singletonMap(
                        NEED_MORE_INFO, 
                     	SUSPECTED_WELL_FORMATED_DECORATIVE_IMG));
    	cc.setIsOrCombinaison(false);
    	setRegularElementChecker(cc);	
			     
    }
}