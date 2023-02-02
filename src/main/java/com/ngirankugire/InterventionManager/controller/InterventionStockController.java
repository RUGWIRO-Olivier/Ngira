package com.ngirankugire.InterventionManager.controller;

import com.ngirankugire.InterventionManager.config.Constants;
import com.ngirankugire.InterventionManager.dto.InterventionStockDetailDto;
import com.ngirankugire.InterventionManager.dto.InterventionStockDto;
import com.ngirankugire.InterventionManager.models.InterventionStock;
import com.ngirankugire.InterventionManager.serviceImpl.InterventionServiceImpl;
import com.ngirankugire.InterventionManager.serviceImpl.InterventionStockServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(Constants.AllowedCrossOrigins)
@RestController
@RequestMapping(Constants.BasePath+Constants.PackagePath+Constants.InterventionStockPath)
public class InterventionStockController {

    @Autowired
    InterventionStockServiceImpl service;

    @Autowired
    InterventionServiceImpl interventionService;



    @ApiOperation(value = "Create Intervention Stock")
    @PostMapping("")
    public ResponseEntity<InterventionStockDto> createInterventionStock(@RequestBody InterventionStockDto dto){

        InterventionStock interventionStock=new InterventionStock(dto.getId(),  interventionService.getIntervention(dto.getInterventionId()),dto.getStockId());
//
        return new ResponseEntity(InterventionStock.REFACTORDETAILED(service.createInterventionStock(interventionStock)), HttpStatus.OK);

    }




    @ApiOperation(value = "Fetch Intervention Stock By Id")
    @GetMapping("/{id}")
    public InterventionStockDto getInterventionStock( @PathVariable("id") String id){
        return InterventionStock.REFACTOR(service.getInterventionStock(id));
    }

    @ApiOperation(value = "Fetch Intervention Stock Details By Id")
    @GetMapping("/Details/{id}")
    public InterventionStockDetailDto getDetailedInterventionStock(@PathVariable("id") String id){
        return InterventionStock.REFACTORDETAILED(service.getInterventionStock(id));
    }


    @ApiOperation(value = "Update Intervention Stock")
    @PutMapping("")
    public ResponseEntity<InterventionStockDetailDto> updateInterventionStock( @RequestBody InterventionStockDto dto){
        InterventionStock interventionStock=new InterventionStock();

        return new ResponseEntity<>(InterventionStock.REFACTORDETAILED(service.updateInterventionStock(interventionStock)),HttpStatus.OK);
    }

    @ApiOperation(value="Delete a Intervention Stock by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaDocumentTypeLt( @PathVariable("id") String id){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        service.deleteInterventionStock(id);
        return new ResponseEntity<>("Intervention Stock Deleted", HttpStatus.OK);
    }

}
