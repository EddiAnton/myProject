package com.eddiAnton;

import com.eddiAnton.model.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Программа запущена!");

//        PhoneBook phoneBook = new PhoneBook();
//        List<Person> phoneBookPersonList = new ArrayList<>();
//        Person person = new Person("Иванов", "Иван", "Иванович");
//        Contact contact1 = new Phone(ContactType.PHONE, "mobile", "+79139139999");
//        Contact contact2 = new Email(ContactType.EMAIL, "personal", "test@test.ru");
//        List<Contact> contacts = new ArrayList<>();
//        contacts.add(contact1);
//        contacts.add(contact2);
//        person.setPersonContacts(contacts);
//        phoneBookPersonList.add(person);
//
//        phoneBook.setPersonList(phoneBookPersonList);
//        System.out.println(phoneBook.toString());

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

        PhoneBook phoneBook = context.getBean("phoneBook", PhoneBook.class);
        System.out.println(phoneBook.toString());

        context.close();
    }
}
