package com.ngirankugire.InterventionManager.serviceImpl;

import com.ngirankugire.InterventionManager.exceptions.ApiRequestException;
import com.ngirankugire.InterventionManager.models.TypeConfig;
import com.ngirankugire.InterventionManager.models.TypeConfig;
import com.ngirankugire.InterventionManager.repository.TypeConfigRepo;
import com.ngirankugire.InterventionManager.service.TypeConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeConfigServiceImpl implements TypeConfigService {
    @Autowired
    TypeConfigRepo repo;
    

    @Override
    public TypeConfig createTypeConfig(TypeConfig typeConfig) {
        return repo.save(typeConfig);
    }

    @Override
    public List<TypeConfig> getTypeConfig() {
        return repo.findAll();
    }

    @Override
    public TypeConfig getTypeConfig(String id) {
        TypeConfig typeConfig = repo.findById(id).orElseThrow(()->new ApiRequestException("Type Config with ID "+id+" is not found"));

        typeConfig.getId();
        return typeConfig;
    }

    @Override
    public TypeConfig updateTypeConfig(TypeConfig typeConfig) {
        repo.findById(typeConfig.getId()).orElseThrow(()->new ApiRequestException("Type Config doesn't exist"));
        TypeConfig result = repo.save(typeConfig);
        return result;
    }

    @Override
    public void deleteTypeConfig(String id) {
        repo.deleteById(id);
    }

}
