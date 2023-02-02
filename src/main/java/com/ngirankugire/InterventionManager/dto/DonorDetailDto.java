package com.ngirankugire.InterventionManager.dto;

import com.ngirankugire.InterventionManager.models.Donor;

public class DonorDetailDto {
    private String donorTypeId;
    private String name;


    public DonorDetailDto(String donorTypeId, String name) {
        this.donorTypeId = donorTypeId;
        this.name = name;
    }

    public DonorDetailDto(Donor donor) {
        this.donorTypeId = donor.getDonorTypeId();
        this.name = donor.getName();
    }

    public DonorDetailDto() {

    }
}
