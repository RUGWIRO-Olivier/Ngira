package com.ngirankugire.InterventionManager.controller;

import com.ngirankugire.InterventionManager.config.Constants;
import com.ngirankugire.InterventionManager.dto.InterventionDto;
import com.ngirankugire.InterventionManager.dto.InterventionItemDetailDto;
import com.ngirankugire.InterventionManager.dto.InterventionItemDto;
import com.ngirankugire.InterventionManager.models.InterventionItem;
import com.ngirankugire.InterventionManager.serviceImpl.InterventionItemServiceImpl;
import com.ngirankugire.InterventionManager.serviceImpl.InterventionServiceImpl;
import com.ngirankugire.InterventionManager.serviceImpl.ItemServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(Constants.AllowedCrossOrigins)
@RestController
@RequestMapping(Constants.BasePath+Constants.PackagePath+Constants.InterventionItemPath)
public class InterventionItemController {

    @Autowired
    InterventionItemServiceImpl service;

    @Autowired
    ItemServiceImpl itemService;
    @Autowired
    InterventionServiceImpl interventionService;



    @ApiOperation(value = "Create Intervention Item")
    @PostMapping("")
    public ResponseEntity<InterventionItemDto> createInterventionItem(@RequestBody InterventionItemDto dto){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
//        //dto.setCreatedBy(auth);
//
        InterventionItem interventionItem=new InterventionItem(dto.getId(), itemService.getItem(dto.getItemId()), interventionService.getIntervention(dto.getInterventionId()));
//
        return new ResponseEntity(InterventionItem.REFACTORDETAILED(service.createInterventionItem(interventionItem)), HttpStatus.OK);

    }

    @ApiOperation(value = "Fetch all Intervention Items")
    @GetMapping()
    public List<InterventionItemDto> getInterventionItems(){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        return InterventionItem.REFACTOR(service.getInterventionItems());
    }


    @ApiOperation(value = "Fetch Intervention Item By Id")
    @GetMapping("/{id}")
    public InterventionItemDto getInterventionItem( @PathVariable("id") String id){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        return InterventionItem.REFACTOR(service.getInterventionItem(id));
    }

    @ApiOperation(value = "Fetch Intervention By Id")
    @GetMapping("/Details/{id}")
    public InterventionItemDetailDto getDetailedInterventionItem(@PathVariable("id") String id){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        return InterventionItem.REFACTORDETAILED(service.getInterventionItem(id));
    }


    @ApiOperation(value = "Update Intervention Item")
    @PutMapping("")
    public ResponseEntity<InterventionItemDetailDto> updateInterventionItem( @RequestBody InterventionDto dto){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        //tariffDto.setUpdatedBy(auth);

        InterventionItem interventionItem=new InterventionItem();

        return new ResponseEntity<>(InterventionItem.REFACTORDETAILED(service.updateInterventionItem(interventionItem)),HttpStatus.OK);
    }

    @ApiOperation(value="Delete a Intervention Item by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInterventionItem( @PathVariable("id") String id){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        service.deleteInterventionItem(id);
        return new ResponseEntity<>("Intervention Item Deleted", HttpStatus.OK);
    }
}
