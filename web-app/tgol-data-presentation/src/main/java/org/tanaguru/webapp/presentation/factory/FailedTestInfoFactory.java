package org.tanaguru.webapp.presentation.factory;

import org.tanaguru.webapp.presentation.data.FailedTestInfo;

public interface FailedTestInfoFactory {
    FailedTestInfo getFailedTestInfo();

    FailedTestInfo getFailedTestInfo(String testCode, String testLabel, Long pageCounter, String testLevelCode);
}
