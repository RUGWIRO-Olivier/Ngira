package com.ngirankugire.InterventionManager.service;

import com.ngirankugire.InterventionManager.models.DonationItem;
import com.ngirankugire.InterventionManager.models.Intervention;

import java.util.List;

public interface DonationItemService {
    DonationItem createDonationItem(DonationItem donationItem);
    List<DonationItem> getDonationItem();
    DonationItem getDonationItem(String id);
    DonationItem updateDonationItem(DonationItem donationItem);
    void deleteDonationItem(String id);
}
