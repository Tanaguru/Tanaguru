/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2016  Tanaguru.org
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

package org.tanaguru.rules.rgaa32016;

import org.tanaguru.ruleimplementation.AbstractPageRuleWithCheckerImplementation;
import org.tanaguru.rules.elementchecker.contrast.ContrastChecker;

/**
 * Implementation of the rule 3.4.2 of the referential Rgaa 3-2016.
 * <br>
 * For more details about the implementation, refer to <a href="http://tanaguru-rules-rgaa3.readthedocs.org/en/latest/Rule-3-4-2">the rule 3.4.2 design page.</a>
 * @see <a href="http://references.modernisation.gouv.fr/referentiel-technique-0#test-3-4-2"> 3.4.2 rule specification</a>
 *
 * @author jkowalczyk
 */

public class Rgaa32016Rule030402 extends AbstractPageRuleWithCheckerImplementation {
    
    /** The contrast checker with a value of ratio set to 7*/
    private final ContrastChecker contrastChecker = 
            new ContrastChecker(7f, false, true, true);

    /**
     * Default constructor
     */
    public Rgaa32016Rule030402 () {
        super();
        setElementChecker(contrastChecker);
    }

    @Override
    public int getSelectionSize() {
        return contrastChecker.getElementCounter();
    }

}
