package com.ngirankugire.InterventionManager.controller;

import com.ngirankugire.InterventionManager.config.Constants;
import com.ngirankugire.InterventionManager.dto.DonorDetailDto;
import com.ngirankugire.InterventionManager.dto.DonorDto;
import com.ngirankugire.InterventionManager.dto.InterventionDetailDto;
import com.ngirankugire.InterventionManager.dto.InterventionDto;
import com.ngirankugire.InterventionManager.models.Donor;
import com.ngirankugire.InterventionManager.models.Intervention;
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
@RequestMapping(Constants.BasePath+Constants.PackagePath+Constants.DonorPath)
public class DonorController {
    @Autowired
    DonorServiceImpl service;


    @ApiOperation(value = "Create Donor")
    @PostMapping("")
    public ResponseEntity<DonorDto> createDonor(@RequestBody DonorDto dto){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
//        //dto.setCreatedBy(auth);
//
        Donor donor=new Donor(dto.getId(), dto.getDonorTypeId(), dto.getName());
//
        return new ResponseEntity(Donor.REFACTORDETAILED(service.createDonor(donor)), HttpStatus.OK);

    }

    @ApiOperation(value = "Fetch all Donors")
    @GetMapping()
    public List<DonorDto> getDonors(){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        return Donor.REFACTOR(service.getDonor());
    }


    @ApiOperation(value = "Fetch Donor By Id")
    @GetMapping("/{id}")
    public DonorDto getDonor( @PathVariable("id") String id){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        return Donor.REFACTOR(service.getDonor(id));
    }

    @ApiOperation(value = "Fetch Donor By Id")
    @GetMapping("/Details/{id}")
    public DonorDetailDto getDetailedDonor(@PathVariable("id") String id){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        return Donor.REFACTORDETAILED(service.getDonor(id));
    }


    @ApiOperation(value = "Update Donor")
    @PutMapping("")
    public ResponseEntity<DonorDetailDto> updateTariff( @RequestBody DonorDto dto){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        //tariffDto.setUpdatedBy(auth);

        Donor donor=new Donor();

        return new ResponseEntity<>(Donor.REFACTORDETAILED(service.updateDonor(donor)),HttpStatus.OK);
    }

    @ApiOperation(value="Delete a Donor by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaDocumentTypeLt( @PathVariable("id") String id){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        service.deleteDonor(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
