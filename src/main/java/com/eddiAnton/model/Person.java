package com.eddiAnton.model;

import java.util.List;
import java.util.UUID;

public class Person {
    private final UUID uuid;
    private final String firstName;
    private final String lastName;
    private final String surname;
    private List<Contact> personContacts;

    public Person(String firstName, String lastName, String surname) {
        this.uuid = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.surname = surname;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSurname() {
        return surname;
    }

    public List<Contact> getPersonContacts() {
        return personContacts;
    }

    public void setPersonContacts(List<Contact> personContacts) {
        this.personContacts = personContacts;
    }

    @Override
    public String toString() {
        return "Person{" +
                "uuid=" + uuid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", surname='" + surname + '\'' +
                ", personContacts=" + personContacts +
                '}';
    }
}
