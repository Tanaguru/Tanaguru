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

import java.util.Collections;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.jsoup.nodes.Element;

import static org.tanaguru.entity.audit.TestSolution.FAILED;
import static org.tanaguru.entity.audit.TestSolution.NEED_MORE_INFO;
import static org.tanaguru.entity.audit.TestSolution.PASSED;

import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.processor.SSPHandler;
import org.tanaguru.ruleimplementation.AbstractMarkerPageRuleImplementation;
import org.tanaguru.ruleimplementation.ElementHandler;
import org.tanaguru.ruleimplementation.ElementHandlerImpl;
import org.tanaguru.ruleimplementation.TestSolutionHandler;
import org.tanaguru.rules.elementchecker.CompositeChecker;
import org.tanaguru.rules.elementchecker.ElementChecker;
import org.tanaguru.rules.elementchecker.pertinence.AttributePertinenceChecker;
import org.tanaguru.rules.elementchecker.text.TextNotIdenticalToAttributeChecker;
import org.tanaguru.rules.elementselector.AreaElementSelector;
import org.tanaguru.rules.elementselector.ImageElementSelector;
import org.tanaguru.rules.elementselector.SimpleElementSelector;

import static org.tanaguru.rules.keystore.AttributeStore.ALT_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABELLEDBY_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABEL_ATTR;
import static org.tanaguru.rules.keystore.RemarkMessageStore.*;
import static org.tanaguru.rules.keystore.AttributeStore.HREF_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.SRC_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ID_ATTR;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.MarkerStore.DECORATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.INFORMATIVE_IMAGE_MARKER;
import org.tanaguru.rules.keystore.RemarkMessageStore;
import org.tanaguru.rules.textbuilder.TextAttributeOfElementBuilder;

/**
 * Implementation of the rule 1.3.2 of the referential Rgaa 3-2017.
 * <br/>
 * For more details about the implementation, refer to <a
 * href="http://tanaguru-rules-rgaa3.readthedocs.org/en/latest/Rule-1-3-2">the rule 1.3.2
 * design page.</a>
 *
 * @see <a
 * href="http://references.modernisation.gouv.fr/referentiel-technique-0#test-1-3-2">
 * 1.3.2 rule specification</a>
 *
 */
public class Rgaa32017Rule010302 extends AbstractMarkerPageRuleImplementation {

	ElementHandler<Element> elementAriaMarker = new ElementHandlerImpl();
	ElementHandler<Element> elementAria = new ElementHandlerImpl();
	ElementHandler<Element> elementMarkerWithAriaLabelledby = new ElementHandlerImpl();
	ElementHandler<Element> elementWithAriaLabelledby = new ElementHandlerImpl();
	
    /**
     * The name of the nomenclature that handles the image file extensions
     */
    private static final String IMAGE_FILE_EXTENSION_NOM = "ImageFileExtensions";

    /**
     * Constructor
     */
    public Rgaa32017Rule010302() {
        super(
                // the informative images are part of the scope
                INFORMATIVE_IMAGE_MARKER,
                // the decorative images are not part of the scope
                DECORATIVE_IMAGE_MARKER);
        setElementSelector(
                new ImageElementSelector(
                        new AreaElementSelector(true, false, false), true, false));

        // checker for elements identified by marker
        setMarkerElementChecker(getMarkerElementChecker());
        
        // checker for elements not identified by marker
        setElementChecker(getLocalRegularElementChecker());
    }

    /**
     * 
     * @return the checker user for marked elements
     */
    private ElementChecker getMarkerElementChecker() {
        CompositeChecker ec = new CompositeChecker(
                    // checker for elements identified by marker
                    new AttributePertinenceChecker(
                        ALT_ATTR,
                        // check emptiness
                        true,
                        // compare with src attribute
                        new TextAttributeOfElementBuilder(HREF_ATTR),
                        // compare attribute value with nomenclature
                        IMAGE_FILE_EXTENSION_NOM,
                        // not pertinent message
                        NOT_PERTINENT_ALT_MSG,
                        // manual check message
                        CHECK_ALT_PERTINENCE_OF_INFORMATIVE_IMG_MSG,
                        // evidence elements
                        ALT_ATTR, 
                        HREF_ATTR),
                    new TextNotIdenticalToAttributeChecker(
                        new TextAttributeOfElementBuilder(TITLE_ATTR),
                        new TextAttributeOfElementBuilder(ALT_ATTR),
                        new ImmutablePair(PASSED,""),
                        new ImmutablePair(FAILED,TITLE_NOT_IDENTICAL_TO_ALT_MSG),
                        // evidence elements
                        ALT_ATTR, 
                        TITLE_ATTR, 
                        HREF_ATTR),
  				  new TextNotIdenticalToAttributeChecker(
		                new TextAttributeOfElementBuilder(ARIA_LABEL_ATTR),
		                new TextAttributeOfElementBuilder(ALT_ATTR),
		                new ImmutablePair(TestSolution.PASSED, ""),
		                new ImmutablePair(TestSolution.FAILED, ARIA_LABEL_NOT_IDENTICAL_TO_ALT_MSG),
		                ALT_ATTR,
		                ARIA_LABEL_ATTR,
		                HREF_ATTR));
        ec.setIsOrCombinaison(false);
        return ec;
    }
    
