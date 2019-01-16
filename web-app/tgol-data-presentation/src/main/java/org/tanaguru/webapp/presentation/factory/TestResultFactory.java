package org.tanaguru.webapp.presentation.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.entity.reference.Criterion;
import org.tanaguru.entity.reference.Scope;
import org.tanaguru.entity.reference.Test;
import org.tanaguru.entity.reference.Theme;
import org.tanaguru.entity.service.audit.AuditDataService;
import org.tanaguru.entity.service.audit.ProcessRemarkDataService;
import org.tanaguru.entity.service.audit.ProcessResultDataService;
import org.tanaguru.entity.service.reference.TestDataService;
import org.tanaguru.entity.subject.WebResource;
import org.tanaguru.webapp.presentation.data.ManualResult;
import org.tanaguru.webapp.presentation.data.TestResult;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public interface TestResultFactory {
    String getSelectAllThemeKey();

    void setSelectAllThemeKey(String selectAllThemeKey);

    TestResult getTestResult();

    TestResult getTestResult(
            ProcessResult processResult,
            boolean hasResultDetails,
            boolean truncatable);

    Map<Theme, List<TestResult>> getTestResultSortedByThemeMap(
            WebResource webresource,
            Scope scope,
            String theme,
            Collection<String> testSolutionList);

    List<TestResult> getTestResultList(
            WebResource webresource,
            Scope scope,
            Locale locale);

    // TO DO : determine the difference between this method and the next one
    // The code seems to be a duplication
    List<ProcessResult> getProcessResultListFromTestsResult(Map<String, ManualResult> overriddenResultMap, WebResource webResource);

    List<ProcessResult> getAllProcessResultListFromTestsResult(
            Map<String, ManualResult> overriddenResultMap,
            WebResource webResource);

    Map<String, TestResult> getTestResultMap(
            WebResource webresource,
            Scope scope,
            String theme,
            Collection<String> testSolutionList);

    Map<Theme, List<TestResult>> getTestResultListFromCriterion(
            WebResource webresource,
            Criterion crit);

    Map<Theme, List<TestResult>> getTestResultListFromTest(
            WebResource webresource,
            Test test);
}
