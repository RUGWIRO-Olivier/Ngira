package com.ngirankugire.InterventionManager.serviceImpl;

import com.ngirankugire.InterventionManager.exceptions.ApiRequestException;
import com.ngirankugire.InterventionManager.models.DonationItem;
import com.ngirankugire.InterventionManager.repository.DonationItemRepo;
import com.ngirankugire.InterventionManager.service.DonationItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationItemServiceImpl implements DonationItemService{

    @Autowired
    DonationItemRepo repo;

//    @Value("${componentId}")
//    private String componentId;


    @Override
    public DonationItem createDonationItem(DonationItem donationItem) {
        return repo.save(donationItem);
    }

    @Override
    public List<DonationItem> getDonationItem() {
        return repo.findAll();
    }

    @Override
    public DonationItem getDonationItem(String id) {
        DonationItem donationItem = repo.findById(id).orElseThrow(()->new ApiRequestException("Donation Item with ID "+id+" is not found"));

        donationItem.getId();
        return donationItem;
    }

    @Override
    public DonationItem updateDonationItem(DonationItem donationItem) {
        repo.findById(donationItem.getId()).orElseThrow(()->new ApiRequestException("Donation Item doesn't exist"));
        DonationItem resultDonationItem = repo.save(donationItem);
//        resultTariff.setTariffItem(TariffItem.REFACTOR(tariffItemService.getTariffItemByTariffId(tariff.getId())));
        return resultDonationItem;
    }

    @Override
    public void deleteDonationItem(String id) {
        repo.deleteById(id);
    }

}
