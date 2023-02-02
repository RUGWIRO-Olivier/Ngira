package com.ngirankugire.InterventionManager.models;

import javax.persistence.Column;
import javax.persistence.Id;

public class InterventionGroupTypeCategoryDistributionPackage {

    @Id
    @Column(name = "interventionGroupTypeCategoryId", length = 120)
    private String interventionGroupTypeCategoryId;
    @Column(name = "packageName", length = 90, nullable = false)
    private String packageName;
    @Column(name = "packageDescription", length = 240)
    private String packageDescription;
}
