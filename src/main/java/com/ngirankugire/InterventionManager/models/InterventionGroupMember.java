package com.ngirankugire.InterventionManager.models;

import javax.persistence.Column;
import javax.persistence.Id;

public class InterventionGroupMember extends BaseEntity{

    @Column(name = "beneficiaryId", length = 120, nullable = false)
    private String beneficiaryId;
}
