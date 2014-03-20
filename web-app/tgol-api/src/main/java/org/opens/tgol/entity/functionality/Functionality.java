/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2012  Open-S Company
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
package org.opens.tgol.entity.functionality;

import org.opens.tanaguru.sdk.entity.Entity;

/**
 *
 * @author jkowalczyk
 */
public interface Functionality extends Entity {

    /**
     *
     * @return
     *      the code associated with the functionality
     */
    String getCode();

    /**
     *
     * @param code
     */
    void setCode(String code);
    
    /**
     *
     * @return
     *      the label describing the functionality
     */
    String getLabel();

    /**
     *
     * @param label
     */
    void setLabel(String label);

    /**
     *
     * @return
     *      the description associated with the functionality
     */
    String getDescription();

    /**
     * 
     * @param description
     */
    void setDescription(String description);

}
