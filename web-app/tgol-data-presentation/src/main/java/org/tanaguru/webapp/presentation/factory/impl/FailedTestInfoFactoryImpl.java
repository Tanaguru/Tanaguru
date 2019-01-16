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

import org.tanaguru.webapp.presentation.data.FailedTestInfo;
import org.tanaguru.webapp.presentation.data.FailedTestInfoImpl;
import org.tanaguru.webapp.presentation.factory.FailedTestInfoFactory;

/**
 * 
 * @author jkowalczyk
 */
public final class FailedTestInfoFactoryImpl implements FailedTestInfoFactory {

    /**
     * The unique shared instance of FailedTestInfoFactoryImpl
     */
    private static FailedTestInfoFactory failedTestInfoFactory;

    /**
     * Default private constructor
     */
    private FailedTestInfoFactoryImpl(){}

    public static synchronized FailedTestInfoFactory getInstance(){
        if (failedTestInfoFactory == null) {
            failedTestInfoFactory = new FailedTestInfoFactoryImpl();
        }
        return failedTestInfoFactory;
    }

    /**
     * 
     * @return
     */
    @Override
    public FailedTestInfo getFailedTestInfo(){
        return new FailedTestInfoImpl();
    }

    /**
     * 
     * @param testCode
     * @param testLabel
     * @param pageCounter
     * @param testLevelCode
     * @return
     */
    @Override
    public FailedTestInfo getFailedTestInfo(String testCode, String testLabel, Long pageCounter, String testLevelCode) {
        return new FailedTestInfoImpl(testCode, testLabel, pageCounter, testLevelCode);
    }

}