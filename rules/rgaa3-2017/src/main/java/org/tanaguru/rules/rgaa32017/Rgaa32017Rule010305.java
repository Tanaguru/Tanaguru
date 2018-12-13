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
import org.tanaguru.rules.elementchecker.ElementChecker;
import org.tanaguru.rules.elementchecker.text.TextNotIdenticalToAttributeChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;
import org.tanaguru.rules.textbuilder.TextAttributeOfElementBuilder;

import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABELLEDBY_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABEL_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ID_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.OBJECT_TYPE_IMG_WITH_TITLE_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.MarkerStore.DECORATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.INFORMATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_OBJ_IMG_ARIA_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.INFORMATIVE_OBJ_NOT_INDENTICAL_ATTR_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.SUSPECTED_INFORMATIVE_OBJ_DETECTED;
import static org.tanaguru.rules.keystore.RemarkMessageStore.INFORMATIVE_OBJ_NOT_INDENTICAL_ARIA_LABELLEDBY_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_OBJ_IMG_ARIA_LABELLEDBY_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.SUSPECTED_INFORMATIVE_OBJ_WITH_LABELLEDBY_DETECTED;

/**
 * Implementation of the rule 1.3.5 of the referential Rgaa 3-2017.
 *
 * For more details about the implementation, refer to <a href="http://tanaguru-rules-rgaa3.readthedocs.org/en/latest/Rule-1-3-5">the rule 1.3.5 design page.</a>
 * @see <a href="http://references.modernisation.gouv.fr/referentiel-technique-0#test-1-3-5"> 1.3.5 rule specification</a>
 */

public class Rgaa32017Rule010305 extends AbstractMarkerPageRuleImplementation {
	
	ElementHandler<Element> elementAriaMarker = new ElementHandlerImpl();
	ElementHandler<Element> elementAria = new ElementHandlerImpl();
	
	
	ElementHandler<Element> elementMarkerWithAriaLabelledby = new ElementHandlerImpl();
	ElementHandler<Element> elementWithAriaLabelledby = new ElementHandlerImpl();
	
    /**
     * Default constructor
     */
    public Rgaa32017Rule010305 () {
    	super(  // the informative images are part of the scope
                INFORMATIVE_IMAGE_MARKER, 

                // the decorative images are not part of the scope
                DECORATIVE_IMAGE_MARKER);       
        
        setElementSelector(new SimpleElementSelector(OBJECT_TYPE_IMG_WITH_TITLE_CSS_LIKE_QUERY));
        
        // init of marker element Checker              
//        TextNotIdenticalToAttributeChecker textChecker1 = 
//     		   new TextNotIdenticalToAttributeChecker(
// 		           	new TextAttributeOfElementBuilder(ARIA_LABEL_ATTR),
// 		           	new TextAttributeOfElementBuilder(TITLE_ATTR),
// 		           	new ImmutablePair(TestSolution.PASSED, ""),
// 		           	new ImmutablePair(TestSolution.FAILED, INFORMATIVE_OBJ_NOT_INDENTICAL_ATTR_MSG),
// 		           	TYPE_ATTR,
// 		           	TITLE_ATTR,
// 		           	ARIA_LABEL_ATTR);
//        
//        TextNotIdenticalToAttributeChecker textChecker2 = 
// 			   new TextNotIdenticalToAttributeChecker(
// 		            new TextAttributeOfElementBuilder(ARIA_LABELLEDBY_ATTR),
// 		            new TextAttributeOfElementBuilder(TITLE_ATTR),
// 		            new ImmutablePair(TestSolution.PASSED, ""),
// 		            new ImmutablePair(TestSolution.FAILED, INFORMATIVE_OBJ_NOT_INDENTICAL_ATTR_MSG),
// 		            TYPE_ATTR,
// 		            TITLE_ATTR,
// 		            ARIA_LABELLEDBY_ATTR); 
//        
//        CompositeChecker cc1 = new CompositeChecker( textChecker1, textChecker2);
//        cc1.setIsOrCombinaison(false);
//        setMarkerElementChecker(cc1);
//        
//        
//        
//        // init of not marker element checker 
//        TextNotIdenticalToAttributeChecker textChecker3 = 
//     		   new TextNotIdenticalToAttributeChecker(
// 	                new TextAttributeOfElementBuilder(ARIA_LABEL_ATTR),
// 	                new TextAttributeOfElementBuilder(TITLE_ATTR),
// 	                new ImmutablePair(TestSolution.NEED_MORE_INFO, SUSPECTED_INFORMATIVE_OBJ_DETECTED),
// 	                new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_OBJ_IMG_ARIA_MSG),
// 	                TYPE_ATTR,
// 	                TITLE_ATTR,
// 	                ARIA_LABEL_ATTR);   
//        
//        TextNotIdenticalToAttributeChecker textChecker4 = 
//     		   new TextNotIdenticalToAttributeChecker(
// 		            new TextAttributeOfElementBuilder(ARIA_LABELLEDBY_ATTR),
// 		            new TextAttributeOfElementBuilder(TITLE_ATTR),
// 		            new ImmutablePair(TestSolution.NEED_MORE_INFO, SUSPECTED_INFORMATIVE_OBJ_DETECTED),
// 		            new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_OBJ_IMG_ARIA_MSG),
// 		            TYPE_ATTR,
// 		            TITLE_ATTR,
// 		            ARIA_LABELLEDBY_ATTR);
//        
//        CompositeChecker cc2 = new CompositeChecker( textChecker3, textChecker4 );
//        cc2.setIsOrCombinaison(false);
//        setRegularElementChecker(cc2);
    }
    
