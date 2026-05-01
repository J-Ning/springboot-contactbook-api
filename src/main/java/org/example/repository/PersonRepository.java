package org.example.repository;

import org.example.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
//Spring Data JPA, allow database operations without writing SQL
public interface PersonRepository extends JpaRepository<Person, String> {
    void deleteByPhone(String phone);

    Optional<Person> readByPhone(String Phone);

    @Query("SELECT p.phone FROM Person p WHERE p.name = :name")
    String readByNameReturnPhone(@Param("name")String name);
}
