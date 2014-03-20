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
package org.opens.tanaguru.persistence.i18n.reference;

import org.opens.tanaguru.i18n.entity.dao.reference.NomenclatureElementI18nDAO;
import org.opens.tanaguru.entity.reference.NomenclatureElement;
import org.opens.tanaguru.i18n.entity.reference.NomenclatureElementI18nImpl;
import org.opens.tanaguru.persistence.i18n.AbstractJPAI18nDAO;

/**
 * 
 * @author jkowalczyk
 */
public class NomenclatureElementI18nDAOImpl extends AbstractJPAI18nDAO<NomenclatureElement, Long> implements
        NomenclatureElementI18nDAO {

    public NomenclatureElementI18nDAOImpl() {
        super();
    }

    @Override
    protected Class<NomenclatureElementI18nImpl> getEntityClass() {
        return NomenclatureElementI18nImpl.class;
    }

}