    protected void select(SSPHandler sspHandler) {
    	super.select(sspHandler); 	
    	
    	//get id attributes
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
    	SimpleElementSelector ses = new SimpleElementSelector("*[id]:not(object)"); //select all element with an id except embed elements
    	ses.selectElements(sspHandler, elementPage);    	
    	    	
    	//select elements have id/aria-labelledby identical
    	for (Element el : elementPage.get()) {
        	for(Element elemAria : elementAriaMarker.get()) {    
				if(elemAria.attr(ARIA_LABELLEDBY_ATTR).equals(el.id())) { //ID == ARIA-LABELLEDBY
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
    
    protected void check(
            SSPHandler sspHandler,
            TestSolutionHandler testSolutionHandler) {

		if(!elementMarkerWithAriaLabelledby.isEmpty()) {			
			ElementChecker ec = 
					new TextNotIdenticalToAttributeChecker(
							elementAriaMarker,
						    new TextAttributeOfElementBuilder(ID_ATTR,TEXT_ELEMENT2),
						    new TextAttributeOfElementBuilder(TITLE_ATTR,ARIA_LABELLEDBY_ATTR),
					        new ImmutablePair(TestSolution.PASSED, ""),
					        new ImmutablePair(TestSolution.FAILED, INFORMATIVE_OBJ_NOT_INDENTICAL_ARIA_LABELLEDBY_MSG),
							TITLE_ATTR,
							ARIA_LABELLEDBY_ATTR);
			ec.check(sspHandler, elementMarkerWithAriaLabelledby, testSolutionHandler);
		}
		
    	if(!elementWithAriaLabelledby.isEmpty()) {    		
    		ElementChecker ec = 
					   new TextNotIdenticalToAttributeChecker(
							    elementAria,
							    new TextAttributeOfElementBuilder(ID_ATTR,TEXT_ELEMENT2),
							    new TextAttributeOfElementBuilder(TITLE_ATTR,ARIA_LABELLEDBY_ATTR),
				                new ImmutablePair(TestSolution.NEED_MORE_INFO, SUSPECTED_INFORMATIVE_OBJ_WITH_LABELLEDBY_DETECTED),
				                new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_OBJ_IMG_ARIA_LABELLEDBY_MSG),
				                TITLE_ATTR,
						        ARIA_LABELLEDBY_ATTR); 
    		ec.check(sspHandler, elementWithAriaLabelledby, testSolutionHandler);
    	}    	
    	
		if(!getSelectionWithMarkerHandler().isEmpty()) {
    		ElementChecker ec = 
    				new TextNotIdenticalToAttributeChecker(
					           	new TextAttributeOfElementBuilder(ARIA_LABEL_ATTR),
					           	new TextAttributeOfElementBuilder(TITLE_ATTR),
					           	new ImmutablePair(TestSolution.PASSED, ""),
					           	new ImmutablePair(TestSolution.FAILED, INFORMATIVE_OBJ_NOT_INDENTICAL_ATTR_MSG),
					           	TITLE_ATTR,
					           	ARIA_LABEL_ATTR); 
			ec.check(sspHandler, getSelectionWithMarkerHandler(), testSolutionHandler);
		}
    	
    	if(!getSelectionWithoutMarkerHandler().isEmpty()) {
			ElementChecker ec = 
					new TextNotIdenticalToAttributeChecker(
			                new TextAttributeOfElementBuilder(ARIA_LABEL_ATTR),
			                new TextAttributeOfElementBuilder(TITLE_ATTR),
			                new ImmutablePair(TestSolution.NEED_MORE_INFO, SUSPECTED_INFORMATIVE_OBJ_DETECTED),
			                new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_OBJ_IMG_ARIA_MSG),
			                TITLE_ATTR,
			                ARIA_LABEL_ATTR);
			ec.check(sspHandler, getSelectionWithoutMarkerHandler(), testSolutionHandler);				
    	}
    }
}
