package org.example.service;

import org.example.entity.Person;
import org.example.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ContactBookService {

    private final PersonRepository personRepository;

    public ContactBookService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> readAll() { return personRepository.findAll(); }

    public Optional<Person> readByName(String name) { return personRepository.findById(name); }

    public String readByNameReturnPhone(String name) {
        return personRepository.readByNameReturnPhone(name);
    }

    public Optional<Person> readByPhone(String phone) { return personRepository.readByPhone(phone); }

    public List<Person> create(Person person) { return Collections.singletonList(personRepository.save(person)); }

    public Optional<Person> updatePhoneNumber(String name, String phone) {
        return personRepository.findById(name).map( Person person -> {
            person.setPhone(phone);
            return personRepository.save(person);
        });
    }

    @Transactional
    public List<Person> deleteByName(String name) {
        personRepository.deleteById(name);
        return readAll();
    }

    @Transactional
    public List<Person> deleteByPhone(String phone) {
        personRepository.deleteByPhone(phone);
        return readAll();
    }

}
