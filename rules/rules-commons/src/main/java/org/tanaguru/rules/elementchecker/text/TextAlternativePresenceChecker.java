/*
 *  Tanaguru - Automated webpage assessment
 *  Copyright (C) 2008-2015  Tanaguru.org
 * 
 *  This file is part of Tanaguru.
 * 
 *  Tanaguru is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 * 
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 *  Contact us by mail: tanaguru AT tanaguru DOT org
 */

package org.tanaguru.rules.elementchecker.text;

import org.jsoup.select.Elements;
import org.tanaguru.processor.SSPHandler;
import org.tanaguru.ruleimplementation.TestSolutionHandler;
import org.tanaguru.rules.elementchecker.ElementCheckerImpl;
import org.tanaguru.rules.elementselector.builder.CssLikeSelectorBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.processor.SSPHandler;
import org.tanaguru.ruleimplementation.ElementHandler;
import org.tanaguru.ruleimplementation.TestSolutionHandler;
import org.tanaguru.rules.elementchecker.ElementCheckerImpl;
import org.tanaguru.rules.textbuilder.TextElementBuilder;

import static org.tanaguru.rules.keystore.AttributeStore.ALT_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABELLEDBY_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABEL_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ID_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.SRC_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.TYPE_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ROLE_ATTR;
import static org.tanaguru.rules.keystore.HtmlElementStore.IMG_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.AREA_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.INPUT_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.SVG_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.EMBED_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.CANVAS_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.OBJECT_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.RemarkMessageStore.INVALID_TEXT_ALTERNATIVE_MSG;

public class TextAlternativePresenceChecker extends ElementCheckerImpl  {

	/**
	 * Exception of alt=""
	 */
	private boolean exception = false;
	
	/**
	 * Unauthorized text alternative attribute detector
	 */
	private boolean unauthorizedAttr = false;
	
	/**
	 * Default Test Solution
	 * If unauthorized text alternative attribute detected
	 */
	private final static TestSolution DEFAULT_INVALID_TEXT_ALTERNATIVE_ATTRIBUTE_TEST_SOLUTION = TestSolution.FAILED;
	
	/**
	 * Default Message Code
	 * If unauthorized text alternative attribute detected
	 */
	private final static String DEFAULT_INVALID_TEXT_ALTERNATIVE_ATTRIBUTE_MSG = INVALID_TEXT_ALTERNATIVE_MSG;

	/**
	 * Attribute to recognize every element
	 */
	private String attrtype=SRC_ATTR;
	
	/**
	 * SSPHandler to check the correspondence between id and aria-labelledby attributes
	 */
	SSPHandler sspHandler;
	
	/**
	 * Basic constructor
	 * @param detectedSolutionPair
	 * @param notDetectedSolutionPair
	 */
	public TextAlternativePresenceChecker(
            Pair<TestSolution, String> detectedSolutionPair,
            Pair<TestSolution, String> notDetectedSolutionPair) {
		super(detectedSolutionPair,notDetectedSolutionPair);
	}
	
	/**
	 * Constructor setting the presence of alt="" exception for decorative image
	 * @param exception
	 * @param detectedSolutionPair
	 * @param notDetectedSolutionPair
	 */
	public TextAlternativePresenceChecker(
			boolean exception,
            Pair<TestSolution, String> detectedSolutionPair,
            Pair<TestSolution, String> notDetectedSolutionPair) {
		this(detectedSolutionPair,notDetectedSolutionPair);
		this.exception = exception;
	}
	
	/**
	 * Constructor setting a different attribute as evidence element
	 * 
	 * @param detectedSolutionPair
	 * @param notDetectedSolutionPair
	 * @param attrtype
	 */
	public TextAlternativePresenceChecker(
            Pair<TestSolution, String> detectedSolutionPair,
            Pair<TestSolution, String> notDetectedSolutionPair,
            String attrtype) {
		this(detectedSolutionPair,notDetectedSolutionPair);
		this.attrtype = attrtype;
	}
	
