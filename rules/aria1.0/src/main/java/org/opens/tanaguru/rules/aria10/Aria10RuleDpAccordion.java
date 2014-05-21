/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.opens.tanaguru.rules.aria10;

import java.util.ArrayList;
import java.util.Collection;
import org.jsoup.nodes.Element;
import org.opens.tanaguru.entity.audit.TestSolution;
import org.opens.tanaguru.processor.SSPHandler;
import org.opens.tanaguru.ruleimplementation.AbstractPageRuleMarkupImplementation;
import org.opens.tanaguru.ruleimplementation.ElementHandler;
import org.opens.tanaguru.ruleimplementation.ElementHandlerImpl;
import org.opens.tanaguru.ruleimplementation.TestSolutionHandler;
import org.opens.tanaguru.rules.aria10.RemarkMessageKeyStore.RemarkMessageStore;
import org.opens.tanaguru.rules.elementchecker.element.ElementPresenceChecker;
import org.opens.tanaguru.rules.elementselector.IdElementSelector;
import org.opens.tanaguru.rules.elementselector.SimpleElementSelector;

/**
 *
 * @author alingua
 */
public class Aria10RuleDpAccordion extends AbstractPageRuleMarkupImplementation {

    private static final String TRUE_VALUE = "true";
    private static final String MULTI_SELECTABLE_ATTR = "aria-multiselectable";
    private static final String ARIA_SELECTED_ATTR = "aria-selected";
    private static final String ARIA_EXPANDED_ATTR = "aria-expanded";
    private static final String ARIA_HIDDEN_ATTR = "aria-hidden";
    private static final String ARIA_LABELLEDBY_ATTR = "aria-labelledby";
    private static final String ID_ATTR = "id";
    private static final String ROLE_TABLIST_WITH_ARIA_QUERY = "[role=tablist][aria-multiselectable=true]";
    private static final String ROLE_TAB_UNDER_TABLIST_QUERY = "[role=tablist] [role=tab]";
    private static final String ROLE_TABPANEL_QUERY = "[role=tabpanel]";
    private static final String ROLE_TABLIST_QUERY = "[role=tablist]";
    private static final String ROLE_TAB_QUERY = "[role=tab]";
    private static final String ARIA_SELECTED_QUERY = "[aria-selected=true]";
    private static final String ROLE_TABPANEL_WITH_ARIA_LABELLEDBY_QUERY = "[role=tabpanel][aria-labelledby]";
    private ElementHandler<Element> tablistElementsHandler = new ElementHandlerImpl();
    private ElementHandler<Element> tablistElementsHandlerWithAriaAttributeNotSetHasTrue = new ElementHandlerImpl();
    private ElementHandler<Element> tablistElementsHandlerWithAriaAttributeSetHasTrue = new ElementHandlerImpl();
    private ElementHandler<Element> tabElementsHandler = new ElementHandlerImpl();
    private ElementHandler<Element> tabElementsHandlerUnderTablistElement = new ElementHandlerImpl();
    private ElementHandler<Element> tabpanelElementsHandler = new ElementHandlerImpl();

    @Override
    protected void select(SSPHandler sspHandler, ElementHandler<Element> elementHandler) {
        SimpleElementSelector elementSelector = new SimpleElementSelector(ROLE_TABLIST_QUERY);
        elementSelector.selectElements(sspHandler, tablistElementsHandler);
        elementSelector.setCssLikeQuery(ROLE_TABLIST_WITH_ARIA_QUERY);
        elementSelector.selectElements(sspHandler, tablistElementsHandlerWithAriaAttributeSetHasTrue);
        elementSelector.setCssLikeQuery(ROLE_TAB_QUERY);
        elementSelector.selectElements(sspHandler, tabElementsHandler);
        elementSelector.setCssLikeQuery(ROLE_TAB_UNDER_TABLIST_QUERY);
        elementSelector.selectElements(sspHandler, tabElementsHandlerUnderTablistElement);
        elementSelector.setCssLikeQuery(ROLE_TABPANEL_QUERY);
        elementSelector.selectElements(sspHandler, tabpanelElementsHandler);
    }

    @Override
    protected void check(SSPHandler sspHandler, ElementHandler<Element> elementHandler, TestSolutionHandler testSolutionHandler) {
        // Test if tablist, tab and tabpanel are presents, if not the test is NA
        if (tabElementsHandler.isEmpty() && tablistElementsHandler.isEmpty() && tabpanelElementsHandler.isEmpty()) {
            testSolutionHandler.addTestSolution(TestSolution.NOT_APPLICABLE);
            return;
        }
        if (testTablistElement(sspHandler) || testTabElement(sspHandler) || testTabPanelElement(sspHandler)) {
            return;
        }
        testSolutionHandler.addTestSolution(TestSolution.PASSED);
    }

