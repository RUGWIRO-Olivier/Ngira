package com.ngirankugire.InterventionManager.controller;

import com.ngirankugire.InterventionManager.config.Constants;
import com.ngirankugire.InterventionManager.dto.InterventionDetailDto;
import com.ngirankugire.InterventionManager.dto.InterventionDto;
import com.ngirankugire.InterventionManager.models.Intervention;
import com.ngirankugire.InterventionManager.serviceImpl.InterventionServiceImpl;
import com.ngirankugire.InterventionManager.serviceImpl.TypeConfigServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(Constants.AllowedCrossOrigins)
@RestController
@RequestMapping(Constants.BasePath+Constants.PackagePath+Constants.InterventionPath)
public class InterventionController {
    @Autowired
    InterventionServiceImpl service;

    @Autowired
    TypeConfigServiceImpl typeConfigService;



    @ApiOperation(value = "Create Intervention")
    @PostMapping("")
    public ResponseEntity<InterventionDto> createIntervention(@RequestBody InterventionDto dto){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
//        //dto.setCreatedBy(auth);
//
        Intervention intervention=new Intervention(dto.getId(), dto.getInterventionTypeId(), dto.getName(), dto.getDescription(), dto.getInterventionStarts(), dto.getInterventionEnds(),  typeConfigService.getTypeConfig(dto.getId()), dto.getUserId());
//
        return new ResponseEntity(Intervention.REFACTORDETAILED(service.createIntervention(intervention)),HttpStatus.OK);

    }

    @ApiOperation(value = "Fetch all Interventions")
    @GetMapping()
    public List<InterventionDto> getInterventions(){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        return Intervention.REFACTOR(service.getIntervention());
    }


    @ApiOperation(value = "Fetch Intervention By Id")
    @GetMapping("/{id}")
    public InterventionDto getIntervention( @PathVariable("id") String id){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        return Intervention.REFACTOR(service.getIntervention(id));
    }

    @ApiOperation(value = "Fetch Intervention By Id")
    @GetMapping("/Details/{id}")
    public InterventionDetailDto getDetailedIntervention(@PathVariable("id") String id){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        return Intervention.REFACTORDETAILED(service.getIntervention(id));
    }


    @ApiOperation(value = "Update Intervention")
    @PutMapping("")
    public ResponseEntity<InterventionDetailDto> updateIntervention( @RequestBody InterventionDto dto){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        //tariffDto.setUpdatedBy(auth);

        Intervention intervention=new Intervention();

        return new ResponseEntity<>(Intervention.REFACTORDETAILED(service.updateIntervention(intervention)),HttpStatus.OK);
    }

    @ApiOperation(value="Delete a Intervention by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaDocumentTypeLt( @PathVariable("id") String id){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        service.deleteIntervention(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
