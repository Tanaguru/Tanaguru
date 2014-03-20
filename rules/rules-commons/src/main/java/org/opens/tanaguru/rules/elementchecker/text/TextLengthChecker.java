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
 * 
 * @author jkowalczyk
 */
public class TextLengthChecker extends ElementCheckerImpl {

    /* the length to test */
    private int lengthLimit;
    /**
     * The message thrown when the text element is too long
     */
    private String textTooLongMessageCode;
    
    /** The text element builder. By default, it is a simple Text builder*/
    private TextElementBuilder testableTextBuilder;
    
    /**
     * Constructor
     * @param testableTextBuilder
     * @param lengthLimit
     * @param textTooLongMessageCode 
     */
    public TextLengthChecker(
            TextElementBuilder testableTextBuilder,
            int lengthLimit, 
            String textTooLongMessageCode) {
        super();
        this.testableTextBuilder = testableTextBuilder;
        this.lengthLimit = lengthLimit;
        this.textTooLongMessageCode = textTooLongMessageCode;
    }
    
    /**
     * Constructor
     * @param testableTextBuilder
     * @param lengthLimit
     * @param textTooLongMessageCode
     * @param eeAttributeNameList 
     */
    public TextLengthChecker(
            TextElementBuilder testableTextBuilder,
            int lengthLimit,
            String textTooLongMessageCode,
            String... eeAttributeNameList) {
        super(eeAttributeNameList);
        this.testableTextBuilder = testableTextBuilder;
        this.lengthLimit = lengthLimit;
        this.textTooLongMessageCode = textTooLongMessageCode;
    }
    
    /**
     * Constructor
     * @param testableTextBuilder
     * @param lengthLimit
     * @param textTooLongSolution
     * @param textTooLongMessageCode
     */
    public TextLengthChecker(
            TextElementBuilder testableTextBuilder,
            int lengthLimit,
            TestSolution textTooLongSolution,
            String textTooLongMessageCode) {
        this(testableTextBuilder, lengthLimit, textTooLongMessageCode);
        setFailureSolution(textTooLongSolution);
    }
    
    /**
     * Constructor
     * @param testableTextBuilder
     * @param lengthLimit
     * @param textTooLongSolution
     * @param textTooLongMessageCode
     * @param eeAttributeNameList 
     */
    public TextLengthChecker(
            TextElementBuilder testableTextBuilder,
            int lengthLimit,
            TestSolution textTooLongSolution,
            String textTooLongMessageCode,
            String... eeAttributeNameList) {
        this(testableTextBuilder, lengthLimit, textTooLongMessageCode, eeAttributeNameList);
        setFailureSolution(textTooLongSolution);
    }

    @Override
    protected void doCheck(
             SSPHandler sspHandler, 
             Elements elements, 
             TestSolutionHandler testSolutionHandler) {
         for (Element element : elements) {
             testSolutionHandler.addTestSolution(
                     checkSizeOfTextDoesNotExceedLengthLimit(
                        element, 
                        testableTextBuilder.buildTextFromElement(element)));
         }
    }
    
    /**
     * 
     * @param element
     * @param elementText
     * @return whether the text exceeds a given size
     */
    private TestSolution checkSizeOfTextDoesNotExceedLengthLimit(
            Element element,
            String elementText) {
        // the test is made through the getter to force the initialisation
        if (element == null || 
                elementText == null) {
            return TestSolution.NOT_APPLICABLE;
        }
        if (elementText.length() > lengthLimit) {
            if (StringUtils.isNotBlank(textTooLongMessageCode)) {
                addSourceCodeRemark(
                    getFailureSolution(), 
                    element, 
                    textTooLongMessageCode);
            }
            return getFailureSolution();
        }
        return getSuccessSolution();
    }

}