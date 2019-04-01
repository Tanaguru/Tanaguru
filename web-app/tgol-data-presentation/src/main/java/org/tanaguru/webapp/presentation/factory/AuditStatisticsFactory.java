package org.tanaguru.webapp.presentation.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.tanaguru.entity.reference.Theme;
import org.tanaguru.entity.service.audit.AuditDataService;
import org.tanaguru.entity.service.parameterization.ParameterDataService;
import org.tanaguru.entity.service.reference.ThemeDataService;
import org.tanaguru.entity.service.statistics.CriterionStatisticsDataService;
import org.tanaguru.entity.service.subject.WebResourceDataService;
import org.tanaguru.entity.subject.WebResource;
import org.tanaguru.webapp.entity.service.contract.ActDataService;
import org.tanaguru.webapp.entity.service.statistics.StatisticsDataService;
import org.tanaguru.webapp.presentation.data.AuditStatistics;

import java.util.Map;

public interface AuditStatisticsFactory {

    AuditStatistics getAuditStatistics(
            WebResource webResource,
            Map<String, String> parametersToDisplay,
            String displayScope,
            boolean isAuditManual);

    Theme getTheme(Long id);

    public void setActDataService(ActDataService actDataService);
    public void setWebResourceDataService(WebResourceDataService webResourceDataService);
    public void setAuditDataService(AuditDataService auditDataService);
    public void setParameterDataService(ParameterDataService parameterDataService);
    public void setCriterionStatisticsDataService(CriterionStatisticsDataService criterionStatisticsDataService);

    @Autowired
    public void setStatisticsDataService(StatisticsDataService statisticsDataService);
    public void setThemeDataService(ThemeDataService themeDataService);
}
