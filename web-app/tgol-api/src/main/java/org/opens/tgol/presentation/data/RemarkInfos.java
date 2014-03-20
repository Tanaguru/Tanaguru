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
package org.opens.tgol.presentation.data;

import java.util.List;
import java.util.Map;

/**
 * This interface handles displayable remarks data
 * @author jkowalczyk
 */
public interface RemarkInfos {

    /**
     *
     * @return
     */
    String getMessageCode();

    /**
     *
     * @param messageCode
     */
    void setMessageCode(String messageCode);

    /**
     *
     * @return
     */
    String getRemarkTarget();

    /**
     *
     * @param remarkTarget
     */
    void setRemarkTarget(String remarkTarget);

    /**
     *
     * @return
     */
    String getRemarkResult();

    /**
     *
     * @param remarkResult
     */
    void setRemarkResult(String remarkResult);

    /**
     *
     * @return
     */
    List<Map<String, String>> getEvidenceElementList();

    /**
     *
     * @param evidenceElementList
     */
    void setEvidenceElementList(List<Map<String, String>> evidenceElementList);

    /**
     *
     * @param evidenceElement
     */
    void addEvidenceElement(Map<String, String> evidenceElement);

}