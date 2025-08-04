package com.eddiAnton.controller;

import com.eddiAnton.model.Contact;
import com.eddiAnton.model.Person;
import com.eddiAnton.repository.PersonRepository;
import com.eddiAnton.service.ContactService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/persons/{personId}/contacts")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;
    private final PersonRepository personRepository;

    @PostMapping
    public ResponseEntity<Contact> addContact(
            @PathVariable UUID personId,
            @RequestBody Contact contact) {

        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new EntityNotFoundException("Person not found"));

        Contact savedContact = contactService.addContact(person, contact);
        return ResponseEntity.ok(savedContact);
    }
}
