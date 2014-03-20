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

import org.opens.tanaguru.entity.reference.NomenclatureElement;
import org.opens.tanaguru.entity.reference.NomenclatureElementImpl;
import org.opens.tanaguru.sdk.entity.dao.jpa.AbstractJPADAO;
import java.util.Collection;
import javax.persistence.Query;
import org.opens.tanaguru.entity.reference.Nomenclature;

/**
 * 
 * @author jkowalczyk
 */
public class NomenclatureElementDAOImpl extends AbstractJPADAO<NomenclatureElement, Long>
        implements NomenclatureElementDAO {

    public NomenclatureElementDAOImpl() {
        super();
    }

    @Override
    protected Class<NomenclatureElementImpl> getEntityClass() {
        return NomenclatureElementImpl.class;
    }

    @Override
    public Collection<NomenclatureElement> retrieveAll(
            Nomenclature nomenclature, String nomenclatureValue) {
        Query query = entityManager.createQuery("SELECT r FROM "
                + getEntityClass().getName()
                + " r WHERE r.nomenclatureValue = :nomenclatureValue AND r.nomenclature = :nomenclature");
        query.setParameter("nomenclatureValue", nomenclatureValue);
        query.setParameter("nomenclature", nomenclature);
        return query.getResultList();
    }

}