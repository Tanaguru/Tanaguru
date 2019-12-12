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
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.processor.SSPHandler;
import org.tanaguru.ruleimplementation.AbstractMarkerPageRuleImplementation;
import org.tanaguru.ruleimplementation.ElementHandler;
import org.tanaguru.ruleimplementation.ElementHandlerImpl;
import org.tanaguru.ruleimplementation.TestSolutionHandler;
import org.tanaguru.rules.elementchecker.ElementChecker;
import org.tanaguru.rules.elementchecker.pertinence.AttributePertinenceChecker;
import org.tanaguru.rules.elementchecker.pertinence.TextPertinenceChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;
import org.tanaguru.rules.elementselector.builder.CssLikeSelectorBuilder;
import org.tanaguru.rules.textbuilder.OwnTextElementBuilder;

import static org.tanaguru.rules.keystore.AttributeStore.*;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.DATA_TABLE_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.HtmlElementStore.CAPTION_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.MarkerStore.*;
import static org.tanaguru.rules.keystore.RemarkMessageStore.*;

/**
 * Implementation of the rule 5-2-1 of the referential Rgaa4 2019.
 *
 * @see <a href="http://www.example.com/refential-descriptor.html#test-5-2-1"> 5-2-1 rule specification</a>
 *
 * @author edaconceicao
 */

public class ComplexDataTableSummaryIsPertinent extends AbstractMarkerPageRuleImplementation {
	
	
	private final ElementHandler<Element> summaryMarkerDetected = new ElementHandlerImpl();
	private final ElementHandler<Element> summaryRegularDetected = new ElementHandlerImpl();
	private final ElementHandler<Element> summaryTextMarkerDetected = new ElementHandlerImpl();
	private final ElementHandler<Element> summaryTextRegularDetected = new ElementHandlerImpl();
	private final ElementHandler<Element> textMarkerDetected = new ElementHandlerImpl();
	private final ElementHandler<Element> textRegularDetected = new ElementHandlerImpl();
	
	
    /**
     * Default constructor
     */
    public ComplexDataTableSummaryIsPertinent() {
    	super(
                // the complex tables are part of the scope
                new String[]{COMPLEX_TABLE_MARKER},

                // the data and presentation tables are not part of the scope
                new String[]{PRESENTATION_TABLE_MARKER, DATA_TABLE_MARKER});
    	
    	setElementSelector(new SimpleElementSelector(DATA_TABLE_CSS_LIKE_QUERY)); 
    }

    @Override
    protected void select(SSPHandler sspHandler) {
        super.select(sspHandler);
        
        for (Element el : getSelectionWithoutMarkerHandler().get()) {
        	if(el.hasAttr(SUMMARY_ATTR)){
        		summaryRegularDetected.add(el);
        	}
        	if(!el.attr(ARIA_DESCRIBEDBY_ATTR).isEmpty()) {
        		summaryTextRegularDetected.addAll(sspHandler.domCssLikeSelectNodeSet(
        				CssLikeSelectorBuilder.buildSelectorFromAttributeTypeAndValue(
        				ID_ATTR, 
                        el.attr(ARIA_DESCRIBEDBY_ATTR))).getSelectedElements());
        	}
        	if(el.select(CAPTION_ELEMENT).first()!=null) {
        		textRegularDetected.add(el.select(CAPTION_ELEMENT).first());
        	}
        }
                
        
        for (Element el : getSelectionWithMarkerHandler().get()) {
        	if(el.hasAttr(SUMMARY_ATTR)){
        		summaryMarkerDetected.add(el);
        	}
        	if(!el.attr(ARIA_DESCRIBEDBY_ATTR).isEmpty()) {
        		summaryTextMarkerDetected.addAll(sspHandler.domCssLikeSelectNodeSet(
        				CssLikeSelectorBuilder.buildSelectorFromAttributeTypeAndValue(
        				ID_ATTR, 
                        el.attr(ARIA_DESCRIBEDBY_ATTR))).getSelectedElements());
        	}
        	if(el.select(CAPTION_ELEMENT).first()!=null) {
        		textMarkerDetected.add(el.select(CAPTION_ELEMENT).first());
        	}
        }
    }
    
