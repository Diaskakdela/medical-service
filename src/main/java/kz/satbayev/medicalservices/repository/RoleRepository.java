package kz.satbayev.medicalservices.repository;

import kz.satbayev.medicalservices.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}