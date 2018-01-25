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
import org.tanaguru.rules.elementchecker.CompositeChecker;
import org.tanaguru.rules.elementchecker.attribute.AttributePresenceChecker;
import org.tanaguru.rules.elementchecker.attribute.AttributeWithValuePresenceChecker;
import org.tanaguru.rules.elementchecker.text.TextEmptinessChecker;
import org.tanaguru.rules.elementselector.ImageElementSelector;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_DESCRIBEDBY_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_HIDDEN_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABELLEDBY_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABEL_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;
import org.tanaguru.rules.keystore.CssLikeQueryStore;
import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.MarkerStore.DECORATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.INFORMATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_ELEMENT_WITH_EMPTY_ALT_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_ELEMENT_WITH_NOT_EMPTY_ALT_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITH_ARIA_DESCRIBEDBY_ATTR_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITH_ARIA_LABELLEDBY_ATTR_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.DECORATIVE_ELEMENT_WITH_ARIA_LABEL_ATTR_MSG;
import org.tanaguru.rules.textbuilder.SimpleTextElementBuilder;

/**
 * Implementation of the rule 1.2.6 of the referential Rgaa 3-2017.
 *
 * For more details about the implementation, refer to <a href="http://tanaguru-rules-rgaa3.readthedocs.org/en/latest/Rule-1-2-6">the rule 1.2.6 design page.</a>
 * @see <a href="http://references.modernisation.gouv.fr/referentiel-technique-0#test-1-2-6"> 1.2.6 rule specification</a>
 */

public class Rgaa32017Rule010206 extends AbstractMarkerPageRuleImplementation {
    
    /**
     * Constructor
     */
    public Rgaa32017Rule010206() {
        super(
                new ImageElementSelector(CssLikeQueryStore.EMBED_TYPE_IMG_CSS_LIKE_QUERY, true, false),
                
                // the decorative images are part of the scope
                DECORATIVE_IMAGE_MARKER, 
                
                // the informative images are not part of the scope
                INFORMATIVE_IMAGE_MARKER, 

                // checker for elements identified by marker
                new CompositeChecker(
                        new AttributeWithValuePresenceChecker(
                                // attribute name
                                ARIA_HIDDEN_ATTR,
                                //attribute value 
                                "true",
                                // solution when detected
                                new ImmutablePair(TestSolution.PASSED, ""),
                                // solution when not detected
                                new ImmutablePair(TestSolution.FAILED, DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG),
                                // evidence elements
                                ARIA_HIDDEN_ATTR),
                        //title
                           new AttributePresenceChecker(
                                TITLE_ATTR,
                                // solution when title is detected
                                new ImmutablePair(TestSolution.FAILED, DECORATIVE_ELEMENT_WITH_ARIA_LABEL_ATTR_MSG),
                                // solution when title is not detected
                                new ImmutablePair(TestSolution.PASSED, ""),
                                // evidence elements
                                TITLE_ATTR),
                        
                        //aria aria-label
                        new AttributePresenceChecker(
                                ARIA_LABEL_ATTR,
                                // solution when title is detected
                                new ImmutablePair(TestSolution.FAILED, DECORATIVE_ELEMENT_WITH_ARIA_LABEL_ATTR_MSG),
                                // solution when title is not detected
                                new ImmutablePair(TestSolution.PASSED, ""),
                                // evidence elements
                                ARIA_LABEL_ATTR),
                        // aria-labeledby
                         new AttributePresenceChecker(
                                ARIA_LABELLEDBY_ATTR,
                                // solution when title is detected
                                new ImmutablePair(TestSolution.FAILED, DECORATIVE_ELEMENT_WITH_ARIA_LABELLEDBY_ATTR_MSG),
                                // solution when title is not detected
                                new ImmutablePair(TestSolution.PASSED, ""),
                                // evidence elements
                                ARIA_LABELLEDBY_ATTR),
                          // aria-describedby
                         new AttributePresenceChecker(
                                ARIA_DESCRIBEDBY_ATTR,
                                // solution when title is detected
                                new ImmutablePair(TestSolution.FAILED, DECORATIVE_ELEMENT_WITH_ARIA_DESCRIBEDBY_ATTR_MSG),
                                // solution when title is not detected
                                new ImmutablePair(TestSolution.PASSED, ""),
                                // evidence elements
                                ARIA_DESCRIBEDBY_ATTR)
                         // on children !!
                         
                ),
                
                // checker for elements not identified by marker
                new TextEmptinessChecker(
                    // the text element builder
                    new SimpleTextElementBuilder(),
                    // solution when text is empty
                    new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_ELEMENT_WITH_EMPTY_ALT_MSG),
                    // solution when text is notempty
                    new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_ELEMENT_WITH_NOT_EMPTY_ALT_MSG),
                    // evidence elements
                    TEXT_ELEMENT2)
            );
    }

}
