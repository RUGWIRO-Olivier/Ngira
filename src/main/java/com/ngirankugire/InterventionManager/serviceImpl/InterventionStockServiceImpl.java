package com.ngirankugire.InterventionManager.serviceImpl;

import com.ngirankugire.InterventionManager.exceptions.ApiRequestException;
import com.ngirankugire.InterventionManager.models.InterventionStock;
import com.ngirankugire.InterventionManager.repository.InterventionStockRepo;
import com.ngirankugire.InterventionManager.service.InterventionStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterventionStockServiceImpl implements InterventionStockService {

    @Autowired
    InterventionStockRepo repo;

    @Override
    public InterventionStock createInterventionStock(InterventionStock interventionStock) {
        return repo.save(interventionStock);
    }

    @Override
    public List<InterventionStock> getInterventionStocks() {
        return repo.findAll();
    }

    @Override
    public InterventionStock getInterventionStock(String id) {
        InterventionStock interventionStock = repo.findById(id).orElseThrow(()->new ApiRequestException("Intervention Stock with ID "+id+" is not found"));

        interventionStock.getId();
        return interventionStock;
    }

    @Override
    public InterventionStock updateInterventionStock(InterventionStock interventionStock) {
        repo.findById(interventionStock.getId()).orElseThrow(()->new ApiRequestException("Intervention Stock doesn't exist"));
        InterventionStock result = repo.save(interventionStock);
        return result;
    }

    @Override
    public void deleteInterventionStock(String id) {
        repo.deleteById(id);
    }
}
