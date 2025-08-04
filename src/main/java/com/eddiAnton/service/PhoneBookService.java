package com.eddiAnton.service;

import com.eddiAnton.exception.InvalidDataException;
import com.eddiAnton.model.Contact;
import com.eddiAnton.model.Person;
import com.eddiAnton.repository.ContactRepository;
import com.eddiAnton.repository.PersonRepository;
import com.eddiAnton.util.LoggingAspect;
import com.eddiAnton.validation.PersonValidator;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PhoneBookService {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    private final PersonRepository personRepository;
    private final PersonValidator personValidator;
    private final ContactRepository contactRepository;

    @Transactional
    public Person addPerson(Person person) {
        if (person.getPersonContacts() == null) {
            person.setPersonContacts(new ArrayList<>());
        }
        personValidator.validate(person);
        return personRepository.save(person);
    }

    @Transactional
    public void removePerson(UUID personId) {
        personRepository.deleteById(personId);
    }

    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    public Person findPersonByUuid(UUID personId) {
        return personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("Person not found"));
    }
}
