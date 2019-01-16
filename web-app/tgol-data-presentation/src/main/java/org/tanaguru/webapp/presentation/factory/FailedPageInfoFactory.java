package org.tanaguru.webapp.presentation.factory;

import org.tanaguru.webapp.presentation.data.FailedPageInfo;

public interface FailedPageInfoFactory {
    FailedPageInfo getFailedPageInfo();

    FailedPageInfo getFailedPageInfo(
            String url,
            Long id,
            Long failedTestCounter,
            Long failedOccurrenceCounter);
}
