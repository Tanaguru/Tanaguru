/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2015  Tanaguru.org
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
package org.tanaguru.jms.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.tanaguru.entity.parameterization.Parameter;
import org.tanaguru.entity.service.parameterization.ParameterDataService;
import org.tanaguru.entity.parameterization.ParameterElement;
import org.tanaguru.entity.service.parameterization.ParameterElementDataService;

/**
 *
 * @author mkebri
 */
public class ParameterUtilsAudit {

    /**
     * Class logger definition
     */
    private static final Logger LOGGER = Logger.getLogger(ParameterUtilsAudit.class);

    public static Map<String, List<Parameter>> parametersMap = null;

    private static final String PAGE_AUDIT = "Page";
    private static final String SCENARIO_AUDIT = "Scenario";
    private static final String FILE_AUDIT = "File";
    private static final String SITE_AUDIT = "File";

    private static final String AW22_REF = "Aw22";
    private static final String RGAA22_REF = "Rgaa22";
    private static final String RGAA30_REF = "Rgaa30";
    private static final String RGAA32016_REF = "Rgaa32016";
    private static final String RGAA32017_REF = "Rgaa32017";
    private static String REF = AW22_REF;

    private static final String BRONZE_LEVEL = "Bz";
    private static final String A_LEVEL = "A";
    private static final String SILVER_LEVEL = "Ar";
    private static final String AA_LEVEL = "AA";
    private static final String GOLD_LEVEL = "Or";
    private static final String AAA_LEVEL = "AAA";

    private static final String LEVEL_1 = "LEVEL_1";
    private static final String LEVEL_2 = "LEVEL_2";
    private static final String LEVEL_3 = "LEVEL_3";

    private static final int DEFAULT_XMS_VALUE = 64;

    private static String LEVEL = SILVER_LEVEL;

    private static final String LEVEL_PARAMETER_ELEMENT_CODE = "LEVEL";

    private static String AUDIT_TYPE = PAGE_AUDIT;

    /*
     * **********************TANGURU SERVICE PARAMETERS
     */
    public static final String DATA_TABLE_MARKER = "DATA_TABLE_MARKER";
    public static final String COMPLEX_TABLE_MARKER = "COMPLEX_TABLE_MARKER";
    public static final String PROXY_HOST = "PROXY_HOST";
    public static final String CONSIDER_COOKIES = "CONSIDER_COOKIES";
    public static final String ALTERNATIVE_CONTRAST_MECHANISM = "ALTERNATIVE_CONTRAST_MECHANISM";
    public static final String INFORMATIVE_IMAGE_MARKER = "INFORMATIVE_IMAGE_MARKER";
    public static final String PROXY_PORT = "PROXY_PORT";
    public static final String DECORATIVE_IMAGE_MARKER = "DECORATIVE_IMAGE_MARKER";
    public static final String MAX_DOCUMENTS = "MAX_DOCUMENTS";
    public static final String MAX_DURATION = "MAX_DURATION";
    public static final String EXCLUSION_REGEXP = "EXCLUSION_REGEXP";
    public static final String DEPTH = "DEPTH";
    public static final String PRESENTATION_TABLE_MARKER = "PRESENTATION_TABLE_MARKER";
    public static final String SCREEN_WIDTH = "SCREEN_WIDTH";
    public static final String SCREEN_HEIGHT = "SCREEN_HEIGHT";

    /*
     * **********************OTHER SERVICE PARAMETERS
     */
    public static final String AUDIT_LEVEL = "level";
    public static final String PAGE_URL = "pageUrl";
    public static final String PAGE_URLS = "pageUrls";
    public static final String SCENARIO_NAME = "scenarioName";
    public static final String SCENARIO = "scenario";
    public static final String DATA_TABLE_MARKER_PARAM = "tblMarker";
    public static final String PRESENTATION_TABLE_MARKER_PARAM = "prTblMarker";
    public static final String DECORATIVE_IMAGE_MARKER_PARAM = "dcrImgMarker";
    public static final String INFORMATIVE_IMAGE_MARKER_PARAM = "infImgMarker";

