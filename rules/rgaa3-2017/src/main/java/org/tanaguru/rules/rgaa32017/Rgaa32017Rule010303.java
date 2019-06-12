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

import org.tanaguru.ruleimplementation.AbstractPageRuleWithSelectorAndCheckerImplementation;
import org.tanaguru.ruleimplementation.ElementHandler;
import org.tanaguru.ruleimplementation.ElementHandlerImpl;
import org.tanaguru.ruleimplementation.TestSolutionHandler;
import org.tanaguru.rules.elementchecker.ElementChecker;
import org.tanaguru.rules.elementchecker.pertinence.AttributePertinenceChecker;
import org.tanaguru.rules.elementselector.ImageElementSelector;
import org.tanaguru.rules.elementselector.SimpleElementSelector;
import org.tanaguru.rules.keystore.RemarkMessageStore;

import static org.tanaguru.entity.audit.TestSolution.FAILED;
import static org.tanaguru.entity.audit.TestSolution.NEED_MORE_INFO;
import static org.tanaguru.entity.audit.TestSolution.PASSED;
import static org.tanaguru.rules.keystore.AttributeStore.ALT_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.SRC_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABEL_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ID_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABELLEDBY_ATTR;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.FORM_BUTTON_WITH_ALT_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.RemarkMessageStore.*;

import java.util.Collections;

import javax.annotation.Nullable;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.jsoup.nodes.Element;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.processor.SSPHandler;
import org.tanaguru.rules.textbuilder.TextAttributeOfElementBuilder;
import org.tanaguru.rules.textbuilder.TextElementBuilder;
import org.tanaguru.rules.elementchecker.CompositeChecker;
import org.tanaguru.rules.elementchecker.text.TextNotIdenticalToAttributeChecker;

/**
 * Implementation of the rule 1.3.3 of the referential Rgaa 3-2017.
 * <br>
 * For more details about the implementation, refer to <a href="http://tanaguru-rules-rgaa3.readthedocs.org/en/latest/Rule-1-3-3">the rule 1.3.3 design page.</a>
 * @see <a href="http://references.modernisation.gouv.fr/referentiel-technique-0#test-1-3-3"> 1.3.3 rule specification</a>
 *
 */
public class Rgaa32017Rule010303 extends AbstractPageRuleWithSelectorAndCheckerImplementation {

    /** The name of the nomenclature that handles the image file extensions */
    private static final String IMAGE_FILE_EXTENSION_NOM = "ImageFileExtensions";

	ElementHandler<Element> inputAriaLabelledby = new ElementHandlerImpl();
	ElementHandler<Element> elementWithAriaLabelledby = new ElementHandlerImpl();


    /**
     * Constructor
     */
    public Rgaa32017Rule010303() {

    	super(new ImageElementSelector(FORM_BUTTON_WITH_ALT_CSS_LIKE_QUERY, true, false),
    		  new CompositeChecker(
    				  new AttributePertinenceChecker(
    			                ALT_ATTR,
    			                // check emptiness
    			                true,
    			                // compare with src attribute
    			                new TextAttributeOfElementBuilder(SRC_ATTR),
    			                // compare attribute value with nomenclature
    			                IMAGE_FILE_EXTENSION_NOM,
    			                // not pertinent message
    			                NOT_PERTINENT_ALT_MSG,
    			                // manual check message
    			                CHECK_ALT_PERTINENCE_OF_INFORMATIVE_IMG_MSG,
    			                // evidence elements
    			                ALT_ATTR, 
    			                SRC_ATTR),
    				  new TextNotIdenticalToAttributeChecker(
    		                	new TextAttributeOfElementBuilder(TITLE_ATTR),
    		                	new TextAttributeOfElementBuilder(ALT_ATTR),
    		                	new ImmutablePair(TestSolution.NEED_MORE_INFO, ""),
    		                	new ImmutablePair(TestSolution.FAILED, TITLE_NOT_IDENTICAL_TO_ALT_MSG),
    		                	ALT_ATTR,SRC_ATTR,TITLE_ATTR),
    				  new TextNotIdenticalToAttributeChecker(
    		                	new TextAttributeOfElementBuilder(ARIA_LABEL_ATTR),
    		                	new TextAttributeOfElementBuilder(ALT_ATTR),
    		                	new ImmutablePair(TestSolution.NEED_MORE_INFO, ""),
    		                	new ImmutablePair(TestSolution.FAILED, ARIA_LABEL_NOT_IDENTICAL_TO_ALT_MSG),
    		                	ALT_ATTR,SRC_ATTR,ARIA_LABEL_ATTR)));
    	CompositeChecker ec = (CompositeChecker) getElementChecker();
    	ec.setIsOrCombinaison(false);
    	setElementChecker(ec);
    }
    
    
    protected void select(SSPHandler sspHandler) {
    	super.select(sspHandler); 	

    	//get id attributes
    	for(Element element : getElements().get()) {
			if(element.hasAttr(ARIA_LABELLEDBY_ATTR)) {
				inputAriaLabelledby.add(element);
			}
		}

		//Select elements have got id attribute
		ElementHandler<Element> elementPage = new ElementHandlerImpl();
    	SimpleElementSelector ses = new SimpleElementSelector("*[id]:not(input)"); //select all element with an id except input elements
    	ses.selectElements(sspHandler, elementPage);    	
    	    	
    	//select elements have id/aria-labelledby identical
    	for (Element el : elementPage.get()) {
        	for(Element elemAria : inputAriaLabelledby.get()) {    
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
    	
    	if(!elementWithAriaLabelledby.isEmpty()) {			
			ElementChecker ec = 
					new TextNotIdenticalToAttributeChecker(
							inputAriaLabelledby,
						    new TextAttributeOfElementBuilder(ID_ATTR,TEXT_ELEMENT2),
						    new TextAttributeOfElementBuilder(ALT_ATTR,ARIA_LABELLEDBY_ATTR),
					        new ImmutablePair(TestSolution.PASSED, ""),
					        new ImmutablePair(TestSolution.FAILED, TEXT_NOT_IDENTICAL_TO_ALT_WITH_ARIA_LABELLEDBY_MSG),
					        ALT_ATTR,ARIA_LABELLEDBY_ATTR);
			ec.check(sspHandler, elementWithAriaLabelledby, testSolutionHandler);
		}
    }
}
