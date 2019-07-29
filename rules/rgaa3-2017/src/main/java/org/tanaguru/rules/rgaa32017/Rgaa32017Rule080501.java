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

import static org.tanaguru.entity.audit.TestSolution.FAILED;
import static org.tanaguru.entity.audit.TestSolution.PASSED;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.TITLE_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.RemarkMessageStore.MULTIPLE_TITLE_TAG_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.TITLE_TAG_IN_THE_BODY_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.TITLE_TAG_MISSING_MSG;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.jsoup.nodes.Element;
import org.tanaguru.processor.SSPHandler;
import org.tanaguru.ruleimplementation.AbstractPageRuleWithSelectorAndCheckerImplementation;
import org.tanaguru.ruleimplementation.ElementHandler;
import org.tanaguru.ruleimplementation.ElementHandlerImpl;
import org.tanaguru.ruleimplementation.TestSolutionHandler;
import org.tanaguru.rules.elementchecker.ElementChecker;
import org.tanaguru.rules.elementchecker.element.ElementPresenceChecker;
import org.tanaguru.rules.elementselector.MultipleElementSelector;

/**
 * Implementation of the rule 8.5.1 of the referential Rgaa 3-2017.
 * <br>
 * For more details about the implementation, refer to <a href="http://tanaguru-rules-rgaa3.readthedocs.org/en/latest/Rule-8-5-1">the rule 8.5.1 design page.</a>
 * @see <a href="http://references.modernisation.gouv.fr/referentiel-technique-0#test-8-5-1"> 8.5.1 rule specification</a>
 *
 */
public class Rgaa32017Rule080501 extends AbstractPageRuleWithSelectorAndCheckerImplementation {
    
	/* ElementHandler to keep all title element present in the head part */
    private final ElementHandler<Element> titleElementInBody = new ElementHandlerImpl();
    
    /* ElementHandler to keep all title element present in the body part */
    private final ElementHandler<Element> titleElementInHead = new ElementHandlerImpl();
    
    /* First title element detected in the head part */
    private Element firstHeadElement;
    
    /**
     * Default constructor
     */
    public Rgaa32017Rule080501(){
    	 super();
    	 setElementSelector(new MultipleElementSelector(TITLE_CSS_LIKE_QUERY)); 
    }
    
    
    
	protected void select(SSPHandler sspHandler) {
        super.select(sspHandler);                 
        
        for (Element el : getElements().get()) {
	    	
	    	for(Element element : el.parents()) {

	    		// title in svg element isn't used for a title page so it's out of scope
		    	if(element.tagName().equals("svg")) {
		    		break;
		    	}
		    	
	    		if(element.tagName().equals("head")) {

	    			if(titleElementInHead.isEmpty()) {
		    	  		firstHeadElement = el;
		    	  	}
	    			titleElementInHead.add(el);
	    		}
		    	  	
	    		if(element.tagName().equals("body")) {
	    			titleElementInBody.add(el);
	    		}
	    	}
        }
	 }
    

	protected void check(SSPHandler sspHandler, TestSolutionHandler testSolutionHandler) {
        
        //check if there is no title tag in the head
  		if(titleElementInHead.isEmpty()) {

  			ElementChecker ec = new ElementPresenceChecker( 
                      new ImmutablePair(FAILED,""),
                      new ImmutablePair(FAILED, TITLE_TAG_MISSING_MSG));
  			ec.check(sspHandler, titleElementInHead, testSolutionHandler);
  		}
  		
  		//check if there is title tag in the head
  		if (!titleElementInHead.isEmpty()) {
  			
  			if(titleElementInHead.size() == 1 ) {
  				
  				ElementChecker ec = new ElementPresenceChecker( 
					   	new ImmutablePair(PASSED,""),
					    new ImmutablePair(FAILED,""),
					    TEXT_ELEMENT2);
			    ec.check(sspHandler, titleElementInHead, testSolutionHandler);
			    
  			}else {

				//Remove the first title element detected to leave the others detected 
	  			titleElementInHead.remove(firstHeadElement);
	  			
	  			ElementChecker ec = new ElementPresenceChecker(
						new ImmutablePair(FAILED,MULTIPLE_TITLE_TAG_MSG),
					    new ImmutablePair(PASSED,""),
					    TEXT_ELEMENT2);
			    ec.check(sspHandler, titleElementInHead, testSolutionHandler);
  				
  			}
  		}
		  
  		
  		//check if there is title tag in the body
		if(!titleElementInBody.isEmpty()){
			 
			if(titleElementInBody.size() == 1 ) {

				ElementChecker ec = new ElementPresenceChecker( 
						new ImmutablePair(FAILED, TITLE_TAG_IN_THE_BODY_MSG),
						new ImmutablePair(PASSED,""),
						TEXT_ELEMENT2);
				ec.check(sspHandler, titleElementInBody, testSolutionHandler);
			     
			}else {
				
				ElementChecker ec = new ElementPresenceChecker( 
						new ImmutablePair(FAILED,MULTIPLE_TITLE_TAG_MSG),
						new ImmutablePair(PASSED,""),
						TEXT_ELEMENT2);
				ec.check(sspHandler, titleElementInBody, testSolutionHandler);
			}
		}
	}
}



