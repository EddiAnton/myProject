package com.eddiAnton.validation;

import com.eddiAnton.exception.InvalidDataException;
import com.eddiAnton.model.Address;
import org.springframework.stereotype.Component;

@Component
public class ContactValidator {
    private static final String PHONE_REGEX = "^\\+?[0-9]{5,15}$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches(PHONE_REGEX)) {
            throw new InvalidDataException("Невалидный телефонный номер");
        }
    }

    public void validateEmail(String email) {
        if (email == null || !email.matches(EMAIL_REGEX)) {
            throw new InvalidDataException("Невалидный емайл");
        }
    }

    public void validateAddress(Address address) {
        // Базовая валидация адреса
        if (address.getCity() == null ||
            address.getCity().trim().isEmpty() ||
            address.getStreet() == null ||
            address.getStreet().trim().isEmpty() ||
            address.getHouse() == null ||
            address.getHouse().trim().isEmpty()) {
            throw new IllegalArgumentException("Невалидный адрес");
        }
    }
}
