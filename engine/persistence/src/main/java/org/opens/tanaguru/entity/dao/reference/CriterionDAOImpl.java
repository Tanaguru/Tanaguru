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

import java.util.Collection;
import javax.persistence.Query;
import org.opens.tanaguru.entity.reference.*;
import org.opens.tanaguru.sdk.entity.dao.jpa.AbstractJPADAO;

/**
 * 
 * @author jkowalczyk
 */
public class CriterionDAOImpl extends AbstractJPADAO<Criterion, Long> implements
        CriterionDAO {

    public CriterionDAOImpl() {
        super();
    }

    @Override
    protected Class<CriterionImpl> getEntityClass() {
        return CriterionImpl.class;
    }
    
    protected Class<TestImpl> getTestEntityClass() {
        return TestImpl.class;
    }

    @Override
    public Collection<Criterion> retrieveAll(String code, Reference reference,
            Theme theme) {
        Query query = entityManager.createQuery("SELECT r FROM "
                + getEntityClass().getName()
                + " r WHERE r.code = :code AND r.reference = :reference AND r.theme = :theme");
        query.setParameter("code", code);
        query.setParameter("reference", reference);
        query.setParameter("theme", theme);
        return query.getResultList();
    }

    @Override
    public Level findCriterionLevel(Criterion criterion) {
        Query query = entityManager.createQuery("SELECT t FROM "
                + getTestEntityClass().getName() + " t "
                + " JOIN t.criterion cr"
                + " WHERE cr = :criterion");
        query.setParameter("criterion", criterion);
        query.setMaxResults(1);
        Test test = (Test)query.getSingleResult();
        return test.getLevel();
    }

}