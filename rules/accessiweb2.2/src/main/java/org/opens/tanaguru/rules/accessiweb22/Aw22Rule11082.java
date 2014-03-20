/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2013  Open-S Company
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
 * Contact us by mail: open-s AT open-s DOT com
 */
package org.opens.tanaguru.rules.accessiweb22;

import org.opens.tanaguru.entity.audit.TestSolution;
import org.opens.tanaguru.ruleimplementation.AbstractPageRuleWithSelectorAndCheckerImplementation;
import org.opens.tanaguru.rules.elementchecker.attribute.AttributePresenceChecker;
import org.opens.tanaguru.rules.elementselector.SimpleElementSelector;
import static org.opens.tanaguru.rules.keystore.AttributeStore.LABEL_ATTR;
import static org.opens.tanaguru.rules.keystore.CssLikeQueryStore.OPTGROUP_WITHIN_SELECT_CSS_LIKE_QUERY;
import static org.opens.tanaguru.rules.keystore.RemarkMessageStore.OPTGROUP_WITHOUT_LABEL_MSG;

/**
 * Implementation of the rule 11.8.2 of the referential Accessiweb 2.2.
 * <br/>
 * For more details about the implementation, refer to <a href="http://www.tanaguru.org/en/content/aw22-rule-11-8-2">the rule 11.8.2 design page.</a>
 * @see <a href="http://www.accessiweb.org/index.php/accessiweb-22-english-version.html#test-11-8-3"> 11.8.2 rule specification</a>
 *
 */
public class Aw22Rule11082 extends AbstractPageRuleWithSelectorAndCheckerImplementation {

    /**
     * Constructor
     */
    public Aw22Rule11082() {
        super(
                new SimpleElementSelector(OPTGROUP_WITHIN_SELECT_CSS_LIKE_QUERY), 
                new AttributePresenceChecker(
                    // the attribute to search
                    LABEL_ATTR, 
                    // passed when attribute is found
                    TestSolution.PASSED, 
                    // failed when attribute is not found
                    TestSolution.FAILED, 
                    // no message created when attribute is found
                    null,
                    // message associated with element when attribute is not found
                    OPTGROUP_WITHOUT_LABEL_MSG)
            );
    }

}