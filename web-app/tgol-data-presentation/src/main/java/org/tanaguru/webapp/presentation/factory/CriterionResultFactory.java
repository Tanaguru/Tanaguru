package org.tanaguru.webapp.presentation.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.tanaguru.entity.reference.Theme;
import org.tanaguru.entity.service.reference.CriterionDataService;
import org.tanaguru.entity.service.statistics.CriterionStatisticsDataService;
import org.tanaguru.entity.statistics.CriterionStatistics;
import org.tanaguru.entity.subject.WebResource;
import org.tanaguru.webapp.presentation.data.CriterionResult;
import org.tanaguru.webapp.presentation.data.TestResult;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface CriterionResultFactory {
    TestResult getTestResult();

    CriterionResult getCriterionResult(
            CriterionStatistics criterionStatistics);

    Map<Theme, List<CriterionResult>> getCriterionResultSortedByThemeMap(
            WebResource webresource,
            String theme,
            Collection<String> testSolution);
}
