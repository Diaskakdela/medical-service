package kz.satbayev.medicalservices.repository;

import kz.satbayev.medicalservices.entity.DoctorSpecialization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorSpecializationRepository extends JpaRepository<DoctorSpecialization, Long> {
}