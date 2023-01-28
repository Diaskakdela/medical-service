package kz.satbayev.medicalservices.repository;

import kz.satbayev.medicalservices.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends PersonRepository<Patient> {
}