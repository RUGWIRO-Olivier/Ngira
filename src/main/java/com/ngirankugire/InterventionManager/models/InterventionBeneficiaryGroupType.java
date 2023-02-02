package com.ngirankugire.InterventionManager.models;

import com.ngirankugire.InterventionManager.dto.DonationDetailDto;
import com.ngirankugire.InterventionManager.dto.DonationDto;
import com.ngirankugire.InterventionManager.dto.InterventionBeneficiaryGroupTypeDetailDto;
import com.ngirankugire.InterventionManager.dto.InterventionBeneficiaryGroupTypeDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class InterventionBeneficiaryGroupType extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interventionId", nullable = false)
    private Intervention intervention;

    @Column(name = "beneficiaryGroupTypeId", length = 120, nullable = false)
    private String beneficiaryGroupTypeId;

    @Column(name = "isGroupIntervention", length = 3, nullable = false)
    private Boolean isGroupIntervention;

    public InterventionBeneficiaryGroupType(){

    }

    public InterventionBeneficiaryGroupType(String id, Intervention intervention, String beneficiaryGroupTypeId, Boolean isGroupIntervention) {
        super(id);
        this.intervention = intervention;
        this.beneficiaryGroupTypeId = beneficiaryGroupTypeId;
        this.isGroupIntervention = isGroupIntervention;
    }

    public static final InterventionBeneficiaryGroupTypeDetailDto REFACTORDETAILED(InterventionBeneficiaryGroupType interventionBeneficiaryGroupType) {
        return new InterventionBeneficiaryGroupTypeDetailDto(interventionBeneficiaryGroupType);
    }

    public  static final InterventionBeneficiaryGroupTypeDto REFACTOR(InterventionBeneficiaryGroupType interventionBeneficiaryGroupType) {
        return new InterventionBeneficiaryGroupTypeDto(interventionBeneficiaryGroupType);
    }

    public static final List<InterventionBeneficiaryGroupTypeDto> REFACTOR(List<InterventionBeneficiaryGroupType> interventionBeneficiaryGroupTypes) {
        List<InterventionBeneficiaryGroupTypeDto> dto = new ArrayList<>();
        for (InterventionBeneficiaryGroupType interventionBeneficiaryGroupType : interventionBeneficiaryGroupTypes) {
            dto.add(REFACTOR(interventionBeneficiaryGroupType));
        }
        return dto;
    }
}
