/*
 *  Tanaguru - Automated webpage assessment
 *  Copyright (C) 2008-2013  Open-S Company
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
 *  Contact us by mail: open-s AT open-s DOT com
 */

package org.opens.tanaguru.rules.elementchecker.text;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.opens.tanaguru.entity.audit.TestSolution;
import org.opens.tanaguru.processor.SSPHandler;
import org.opens.tanaguru.ruleimplementation.TestSolutionHandler;
import org.opens.tanaguru.rules.elementchecker.ElementCheckerImpl;
import org.opens.tanaguru.rules.textbuilder.TextElementBuilder;

/**
 * This class checks whether the content of an text is empty.
 */
public class TextEmptinessChecker extends ElementCheckerImpl {

    /*
     * The message code associated with a processRemark when the attribute is
     * empty on an element
     */
    private String messageCodeOnTextEmpty;
    
    /* 
     * The message code associated with a processRemark when the attribute is
     * empty on an element
     */
    private String messageCodeOnTextNotEmpty;
    
    /* The text element builder. By default, it is a simple Text builder */
    private TextElementBuilder testableTextBuilder;
    
    /**
     * Constructor. 
     * Returns FAILED when the text is empty and PASSED when it is not.
     * 
     * @param testableTextBuilder
     * @param messageCodeOnTextEmpty
     * @param messageCodeOnTextNotEmpty
     */
    public TextEmptinessChecker(
            TextElementBuilder testableTextBuilder,
            String messageCodeOnTextEmpty, 
            String messageCodeOnTextNotEmpty) {
        super();
        this.testableTextBuilder = testableTextBuilder;
        this.messageCodeOnTextEmpty = messageCodeOnTextEmpty;
        this.messageCodeOnTextNotEmpty = messageCodeOnTextNotEmpty;
    }
    
    /**
     * Constructor.
     * Returns FAILED when the text is empty and PASSED when it is not.
     * 
     * @param testableTextBuilder
     * @param messageCodeOnTextEmpty
     * @param messageCodeOnTextNotEmpty
     * @param eeAttributeNameList 
     */
    public TextEmptinessChecker(
            TextElementBuilder testableTextBuilder,
            String messageCodeOnTextEmpty, 
            String messageCodeOnTextNotEmpty, 
            String... eeAttributeNameList) {
        super(eeAttributeNameList);
        this.testableTextBuilder = testableTextBuilder;
        this.messageCodeOnTextEmpty = messageCodeOnTextEmpty;
        this.messageCodeOnTextNotEmpty = messageCodeOnTextNotEmpty;
    }
    
    /**
     * Constructor.
     * 
     * @param testableTextBuilder
     * @param textEmptySolution
     * @param textNotEmptySolution
     * @param messageCodeOnTextEmpty
     * @param messageCodeOnTextNotEmpty
     */
    public TextEmptinessChecker(
            TextElementBuilder testableTextBuilder,
            TestSolution textEmptySolution,
            TestSolution textNotEmptySolution,
            String messageCodeOnTextEmpty, 
            String messageCodeOnTextNotEmpty) {
        this(testableTextBuilder, 
             messageCodeOnTextEmpty, 
             messageCodeOnTextNotEmpty);
        setSuccessSolution(textNotEmptySolution);
        setFailureSolution(textEmptySolution);
    }
    
    /**
     * Constructor 
     * 
     * @param testableTextBuilder
     * @param textEmptySolution
     * @param textNotEmptySolution
     * @param messageCodeOnTextEmpty
     * @param messageCodeOnTextNotEmpty
     * @param eeAttributeNameList 
     */
    public TextEmptinessChecker(
            TextElementBuilder testableTextBuilder,
            TestSolution textEmptySolution,
            TestSolution textNotEmptySolution,
            String messageCodeOnTextEmpty, 
            String messageCodeOnTextNotEmpty, 
            String... eeAttributeNameList) {
        this(testableTextBuilder, 
             messageCodeOnTextEmpty, 
             messageCodeOnTextNotEmpty, 
             eeAttributeNameList);
        setSuccessSolution(textNotEmptySolution);
        setFailureSolution(textEmptySolution);
    }
    
    @Override
    public void doCheck(
            SSPHandler sspHandler, 
            Elements elements, 
            TestSolutionHandler testSolutionHandler) {
        checkEmptiness(
                elements, 
                testSolutionHandler);
    }

    /**
     * This methods checks whether a given attribute is empty for a set of
     * elements
     * 
     * @param elements
     * @param testSolutionHandler
     */
    private void checkEmptiness (
            Elements elements, 
            TestSolutionHandler testSolutionHandler) {
        
        if (elements.isEmpty()) {
            testSolutionHandler.addTestSolution(TestSolution.NOT_APPLICABLE);
            return;
        }
        
        TestSolution testSolution = TestSolution.NOT_APPLICABLE;
        String textElement;
        for (Element el : elements) {
            textElement = testableTextBuilder.buildTextFromElement(el);
            if (textElement == null)  {
                testSolution = setTestSolution(testSolution, 
                                               TestSolution.NOT_APPLICABLE);
            } else if (isElementEmpty(textElement)) {
                testSolution = setTestSolution(testSolution, 
                                               getFailureSolution());
                if (StringUtils.isNotBlank(messageCodeOnTextEmpty)) {
                    addSourceCodeRemark(
                            getFailureSolution(), 
                            el, 
                            messageCodeOnTextEmpty);
                }
            } else {
                testSolution = setTestSolution(testSolution, 
                                               getSuccessSolution());
                if (StringUtils.isNotBlank(messageCodeOnTextNotEmpty)) {
                    addSourceCodeRemark(
                            getSuccessSolution(), 
                            el, 
                            messageCodeOnTextNotEmpty);
                }
            }
        }
        testSolutionHandler.addTestSolution(testSolution);
    }

    /**
     * 
     * @param element
     * @return whether an element is seen as empty
     */
    private boolean isElementEmpty(String textElement) {
        return StringUtils.isBlank(textElement);
    }

}