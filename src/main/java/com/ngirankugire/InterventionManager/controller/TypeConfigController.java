package com.ngirankugire.InterventionManager.controller;

import com.ngirankugire.InterventionManager.config.Constants;
import com.ngirankugire.InterventionManager.dto.ItemDetailDto;
import com.ngirankugire.InterventionManager.dto.ItemDto;
import com.ngirankugire.InterventionManager.dto.TypeConfigDetailDto;
import com.ngirankugire.InterventionManager.dto.TypeConfigDto;
import com.ngirankugire.InterventionManager.models.TypeConfig;
import com.ngirankugire.InterventionManager.serviceImpl.ItemServiceImpl;
import com.ngirankugire.InterventionManager.serviceImpl.TypeConfigServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(Constants.AllowedCrossOrigins)
@RestController
@RequestMapping(Constants.BasePath+Constants.PackagePath+Constants.TypeConfigPath)
public class TypeConfigController {
    @Autowired
    TypeConfigServiceImpl service;

    @ApiOperation(value = "Create a Type")
    @PostMapping("")
    public ResponseEntity<TypeConfigDto> createItem(@RequestBody TypeConfigDto dto){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
//        //dto.setCreatedBy(auth);
//
        TypeConfig typeConfig=new TypeConfig(dto.getId() ,dto.getTypeName(), dto.getEntity(), dto.getDescription());
//
        return new ResponseEntity(TypeConfig.REFACTORDETAILED(service.createTypeConfig(typeConfig)), HttpStatus.OK);

    }

    @ApiOperation(value = "Fetch all Types")
    @GetMapping()
    public List<TypeConfigDto> getTypeConfig(){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        return TypeConfig.REFACTOR(service.getTypeConfig());
    }


    @ApiOperation(value = "Fetch Typ eConfig By Id")
    @GetMapping("/{id}")
    public TypeConfigDto getTypeConfig( @PathVariable("id") String id){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        return TypeConfig.REFACTOR(service.getTypeConfig(id));
    }

    @ApiOperation(value = "Fetch Type Config By Id")
    @GetMapping("/Details/{id}")
    public TypeConfigDetailDto getDetailedTypeConfig(@PathVariable("id") String id){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        return TypeConfig.REFACTORDETAILED(service.getTypeConfig(id));
    }


    @ApiOperation(value = "Update Type")
    @PutMapping("")
    public ResponseEntity<TypeConfigDetailDto> updateTypeConfig(@RequestBody ItemDto dto){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        //tariffDto.setUpdatedBy(auth);

        TypeConfig typeConfig=new TypeConfig();

        return new ResponseEntity<>(TypeConfig.REFACTORDETAILED(service.updateTypeConfig(typeConfig)),HttpStatus.OK);
    }

    @ApiOperation(value="Delete an TypeConfig by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaDocumentTypeLt( @PathVariable("id") String id){
//        String auth = JwtTokenUtil.getUserIdFromToken(accessToken);
        service.deleteTypeConfig(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
