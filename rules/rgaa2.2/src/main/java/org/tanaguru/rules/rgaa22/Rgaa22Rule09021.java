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

package org.tanaguru.rules.rgaa22;

import org.tanaguru.ruleimplementation.AbstractPageRuleWithCheckerImplementation;
import org.tanaguru.rules.elementchecker.doctype.DoctypePositionChecker;

/**
 * Implementation of the rule 9.2 of the referential RGAA 2.2.
 * <br>
 * For more details about the implementation, refer to <a href="http://www.tanaguru.org/en/content/rgaa22-rule-9-2">the rule 9.2 design page.</a>
 * @see <a href="http://rgaa.net/Conformite-de-la-position-de-la.html"> 9.2 rule specification </a>
 *
 * @author jkowalczyk
 */
public class Rgaa22Rule09021 extends AbstractPageRuleWithCheckerImplementation {

    /**
     * Default constructor
     */
    public Rgaa22Rule09021() {
        super(new DoctypePositionChecker());
    }

}