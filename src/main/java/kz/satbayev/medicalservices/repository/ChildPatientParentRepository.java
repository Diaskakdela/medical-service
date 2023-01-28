package kz.satbayev.medicalservices.repository;

import kz.satbayev.medicalservices.entity.ChildPatientParent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildPatientParentRepository extends JpaRepository<ChildPatientParent, Long> {
}