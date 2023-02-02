package com.ngirankugire.InterventionManager.models;

import com.ngirankugire.InterventionManager.dto.InterventionDetailDto;
import com.ngirankugire.InterventionManager.dto.InterventionDto;
import com.ngirankugire.InterventionManager.dto.InterventionItemDetailDto;
import com.ngirankugire.InterventionManager.dto.InterventionItemDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class InterventionItem extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemId", nullable = false)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interventionId", nullable = false)
    private Intervention intervention;


    public InterventionItem() {

    }

    public InterventionItem(String id, Item item, Intervention intervention) {
        super(id);
        this.item = item;
        this.intervention = intervention;
    }

    public static final InterventionItemDetailDto REFACTORDETAILED(InterventionItem interventionItem) {
        return new InterventionItemDetailDto(interventionItem);
    }

    public  static final InterventionItemDto REFACTOR(InterventionItem interventionItem) {
        return new InterventionItemDto(interventionItem);
    }

    public static final List<InterventionItemDto> REFACTOR(List<InterventionItem> interventionItems) {
        List<InterventionItemDto> dto = new ArrayList<>();
        for (InterventionItem interventionItem : interventionItems) {
            dto.add(REFACTOR(interventionItem));
        }
        return dto;
    }

}
