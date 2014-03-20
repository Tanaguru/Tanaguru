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
package org.opens.tanaguru.service;

import org.opens.tanaguru.entity.reference.Test;
import org.opens.tanaguru.entity.factory.audit.DefiniteResultFactory;
import org.opens.tanaguru.entity.factory.audit.IndefiniteResultFactory;
import org.opens.tanaguru.ruleimplementation.RuleImplementation;
import java.util.Set;
import org.opens.tanaguru.ruleimplementationloader.RuleImplementationLoaderFactory;

/**
 * 
 * @author jkowalczyk
 */
public interface RuleImplementationLoaderService {

    /**
     *
     * @param testSet
     * @return
     */
    Set<RuleImplementation> loadRuleImplementationSet(Set<Test> testSet);

    /**
     *
     * @param definiteResultFactory
     */
    void setDefiniteResultFactory(DefiniteResultFactory definiteResultFactory);

    /**
     *
     * @param indefiniteResultFactory
     */
    void setIndefiniteResultFactory(
            IndefiniteResultFactory indefiniteResultFactory);

    /**
     *
     * @param nomenclatureLoaderService
     */
    void setNomenclatureLoaderService(
            NomenclatureLoaderService nomenclatureLoaderService);

    /**
     *
     * @param test
     * @return
     */
    RuleImplementation loadRuleImplementation(Test test);

    /**
     * 
     * @param archiveRoot
     */
    void setArchiveRoot(String archiveRoot);

    /**
     *
     * @param ruleImplementationLoaderFactory
     */
    void setRuleImplementationLoaderFactory(RuleImplementationLoaderFactory ruleImplementationLoaderFactory);

}