package com.eddiAnton.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PhoneBook {
    public PhoneBook(){
        System.out.println("Phone book is created");
    }

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
