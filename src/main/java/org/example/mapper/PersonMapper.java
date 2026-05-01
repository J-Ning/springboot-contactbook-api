package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.model.Person;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PersonMapper {

    List<Person> readAll();

    void create(Person person);

    void updateAll(Person person);

    void updatePhone(String phone);

    void delete(String name);

    Optional<Person> readByName(String name);
}
