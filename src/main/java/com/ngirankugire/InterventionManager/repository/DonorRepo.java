package com.ngirankugire.InterventionManager.repository;

import com.ngirankugire.InterventionManager.models.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorRepo extends JpaRepository<Donor, String> {
}
