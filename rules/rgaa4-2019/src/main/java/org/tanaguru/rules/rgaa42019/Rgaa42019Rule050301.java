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
package org.tanaguru.rules.rgaa42019;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.ruleimplementation.AbstractMarkerPageRuleImplementation;
import org.tanaguru.rules.elementchecker.CompositeChecker;
import org.tanaguru.rules.elementchecker.attribute.AttributeWithValuePresenceChecker;
import org.tanaguru.rules.elementchecker.element.ElementPresenceChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;
import org.tanaguru.rules.keystore.AttributeStore;

import static org.tanaguru.rules.keystore.AttributeStore.PRESENTATION_VALUE;
import static org.tanaguru.rules.keystore.AttributeStore.ROLE_ATTR;
import static org.tanaguru.rules.keystore.HtmlElementStore.TABLE_ELEMENT;
import static org.tanaguru.rules.keystore.MarkerStore.COMPLEX_TABLE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.DATA_TABLE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.PRESENTATION_TABLE_MARKER;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_LINEARISED_CONTENT_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_NATURE_OF_TABLE_AND_LINEARISED_CONTENT_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_TABLE_IS_NOT_PRESENTATION_WITHOUT_ROLE_ARIA_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.PRESENTATION_TABLE_WITHOUT_ARIA_MARKUP_MSG;

/**
 * Implementation of the rule 5-3-1 of the referential Rgaa4 2019.
 *
 * @see <a href="http://www.example.com/refential-descriptor.html#test-5-3-1"> 5-3-1 rule specification</a>
 *
 * @author edaconceicao
 */

public class Rgaa42019Rule050301 extends AbstractMarkerPageRuleImplementation {

    /**
     * Default constructor
     */
    public Rgaa42019Rule050301 () {
        super(
                new SimpleElementSelector(TABLE_ELEMENT),
                
                // the presentation tables are not part of the scope
                new String[]{PRESENTATION_TABLE_MARKER},
                
                // the data and complex tables are part of the scope
                new String[]{DATA_TABLE_MARKER,COMPLEX_TABLE_MARKER},
                
                new CompositeChecker(                        
                        new AttributeWithValuePresenceChecker(
                                ROLE_ATTR,
                                PRESENTATION_VALUE,
                                // empty msg because the CHECK_LINEARISED_CONTENT_MSG
                                // is already use above in this case.
                                new ImmutablePair(TestSolution.PASSED,""),
                                new ImmutablePair(TestSolution.FAILED,PRESENTATION_TABLE_WITHOUT_ARIA_MARKUP_MSG),
                                AttributeStore.ROLE_ATTR),
                        new ElementPresenceChecker(
                                // nmi when element is found
                                new ImmutablePair(TestSolution.NEED_MORE_INFO,CHECK_LINEARISED_CONTENT_MSG),
                                // na when element is not found
                                new ImmutablePair(TestSolution.NOT_APPLICABLE,""))),
                
                // checker for elements not identified by marker
                new CompositeChecker(                        
                        new AttributeWithValuePresenceChecker(
                                ROLE_ATTR,
                                PRESENTATION_VALUE,
                                // empty msg because the CHECK_NATURE_OF_TABLE_AND_LINEARISED_CONTENT_MSG
                                // is already use above in this case.
                                new ImmutablePair(TestSolution.NEED_MORE_INFO,""),
                                new ImmutablePair(TestSolution.NEED_MORE_INFO,CHECK_TABLE_IS_NOT_PRESENTATION_WITHOUT_ROLE_ARIA_MSG),
                                AttributeStore.ROLE_ATTR),           		
                        new ElementPresenceChecker(
                                // nmi when element is found
                                new ImmutablePair(TestSolution.NEED_MORE_INFO,CHECK_NATURE_OF_TABLE_AND_LINEARISED_CONTENT_MSG),
                                // na when element is not found
                                new ImmutablePair(TestSolution.NOT_APPLICABLE,""))));
    }

}