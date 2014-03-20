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
package org.opens.tgol.form.builder;

import java.util.ArrayList;
import java.util.List;
import org.opens.tgol.form.CheckboxElement;
import org.opens.tgol.form.CheckboxFormField;
import org.opens.tgol.form.CheckboxFormFieldImpl;

/**
 *
 * @author jkowalczyk
 */
public class CheckboxFormFieldBuilderImpl extends FormFieldBuilderImpl
        implements AbstractGenericFormFieldBuilder<CheckboxFormField>, CheckboxFormFieldBuilder {

    public CheckboxFormFieldBuilderImpl() {
        super();
    }

    @Override
    public CheckboxFormField build() {
        CheckboxFormField formField = new CheckboxFormFieldImpl();
        formField.setErrorI18nKey(getErrorI18nKey());
        formField.setI18nKey(getI18nKey());
        formField.setValue(getValue());
        formField.setRestrictionCode(restrictionCode);
        formField.setCode(code);
        formField.setActivationCode(activationCode);
        formField.setCheckboxElementList(getCheckboxElementList());
        return formField;
    }
    
    private List<CheckboxElementBuilder> checkboxElementBuilderList;
    @Override
    public void setCheckboxElementBuilderList(List<CheckboxElementBuilder> checkboxElementBuilderList) {
        this.checkboxElementBuilderList = checkboxElementBuilderList;
    }

    @Override
    public List<CheckboxElement> getCheckboxElementList() {
        List<CheckboxElement> checkboxElementList = new ArrayList<CheckboxElement>();
        for (CheckboxElementBuilder ceb : checkboxElementBuilderList) {
            checkboxElementList.add((CheckboxElement)ceb.build());
        }
        return checkboxElementList;
    }

    private String restrictionCode = null;
    @Override
    public String getRestrictionCode() {
        return restrictionCode;
    }

    @Override
    public void setRestrictionCode(String restrictionCode) {
        this.restrictionCode = restrictionCode;
    }

    private String activationCode = null;
    @Override
    public String getActivationCode() {
        return activationCode;
    }

    @Override
    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    private String code = null;
    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

}