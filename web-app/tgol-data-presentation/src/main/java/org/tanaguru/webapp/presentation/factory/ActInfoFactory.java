package org.tanaguru.webapp.presentation.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.tanaguru.entity.service.audit.ContentDataService;
import org.tanaguru.webapp.entity.contract.Act;
import org.tanaguru.webapp.entity.decorator.tanaguru.parameterization.ParameterDataServiceDecorator;
import org.tanaguru.webapp.entity.service.statistics.StatisticsDataService;
import org.tanaguru.webapp.presentation.data.ActInfo;

import java.util.Collection;

public interface ActInfoFactory {
    ActInfo getActInfo(Act act);

    Collection<ActInfo> getActInfoSet(Collection<Act> actSet);
}
