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

/**
 * This class handles displayable data that represent statistics of tests whose
 * result is failed
 * 
 * @author jkowalczyk
 */
public class FailedTestInfoImpl implements FailedTestInfo{

    /**
     * Default constructor
     */
    public FailedTestInfoImpl(){}

    /**
     * Constructor
     * @param testLabel
     * @param pageCounter
     */
    public FailedTestInfoImpl(String testCode, String testLabel, Long pageCounter) {
        this.testCode = testCode;
        this.testLabel = testLabel;
        this.pageCounter = pageCounter;
    }

    private String testLabel;

    /**
     *
     * @return
     *          the label of the test
     */
    @Override
    public String getTestLabel() {
        return testLabel;
    }

    /**
     *
     * @param testLabel
     */
    @Override
    public void setTestLabel(String testLabel) {
        this.testLabel = testLabel;
    }

    private String testCode;

    /**
     *
     * @return
     *          the code of the test
     */
    @Override
    public String getTestCode() {
        return testCode;
    }

    /**
     *
     * @param testCode
     */
    @Override
    public void setTestCode(String testCode) {
        this.testCode = testCode;
    }

    private Long pageCounter;

    /**
     *
     * @return
     *          the number of pages whose the given test is failed
     */
    @Override
    public Long getPageCounter() {
        return pageCounter;
    }

    /**
     *
     * @param pageCounter
     */
    @Override
    public void setPageCounter(Long pageCounter) {
        this.pageCounter = pageCounter;
    }

}