    /**
     *
     * @param auditLevel
     * @return
     */
    public static Set<Parameter> getParameterSetFromAuditLevel(String ref, String level, ParameterElementDataService parameterElementDataService,
            ParameterDataService parameterDataService) {
        if (ref.equalsIgnoreCase(RGAA22_REF) || ref.equalsIgnoreCase(RGAA30_REF)) {
            if (level.equalsIgnoreCase(BRONZE_LEVEL)) {
                level = A_LEVEL;
            } else if (level.equalsIgnoreCase(SILVER_LEVEL)) {
                level = AA_LEVEL;
            } else if (level.equalsIgnoreCase(GOLD_LEVEL)) {
                level = AAA_LEVEL;
            }
        }
        if (level.equalsIgnoreCase(BRONZE_LEVEL) || level.equalsIgnoreCase(A_LEVEL)) {
            level = LEVEL_1;
        } else if (level.equalsIgnoreCase(SILVER_LEVEL) || level.equalsIgnoreCase(AA_LEVEL)) {
            level = LEVEL_2;
        } else if (level.equalsIgnoreCase(GOLD_LEVEL) || level.equalsIgnoreCase(AAA_LEVEL)) {
            level = LEVEL_3;
        }
        ParameterElement levelParameterElement = parameterElementDataService.getParameterElement(LEVEL_PARAMETER_ELEMENT_CODE);
        Parameter levelParameter = parameterDataService.getParameter(levelParameterElement, ref + ";" + level);
        Set<Parameter> paramSet = parameterDataService.getDefaultParameterSet();
        return parameterDataService.updateParameter(paramSet, levelParameter);
    }

    /**
     * The default parameter set embeds a depth value that corresponds to the
     * site audit. We need here to replace this parameter by a parameter value
     * equals to 0.
     *
     * @param defaultParameterSet
     * @param parameterElementDataService
     * @param parameterDataService
     * @return
     */
    public static Set<Parameter> getAuditPageParameterSet(Set<Parameter> defaultParameterSet, ParameterElementDataService parameterElementDataService,
            ParameterDataService parameterDataService) {
        ParameterElement parameterElement = parameterElementDataService.getParameterElement("DEPTH");
        Parameter depthParameter = parameterDataService.getParameter(parameterElement, "0");
        Set<Parameter> auditPageParamSet = parameterDataService.updateParameter(
                defaultParameterSet, depthParameter);
        return auditPageParamSet;
    }

    public static void initializePAInputOptions(String tblMarker, String cplxTblMarker, String prTblMarker, String dcrImgMarker, String infImgMarker,
            String screenWidth, String screenHeight, Set<Parameter> parameters) {

        for (Parameter parameter : parameters) {

            if (parameter != null && parameter.getParameterElement() != null && parameter.getParameterElement().getParameterElementCode() != null) {

                if (tblMarker != null) {
                    if (DATA_TABLE_MARKER.equals(parameter.getParameterElement().getParameterElementCode())) {
                        parameter.setValue(tblMarker);
                    }
                }
                if (cplxTblMarker != null) {
                    if (COMPLEX_TABLE_MARKER.equals(parameter.getParameterElement().getParameterElementCode())) {
                        parameter.setValue(cplxTblMarker);
                    }
                }
                if (prTblMarker != null) {
                    if (PRESENTATION_TABLE_MARKER.equals(parameter.getParameterElement().getParameterElementCode())) {
                        parameter.setValue(prTblMarker);
                    }
                }
                if (dcrImgMarker != null) {
                    if (DECORATIVE_IMAGE_MARKER.equals(parameter.getParameterElement().getParameterElementCode())) {
                        parameter.setValue(dcrImgMarker);
                    }
                }
                if (infImgMarker != null) {
                    if (INFORMATIVE_IMAGE_MARKER.equals(parameter.getParameterElement().getParameterElementCode())) {
                        parameter.setValue(infImgMarker);
                    }
                }
                if (screenWidth != null) {
                    if (SCREEN_WIDTH.equals(parameter.getParameterElement().getParameterElementCode())) {
                        parameter.setValue(screenWidth);
                    }
                }
                if (screenHeight != null) {
                    if (SCREEN_HEIGHT.equals(parameter.getParameterElement().getParameterElementCode())) {
                        parameter.setValue(screenHeight);
                    }
                }

            }
        }
    }
}
