package org.tanaguru.webapp.presentation.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.tanaguru.webapp.action.voter.ActionHandler;
import org.tanaguru.webapp.entity.contract.Contract;
import org.tanaguru.webapp.entity.service.contract.ActDataService;
import org.tanaguru.webapp.entity.service.contract.ContractDataService;
import org.tanaguru.webapp.presentation.data.ContractInfo;

public interface ContractInfoFactory {
    ContractInfo getContractInfo(Contract contract);

    public void setActDataService(ActDataService actDataService);
    public ContractDataService getContractDataService();
    public void setContractDataService(ContractDataService contractDataService);
    public ActionHandler getContractActionHandler();
    public void setContractActionHandler(ActionHandler contractActionHandler);
}
