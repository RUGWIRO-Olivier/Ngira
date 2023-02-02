package com.ngirankugire.InterventionManager.controller;

import com.ngirankugire.InterventionManager.config.Constants;
import com.ngirankugire.InterventionManager.dto.DonationItemDetailDto;
import com.ngirankugire.InterventionManager.dto.DonationItemDto;
import com.ngirankugire.InterventionManager.dto.InterventionDetailDto;
import com.ngirankugire.InterventionManager.dto.InterventionDto;
import com.ngirankugire.InterventionManager.models.DonationItem;
import com.ngirankugire.InterventionManager.models.Intervention;
import com.ngirankugire.InterventionManager.serviceImpl.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(Constants.AllowedCrossOrigins)
@RestController
@RequestMapping(Constants.BasePath+Constants.PackagePath+Constants.DonationItemPath)
public class DonationItemController {
    @Autowired
    DonationItemServiceImpl service;

    @Autowired
    ItemServiceImpl itemService;

    @Autowired
    DonationServiceImpl donationService;


    @ApiOperation(value = "Create Donation Item")
    @PostMapping("")
    public ResponseEntity<DonationItemDto> createDonationItem(@RequestBody DonationItemDto dto){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
//        //dto.setCreatedBy(auth);
//
        DonationItem donationItem=new DonationItem(dto.getId(), itemService.getItem(dto.getItemId()),donationService.getDonation(dto.getDonationId()), dto.getQuantity());
//
        return new ResponseEntity(DonationItem.REFACTORDETAILED(service.createDonationItem(donationItem)), HttpStatus.OK);

    }

    @ApiOperation(value = "Fetch all Donation Items")
    @GetMapping()
    public List<DonationItemDto> getTariffs(){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        return DonationItem.REFACTOR(service.getDonationItem());
    }


    @ApiOperation(value = "Fetch Donation Item By Id")
    @GetMapping("/{id}")
    public DonationItemDto getDonationItem( @PathVariable("id") String id){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        return DonationItem.REFACTOR(service.getDonationItem(id));
    }

    @ApiOperation(value = "Fetch Donation Item By Id")
    @GetMapping("/Details/{id}")
    public DonationItemDetailDto getDetailedDonationItem(@PathVariable("id") String id){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        return DonationItem.REFACTORDETAILED(service.getDonationItem(id));
    }


    @ApiOperation(value = "Update Donation Item")
    @PutMapping("")
    public ResponseEntity<DonationItemDetailDto> updateTariff( @RequestBody DonationItemDto dto){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        //tariffDto.setUpdatedBy(auth);

        DonationItem donationItem=new DonationItem();

        return new ResponseEntity<>(DonationItem.REFACTORDETAILED(service.updateDonationItem(donationItem)),HttpStatus.OK);
    }

    @ApiOperation(value="Delete a Donation Item by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaDocumentTypeLt( @PathVariable("id") String id){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        service.deleteDonationItem(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
