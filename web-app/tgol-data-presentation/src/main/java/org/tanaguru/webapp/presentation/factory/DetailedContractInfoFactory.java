package org.tanaguru.webapp.presentation.factory;

import org.tanaguru.webapp.entity.contract.Contract;
import org.tanaguru.webapp.presentation.data.DetailedContractInfo;

public interface DetailedContractInfoFactory extends ContractInfoFactory {
    String getNbMaxActRestrictionCode();

    void setNbMaxActRestrictionCode(String nbMaxActRestrictionCode);

    DetailedContractInfo getDetailedContractInfo(Contract contract);
}
