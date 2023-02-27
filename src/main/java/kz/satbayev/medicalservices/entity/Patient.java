package kz.satbayev.medicalservices.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("P")
public class Patient extends Person{
    @Column(columnDefinition = "boolean default false", nullable = false)
    private boolean isPatientChild;

}
