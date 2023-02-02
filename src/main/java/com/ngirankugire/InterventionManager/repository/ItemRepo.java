package com.ngirankugire.InterventionManager.repository;

import com.ngirankugire.InterventionManager.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, String> {
}
