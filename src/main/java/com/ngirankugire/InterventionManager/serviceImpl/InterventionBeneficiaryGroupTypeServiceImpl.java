package com.ngirankugire.InterventionManager.serviceImpl;

import com.ngirankugire.InterventionManager.exceptions.ApiRequestException;
import com.ngirankugire.InterventionManager.models.Donor;
import com.ngirankugire.InterventionManager.models.InterventionBeneficiaryGroupType;
import com.ngirankugire.InterventionManager.repository.DonorRepo;
import com.ngirankugire.InterventionManager.repository.InterventionBeneficiaryGroupTypeRepo;
import com.ngirankugire.InterventionManager.service.InterventionBeneficiaryGroupTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterventionBeneficiaryGroupTypeServiceImpl implements InterventionBeneficiaryGroupTypeService {

    @Autowired
    InterventionBeneficiaryGroupTypeRepo repo;


    @Override
    public InterventionBeneficiaryGroupType createInterventionBeneficiaryGroupType(InterventionBeneficiaryGroupType interventionBeneficiaryGroupType) {
        return repo.save(interventionBeneficiaryGroupType);
    }

    @Override
    public List<InterventionBeneficiaryGroupType> getInterventionBeneficiaryGroupType() {
        return repo.findAll();
    }

    @Override
    public InterventionBeneficiaryGroupType getInterventionBeneficiaryGroupType(String id) {
        InterventionBeneficiaryGroupType interventionBeneficiaryGroupType = repo.findById(id).orElseThrow(()->new ApiRequestException("Donor with ID "+id+" is not found"));

        interventionBeneficiaryGroupType.getId();
        return interventionBeneficiaryGroupType;
    }

    @Override
    public InterventionBeneficiaryGroupType updateInterventionBeneficiaryGroupType(InterventionBeneficiaryGroupType interventionBeneficiaryGroupType) {
        repo.findById(interventionBeneficiaryGroupType.getId()).orElseThrow(()->new ApiRequestException("Donor doesn't exist"));
        InterventionBeneficiaryGroupType result = repo.save(interventionBeneficiaryGroupType);
        return result;
    }

    @Override
    public void deleteInterventionBeneficiaryGroupType(String id) {
        repo.deleteById(id);
    }
}
