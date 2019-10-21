package org.tanaguru.entity.reference;

import org.tanaguru.sdk.entity.Entity;

public interface Rule extends Entity {

    /**
     *
     * @return
     */
    String getRuleArchiveName();

    /**
     *
     * @return
     */
    String getRuleClassName();

    /**
     *
     * @return the scope
     */
    Scope getScope();

    /**
     *
     * @return the description
     */
    String getDescription();

    /**
     *
     * @param description
     *            the description to set
     */
    void setDescription(String description);

    /**
     *
     * @param ruleArchiveName
     */
    void setRuleArchiveName(String ruleArchiveName);

    /**
     *
     * @param ruleClassName
     */
    void setRuleClassName(String ruleClassName);

    /**
     *
     * @param scope
     *            the scrope to set
     */
    void setScope(Scope scope);

    /**
     *
     * @return whether the test handle a process
     */
    boolean getNoProcess();

    /**
     *
     * @param noProcess
     */
    void setNoProcess(boolean noProcess);
}
