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

import org.tanaguru.ruleimplementation.AbstractPageRuleWithSelectorAndCheckerImplementation;
import org.tanaguru.ruleimplementation.ElementHandler;
import org.tanaguru.ruleimplementation.ElementHandlerImpl;
import org.tanaguru.ruleimplementation.TestSolutionHandler;
import org.tanaguru.rules.elementchecker.CompositeChecker;
import org.tanaguru.rules.elementchecker.ElementChecker;
import org.tanaguru.rules.elementchecker.attribute.AttributePresenceChecker;
import org.tanaguru.rules.elementchecker.attribute.AttributeWithValuePresenceChecker;
import org.tanaguru.rules.elementchecker.text.TextEmptinessChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;
import org.tanaguru.rules.elementselector.builder.CssLikeSelectorBuilder;
import org.tanaguru.rules.textbuilder.SimpleTextElementBuilder;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.jsoup.nodes.Element;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.processor.SSPHandler;

import static org.tanaguru.rules.keystore.AttributeStore.*;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.ELEMENT_WITH_ROLE_ATTR_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.RemarkMessageStore.*;

import java.util.Collection;

import static org.tanaguru.rules.keystore.HtmlElementStore.IMG_ELEMENT;

/**
 * Implementation of the rule 7-1-1 of the referential Rgaa4 2019.
 *
 * @see <a href="http://www.example.com/refential-descriptor.html#test-7-1-1"> 7-1-1 rule specification</a>
 *
 * @author edaconceicao
 */

public class Rgaa42019Rule070101 extends AbstractPageRuleWithSelectorAndCheckerImplementation {

	ElementHandler<Element> imgElement = new ElementHandlerImpl();
	ElementHandler<Element> elementWithNoLabel = new ElementHandlerImpl();
	ElementHandler<Element> elementSelectedWithAriaLabelledby = new ElementHandlerImpl();
	ElementHandler<Element> elementWithAriaLabelledby = new ElementHandlerImpl();


    /**
     * Default constructor
     */
    public Rgaa42019Rule070101 () {
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

    	for(Element element : getElements().get()) {
    		
			if(element.tagName().equals(IMG_ELEMENT)) {
				imgElement.add(element);
			}else if(!element.hasAttr(ARIA_LABELLEDBY_ATTR) &&
    				!element.hasAttr(ARIA_LABEL_ATTR) &&
    				!element.hasAttr(TITLE_ATTR)) {
    			elementWithNoLabel.add(element);
    		}
		}
    	
    	selectElementWithAriaLabelledbyAttribute(sspHandler,elementWithAriaLabelledby);    	
    	
    }
    
    protected void check(SSPHandler sspHandler,
            TestSolutionHandler testSolutionHandler) {

    	super.check(sspHandler, testSolutionHandler);   
    	
    	if(!elementWithAriaLabelledby.isEmpty()) {
    		ElementChecker ec = 
    				new TextEmptinessChecker(
	                    new SimpleTextElementBuilder(),
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
    
    
    
	/**
     * Select all elements having id corresponding with the aria-labelledby
     * @param sspHandler having element to test
     * @param elementHandler to put corresponding elements on it 
     */
    private void selectElementWithAriaLabelledbyAttribute (SSPHandler sspHandler, ElementHandler<Element> elementHandler) {
    	
    	for(Element el : getElements().get()) {
    		
    		if(el.hasAttr(ARIA_LABELLEDBY_ATTR)) {
    			
    			String query = CssLikeSelectorBuilder.buildSelectorFromAttributeTypeAndValue(
        				ID_ATTR, 
                        el.attr(ARIA_LABELLEDBY_ATTR));
		        
		        Collection<Element> elemToAdd = sspHandler.domCssLikeSelectNodeSet(query).getSelectedElements();
		        elementHandler.addAll(elemToAdd);
		        
    		}
    	}
    }

}