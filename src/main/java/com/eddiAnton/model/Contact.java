package com.eddiAnton.model;

import java.util.UUID;

public class Contact {
    private final UUID uuid;
    private final ContactType contactType;

    public Contact(ContactType contactType) {
        this.uuid = UUID.randomUUID();
        this.contactType = contactType;
    }

    public UUID getUuid() {
        return uuid;
    }

    public ContactType getContactType() {
        return contactType;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactType='" + contactType + '\'' +
                '}';
    }
}
