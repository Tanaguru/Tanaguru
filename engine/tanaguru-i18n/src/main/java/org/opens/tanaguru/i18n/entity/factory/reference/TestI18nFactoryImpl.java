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
package org.opens.tanaguru.i18n.entity.factory.reference;

import org.opens.tanaguru.i18n.entity.reference.TestI18n;
import org.opens.tanaguru.i18n.entity.reference.TestI18nImpl;

/**
 * 
 * @author jkowalczyk
 */
public class TestI18nFactoryImpl implements TestI18nFactory {

    public TestI18nFactoryImpl() {
        super();
    }

    @Override
    public TestI18n create() {
        return new TestI18nImpl();
    }

}