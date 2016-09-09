package org.tanaguru.kafka.util;

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
 * @author omokeddem at oceaneconsulting
 *
 */
public class ParameterUtils {

    /**
     * Class logger definition
     */
    private static final Logger LOGGER = Logger.getLogger(ParameterUtils.class);

    public static Map<String, List<Parameter>> parametersMap = null;

    private static final String PAGE_AUDIT = "Page";
    private static final String SCENARIO_AUDIT = "Scenario";
    private static final String FILE_AUDIT = "File";
    private static final String SITE_AUDIT = "File";

    private static final String AW22_REF = "Aw22";
    private static final String RGAA22_REF = "Rgaa22";
    private static final String RGAA30_REF = "Rgaa30";
    private static final String RGAA32016_REF = "Rgaa32016";
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
                if (screenWidth != null){
                    if(SCREEN_WIDTH.equals(parameter.getParameterElement().getParameterElementCode())){
                        parameter.setValue(screenWidth);
                    }
                }
                if (screenHeight != null){
                    if(SCREEN_HEIGHT.equals(parameter.getParameterElement().getParameterElementCode())){
                        parameter.setValue(screenHeight);
                    }
                }

            }
        }
    }

}
