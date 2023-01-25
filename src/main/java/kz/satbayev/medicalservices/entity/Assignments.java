package kz.satbayev.medicalservices.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Assignments {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    private Patient patient;

    @OneToOne
    private Doctor doctor;

    private boolean isServiceProvided;

    private Date appointmentDate;

    private Date serviceProvidedDate;

    private String comment;

}
