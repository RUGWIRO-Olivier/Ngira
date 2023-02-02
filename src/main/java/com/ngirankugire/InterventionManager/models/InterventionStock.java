package com.ngirankugire.InterventionManager.models;

import com.ngirankugire.InterventionManager.dto.*;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class InterventionStock extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interventionId", nullable = false)
    private Intervention intervention;

    @Column(name = "stockId", nullable = false, length = 120)
    private String stockId;

public InterventionStock(){

}

    public InterventionStock(String id, Intervention intervention, String stockId) {
        super(id);
        this.intervention = intervention;
        this.stockId = stockId;
    }

    public static final InterventionStockDetailDto REFACTORDETAILED(InterventionStock interventionStock) {
        return new InterventionStockDetailDto(interventionStock);
    }

    public  static final InterventionStockDto REFACTOR(InterventionStock interventionStock) {
        return new InterventionStockDto(interventionStock);
    }

    public static final List<InterventionStockDto> REFACTOR(List<InterventionStock> interventionStocks) {
        List<InterventionStockDto> dto = new ArrayList<>();
        for (InterventionStock interventionStock : interventionStocks) {
            dto.add(REFACTOR(interventionStock));
        }
        return dto;
    }
}
