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
package org.tanaguru.ruleimplementation.impl.table;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.jsoup.nodes.Element;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.processor.SSPHandler;
import org.tanaguru.ruleimplementation.AbstractPageRuleWithSelectorAndCheckerImplementation;
import org.tanaguru.ruleimplementation.ElementHandler;
import org.tanaguru.ruleimplementation.ElementHandlerImpl;
import org.tanaguru.rules.elementchecker.element.ElementPresenceChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;

import static org.tanaguru.rules.keystore.CssLikeQueryStore.DATA_TABLE_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_USAGE_OF_COLUMN_HEADERS_MSG;

/**
 * Implementation of the rule 5-6-1 of the referential Rgaa4 2019.
 *
 * @see <a href="http://www.example.com/refential-descriptor.html#test-5-6-1"> 5-6-1 rule specification</a>
 *
 * @author edaconceicao
 */

public class DataTableEachHeaderIsThAndHasRoleColumnHeader extends AbstractPageRuleWithSelectorAndCheckerImplementation {
	
    /**
     * Default constructor
     */
    public DataTableEachHeaderIsThAndHasRoleColumnHeader() {
        super(new SimpleElementSelector(DATA_TABLE_CSS_LIKE_QUERY),
        		new ElementPresenceChecker(
        				new ImmutablePair(TestSolution.NEED_MORE_INFO,CHECK_USAGE_OF_COLUMN_HEADERS_MSG),
        				new ImmutablePair(TestSolution.NOT_APPLICABLE,"")));
    }
    
    protected void select(SSPHandler sspHandler) {
    	super.select(sspHandler);
    	
    	ElementHandler<Element> newElementScope = 
                new ElementHandlerImpl();
    	
		for(Element el : getElements().get()){
    		if(el.select("tr[scope=col]").first() != null) {
    			newElementScope.add(el.select("tr[scope=col]").first());
    		}
    		if(el.select("thead").first() != null) {
    			newElementScope.add(el.select("thead").first());
    		}
    		Element trElement = el.select("tr").first();
    		if(trElement != null) {
    			if(trElement.select("th[id]").first() != null) {
    				newElementScope.add(el.select("tr:has(th[id])").first());
    			}
    		}
    		if(el.select("[role=columnheader]").first() != null) {
    			newElementScope.add(el.select("[role=columnheader]").first());
    		}
    	}
		getElements().clean();
		setElementHandler(newElementScope);
    }

}