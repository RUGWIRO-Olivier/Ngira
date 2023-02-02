package com.ngirankugire.InterventionManager.serviceImpl;

import com.ngirankugire.InterventionManager.exceptions.ApiRequestException;
import com.ngirankugire.InterventionManager.models.Donation;
import com.ngirankugire.InterventionManager.models.Intervention;
import com.ngirankugire.InterventionManager.repository.DonationRepo;
import com.ngirankugire.InterventionManager.repository.InterventionRepo;
import com.ngirankugire.InterventionManager.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationServiceImpl implements DonationService {
    @Autowired
    DonationRepo repo;

//    @Value("${componentId}")
//    private String componentId;


    @Override
    public Donation createDonation(Donation donation) {
        return repo.save(donation);
    }

    @Override
    public List<Donation> getDonation() {
        return repo.findAll();
    }

    @Override
    public Donation getDonation(String id) {
        Donation donation = repo.findById(id).orElseThrow(()->new ApiRequestException("Donation with ID "+id+" is not found"));

        donation.getDonorTypeId();
        return donation;
    }

    @Override
    public Donation updateDonation(Donation donation) {
        repo.findById(donation.getDonorTypeId()).orElseThrow(()->new ApiRequestException("Donation doesn't exist"));
        Donation resultDonation = repo.save(donation);
 return resultDonation;
    }

    @Override
    public void deleteDonation(String id) {
        repo.deleteById(id);
    }

}
