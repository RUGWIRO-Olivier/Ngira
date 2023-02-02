package com.ngirankugire.InterventionManager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ngirankugire.InterventionManager.models.InterventionItem;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class InterventionItemDto {
    private String id;
    private String itemId;
    private String interventionId;

    public InterventionItemDto(){

    }

    public InterventionItemDto(String id, String itemId, String interventionId) {
        this.id = id;
        this.itemId = itemId;
        this.interventionId = interventionId;
    }

    public InterventionItemDto(InterventionItem interventionItem) {
        this.id=interventionItem.getId();
        this.itemId = interventionItem.getItem().getId();
        this.interventionId = interventionItem.getIntervention().getId();
    }

}
