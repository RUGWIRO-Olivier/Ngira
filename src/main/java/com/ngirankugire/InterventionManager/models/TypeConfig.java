package com.ngirankugire.InterventionManager.models;

import com.ngirankugire.InterventionManager.dto.ItemDetailDto;
import com.ngirankugire.InterventionManager.dto.ItemDto;
import com.ngirankugire.InterventionManager.dto.TypeConfigDetailDto;
import com.ngirankugire.InterventionManager.dto.TypeConfigDto;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class TypeConfig extends BaseEntity{
    @Column(name = "typeName", length = 120, nullable = false)
    private String typeName;
    @Column(name = "entity", length = 120, nullable = false)
    private String entity;
    @Column(name = "description", length = 240)
    private String description;

    public TypeConfig(){

    }

    public TypeConfig(String id, String typeName, String entity, String description) {
        super(id);
        this.typeName = typeName;
        this.entity = entity;
        this.description = description;
    }

    public static final TypeConfigDetailDto REFACTORDETAILED(TypeConfig typeConfig) {
        return new TypeConfigDetailDto(typeConfig);
    }

    public  static final TypeConfigDto REFACTOR(TypeConfig typeConfig) {
        return new TypeConfigDto(typeConfig);
    }

    public static final List<TypeConfigDto> REFACTOR(List<TypeConfig> typeConfigs) {
        List<TypeConfigDto> dto = new ArrayList<>();
        for (TypeConfig typeConfig : typeConfigs) {
            dto.add(REFACTOR(typeConfig));
        }
        return dto;
    }
}
