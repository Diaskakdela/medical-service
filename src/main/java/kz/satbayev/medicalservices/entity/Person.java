package kz.satbayev.medicalservices.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@MappedSuperclass
@DiscriminatorColumn(name="personType", discriminatorType = DiscriminatorType.CHAR)
public abstract class Person{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
