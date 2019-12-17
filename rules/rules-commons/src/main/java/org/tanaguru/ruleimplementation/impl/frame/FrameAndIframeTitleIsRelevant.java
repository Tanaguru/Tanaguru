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
package org.tanaguru.ruleimplementation.impl.frame;

import org.tanaguru.ruleimplementation.AbstractPageRuleWithSelectorAndCheckerImplementation;
import org.tanaguru.rules.elementchecker.pertinence.AttributePertinenceChecker;
import org.tanaguru.rules.elementselector.MultipleElementSelector;
import org.tanaguru.rules.textbuilder.TextAttributeOfElementBuilder;

import static org.tanaguru.rules.keystore.AttributeStore.SRC_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.FRAME_WITH_TITLE_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.IFRAME_WITH_TITLE_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_TITLE_OF_FRAME_PERTINENCE_MSG2;
import static org.tanaguru.rules.keystore.RemarkMessageStore.NOT_PERTINENT_TITLE_OF_FRAME_MSG2;

/**
 * Implementation of the rule 2-2-1 of the referential Rgaa4 2019.
 *
 * @see <a href="http://www.example.com/refential-descriptor.html#test-2-2-1"> 2-2-1 rule specification</a>
 *
 * @author edaconceicao
 */

public class FrameAndIframeTitleIsRelevant extends AbstractPageRuleWithSelectorAndCheckerImplementation {

    /**
     * Default constructor
     */
    public FrameAndIframeTitleIsRelevant() {
    	super(
                new MultipleElementSelector(IFRAME_WITH_TITLE_CSS_LIKE_QUERY,FRAME_WITH_TITLE_CSS_LIKE_QUERY), 
                
                new AttributePertinenceChecker(
                    TITLE_ATTR, 
                    // tests the emptiness of the attribute
                    true, 
                    // compare title with src attribute
                    new TextAttributeOfElementBuilder(SRC_ATTR), 
                    // no comparison by extension
                    null, 
                    //  message associated with element when title is not pertinent
                    NOT_PERTINENT_TITLE_OF_FRAME_MSG2, 
                    // message associated with element when pertinence cannot be determined
                    CHECK_TITLE_OF_FRAME_PERTINENCE_MSG2, 
                    //evidence elements
                    TITLE_ATTR)
            );
    }

}