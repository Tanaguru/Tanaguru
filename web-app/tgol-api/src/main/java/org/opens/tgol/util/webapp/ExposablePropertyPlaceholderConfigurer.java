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
package org.opens.tgol.util.webapp;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * Bean that should be used instead of the {@link PropertyPlaceholderConfigurer} if you want to have
 * access to the resolved properties not obly from the Spring context. e.g. from JSP or so. 
 *
 * @author Mykola Palienko
 */
public class ExposablePropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    private Map<String, String> resolvedProps;
    private static final Logger LOGGER = Logger.getLogger(ConfigPropertiesExposerListener.class);

    public ExposablePropertyPlaceholderConfigurer(){
        super();
    }

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess,
            Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        resolvedProps = new HashMap<String, String>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            resolvedProps.put(keyStr, parseStringValue(props.getProperty(keyStr), props,
                    new HashSet()));
        }
    }

    public Map<String, String> getResolvedProps() {
        return Collections.unmodifiableMap(resolvedProps);
    }

}