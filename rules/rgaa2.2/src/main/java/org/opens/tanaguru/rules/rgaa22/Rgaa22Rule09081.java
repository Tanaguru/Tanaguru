/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2013  Open-S Company
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
 * Contact us by mail: open-s AT open-s DOT com
 */
package org.opens.tanaguru.rules.rgaa22;

import org.jsoup.nodes.Element;
import org.opens.tanaguru.entity.audit.TestSolution;
import org.opens.tanaguru.processor.SSPHandler;
import org.opens.tanaguru.ruleimplementation.AbstractPageRuleMarkupImplementation;
import org.opens.tanaguru.ruleimplementation.ElementHandler;
import org.opens.tanaguru.ruleimplementation.ElementHandlerImpl;
import org.opens.tanaguru.ruleimplementation.TestSolutionHandler;
import org.opens.tanaguru.rules.elementchecker.lang.LangChecker;
import org.opens.tanaguru.rules.elementchecker.lang.LangDeclarationValidityChecker;
import org.opens.tanaguru.rules.elementselector.ElementSelector;
import org.opens.tanaguru.rules.elementselector.SimpleElementSelector;
import static org.opens.tanaguru.rules.keystore.AttributeStore.LANG_ATTR;
import static org.opens.tanaguru.rules.keystore.AttributeStore.XML_LANG_ATTR;
import static org.opens.tanaguru.rules.keystore.CssLikeQueryStore.*;
import static org.opens.tanaguru.rules.keystore.HtmlElementStore.HTML_ELEMENT;
import static org.opens.tanaguru.rules.keystore.RemarkMessageStore.LANG_ATTRIBUTE_MISSING_ON_HTML_TAG_MSG;
import static org.opens.tanaguru.rules.keystore.RemarkMessageStore.LANG_ATTRIBUTE_MISSING_ON_WHOLE_PAGE_MSG;

/**
 * Implementation of the rule 9.8 of the referential RGAA 2.2. <br/> For more
 * details about the implementation, refer to <a
 * href="http://www.tanaguru.org/en/content/rgaa22-rule-9-8">the rule 9.8 design
 * page.</a>
 *
 * @see <a href="http://rgaa.net/Presence-d-une-langue-de.html"> 9.8 rule
 * specification
 *
 * @author jkowalczyk
 */
public class Rgaa22Rule09081 extends AbstractPageRuleMarkupImplementation {

    /**
     * the elements with a lang attribute
     */
    private ElementHandler elementWithLang = new ElementHandlerImpl();
    /**
     * the elements without lang attribute
     */
    private ElementHandler elementWithoutLang = new ElementHandlerImpl();

    /**
     * Default constructor
     */
    public Rgaa22Rule09081() {
        super();
    }

    @Override
    protected void select(SSPHandler sspHandler, ElementHandler<Element> elementHandler) {
        ElementSelector selector = new SimpleElementSelector(HTML_WITH_LANG_CSS_LIKE_QUERY);
        selector.selectElements(sspHandler, elementHandler);
        
        selector = new SimpleElementSelector(ELEMENT_WITH_LANG_ATTR_CSS_LIKE_QUERY);
        selector.selectElements(sspHandler, elementWithLang);
        if (elementWithLang.isEmpty()) {
            return;
        }
        selector = new SimpleElementSelector(ELEMENT_WITHOUT_LANG_ATTR_CSS_LIKE_QUERY);
        selector.selectElements(sspHandler, elementWithoutLang);
        removeElementWithParentWithLangAttr(elementWithoutLang);
    }

    @Override
    protected void check(
            SSPHandler sspHandler,
            ElementHandler selectionHandler,
            TestSolutionHandler testSolutionHandler) {

        if (!selectionHandler.isEmpty()) {
            checkLangDeclarationValidity(sspHandler, selectionHandler, testSolutionHandler);
        }
        if (selectionHandler.isEmpty() && elementWithLang.isEmpty()) {
            testSolutionHandler.addTestSolution(TestSolution.FAILED);
            sspHandler.getProcessRemarkService().addProcessRemark(
                    TestSolution.FAILED,
                    LANG_ATTRIBUTE_MISSING_ON_WHOLE_PAGE_MSG);
            return;
        }
        if (selectionHandler.isEmpty() && !elementWithoutLang.isEmpty()) {
            testSolutionHandler.addTestSolution(TestSolution.FAILED);
            sspHandler.getProcessRemarkService().addProcessRemark(
                    TestSolution.FAILED,
                    LANG_ATTRIBUTE_MISSING_ON_HTML_TAG_MSG);
        }
        checkLangDeclarationValidity(sspHandler, elementWithLang, testSolutionHandler);
    }

    /**
     * Use the LangDeclarationValidityChecker to check the declaration 
     * validity and pertinence
     * 
     * @param sspHandler
     * @param selectionHandler
     * @param testSolutionHandler 
     */
    private void checkLangDeclarationValidity(
            SSPHandler sspHandler,
            ElementHandler selectionHandler,
            TestSolutionHandler testSolutionHandler) {
        LangChecker ec = new LangDeclarationValidityChecker(true, true);
        ec.setNomenclatureLoaderService(nomenclatureLoaderService);
        ec.check(sspHandler, selectionHandler, testSolutionHandler);
    }

    /**
     * Remove elements from the current elementHandler when an element has a
     * parent with a lang attribute
     *
     * @param elementHandler
     */
    private void removeElementWithParentWithLangAttr(ElementHandler<Element> elementHandler) {
        ElementHandler elementWithParentWithLang = new ElementHandlerImpl();
        for (Element el : elementHandler.get()) {
            if (isElementHasParentWithLang(el)) {
                elementWithParentWithLang.add(el);
            }
        }
        elementHandler.removeAll(elementWithParentWithLang);
    }

    /**
     * Checks recursively whether an element has a parent with a lang attribute
     *
     * @param el
     * @return whether the element passed as argument has a parent with a lang
     * attribute
     */
    private boolean isElementHasParentWithLang(Element el) {
        for (Element pel : el.parents()) {
            if (!pel.nodeName().equals(HTML_ELEMENT)
                    && (pel.hasAttr(LANG_ATTR)
                    || pel.hasAttr(XML_LANG_ATTR))) {
                return true;
            }
        }
        return false;
    }
}