
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
import org.tanaguru.rules.elementchecker.DocumentStructureChecker;
import org.tanaguru.rules.elementchecker.ElementChecker;
import org.tanaguru.rules.elementchecker.element.ElementPresenceChecker;
import org.tanaguru.rules.elementchecker.element.ForbiddenParentElementChecker;
import org.tanaguru.rules.elementchecker.element.ForbiddenParentaAndUnicityElementChecker;
import org.tanaguru.rules.elementselector.ElementSelector;
import org.tanaguru.rules.elementselector.SimpleElementSelector;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_DETECTED_MAIN_ELEMNT_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_FOOTER_ELEMENT_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_HEADER_ELEMENT_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_MAIN_ELEMENT_MULTIPLE_MISSING_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_NAV_ELEMNT_WITH_NAVIGATION_ROLE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.MISIING_ROLE_NAVIGATION_IN_NAV_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.MISSING_NAV_ELEMNT_WITH_NAVIGATION_ROLE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.MISSING_ROLE_MAIN_IN_MAIN_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.ROLE_BANNER_NOT_IN_HEADER_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.ROLE_BANNER_UNICITY_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.ROLE_CONTENT_INFO_NOT_IN_FOOTER_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.ROLE_CONTENT_INFO_UNICITY_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.ROLE_MAIN_NOT_IN_MAIN_MSG;

/**
 * Implementation of the rule 9.2.1 of the referential Rgaa 3-2017.
 *
 * For more details about the implementation, refer to
 * <a href="http://tanaguru-rules-rgaa3.readthedocs.org/en/latest/Rule-9-2-1">the
 * rule 9.2.1 design page.</a>
 *
 * @see
 * <a href="http://references.modernisation.gouv.fr/referentiel-technique-0#test-9-2-1">
 * 9.2.1 rule specification</a>
 */
public class Rgaa32017Rule090201 extends AbstractPageRuleWithDoctypeHtml5CheckerImplementation {

    //definir ic les selecteurs simples 
    // definir ici les checkers 
    //* the main elements*/
    ElementHandler<Element> mainElementHandler = new ElementHandlerImpl();
//* the wrong main elements*/
    ElementHandler<Element> wrongMainElementHandler = new ElementHandlerImpl();
    /* the nav elements*/
    ElementHandler<Element> navElementHandler = new ElementHandlerImpl();
    /* the wrong nav elements*/
    ElementHandler<Element> wrongNavElementHandler = new ElementHandlerImpl();

    /* the wrong role header elements*/
    ElementHandler<Element> wrongRoleHeaderElementHandler = new ElementHandlerImpl();

    /* the wrong role footer elements*/
    ElementHandler<Element> wrongRoleFooterElementHandler = new ElementHandlerImpl();

//* the header elements*/
    ElementHandler<Element> headerElementHandler = new ElementHandlerImpl();

//* the footer elements*/
    ElementHandler<Element> footerElementHandler = new ElementHandlerImpl();

    /* the header with role banner elements*/
    ElementHandler<Element> headerRoleBannerElementHandler = new ElementHandlerImpl();

    /* the footer with role contentinfo elements*/
    ElementHandler<Element> footerRoleContentInfoElementHandler = new ElementHandlerImpl();

    /* the total number of elements */
    int totalNumberOfElements = 0;

    /**
     * Default constructor
     */
    public Rgaa32017Rule090201() {
        super();
    }

    @Override
    protected void select(SSPHandler sspHandler) {
        // Selection of main element
        ElementSelector mainElementSelector
                = new SimpleElementSelector("main");
        mainElementSelector.selectElements(sspHandler, mainElementHandler);
        System.out.println("main elements size :" + mainElementHandler.size());

        //Selection of wrong main element
        ElementSelector wrongMainElementSelector
                = new SimpleElementSelector("*[role=main]:not(main)");
        wrongMainElementSelector.selectElements(sspHandler, wrongMainElementHandler);
        System.out.println("wrong main elements size :" + wrongMainElementHandler.size());

        // Selection of nav element
        ElementSelector navElementSelector
                = new SimpleElementSelector("nav[role=navigation]");
        navElementSelector.selectElements(sspHandler, navElementHandler);

        //Selection of wrong nav element
        ElementSelector wrongNavElementSelector
                = new SimpleElementSelector("*[role=navigation]:not(nav)");
        wrongNavElementSelector.selectElements(sspHandler, wrongNavElementHandler);
        System.out.println("role Nav elements size :" + wrongNavElementHandler.size());

        //Selection of wrong role header element
        ElementSelector wrongRoleHeaderElementSelector
                = new SimpleElementSelector("*[role=banner]:not(header)");
        wrongRoleHeaderElementSelector.selectElements(sspHandler, wrongRoleHeaderElementHandler);
        System.out.println(" wrong role header elements size :" + wrongRoleHeaderElementHandler.size());

        //Selection of wrong role footer element
        ElementSelector wrongRoleFooterElementSelector
                = new SimpleElementSelector("*[role=contentinfo]:not(footer)");
        wrongRoleFooterElementSelector.selectElements(sspHandler, wrongRoleFooterElementHandler);
        System.out.println(" wrong role footer elements size :" + wrongRoleFooterElementHandler.size());

        // Selection of header element
        ElementSelector headerElementSelector
                = new SimpleElementSelector("header:not([role=banner])");
        headerElementSelector.selectElements(sspHandler, headerElementHandler);
        System.out.println("header elements size :" + headerElementHandler.size());

        // Selection of header element
        ElementSelector footerElementSelector
                = new SimpleElementSelector("footer:not([role=contentinfo])");
        footerElementSelector.selectElements(sspHandler, footerElementHandler);
        System.out.println("footer elements size :" + footerElementHandler.size());

        // Selection of header with role banner element
        ElementSelector headerRoleBannerElementSelector
                = new SimpleElementSelector("header[role=banner]");
        headerRoleBannerElementSelector.selectElements(sspHandler, headerRoleBannerElementHandler);
        System.out.println("header with role banner elements size :" + headerRoleBannerElementHandler.size());

        // Selection of footer with role contentinfo element
        ElementSelector footerRoleContentInfoElementSelector
                = new SimpleElementSelector("footer[role=contentinfo]");
        footerRoleContentInfoElementSelector.selectElements(sspHandler, footerRoleContentInfoElementHandler);
        System.out.println("footer with role contentinfo elements size :" + footerRoleContentInfoElementHandler.size());

        //footerRoleContentInfoElementHandler
        totalNumberOfElements = sspHandler.getTotalNumberOfElements();
        System.out.println("Total elements size :" + totalNumberOfElements);
    }

