package com.eddiAnton.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "emails")
@Getter
@Setter
@NoArgsConstructor
public class Email extends Contact {
    private String emailType;
    private String email;

    @Override
    public ContactType getContactType() {
        return ContactType.EMAIL;
    }
}
