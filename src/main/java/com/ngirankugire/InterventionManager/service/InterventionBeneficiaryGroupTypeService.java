package com.ngirankugire.InterventionManager.service;

import com.ngirankugire.InterventionManager.models.InterventionBeneficiaryGroupType;

import java.util.List;

public interface InterventionBeneficiaryGroupTypeService {

    InterventionBeneficiaryGroupType createInterventionBeneficiaryGroupType(InterventionBeneficiaryGroupType interventionBeneficiaryGroupType);
    List<InterventionBeneficiaryGroupType> getInterventionBeneficiaryGroupType();
    InterventionBeneficiaryGroupType getInterventionBeneficiaryGroupType(String id);
    InterventionBeneficiaryGroupType updateInterventionBeneficiaryGroupType(InterventionBeneficiaryGroupType interventionBeneficiaryGroupType);
    void deleteInterventionBeneficiaryGroupType(String id);
}
