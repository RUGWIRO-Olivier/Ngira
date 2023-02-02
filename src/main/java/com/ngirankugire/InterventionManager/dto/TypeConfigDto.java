package com.ngirankugire.InterventionManager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ngirankugire.InterventionManager.models.TypeConfig;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class TypeConfigDto {
    private String id;
    private String typeName;
    private String entity;
    private String description;


    public TypeConfigDto(){

    }
    public TypeConfigDto(String id, String typeName, String entity, String description) {
        this.id = id;
        this.typeName = typeName;
        this.entity = entity;
        this.description = description;
    }

    public TypeConfigDto(TypeConfig typeConfig) {
        this.id = typeConfig.getId();
        this.typeName = typeConfig.getTypeName();
        this.entity = typeConfig.getEntity();
        this.description = typeConfig.getDescription();
    }
}
