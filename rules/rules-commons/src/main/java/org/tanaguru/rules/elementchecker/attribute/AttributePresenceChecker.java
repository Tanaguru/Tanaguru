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

import java.util.Collection;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.processor.SSPHandler;
import org.tanaguru.ruleimplementation.TestSolutionHandler;
import org.tanaguru.rules.elementchecker.ElementCheckerImpl;

/**
 * This checker controls the presence of an attribute for a set of elements.
 * 
 */
public class AttributePresenceChecker extends ElementCheckerImpl {

    /**
     * the attribute the test is about
     */
    private final String attributeName;
    
    /**
     * 
     */
    private Collection<String> markerElementsValues ; 
    
    /**
     * This flag determines whether each source code remark have to be related 
     * with the element or the attribute itself. Default is false
     */
    private boolean createSourceCodeRemarkOnAttribute = false;
    
    /**
     * Use constructor with Pair instead
     * @param attributeName
     * @param detectedSolution
     * @param notDetectedSolution
     * @param messageCodeOnAttrDetected
     * @param messageCodeOnAttrNotDetected
     * @param eeAttributeNameList 
     */
    @Deprecated
    public AttributePresenceChecker(
            String attributeName, 
            TestSolution detectedSolution,
            TestSolution notDetectedSolution,
            String messageCodeOnAttrDetected, 
            String messageCodeOnAttrNotDetected, 
            String...eeAttributeNameList) {
        this(
                attributeName,
                new ImmutablePair(detectedSolution,messageCodeOnAttrDetected), 
                new ImmutablePair(notDetectedSolution,messageCodeOnAttrNotDetected),
                eeAttributeNameList);
    }
    
    /**
     * 
     * @param attributeName
     * @param detectedSolutionPair
     * @param notDetectedSolutionPair
     * @param eeAttributeNameList 
     */
    public AttributePresenceChecker(
            String attributeName, 
            Pair<TestSolution,String> detectedSolutionPair,
            Pair<TestSolution,String> notDetectedSolutionPair,
            String...eeAttributeNameList) {
        super(detectedSolutionPair, notDetectedSolutionPair,eeAttributeNameList);
        this.attributeName = attributeName;
    }
    
    /**
     * 
     * @param attributeName
     * @param markerElementsValues
     * @param detectedSolutionPair
     * @param notDetectedSolutionPair
     * @param eeAttributeNameList 
     */
    public AttributePresenceChecker(
            String attributeName, 
            Collection<String> markerElementsValues,
            Pair<TestSolution,String> detectedSolutionPair,
            Pair<TestSolution,String> notDetectedSolutionPair,
            String...eeAttributeNameList) {
        super(detectedSolutionPair, notDetectedSolutionPair,eeAttributeNameList);
        this.attributeName = attributeName;
        this.markerElementsValues = markerElementsValues;
    }
    
    /**
     * Use constructor with Pair instead
     * @param attributeName
     * @param detectedSolution
     * @param notDetectedSolution
     * @param messageCodeOnAttrDetected
     * @param messageCodeOnAttrNotDetected
     * @param createSourceCodeRemarkOnAttribute
     * @param eeAttributeNameList 
     */
    @Deprecated
    public AttributePresenceChecker(
            String attributeName, 
            TestSolution detectedSolution,
            TestSolution notDetectedSolution,
            String messageCodeOnAttrDetected, 
            String messageCodeOnAttrNotDetected, 
            boolean createSourceCodeRemarkOnAttribute, 
            String...eeAttributeNameList) {
        this(
                attributeName,
                new ImmutablePair(detectedSolution,messageCodeOnAttrDetected), 
                new ImmutablePair(notDetectedSolution,messageCodeOnAttrNotDetected),
                createSourceCodeRemarkOnAttribute,
                eeAttributeNameList);
    }
    
    /**
     * 
     * @param attributeName
     * @param detectedSolutionPair
     * @param notDetectedSolutionPair
     * @param createSourceCodeRemarkOnAttribute
     * @param eeAttributeNameList 
     */
    public AttributePresenceChecker(
            String attributeName, 
            Pair<TestSolution,String> detectedSolutionPair,
            Pair<TestSolution,String> notDetectedSolutionPair,
            boolean createSourceCodeRemarkOnAttribute, 
            String...eeAttributeNameList) {
        super(detectedSolutionPair, notDetectedSolutionPair, eeAttributeNameList);
        this.attributeName = attributeName;
        this.createSourceCodeRemarkOnAttribute = createSourceCodeRemarkOnAttribute;
    }
    
    @Override
    public void doCheck(
            SSPHandler sspHandler, 
            Elements elements, 
            TestSolutionHandler testSolutionHandler) {
    	
        checkAttributePresence(
        		removeMarkerElementsWithValuePresenceChecher(elements), 
                testSolutionHandler);
    }

    /**
     * This methods checks whether a given attribute is present for a set of 
     * elements
     * 
     * @param elements
     * @param testSolutionHandler
     */
    private void checkAttributePresence (
            Elements elements, 
            TestSolutionHandler testSolutionHandler) {
        
        if (elements.isEmpty()) {
            testSolutionHandler.addTestSolution(TestSolution.NOT_APPLICABLE);
            return;
        }
        
        TestSolution testSolution = TestSolution.PASSED;
        
        for (Element el : elements) {
            if (!el.hasAttr(attributeName)) {

                testSolution = setTestSolution(testSolution, getFailureSolution());
                createSourceCodeRemark(getFailureSolution(), el, getFailureMsgCode());

            } else {
                testSolution = setTestSolution(testSolution, getSuccessSolution());
                createSourceCodeRemark(getSuccessSolution(), el, getSuccessMsgCode());

            }
        }
        
        testSolutionHandler.addTestSolution(testSolution);
        
    }
    
    /**
     * This methods checks whether a given attribute is present and if the value correspond to a marker value : 
     * in this case, the element is out of scope because its uses it to be marked
     * @param elements
     */
    private Elements removeMarkerElementsWithValuePresenceChecher (
            Elements elements) {
        
        if (markerElementsValues == null ||
        		markerElementsValues.isEmpty() ) {
            return elements;
        }
        
        Elements elementsToCheck = new Elements();
        for (Element el : elements) {
        	if (el.hasAttr(attributeName)) {
        		boolean found = false;
        		for(String str : markerElementsValues) {
            		if(el.attr(attributeName).equals(str)) {
            			found = true;
            			break;
            		}
            	}
        		if(!found) {
        			elementsToCheck.add(el);        			
        		}
            }
        }
        return elementsToCheck;
        
    }
    /**
     * 
     * @param testSolution
     * @param element
     * @param message 
     */
    private void createSourceCodeRemark (TestSolution testSolution, Element element, String message) {
        if (createSourceCodeRemarkOnAttribute) {
            addSourceCodeRemarkOnAttribute(
                    testSolution, 
                    element, 
                    message, 
                    attributeName);
        } else {
            addSourceCodeRemark(
                    testSolution, 
                    element, 
                    message);
        }
    }
    
}
