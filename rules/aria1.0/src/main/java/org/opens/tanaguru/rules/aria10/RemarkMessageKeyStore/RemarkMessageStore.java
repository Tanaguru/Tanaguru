/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.opens.tanaguru.rules.aria10.RemarkMessageKeyStore;

/**
 *
 * @author alingua
 */
public final class RemarkMessageStore {

    //----------------------------------------------------------------------
    //-----------REMARK MESSAGES FOR ACCORDION DESIGN PATTERN---------------
    //----------------------------------------------------------------------

    /* tablist remark */
    public static final String TABLIST_ROLE_WITHOUT_ARIA_MULTISELECTABLE =
            "tablistRoleWithoutAriaMultiselectable";
    public static final String TABLIST_ROLE_WITH_ARIA_MULTISELECTABLE_WRONG_SET = 
            "tablistRoleWithAriaMultiselectableNotSetHasTrue";
    
    /* tab remark */
    public static final String TAB_ROLE_WITHOUT_ANCESTOR_WITH_TABLIST_ROLE = 
            "tabRoleWithoutAncestorWithRoleTabList";
    public static final String TAB_ROLE_WITHOUT_AN_ID_ATTR = 
            "tabRoleWithoutAnIdAttribute";
    public static final String TAB_ROLE_WITHOUT_AN_ARIA_SELECTED_ATTR = 
            "tabRoleWithoutAnAriaSelectedAttribute";
    public static final String TABLIST_ROLE_WITH_MULTIPLE_TAB_ARIA_SELECTED_SET_HAS_TRUE = 
            "tablistRoleWithMultipleTabWithAriaSelectedSetHasTrue";
    
    /* tabpanel remark */
    public static final String TABPANEL_ROLE_WITHOUT_ANCESTOR_WITH_TABLIST_ROLE =
            "tabpanelRoleWithoutAncestorWithRoleTabList";
    public static final String TABPANEL_ROLE_WITHOUT_AN_ARIA_EXPANDED_ATTR = 
            "tabpanelRoleWithoutAnAriaExpandedAttribute";
    public static final String TABPANEL_ROLE_WITHOUT_AN_ARIA_HIDDEN_ATTR = 
            "tabpanelRoleWithoutAnAriaHiddenAttribute";
    public static final String TABPANEL_ROLE_WITHOUT_AN_ARIA_LABELLEDBY_ATTR = 
            "tabpanelRoleWithoutAnAriaLabelledbyAttribute";
    public static final String TABPANEL_ROLE_WITH_ARIA_HIDDEN_AND_EXPANDED_SET_TO_SAME_VALUE = 
            "tabpanelRoleWithAnAriaHiddenAndExpandedAttributeSetToSameValue";
    public static final String TABPANEL_ROLE_UNDEFINED_REFERENCE_ID_HEADER = 
            "tabpanelRoleUndefinedReferencedIdHeader";
    public static final String TABPANEL_ROLE_MULTIPLE_REFERENCE_ID_HEADER = 
            "tabpanelRoleMultipleReferencedIdHeader";

    private RemarkMessageStore() {
    }
}
