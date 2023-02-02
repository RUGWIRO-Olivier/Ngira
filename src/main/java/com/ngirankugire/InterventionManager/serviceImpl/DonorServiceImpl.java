package com.ngirankugire.InterventionManager.serviceImpl;

import com.ngirankugire.InterventionManager.exceptions.ApiRequestException;
import com.ngirankugire.InterventionManager.models.Donor;
import com.ngirankugire.InterventionManager.models.Item;
import com.ngirankugire.InterventionManager.repository.DonorRepo;
import com.ngirankugire.InterventionManager.repository.ItemRepo;
import com.ngirankugire.InterventionManager.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorServiceImpl implements DonorService {

    @Autowired
    DonorRepo repo;

//    @Value("${componentId}")
//    private String componentId;


    @Override
    public Donor createDonor(Donor donor) {
        return repo.save(donor);
    }

    @Override
    public List<Donor> getDonor() {
        return repo.findAll();
    }

    @Override
    public Donor getDonor(String id) {
        Donor donor = repo.findById(id).orElseThrow(()->new ApiRequestException("Donor with ID "+id+" is not found"));

        donor.getDonorTypeId();
        return donor;
    }

    @Override
    public Donor updateDonor(Donor donor) {
        repo.findById(donor.getDonorTypeId()).orElseThrow(()->new ApiRequestException("Donor doesn't exist"));
        Donor resultDonor = repo.save(donor);
 return resultDonor;
    }

    @Override
    public void deleteDonor(String id) {
        repo.deleteById(id);
    }
}
