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
import org.tanaguru.ruleimplementation.AbstractPageRuleWithSelectorAndCheckerImplementation;
import org.tanaguru.rules.elementchecker.element.ElementPresenceChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.FORM_WITH_TITLE_ATTR_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_FORM_ARIA_MSG;

/**
 *
 * @author tanaguru
 */

/**
 * Implementation of the rule 11.01.05 of the referential Rgaa 3-2017.
 *
 * For more details about the implementation, refer to <a href="http://tanaguru-rules-rgaa3.readthedocs.org/en/latest/Rule-11-01-05">the rule 11.01.05 design page.</a>
 * @see <a href="http://references.modernisation.gouv.fr/referentiel-technique-0#test-11-10-10"> 11.01.05 rule specification</a>
 */

public class Rgaa32017Rule110105 extends AbstractPageRuleWithSelectorAndCheckerImplementation {

    /**
     * Default constructor
     */
    //FORM_ARIA_CSS_LIKE_QUERY
    public Rgaa32017Rule110105 () {
       super(new SimpleElementSelector(FORM_WITH_TITLE_ATTR_CSS_LIKE_QUERY),
                new ElementPresenceChecker(
                new ImmutablePair(TestSolution.NEED_MORE_INFO,CHECK_FORM_ARIA_MSG),
                new ImmutablePair(TestSolution.NOT_APPLICABLE, "")
                ));
    }

}