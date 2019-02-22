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

import org.tanaguru.ruleimplementation.AbstractPageRuleWithSelectorAndCheckerImplementation;
import org.tanaguru.rules.elementchecker.pertinence.AttributePertinenceChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.FORM_ELEMENT_WITH_TITLE_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.RemarkMessageStore.NOT_PERTINENT_TEXTUAL_CONTENT_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_TITLE_ATTR_PERTINENCE_MSG;

/**
 * Implementation of the rule 11.2.2 of the referential Rgaa 3-2017.
 * <br/>
 * For more details about the implementation, refer to <a href="http://tanaguru-rules-rgaa3.readthedocs.org/en/latest/Rule-11-2-2">the rule 11.2.2 design page.</a>
 * @see <a href="http://references.modernisation.gouv.fr/referentiel-technique-0#test-11-2-2"> 11.2.2 rule specification</a>
 *
 * @author jkowalczyk
 */

public class Rgaa32017Rule110202 extends AbstractPageRuleWithSelectorAndCheckerImplementation {
    
    /**
     * Default constructor
     */
    public Rgaa32017Rule110202 () {
        super(
                new SimpleElementSelector(FORM_ELEMENT_WITH_TITLE_CSS_LIKE_QUERY),
                new AttributePertinenceChecker(
                		TITLE_ATTR,
                        // check emptiness
                		true, 
                        // no comparison with other attribute
                        null,
                        // no comparison with blacklist
                        null,
                        NOT_PERTINENT_TEXTUAL_CONTENT_MSG,
                        // manual check message
                        CHECK_TITLE_ATTR_PERTINENCE_MSG,
                        // evidence element
                        TITLE_ATTR)
            );
    }

}
