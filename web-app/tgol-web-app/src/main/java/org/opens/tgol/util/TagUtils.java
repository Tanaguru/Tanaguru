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
package org.opens.tgol.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import javax.servlet.jsp.PageContext;

/**
 *
 * @author jkowalczyk
 */
public final class TagUtils {

    /**
     * Private constructor.  This class only handles static methods
     */
    private TagUtils(){}

    //Checks to see if Object 'o' is an instance of the class in the string
    public static boolean instanceOf(Object o, String className) {
        boolean returnValue;
        try {
            returnValue = Class.forName(className).isInstance(o);
        } catch (ClassNotFoundException e) {
            returnValue = false;
        }
        return returnValue;
    }
    
    /**
     * 
     * @param pageContext
     * @return 
     */
    public static String getLangFromPageContext(PageContext pageContext) {
        if (pageContext.getResponse().getLocale().getLanguage().
                equalsIgnoreCase(Locale.FRENCH.getLanguage())) {
            return Locale.FRENCH.getLanguage();
        }
        return Locale.ENGLISH.getLanguage();
    }
    
    /**
     * 
     * @param pageContext
     * @return 
     */
    public static String getHostFromUrl(String url)  {
        try {
            return new URL(url).getHost();
        } catch (MalformedURLException ex) {
            return url;
        }
    }
    
}