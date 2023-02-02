package com.ngirankugire.InterventionManager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ngirankugire.InterventionManager.models.Donation;
import com.ngirankugire.InterventionManager.models.DonationItem;
import com.ngirankugire.InterventionManager.models.Item;
import lombok.Data;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class DonationItemDto {

    private String id;
    private String itemId;
    private String donationId;
    private Float quantity;

    public DonationItemDto(String id, String itemId, String donationId, Float quantity) {
        this.id = id;
        this.itemId = itemId;
        this.donationId = donationId;
        this.quantity = quantity;
    }

    public DonationItemDto(DonationItem donationItem) {
        this.id = donationItem.getId();
        this.itemId = donationItem.getItem().getItemTypeId();
        this.donationId = donationItem.getDonation().getDonorTypeId();
        this.quantity = donationItem.getQuantity();
    }

    public DonationItemDto() {
    }
}
