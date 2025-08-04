package com.eddiAnton.service;

import com.eddiAnton.model.Address;
import com.eddiAnton.model.Person;
import com.eddiAnton.repository.AddressRepository;
import com.eddiAnton.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;

    public List<Address> getAddressesByPerson(UUID personId) {
        return addressRepository.findAddressesByPersonUuid(personId);
    }

    public Address addAddress(UUID personId, Address address) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new EntityNotFoundException("Person not found"));

        address.setPerson(person);
        return addressRepository.save(address);
    }

    public void deleteAddress(UUID addressId) {
        addressRepository.deleteById(addressId);
    }
}
