package com.ngirankugire.InterventionManager.repository;

import com.ngirankugire.InterventionManager.models.Donation;
import com.ngirankugire.InterventionManager.models.DonationItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationItemRepo extends JpaRepository<DonationItem, String> {
}
