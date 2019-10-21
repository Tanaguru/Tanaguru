/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2015  Tanaguru.org
 *
 * This file is part of Tanaguru.
 *
 * Tanaguru is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact us by mail: tanaguru AT tanaguru DOT org
 */
package org.tanaguru.entity.reference;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author jkowalczyk
 */
@Entity
@Table(name = "TEST")
@XmlRootElement
public class TestImpl implements Test, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Test")
    private Long id;

    @Column(name = "Cd_Test")
    private String code;

    @ManyToOne
    @JoinColumn(name = "Id_Criterion")
    private CriterionImpl criterion;

    @ManyToOne
    @JoinColumn(name = "Id_Decision_Level")
    @JsonIgnore
    private DecisionLevelImpl decisionLevel;


    @Column(name = "Label")
    private String label;

    @ManyToOne
    @JoinColumn(name = "Id_Level")
    private LevelImpl level;

    @Column(name = "Eaccess")
    private Integer eAccess;

    @Column(name = "Rank")
    @JsonIgnore
    private int rank;

    @Column(name = "Rule_Design_Url")
    private String ruleDesignUrl;

    @Column(name = "Weight", precision = 2, scale = 1)
    private BigDecimal weight;


    @OneToMany(targetEntity = AccedewebImpl.class , mappedBy = "test", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Accedeweb> accedwebSet;

    @OneToOne
    @JoinColumn(name = "Id_Rule")
    private RuleImpl rule;

    public TestImpl() {
        super();
    }

    public TestImpl(String code, String label) {
        super();
        this.code = code;
        this.label = label;
    }

    @XmlElementRef(type = org.tanaguru.entity.reference.AccedewebImpl.class)
    @Override
    public Collection<Accedeweb> getAccedwebSet() {
        if (this.accedwebSet == null) {
            this.accedwebSet = new HashSet<>();
        }
        return (Collection) accedwebSet;
    }


    @Override
    public void setAccedwebSet(Set<Accedeweb> accedweb) {
        if (this.accedwebSet == null) {
            this.accedwebSet = new HashSet<>();
        }
        for (Accedeweb accWeb : accedweb) {
            this.accedwebSet.add((AccedewebImpl) accWeb);
        }
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    @XmlElementRef(type = org.tanaguru.entity.reference.CriterionImpl.class)
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
    @JsonSubTypes({
            @JsonSubTypes.Type(value = org.tanaguru.entity.reference.CriterionImpl.class, name = "Criterion")})
    public Criterion getCriterion() {
        return this.criterion;
    }

    @Override
    @XmlElementRef(type = org.tanaguru.entity.reference.DecisionLevelImpl.class)
    public DecisionLevel getDecisionLevel() {
        return this.decisionLevel;
    }



    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    @XmlElementRef(type = org.tanaguru.entity.reference.LevelImpl.class)
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
    @JsonSubTypes({
            @JsonSubTypes.Type(value = org.tanaguru.entity.reference.LevelImpl.class, name = "Level")})
    public Level getLevel() {
        return this.level;
    }

    @Override
    public int geteAccess() {
        return eAccess;
    }

    @Override
    public int getRank() {
        return rank;
    }

    @Override
    public String getRuleDesignUrl() {
        return this.ruleDesignUrl;
    }

    @Override
    public BigDecimal getWeight() {
        return this.weight;
    }


    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public void setCriterion(Criterion criterion) {
        this.criterion = (CriterionImpl) criterion;
    }

    @Override
    public void setDecisionLevel(DecisionLevel decisionLevel) {
        this.decisionLevel = (DecisionLevelImpl) decisionLevel;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void setLevel(Level priority) {
        this.level = (LevelImpl) priority;
    }

    @Override
    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public void seteAccess(Integer eAccess) {
        this.eAccess = eAccess;
    }


    @Override
    public void setRuleDesignUrl(String ruleDesignUrl) {
        this.ruleDesignUrl = ruleDesignUrl;
    }

    @Override
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + (this.code != null ? this.code.hashCode() : 0);
        hash = 11 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TestImpl other = (TestImpl) obj;
        if ((this.code == null) ? (other.code != null) : !this.code.equals(other.code)) {
            return false;
        }
        return Objects.equals(this.id, other.id) || (this.id != null && this.id.equals(other.id));
    }

    public void setCriterion(CriterionImpl criterion) {
        this.criterion = criterion;
    }

    public void setDecisionLevel(DecisionLevelImpl decisionLevel) {
        this.decisionLevel = decisionLevel;
    }

    public void setLevel(LevelImpl level) {
        this.level = level;
    }

    @Override
    public Rule getRule() {
        return rule;
    }

    @Override
    public void setRule(Rule rule) {
        this.rule = (RuleImpl) rule;
    }
}
