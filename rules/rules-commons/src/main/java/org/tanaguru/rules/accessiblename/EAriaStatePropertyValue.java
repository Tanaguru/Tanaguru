package org.tanaguru.rules.accessiblename;

import java.util.HashMap;
import java.util.Map;

public enum EAriaStatePropertyValue {
    FALSE("false"),
    TRUE("true"),
    BOTH("both"),
    INLINE("inline"),
    LIST("list"),
    NONE("none"),
    MIXED("mixed"),
    UNDEFINED("undefined"),
    DATE("Date"),
    LOCATION("location"),
    PAGE("page"),
    STEP("step"),
    TIME("time"),
    COPY("copy"),
    EXECUTE("execute"),
    LINK("link"),
    MOVE("move"),
    POPUP("popup"),
    DIALOG("dialog"),
    GRID("grid"),
    LISTBOX("listbox"),
    MENU("menu"),
    TREE("tree"),
    GRAMMAR("grammar"),
    SPELLING("spelling"),
    ASSERTIVE("assertive"),
    OFF("off"),
    POLITE("polite"),
    HORIZONTAL("horizontal"),
    VERTICAL("vertical"),
    ADDITIONS("additions"),
    ALL("all"),
    REMOVALS("removals"),
    TEXT("text"),
    ASCENDING("ascending"),
    DESCENDING("descending"),
    OTHER("other");

    private String value;
    EAriaStatePropertyValue(String value){
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    //Lookup table
    private static final Map<String, EAriaStatePropertyValue> lookup = new HashMap<>();

    static
    {
        for(EAriaStatePropertyValue value : EAriaStatePropertyValue.values())
        {
            lookup.put(value.getValue(), value);
        }
    }

    public static EAriaStatePropertyValue get(String value)
    {
        return lookup.get(value);
    }
}
