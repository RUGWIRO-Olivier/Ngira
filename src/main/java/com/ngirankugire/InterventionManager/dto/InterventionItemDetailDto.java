package com.ngirankugire.InterventionManager.dto;

import com.ngirankugire.InterventionManager.models.Intervention;
import com.ngirankugire.InterventionManager.models.InterventionItem;
import com.ngirankugire.InterventionManager.models.Item;

public class InterventionItemDetailDto {

    private ItemDto item;
    private InterventionDto intervention;

    public InterventionItemDetailDto(){

    }

    public InterventionItemDetailDto(Item item, Intervention intervention) {
        this.item = new ItemDto(item);
        this.intervention = new InterventionDto(intervention);
    }




    public InterventionItemDetailDto(InterventionItem interventionItem) {
        this.item = new ItemDto(interventionItem.getItem());
        this.intervention = new InterventionDto(interventionItem.getIntervention());
    }

}
