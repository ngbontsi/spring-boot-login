package com.bezkoder.spring.login.repository;

import com.bezkoder.spring.login.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParentRepository extends JpaRepository<Person, Long> {
  Optional<Person> findByFirstnameAndLastname(String firstname, String lastname);
}
