package com.bezkoder.spring.login.repository;

import com.bezkoder.spring.login.models.Person;
import com.bezkoder.spring.login.models.User;
import com.bezkoder.spring.login.models.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInformationRepository extends JpaRepository<Person, Long> {
  Optional<Person> findByFirstnameAndLastname(String username, String lastname);

  Boolean existsByFirstnameAndLastname(String username, String lastname);

}
