package com.ngirankugire.InterventionManager.service;

import com.ngirankugire.InterventionManager.models.Intervention;

import java.util.List;

public interface InterventionService {
    Intervention createIntervention(Intervention intervention);
    List<Intervention> getIntervention();
    Intervention getIntervention(String id);
    Intervention updateIntervention(Intervention intervention);
    void deleteIntervention(String id);
}
