package com.eddiAnton.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "persons")
@Getter
@Setter
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID uuid;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String surname;

    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
    private List<Contact> personContacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contact.setPerson(this);
        this.personContacts.add(contact);
    }

    public void removeContact(Contact contact) {
        personContacts.remove(contact);
        contact.setPerson(null);
    }
}
