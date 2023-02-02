package com.ngirankugire.InterventionManager.serviceImpl;

import com.ngirankugire.InterventionManager.exceptions.ApiRequestException;
import com.ngirankugire.InterventionManager.models.Intervention;
import com.ngirankugire.InterventionManager.repository.InterventionRepo;
import com.ngirankugire.InterventionManager.service.InterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterventionServiceImpl implements InterventionService {
    @Autowired
    InterventionRepo repo;

//    @Value("${componentId}")
//    private String componentId;


    @Override
    public Intervention createIntervention(Intervention intervention) {
        return repo.save(intervention);
    }

    @Override
    public List<Intervention> getIntervention() {
        return repo.findAll();
    }

    @Override
    public Intervention getIntervention(String id) {
        Intervention intervention = repo.findById(id).orElseThrow(()->new ApiRequestException("Intervention with ID "+id+" is not found"));

        intervention.getInterventionTypeId();
        return intervention;
    }

    @Override
    public Intervention updateIntervention(Intervention intervention) {
        repo.findById(intervention.getInterventionTypeId()).orElseThrow(()->new ApiRequestException("Intervention doesn't exist"));
        Intervention resultTariff = repo.save(intervention);
//        resultTariff.setTariffItem(TariffItem.REFACTOR(tariffItemService.getTariffItemByTariffId(tariff.getId())));
        return resultTariff;
    }

    @Override
    public void deleteIntervention(String id) {
        repo.deleteById(id);
    }
}
