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
import org.jsoup.nodes.Element;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.processor.SSPHandler;
import org.tanaguru.ruleimplementation.AbstractPageRuleWithDoctypeHtml5CheckerImplementation;
import org.tanaguru.ruleimplementation.ElementHandler;
import org.tanaguru.ruleimplementation.ElementHandlerImpl;
import org.tanaguru.ruleimplementation.TestSolutionHandler;
import org.tanaguru.rules.elementchecker.ElementChecker;
import org.tanaguru.rules.elementchecker.RoleMainElementChecker;
import org.tanaguru.rules.elementchecker.RoleStructureElementChecker;
import org.tanaguru.rules.elementchecker.element.ElementPresenceChecker;
import org.tanaguru.rules.elementchecker.element.ForbiddenParentElementChecker;
import org.tanaguru.rules.elementselector.ElementSelector;
import org.tanaguru.rules.elementselector.SimpleElementSelector;
import static org.tanaguru.rules.keystore.RemarkMessageStore.ADD_ROLE_BANNER_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.ADD_ROLE_CONTENT_INFO_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_ROLE_MAIN_ELEMENT_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_ROLE_NAGIVATION_ARIA_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.MAIN_WITHOUT_ROLE_MAIN_ARIA_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.MISSING_ROLE_ARIA_MAIN_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.MISSING_ROLE_BANNER_ARIA_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.MISSING_ROLE_CONTENT_INFO_ARIA_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.MISSING_ROLE_NAVIGATION_ARIA_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.MISSING_ROLE_SEARCH_ARIA_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.ROLE_BANNER_ARIA_UNICITY_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.ROLE_CONTENT_INFO_ARIA_UNICITY_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.ROLE_SEARCH_ARIA_UNICITY_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.ROLE_SEARCH_ON_INPUT_MSG;

/**
 * Implementation of the rule 12.10.4 of the referential Rgaa 3-2017.
 *
 * For more details about the implementation, refer to <a href="http://tanaguru-rules-rgaa3.readthedocs.org/en/latest/Rule-12-10-4">the rule 12.10.4 design page.</a>
 * @see <a href="http://references.modernisation.gouv.fr/referentiel-technique-0#test-12-10-4"> 12.10.4 rule specification</a>
 */

public class Rgaa32017Rule121004 extends AbstractPageRuleWithDoctypeHtml5CheckerImplementation {

    
     //* the main elements*/
    ElementHandler<Element> roleMainElementHandler = new ElementHandlerImpl();
ElementHandler<Element> roleContentInfoElementHandler = new ElementHandlerImpl();
ElementHandler<Element> roleBannerElementHandler = new ElementHandlerImpl();
ElementHandler<Element> roleSearchElementHandler = new ElementHandlerImpl();
ElementHandler<Element> roleNavigationElementHandler = new ElementHandlerImpl();
ElementHandler<Element> wrongHeaderElementHandler = new ElementHandlerImpl();
ElementHandler<Element> wrongFooterElementHandler = new ElementHandlerImpl();
ElementHandler<Element> wrongMainElementHandler = new ElementHandlerImpl();
ElementHandler<Element> inputRoleSearchElementHandler = new ElementHandlerImpl();
ElementHandler<Element> missingRoleSearchElementHandler = new ElementHandlerImpl();

/* the total number of elements */
int totalNumberOfElements = 0;

