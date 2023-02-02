package com.ngirankugire.InterventionManager.service;

import com.ngirankugire.InterventionManager.models.Donation;
import com.ngirankugire.InterventionManager.models.Intervention;
import com.ngirankugire.InterventionManager.models.Item;

import java.util.List;

public interface DonationService {
    Donation createDonation(Donation donation);
    List<Donation> getDonation();
    Donation getDonation(String id);
    Donation updateDonation(Donation donation);
    void deleteDonation(String id);
}
