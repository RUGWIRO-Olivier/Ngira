package com.ngirankugire.InterventionManager.service;

import com.ngirankugire.InterventionManager.models.TypeConfig;

import java.util.List;

public interface TypeConfigService {
    TypeConfig createTypeConfig(TypeConfig typeConfig);
    List<TypeConfig> getTypeConfig();
    TypeConfig getTypeConfig(String id);
    TypeConfig updateTypeConfig(TypeConfig typeConfig);
    void deleteTypeConfig(String id);
}
