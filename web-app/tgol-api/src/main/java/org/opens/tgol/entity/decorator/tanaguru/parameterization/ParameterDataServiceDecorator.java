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
package org.opens.tgol.entity.decorator.tanaguru.parameterization;

import java.util.Collection;
import org.opens.tanaguru.entity.parameterization.Parameter;
import org.opens.tanaguru.entity.parameterization.ParameterElement;
import org.opens.tanaguru.entity.service.parameterization.ParameterDataService;
import org.opens.tgol.entity.contract.ScopeEnum;
import org.opens.tgol.entity.option.OptionElement;

/**
 *
 * @author jkowalczyk
 */
public interface ParameterDataServiceDecorator extends ParameterDataService {

    /**
     * 
     * @param idContract
     * @param parameterElement
     * @param scope
     * @return
     */
    String getLastParameterValueFromUser(
            Long idContract,
            ParameterElement parameterElement,
            ScopeEnum scope);

    /**
     * 
     * @param idContract
     * @param parameterElement
     * @param scenarioName
     * @return 
     */
    String getLastParameterValueFromContractAndScenario(
            Long idContract, 
            ParameterElement parameterElement, 
            String scenarioName);
    
    /**
     * 
     * @param optionElementSet
     * @return 
     */
    Collection<Parameter> getParameterSetFromOptionElementSet(Collection<OptionElement> optionElementSet);
}
