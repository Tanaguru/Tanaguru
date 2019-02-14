/*
 * Tanaguru - Automated webpage assessment
  * Copyright (C) 2008-2015 Tanaguru.org
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
import static org.tanaguru.entity.audit.TestSolution.FAILED;
import static org.tanaguru.entity.audit.TestSolution.PASSED;

import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.processor.SSPHandler;
import org.tanaguru.ruleimplementation.AbstractPageRuleWithSelectorAndCheckerImplementation;
import org.tanaguru.ruleimplementation.ElementHandler;
import org.tanaguru.ruleimplementation.ElementHandlerImpl;
import org.tanaguru.ruleimplementation.TestSolutionHandler;
import org.tanaguru.rules.elementchecker.ElementChecker;
import org.tanaguru.rules.elementchecker.attribute.AttributePresenceChecker;
import org.tanaguru.rules.elementchecker.element.ElementPresenceChecker;
import org.tanaguru.rules.elementchecker.pertinence.AttributePertinenceChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;
import org.tanaguru.rules.keystore.CssLikeQueryStore;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABELLEDBY_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABEL_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.FOR_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ID_ATTR;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_TEXT_PERTINENCE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_LABEL_PERTINENCE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.NOT_PERTINENT_TEXTUAL_CONTENT_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.ARIA_LABEL_ATTR_MISSING_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.FORM_ELEMENT_WITHOUT_LABEL_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.FORM_NOT_REFERENCED_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_TITLE_PERTINENCE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_ARIA_LABEL_PERTINENCE_MSG;

/**
 * Implementation of the rule 11.1.1 of the referential Rgaa 3-2017.
 * <br/>
 * For more details about the implementation, refer to <a href="http://tanaguru-rules-rgaa3.readthedocs.org/en/latest/Rule-11-1-1">the rule 11.1.1 design page.</a>
 * @see <a href="http://references.modernisation.gouv.fr/referentiel-technique-0#test-11-1-1"> 11.1.1 rule specification</a>
 *
 */
public class Rgaa32017Rule110101  extends AbstractPageRuleWithSelectorAndCheckerImplementation {


	ElementHandler<Element> elementWithAriaLabelledbyEqualId = new ElementHandlerImpl();
	ElementHandler<Element> elementWithIdEqualFor = new ElementHandlerImpl();
	ElementHandler<Element> elementWithLabel = new ElementHandlerImpl();
	ElementHandler<Element> elementWithTitle = new ElementHandlerImpl();
	ElementHandler<Element> elementWithNoLabel = new ElementHandlerImpl();
	ElementHandler<Element> elementNotRefWithID = new ElementHandlerImpl();
	ElementHandler<Element> elementNotRefWithARIA = new ElementHandlerImpl();
    
    
    /**
     * Default constructor
     */
    public Rgaa32017Rule110101() {
        super();
        setElementSelector(new SimpleElementSelector(CssLikeQueryStore.LABEL_ELEMENT_CSS_LIKE_QUERY));
    }

    @Override
    protected void select(SSPHandler sspHandler) {
    	super.select(sspHandler);
    	
    	
		ElementHandler<Element> elementWithIdOnPage = new ElementHandlerImpl(); 
    	new SimpleElementSelector("*[id]:not(input):not(textarea):not(select)").selectElements(sspHandler, elementWithIdOnPage);
    	
    	
		ElementHandler<Element> labelElementPage = new ElementHandlerImpl();
    	new SimpleElementSelector("label[for]").selectElements(sspHandler, labelElementPage); 
    	
    	
		for(Element el : getElements().get()) {
			if(!selectAriaLabelledby(el, elementWithIdOnPage) 
					&& !selectAriaLabel(el) 
					&& !selectLabel(el, labelElementPage) 
					&& !selectTitle(el)) {
				
				elementWithNoLabel.add(el);
			}
    	}
    }
    

