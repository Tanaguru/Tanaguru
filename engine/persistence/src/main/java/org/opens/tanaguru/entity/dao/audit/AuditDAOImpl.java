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
package org.opens.tanaguru.entity.dao.audit;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.opens.tanaguru.entity.audit.Audit;
import org.opens.tanaguru.entity.audit.AuditImpl;
import org.opens.tanaguru.entity.audit.AuditStatus;
import org.opens.tanaguru.sdk.entity.dao.jpa.AbstractJPADAO;

/**
 * 
 * @author jkowalczyk
 */
public class AuditDAOImpl extends AbstractJPADAO<Audit, Long> implements
        AuditDAO {

    public AuditDAOImpl() {
        super();
    }

    @Override
    public List<Audit> findAll() {
        List<Audit> auditList = super.findAll();
        return auditList;
    }

    @Override
    public List<Audit> findAll(AuditStatus status) {
        Query query = entityManager.createQuery("SELECT o FROM "
                + getEntityClass().getName() + " o"
                + " LEFT JOIN FETCH o.subject"
                + " WHERE o.status = :status");
        query.setParameter("status", status);
        return (List<Audit>)query.getResultList();
    }

    @Override
    protected Class<AuditImpl> getEntityClass() {
        return AuditImpl.class;
    }

    @Override
    public Audit findAuditWithTest(Long id) {
        Query query = entityManager.createQuery("SELECT a FROM "
                + getEntityClass().getName() + " a"
                + " LEFT JOIN FETCH a.testSet"
                + " WHERE a.id = :id");
        query.setParameter("id", id);
        try {
            return (Audit)query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

}