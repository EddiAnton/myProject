package com.eddiAnton.repository;

import com.eddiAnton.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {
    List<Person> findByLastName(String lastName);
    List<Person> findByFirstNameAndLastName(String firstName, String lastName);
}
