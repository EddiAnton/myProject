package com.eddiAnton.model;

import jakarta.persistence.DiscriminatorValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "contacts")
@DiscriminatorValue("PHONE")
@Getter
@Setter
@NoArgsConstructor
public class Phone extends Contact {
    private String phoneType;
    private String phoneNumber;

    @Override
    public ContactType getContactType() {
        return ContactType.PHONE;
    }
}
