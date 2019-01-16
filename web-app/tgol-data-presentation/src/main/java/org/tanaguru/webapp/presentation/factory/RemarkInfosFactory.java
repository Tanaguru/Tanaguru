package org.tanaguru.webapp.presentation.factory;

import org.tanaguru.webapp.presentation.data.RemarkInfos;

public interface RemarkInfosFactory {
    RemarkInfos getRemarksInfo();

    RemarkInfos getRemarksInfo(String messageCode);

    RemarkInfos getRemarksInfo(String messageCode, String remarkTarget);
}
