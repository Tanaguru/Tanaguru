package org.tanaguru.webapp.presentation.factory;

import org.tanaguru.webapp.presentation.data.FailedThemeInfo;

public interface FailedThemeInfoFactory {
    FailedThemeInfo getFailedThemeInfo();

    FailedThemeInfo getFailedThemeInfo(Long themeId, Long resultCounter);
}