	@Override
	public void doCheck(SSPHandler sspHandler, Elements elements, TestSolutionHandler testSolutionHandler) {
		
		this.sspHandler = sspHandler;
		for (Element el : elements) {
    		testSolutionHandler.addTestSolution(
    				checkTextAlternativePresence(el));
    	}
		
	}
	
	/**
	 * Check the presence of a text alternative
	 * @param el
	 * @return successSolution if exists
	 */
	private TestSolution checkTextAlternativePresence(Element el) {
		
		if(el == null) {
			return TestSolution.NOT_APPLICABLE;
		}
		
		
		boolean hasTextAlternative = false;
		
		if(hasAlt(el)) {
            addSourceCodeRemark(getSuccessSolution(),el,getSuccessMsgCode());
			hasTextAlternative = true;
		}
		
		if(hasAriaLabelledby(el)) {
            addSourceCodeRemark(getSuccessSolution(),el,getSuccessMsgCode());
			hasTextAlternative = true;
		}
		
		if(hasAriaLabel(el)) {
            addSourceCodeRemark(getSuccessSolution(),el,getSuccessMsgCode());
			hasTextAlternative = true;
		}
		
		if(hasTitle(el)) {
            addSourceCodeRemark(getSuccessSolution(),el,getSuccessMsgCode());
			hasTextAlternative = true;
		}
		
		if(hasTextElement(el)) {
			addSourceCodeRemark(getSuccessSolution(),el,getSuccessMsgCode());
			hasTextAlternative = true;
		}
		
		if(unauthorizedAttr) {
			return DEFAULT_INVALID_TEXT_ALTERNATIVE_ATTRIBUTE_TEST_SOLUTION;
		}
				
		if(!hasTextAlternative) {
			super.setEeAttributes(attrtype);
			if(!hasException(el)) {
				addSourceCodeRemark(getSuccessSolution(),el,getSuccessMsgCode());
				return getSuccessSolution();
			}
			addSourceCodeRemark(getFailureSolution(),el,getFailureMsgCode());
			return getFailureSolution();
		}
		
		return getSuccessSolution();
	}

