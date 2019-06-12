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

import java.util.Collection;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.jsoup.nodes.Element;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.processor.SSPHandler;
import org.tanaguru.ruleimplementation.AbstractPageRuleFromPreProcessImplementation;
import org.tanaguru.rules.domelement.DomElement;
import org.tanaguru.rules.domelement.extractor.DomElementExtractor;
import org.tanaguru.rules.elementchecker.element.ElementPresenceChecker;
import static org.tanaguru.rules.keystore.RemarkMessageStore.FORBIDDEN_UNRELATIVE_UNIT_TYPE_MSG;


/**
 * Implementation of the rule 10.4.2 of the referential Rgaa 3-2017.
 * <br>
 * For more details about the implementation, refer to <a href="http://tanaguru-rules-rgaa3.readthedocs.org/en/latest/Rule-10-4-2">the rule 10.4.2 design page.</a>
 * @see <a href="http://references.modernisation.gouv.fr/referentiel-technique-0#test-10-4-2"> 10.4.2 rule specification</a>
 *
 * @author jkowalczyk
 */

public class Rgaa32017Rule100402 extends AbstractPageRuleFromPreProcessImplementation {

   public Rgaa32017Rule100402() {
    	super(
                new ElementPresenceChecker(
                    // if some elements with different units are found
                	new ImmutablePair(TestSolution.FAILED, FORBIDDEN_UNRELATIVE_UNIT_TYPE_MSG),
                    // if no found element
                    new ImmutablePair(TestSolution.PASSED, "")
                )
            );
    }

	@Override
	protected void doSelect(Collection<DomElement> domElements, SSPHandler sspHandler) {
		
		for (DomElement element : domElements) {
			if (element.isNotAuthorizedUnitUsed()) {  //TODO
                Element el = DomElementExtractor.getElementFromDomElement(element, sspHandler);
                if (el != null) {
                	getElements().add(el);
                }
            }
        }
	}
}