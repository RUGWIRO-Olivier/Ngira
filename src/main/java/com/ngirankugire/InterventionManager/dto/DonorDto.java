package com.ngirankugire.InterventionManager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ngirankugire.InterventionManager.models.Donation;
import com.ngirankugire.InterventionManager.models.DonationItem;
import com.ngirankugire.InterventionManager.models.Donor;
import com.ngirankugire.InterventionManager.models.Item;
import lombok.Data;

import javax.persistence.Column;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class DonorDto {
    private String id;
    private String donorTypeId;
    private String name;
    public DonorDto() {

    }

    public DonorDto(String id, String donorTypeId, String name) {
        this.id = id;
        this.donorTypeId = donorTypeId;
        this.name = name;
    }

    public DonorDto(Donor donor) {
        this.id = donor.getId();
        this.donorTypeId = donor.getDonorTypeId();
        this.name = donor.getName();
    }


}
