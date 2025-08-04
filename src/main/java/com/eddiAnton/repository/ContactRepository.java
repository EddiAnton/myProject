package com.eddiAnton.repository;

import com.eddiAnton.model.Contact;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ContactRepository extends JpaRepository<Contact, UUID> {

    @Override
    @EntityGraph(attributePaths = {"person"})
    <S extends Contact> S save(S entity);

    @Override
    @EntityGraph(attributePaths = {"person"})
    <S extends Contact> S saveAndFlush(S entity);

    List<Contact> findByPersonUuid(UUID personId);

    @Modifying
    @Query("DELETE FROM Contact contact WHERE contact.person.uuid = :personId")
    void deleteByPersonUuid(@Param("personId") UUID personId);

    @Modifying
    @Query("DELETE FROM Contact contact WHERE contact.person.uuid = :personId AND contact.uuid = :contactId")
    void deleteByPersonUuidAndContactUuid(@Param("personId") UUID personId, @Param("contactId") UUID contactId);
}