    private boolean testTablistElement(SSPHandler sspHandler) {
        ElementHandler<Element> tablistElementsHandlerWithoutAriaAttribute = new ElementHandlerImpl();
        if (!tablistElementsHandler.isEmpty()) {
            for (Element tablistEl : tablistElementsHandler.get()) {
                if (tablistEl.hasAttr(MULTI_SELECTABLE_ATTR)
                        && tablistEl.attr(MULTI_SELECTABLE_ATTR).equalsIgnoreCase(TRUE_VALUE)) {
                    tablistElementsHandlerWithAriaAttributeSetHasTrue.add(tablistEl);
                } else if (tablistEl.hasAttr(MULTI_SELECTABLE_ATTR)
                        && !tablistEl.attr(MULTI_SELECTABLE_ATTR).equalsIgnoreCase(TRUE_VALUE)) {
                    tablistElementsHandlerWithAriaAttributeNotSetHasTrue.add(tablistEl);
                } else {
                    tablistElementsHandlerWithoutAriaAttribute.add(tablistEl);
                }
            }
        }
        if (!tablistElementsHandlerWithoutAriaAttribute.isEmpty()) {
            createRemarkFromElementHandler(sspHandler, tablistElementsHandlerWithoutAriaAttribute,
                    RemarkMessageStore.TABLIST_ROLE_WITHOUT_ARIA_MULTISELECTABLE);
            return true;
        }
        if (!tablistElementsHandlerWithAriaAttributeNotSetHasTrue.isEmpty()) {
            createRemarkFromElementHandler(sspHandler, tablistElementsHandlerWithAriaAttributeNotSetHasTrue,
                    RemarkMessageStore.TABLIST_ROLE_WITH_ARIA_MULTISELECTABLE_WRONG_SET);
            return true;
        }
        return false;
    }

