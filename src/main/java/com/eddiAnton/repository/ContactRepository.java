package com.eddiAnton.repository;

import com.eddiAnton.model.Contact;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContactRepository extends JpaRepository<Contact, UUID> {

    List<Contact> findByPersonUuid(UUID personId);

    @EntityGraph(attributePaths = {"person"})
    @Query("SELECT contact FROM Contact contact WHERE contact.uuid = :id")
    Optional<Contact> findByUuidWithPerson(@Param("id") UUID id);

    @Modifying
    @Query("DELETE FROM Contact contact WHERE contact.person.uuid = :personId")
    void deleteByPersonUuid(@Param("personId") UUID personId);

    @Modifying
    @Query("DELETE FROM Contact contact WHERE contact.person.uuid = :personId AND contact.uuid = :contactId")
    void deleteByPersonUuidAndContactUuid(@Param("personId") UUID personId, @Param("contactId") UUID contactId);
}
