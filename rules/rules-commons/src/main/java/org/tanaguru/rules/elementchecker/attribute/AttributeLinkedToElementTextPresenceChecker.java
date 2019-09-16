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

package org.tanaguru.rules.elementchecker.attribute;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.processor.SSPHandler;
import org.tanaguru.ruleimplementation.TestSolutionHandler;
import org.tanaguru.rules.elementchecker.ElementCheckerImpl;
import org.tanaguru.rules.elementselector.builder.CssLikeSelectorBuilder;

import org.apache.commons.lang3.tuple.Pair;

/**
 * Checker detects : 
 * First if two elements are liked 
 * Second if text is present
 * @author edaconceicao
 *
 */
public class AttributeLinkedToElementTextPresenceChecker extends ElementCheckerImpl {

	/**
	 * Attribute belongs to the selected element, to check correspondences 
	 */
	private String attributeToCheck;
	
	/**
	 * Attribute compares to attributeToCheck and belongs to an other element
	 */
	private String attributeToLinkWith;
	
	/**
	 * The constructor
	 * @param attributeToCheck
	 * @param attributeToLinkWith
	 * @param detectedSolutionPair
	 * @param notDetectedSolutionPair
	 * @param eeAttributeNameList
	 */
	public AttributeLinkedToElementTextPresenceChecker(
			String attributeToCheck,
			String attributeToLinkWith,
            Pair<TestSolution, String> detectedSolutionPair,
            Pair<TestSolution, String> notDetectedSolutionPair,
            String... eeAttributeNameList) {
		super(detectedSolutionPair, notDetectedSolutionPair,eeAttributeNameList);
		this.attributeToCheck = attributeToCheck;
		this.attributeToLinkWith = attributeToLinkWith;
	}
	
	@Override
	protected void doCheck(SSPHandler sspHandler, Elements elements, TestSolutionHandler testSolutionHandler) {
		
		for (Element el : elements) {
    		testSolutionHandler.addTestSolution(
    				checkCorrespondence(el , sspHandler));
    	}
	}
	
	/**
	 * Check the correspondence exists between to elements and 
	 * check if a text is present 
	 * @param el
	 * @param sspHandler
	 * @return
	 */
	private TestSolution checkCorrespondence(Element el, SSPHandler sspHandler) {
		
		TestSolution ts = getSuccessSolution();
		
		if(el.attr(attributeToCheck).isEmpty()) {
			return TestSolution.NOT_APPLICABLE;
		}
		
		//Storage linked elements to the "el"
		Elements elements = correspondenceAttributeToCheck(el , sspHandler);
		
		if(elements.isEmpty()) {
			
			addSourceCodeRemark(getFailureSolution(),el,getFailureMsgCode());
			return getFailureSolution();
			
		}else {
			
			//check for each storage element its text
			for(Element elem : elements) {
				
				if(!elem.text().isEmpty()) {
					
					addSourceCodeRemark(getSuccessSolution(),elem,getSuccessMsgCode());
					
				}else {
					
					//return the linked element having an empty text
					addSourceCodeRemark(getFailureSolution(),elem,getFailureMsgCode());
					ts = getFailureSolution();
				}
			}
		}
		
		return ts;
	}


	/**
	 * check if exists id attribute elements corresponding with the aria-labelledby attribute
	 * @param el
	 * @return true if found
	 */
	private Elements correspondenceAttributeToCheck(Element el, SSPHandler sspHandler) {

		return sspHandler.domCssLikeSelectNodeSet(
				CssLikeSelectorBuilder.buildSelectorFromAttributeTypeAndValue(
				attributeToLinkWith, 
                el.attr(attributeToCheck))).getSelectedElements();
	}

}
