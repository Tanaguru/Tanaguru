package org.tanaguru.rules.keystore.rgaa4;

import org.tanaguru.rules.accessiblename.AriaRole;
import org.tanaguru.rules.accessiblename.AriaStateProperty;
import org.tanaguru.rules.accessiblename.EAriaRoleType;

import java.util.HashMap;
import java.util.Map;

import static org.tanaguru.rules.accessiblename.EAriaRoleType.*;

public class Rgaa4AriaRoleStore {
    private static Map<String, AriaRole> RGAA4_ARIA_ROLE_STORE = new HashMap<>();

    public static AriaRole get(String aria_role){
        return RGAA4_ARIA_ROLE_STORE.get(aria_role);
    }

    static{
        RGAA4_ARIA_ROLE_STORE.put("alert",
                new AriaRole("alert",
                        new EAriaRoleType[]{LIVE_REGION, STANDALONE_UI_WIDGET}));

        RGAA4_ARIA_ROLE_STORE.put("alertdialog",
                new AriaRole("alertdialog",
                        new EAriaRoleType[]{STANDALONE_UI_WIDGET}));

        RGAA4_ARIA_ROLE_STORE.put("application",
                new AriaRole("application",
                        new EAriaRoleType[]{DOCUMENT_STRUCTURE}));

        RGAA4_ARIA_ROLE_STORE.put("article",
                new AriaRole("article",
                        new EAriaRoleType[]{DOCUMENT_STRUCTURE}));

        RGAA4_ARIA_ROLE_STORE.put("banner",
                new AriaRole("banner",
                        new EAriaRoleType[]{LANDMARK}));

        RGAA4_ARIA_ROLE_STORE.put("button",
                new AriaRole("button",
                        new EAriaRoleType[]{STANDALONE_UI_WIDGET},
                        new AriaStateProperty[]{
                                Rgaa4AriaStatePropertyStore.get("aria-expanded"),
                                Rgaa4AriaStatePropertyStore.get("aria-pressed")
                        }));

        RGAA4_ARIA_ROLE_STORE.put("cell",
                new AriaRole("cell",
                        new EAriaRoleType[]{DOCUMENT_STRUCTURE},
                        true));

        RGAA4_ARIA_ROLE_STORE.put("checkbox",
                new AriaRole("checkbox",
                        new EAriaRoleType[]{STANDALONE_UI_WIDGET},
                        true));

        RGAA4_ARIA_ROLE_STORE.put("columnheader",
                new AriaRole("columnheader",
                        new EAriaRoleType[]{DOCUMENT_STRUCTURE},
                        true));

        RGAA4_ARIA_ROLE_STORE.put("combobox",
                new AriaRole("combobox",
                        new EAriaRoleType[]{COMPOSITE_UI_WIDGET}));

        RGAA4_ARIA_ROLE_STORE.put("command",
                new AriaRole("command",
                        new EAriaRoleType[]{ABSTRACT}));

        RGAA4_ARIA_ROLE_STORE.put("complementary",
                new AriaRole("complementary",
                        new EAriaRoleType[]{LANDMARK}));

        RGAA4_ARIA_ROLE_STORE.put("composite",
                new AriaRole("composite",
                        new EAriaRoleType[]{ABSTRACT}));

        RGAA4_ARIA_ROLE_STORE.put("definition",
                new AriaRole("definition",
                        new EAriaRoleType[]{DOCUMENT_STRUCTURE}));

        RGAA4_ARIA_ROLE_STORE.put("dialog",
                new AriaRole("dialog",
                        new EAriaRoleType[]{STANDALONE_UI_WIDGET}));

        RGAA4_ARIA_ROLE_STORE.put("directory",
                new AriaRole("directory",
                        new EAriaRoleType[]{DOCUMENT_STRUCTURE}));

        RGAA4_ARIA_ROLE_STORE.put("document",
                new AriaRole("document",
                        new EAriaRoleType[]{DOCUMENT_STRUCTURE}));

        RGAA4_ARIA_ROLE_STORE.put("feed",
                new AriaRole("feed",
                        new EAriaRoleType[]{DOCUMENT_STRUCTURE}));

        RGAA4_ARIA_ROLE_STORE.put("figure",
                new AriaRole("figure",
                        new EAriaRoleType[]{DOCUMENT_STRUCTURE}));

        RGAA4_ARIA_ROLE_STORE.put("form",
                new AriaRole("form",
                        new EAriaRoleType[]{LANDMARK}));

        RGAA4_ARIA_ROLE_STORE.put("grid",
                new AriaRole("grid",
                        new EAriaRoleType[]{COMPOSITE_UI_WIDGET}));

        RGAA4_ARIA_ROLE_STORE.put("gridcell",
                new AriaRole("gridcell",
                        new EAriaRoleType[]{STANDALONE_UI_WIDGET},
                        true));

        RGAA4_ARIA_ROLE_STORE.put("group",
                new AriaRole("group",
                        new EAriaRoleType[]{DOCUMENT_STRUCTURE}));


    }



}
