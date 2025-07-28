package com.eddiAnton.model;

import java.util.UUID;

public class Contact {
    private final UUID uuid;
    private ContactType contactType;

    Contact(ContactType contactType) {
        this.uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactType='" + contactType + '\'' +
                '}';
    }
}
