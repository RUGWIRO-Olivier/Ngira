package com.ngirankugire.InterventionManager.repository;

import com.ngirankugire.InterventionManager.models.InterventionItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterventionItemRepo extends JpaRepository<InterventionItem, String> {
}
