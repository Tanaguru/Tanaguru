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
import org.tanaguru.rules.elementchecker.CompositeChecker;
import org.tanaguru.rules.elementchecker.ElementChecker;
import org.tanaguru.rules.elementchecker.attribute.AttributePresenceChecker;
import org.tanaguru.rules.elementchecker.attribute.AttributeWithValuePresenceChecker;
import org.tanaguru.rules.elementchecker.text.TextNotIdenticalToAttributeChecker;
import org.tanaguru.rules.elementselector.MultipleElementSelector;
import org.tanaguru.rules.elementselector.SimpleElementSelector;
import org.tanaguru.rules.textbuilder.TextAttributeOfElementBuilder;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.jsoup.nodes.Element;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.processor.SSPHandler;

import static org.tanaguru.rules.keystore.AttributeStore.*;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.ELEMENT_WITH_ROLE_ATTR_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.RemarkMessageStore.*;
import static org.tanaguru.rules.keystore.HtmlElementStore.IMG_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT;

/**
 * Implementation of the rule 7.1.1 of the referential Rgaa 3-2017.
 *
 * For more details about the implementation, refer to <a href="http://tanaguru-rules-rgaa3.readthedocs.org/en/latest/Rule-7-1-1">the rule 7.1.1 design page.</a>
 * @see <a href="http://references.modernisation.gouv.fr/referentiel-technique-0#test-7-1-1"> 7.1.1 rule specification</a>
 */

public class Rgaa32017Rule070101 extends AbstractPageRuleWithSelectorAndCheckerImplementation {

	ElementHandler<Element> imgElement = new ElementHandlerImpl();
	ElementHandler<Element> elementWithNoLabel = new ElementHandlerImpl();
	ElementHandler<Element> elementSelectedWithAriaLabelledby = new ElementHandlerImpl();
	ElementHandler<Element> elementWithAriaLabelledby = new ElementHandlerImpl();

		
    /**
     * Default constructor
     */
    public Rgaa32017Rule070101 () {
        super();	
        		setElementSelector(new SimpleElementSelector(ELEMENT_WITH_ROLE_ATTR_CSS_LIKE_QUERY));
        		CompositeChecker cc =new CompositeChecker (
                		new AttributeWithValuePresenceChecker(
                        		TITLE_ATTR,
                    			"",
                        		new ImmutablePair(TestSolution.FAILED, ARIA_FORM_LABEL_EMPTY),
                    			new ImmutablePair(TestSolution.PASSED, ""),
                        		ROLE_ATTR),
                        new AttributeWithValuePresenceChecker(
                        		ARIA_LABEL_ATTR,
                    			"",
                        		new ImmutablePair(TestSolution.FAILED, ARIA_FORM_LABEL_EMPTY),
                    			new ImmutablePair(TestSolution.PASSED, ""),
                        		ROLE_ATTR));
        		cc.setIsOrCombinaison(false);
        		setElementChecker(cc);
    }
    
    protected void select(SSPHandler sspHandler) {
    	super.select(sspHandler); 	

    	//get id attributes
    	for(Element element : getElements().get()) {
    		
			if(element.hasAttr(ARIA_LABELLEDBY_ATTR)) {
				elementSelectedWithAriaLabelledby.add(element);
			}
			if(element.tagName().equals(IMG_ELEMENT)) {
				imgElement.add(element);
			}else if(!element.hasAttr(ARIA_LABELLEDBY_ATTR) &&
    				!element.hasAttr(ARIA_LABEL_ATTR) &&
    				!element.hasAttr(TITLE_ATTR)) {
    			elementWithNoLabel.add(element);
    		}
		}

		//Select elements have got id attribute
		ElementHandler<Element> elementPage = new ElementHandlerImpl();
    	SimpleElementSelector ses = new SimpleElementSelector("*[id]"); //select all element with an id except input elements
    	ses.selectElements(sspHandler, elementPage);    	
    	    	
    	//select elements have id/aria-labelledby identical
    	for (Element el : elementPage.get()) {
        	for(Element elemAria : elementSelectedWithAriaLabelledby.get()) {    
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
					new AttributeWithValuePresenceChecker(
							TEXT_ELEMENT2,
                			"",
                    		new ImmutablePair(TestSolution.FAILED, ARIA_FORM_LABEL_EMPTY),
                			new ImmutablePair(TestSolution.PASSED, ""),
                    		ID_ATTR);
			ec.check(sspHandler, elementWithAriaLabelledby, testSolutionHandler);
		}
    	
    	if(!imgElement.isEmpty()) {
    		ElementChecker ec = 
	    		new AttributeWithValuePresenceChecker(
						ALT_ATTR,
						"",
        				new ImmutablePair(TestSolution.FAILED, ALT_IMG_FORM_LABEL_EMPTY),
    					new ImmutablePair(TestSolution.PASSED, ""),
	    				ROLE_ATTR);
			ec.check(sspHandler, imgElement, testSolutionHandler);
    	}
    	
    	if(!elementWithNoLabel.isEmpty()) {
    		ElementChecker ec = new CompositeChecker(
		    		new AttributePresenceChecker(
							TITLE_ATTR,
							new ImmutablePair(TestSolution.PASSED, ""),
							new ImmutablePair(TestSolution.FAILED, ARIA_FORM_LABEL_MISSING),
							ROLE_ATTR),
		    		new AttributePresenceChecker(
			   				ARIA_LABEL_ATTR,
							new ImmutablePair(TestSolution.PASSED, ""),
			   				new ImmutablePair(TestSolution.FAILED, ARIA_FORM_LABEL_MISSING),
							ROLE_ATTR),
					new AttributePresenceChecker(
			   				ARIA_LABELLEDBY_ATTR,
							new ImmutablePair(TestSolution.PASSED, ""),
							new ImmutablePair(TestSolution.FAILED, ARIA_FORM_LABEL_MISSING), 
							ROLE_ATTR));
			ec.check(sspHandler, elementWithNoLabel, testSolutionHandler);
    	}
    }
    
}