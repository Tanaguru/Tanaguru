/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2015 Tanaguru.org
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

import java.util.Collections;
import org.apache.commons.lang3.tuple.ImmutablePair;
import static org.tanaguru.entity.audit.TestSolution.FAILED;
import static org.tanaguru.entity.audit.TestSolution.NEED_MORE_INFO;
import static org.tanaguru.entity.audit.TestSolution.PASSED;
import org.tanaguru.ruleimplementation.AbstractMarkerPageRuleImplementation;

import org.tanaguru.rules.elementchecker.CompositeChecker;
import org.tanaguru.rules.elementchecker.ElementChecker;
import org.tanaguru.rules.elementchecker.attribute.AttributePresenceChecker;
import org.tanaguru.rules.elementchecker.text.TextEmptinessChecker;
import org.tanaguru.rules.elementselector.AreaElementSelector;
import org.tanaguru.rules.elementselector.ImageElementSelector;
import static org.tanaguru.rules.keystore.AttributeStore.ALT_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_DESCRIBEDBY_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABELLEDBY_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABEL_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ROLE_ATTR;
import static org.tanaguru.rules.keystore.MarkerStore.DECORATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.INFORMATIVE_IMAGE_MARKER;
import org.tanaguru.rules.keystore.RemarkMessageStore;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITH_ARIA_DESCRIBEDBY_ATTR_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITH_ARIA_LABELLEDBY_ATTR_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITH_ARIA_LABEL_ATTR_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITH_NOT_EMPTY_ALT_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITH_TITLE_ATTR_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITH_ROLE_ATTR_MSG;
import org.tanaguru.rules.textbuilder.TextAttributeOfElementBuilder;

/**
 * Implementation of the rule 1.2.2 of the referential Rgaa 3-2017.
 * <br>
 * For more details about the implementation, refer to <a
 * href="http://tanaguru-rules-rgaa3.readthedocs.org/en/latest/Rule-1-2-2">the
 * rule 1.2.2 design page.</a>
 *
 * @see <a
 * href="http://references.modernisation.gouv.fr/referentiel-technique-0#test-1-2-2">
 * 1.2.2 rule specification</a>
 *
 */
public class Rgaa32017Rule010202 extends AbstractMarkerPageRuleImplementation {

    public Rgaa32017Rule010202() {
        super(
                // the decorative images are part of the scope
                DECORATIVE_IMAGE_MARKER,
                // the informative images are not part of the scope
                INFORMATIVE_IMAGE_MARKER);
        setElementSelector(new ImageElementSelector(new AreaElementSelector(true, true, false), true, false));
        setMarkerElementChecker(getMarkerElementChecker());
        setRegularElementChecker(getLocalRegularElementChecker());
    }

    /**
     *
     * @return the checker user for marked elements
     */
    private ElementChecker getMarkerElementChecker() {
        CompositeChecker ec = new CompositeChecker(
                new TextEmptinessChecker(
                        new TextAttributeOfElementBuilder(ALT_ATTR),
                        new ImmutablePair(PASSED, ""),
                        new ImmutablePair(FAILED, DECORATIVE_ELEMENT_WITH_NOT_EMPTY_ALT_MSG),
                        ALT_ATTR,
                        TITLE_ATTR),
                // Checker sur la présence de l'attribut title
                new AttributePresenceChecker(
                        TITLE_ATTR,
                        new ImmutablePair(FAILED, DECORATIVE_ELEMENT_WITH_TITLE_ATTR_MSG),
                        new ImmutablePair(PASSED, ""),
                        TITLE_ATTR),
                
                //checker sur la présence de l'attribut aria-label
                new AttributePresenceChecker(
                        ARIA_LABEL_ATTR,
                        new ImmutablePair(FAILED, DECORATIVE_ELEMENT_WITH_ARIA_LABEL_ATTR_MSG),
                        new ImmutablePair(PASSED, ""),
                        ARIA_LABEL_ATTR),
                
                //checker sur la présence de l'attribut aria-labelledby
                new AttributePresenceChecker(
                        ARIA_LABELLEDBY_ATTR,
                        new ImmutablePair(FAILED, DECORATIVE_ELEMENT_WITH_ARIA_LABELLEDBY_ATTR_MSG),
                        new ImmutablePair(PASSED, ""),
                        ARIA_LABELLEDBY_ATTR),
                
                //checker sur la présence de l'attribut aria-describedby
                new AttributePresenceChecker(
                        ARIA_DESCRIBEDBY_ATTR,
                        new ImmutablePair(FAILED, DECORATIVE_ELEMENT_WITH_ARIA_DESCRIBEDBY_ATTR_MSG),
                        new ImmutablePair(PASSED, ""),
                        ARIA_DESCRIBEDBY_ATTR),
                
                //checker la présence de l'attribut role
                new AttributePresenceChecker(
                		ROLE_ATTR,
                        new ImmutablePair(FAILED, DECORATIVE_ELEMENT_WITH_ROLE_ATTR_MSG),
                        new ImmutablePair(PASSED, ""),
                        ROLE_ATTR));
        
        ec.setIsOrCombinaison(false);
        return ec;
    }

    /**
     *
     * @return the checker user for not marked elements
     */
    private ElementChecker getLocalRegularElementChecker() {

        CompositeChecker compositeChecker = new CompositeChecker(
                new TextEmptinessChecker(
                        new TextAttributeOfElementBuilder(ALT_ATTR),
                        new ImmutablePair(PASSED, ""),
                        new ImmutablePair(FAILED, "")),
                new AttributePresenceChecker(
                        TITLE_ATTR,
                        new ImmutablePair(FAILED, ""),
                        new ImmutablePair(PASSED, "")),
                new AttributePresenceChecker(
                		ARIA_LABEL_ATTR,
                        new ImmutablePair(FAILED, ""),
                        new ImmutablePair(PASSED, "")),
                new AttributePresenceChecker(
                		ARIA_LABELLEDBY_ATTR,
                        new ImmutablePair(FAILED, ""),
                        new ImmutablePair(PASSED, "")),
                new AttributePresenceChecker(
                		ARIA_DESCRIBEDBY_ATTR,
                        new ImmutablePair(FAILED, ""),
                        new ImmutablePair(PASSED, "")),
                new AttributePresenceChecker(
                		ROLE_ATTR,
                        new ImmutablePair(FAILED, ""),
                        new ImmutablePair(PASSED, "")));

        compositeChecker.setIsOrCombinaison(false);
        compositeChecker.addCheckMessageFromSolution(
                PASSED,
                Collections.singletonMap(
                        NEED_MORE_INFO,
                        RemarkMessageStore.CHECK_NATURE_OF_IMAGE_WITH_EMPTY_ALT_MSG));
        compositeChecker.addCheckMessageFromSolution(
                FAILED,
                Collections.singletonMap(
                        NEED_MORE_INFO,
                        RemarkMessageStore.CHECK_NATURE_OF_IMAGE_WITH_NOT_EMPTY_ALT_MSG));

        return compositeChecker;
    }

}
