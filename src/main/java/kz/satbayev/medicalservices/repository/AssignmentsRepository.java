package kz.satbayev.medicalservices.repository;

import kz.satbayev.medicalservices.entity.Assignments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AssignmentsRepository extends JpaRepository<Assignments, Long> {
    List<Assignments> findAllByDoctor_Id(Long doctorId);
}