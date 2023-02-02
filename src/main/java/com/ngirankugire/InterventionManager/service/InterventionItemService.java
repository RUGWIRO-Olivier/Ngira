package com.ngirankugire.InterventionManager.service;

import com.ngirankugire.InterventionManager.models.Intervention;
import com.ngirankugire.InterventionManager.models.InterventionItem;

import java.util.List;

public interface InterventionItemService {
    InterventionItem createInterventionItem(InterventionItem interventionItem);
    List<InterventionItem> getInterventionItems();
    InterventionItem getInterventionItem(String id);
    InterventionItem updateInterventionItem(InterventionItem interventionItem);
    void deleteInterventionItem(String id);
}
