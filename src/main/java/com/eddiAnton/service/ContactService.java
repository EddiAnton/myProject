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

        // Сначала сохраняем персону, если она новая
        if (person.getUuid() == null) {
            person = personRepository.save(person);
        }
        contact.setPerson(person);

        // Устанавливаем тип контакта
        if (contact instanceof Phone) {
            contact.setContactType(ContactType.PHONE);
        } else if (contact instanceof Email) {
            contact.setContactType(ContactType.EMAIL);
        } else if (contact instanceof Address) {
            contact.setContactType(ContactType.ADDRESS);
        }

        return contactRepository.save(contact);
    }

    public void removeContact (Person person, UUID contactId) {
        contactRepository.deleteByPersonUuidAndContactUuid(person.getUuid(), contactId);
    }
}
