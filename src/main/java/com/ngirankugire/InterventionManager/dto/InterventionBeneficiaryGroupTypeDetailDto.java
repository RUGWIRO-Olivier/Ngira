package com.ngirankugire.InterventionManager.dto;

import com.ngirankugire.InterventionManager.models.Intervention;
import com.ngirankugire.InterventionManager.models.InterventionBeneficiaryGroupType;

public class InterventionBeneficiaryGroupTypeDetailDto {
    private InterventionDto intervention;
    private String beneficiaryGroupTypeId;
    private Boolean isGroupIntervention;



    public InterventionBeneficiaryGroupTypeDetailDto(){

    }

    public InterventionBeneficiaryGroupTypeDetailDto(Intervention intervention, String beneficiaryGroupTypeId, Boolean isGroupIntervention) {
        this.intervention = new InterventionDto(intervention);
        this.beneficiaryGroupTypeId = beneficiaryGroupTypeId;
        this.isGroupIntervention = isGroupIntervention;
    }

    public InterventionBeneficiaryGroupTypeDetailDto(InterventionBeneficiaryGroupType interventionBeneficiaryGroupType) {
        this.intervention = new InterventionDto(interventionBeneficiaryGroupType.getIntervention());
        this.beneficiaryGroupTypeId = interventionBeneficiaryGroupType.getBeneficiaryGroupTypeId();
        this.isGroupIntervention = interventionBeneficiaryGroupType.getIsGroupIntervention();
    }
}
