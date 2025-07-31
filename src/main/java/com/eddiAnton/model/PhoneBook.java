package com.eddiAnton.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PhoneBook {

    public PhoneBook(){
        System.out.println("Записная книжка создана");
    }

    private List<Person> personList = new ArrayList<>();

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
