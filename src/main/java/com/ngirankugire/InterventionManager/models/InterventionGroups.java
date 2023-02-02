package com.ngirankugire.InterventionManager.models;

import javax.persistence.Column;
import javax.persistence.Id;

public class InterventionGroups {

    @Id
    @Column(name = "interventionGroupTypeId", length = 120, nullable = false)
    private String interventionGroupTypeId;
    @Column(name = "groupName", length = 120, nullable = false)
    private String groupName;
    @Column(name = "groupDescription", length = 240)
    private String groupDescription;
    @Column(name = "groupHead", length = 120)
    private String groupHead;

}
