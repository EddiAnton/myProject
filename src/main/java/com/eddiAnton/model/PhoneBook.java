package com.eddiAnton.model;

import java.util.List;

public class PhoneBook {
    private List<Person> personList;

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "personList=" + personList +
                '}';
    }
}
