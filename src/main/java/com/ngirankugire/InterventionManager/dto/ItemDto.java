package com.ngirankugire.InterventionManager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ngirankugire.InterventionManager.models.Item;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ItemDto {
    private String id;
    private String itemTypeId;
    private String name;
    private String measurementUnit;

    public ItemDto() {
    }

    public ItemDto(String id, String itemTypeId, String name, String measurementUnit) {
        this.id = id;
        this.itemTypeId = itemTypeId;
        this.name = name;
        this.measurementUnit = measurementUnit;
    }

    public ItemDto(Item item) {
        this.id = item.getId();
        this.itemTypeId = item.getItemTypeId();
        this.name = item.getName();
        this.measurementUnit = item.getMeasurementUnit();
    }
}
