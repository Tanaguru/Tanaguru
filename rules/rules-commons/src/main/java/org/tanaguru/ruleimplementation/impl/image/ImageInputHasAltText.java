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
import org.tanaguru.ruleimplementation.AbstractPageRuleWithSelectorAndCheckerImplementation;
import org.tanaguru.rules.elementchecker.text.TextAlternativePresenceChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;

import static org.tanaguru.rules.keystore.AttributeStore.VALUE_ATTR;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.FORM_BUTTON_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_NATURE_OF_IMAGE_WITH_TEXT_ALTERNATIVE;
import static org.tanaguru.rules.keystore.RemarkMessageStore.TEXT_ALTERNATIVE_MISSING;

/**
 * Implementation of the rule 1-1-3 of the referential Rgaa4 2019.
 *
 * @see <a href="http://www.example.com/refential-descriptor.html#test-1-1-3"> 1-1-3 rule specification</a>
 *
 * @author edaconceicao
 */

public class ImageInputHasAltText extends AbstractPageRuleWithSelectorAndCheckerImplementation {

    /**
     * Default constructor
     */
    public ImageInputHasAltText() {
        super(new SimpleElementSelector(FORM_BUTTON_CSS_LIKE_QUERY),

        		new TextAlternativePresenceChecker(
                        // passed when text alternative is found, check
                        new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_NATURE_OF_IMAGE_WITH_TEXT_ALTERNATIVE),
                        // failed when attribute is not found, altMissing message
                        new ImmutablePair(TestSolution.FAILED, TEXT_ALTERNATIVE_MISSING),
                        true,
                        VALUE_ATTR));
    }

}