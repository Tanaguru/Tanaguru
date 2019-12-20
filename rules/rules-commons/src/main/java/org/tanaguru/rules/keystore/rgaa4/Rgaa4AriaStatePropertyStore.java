package org.tanaguru.rules.keystore.rgaa4;

import org.tanaguru.rules.accessiblename.AriaStateProperty;
import org.tanaguru.rules.accessiblename.EAriaStatePropertyType;
import org.tanaguru.rules.accessiblename.EAriaStatePropertyValue;

import java.util.HashMap;
import java.util.Map;

import static org.tanaguru.rules.accessiblename.EAriaStatePropertyType.*;
import static org.tanaguru.rules.accessiblename.EAriaStatePropertyValue.*;

public class Rgaa4AriaStatePropertyStore {
    private static Map<String, AriaStateProperty> RGAA4_ARIA_STATE_PROPERTY_STORE = new HashMap<>();

    public static AriaStateProperty get(String aria_state_property){
        return RGAA4_ARIA_STATE_PROPERTY_STORE.get(aria_state_property);
    }

    static{
        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-activedescendant",
                new AriaStateProperty("aria-activedescendant",
                        new EAriaStatePropertyType[]{RELATIONSHIP}));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-atomic",
                new AriaStateProperty("aria-atomic",
                        new EAriaStatePropertyType[]{LIVE_REGION},
                        new EAriaStatePropertyValue[]{FALSE, TRUE},
                        FALSE,
                        true,
                        false));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-autocomplete",
                new AriaStateProperty("aria-autocomplete",
                        new EAriaStatePropertyType[]{WIDGET},
                        new EAriaStatePropertyValue[]{BOTH, INLINE, LIST, NONE},
                        NONE));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-busy",
                new AriaStateProperty("aria-busy",
                        new EAriaStatePropertyType[]{LIVE_REGION},
                        new EAriaStatePropertyValue[]{FALSE, TRUE},
                        NONE,
                        true,
                        false));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-checked",
                new AriaStateProperty("aria-checked",
                        new EAriaStatePropertyType[]{WIDGET},
                        new EAriaStatePropertyValue[]{FALSE, MIXED, TRUE, UNDEFINED},
                        UNDEFINED));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-colcount",
                new AriaStateProperty("aria-colcount",
                        new EAriaStatePropertyType[]{RELATIONSHIP}));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-colindex",
                new AriaStateProperty("aria-colindex",
                        new EAriaStatePropertyType[]{RELATIONSHIP}));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-colspan",
                new AriaStateProperty("aria-colspan",
                        new EAriaStatePropertyType[]{RELATIONSHIP}));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-controls",
                new AriaStateProperty("aria-controls",
                        new EAriaStatePropertyType[]{RELATIONSHIP},
                        true));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-current",
                new AriaStateProperty("aria-current",
                        new EAriaStatePropertyType[]{},
                        new EAriaStatePropertyValue[]{DATE, FALSE, LOCATION, PAGE, STEP, TIME, TRUE},
                        FALSE,
                        true,
                        false));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-describedby",
                new AriaStateProperty("aria-describedby",
                        new EAriaStatePropertyType[]{RELATIONSHIP},
                        true));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-details",
                new AriaStateProperty("aria-details",
                        new EAriaStatePropertyType[]{RELATIONSHIP},
                        true));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-disabled",
                new AriaStateProperty("aria-disabled",
                        new EAriaStatePropertyType[]{WIDGET},
                        new EAriaStatePropertyValue[]{DATE, TRUE},
                        FALSE,
                        true,
                        false));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-dropeffect",
                new AriaStateProperty("aria-dropeffect",
                        new EAriaStatePropertyType[]{DRAG_AND_DROP},
                        new EAriaStatePropertyValue[]{COPY, EXECUTE, LINK, MOVE, NONE, POPUP},
                        NONE,
                        true,
                        false));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-errormessage",
                new AriaStateProperty("aria-errormessage",
                        new EAriaStatePropertyType[]{RELATIONSHIP, WIDGET},
                        true));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-expanded",
                new AriaStateProperty("aria-expanded",
                        new EAriaStatePropertyType[]{WIDGET},
                        new EAriaStatePropertyValue[]{FALSE, TRUE, UNDEFINED},
                        UNDEFINED));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-flowto",
                new AriaStateProperty("aria-flowto",
                        new EAriaStatePropertyType[]{RELATIONSHIP},
                        true));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-grabbed",
                new AriaStateProperty("aria-grabbed",
                        new EAriaStatePropertyType[]{DRAG_AND_DROP},
                        new EAriaStatePropertyValue[]{FALSE, TRUE, UNDEFINED},
                        UNDEFINED,
                        true,
                        false));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-haspopup",
                new AriaStateProperty("aria-haspopup",
                        new EAriaStatePropertyType[]{WIDGET},
                        new EAriaStatePropertyValue[]{DIALOG, FALSE, GRID, LISTBOX, MENU, TREE, TRUE},
                        FALSE,
                        true,
                        false,
                        true));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-hidden",
                new AriaStateProperty("aria-hidden",
                        new EAriaStatePropertyType[]{WIDGET},
                        new EAriaStatePropertyValue[]{FALSE, TRUE, UNDEFINED},
                        UNDEFINED,
                        true,
                        false));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-invalid",
                new AriaStateProperty("aria-invalid",
                        new EAriaStatePropertyType[]{WIDGET},
                        new EAriaStatePropertyValue[]{FALSE, TRUE, GRAMMAR, SPELLING},
                        FALSE,
                        true,
                        false));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-keyshortcuts",
                new AriaStateProperty("aria-keyshortcuts",
                        new EAriaStatePropertyType[]{},
                        true));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-label",
                new AriaStateProperty("aria-label",
                        new EAriaStatePropertyType[]{WIDGET},
                        true));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-labelledby",
                new AriaStateProperty("aria-labelledby",
                        new EAriaStatePropertyType[]{RELATIONSHIP},
                        true));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-level",
                new AriaStateProperty("aria-level",
                        new EAriaStatePropertyType[]{WIDGET}));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-live",
                new AriaStateProperty("aria-live",
                        new EAriaStatePropertyType[]{LIVE_REGION},
                        new EAriaStatePropertyValue[]{ASSERTIVE, OFF, POLITE},
                        OFF,
                        true,
                        false));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-modal",
                new AriaStateProperty("aria-modal",
                        new EAriaStatePropertyType[]{WIDGET},
                        new EAriaStatePropertyValue[]{FALSE, TRUE},
                        FALSE));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-multiline",
                new AriaStateProperty("aria-multiline",
                        new EAriaStatePropertyType[]{WIDGET},
                        new EAriaStatePropertyValue[]{FALSE, TRUE},
                        FALSE));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-multiselectable",
                new AriaStateProperty("aria-multiselectable",
                        new EAriaStatePropertyType[]{WIDGET},
                        new EAriaStatePropertyValue[]{FALSE, TRUE},
                        FALSE));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-orientation",
                new AriaStateProperty("aria-orientation",
                        new EAriaStatePropertyType[]{WIDGET},
                        new EAriaStatePropertyValue[]{HORIZONTAL, VERTICAL, UNDEFINED},
                        UNDEFINED));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-owns",
                new AriaStateProperty("aria-owns",
                        new EAriaStatePropertyType[]{RELATIONSHIP},
                        true));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-placeholder",
                new AriaStateProperty("aria-placeholder",
                        new EAriaStatePropertyType[]{WIDGET}));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-posinset",
                new AriaStateProperty("aria-posinset",
                        new EAriaStatePropertyType[]{RELATIONSHIP}));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-pressed",
                new AriaStateProperty("aria-pressed",
                        new EAriaStatePropertyType[]{WIDGET},
                        new EAriaStatePropertyValue[]{FALSE, TRUE, MIXED, UNDEFINED},
                        UNDEFINED));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-readonly",
                new AriaStateProperty("aria-readonly",
                        new EAriaStatePropertyType[]{WIDGET},
                        new EAriaStatePropertyValue[]{FALSE, TRUE},
                        FALSE));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-relevant",
                new AriaStateProperty("aria-relevant",
                        new EAriaStatePropertyType[]{LIVE_REGION},
                        new EAriaStatePropertyValue[]{ADDITIONS, ALL, REMOVALS, TEXT},
                        FALSE,
                        true,
                        true));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-required",
                new AriaStateProperty("aria-required",
                        new EAriaStatePropertyType[]{WIDGET},
                        new EAriaStatePropertyValue[]{FALSE, TRUE},
                        FALSE));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-roledescription",
                new AriaStateProperty("aria-roledescription",
                        new EAriaStatePropertyType[]{},
                        true));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-rowcount",
                new AriaStateProperty("aria-rowcount",
                        new EAriaStatePropertyType[]{RELATIONSHIP}));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-rowindex",
                new AriaStateProperty("aria-rowindex",
                        new EAriaStatePropertyType[]{RELATIONSHIP}));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-rowspan",
                new AriaStateProperty("aria-rowspan",
                        new EAriaStatePropertyType[]{RELATIONSHIP}));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-selected",
                new AriaStateProperty("aria-selected",
                        new EAriaStatePropertyType[]{WIDGET},
                        new EAriaStatePropertyValue[]{FALSE, TRUE, UNDEFINED},
                        UNDEFINED));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-setsize",
                new AriaStateProperty("aria-setsize",
                        new EAriaStatePropertyType[]{RELATIONSHIP}));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-sort",
                new AriaStateProperty("aria-sort",
                        new EAriaStatePropertyType[]{WIDGET},
                        new EAriaStatePropertyValue[]{NONE, ASCENDING, DESCENDING, OTHER},
                        NONE));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-valuemax",
                new AriaStateProperty("aria-valuemax",
                        new EAriaStatePropertyType[]{WIDGET}));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-valuemin",
                new AriaStateProperty("aria-valuemin",
                        new EAriaStatePropertyType[]{WIDGET}));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-valuenow",
                new AriaStateProperty("aria-valuenow",
                        new EAriaStatePropertyType[]{WIDGET}));

        RGAA4_ARIA_STATE_PROPERTY_STORE.put("aria-valuetext",
                new AriaStateProperty("aria-valuetext",
                        new EAriaStatePropertyType[]{WIDGET}));
    }
}
