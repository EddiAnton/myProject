package com.eddiAnton.service;

import com.eddiAnton.exception.PersonNotFoundException;
import com.eddiAnton.model.Person;
import com.eddiAnton.model.PhoneBook;
import com.eddiAnton.validation.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneBookService {
    private PhoneBook phoneBook;
    private final PersonValidator personValidator;

    @Autowired
    public PhoneBookService (PhoneBook phoneBook, PersonValidator personValidator) {
        this.phoneBook = phoneBook;
        this.personValidator = personValidator;
    }

    public void addPerson(Person person) {
        personValidator.validate(person);
        phoneBook.getPersonList().add(person);
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
