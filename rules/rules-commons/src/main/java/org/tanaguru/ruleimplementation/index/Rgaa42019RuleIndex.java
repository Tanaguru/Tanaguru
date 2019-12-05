package org.tanaguru.ruleimplementation.index;

import org.tanaguru.ruleimplementation.impl.ImageAndRoleImageHasAltAttr;

public enum  Rgaa42019RuleIndex {
    /**
     * This enum is not used anywhere. Its only purpose is to help developers
     * to find multi referential rules.
     *
     * @Author Raphaël Charre
     */

    rgaa42019_1_1_1(ImageAndRoleImageHasAltAttr.class, "RGAA42019 1.1.1");

    private Class ruleClass;
    private String rule;

    Rgaa42019RuleIndex(Class ruleClass, String rule){
        this.ruleClass = ruleClass;
        this.rule = rule;
    }

    public Class getRuleClass() {
        return ruleClass;
    }

    public String getRule() {
        return rule;
    }
}
