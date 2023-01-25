package kz.satbayev.medicalservices.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String fullName;

    private Date createdDate;

    @ManyToMany
    private List<Role> roles;
}