    @Override
    protected void check(
            SSPHandler sspHandler, 
            TestSolutionHandler testSolutionHandler) {
    	
    	if(!elementWithNoLabel.isEmpty()) {
    		ElementChecker ec = 
    				new ElementPresenceChecker( 
					    new ImmutablePair(FAILED, FORM_ELEMENT_WITHOUT_LABEL_MSG),
					   	new ImmutablePair(PASSED,""));
    		ec.check(sspHandler, elementWithNoLabel, testSolutionHandler);
    	}
    	
    	
    	if(!elementNotRefWithARIA.isEmpty()) {
    		ElementChecker ec = 
    				new ElementPresenceChecker( 
					    new ImmutablePair(FAILED, FORM_NOT_REFERENCED_MSG),
					   	new ImmutablePair(PASSED,""),
					    ARIA_LABELLEDBY_ATTR);
    		ec.check(sspHandler, elementNotRefWithARIA, testSolutionHandler);
    	}
    	
    	if(!elementNotRefWithID.isEmpty()) {
    		ElementChecker ec = 
    				new ElementPresenceChecker( 
					    new ImmutablePair(FAILED, FORM_NOT_REFERENCED_MSG),
					   	new ImmutablePair(PASSED,""),
					    ID_ATTR);
    		ec.check(sspHandler, elementNotRefWithID, testSolutionHandler);
    	}
    	
    	// check if elements have a title or an aria-label attribute
    	if(!elementWithLabel.isEmpty()) {
	    	ElementChecker cc =
	    			new AttributePertinenceChecker(
	    					ARIA_LABEL_ATTR,
	    					// check emptiness
	    					true,
	    					null,
	    					null,
	    					// not pertinent message
	    					NOT_PERTINENT_TEXTUAL_CONTENT_MSG,
	    					// manual check message
	    					CHECK_ARIA_LABEL_PERTINENCE_MSG, 
	    					// evidence elements
	    					ARIA_LABEL_ATTR);
			cc.check(sspHandler, elementWithLabel, testSolutionHandler);
    	}
    	
    	if(!elementWithTitle.isEmpty()) {
    		ElementChecker cc =				
    			new AttributePertinenceChecker(
    					TITLE_ATTR,
    					// check emptiness
    					true,
    					null,
    					null,
    					// not pertinent message
    					NOT_PERTINENT_TEXTUAL_CONTENT_MSG,
    					// manual check message
    					CHECK_TITLE_PERTINENCE_MSG, 
    					// evidence elements
    					TITLE_ATTR);
			cc.check(sspHandler, elementWithTitle, testSolutionHandler);
    	}
                
        if(!elementWithAriaLabelledbyEqualId.isEmpty()) {
    		ElementChecker cc =     				
    				new AttributePertinenceChecker(
    						TEXT_ELEMENT2,
                            // check emptiness
                            true,
                            null,
                            null,
                            // not pertinent message
                            NOT_PERTINENT_TEXTUAL_CONTENT_MSG,
                            // manual check message
                            CHECK_TEXT_PERTINENCE_MSG, 
                            // evidence elements
                            ID_ATTR,  
                            TEXT_ELEMENT2);    		
    		cc.check(sspHandler, elementWithAriaLabelledbyEqualId, testSolutionHandler);
        }
        
        if(!elementWithIdEqualFor.isEmpty()) {
        	ElementChecker cc =     				
    				new AttributePertinenceChecker(
    						TEXT_ELEMENT2,
                            // check emptiness
                            true,
                            null,
                            null,
                            // not pertinent message
                            NOT_PERTINENT_TEXTUAL_CONTENT_MSG,
                            // manual check message
                            CHECK_LABEL_PERTINENCE_MSG,
                            // evidence elements
                            FOR_ATTR,  
                            TEXT_ELEMENT2);    		
    		cc.check(sspHandler, elementWithIdEqualFor, testSolutionHandler);
        }
    }
    
    
    
    /**
     * Select if the element has an aria-labelledby attribute linked with an id attribute 
     * @param el
     * @param selectionHandler
     * @return
     */
    public boolean selectAriaLabelledby(Element el, ElementHandler<Element> selectionHandler ) {
    	
    	if(!el.attr(ARIA_LABELLEDBY_ATTR).isEmpty()) {
    		
        	if(selectionHandler.get().isEmpty()) {
        		elementNotRefWithARIA.add(el);
            	return true;
        	}
    		
    		boolean isSomeElementsAdded = false;
    		for (Element selected : selectionHandler.get()) { 
    			
					if(!selected.id().isEmpty() 
							&& el.attr(ARIA_LABELLEDBY_ATTR).contains(selected.id())) { //ID == ARIA-LABELLEDBY

						elementWithAriaLabelledbyEqualId.add(selected); //check si moyen d'ajouter les 2 lignes avec attr en plus
						isSomeElementsAdded=true;
					}
    		}
    		if(isSomeElementsAdded) {
    			selectionHandler.removeAll(elementWithAriaLabelledbyEqualId);
    		}else {
    			elementNotRefWithARIA.add(el);
    		}
			return true;
		}
    	return false;
    }
    
    
    
    /**
     * Select the element if it has an aria-label attribute
     * @param el
     * @return
     */
    public boolean selectAriaLabel(Element el ) {
    	if(!el.attr(ARIA_LABEL_ATTR).isEmpty()) {
			elementWithLabel.add(el);
			return true;
		}
    	return false;
    }
    
    
    
    
    /**
     * Select if the id's element is linked with the for's attribute label element
     * @param el
     * @param selectionHandler
     * @return
     */
    public boolean selectLabel(Element el, ElementHandler<Element> selectionHandler ) {
    	
    	if(!el.attr(ID_ATTR).isEmpty()) {
    		
    		if(selectionHandler.get().isEmpty()) {
    			elementNotRefWithID.add(el);
            	return true;
        	}
    		
    		boolean isSomeElementsAdded = false;
    		for (Element selected : selectionHandler.get()) {  
			        	
    			if(!selected.attr(FOR_ATTR).isEmpty() &&
    					el.id().equals(selected.attr(FOR_ATTR))) { //ID == FOR

    				elementWithIdEqualFor.add(selected);
					isSomeElementsAdded=true;
    			}
    		}
    		if(isSomeElementsAdded) {
    			selectionHandler.removeAll(elementWithIdEqualFor);
    		}else if(!selectTitle(el)) {
    			elementNotRefWithID.add(el);
    		}
			return true;		
    	}
    	return false;
    }
    
    
    
    /**
     * Select the element has got a title
     * @param el
     * @return
     */
    public boolean selectTitle(Element el ) {
    	if(!el.attr(TITLE_ATTR).isEmpty() && !elementWithTitle.get().contains(el)) {
			elementWithTitle.add(el);
			return true;
		}
    	return false;
    }
}