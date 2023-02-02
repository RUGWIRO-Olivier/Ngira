package com.ngirankugire.InterventionManager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ngirankugire.InterventionManager.models.Intervention;
import lombok.Data;

import java.util.Date;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class InterventionDto {
    private String id;
    private String interventionTypeId;
    private String name;
    private String description;
    private Date interventionStarts;
    private Date interventionEnds;
    private String typeConfig;
//    private String stockId;
//    private String groupTypeId;
    private String userId;

    public InterventionDto() {

    }

    public InterventionDto(String id, String interventionTypeId, String name, String description, Date interventionStarts, Date interventionEnds, String typeConfig, String userId) {
        this.id = id;
        this.interventionTypeId = interventionTypeId;
        this.name = name;
        this.description = description;
        this.interventionStarts = interventionStarts;
        this.interventionEnds = interventionEnds;
        this.typeConfig = typeConfig;
//        this.stockId = stockId;
//        this.groupTypeId = groupTypeId;
        this.userId = userId;
    }

    public InterventionDto(Intervention intervention) {
        this.id = intervention.getId();
        this.interventionTypeId = intervention.getInterventionTypeId();
        this.name = intervention.getName();
        this.description = intervention.getDescription();
        this.interventionStarts = intervention.getInterventionStarts();
        this.interventionEnds = intervention.getInterventionEnds();
//        this.groupTypeId = intervention.getGroupTypeId();
        this.typeConfig = intervention.getTypeConfig().getId();
//        this.stockId = intervention.getStockId();
        this.userId = intervention.getUserId();

    }

}
