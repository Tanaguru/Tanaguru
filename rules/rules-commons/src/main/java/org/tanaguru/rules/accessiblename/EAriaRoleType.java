package org.tanaguru.rules.accessiblename;

import java.util.HashMap;
import java.util.Map;

public enum EAriaRoleType {
    LIVE_REGION("live region"),
    STANDALONE_UI_WIDGET("standalone ui widget"),
    DOCUMENT_STRUCTURE("document structure"),
    LANDMARK("landmark"),
    ABSTRACT("abstract"),
    COMPOSITE_UI_WIDGET("composite ui widget");

    private String value;
    EAriaRoleType(String value){
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    //Lookup table
    private static final Map<String, EAriaRoleType> lookup = new HashMap<>();

    static
    {
        for(EAriaRoleType type : EAriaRoleType.values())
        {
            lookup.put(type.getValue(), type);
        }
    }
    public static EAriaRoleType get(String type)
    {
        return lookup.get(type);
    }
}
