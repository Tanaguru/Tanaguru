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
package org.opens.tanaguru.entity.dao.reference;

import java.util.List;
import java.util.Map;
import org.opens.tanaguru.entity.reference.Criterion;
import org.opens.tanaguru.entity.reference.Level;
import org.opens.tanaguru.entity.reference.Reference;
import org.opens.tanaguru.entity.reference.Test;
import org.opens.tanaguru.sdk.entity.dao.GenericDAO;

/**
 * 
 * @author jkowalczyk
 */
public interface TestDAO extends GenericDAO<Test, Long> {

    /**
     *
     * @param reference
     *            the reference of the tests to find
     * @return the collection of tests found
     */
    List<Test> retrieveAll(Reference reference);

    /**
     * 
     * @param reference
     * @param criterion
     * @return
     */
    List<Test> retrieveAllByReferenceAndCriterion(Reference reference, List<Criterion> criterion);

    /**
     *
     * @param codeArray
     * @return
     */
    List<Test> retrieveAllByCode(String[] codeArray);
    
    /**
     * 
     * @param criterion
     * @return 
     */
    List<Test> retrieveAllByCriterion(Criterion criterion);

    /**
     * 
     * @param reference
     * @param level
     * @return 
     *      the collection of test regarding the reference and the level
     */
    List<Test> retrieveAllByReferenceAndLevel(Reference reference, Level level);

    /**
     * 
     * @param levelDAO
     */
    void setLevelDAO(LevelDAO levelDAO);

    /**
     * 
     * @param bronzeLevelCodeByRefMap This map handles the bronze level code
     *      (first level) for each referential
     */
    void setBronzeLevelCodeByRefMap(Map<String, String> bronzeLevelCodeByRefMap);

}