package kz.satbayev.medicalservices.repository;

import kz.satbayev.medicalservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}