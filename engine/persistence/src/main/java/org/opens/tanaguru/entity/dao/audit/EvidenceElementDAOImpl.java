/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2013  Open-S Company
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

import java.util.Collection;
import javax.persistence.Query;
import org.opens.tanaguru.entity.audit.Evidence;
import org.opens.tanaguru.entity.audit.EvidenceElement;
import org.opens.tanaguru.entity.audit.EvidenceElementImpl;
import org.opens.tanaguru.entity.audit.ProcessRemark;
import org.opens.tanaguru.sdk.entity.dao.jpa.AbstractJPADAO;

/**
 * 
 * @author jkowalczyk
 */
public class EvidenceElementDAOImpl extends AbstractJPADAO<EvidenceElement, Long> implements
        EvidenceElementDAO {

    public EvidenceElementDAOImpl() {
        super();
    }

    @Override
    protected Class<EvidenceElementImpl> getEntityClass() {
        return EvidenceElementImpl.class;
    }

    @Override
    public Collection<EvidenceElement> retrieveAll(
            Evidence Evidence, String EvidenceValue) {
        Query query = entityManager.createQuery("SELECT r FROM "
                + getEntityClass().getName()
                + " r WHERE r.value = :EvidenceValue AND r.evidence = :Evidence");
        query.setParameter("EvidenceValue", EvidenceValue);
        query.setParameter("Evidence", Evidence);
        return query.getResultList();
    }

    @Override
    public Collection<EvidenceElement> retrieveAllByProcessRemark(
            ProcessRemark processRemark) {
        Query query = entityManager.createQuery("SELECT r FROM "
                + getEntityClass().getName()
                + " r WHERE r.processRemark = :processRemark"
                + " ORDER BY r.id ASC");
        query.setParameter("processRemark", processRemark);
        return query.getResultList();
    }

}
