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
package org.opens.tanaguru.entity.service.reference;

import java.util.HashMap;
import java.util.Map;
import org.opens.tanaguru.entity.dao.reference.ReferenceDAO;
import org.opens.tanaguru.entity.reference.Reference;
import org.opens.tanaguru.sdk.entity.service.AbstractGenericDataService;

/**
 * 
 * @author jkowalczyk
 */
public class ReferenceDataServiceImpl extends AbstractGenericDataService<Reference, Long> implements
        ReferenceDataService {

    private Map<String, Reference> referenceMap = new HashMap<String,Reference>();
    
    public ReferenceDataServiceImpl() {
        super();
    }

    @Override
    public Reference read(Long key) {
        Reference entity = super.read(key);
        return entity;
    }

    @Override
    public Reference getByCode(String code) {
        if (referenceMap.containsKey(code)) {
            return referenceMap.get(code);
        }
        Reference reference = ((ReferenceDAO)entityDao).retrieveByCode(code);
        referenceMap.put(code, reference);
        return reference;
    }

}