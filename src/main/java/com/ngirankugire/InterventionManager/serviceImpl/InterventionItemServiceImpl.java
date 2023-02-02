package com.ngirankugire.InterventionManager.serviceImpl;

import com.ngirankugire.InterventionManager.exceptions.ApiRequestException;
import com.ngirankugire.InterventionManager.models.Intervention;
import com.ngirankugire.InterventionManager.models.InterventionItem;
import com.ngirankugire.InterventionManager.repository.InterventionItemRepo;
import com.ngirankugire.InterventionManager.service.InterventionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterventionItemServiceImpl implements InterventionItemService {
    @Autowired
    InterventionItemRepo repo;



    @Override
    public InterventionItem createInterventionItem(InterventionItem interventionItem) {
        return repo.save(interventionItem);
    }

    @Override
    public List<InterventionItem> getInterventionItems() {
        return repo.findAll();
    }

    @Override
    public InterventionItem getInterventionItem(String id) {
        InterventionItem interventionItem = repo.findById(id).orElseThrow(()->new ApiRequestException("Intervention Item with ID "+id+" is not found"));

        interventionItem.getId();
        return interventionItem;
    }

    @Override
    public InterventionItem updateInterventionItem(InterventionItem interventionItem) {
        repo.findById(interventionItem.getId()).orElseThrow(()->new ApiRequestException("Intervention Item doesn't exist"));
        InterventionItem result = repo.save(interventionItem);
        return result;
    }

    @Override
    public void deleteInterventionItem(String id) {
        repo.deleteById(id);
    }
}
