package com.ngirankugire.InterventionManager.repository;

import com.ngirankugire.InterventionManager.models.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepo extends JpaRepository<Donation, String> {
}
