package com.ngirankugire.InterventionManager.dto;

import com.ngirankugire.InterventionManager.models.Donation;
import com.ngirankugire.InterventionManager.models.Donor;
import com.ngirankugire.InterventionManager.models.Intervention;

public class DonationDetailDto {

    private String donorTypeId;
    private String message;
    private DonorDto donor;
    private InterventionDto intervention;

    public DonationDetailDto(String donorTypeId, String message, Donor donor, Intervention intervention) {
        this.donorTypeId = donorTypeId;
        this.message = message;
        this.donor = new DonorDto(donor);
        this.intervention = new InterventionDto(intervention);
    }

    public DonationDetailDto(Donation donation) {
        this.donorTypeId = donation.getDonorTypeId();
        this.message = donation.getMessage();
        this.donor = new DonorDto(donation.getDonor());
        this.intervention = new InterventionDto(donation.getIntervention());
    }

    public DonationDetailDto() {
    }
}
