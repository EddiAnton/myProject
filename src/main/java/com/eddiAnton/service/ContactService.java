package com.eddiAnton.service;

import com.eddiAnton.model.*;
import com.eddiAnton.repository.ContactRepository;
import com.eddiAnton.repository.PersonRepository;
import com.eddiAnton.validation.ContactValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;
    private final PersonRepository personRepository;
    private final ContactValidator contactValidator;

    @Transactional
    public void updateContacts (Person person, List<Contact> newContacts) {
        // Удаляем старые контакты
        contactRepository.deleteByPersonUuid(person.getUuid());

        // Добавляем и валидируем новые
        newContacts.forEach(contact -> {
            contactValidator.validateContact(contact);
            contact.setPerson(person);
            contactRepository.save(contact);
        });
    }

    public Contact addContact (Person person, Contact contact) {
        contactValidator.validateContact(contact);
        contact.setPerson(person);
        return contactRepository.save(contact);
    }

    public void removeContact (Person person, UUID contactId) {
        contactRepository.deleteByPersonUuidAndContactUuid(person.getUuid(), contactId);
    }
}
