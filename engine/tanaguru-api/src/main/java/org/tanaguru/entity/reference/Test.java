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


import org.tanaguru.sdk.entity.Entity;
import org.tanaguru.sdk.entity.Reorderable;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Set;


/**
 * 
 * @author jkowalczyk
 */
public interface Test extends Entity, Reorderable {


    /**
     *
     * @return the code
     */
    String getCode();

    /**
     *
     * @return the criterion
     */
    Criterion getCriterion();

    /**
     *
     * @return the decision level
     */
    DecisionLevel getDecisionLevel();

    /**
     *
     * @return the label
     */
    String getLabel();



    /**
     *
     * @return the level
     */
    Level getLevel();

    /**
     *
     * @return the rule design url
     */
    String getRuleDesignUrl();



    /**
     *
     * @return the set of Accedeweb notice
     */
    Collection<Accedeweb> getAccedwebSet();



    void setAccedwebSet(Set<Accedeweb> accedweb);

    /**
     *
     * @param code
     *            the code to set
     */
    void setCode(String code);

    /**
     *
     * @param criterion
     *            the criterion to set
     */

    void setCriterion(Criterion criterion);

    /**
     *
     * @param decisionLevel
     *            the decision level to set
     */
    void setDecisionLevel(DecisionLevel decisionLevel);

    /**
     *
     * @param label
     *            the label to set
     */
    void setLabel(String label);

    /**
     *
     * @param level
     *            the level to set
     */
    void setLevel(Level level);

    /**
     *
     * @return
     */
    BigDecimal getWeight();

    /**
     *
     * @param weight
     */
    void setWeight(BigDecimal weight);



    /**
     *
     * @return eAccess lvl
     */
    int geteAccess();
    /**
     *
     * @param  eAccess
     */
    void seteAccess(Integer eAccess);

    /**
     *
     * @param ruleDesignUrl
     */
    void setRuleDesignUrl(String ruleDesignUrl);

    void setRule(Rule rule);

    Rule getRule();


}
