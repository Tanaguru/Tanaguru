package org.tanaguru.rules.accessiblename;

public class AriaStateProperty {
    private String name;
    private EAriaStatePropertyType[] types;
    private EAriaStatePropertyValue[] values;
    private EAriaStatePropertyValue defaultValue;
    private boolean global;
    private boolean tokenList;
    private boolean deprecated;

    public AriaStateProperty(String name, EAriaStatePropertyType[] types, EAriaStatePropertyValue[] values, EAriaStatePropertyValue defaultValue, boolean global, boolean tokenList, boolean deprecated) {
        this.name = name;
        this.types = types;
        this.values = values;
        this.defaultValue = defaultValue;
        this.global = global;
        this.tokenList = tokenList;
        this.deprecated = deprecated;
    }

    public AriaStateProperty(String name, EAriaStatePropertyType[] types, boolean global) {
        this.name = name;
        this.types = types;
        this.values = new EAriaStatePropertyValue[]{};
        this.defaultValue = null;
        this.global = global;
        this.tokenList = false;
        this.deprecated = false;
    }

    public AriaStateProperty(String name, EAriaStatePropertyType[] types, EAriaStatePropertyValue[] values, EAriaStatePropertyValue defaultValue, boolean global, boolean tokenList) {
        this.name = name;
        this.types = types;
        this.values = values;
        this.defaultValue = defaultValue;
        this.global = global;
        this.tokenList = tokenList;
        this.deprecated = false;
    }

    public AriaStateProperty(String name, EAriaStatePropertyType[] types, EAriaStatePropertyValue[] values, EAriaStatePropertyValue defaultValue) {
        this.name = name;
        this.types = types;
        this.values = values;
        this.defaultValue = defaultValue;
        this.global = false;
        this.tokenList = false;
        this.deprecated = false;
    }

    public AriaStateProperty(String name, EAriaStatePropertyType[] types) {
        this.name = name;
        this.types = types;
        this.values = new EAriaStatePropertyValue[]{};
        this.defaultValue = null;
        this.global = false;
        this.tokenList = false;
        this.deprecated = false;
    }

    public String getName() {
        return name;
    }

    public EAriaStatePropertyType[] getTypes() {
        return types;
    }

    public EAriaStatePropertyValue[] getValues() {
        return values;
    }

    public EAriaStatePropertyValue getDefaultValue() {
        return defaultValue;
    }

    public boolean isGlobal() {
        return global;
    }

    public boolean isTokenList() {
        return tokenList;
    }

    public boolean isDeprecated() {
        return deprecated;
    }
}
