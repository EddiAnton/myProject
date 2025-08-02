package com.eddiAnton.service;

import com.eddiAnton.exception.PersonNotFoundException;
import com.eddiAnton.model.Person;
import com.eddiAnton.model.PhoneBook;
import com.eddiAnton.util.LoggingAspect;
import com.eddiAnton.validation.PersonValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PhoneBookService {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    private PhoneBook phoneBook;
    private final ContactService contactService;
    private final PersonValidator personValidator;

    @Autowired
    public PhoneBookService (PhoneBook phoneBook, ContactService contactService, PersonValidator personValidator) {
        this.phoneBook = phoneBook;
        this.contactService = contactService;
        this.personValidator = personValidator;
    }

    public void addPerson(Person person) {
        personValidator.validate(person);
        phoneBook.getPersonList().add(person);
    }

    public void removePerson(String firstName, String surname) {
        if (firstName == null || surname == null) {
            throw new IllegalArgumentException("Имя и Фамилия не могут быть пустыми");
        }

        boolean removed = phoneBook.getPersonList().removeIf(person ->
                person.getFirstName().equals(firstName) && person.getSurname().equals(surname));

        if (!removed) {
            throw new PersonNotFoundException(
                    String.format("Персона не найдена: %s %s", firstName, surname));
        }
        logger.info("Персона {} {} успешно удалена", firstName, surname);
    }

    private Person findPersonById(UUID personUuid) {
        return phoneBook.getPersonList().stream()
                .filter(p -> p.getUuid().equals(personUuid))
                .findFirst()
                .orElseThrow(() -> new PersonNotFoundException("Не нашлось персоны по uuid: " + personUuid));
    }

    public void showAllPersons() {
        List<Person> persons = phoneBook.getPersonList();
        if (persons == null || persons.isEmpty()) {
            throw new PersonNotFoundException("Персоны не найдены в записной книжке");
        }

        System.out.println("= Персоны в записной книжке =");
        persons.forEach(System.out::println);
    }

    public int getPersonCount() {
        return phoneBook.getPersonList().size();
    }
}
