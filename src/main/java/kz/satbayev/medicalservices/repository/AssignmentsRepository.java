package kz.satbayev.medicalservices.repository;

import kz.satbayev.medicalservices.entity.Assignments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentsRepository extends JpaRepository<Assignments, Long> {
}