package com.ngirankugire.InterventionManager.models;

import com.ngirankugire.InterventionManager.dto.InterventionDetailDto;
import com.ngirankugire.InterventionManager.dto.InterventionDto;
import com.ngirankugire.InterventionManager.dto.ItemDetailDto;
import com.ngirankugire.InterventionManager.dto.ItemDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Item extends BaseEntity{
    @Column(name = "itemTypeId", length = 120, nullable = false)
    private String itemTypeId;

    @Column(name = "name", nullable = false, length = 120)
    private String name;

    @Column(name = "measurementUnit", nullable = false, length = 24)
    private String measurementUnit;

    public Item() {
    }

    public Item(String id, String itemTypeId, String name, String measurementUnit) {
        super(id);
        this.itemTypeId = itemTypeId;
        this.name = name;
        this.measurementUnit = measurementUnit;
    }

    public static final ItemDetailDto REFACTORDETAILED(Item item) {
        return new ItemDetailDto(item);
    }

    public  static final ItemDto REFACTOR(Item items) {
        return new ItemDto(items);
    }

    public static final List<ItemDto> REFACTOR(List<Item> items) {
        List<ItemDto> dto = new ArrayList<>();
        for (Item item : items) {
            dto.add(REFACTOR(item));
        }
        return dto;
    }

}
