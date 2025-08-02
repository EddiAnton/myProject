package com.eddiAnton.service;

import com.eddiAnton.exception.ValidationException;
import com.eddiAnton.model.*;
import com.eddiAnton.validation.ContactValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ContactService {
    private final ContactValidator contactValidator;

    @Autowired
    public ContactService (ContactValidator contactValidator) {
        this.contactValidator = contactValidator;
    }

    public void updateContacts (Person person, List<Contact> newContacts) {
        validateContacts(newContacts);
        person.setPersonContacts(new ArrayList<>(newContacts));
    }

    public void addContact (Person person, Contact newContact) {
        validateSingleContact(newContact);
        List<Contact> contacts = new ArrayList<>(person.getPersonContacts());
        contacts.add(newContact);
        person.setPersonContacts(contacts);
    }

    public void removeContact (Person person, UUID contactUuid) {
        person.getPersonContacts().removeIf(contact -> contact.getUuid().equals(contactUuid));
    }

    private void validateContacts(List<Contact> contacts) {
        if(contacts == null || contacts.isEmpty()) {
            throw new ValidationException("Список контактов не может быть пустым");
        }
        contacts.forEach(this::validateSingleContact);
    }

    private void validateSingleContact(Contact contact) {
        switch (contact.getContactType()) {
            case PHONE:
                Phone phone = (Phone) contact;
                contactValidator.validatePhoneNumber(phone.getPhoneNumber());
                break;
            case EMAIL:
                Email email = (Email) contact;
                contactValidator.validateEmail(email.getEmail());
                break;
            case ADDRESS:
                if (!(contact instanceof Address address)) {
                    throw new ValidationException("Контакт не является адресом");
                }
                contactValidator.validateAddress(address);
        }
    }
}
