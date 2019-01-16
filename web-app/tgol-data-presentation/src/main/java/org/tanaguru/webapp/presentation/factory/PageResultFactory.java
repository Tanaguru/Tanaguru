package org.tanaguru.webapp.presentation.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.tanaguru.entity.reference.Scope;
import org.tanaguru.entity.service.audit.ProcessResultDataService;
import org.tanaguru.webapp.presentation.data.PageResult;

public interface PageResultFactory {
    Scope getScope();

    void setScope(Scope scope);

    PageResult getPageResult(
            String url,
            Integer rank,
            Float weightedMark,
            Float rawMark,
            Long webResourceId,
            String httpStatusCode);
}
