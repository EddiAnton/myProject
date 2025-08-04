package com.eddiAnton.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
public class Address extends Contact {
    private String city;
    private String street;
    private String house;
    private String apartment;

    @Override
    public ContactType getContactType() {
        return ContactType.ADDRESS;
    }
}
