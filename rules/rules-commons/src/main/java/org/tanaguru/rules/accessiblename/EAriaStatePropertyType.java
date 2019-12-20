package org.tanaguru.rules.accessiblename;

import java.util.HashMap;
import java.util.Map;

public enum EAriaStatePropertyType {
    LIVE_REGION("live region"),
    RELATIONSHIP("relationship"),
    WIDGET("WIDGET"),
    DRAG_AND_DROP("drag and drop");

    private String value;
    EAriaStatePropertyType(String value){
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    //Lookup table
    private static final Map<String, EAriaStatePropertyType> lookup = new HashMap<>();

    static
    {
        for(EAriaStatePropertyType type : EAriaStatePropertyType.values())
        {
            lookup.put(type.getValue(), type);
        }
    }
    public static EAriaStatePropertyType get(String type)
    {
        return lookup.get(type);
    }
}
