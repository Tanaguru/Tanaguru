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
package org.tanaguru.rules.textbuilder;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;

import static org.tanaguru.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.tanaguru.rules.keystore.AttributeStore.ID_ATTR;

/**
 * This implementation of the {@link TextualElementBuilder} extracts the text
 * content of a given attribute of an element. The attribute type is settable by
 * contructor argument
 */
public class TextAttributeOfElementBuilder implements TextElementBuilder {

    /* the attribute name*/
    private Collection<String> attributeNames = new HashSet<String>();
    public final void setAttributeName(String attributeName) {
        this.attributeNames.add(attributeName);
    }
    
    /**
     * Constructor
     */
    public TextAttributeOfElementBuilder() {
        super();
    }
    
    /**
     * Constructor
     * @param attributeName 
     */
    public TextAttributeOfElementBuilder(String attributeName) {
        attributeNames.add(attributeName);
    }
    
    /**
     * Constructor
     * @param attributeNames
     */
    public TextAttributeOfElementBuilder(String... attributeNames) {
        this.attributeNames.addAll(Arrays.asList(attributeNames));
    }

    /**
     * 
     * @param element
     * @return the content of the attribute when it exits, null instead.
     */
    @Override
    public String buildTextFromElement(Element element) {
        if (CollectionUtils.isEmpty(attributeNames)) {
            return null;
        }
        boolean elementHasAttr = false;
        StringBuilder strb = new StringBuilder();
        for (String attributeName : attributeNames) {
            if (element.hasAttr(attributeName)) {
                elementHasAttr = true;
                strb.append(element.attr(attributeName));
                strb.append(SPACER);
            }else if(StringUtils.equalsIgnoreCase(attributeName, TEXT_ELEMENT2)) {
           		 elementHasAttr = true;
                 strb.append(element.text());
                 strb.append(SPACER);
           	}
        }
        if (!elementHasAttr) {
            return null;
        }
        return strb.toString().trim();
    }

}