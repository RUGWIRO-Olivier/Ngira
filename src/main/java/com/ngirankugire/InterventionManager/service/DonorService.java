package com.ngirankugire.InterventionManager.service;

import com.ngirankugire.InterventionManager.models.Donor;
import com.ngirankugire.InterventionManager.models.Item;

import java.util.List;

public interface DonorService {
    Donor createDonor(Donor donor);
    List<Donor> getDonor();
    Donor getDonor(String id);
    Donor updateDonor(Donor donor);
    void deleteDonor(String id);
}
