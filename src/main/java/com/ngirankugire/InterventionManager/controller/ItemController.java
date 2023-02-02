package com.ngirankugire.InterventionManager.controller;

import com.ngirankugire.InterventionManager.config.Constants;
import com.ngirankugire.InterventionManager.dto.InterventionDetailDto;
import com.ngirankugire.InterventionManager.dto.InterventionDto;
import com.ngirankugire.InterventionManager.dto.ItemDetailDto;
import com.ngirankugire.InterventionManager.dto.ItemDto;
import com.ngirankugire.InterventionManager.models.Intervention;
import com.ngirankugire.InterventionManager.models.Item;
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
@RequestMapping(Constants.BasePath+Constants.PackagePath+Constants.ItemPath)
public class ItemController {
    @Autowired
    ItemServiceImpl service;

    @ApiOperation(value = "Create Item")
    @PostMapping("")
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto dto){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
//        //dto.setCreatedBy(auth);
//
        Item item=new Item(dto.getId() ,dto.getItemTypeId(), dto.getName(), dto.getMeasurementUnit());
//
        return new ResponseEntity(Item.REFACTORDETAILED(service.createItem(item)), HttpStatus.OK);

    }

    @ApiOperation(value = "Fetch all Items")
    @GetMapping()
    public List<ItemDto> getItems(){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        return Item.REFACTOR(service.getItem());
    }


    @ApiOperation(value = "Fetch Item By Id")
    @GetMapping("/{id}")
    public ItemDto getItem( @PathVariable("id") String id){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        return Item.REFACTOR(service.getItem(id));
    }

    @ApiOperation(value = "Fetch Item By Id")
    @GetMapping("/Details/{id}")
    public ItemDetailDto getDetailedItem(@PathVariable("id") String id){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        return Item.REFACTORDETAILED(service.getItem(id));
    }


    @ApiOperation(value = "Update Item")
    @PutMapping("")
    public ResponseEntity<ItemDetailDto> updateItem(@RequestBody ItemDto dto){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        //tariffDto.setUpdatedBy(auth);

        Item item=new Item();

        return new ResponseEntity<>(Item.REFACTORDETAILED(service.updateItem(item)),HttpStatus.OK);
    }

    @ApiOperation(value="Delete an Item by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaDocumentTypeLt( @PathVariable("id") String id){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        service.deleteItem(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
