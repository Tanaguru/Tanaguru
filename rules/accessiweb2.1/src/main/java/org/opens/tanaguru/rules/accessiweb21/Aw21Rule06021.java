/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2012  Open-S Company
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
package org.opens.tanaguru.rules.accessiweb21;

import org.opens.tanaguru.entity.audit.ProcessResult;
import org.opens.tanaguru.entity.audit.TestSolution;
import org.opens.tanaguru.processor.SSPHandler;
import org.opens.tanaguru.rules.accessiweb21.handler.link.AbstractPageRuleLinkThemeImplementation;
import org.opens.tanaguru.rules.accessiweb21.handler.link.LinkRulesHandler;

/**
 * This rule tests if the title attribute of a &lt;a&gt; tag is pertinent.
 * To do so, we check whether the content of the title attribute is empty,
 * is equal to the text content of the tag, and belongs to the text link
 * blacklist.
 * If one of these conditions is fulfilled, the test returns FAILED.
 * If the page doesn't contain any &lt;a&gt; tag, the test returns NOT_APPLICABLE.
 * In all the other cases, the test returns NEED_MORE_INFORMATIONS.
 * @author jkowalczyk
 */
public class Aw21Rule06021 extends AbstractPageRuleLinkThemeImplementation {

    private static final String XPATH_EXPR =
            "//A[@title and "+
            LinkRulesHandler.SIMPLE_LINK+
            LinkRulesHandler.END_BRACKET;

    public Aw21Rule06021() {
        super();
    }

    @Override
    protected ProcessResult processImpl(SSPHandler sspHandler) {
        super.processImpl(sspHandler);

        sspHandler.beginSelection().domXPathSelectNodeSet(XPATH_EXPR);
        TestSolution testSolution = linkRulesHandler.checkAttributePertinence(
                     NodeAndAttributeKeyStore.TITLE_ATTR,
                     false);

        ProcessResult processResult = definiteResultFactory.create(
                test,
                sspHandler.getPage(),
                testSolution,
                sspHandler.getRemarkList());
        processResult.setElementCounter(linkRulesHandler.getElementCounter());

        cleanUpRule();
        return processResult;
    }

}