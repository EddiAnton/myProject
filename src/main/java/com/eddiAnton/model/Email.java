package com.eddiAnton.model;

public class Email extends Contact {
    private final String emailType;
    private String email;

    public Email(ContactType contactType, String emailType, String email) {
        super(contactType);
        this.email = email;
        this.emailType = emailType;
    }

    public String getEmailType() {
        return emailType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Email{" +
                "emailType='" + emailType + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
