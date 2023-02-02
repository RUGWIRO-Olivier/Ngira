package com.ngirankugire.InterventionManager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ngirankugire.InterventionManager.models.Donation;
import com.ngirankugire.InterventionManager.models.Donor;
import com.ngirankugire.InterventionManager.models.Intervention;
import lombok.Data;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class DonationDto {
    private String id;
    private String donorTypeId;
    private String message;
    private String donorId;
    private String interventionId;

    public DonationDto(String id, String donorTypeId, String message, String donorId, String interventionId) {
        this.id = id;
        this.donorTypeId = donorTypeId;
        this.message = message;
        this.donorId = donorId;
        this.interventionId = interventionId;
    }

    public DonationDto(Donation donation) {
        this.id = donation.getId();
        this.donorTypeId = donation.getDonorTypeId();
        this.message = donation.getMessage();
        this.donorId = donation.getDonor().getDonorTypeId();
        this.interventionId = donation.getIntervention().getInterventionTypeId();
    }

    public DonationDto() {
    }
}
