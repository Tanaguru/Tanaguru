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

import org.jsoup.nodes.Element;
import org.tanaguru.processor.SSPHandler;
import org.tanaguru.ruleimplementation.AbstractPageRuleWithSelectorAndCheckerImplementation;
import org.tanaguru.ruleimplementation.ElementHandler;
import org.tanaguru.ruleimplementation.ElementHandlerImpl;
import org.tanaguru.ruleimplementation.TestSolutionHandler;
import org.tanaguru.rules.elementchecker.ElementChecker;
import org.tanaguru.rules.elementchecker.element.ElementPresenceChecker;
import org.tanaguru.rules.elementselector.ElementSelector;
import org.tanaguru.rules.elementselector.SimpleElementSelector;
import org.tanaguru.rules.elementselector.builder.CssLikeSelectorBuilder;

import static org.tanaguru.entity.audit.TestSolution.NOT_APPLICABLE;
import static org.tanaguru.entity.audit.TestSolution.NEED_MORE_INFO;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABELLEDBY_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABEL_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.FOR_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ID_ATTR;
import static org.tanaguru.rules.keystore.HtmlElementStore.LABEL_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.INPUT_ELEMENT;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.FORM_ELEMENT_WITH_ID_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.FORM_ARIA_LABEL_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.FORM_ARIA_LABELLEDBY_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.FORM_TITLE_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_REPEATED_LABEL_PERTINENCE_MSG;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;

/**
 * Implementation of the rule 11.3.1 of the referential Rgaa 3-2017.
 * <br>
 * For more details about the implementation, refer to <a href="http://tanaguru-rules-rgaa3.readthedocs.org/en/latest/Rule-11-3-1">the rule 11.3.1 design page.</a>
 * @see <a href="http://references.modernisation.gouv.fr/referentiel-technique-0#test-11-3-1"> 11.3.1 rule specification</a>
 *
 */
public class Rgaa32017Rule110301 extends AbstractPageRuleWithSelectorAndCheckerImplementation {
    
    /** the input form elements  */
    private final ElementHandler<Element> textOfLabels = 
            new ElementHandlerImpl();
    
    /** the input form elements  */
    private final ElementHandler<Element> labels = 
            new ElementHandlerImpl();
    
    
    public Rgaa32017Rule110301 () {
        super();
    }
    
    
    
    protected void select(SSPHandler sspHandler) {

    	ElementHandler<Element> inputFormHandler =  new ElementHandlerImpl();
    	
        
        // Selection of all the input form elements with an aria-labelleby of the page
        ElementSelector elementSelectorAriaLabelledby = new SimpleElementSelector(FORM_ARIA_LABELLEDBY_CSS_LIKE_QUERY);
        elementSelectorAriaLabelledby.selectElements(sspHandler, inputFormHandler);
        selectElementWithAriaLabelledbyAttribute(sspHandler,inputFormHandler);
    	
        // Selection of all the input form elements with an aria-label of the page
        ElementSelector elementSelectorAriaLabel = new SimpleElementSelector(FORM_ARIA_LABEL_CSS_LIKE_QUERY);
//        elementSelectorAriaLabel.selectElements(sspHandler, ariaLabelDetected);
        elementSelectorAriaLabel.selectElements(sspHandler, textOfLabels);
        
        // Selection of all the input form elements with an id of the page
        ElementSelector elementSelectorId = new SimpleElementSelector(FORM_ELEMENT_WITH_ID_CSS_LIKE_QUERY);
        elementSelectorId.selectElements(sspHandler, inputFormHandler);
        selectLabelElementWithForAttribute(sspHandler,inputFormHandler);

        // Selection of all the input form elements with a title of the page
        ElementSelector elementSelectorTitle = new SimpleElementSelector(FORM_TITLE_CSS_LIKE_QUERY);
//        elementSelectorTitle.selectElements(sspHandler, titleDetected);
        elementSelectorTitle.selectElements(sspHandler, textOfLabels);
    }
    
    

	@Override
	protected void check(SSPHandler sspHandler, TestSolutionHandler testSolutionHandler) {

        
    	checkIdenticalLabels();
    	
		if (labels.isEmpty()) {
            testSolutionHandler.addTestSolution(NOT_APPLICABLE);
            return;
        }

		ElementChecker ec = new ElementPresenceChecker(
		      new ImmutablePair(NEED_MORE_INFO, CHECK_REPEATED_LABEL_PERTINENCE_MSG),
		      new ImmutablePair(NOT_APPLICABLE, ""),
		      TEXT_ELEMENT2,
		      ARIA_LABEL_ATTR,
		      TITLE_ATTR);
		ec.check(sspHandler, labels, testSolutionHandler);
	}
	
	
	
	
	
