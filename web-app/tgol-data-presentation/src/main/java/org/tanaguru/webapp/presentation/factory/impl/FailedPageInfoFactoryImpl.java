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
package org.tanaguru.webapp.presentation.factory.impl;

import org.tanaguru.webapp.presentation.data.FailedPageInfo;
import org.tanaguru.webapp.presentation.data.FailedPageInfoImpl;
import org.tanaguru.webapp.presentation.factory.FailedPageInfoFactory;


/**
 * 
 * @author jkowalczyk
 */
public final class FailedPageInfoFactoryImpl implements FailedPageInfoFactory {

    /**
     * The unique shared instance of FailedPageInfoFactoryImpl
     */
    private static FailedPageInfoFactory failedPageInfoFactory;

    /**
     * Default private constructor
     */
    private FailedPageInfoFactoryImpl(){}

    public static synchronized FailedPageInfoFactory getInstance(){
        if (failedPageInfoFactory == null) {
            failedPageInfoFactory = new FailedPageInfoFactoryImpl();
        }
        return failedPageInfoFactory;
    }

    /**
     * 
     * @return
     */
    @Override
    public FailedPageInfo getFailedPageInfo(){
        return new FailedPageInfoImpl();
    }

    /**
     *
     * @param url
     * @param id
     * @param failedTestCounter
     * @param failedOccurrenceCounter
     * @return
     */
    @Override
    public FailedPageInfo getFailedPageInfo(
            String url,
            Long id,
            Long failedTestCounter,
            Long failedOccurrenceCounter) {
        return new FailedPageInfoImpl(url, id, failedTestCounter, failedOccurrenceCounter);
    }
}