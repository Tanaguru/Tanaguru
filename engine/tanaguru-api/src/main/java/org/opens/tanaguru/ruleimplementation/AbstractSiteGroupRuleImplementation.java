/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2011  Open-S Company
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
 * Contact us by mail: open-s AT open-s DOT com
 */
package org.opens.tanaguru.ruleimplementation;

import java.util.List;
import org.opens.tanaguru.entity.audit.ProcessResult;
import org.opens.tanaguru.service.ProcessRemarkService;

/**
 * This class should be overriden by concrete {@link RuleImplementation} classes
 * which implement tests with site scope. It encapsulates common algorithms of
 * {@link RuleImplementation} operations for tests with site scope.
 * 
 * @author jkowalczyk
 */
public abstract class AbstractSiteGroupRuleImplementation extends AbstractGroupRuleImplementation {

    @Override
    protected List<ProcessResult> consolidateSite(
            List<ProcessResult> netResultList,
            ProcessRemarkService processRemarkService) {
        return consolidateSiteImpl(netResultList, processRemarkService);
    }

    /**
     * 
     * @param netResultSet
     * @param processRemarkService
     * @return 
     *      the list of consolidated process results
     */
    protected abstract List<ProcessResult> consolidateSiteImpl(
            List<ProcessResult> netResultSet,
            ProcessRemarkService processRemarkService);

}