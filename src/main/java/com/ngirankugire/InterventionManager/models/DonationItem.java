package com.ngirankugire.InterventionManager.models;

import com.ngirankugire.InterventionManager.dto.DonationItemDetailDto;
import com.ngirankugire.InterventionManager.dto.DonationItemDto;
import com.ngirankugire.InterventionManager.dto.InterventionDetailDto;
import com.ngirankugire.InterventionManager.dto.InterventionDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class DonationItem extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemId", nullable = false)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "donationId", nullable = false)
    private Donation donation;

    @Column(name = "quantity", length = 10, nullable = false)
    private Float quantity;

    public DonationItem() {
    }

    public DonationItem(String id, Item item, Donation donation, Float quantity) {
        super(id);
        this.item = item;
        this.donation = donation;
        this.quantity = quantity;
    }

    public static final DonationItemDetailDto REFACTORDETAILED(DonationItem donationItem) {
        return new DonationItemDetailDto(donationItem);
    }

    public  static final DonationItemDto REFACTOR(DonationItem donationItem) {
        return new DonationItemDto(donationItem);
    }

    public static final List<DonationItemDto> REFACTOR(List<DonationItem> donationItems) {
        List<DonationItemDto> dto = new ArrayList<>();
        for (DonationItem donationItem : donationItems) {
            dto.add(REFACTOR(donationItem));
        }
        return dto;
    }
}