    public Rgaa32017Rule121004 () {
        super();
    }
@Override
protected void select(SSPHandler sspHandler) {
    // Selection of Role main element
    ElementSelector roleMainElementSelector = 
            new SimpleElementSelector("*[role=main]");
    roleMainElementSelector.selectElements(sspHandler, roleMainElementHandler);
     System.out.println("role = main elements size :"+roleMainElementHandler.size());
    // Selection of Role content Info element
    ElementSelector roleContentInfoElementSelector = 
            new SimpleElementSelector("*[role=contentinfo]");
    roleContentInfoElementSelector.selectElements(sspHandler, roleContentInfoElementHandler);
     System.out.println("role = contentinfo elements size :"+roleContentInfoElementHandler.size());
     
     // Selection of Role content Info element
    ElementSelector roleBannerElementSelector = 
            new SimpleElementSelector("*[role=banner]");
    roleBannerElementSelector.selectElements(sspHandler, roleBannerElementHandler);
     System.out.println("role=banner elements size :"+roleBannerElementHandler.size());
     
      // Selection of Role search Info element
    ElementSelector roleSearchElementSelector = 
            new SimpleElementSelector("*[role=search]");
    roleSearchElementSelector.selectElements(sspHandler, roleSearchElementHandler);
     System.out.println("role=search elements size :"+roleSearchElementHandler.size());
     
      // Selection of Wrong header element(without role = banner) 
    ElementSelector wrongHeaderElementSelector = 
            new SimpleElementSelector("header:not([role=banner])");
    wrongHeaderElementSelector.selectElements(sspHandler, wrongHeaderElementHandler);
     System.out.println("header without role=banner elements size :"+wrongHeaderElementHandler.size());
     
     // Selection of Wrong footer element(without role = contentinfo) 
    ElementSelector wrongFooterElementSelector = 
            new SimpleElementSelector("footer:not([role=contentinfo])");
    wrongFooterElementSelector.selectElements(sspHandler, wrongFooterElementHandler);
     System.out.println("footer without role=contentinfo elements size :"+wrongFooterElementHandler.size());
     
     // Selection of main element(without role = main) 
    ElementSelector wrongMainElementSelector = 
            new SimpleElementSelector("main:not([role=main])");
    wrongMainElementSelector.selectElements(sspHandler, wrongMainElementHandler);
     System.out.println("main without role=main elements size :"+wrongMainElementHandler.size());
     
     // Selection of input element(without role = main) 
    ElementSelector inputRoleSearchElementSelector = 
            new SimpleElementSelector("input[role=search]");
    inputRoleSearchElementSelector.selectElements(sspHandler, inputRoleSearchElementHandler);
     System.out.println("input with role=search elements size :"+inputRoleSearchElementHandler.size());
     
     // Selection of elements ,execpt input, with role = search  
    ElementSelector missingRoleSearchElementSelector = 
            new SimpleElementSelector("*[role=search]:not(input,form)");
    missingRoleSearchElementSelector.selectElements(sspHandler, missingRoleSearchElementHandler);
     System.out.println("missing with role = search  size :"+missingRoleSearchElementHandler.size());
     
     // Selection of elements with role =navigation  
    ElementSelector roleNavigationElementSelector = 
            new SimpleElementSelector("*[role=navigation]");
    roleNavigationElementSelector.selectElements(sspHandler, missingRoleSearchElementHandler);
     System.out.println("missing with role = search  size :"+missingRoleSearchElementHandler.size());
}

@Override
protected void check(
        SSPHandler sspHandler, 
        TestSolutionHandler testSolutionHandler) {
    
    //role main elements
     ElementChecker roleMainChecker  = new RoleMainElementChecker(
              // successful solution pair
             new ImmutablePair(TestSolution.NEED_MORE_INFO,CHECK_ROLE_MAIN_ELEMENT_MSG),
             // failaire solution pair
             new ImmutablePair(TestSolution.FAILED,MISSING_ROLE_ARIA_MAIN_MSG)
     );
     roleMainChecker.check(                   
                sspHandler, 
                roleMainElementHandler, 
                testSolutionHandler);
    
    //role contentinfo elements
     ElementChecker roleContentInfoChecker  = new RoleStructureElementChecker(
              // successful solution pair (set=0)
             new ImmutablePair(TestSolution.NEED_MORE_INFO,MISSING_ROLE_CONTENT_INFO_ARIA_MSG),
             // failaire solution pair(set>1)
             new ImmutablePair(TestSolution.FAILED,ROLE_CONTENT_INFO_ARIA_UNICITY_MSG)
     );
     roleContentInfoChecker.check(                   
                sspHandler, 
                roleContentInfoElementHandler, 
                testSolutionHandler);
     
     //role Banner elements
     ElementChecker roleBannerChecker  = new RoleStructureElementChecker(
              // successful solution pair
             new ImmutablePair(TestSolution.NEED_MORE_INFO, MISSING_ROLE_BANNER_ARIA_MSG),
             // failaire solution pair
             new ImmutablePair(TestSolution.FAILED,ROLE_BANNER_ARIA_UNICITY_MSG)
     );
     roleBannerChecker.check(                   
                sspHandler, 
                roleBannerElementHandler, 
                testSolutionHandler);
     //role search elements
     ElementChecker roleSearchChecker  = new RoleStructureElementChecker(
              // successful solution pair
             new ImmutablePair(TestSolution.NEED_MORE_INFO, MISSING_ROLE_SEARCH_ARIA_MSG),
             // failaire solution pair
             new ImmutablePair(TestSolution.FAILED,ROLE_SEARCH_ARIA_UNICITY_MSG)
     );
     roleSearchChecker.check(                   
                sspHandler, 
                roleSearchElementHandler, 
                testSolutionHandler);
     
     //wrong header elements
    ElementChecker wrongHeaderElementChecker = new ForbiddenParentElementChecker(
                    new ImmutablePair(TestSolution.FAILED,ADD_ROLE_BANNER_MSG),
                    new ImmutablePair(TestSolution.NEED_MORE_INFO,""));

    wrongHeaderElementChecker.check(
                sspHandler, 
                wrongHeaderElementHandler, 
                testSolutionHandler);
    
    //wrong footer elements
    ElementChecker wrongFooterElementChecker = new ForbiddenParentElementChecker(
                    new ImmutablePair(TestSolution.FAILED,ADD_ROLE_CONTENT_INFO_MSG),
                    new ImmutablePair(TestSolution.NEED_MORE_INFO,""));

    wrongFooterElementChecker.check(
                sspHandler, 
                wrongFooterElementHandler, 
                testSolutionHandler);
    
    //wrong main elements
    ElementChecker wrongMainElementChecker = new ElementPresenceChecker(
                    new ImmutablePair(TestSolution.FAILED,MAIN_WITHOUT_ROLE_MAIN_ARIA_MSG),
                    new ImmutablePair(TestSolution.NEED_MORE_INFO,""));

    wrongMainElementChecker.check(
                sspHandler, 
                wrongMainElementHandler, 
                testSolutionHandler);
    
    //wrong input role search elements
    ElementChecker inputRoleSearchElementChecker = new ElementPresenceChecker(
                    new ImmutablePair(TestSolution.FAILED,ROLE_SEARCH_ON_INPUT_MSG),
                    new ImmutablePair(TestSolution.NEED_MORE_INFO,""));

    inputRoleSearchElementChecker.check(
                sspHandler, 
                inputRoleSearchElementHandler, 
                testSolutionHandler);
    
    //missing role search elements
    ElementChecker missingRoleSearchElementChecker = new ElementPresenceChecker(
                    new ImmutablePair(TestSolution.NEED_MORE_INFO,""),
                    new ImmutablePair(TestSolution.FAILED,MISSING_ROLE_SEARCH_ARIA_MSG));

    missingRoleSearchElementChecker.check(
                sspHandler, 
                missingRoleSearchElementHandler, 
                testSolutionHandler);
    
    // role navigation elements
    ElementChecker roleNavigationElementChecker = new ElementPresenceChecker(
                    new ImmutablePair(TestSolution.NEED_MORE_INFO,CHECK_ROLE_NAGIVATION_ARIA_MSG),
                    new ImmutablePair(TestSolution.NEED_MORE_INFO,MISSING_ROLE_NAVIGATION_ARIA_MSG));

    roleNavigationElementChecker.check(
                sspHandler, 
                roleNavigationElementHandler, 
                testSolutionHandler);
}

@Override
public int getSelectionSize() {
    return totalNumberOfElements;
}
}