	/**
	 * checks if the exception alt="" for the decorative image is present or not
	 * @param el
	 * @return true if the exception is verified
	 */
	private boolean hasException(Element el) {
		
		if(exception) {
			if(el.hasAttr(ALT_ATTR) && el.attr(ALT_ATTR).isEmpty()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * checks the <code>alt</code> attribute present 
	 * @param el
	 * @return true if the attribute is detected
	 */
	private boolean hasAlt(Element el) {
		
		if(el.hasAttr(ALT_ATTR)) {
			
			super.setEeAttributes(attrtype,ALT_ATTR);
			
			if(el.tagName().equals(IMG_ELEMENT) ||
					el.tagName().equals(AREA_ELEMENT) ||
					(el.tagName().equals(INPUT_ELEMENT) && el.attr(TYPE_ATTR).equals("image"))) {
				
				if(hasException(el)) {
					return false;
				}
				
	            return true;
			}
			unauthorizedAttr = true;
			addSourceCodeRemark(DEFAULT_INVALID_TEXT_ALTERNATIVE_ATTRIBUTE_TEST_SOLUTION,
					el,DEFAULT_INVALID_TEXT_ALTERNATIVE_ATTRIBUTE_MSG);
		}
		return false;
	}

	/**
	 * checks the <code>aria-labelledby</code> attribute present 
	 * @param el
	 * @return true if the attribute is detected
	 */
	private boolean hasAriaLabelledby(Element el) {

		if(el.hasAttr(ARIA_LABELLEDBY_ATTR)) {
			
			super.setEeAttributes(attrtype,ARIA_LABELLEDBY_ATTR);
			
			if(el.tagName().equals(IMG_ELEMENT) ||
					(el.tagName().equals(INPUT_ELEMENT) && el.attr(TYPE_ATTR).equals("image")) ||
					el.tagName().equals(SVG_ELEMENT) ||
					(el.tagName().equals(OBJECT_ELEMENT) && el.attr(TYPE_ATTR).contains("image")) ||
					(el.tagName().equals(EMBED_ELEMENT) && el.attr(TYPE_ATTR).contains("image")) ||
					el.tagName().equals(CANVAS_ELEMENT) ||
					el.attr(ROLE_ATTR).contains("img")) {
				
				if(correspondenceWithAriaLabelledby(el)) {

		            return true;
				}
			}
			unauthorizedAttr = true;
			addSourceCodeRemark(DEFAULT_INVALID_TEXT_ALTERNATIVE_ATTRIBUTE_TEST_SOLUTION,
					el,DEFAULT_INVALID_TEXT_ALTERNATIVE_ATTRIBUTE_MSG);
		}
		return false;
	}

	/**
	 * checks the <code>aria-label</code> attribute present 
	 * @param el
	 * @return true if the attribute is detected
	 */
	private boolean hasAriaLabel(Element el) {
		
		if(el.hasAttr(ARIA_LABEL_ATTR)) {
			
			super.setEeAttributes(attrtype,ARIA_LABEL_ATTR);
			
			if(el.tagName().equals(IMG_ELEMENT) ||
					el.tagName().equals(AREA_ELEMENT) ||
					(el.tagName().equals(INPUT_ELEMENT) && el.attr(TYPE_ATTR).equals("image")) ||
					el.tagName().equals(SVG_ELEMENT) ||
					(el.tagName().equals(OBJECT_ELEMENT) && el.attr(TYPE_ATTR).contains("image")) ||
					(el.tagName().equals(EMBED_ELEMENT) && el.attr(TYPE_ATTR).contains("image")) ||
					el.tagName().equals(CANVAS_ELEMENT) ||
					el.attr(ROLE_ATTR).contains("img")) {

	            return true;
			}
			unauthorizedAttr = true;
			addSourceCodeRemark(DEFAULT_INVALID_TEXT_ALTERNATIVE_ATTRIBUTE_TEST_SOLUTION,
					el,DEFAULT_INVALID_TEXT_ALTERNATIVE_ATTRIBUTE_MSG);
		}
		return false;
	}

	/**
	 * checks the <code>title</code> attribute present 
	 * @param el
	 * @return true if the attribute is detected
	 */
	private boolean hasTitle(Element el) {

		if(el.hasAttr(TITLE_ATTR)) {
			
			super.setEeAttributes(attrtype,TITLE_ATTR);
			
			if(el.tagName().equals(IMG_ELEMENT) ||
					(el.tagName().equals(INPUT_ELEMENT) && el.attr(TYPE_ATTR).equals("image")) ||
					(el.tagName().equals(OBJECT_ELEMENT) && el.attr(TYPE_ATTR).contains("image")) ||
					(el.tagName().equals(EMBED_ELEMENT) && el.attr(TYPE_ATTR).contains("image"))) {

	            return true;
			}
			unauthorizedAttr = true;
			addSourceCodeRemark(DEFAULT_INVALID_TEXT_ALTERNATIVE_ATTRIBUTE_TEST_SOLUTION,
					el,DEFAULT_INVALID_TEXT_ALTERNATIVE_ATTRIBUTE_MSG);
		}
		return false;
	}

	/**
	 * check if exists id attribute elements corresponding with the aria-labelledby attribute
	 * @param el
	 * @return true if found
	 */
	private boolean correspondenceWithAriaLabelledby(Element el) {

		return !sspHandler.domCssLikeSelectNodeSet(
				CssLikeSelectorBuilder.buildSelectorFromAttributeTypeAndValue(
				ID_ATTR, 
                el.attr(ARIA_LABELLEDBY_ATTR))).getSelectedElements().isEmpty();
	}
	

	/**
	 * check if exists a text element into the svg element
	 * @param el : the element selected
	 * @return true if found
	 */
	private boolean hasTextElement(Element el) {
		
		if(el.tagName().equals(SVG_ELEMENT)) {
			for(Element child : el.children()) {
				if(child.tagName().equals(TEXT_ELEMENT2)) {
					return true;
				}
			}			
		}
		return false;
	}
}
