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
import org.tanaguru.ruleimplementation.AbstractDetectionPageRuleImplementation;
import org.tanaguru.rules.elementselector.ImageElementSelector;
import static org.tanaguru.rules.keystore.AttributeStore.*;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.*;
import static org.tanaguru.rules.keystore.RemarkMessageStore.*;

/**
 * Implementation of the rule 1.9.4 of the referential Rgaa 3-2017.
 * <br/>
 * For more details about the implementation, refer to <a href="http://tanaguru-rules-rgaa3.readthedocs.org/en/latest/Rule-1-9-4">the rule 1.9.4 design page.</a>
 * @see <a href="http://references.modernisation.gouv.fr/referentiel-technique-0#test-1-9-4"> 1.9.4 rule specification</a>
 *
 */
public class Rgaa32017Rule010904 extends AbstractDetectionPageRuleImplementation {

    /**
     * Default constructor
     */
    public Rgaa32017Rule010904 () {
        super(
                new ImageElementSelector(EMBED_TYPE_IMG_CSS_LIKE_QUERY),
                new ImmutablePair(TestSolution.NEED_MORE_INFO,MANUAL_CHECK_ON_ELEMENTS_MSG),
                new ImmutablePair(TestSolution.NOT_APPLICABLE,""),
                // evidence elements
                SRC_ATTR
            );
    }

}
