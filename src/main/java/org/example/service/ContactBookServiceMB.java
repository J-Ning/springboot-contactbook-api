package org.example.service;

import org.example.model.Person;
import org.example.mapper.PersonMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactBookServiceMB {

    private final PersonMapper personMapper;

    public ContactBookServiceMB(PersonMapper personMapper) { this.personMapper = personMapper; }

    public List<Person> readAll() { return personMapper.readAll(); }

    public Optional<Person> readByName(String name) { return personMapper.readByName(name); }

    public void create(Person person) { personMapper.create(person); }

    public void updateAll(Person person) { personMapper.updateAll(person); }

    public void updatePhone(String phone) { personMapper.updatePhone(phone); }

    public void delete(String name) { personMapper.delete(name); }

}
