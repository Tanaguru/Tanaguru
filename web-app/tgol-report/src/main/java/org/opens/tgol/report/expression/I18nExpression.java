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
package org.opens.tgol.report.expression;

import ar.com.fdvs.dj.domain.CustomExpression;
import java.util.*;
import org.apache.commons.lang.StringEscapeUtils;
import org.opens.tgol.report.expression.retriever.KeyRetriever;

/**
 *
 * @author jkowalczyk
 */
public class I18nExpression implements CustomExpression {

    private static final long serialVersionUID = 1174999656431046383L;

    private List<ResourceBundle> resourceBundleList = new ArrayList<ResourceBundle>();
    private KeyRetriever keyRetriever = null;
    private boolean escapeHtml = false;
    
    /**
     * Default constructor
     */
    public I18nExpression(
            List<String> bundleNameList,
            KeyRetriever keyRetriever,
            boolean escapeHtml,
            Locale locale) {
        if (bundleNameList != null) {
            for (String bundleName : bundleNameList) {
                resourceBundleList.add(ResourceBundle.getBundle(bundleName, locale));
            }
        }
        this.keyRetriever = keyRetriever;
        this.escapeHtml = escapeHtml;
    }

    @Override
    public Object evaluate(Map fields, Map variables, Map parameters) {
        String key = keyRetriever.retrieveKey(fields, variables, parameters);
        if (!resourceBundleList.isEmpty()) {
            String i18nValue = retrieveI18nValue(key);
            if (escapeHtml) {
                return StringEscapeUtils.escapeHtml(i18nValue);
            }
            return StringEscapeUtils.unescapeHtml(i18nValue);
        }
        return key;
    }

    @Override
    public String getClassName() {
        return String.class.getName();
    }

    /**
     * Retrieve a i18n among the Collection of resourceBundle associated with
     * the instance
     * 
     * @param key
     * @return 
     */
    private String retrieveI18nValue(String key) {
        for (ResourceBundle rb: resourceBundleList) {
            if (rb.containsKey(key)) {
                return rb.getString(key);
            }
        }
        return key;
    }
}