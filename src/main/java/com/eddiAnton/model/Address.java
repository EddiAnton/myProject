package com.eddiAnton.model;

public class Address extends Contact {
    private String city;
    private String street;
    private String house;
    private String apartment;

    public Address(ContactType contactType, String city, String street, String house, String apartment) {
        super(contactType);
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }

    public Address(ContactType contactType, String city, String street, String house) {
        super(contactType);
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", apartment='" + apartment + '\'' +
                '}';
    }
}
