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
package org.tanaguru.ruleimplementation.impl.table;

import org.jsoup.nodes.Element;
import org.tanaguru.processor.SSPHandler;
import org.tanaguru.ruleimplementation.AbstractPageRuleWithSelectorAndCheckerImplementation;
import org.tanaguru.ruleimplementation.ElementHandler;
import org.tanaguru.ruleimplementation.ElementHandlerImpl;
import org.tanaguru.ruleimplementation.TestSolutionHandler;
import org.tanaguru.rules.elementchecker.IndependentChecker;
import org.tanaguru.rules.elementchecker.pertinence.AttributePertinenceChecker;
import org.tanaguru.rules.elementchecker.pertinence.TextPertinenceChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;
import org.tanaguru.rules.elementselector.builder.CssLikeSelectorBuilder;
import org.tanaguru.rules.textbuilder.OwnTextElementBuilder;

import static org.tanaguru.rules.keystore.AttributeStore.*;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.DATA_TABLE_WITH_TITLE_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.HtmlElementStore.CAPTION_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.RemarkMessageStore.TABLE_TITLE_NOT_RELEVANT_CONTENT;
import static org.tanaguru.rules.keystore.RemarkMessageStore.TABLE_TITLE_RELEVANT_CONTENT;

/**
 * Implementation of the rule 5-5-1 of the referential Rgaa4 2019.
 *
 * @see <a href="http://www.example.com/refential-descriptor.html#test-5-5-1"> 5-5-1 rule specification</a>
 *
 * @author edaconceicao
 */

public class DataTableTitleIdentifyContent extends AbstractPageRuleWithSelectorAndCheckerImplementation {

	private ElementHandler<Element> textElementDetected = new ElementHandlerImpl();
    /**
     * Default constructor
     */
    public DataTableTitleIdentifyContent() {
        super(new SimpleElementSelector(DATA_TABLE_WITH_TITLE_CSS_LIKE_QUERY),
        		new IndependentChecker(
        				new AttributePertinenceChecker(
        						//Attribute to check
        						ARIA_LABEL_ATTR,
        						//if check emptiness
        						true,
        						//Compare with something
        						null,
        						//belong to a black list
        						null,
        						//message for a not pertinent attribute text
        						TABLE_TITLE_NOT_RELEVANT_CONTENT,
        						//message for a pertinent attribute text
        						TABLE_TITLE_RELEVANT_CONTENT,
        						//evidence list
        						ARIA_LABEL_ATTR),
        				new AttributePertinenceChecker(
        						//Attribute to check
        						TITLE_ATTR,
        						//if check emptiness
        						true,
        						//Compare with something
        						null,
        						//belong to a black list
        						null,
        						//message for a not pertinent attribute text
        						TABLE_TITLE_NOT_RELEVANT_CONTENT,
        						//message for a pertinent attribute text
        						TABLE_TITLE_RELEVANT_CONTENT,
        						//evidence list
        						TITLE_ATTR)));
    }
    
    protected void select(SSPHandler sspHandler) {
    	super.select(sspHandler);
    	
    	ElementHandler<Element> toRemove = new ElementHandlerImpl();
    	
    	for(Element el : getElements().get()) {
    		if(el.select(CAPTION_ELEMENT).first()!=null) {
    			textElementDetected.add(el.select(CAPTION_ELEMENT).first());
    			toRemove.add(el);
    		}
    		if(!el.attr(ARIA_LABELLEDBY_ATTR).isEmpty()) {
    			textElementDetected.addAll(sspHandler.domCssLikeSelectNodeSet(
        				CssLikeSelectorBuilder.buildSelectorFromAttributeTypeAndValue(
        				ID_ATTR, 
                        el.attr(ARIA_LABELLEDBY_ATTR))).getSelectedElements());
    			toRemove.add(el);
    		}
    	}
    }
    
    protected void check(
            SSPHandler sspHandler, 
            TestSolutionHandler testSolutionHandler) {
    	super.check(sspHandler, testSolutionHandler);
    	if(!textElementDetected.isEmpty()) {
	    			new TextPertinenceChecker(
	                	new OwnTextElementBuilder(),
	                    // check emptiness
	                    true, 
	                    // no comparison with other attribute
	                    null,
	                    // no comparison with blacklist
	                    null,
	                    // not pertinent message
	                    TABLE_TITLE_NOT_RELEVANT_CONTENT, 
	                    // manual check message
	                    TABLE_TITLE_RELEVANT_CONTENT, 
	                    // evidence element
	                    TEXT_ELEMENT2).check(
	                    		sspHandler, 
	                    		textElementDetected, 
	                    		testSolutionHandler);	    			
    	}
    }
}