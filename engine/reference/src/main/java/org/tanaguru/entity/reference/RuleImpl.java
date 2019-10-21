package org.tanaguru.entity.reference;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RULE")
public class RuleImpl implements Serializable, Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Rule")
    private Long id;

    @Column(name = "Rule_Archive_Name")
    @JsonIgnore
    private String ruleArchiveName;

    @Column(name = "Rule_Class_Name")
    @JsonIgnore
    private String ruleClassName;

    @ManyToOne
    @JoinColumn(name = "SCOPE_Id_Scope")
    private ScopeImpl scope;

    @Column(name = "No_Process")
    @JsonIgnore
    private boolean noProcess;

    @Column(name = "Description")
    @JsonIgnore
    private String description;

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getRuleArchiveName() {
        return ruleArchiveName;
    }

    @Override
    public void setRuleArchiveName(String ruleArchiveName) {
        this.ruleArchiveName = ruleArchiveName;
    }

    @Override
    public String getRuleClassName() {
        return ruleClassName;
    }

    @Override
    public void setRuleClassName(String ruleClassName) {
        this.ruleClassName = ruleClassName;
    }

    @Override
    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = (ScopeImpl) scope;
    }

    public boolean isNoProcess() {
        return noProcess;
    }


    @Override
    public void setNoProcess(boolean noProcess) {
        this.noProcess = noProcess;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean getNoProcess() {
        return this.noProcess;
    }
}