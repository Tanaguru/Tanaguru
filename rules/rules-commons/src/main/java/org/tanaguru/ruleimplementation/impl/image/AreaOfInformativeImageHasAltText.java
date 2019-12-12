/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2015  Tanaguru.org
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
package org.tanaguru.ruleimplementation.impl.image;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.ruleimplementation.AbstractMarkerPageRuleImplementation;
import org.tanaguru.rules.elementchecker.text.TextAlternativePresenceChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;

import static org.tanaguru.rules.keystore.AttributeStore.HREF_ATTR;
import static org.tanaguru.rules.keystore.HtmlElementStore.AREA_ELEMENT;
import static org.tanaguru.rules.keystore.MarkerStore.DECORATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.INFORMATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.RemarkMessageStore.*;

/**
 * Implementation of the rule 1-1-2 of the referential Rgaa4 2019.
 *
 * @see <a href="http://www.example.com/refential-descriptor.html#test-1-1-2"> 1-1-2 rule specification</a>
 *
 * @author edaconceicao
 */

public class AreaOfInformativeImageHasAltText extends AbstractMarkerPageRuleImplementation {

    /**
     * Default constructor
     */
    public AreaOfInformativeImageHasAltText() {
        super(new SimpleElementSelector(AREA_ELEMENT), 
        		
        		// the informative images are part of the scope
                INFORMATIVE_IMAGE_MARKER, 

                // the decorative images are not part of the scope
                DECORATIVE_IMAGE_MARKER, 

        		new TextAlternativePresenceChecker(
                        // passed when attribute is found, empty message
                        new ImmutablePair(TestSolution.PASSED, ""),
                        // failed when attribute is not found, altMissing message
                        new ImmutablePair(TestSolution.FAILED, TEXT_ALTERNATIVE_MISSING),
                        HREF_ATTR),
        		
        		new TextAlternativePresenceChecker(
                        // passed when attribute is found, empty message
                        new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_NATURE_OF_IMAGE),
                        // failed when attribute is not found, altMissing message
                        new ImmutablePair(TestSolution.NEED_MORE_INFO,CHECK_NATURE_OF_IMAGE_WITHOUT_TEXT_ALTERNATIVE),
                        HREF_ATTR));
    }

}