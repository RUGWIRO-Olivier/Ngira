package com.ngirankugire.InterventionManager.dto;

import com.ngirankugire.InterventionManager.models.Intervention;
import com.ngirankugire.InterventionManager.models.InterventionStock;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class InterventionStockDetailDto {
    private InterventionDto intervention;
    private String stockId;

    public InterventionStockDetailDto(){

    }

    public InterventionStockDetailDto(Intervention intervention, String stockId) {
        this.intervention = new InterventionDto(intervention);
        this.stockId = stockId;
    }

    public InterventionStockDetailDto(InterventionStock interventionStock) {
        this.intervention = new InterventionDto(interventionStock.getIntervention());
        this.stockId = interventionStock.getStockId();
    }
}
