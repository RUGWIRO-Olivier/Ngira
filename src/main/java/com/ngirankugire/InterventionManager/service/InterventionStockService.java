package com.ngirankugire.InterventionManager.service;

import com.ngirankugire.InterventionManager.models.Intervention;
import com.ngirankugire.InterventionManager.models.InterventionStock;

import java.util.List;

public interface InterventionStockService {
    InterventionStock createInterventionStock(InterventionStock interventionStock);
    List<InterventionStock> getInterventionStocks();
    InterventionStock getInterventionStock(String id);
    InterventionStock updateInterventionStock(InterventionStock interventionStock);
    void deleteInterventionStock(String id);
}
