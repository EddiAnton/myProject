package com.eddiAnton.controller;

import com.eddiAnton.model.Person;
import com.eddiAnton.service.PhoneBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PhoneBookService phoneBookService;

    @GetMapping
    public List<Person> getAllPersons() {
        return phoneBookService.findAllPersons();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable UUID id) {
        return phoneBookService.findPersonByUuid(id);
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return phoneBookService.addPerson(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable UUID id) {
        phoneBookService.removePerson(id);
    }
}