    protected void check(SSPHandler sspHandler, TestSolutionHandler testSolutionHandler) {
    	
    	
    	if(!summaryMarkerDetected.isEmpty()) {
    		ElementChecker ec = new AttributePertinenceChecker(
					SUMMARY_ATTR,
					true,
					null,
					null,
	                TestSolution.FAILED,
	                NOT_PERTINENT_SUMMARY_MSG,
					CHECK_SUMMARY_PERTINENCE_FOR_DATA_TABLE_MSG,
					SUMMARY_ATTR);
    		ec.check(sspHandler, summaryMarkerDetected, testSolutionHandler);
    	}
    	
    	if(!summaryRegularDetected.isEmpty()) {
    		ElementChecker ec = new AttributePertinenceChecker(
    				SUMMARY_ATTR,
    				true,
    				null,
    				null,
    				TestSolution.NEED_MORE_INFO, 
    				CHECK_NATURE_OF_TABLE_FOR_NOT_PERTINENT_SUMMARY_MSG,
    				CHECK_NATURE_OF_TABLE_AND_SUMMARY_PERTINENCE_MSG,
					SUMMARY_ATTR);
    		ec.check(sspHandler, summaryRegularDetected, testSolutionHandler);
    	}
    	
    	if(!summaryTextMarkerDetected.isEmpty()) {
    		ElementChecker ec = new TextPertinenceChecker(
                	new OwnTextElementBuilder(),
                    // check emptiness
                    true, 
                    // no comparison with other attribute
                    null,
                    // no comparison with blacklist
                    null,
                    // not pertinent message
                    NOT_PERTINENT_SUMMARY_TEXT_FOR_COMPLEX_TABLE_MSG, 
                    // manual check message
                    CHECK_SUMMARY_TEXT_PERTINENCE_FOR_COMPLEX_TABLE_MSG, 
                    // evidence element
                    TEXT_ELEMENT2);
            		ec.check(sspHandler, summaryTextMarkerDetected, testSolutionHandler);
    	}
    	
    	if(!summaryTextRegularDetected.isEmpty()) {
    		ElementChecker ec = new TextPertinenceChecker(
                    new OwnTextElementBuilder(),
                   // check emptiness
                    true, 
                    // no comparison with other attribute
                    null,
                    // no comparison with blacklist
                    null,
                    TestSolution.NEED_MORE_INFO,
                    // not pertinent message
                    CHECK_TABLE_IS_COMPLEX_FOR_NOT_PERTINENT_SUMMARY_TEXT_MSG, 
                    // manual check message
                    CHECK_TABLE_IS_COMPLEX_AND_SUMMARY_TEXT_PERTINENCE_MSG,
                    // evidence element
                    TEXT_ELEMENT2);
    		ec.check(sspHandler, summaryTextRegularDetected, testSolutionHandler);
    	}
    	
    	if(!textMarkerDetected.isEmpty()) {
    		ElementChecker ec = new TextPertinenceChecker(
                	new OwnTextElementBuilder(),
                    // check emptiness
                    true, 
                    // no comparison with other attribute
                    null,
                    // no comparison with blacklist
                    null,
                    // not pertinent message
                    NOT_PERTINENT_CAPTION_FOR_COMPLEX_TABLE_MSG, 
                    // manual check message
                    CHECK_CAPTION_PERTINENCE_FOR_COMPLEX_TABLE_MSG, 
                    // evidence element
                    TEXT_ELEMENT2);
            		ec.check(sspHandler, textMarkerDetected, testSolutionHandler);
    	}
    	
    	if(!textRegularDetected.isEmpty()) {
    		ElementChecker ec = new TextPertinenceChecker(
                    new OwnTextElementBuilder(),
                   // check emptiness
                    true, 
                    // no comparison with other attribute
                    null,
                    // no comparison with blacklist
                    null,
                    TestSolution.NEED_MORE_INFO,
                    // not pertinent message
                    CHECK_TABLE_IS_COMPLEX_FOR_NOT_PERTINENT_CAPTION_MSG, 
                    // manual check message
                    CHECK_TABLE_IS_COMPLEX_AND_CAPTION_PERTINENCE_MSG,
                    // evidence element
                    TEXT_ELEMENT2);
            		ec.check(sspHandler, textRegularDetected, testSolutionHandler);
    	}
    	
    }

}