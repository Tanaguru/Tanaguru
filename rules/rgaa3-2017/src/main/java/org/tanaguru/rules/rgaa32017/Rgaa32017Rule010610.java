/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tanaguru.rules.rgaa32017;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.ruleimplementation.AbstractPageRuleWithSelectorAndCheckerImplementation;
import org.tanaguru.rules.elementchecker.element.ElementPresenceChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.ALL_IMG_TAGS_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_IMG_TAGS_MSG;

/**
 *
 * @author tanaguru
 */
public class Rgaa32017Rule010610 extends AbstractPageRuleWithSelectorAndCheckerImplementation {

    /**
     * Default constructor
     */
    public Rgaa32017Rule010610 () {
       super(new SimpleElementSelector(ALL_IMG_TAGS_CSS_LIKE_QUERY),
                new ElementPresenceChecker(
                new ImmutablePair(TestSolution.NEED_MORE_INFO,CHECK_IMG_TAGS_MSG),
                new ImmutablePair(TestSolution.NOT_APPLICABLE, "")
                ));
    }

}

