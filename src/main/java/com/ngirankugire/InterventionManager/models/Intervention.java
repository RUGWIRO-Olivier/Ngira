package com.ngirankugire.InterventionManager.models;

import com.ngirankugire.InterventionManager.dto.InterventionDetailDto;
import com.ngirankugire.InterventionManager.dto.InterventionDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Intervention extends BaseEntity{

    @Column(name = "interventionTypeId", length = 120, nullable = false)
    private String interventionTypeId;

    @Column(name = "name", length = 60, nullable = false)
    private String name;

    @Column(name = "description", length = 120)
    private String description;

    @Column(name = "interventionStarts", nullable = false, updatable = false, insertable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date interventionStarts;

    @Column(name = "interventionEnds", nullable = false, updatable = false, insertable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date interventionEnds;

//    @Column(name = "groupTypeId", nullable = false, length = 120)
//    private String groupTypeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "beneficiaryGroupTypeId", nullable = false)
    private TypeConfig typeConfig;
//
//    @Column(name = "stockId", nullable = false)
//    private String stockId;

    @Column(name = "userId", nullable = false)
    private String userId;

    public Intervention() {

    }

    public Intervention(String id, String interventionTypeId, String name, String description, Date interventionStarts, Date interventionEnds, TypeConfig typeConfig, String userId) {
        super(id);
        this.interventionTypeId = interventionTypeId;
        this.name = name;
        this.description = description;
        this.interventionStarts = interventionStarts;
        this.interventionEnds = interventionEnds;
//        this.groupTypeId = groupTypeId;
        this.typeConfig = typeConfig;
//        this.stockId = stockId;
        this.userId = userId;
    }

    public static final InterventionDetailDto REFACTORDETAILED(Intervention intervention) {
        return new InterventionDetailDto(intervention);
    }

    public  static final InterventionDto REFACTOR(Intervention intervention) {
        return new InterventionDto(intervention);
    }

    public static final List<InterventionDto> REFACTOR(List<Intervention> interventions) {
        List<InterventionDto> dto = new ArrayList<>();
        for (Intervention intervention : interventions) {
            dto.add(REFACTOR(intervention));
        }
        return dto;
    }

}
