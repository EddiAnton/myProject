package com.eddiAnton;

import com.eddiAnton.configuration.AppConfig;
import com.eddiAnton.model.*;
import com.eddiAnton.service.ContactService;
import com.eddiAnton.service.PhoneBookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Программа запущена!");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PhoneBookService phoneBookService = context.getBean(PhoneBookService.class);
        ContactService contactService = context.getBean(ContactService.class);

        Person person1 = new Person("Ivan", "Ivanovich", "Ivanov");
        person1.setPersonContacts(List.of(
                new Phone(ContactType.PHONE, "mobile", "+1234567890"),
                new Email(ContactType.EMAIL, "work", "ivanov@example.ru")
        ));

        Person person2 = new Person("Petr", "Petrovich", "Petrov");
        person2.setPersonContacts(List.of(
                new Phone(ContactType.PHONE, "mobile", "+0987654321"),
                new Email(ContactType.EMAIL, "private", "petrov@example.ru")
        ));

        phoneBookService.addPerson(person1);
        phoneBookService.addPerson(person2);
        System.out.println("Persons count: " + phoneBookService.getPersonCount());
        phoneBookService.showAllPersons();

        contactService.addContact(person1,
                new Email(ContactType.EMAIL, "work", "ivanov@example.com"));
        phoneBookService.showAllPersons();

        contactService.addContact(person1,
                new Address(ContactType.ADDRESS, "Novosibirsk", "Lenina", "1"));
        phoneBookService.showAllPersons();

        phoneBookService.removePerson("Petr", "Petrov");
        phoneBookService.showAllPersons();

    }
}