    /**
     * 
     * @return the checker user for not marked elements
     */
    private ElementChecker getLocalRegularElementChecker() {
        
        CompositeChecker compositeChecker = 
        	
        	new CompositeChecker(
        		new AttributePertinenceChecker(
                        ALT_ATTR,
                        // check emptiness
                        false,
                        // compare with src attribute
                        new TextAttributeOfElementBuilder(HREF_ATTR),
                        // compare attribute value with nomenclature
                        IMAGE_FILE_EXTENSION_NOM,
                        // solution when not pertinent
                        FAILED,
                        // not pertinent message
                        NOT_PERTINENT_ALT_MSG,
                        // manual check message
                        RemarkMessageStore.CHECK_NATURE_OF_IMAGE_AND_ALT_PERTINENCE_MSG,
                        ALT_ATTR, 
                        HREF_ATTR),
                new TextNotIdenticalToAttributeChecker(
                        new TextAttributeOfElementBuilder(TITLE_ATTR),
                        new TextAttributeOfElementBuilder(ALT_ATTR),
                        new ImmutablePair(NEED_MORE_INFO,""),
                        new ImmutablePair(NEED_MORE_INFO,CHECK_NATURE_OF_IMAGE_WITH_NOT_PERTINENT_ALT_MSG),
                        ALT_ATTR, 
                        TITLE_ATTR, 
                        HREF_ATTR),
                new TextNotIdenticalToAttributeChecker(
                        new TextAttributeOfElementBuilder(ARIA_LABEL_ATTR),
                        new TextAttributeOfElementBuilder(ALT_ATTR),
                    	new ImmutablePair(NEED_MORE_INFO, ""),
                    	new ImmutablePair(NEED_MORE_INFO, CHECK_NATURE_OF_IMAGE_WITH_NOT_PERTINENT_ALT_MSG),
                        ALT_ATTR, 
                        ARIA_LABEL_ATTR, 
                        HREF_ATTR));
        
        compositeChecker.setIsOrCombinaison(false);        
        return compositeChecker;
    }
    
    
    protected void select(SSPHandler sspHandler) {
    	super.select(sspHandler); 	
    	
    	//get aria-labelledby attributes
    	if(!getSelectionWithoutMarkerHandler().isEmpty()) {
			for(Element el : getSelectionWithoutMarkerHandler().get()) {
				if(el.hasAttr(ARIA_LABELLEDBY_ATTR)) {
					elementAria.add(el);
				}
			}
    	}
		if(!getSelectionWithMarkerHandler().isEmpty()) {
			for(Element el : getSelectionWithMarkerHandler().get()) {
				if(el.hasAttr(ARIA_LABELLEDBY_ATTR)) {
					elementAriaMarker.add(el);
				}
			}
		}		
		
		//Select elements have got id attribute
		ElementHandler<Element> elementPage = new ElementHandlerImpl();
    	SimpleElementSelector ses = new SimpleElementSelector("*[id]:not(area)"); //select all element with an id except canvas elements
    	ses.selectElements(sspHandler, elementPage);    	
    	    	
    	//select elements have id/aria-labelledby identical
    	for (Element el : elementPage.get()) {
        	for(Element elemAria : elementAriaMarker.get()) {    
				if(elemAria.attr(ARIA_LABELLEDBY_ATTR).equals(el.id())) { //ID == ARIA-LABELLEDBY
//					System.out.println(el);
					elementMarkerWithAriaLabelledby.add(el);
					break;
				}
        	}
            for(Element elemAria : elementAria.get()) {
    			if(elemAria.attr(ARIA_LABELLEDBY_ATTR).equals(el.id())) { //ID == ARIA-LABELLEDBY
    				elementWithAriaLabelledby.add(el);
					break;
    			}
            }
		}
    	
    }
    
    protected void check(SSPHandler sspHandler,
            TestSolutionHandler testSolutionHandler) {

    	super.check(sspHandler, testSolutionHandler); 
    	
    	if(!elementMarkerWithAriaLabelledby.isEmpty()) {
    		ElementChecker ec = 
      				new TextNotIdenticalToAttributeChecker(
      						elementAriaMarker,
    					    new TextAttributeOfElementBuilder(ID_ATTR,TEXT_ELEMENT2),
    					    new TextAttributeOfElementBuilder(ALT_ATTR,ARIA_LABELLEDBY_ATTR),
    				        new ImmutablePair(PASSED, ""),
    				        new ImmutablePair(FAILED, INFORMATIVE_AREA_TEXT_NOT_IDENTICAL_TO_ALT_WITH_ARIA_LABELLEDBY_MSG),
    				        ALT_ATTR,
    				        ARIA_LABELLEDBY_ATTR);
    		ec.check(sspHandler, elementMarkerWithAriaLabelledby, testSolutionHandler);
    	}  
    	
    	if(!elementWithAriaLabelledby.isEmpty()) {			
			ElementChecker ec = 
					 new TextNotIdenticalToAttributeChecker(
							elementAria,
							new TextAttributeOfElementBuilder(ID_ATTR,TEXT_ELEMENT2),
							new TextAttributeOfElementBuilder(ALT_ATTR,ARIA_LABELLEDBY_ATTR),
						    new ImmutablePair(NEED_MORE_INFO, ""),
						    new ImmutablePair(NEED_MORE_INFO, AREA_TEXT_NOT_IDENTICAL_TO_ALT_WITH_ARIA_LABELLEDBY_MSG),
						    ALT_ATTR,
						    ARIA_LABELLEDBY_ATTR);
			ec.check(sspHandler, elementWithAriaLabelledby, testSolutionHandler);
		}
    	
    }   
}
