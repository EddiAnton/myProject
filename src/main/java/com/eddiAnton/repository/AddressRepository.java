package com.eddiAnton.repository;

import com.eddiAnton.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {

    List<Address> findAddressesByPersonUuid(UUID personId);

    @Modifying
    @Query("DELETE FROM Address a WHERE a.person.uuid = :personId")
    void deleteByPersonUuid(@Param("personId") UUID personId);
}
