package kz.satbayev.medicalservices.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

}
