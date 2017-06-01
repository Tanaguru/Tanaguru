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

import java.util.Collection;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.jsoup.nodes.Element;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.processor.SSPHandler;
import org.tanaguru.ruleimplementation.AbstractPageRuleFromPreProcessImplementation;
import org.tanaguru.ruleimplementation.ElementHandler;
import org.tanaguru.ruleimplementation.TestSolutionHandler;
import org.tanaguru.rules.domelement.DomElement;
import org.tanaguru.rules.domelement.extractor.DomElementExtractor;
import org.tanaguru.rules.elementchecker.element.ElementPresenceChecker;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_BG_COLOR_PRESENCE;

/**
 * Implementation of the rule 10.5.1 of the referential Rgaa 3-2017.
 *
 * For more details about the implementation, refer to
 * <a href="http://tanaguru-rules-rgaa3.readthedocs.org/en/latest/Rule-10-5-1">the
 * rule 10.5.1 design page.</a>
 *
 * @see
 * <a href="http://references.modernisation.gouv.fr/referentiel-technique-0#test-10-5-1">
 * 10.5.1 rule specification</a>
 */
public class Rgaa32017Rule100501 extends AbstractPageRuleFromPreProcessImplementation {
    /* the none css property outline-style value*/

    private static final String NONE_COLOR_STYLE = "none";
    /* the counter of focusable elements*/
    private int nbOfTextuelElementsWhithOutBackgroundColor = 0;
    private int nbOfTextuelElementsWhithForegroundColor = 0;

    /**
     * Default constructor
     */
    public Rgaa32017Rule100501() {
        super(
                new ElementPresenceChecker(
                        // if some elements are found
                        new ImmutablePair(TestSolution.FAILED, CHECK_BG_COLOR_PRESENCE),
                        // if no found element
                        new ImmutablePair(TestSolution.PASSED, "")
                )
        );
    }

    @Override
    protected void doSelect(
            Collection<DomElement> domElements,
            SSPHandler sspHandler) {
        for (DomElement domElement : domElements) {
            if (domElement.isTextNode() && !domElement.getFgColor().equalsIgnoreCase(NONE_COLOR_STYLE)) {
                Element el = DomElementExtractor.getElementFromDomElement(domElement, sspHandler);
                if (el != null) {
                    nbOfTextuelElementsWhithForegroundColor++;
                }
                if (domElement.getBgColor().equalsIgnoreCase(NONE_COLOR_STYLE)) {
                    treatDetectedElement(el, domElement, getElements());
                }
            }
        }
    }

    @Override
    protected void check(
            SSPHandler sspHandler,
            TestSolutionHandler testSolutionHandler) {
        if (nbOfTextuelElementsWhithForegroundColor == 0 && nbOfTextuelElementsWhithOutBackgroundColor == 0) {
            testSolutionHandler.addTestSolution(TestSolution.NOT_APPLICABLE);
            return;
        }

        if (nbOfTextuelElementsWhithForegroundColor > 0 && nbOfTextuelElementsWhithOutBackgroundColor == 0) {
            testSolutionHandler.addTestSolution(TestSolution.PASSED);
            return;
        }

        if (nbOfTextuelElementsWhithForegroundColor > 0 && nbOfTextuelElementsWhithOutBackgroundColor > 0) {
            testSolutionHandler.addTestSolution(TestSolution.NEED_MORE_INFO);
            sspHandler.getProcessRemarkService().addProcessRemark(
                    TestSolution.NEED_MORE_INFO,
                    CHECK_BG_COLOR_PRESENCE);
            
        }
    }

    @Override
    public int getSelectionSize() {
        return nbOfTextuelElementsWhithOutBackgroundColor;
    }

    /**
     *
     * @param element
     * @param domElement
     * @param elementHandler
     */
    private void treatDetectedElement(
            Element element,
            DomElement domElement,
            ElementHandler<Element> elementHandler) {
        if (element == null) {
            return;
        }
        nbOfTextuelElementsWhithOutBackgroundColor++;

        elementHandler.add(element);

    }

}
