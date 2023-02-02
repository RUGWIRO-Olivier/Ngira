package com.ngirankugire.InterventionManager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ngirankugire.InterventionManager.models.Intervention;
import com.ngirankugire.InterventionManager.models.InterventionStock;
import lombok.Data;

import java.util.Date;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class InterventionStockDto {
    private String id;
    private String interventionId;
    private String stockId;

    public InterventionStockDto(){

    }

    public InterventionStockDto(String id, String intervention, String stockId) {
        this.id= id;
        this.interventionId = intervention;
        this.stockId = stockId;
    }

    public InterventionStockDto(InterventionStock interventionStock) {
        this.id=interventionStock.getId();
        this.interventionId = interventionStock.getIntervention().getId();
        this.stockId = interventionStock.getStockId();
    }
}
