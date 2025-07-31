package com.eddiAnton;

import com.eddiAnton.configuration.AppConfig;
import com.eddiAnton.model.*;
import com.eddiAnton.service.PhoneBookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Программа запущена!");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PhoneBookService service = context.getBean(PhoneBookService.class);

        Person person = new Person("Ivan", "Ivanovich", "Ivanov");
        person.setPersonContacts(List.of(
                new Phone(ContactType.PHONE, "mobile", "+1234567890"),
                new Email(ContactType.EMAIL, "work", "ivanov@example.ru")
        ));

        service.addPerson(person);
        service.showAllPersons();
    }
}
