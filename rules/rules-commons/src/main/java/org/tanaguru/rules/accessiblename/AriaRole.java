package org.tanaguru.rules.accessiblename;

public class AriaRole {
    private String name;
    private EAriaRoleType[] types;
    private AriaStateProperty[] supportedStatesProperties;
    private AriaStateProperty[] requiredStatesProperties;
    private boolean supportNameFromContents;
    private boolean supportNameFromAuthors;

    public AriaRole(String name,
                    EAriaRoleType[] types,
                    AriaStateProperty[] supportedStatesProperties,
                    AriaStateProperty[] requiredStatesProperties,
                    boolean supportNameFromContents,
                    boolean supportNameFromAuthors) {
        this.name = name;
        this.types = types;
        this.supportedStatesProperties = supportedStatesProperties;
        this.requiredStatesProperties = requiredStatesProperties;
        this.supportNameFromContents = supportNameFromContents;
        this.supportNameFromAuthors = supportNameFromAuthors;
    }

    public AriaRole(String name,
                    EAriaRoleType[] types,
                    AriaStateProperty[] supportedStatesProperties) {
        this.name = name;
        this.types = types;
        this.supportedStatesProperties = supportedStatesProperties;
        this.requiredStatesProperties = new AriaStateProperty[]{};
        this.supportNameFromContents = false;
        this.supportNameFromAuthors = false;
    }

    public AriaRole(String name,
                    EAriaRoleType[] types) {
        this.name = name;
        this.types = types;
        this.supportedStatesProperties = new AriaStateProperty[]{};
        this.requiredStatesProperties = new AriaStateProperty[]{};
        this.supportNameFromContents = false;
        this.supportNameFromAuthors = false;
    }

    public AriaRole(String name,
                    EAriaRoleType[] types, boolean supportNameFromContents) {
        this.name = name;
        this.types = types;
        this.supportedStatesProperties = new AriaStateProperty[]{};
        this.requiredStatesProperties = new AriaStateProperty[]{};
        this.supportNameFromContents = supportNameFromContents;
        this.supportNameFromAuthors = false;
    }

    public String getName() {
        return name;
    }

    public EAriaRoleType[] getTypes() {
        return types;
    }

    public AriaStateProperty[] getSupportedStatesProperties() {
        return supportedStatesProperties;
    }

    public AriaStateProperty[] getRequiredStatesProperties() {
        return requiredStatesProperties;
    }

    public boolean isSupportNameFromContents() {
        return supportNameFromContents;
    }

    public boolean isSupportNameFromAuthors() {
        return supportNameFromAuthors;
    }
}
