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
import org.apache.log4j.Logger;
import org.jsoup.nodes.Element;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.entity.parameterization.Parameter;
import org.tanaguru.processor.SSPHandler;
import org.tanaguru.ruleimplementation.AbstractPageRuleFromPreProcessImplementation;
import org.tanaguru.rules.domelement.DomElement;
import org.tanaguru.rules.domelement.extractor.DomElementExtractor;
import org.tanaguru.rules.elementchecker.element.ElementPresenceChecker;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_IF_USER_HAVE_MECHANISM_TO_DELETE_JUSTIFY_TEXT_ALIGN_MSG;

/**
 * Implementation of the rule 10.9.1 of the referential Rgaa 3-2017.
 * 
* For more details about the implementation, refer to
 * <a href="http://tanaguru-rules-rgaa3.readthedocs.org/en/latest/Rule-10-9-1">the
 * rule 10.9.1 design page.</a>
 *
 * @see
 * <a href="http://references.modernisation.gouv.fr/referentiel-technique-0#test-10-9-1">
 * 10.9.1 rule specification</a>
 */
public class Rgaa32017Rule100901 extends AbstractPageRuleFromPreProcessImplementation {

    static final Logger LOGGER = Logger.getLogger(Rgaa32017Rule100901.class);

    private static final String ALT_JUSTIFY_MECHA_PARAM_KEY
            = "ALTERNATIVE_JUSTIFY_MECHANISM";
    /* the text justification css property key */
    private static final String ALIGN_TEXT_CSS_PROPERTY = "justify";
    /**
     *      */
    private boolean alternativeJustifyMechanismPresent = false;

    /**
     * Default constructor
     */
    public Rgaa32017Rule100901() {
        super(
                new ElementPresenceChecker(
                        // if some elements are found
                        new ImmutablePair(TestSolution.FAILED, CHECK_IF_USER_HAVE_MECHANISM_TO_DELETE_JUSTIFY_TEXT_ALIGN_MSG),
                        // if no found element
                        new ImmutablePair(TestSolution.PASSED, "")
                )
        );
    }

    @Override
    protected void doSelect(
            Collection<DomElement> domElements,
            SSPHandler sspHandler) {
        if (isAlternativeJustifyMechanismPresentFromParam(sspHandler)) {
            return;
        }
        for (DomElement element : domElements) {
            if (element.getTextAlignValue().equalsIgnoreCase(ALIGN_TEXT_CSS_PROPERTY) && element.isTextNode()) {  //
                Element el = DomElementExtractor.getElementFromDomElement(element, sspHandler);
                if (el != null) {
                    getElements().add(el);
                }
            }
        }
    }

    private boolean isAlternativeJustifyMechanismPresentFromParam(SSPHandler sspHandler) {
        for (Parameter parameter : sspHandler.getSSP().getAudit().getParameterSet()) {
            if (parameter.getParameterElement().getParameterElementCode().equalsIgnoreCase(ALT_JUSTIFY_MECHA_PARAM_KEY)) {
                if (Boolean.valueOf(parameter.getValue())) {
                    return true;
                }
                break;
            }
        }
        return false;
    }
}
