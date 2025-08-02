package com.eddiAnton.validation;

import com.eddiAnton.exception.InvalidDataException;
import com.eddiAnton.model.Address;
import com.eddiAnton.model.Email;
import com.eddiAnton.model.Person;
import com.eddiAnton.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonValidator {

    @Autowired
    private ContactValidator contactValidator;

    public void validate(Person person) {
        if (person == null) {
            throw new InvalidDataException("Персона не может быть null");
        }

        if (person.getPersonContacts() == null || person.getPersonContacts().isEmpty()) {
            throw new InvalidDataException("Персона должна иметь хотя бы один контакт");
        }

        person.getPersonContacts().forEach(contact -> {
            if (contact instanceof Phone) {
                contactValidator.validatePhoneNumber(((Phone) contact).getPhoneNumber());
            } else if (contact instanceof Email) {
                contactValidator.validateEmail(((Email) contact).getEmail());
            }else if (contact instanceof Address) {
                contactValidator.validateAddress((Address) contact);
            }
        });
    }
}
