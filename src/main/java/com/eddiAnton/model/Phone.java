package com.eddiAnton.model;

public class Phone extends Contact {
    private final String phoneType;
    private String phoneNumber;

    public Phone(ContactType contactType, String phoneType, String phoneNumber) {
        super(contactType);
        this.phoneType = phoneType;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneType='" + phoneType + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
