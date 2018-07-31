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

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.ruleimplementation.AbstractMarkerPageRuleImplementation;
import org.tanaguru.rules.elementchecker.ElementChecker;
import org.tanaguru.rules.elementselector.ImageElementSelector;
import org.tanaguru.rules.elementchecker.attribute.AttributeLengthChecker;
import static org.tanaguru.rules.keystore.AttributeStore.ALT_ATTR;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.IMG_WITH_ALT_NOT_IN_LINK_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.MarkerStore.DECORATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.INFORMATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.RemarkMessageStore.ALTERNATIVE_TOO_LONG_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_ALT_PERTINENCE_OF_INFORMATIVE_IMG_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_NATURE_OF_IMAGE_AND_ALT_LENGTH_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_NATURE_OF_IMAGE_AND_ALT_PERTINENCE_MSG;

/**
 * Implementation of the rule 1.3.13 of the referential Rgaa 3-2017.
 *
 * For more details about the implementation, refer to
 * <a href="http://tanaguru-rules-rgaa3.readthedocs.org/en/latest/Rule-1-3-13">the
 * rule 1.3.13 design page.</a>
 *
 * @see
 * <a href="http://references.modernisation.gouv.fr/referentiel-technique-0#test-1-3-13">
 * 1.3.13 rule specification</a>
 */
public class Rgaa32017Rule010313 extends AbstractMarkerPageRuleImplementation {

    
        final int MAX_LENGTH = 80;
    /**
     * Default constructor
     */
     public Rgaa32017Rule010313 () {
  super(
                // the informative images are part of the scope
                INFORMATIVE_IMAGE_MARKER,
                // the decorative images are not part of the scope
                DECORATIVE_IMAGE_MARKER);
        
        setElementSelector(new ImageElementSelector(IMG_WITH_ALT_NOT_IN_LINK_CSS_LIKE_QUERY, true, false));
                   
        setMarkerElementChecker(getMarkerElementChecker());
        setRegularElementChecker(getLocalRegularElementChecker());
    }

    /**
     *
     * @return the checker used for marked elements
     */
    private ElementChecker getMarkerElementChecker() {
        ElementChecker ec = new AttributeLengthChecker(ALT_ATTR,
                MAX_LENGTH,
                new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_ALT_PERTINENCE_OF_INFORMATIVE_IMG_MSG),
                new ImmutablePair(TestSolution.NEED_MORE_INFO, ALTERNATIVE_TOO_LONG_MSG),
                // evidence element
                ALT_ATTR
        );
        return ec;
    }
    
    /**
     *
     * @return the checker used for not marked elements
     */
    private ElementChecker getLocalRegularElementChecker() {
        ElementChecker ec = new AttributeLengthChecker(ALT_ATTR,
                MAX_LENGTH,
                new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_NATURE_OF_IMAGE_AND_ALT_PERTINENCE_MSG),
                new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_NATURE_OF_IMAGE_AND_ALT_LENGTH_MSG),
                // evidence element
                ALT_ATTR
        );
        return ec;
    }

}