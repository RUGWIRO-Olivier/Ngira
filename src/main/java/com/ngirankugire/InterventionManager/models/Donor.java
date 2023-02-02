package com.ngirankugire.InterventionManager.models;

import com.ngirankugire.InterventionManager.dto.DonorDetailDto;
import com.ngirankugire.InterventionManager.dto.DonorDto;
import com.ngirankugire.InterventionManager.dto.InterventionDetailDto;
import com.ngirankugire.InterventionManager.dto.InterventionDto;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Donor extends BaseEntity{
    @Column(name = "donorTypeId", length = 120, nullable = false)
    private String donorTypeId;
    @Column(name = "name", length = 60, nullable = false)
    private String name;

    public Donor() {
    }

    public Donor(String id, String donorTypeId,String name) {
        this.setId(id);
        this.donorTypeId = donorTypeId;
        this.name = name;
    }

    public static final DonorDetailDto REFACTORDETAILED(Donor donor) {
        return new DonorDetailDto(donor);
    }

    public  static final DonorDto REFACTOR(Donor donor) {
        return new DonorDto(donor);
    }

    public static final List<DonorDto> REFACTOR(List<Donor> donors) {
        List<DonorDto> dto = new ArrayList<>();
        for (Donor donor : donors) {
            dto.add(REFACTOR(donor));
        }
        return dto;
    }
}
