package com.ngirankugire.InterventionManager.controller;

import com.ngirankugire.InterventionManager.config.Constants;
import com.ngirankugire.InterventionManager.dto.DonationDetailDto;
import com.ngirankugire.InterventionManager.dto.DonationDto;
import com.ngirankugire.InterventionManager.dto.InterventionDetailDto;
import com.ngirankugire.InterventionManager.dto.InterventionDto;
import com.ngirankugire.InterventionManager.models.Donation;
import com.ngirankugire.InterventionManager.models.Intervention;
import com.ngirankugire.InterventionManager.serviceImpl.DonationServiceImpl;
import com.ngirankugire.InterventionManager.serviceImpl.DonorServiceImpl;
import com.ngirankugire.InterventionManager.serviceImpl.InterventionServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(Constants.AllowedCrossOrigins)
@RestController
@RequestMapping(Constants.BasePath+Constants.PackagePath+Constants.DonationPath)
public class DonationController {
    @Autowired
    DonationServiceImpl service;

    @Autowired
    DonorServiceImpl donorService;

    @Autowired
    InterventionServiceImpl interventionService;


    @ApiOperation(value = "Create Donation")
    @PostMapping("")
    public ResponseEntity<DonationDto> createIntervention(@RequestBody DonationDto dto){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
//        //dto.setCreatedBy(auth);
//
        Donation donation=new Donation(dto.getId(), dto.getDonorTypeId(), dto.getMessage(), donorService.getDonor(dto.getDonorId()), interventionService.getIntervention(dto.getInterventionId()));
//
        return new ResponseEntity(Donation.REFACTORDETAILED(service.createDonation(donation)), HttpStatus.OK);

    }

    @ApiOperation(value = "Fetch all Donations")
    @GetMapping()
    public List<DonationDto> getDonations(){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        return Donation.REFACTOR(service.getDonation());
    }


    @ApiOperation(value = "Fetch Donation By Id")
    @GetMapping("/{id}")
    public DonationDto getIntervention( @PathVariable("id") String id){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        return Donation.REFACTOR(service.getDonation(id));
    }

    @ApiOperation(value = "Fetch Donation By Id")
    @GetMapping("/Details/{id}")
    public DonationDetailDto getDetailedDonation(@PathVariable("id") String id){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        return Donation.REFACTORDETAILED(service.getDonation(id));
    }


    @ApiOperation(value = "Update Donation")
    @PutMapping("")
    public ResponseEntity<DonationDetailDto> updateTariff(@RequestBody InterventionDto dto){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        //tariffDto.setUpdatedBy(auth);

        Donation donation=new Donation();

        return new ResponseEntity<>(Donation.REFACTORDETAILED(service.updateDonation(donation)),HttpStatus.OK);
    }

    @ApiOperation(value="Delete a Donation by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaDocumentTypeLt( @PathVariable("id") String id){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        service.deleteDonation(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
