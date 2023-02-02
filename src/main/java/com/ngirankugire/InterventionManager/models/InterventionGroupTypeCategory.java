package com.ngirankugire.InterventionManager.models;

import javax.persistence.Column;
import javax.persistence.Id;

public class InterventionGroupTypeCategory {
    @Id
    @Column(name = "interventionBeneficiaryGroupTypeId", length = 10)
    private String interventionBeneficiaryGroupTypeId;
    @Column(name = "parameterName", length = 120, nullable = false)
    private String parameterName;
    @Column(name = "parameterValue", length = 90, nullable = false)
    private String parameterValue;
    @Column(name = "parameterDescription", length = 240)
    private String parameterDescription;

}
