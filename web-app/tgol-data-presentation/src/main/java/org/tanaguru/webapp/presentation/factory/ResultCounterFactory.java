package org.tanaguru.webapp.presentation.factory;

import org.tanaguru.webapp.presentation.data.ResultCounter;

public interface ResultCounterFactory {
    ResultCounter getResultCounter();

    ResultCounter getResultCounter(
            Integer passedCount,
            Integer failedCount,
            Integer nmiCount,
            Integer naCount,
            Integer ntCount);
}
