package com.ngirankugire.InterventionManager.models;

import com.ngirankugire.InterventionManager.dto.DonationDetailDto;
import com.ngirankugire.InterventionManager.dto.DonationDto;
import com.ngirankugire.InterventionManager.dto.InterventionDetailDto;
import com.ngirankugire.InterventionManager.dto.InterventionDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Donation extends BaseEntity{
    @Column(name = "donorTypeId", length = 120, nullable = false)
    private String donorTypeId;

    @Column(name = "message", length = 60, nullable = false)
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "donorId", nullable = false)
    private Donor donor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interventionId", nullable = false)
    private Intervention intervention;
    public Donation() {

    }


    public Donation(String id, String donorTypeId, String message, Donor donor, Intervention intervention) {
        super(id);
        this.donorTypeId = donorTypeId;
        this.message = message;
        this.donor = donor;
        this.intervention = intervention;
    }



    public static final DonationDetailDto REFACTORDETAILED(Donation donation) {
        return new DonationDetailDto(donation);
    }

    public  static final DonationDto REFACTOR(Donation donation) {
        return new DonationDto(donation);
    }

    public static final List<DonationDto> REFACTOR(List<Donation> donations) {
        List<DonationDto> dto = new ArrayList<>();
        for (Donation donation : donations) {
            dto.add(REFACTOR(donation));
        }
        return dto;
    }
}