	private void checkIdenticalLabels() {

		boolean added = false;
		ArrayList<ArrayList<Element>> arrayListOfLabels = new ArrayList<ArrayList<Element>>();
		
		//Check for all elements repeated, Seek if there are not other sibling as <label> or attributes
		for(Element el : textOfLabels.get()) {
			added = false;

			//Initialize the first list of elements to begin the selection
			if(arrayListOfLabels.isEmpty()) {
				
				//Initialize it with the first element of the handler
				arrayListOfLabels.add(new ArrayList<Element>());
				arrayListOfLabels.get(arrayListOfLabels.size()-1).add(el);
				
			}else {
				
				//check if the current element is an input and so, check if it has the attribute compatibility first
				if(el.tagName().equals(INPUT_ELEMENT)) {
					
					
					//Check if the attribute exists and if it is not empty
					if(!el.attr(ARIA_LABEL_ATTR).isEmpty()) {
						
						for(ArrayList<Element> lab : arrayListOfLabels) {
							
							//avoid siblings
							if(!lab.contains(el)) {

								if((StringUtils.equalsIgnoreCase(el.attr(ARIA_LABEL_ATTR),lab.get(0).attr(ARIA_LABEL_ATTR)) && lab.get(0).tagName().equals(INPUT_ELEMENT)) ||
										(StringUtils.equalsIgnoreCase(el.attr(ARIA_LABEL_ATTR),lab.get(0).attr(TITLE_ATTR)) && lab.get(0).tagName().equals(INPUT_ELEMENT)) ||
										StringUtils.equalsIgnoreCase(el.attr(ARIA_LABEL_ATTR),lab.get(0).text())) {
									
									lab.add(el);
									added = true;
									break;
								}
							}
						}	
						
					//Check if the attribute exists and if it is not empty
					}else if(!el.attr(TITLE_ATTR).isEmpty()) {
						
						for(ArrayList<Element> lab : arrayListOfLabels) {

							//avoid siblings
							if(!lab.contains(el)) {
								
								if((StringUtils.equalsIgnoreCase(el.attr(TITLE_ATTR),lab.get(0).attr(ARIA_LABEL_ATTR)) && lab.get(0).tagName().equals(INPUT_ELEMENT))||
										(StringUtils.equalsIgnoreCase(el.attr(TITLE_ATTR),lab.get(0).attr(TITLE_ATTR)) && lab.get(0).tagName().equals(INPUT_ELEMENT))||
										StringUtils.equalsIgnoreCase(el.attr(TITLE_ATTR),lab.get(0).text())) {
									
									lab.add(el);
									added = true;
									break;
								}
							}
						}				
					}
				
				//Check if there is no attribute label for the current element
				}else {
					
					for(ArrayList<Element> lab : arrayListOfLabels) {

						//avoid siblings
						if(!lab.contains(el) && !el.text().isEmpty()) {
							
							if((StringUtils.equalsIgnoreCase(el.text(),lab.get(0).attr(ARIA_LABEL_ATTR)) && lab.get(0).tagName().equals(INPUT_ELEMENT)) ||
									(StringUtils.equalsIgnoreCase(el.text(),lab.get(0).attr(TITLE_ATTR)) && lab.get(0).tagName().equals(INPUT_ELEMENT)) ||
									(StringUtils.equalsIgnoreCase(el.text(),lab.get(0).text()))) {
							
							
//							if(StringUtils.equalsIgnoreCase(el.text(),lab.get(0).text())){

														
								lab.add(el);
								added = true;
								break;
							}
						}
					}
				}
				
				//if there is no identical label, create a new arraylist with the current element in it
				if(!added) {
					arrayListOfLabels.add(new ArrayList<Element>());
					arrayListOfLabels.get(arrayListOfLabels.size()-1).add(el);
				}
			}
		}
		
		 ArrayList<ArrayList<Element>> arrayListOfListToDelete = new ArrayList<ArrayList<Element>>();

	        //Remove all lists which have a single element
		 	for(ArrayList<Element> array : arrayListOfLabels) {
	        	if(array.size() == 1) {
	        		arrayListOfListToDelete.add(array);
	        	}
	        }
	        arrayListOfLabels.removeAll(arrayListOfListToDelete);
	        

	    	//clean the handler before to add the new elements list
	        for(ArrayList<Element> array : arrayListOfLabels) {
	        	labels.addAll(array);
	        }
	}

	
	
	/**
     * 
     * @param sspHandler
     * @param id
     * @return whether a label element with the for attribute equals to the id
     * passed as argument is found on the page
     */
    private void selectLabelElementWithForAttribute (SSPHandler sspHandler, ElementHandler<Element> elementHandler) {
    	
    	for(Element el : elementHandler.get()) {
	        String query = CssLikeSelectorBuilder.buildSelectorFromElementsAndAttributeValue(
	                        LABEL_ELEMENT,
	                        FOR_ATTR, 
	                        el.id());
	        Collection<Element> elemToAdd = sspHandler.domCssLikeSelectNodeSet(query).getSelectedElements();
//	        labelDetected.addAll(elemToAdd);
	        textOfLabels.addAll(elemToAdd);
	        //voir à add l'id correspondant aux lignes input concernées
	        
    	}
    	elementHandler.clean();
    }
    
    
    
    
    
    
	/**
     * 
     * @param sspHandler
     * @param id
     * @return whether an element with the aria-labelledby attribute equals to the id
     * passed as argument is found on the page
     */
    private void selectElementWithAriaLabelledbyAttribute (SSPHandler sspHandler, ElementHandler<Element> elementHandler) {
    	
    	for(Element el : elementHandler.get()) {
    		
    		if(el.hasAttr(ARIA_LABELLEDBY_ATTR)) {
    			
    			String query = CssLikeSelectorBuilder.buildSelectorFromAttributeTypeAndValue(
        				ID_ATTR, 
                        el.attr(ARIA_LABELLEDBY_ATTR));
		        
		        Collection<Element> elemToAdd = sspHandler.domCssLikeSelectNodeSet(query).getSelectedElements();
//		        ariaLabelledbyDetected.addAll(elemToAdd);
		        textOfLabels.addAll(elemToAdd);
		        
    		}
    	}
    	elementHandler.clean();
    }
}
