package com.ngirankugire.InterventionManager.models;

import javax.persistence.Column;
import javax.persistence.Id;

public class InterventionGroupType {
    @Id
    @Column(name = "interventionId", length = 120, nullable = false)
    private String interventionId;
    @Column(name = "beneficiaryGroupTypeId", length = 120, nullable = false)
    private String beneficiaryGroupTypeId;
    @Column(name = "isGroupIntervention", length = 3)
    private Boolean isGroupIntervention;

}
