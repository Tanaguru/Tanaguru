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
package org.tanaguru.entity.dao.reference;


import org.tanaguru.sdk.entity.dao.jpa.AbstractJPADAO;
import org.tanaguru.entity.reference.Scope;
import org.tanaguru.entity.reference.ScopeImpl;

import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * 
 * @author jkowalczyk
 */
public class ScopeDAOImpl extends AbstractJPADAO<Scope, Long> implements ScopeDAO {

    public ScopeDAOImpl() {
        super();
    }

    @Override
    protected Class<ScopeImpl> getEntityClass() {
        return ScopeImpl.class;
    }

    @Override
    public Scope findByCode(String code) {
        Query query = entityManager.createQuery("SELECT s FROM "
                + getEntityClass().getName() + " s"
                + " WHERE s.code = :code");
        query.setParameter("code", code);
        try {
            return (Scope)query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}