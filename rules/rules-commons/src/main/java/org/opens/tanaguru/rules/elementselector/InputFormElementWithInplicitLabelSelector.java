/*
 *  Tanaguru - Automated webpage assessment
 *  Copyright (C) 2008-2013  Open-S Company
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
 *  Contact us by mail: open-s AT open-s DOT com
 */

package org.opens.tanaguru.rules.elementselector;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.opens.tanaguru.processor.SSPHandler;
import org.opens.tanaguru.ruleimplementation.ElementHandler;
import static org.opens.tanaguru.rules.keystore.CssLikeQueryStore.FORM_ELEMENT_CSS_LIKE_QUERY;
import static org.opens.tanaguru.rules.keystore.HtmlElementStore.LABEL_ELEMENT;

/**
 * Element selector implementation that retrieves input form elements that
 * have a label element as child.
 */
public class InputFormElementWithInplicitLabelSelector implements ElementSelector{

    /** the pre-selected input form elements */
    private ElementHandler formElementHandler;
    
    /**
     * Default constructor
     */
    public InputFormElementWithInplicitLabelSelector() {}
    
    /**
     * Constructor
     * @param formElementHandler 
     */
    public InputFormElementWithInplicitLabelSelector(ElementHandler formElementHandler) {
        this.formElementHandler = formElementHandler;
    }

    @Override
    public void selectElements(SSPHandler sspHandler, ElementHandler selectionHandler) {
        for (Element el : getElements(sspHandler)) {
            if (StringUtils.equalsIgnoreCase(el.parent().nodeName(), LABEL_ELEMENT)) {
                selectionHandler.add(el);
            }
        }
    }

    /**
     * 
     * @param sspHandler
     * @return the elements implied by the test
     */
    private Elements getElements (SSPHandler sspHandler) {
        if (formElementHandler != null) {
            return (Elements)formElementHandler.get();
        } else {
            return sspHandler.beginCssLikeSelection().
                domCssLikeSelectNodeSet(FORM_ELEMENT_CSS_LIKE_QUERY).
                getSelectedElements();
        }
    }

}