package com.ngirankugire.InterventionManager.dto;

import com.ngirankugire.InterventionManager.models.TypeConfig;

import javax.persistence.Column;

public class TypeConfigDetailDto {
    private String typeName;
    private String entity;
    private String description;

    public TypeConfigDetailDto(){

    }
    public TypeConfigDetailDto(String typeName, String entity, String description) {
        this.typeName = typeName;
        this.entity = entity;
        this.description = description;
    }

    public TypeConfigDetailDto(TypeConfig typeConfig) {
        this.typeName = typeConfig.getTypeName();
        this.entity = typeConfig.getEntity();
        this.description = typeConfig.getDescription();
    }
}
