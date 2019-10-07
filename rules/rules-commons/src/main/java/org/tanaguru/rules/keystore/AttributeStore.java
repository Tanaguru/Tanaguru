/*
 *  Tanaguru - Automated webpage assessment
 *  Copyright (C) 2008-2015  Tanaguru.org
 * 
 *  This file is part of Tanaguru.
 * 
 *  Tanaguru is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 * 
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 *  Contact us by mail: tanaguru AT tanaguru DOT org
 */
package org.tanaguru.rules.keystore;

import javax.swing.text.html.HTML;

/**
 * Utility class that stores html attributes as static String
 */
public final class AttributeStore {

    /**
     * Returned key when an attribute requested as evidence element is missing
     */
    public static final String ABSENT_ATTRIBUTE_VALUE = "attribute-absent";

    public static final String ALT_ATTR = HTML.Attribute.ALT.toString();
    public static final String CLASS_ATTR = HTML.Attribute.CLASS.toString();
    public static final String CODE_ATTR = HTML.Attribute.CODE.toString();
    public static final String CONTENT_ATTR = HTML.Attribute.CONTENT.toString();
    public static final String DATA_ATTR = HTML.Attribute.DATA.toString();
    public static final String DISABLED_ATTR = "disabled";
    public static final String FOR_ATTR = "for";
    public static final String HREF_ATTR = HTML.Attribute.HREF.toString();
    public static final String HEADERS_ATTR = "headers";
    public static final String ID_ATTR = HTML.Attribute.ID.toString();
    public static final String LABEL_ATTR = "label";
    public static final String LANG_ATTR = HTML.Attribute.LANG.toString();
    public static final String LONGDESC_ATTR = "longdesc";
    public static final String NAME_ATTR = HTML.Attribute.NAME.toString();
    public static final String ONKEYPRESS_ATTR = "onkeypress";
    public static final String ROLE_ATTR = "role";
    public static final String KIND_ATTR = "kind";
    public static final String DIR_ATTR = "dir";
    public static final String SRC_ATTR = HTML.Attribute.SRC.toString();
    public static final String SCOPE_ATTR = "scope";
    public static final String SUMMARY_ATTR = "summary";
    public static final String TABINDEX_ATTR = "tabindex";
    public static final String TARGET_ATTR = HTML.Attribute.TARGET.toString();
    public static final String TITLE_ATTR = HTML.Attribute.TITLE.toString();
    public static final String ARIA_LABEL_ATTR = "aria-label";
    public static final String ARIA_LABELLEDBY_ATTR = "aria-labelledby";
    public static final String ARIA_DESCRIBEDBY_ATTR = "aria-describedby";
    public static final String ARIA_HIDDEN_ATTR = "aria-hidden";
    public static final String ARIA_LEVEL_ATTR = "aria-level";
    public static final String USEMAP_ATTR = HTML.Attribute.USEMAP.toString();
    public static final String VALUE_ATTR = HTML.Attribute.VALUE.toString();
    public static final String WIDTH_ATTR = HTML.Attribute.WIDTH.toString();
    public static final String HEIGHT_ATTR = HTML.Attribute.HEIGHT.toString();
    public static final String XML_LANG_ATTR = "xml:lang";
    public static final String XMLNS_ATTR = "xmlns";

    /* Value linked to an attribute */
    public static final String PRESENTATION_VALUE = "presentation";
    public static final String KIND_VALUE = "captions";
    public static final String DIR_LTR_VALUE = "ltr";
    public static final String DIR_RTL_VALUE = "rtl";
    
    public static final String ROLE_ATTR_VALUE_MAIN = "main";
    public static final String ROLE_ATTR_VALUE_BANNER = "banner";
    public static final String ROLE_ATTR_VALUE_NAVIGATION = "navigation";
    public static final String ROLE_ATTR_VALUE_CONTENTINFO = "contentinfo";
    public static final String ROLE_ATTR_VALUE_SEARCH = "search";
    public static final String TYPE_ATTR = HTML.Attribute.TYPE.toString(); 
    public static final String PLACEHOLDER_ATTR = "placeholder"; 

    /**
     * Private constructor. This class handles keys and must not be instantiated
     */
    private AttributeStore() {
    }

}
