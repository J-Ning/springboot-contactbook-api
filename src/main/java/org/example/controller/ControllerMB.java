package org.example.controller;

import org.example.model.Person;
import org.example.service.ContactBookServiceMB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("/mybatis")
public class ControllerMB {

    private final ContactBookServiceMB contactBookServiceMB;

    @Autowired
    public ControllerMB( ContactBookServiceMB contactBookServiceMB) { this.contactBookServiceMB=contactBookServiceMB; }

    @GetMapping("/readAll")
    public List<Person> readAll() { return contactBookServiceMB.readAll(); }

    @GetMapping("/readByName/{name}")
    public Optional<Person> readByName(@PathVariable String name) { return contactBookServiceMB.readByName(name); }

    @PostMapping("/create")
    public List<Person> create(@RequestBody Person person){
        contactBookServiceMB.create(person);
        return readAll();
    }

    @PutMapping("/updateAll")
    public List<Person> updateAll(@RequestBody Person person){
        contactBookServiceMB.updateAll(person);
        return readAll();
    }

    @PutMapping("/updatePhone/{name}")
    public List<Person> updatePhone(@PathVariable String name, @RequestBody String phone){
        contactBookServiceMB.updatePhone(phone);
        return readAll();
    }

    @DeleteMapping("/delete/{name}")
    public List<Person> delete(@PathVariable String name){
        contactBookServiceMB.delete(name);
        return readAll();
    }

}

//10.208.68.223