    private boolean testTabElement(SSPHandler sspHandler) {
        if (!tabElementsHandler.get().isEmpty()) {
            ElementHandler<Element> roleTabElWithoutTablistAncestor = new ElementHandlerImpl();
            ElementHandler<Element> roleTabElWithoutAnIdAttribute = new ElementHandlerImpl();
            ElementHandler<Element> roleTabElWithoutAnAriaselectedAttribute = new ElementHandlerImpl();
            ElementHandler<Element> parentTabListRoleTabElement = new ElementHandlerImpl();
            for (Element tabEl : tabElementsHandler.get()) {
                listWithoutAncestorOrAddParentToList(tabEl, roleTabElWithoutTablistAncestor, parentTabListRoleTabElement);
                if (!tabEl.hasAttr(ID_ATTR)) {
                    roleTabElWithoutAnIdAttribute.add(tabEl);
                }
                if (!tabEl.hasAttr(ARIA_SELECTED_ATTR)) {
                    roleTabElWithoutAnAriaselectedAttribute.add(tabEl);
                }
            }
            // If a role=tab element hasn't an ancestor with role=tablist, the test is failed
            if (!roleTabElWithoutTablistAncestor.isEmpty()) {
                createRemarkFromElementHandler(sspHandler, roleTabElWithoutTablistAncestor,
                        RemarkMessageStore.TAB_ROLE_WITHOUT_ANCESTOR_WITH_TABLIST_ROLE);
                return true;
            }
            // If a role=tab element hasn't an id attribute to be referenced, the test is failed
            if (!roleTabElWithoutAnIdAttribute.isEmpty()) {
                createRemarkFromElementHandler(sspHandler, roleTabElWithoutAnIdAttribute,
                        RemarkMessageStore.TAB_ROLE_WITHOUT_AN_ID_ATTR);
                return true;
            }
            // If a role=tab element hasn't an aria-selected attribute, the test is failed
            if (!roleTabElWithoutAnAriaselectedAttribute.isEmpty()) {
                createRemarkFromElementHandler(sspHandler, roleTabElWithoutAnAriaselectedAttribute,
                        RemarkMessageStore.TAB_ROLE_WITHOUT_AN_ARIA_SELECTED_ATTR);
                return true;
            }
            // If there are multiple element role=tab with attr aria-selected set has true, the test failed
            if (!parentTabListRoleTabElement.isEmpty()) {
                ElementHandler<Element> multipleRoleTabAriaSelectedSetHasTrue = new ElementHandlerImpl();
                for (Element el : parentTabListRoleTabElement.get()) {
                    ElementHandler<Element> tmpMultipleRoleTabAriaSelectedSetHasTrue = new ElementHandlerImpl();
                    tmpMultipleRoleTabAriaSelectedSetHasTrue.addAll(el.select(ARIA_SELECTED_QUERY));
                    if (tmpMultipleRoleTabAriaSelectedSetHasTrue.get().size() > 1) {
                        multipleRoleTabAriaSelectedSetHasTrue.addAll(tmpMultipleRoleTabAriaSelectedSetHasTrue.get());
                    }
                }
                if (multipleRoleTabAriaSelectedSetHasTrue.get().size() > 1) {
                    createRemarkFromElementHandler(sspHandler, multipleRoleTabAriaSelectedSetHasTrue,
                            RemarkMessageStore.TABLIST_ROLE_WITH_MULTIPLE_TAB_ARIA_SELECTED_SET_HAS_TRUE);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean testTabPanelElement(SSPHandler sspHandler) {
        if (!tabpanelElementsHandler.isEmpty()) {
            ElementHandler<Element> roleTabPanelElWithoutTablistAncestor = new ElementHandlerImpl();
            ElementHandler<Element> parentTabListRoleTabPanelElement = new ElementHandlerImpl();
            ElementHandler<Element> tabpanelElementsHandlerWithoutAriaExpandedAttribute = new ElementHandlerImpl();
            ElementHandler<Element> tabpanelElementsHandlerWithoutAriaHiddenAttribute = new ElementHandlerImpl();
            ElementHandler<Element> tabpanelElementsHandlerWithoutAriaLabbelledbyAttribute = new ElementHandlerImpl();
            ElementHandler<Element> tabpanelElementsHandlerWithHiddenAndExpandedSameValueAttribute = new ElementHandlerImpl();
            for (Element tabpanelEl : tabpanelElementsHandler.get()) {
                listWithoutAncestorOrAddParentToList(tabpanelEl, roleTabPanelElWithoutTablistAncestor, parentTabListRoleTabPanelElement);
                if (!tabpanelEl.hasAttr(ARIA_EXPANDED_ATTR)) {
                    tabpanelElementsHandlerWithoutAriaExpandedAttribute.add(tabpanelEl);
                }
                if (!tabpanelEl.hasAttr(ARIA_HIDDEN_ATTR)) {
                    tabpanelElementsHandlerWithoutAriaHiddenAttribute.add(tabpanelEl);
                }
                if (!tabpanelEl.hasAttr(ARIA_LABELLEDBY_ATTR)) {
                    tabpanelElementsHandlerWithoutAriaLabbelledbyAttribute.add(tabpanelEl);
                }
                if (tabpanelEl.attr(ARIA_EXPANDED_ATTR).equalsIgnoreCase(tabpanelEl.attr(ARIA_HIDDEN_ATTR))) {
                    tabpanelElementsHandlerWithHiddenAndExpandedSameValueAttribute.add(tabpanelEl);
                }
            }
            // If a role=tabpanel element hasn't an ancestor with role=tablist, the test is failed

            if (!roleTabPanelElWithoutTablistAncestor.isEmpty()) {
                createRemarkFromElementHandler(sspHandler, roleTabPanelElWithoutTablistAncestor,
                        RemarkMessageStore.TABPANEL_ROLE_WITHOUT_ANCESTOR_WITH_TABLIST_ROLE);
                return true;
            }
            // If a role=tabpanel element hasn't an aria-expanded attribute, the test is failed
            if (!tabpanelElementsHandlerWithoutAriaExpandedAttribute.isEmpty()) {
                createRemarkFromElementHandler(sspHandler, tabpanelElementsHandlerWithoutAriaExpandedAttribute,
                        RemarkMessageStore.TABPANEL_ROLE_WITHOUT_AN_ARIA_EXPANDED_ATTR);
                return true;
            }
            // If a role=tabpanel element hasn't an aria-hidden attribute, the test is failed
            if (!tabpanelElementsHandlerWithoutAriaHiddenAttribute.isEmpty()) {
                createRemarkFromElementHandler(sspHandler, tabpanelElementsHandlerWithoutAriaHiddenAttribute,
                        RemarkMessageStore.TABPANEL_ROLE_WITHOUT_AN_ARIA_HIDDEN_ATTR);
                return true;
            }
            // If a role=tabpanel element hasn't an aria-labelledby attribute, the test is failed
            if (!tabpanelElementsHandlerWithoutAriaLabbelledbyAttribute.isEmpty()) {
                createRemarkFromElementHandler(sspHandler, tabpanelElementsHandlerWithoutAriaLabbelledbyAttribute,
                        RemarkMessageStore.TABPANEL_ROLE_WITHOUT_AN_ARIA_LABELLEDBY_ATTR);
                return true;
            }
            // If a role=tabpanel element has the same value set on the aria-hidden and aria-expanded attributes, the test is failed.
            // It's impossible to have a panel expanded and not hidden ...
            if (!tabpanelElementsHandlerWithHiddenAndExpandedSameValueAttribute.isEmpty()) {
                createRemarkFromElementHandler(sspHandler, tabpanelElementsHandlerWithHiddenAndExpandedSameValueAttribute,
                        RemarkMessageStore.TABPANEL_ROLE_WITH_ARIA_HIDDEN_AND_EXPANDED_SET_TO_SAME_VALUE);
                return true;
            }

            if (!parentTabListRoleTabPanelElement.isEmpty()) {
                ElementHandler<Element> undefinedReferenceToHeaderTab = new ElementHandlerImpl();
                ElementHandler<Element> multipleReferenceToHeaderTab = new ElementHandlerImpl();
                for (Element el : parentTabListRoleTabPanelElement.get()) {
                    ElementHandler<Element> tmpUndefinedReferenceToHeaderTab = new ElementHandlerImpl();
                    ElementHandler<Element> tmpMultipleReferenceToHeaderTab = new ElementHandlerImpl();
                    ElementHandler<Element> tmpEl = new ElementHandlerImpl();
                    Collection<String> listTabPanelLabelledbyValue = new ArrayList<String>();
                    SimpleElementSelector idSelector = new IdElementSelector();
                    for (Element tabPanelEl : el.select(ROLE_TABPANEL_WITH_ARIA_LABELLEDBY_QUERY)) {
                        String currentLabelledBy = tabPanelEl.attr(ARIA_LABELLEDBY_ATTR);
                        if (listTabPanelLabelledbyValue.contains(currentLabelledBy)) {
                            tmpMultipleReferenceToHeaderTab.add(tabPanelEl);
                        } else {
                            listTabPanelLabelledbyValue.add(currentLabelledBy);

                            idSelector.setCssLikeQuery(currentLabelledBy);
                            idSelector.selectElements(sspHandler, tmpEl);
                            if (tmpEl.isEmpty()) {
                                tmpUndefinedReferenceToHeaderTab.add(tabPanelEl);
                            }
                        }
                        tmpEl.clean();
                    }
                    undefinedReferenceToHeaderTab.addAll(tmpUndefinedReferenceToHeaderTab.get());
                    multipleReferenceToHeaderTab.addAll(tmpMultipleReferenceToHeaderTab.get());
                }
                if (!undefinedReferenceToHeaderTab.isEmpty()) {
                    createRemarkFromElementHandler(sspHandler, undefinedReferenceToHeaderTab,
                            RemarkMessageStore.TABPANEL_ROLE_UNDEFINED_REFERENCE_ID_HEADER);
                    return true;
                }
                if (!multipleReferenceToHeaderTab.isEmpty()) {
                    createRemarkFromElementHandler(sspHandler, multipleReferenceToHeaderTab,
                            RemarkMessageStore.TABPANEL_ROLE_MULTIPLE_REFERENCE_ID_HEADER);
                    return true;
                }
            }
        }
        return false;
    }

    private void listWithoutAncestorOrAddParentToList(Element tabEl,
            ElementHandler roleTabElWithoutTablistAncestor,
            ElementHandler parentTabListRoleTabElement) {
        if (tabEl.parents().select(ROLE_TABLIST_QUERY).isEmpty()) {
            roleTabElWithoutTablistAncestor.add(tabEl);
        } else if (!parentTabListRoleTabElement.get().contains(tabEl.parents().select(ROLE_TABLIST_QUERY).first())) {
            parentTabListRoleTabElement.add(tabEl.parents().select(ROLE_TABLIST_QUERY).first());
        }
    }

    @Override
    public int getSelectionSize() {
        return tablistElementsHandler.get().size() + tabElementsHandler.get().size() + tabpanelElementsHandler.get().size();
    }

    private void createRemarkFromElementHandler(SSPHandler sspHandler, ElementHandler elementHandler, String messageNameOnDetection) {
        ElementPresenceChecker apc1 = new ElementPresenceChecker(messageNameOnDetection, null);
        apc1.check(sspHandler, elementHandler, this);
    }
}