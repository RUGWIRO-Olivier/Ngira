package com.ngirankugire.InterventionManager.dto;

import com.ngirankugire.InterventionManager.models.Donation;
import com.ngirankugire.InterventionManager.models.DonationItem;
import com.ngirankugire.InterventionManager.models.Item;

public class DonationItemDetailDto {
    private String id;
    private ItemDto item;
    private DonationDto donation;
    private Float quantity;

    public DonationItemDetailDto(String id, Item item, Donation donation, Float quantity) {
        this.id = id;
        this.item = new ItemDto(item);
        this.donation = new DonationDto(donation);
        this.quantity = quantity;
    }

    public DonationItemDetailDto(DonationItem donationItem) {
        this.id = donationItem.getId();
        this.item = new ItemDto(donationItem.getItem());
        this.donation = new DonationDto(donationItem.getDonation());
        this.quantity = donationItem.getQuantity();
    }

    public DonationItemDetailDto() {
    }
}
