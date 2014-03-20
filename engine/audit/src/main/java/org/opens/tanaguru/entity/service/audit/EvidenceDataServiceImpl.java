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
package org.opens.tanaguru.entity.service.audit;

import java.util.HashMap;
import java.util.Map;
import org.opens.tanaguru.entity.audit.Evidence;
import org.opens.tanaguru.entity.dao.audit.EvidenceDAO;
import org.opens.tanaguru.sdk.entity.service.AbstractGenericDataService;

/**
 * 
 * @author jkowalczyk
 */
public class EvidenceDataServiceImpl extends AbstractGenericDataService<Evidence, Long> implements
        EvidenceDataService {

    private Map<String, Evidence> evidenceMap = new HashMap<String, Evidence>();

    public EvidenceDataServiceImpl() {
        super();
    }

    @Override
    public Evidence findByCode(String code) {
        if (evidenceMap.containsKey(code)) {
            return evidenceMap.get(code);
        }
        Evidence evidence = ((EvidenceDAO) entityDao).retrieveByCode(code);
        evidenceMap.put(code, evidence);
        return evidence;
    }

}