    @Override
    protected void check(
            SSPHandler sspHandler,
            TestSolutionHandler testSolutionHandler) {

    //Main elements
        ElementChecker documentStructureChecker = new DocumentStructureChecker(
                // successful solution pair
                new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_DETECTED_MAIN_ELEMNT_MSG),
                // failure solution pair
                new ImmutablePair(TestSolution.FAILED, CHECK_MAIN_ELEMENT_MULTIPLE_MISSING_MSG)
        );

        documentStructureChecker.check(
                sspHandler,
                mainElementHandler,
                testSolutionHandler);

        //wrong main elements
        ElementChecker wrongMainElementSelector = new ElementPresenceChecker(
                new ImmutablePair(TestSolution.FAILED, ROLE_MAIN_NOT_IN_MAIN_MSG),
                new ImmutablePair(TestSolution.NEED_MORE_INFO, MISSING_ROLE_MAIN_IN_MAIN_MSG));

        wrongMainElementSelector.check(
                sspHandler,
                wrongMainElementHandler,
                testSolutionHandler);

   //navigation elements
        ElementChecker navElementChecker = new ElementPresenceChecker(
                new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_NAV_ELEMNT_WITH_NAVIGATION_ROLE_MSG),
                new ImmutablePair(TestSolution.NEED_MORE_INFO,MISIING_ROLE_NAVIGATION_IN_NAV_MSG));

        navElementChecker.check(
                sspHandler,
                navElementHandler,
                testSolutionHandler);

    //wrong navigation elements
        ElementChecker wrongNavElementChecher = new ElementPresenceChecker(//"role navigation attribute should be in nav tag"
                new ImmutablePair(TestSolution.FAILED,MISSING_NAV_ELEMNT_WITH_NAVIGATION_ROLE_MSG),
                new ImmutablePair(TestSolution.NEED_MORE_INFO, ""));
        wrongNavElementChecher.check(
                sspHandler,
                wrongNavElementHandler,
                testSolutionHandler);

    //wrong role header elements
        ElementChecker wrongRoleHeaderElementChecker = new ForbiddenParentElementChecker(
                new ImmutablePair(TestSolution.FAILED, ROLE_BANNER_NOT_IN_HEADER_MSG),
                new ImmutablePair(TestSolution.NEED_MORE_INFO, ""));
        wrongRoleHeaderElementChecker.check(
                sspHandler,
                wrongRoleHeaderElementHandler,
                testSolutionHandler);

        //wrong role footer elements
        ElementChecker wrongRoleFooterElementChecker = new ForbiddenParentElementChecker(
                new ImmutablePair(TestSolution.FAILED, ROLE_CONTENT_INFO_NOT_IN_FOOTER_MSG),
                new ImmutablePair(TestSolution.NEED_MORE_INFO, ""));
        wrongRoleFooterElementChecker.check(
                sspHandler,
                wrongRoleFooterElementHandler,
                testSolutionHandler);

        // header elements
        ElementChecker HeaderElementChecker = new ForbiddenParentElementChecker(
                new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_HEADER_ELEMENT_MSG),
                new ImmutablePair(TestSolution.NEED_MORE_INFO,""));//MISSING_HEADER_ELEMENT_MSG
        HeaderElementChecker.check(
                sspHandler,
                headerElementHandler,
                testSolutionHandler);

        // footer elements
        ElementChecker footerElementChecker = new ForbiddenParentElementChecker(
                new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_FOOTER_ELEMENT_MSG),
                new ImmutablePair(TestSolution.NEED_MORE_INFO,""));//MISSING_FOOTER_ELEMENT_MSG
        footerElementChecker.check(
                sspHandler,
                footerElementHandler,
                testSolutionHandler);

        // header role  Banner elements
        ElementChecker headerRoleBannerElementChecker = new ForbiddenParentaAndUnicityElementChecker(
                new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_HEADER_ELEMENT_MSG),
                new ImmutablePair(TestSolution.FAILED, ROLE_BANNER_UNICITY_MSG));
        headerRoleBannerElementChecker.check(
                sspHandler,
                headerRoleBannerElementHandler,
                testSolutionHandler);

        // footer role contentinfo elements
        ElementChecker footerRoleContentInfoElementChecker = new ForbiddenParentaAndUnicityElementChecker(
                new ImmutablePair(TestSolution.NEED_MORE_INFO, CHECK_FOOTER_ELEMENT_MSG),
                new ImmutablePair(TestSolution.FAILED, ROLE_CONTENT_INFO_UNICITY_MSG));
        footerRoleContentInfoElementChecker.check(
                sspHandler,
                footerRoleContentInfoElementHandler,
                testSolutionHandler);

    }

    @Override
    public int getSelectionSize() {
        return totalNumberOfElements;
    }
}
