package kz.satbayev.medicalservices.repository;

import kz.satbayev.medicalservices.entity.Person;
import kz.satbayev.medicalservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonRepository<T extends Person> extends JpaRepository<T, Long> {
//    T findByUser(User user);
}