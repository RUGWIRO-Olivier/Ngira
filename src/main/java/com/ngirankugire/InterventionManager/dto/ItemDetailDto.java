package com.ngirankugire.InterventionManager.dto;

import com.ngirankugire.InterventionManager.models.Item;

public class ItemDetailDto {
    private String itemTypeId;
    private String name;
    private String measurementUnit;

    public ItemDetailDto() {
    }

    public ItemDetailDto(String id, String name, String measurementUnit) {
        this.itemTypeId = id;
        this.name = name;
        this.measurementUnit = measurementUnit;
    }

    public ItemDetailDto(Item item) {
        this.itemTypeId = item.getItemTypeId();
        this.name = item.getName();
        this.measurementUnit = item.getMeasurementUnit();
    }
}
