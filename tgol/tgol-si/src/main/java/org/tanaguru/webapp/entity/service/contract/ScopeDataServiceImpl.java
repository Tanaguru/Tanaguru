/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2015 Tanaguru.org
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
package org.tanaguru.webapp.entity.service.contract;

import org.tanaguru.sdk.entity.service.AbstractGenericDataService;
import org.tanaguru.webapp.entity.contract.Scope;
import org.tanaguru.webapp.entity.contract.ScopeEnum;
import org.tanaguru.webapp.entity.dao.contract.ScopeDAO;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jkowalczyk
 */
public class ScopeDataServiceImpl extends AbstractGenericDataService<Scope, Long>
        implements ScopeDataService {

    private Map<ScopeEnum, Scope> scopeMap = new HashMap<ScopeEnum,Scope>();

    @Override
    public Scope getByCode(ScopeEnum code) {
        if (scopeMap.containsKey(code)) {
            return scopeMap.get(code);
        }
        Scope scope = ((ScopeDAO)entityDao).retrieveByCode(code);
        scopeMap.put(code, scope);
        return scope;
    }
}
