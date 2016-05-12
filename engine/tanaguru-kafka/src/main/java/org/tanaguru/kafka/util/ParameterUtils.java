package org.tanaguru.kafka.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.tanaguru.entity.parameterization.Parameter;
import org.tanaguru.entity.service.parameterization.ParameterDataService;
import org.apache.commons.lang3.StringUtils;
import org.tanaguru.entity.parameterization.ParameterElement;
import org.tanaguru.entity.service.parameterization.ParameterElementDataService;
import scala.collection.parallel.ParIterableLike;

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

}
