package kz.satbayev.medicalservices.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
@DiscriminatorValue("D")
public class Doctor extends Person{

    @OneToMany
    private List<DoctorSpecialization> doctorSpecialization;
}
