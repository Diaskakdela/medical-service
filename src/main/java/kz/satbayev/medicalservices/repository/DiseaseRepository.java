package kz.satbayev.medicalservices.repository;

import kz.satbayev.medicalservices.entity.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseRepository extends JpaRepository<Disease, Long> {
}