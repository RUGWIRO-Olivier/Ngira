package com.ngirankugire.InterventionManager.repository;

import com.ngirankugire.InterventionManager.models.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterventionRepo extends JpaRepository<Intervention, String> {
}
