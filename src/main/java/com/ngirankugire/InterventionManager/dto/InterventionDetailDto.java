package com.ngirankugire.InterventionManager.dto;

import com.ngirankugire.InterventionManager.models.Intervention;
import com.ngirankugire.InterventionManager.models.TypeConfig;

import java.util.Date;

public class InterventionDetailDto {

    private String interventionTypeId;
    private String name;
    private String description;
    private Date interventionStarts;
    private Date interventionEnds;
    private TypeConfigDto typeConfig;

    public InterventionDetailDto() {

    }

    public InterventionDetailDto(String interventionTypeId, String name, String description, Date interventionStarts, Date interventionEnds, TypeConfig typeConfig) {
        this.interventionTypeId = interventionTypeId;
        this.name = name;
        this.description = description;
        this.interventionStarts = interventionStarts;
        this.interventionEnds = interventionEnds;
        this.typeConfig = new TypeConfigDto(typeConfig);
    }

    public InterventionDetailDto(Intervention intervention) {
        this.interventionTypeId = intervention.getInterventionTypeId();
        this.name = intervention.getName();
        this.description = intervention.getDescription();
        this.interventionStarts = intervention.getInterventionStarts();
        this.interventionEnds = intervention.getInterventionEnds();
        this.typeConfig = new TypeConfigDto(intervention.getTypeConfig());
    }

}
