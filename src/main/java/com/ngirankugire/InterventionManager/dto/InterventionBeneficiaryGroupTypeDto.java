package com.ngirankugire.InterventionManager.dto;

import com.ngirankugire.InterventionManager.models.Donation;
import com.ngirankugire.InterventionManager.models.Donor;
import com.ngirankugire.InterventionManager.models.Intervention;
import com.ngirankugire.InterventionManager.models.InterventionBeneficiaryGroupType;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

public class InterventionBeneficiaryGroupTypeDto {
    private String id;
    private String interventionId;
    private String beneficiaryGroupTypeId;
    private Boolean isGroupIntervention;



    public InterventionBeneficiaryGroupTypeDto(){

    }

    public InterventionBeneficiaryGroupTypeDto(String id, String interventionId, String beneficiaryGroupTypeId, Boolean isGroupIntervention, Donor donor) {
        this.id=id;
        this.interventionId = interventionId;
        this.beneficiaryGroupTypeId = beneficiaryGroupTypeId;
        this.isGroupIntervention = isGroupIntervention;
    }

    public InterventionBeneficiaryGroupTypeDto(InterventionBeneficiaryGroupType interventionBeneficiaryGroupType) {
        this.id=interventionBeneficiaryGroupType.getId();
        this.interventionId = interventionBeneficiaryGroupType.getIntervention().getId();
        this.beneficiaryGroupTypeId = interventionBeneficiaryGroupType.getBeneficiaryGroupTypeId();
        this.isGroupIntervention = interventionBeneficiaryGroupType.getIsGroupIntervention();
    }


}
