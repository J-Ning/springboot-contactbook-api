package org.example.service;

import org.example.entity.Person;
import org.example.repository.PersonRepository;
import org.springframework.transaction.annotation.Transactional;

abstract class LockSampleAbstract {

    LockSampleAbstract(PersonRepository personRepository) { this.personRepository = personRepository; }

    public String hello() { return "Hello"; }

    public void DeadLockSample(Object lockA, Object lockB) {
    }

    public void reentrantLock() {

    }

    private final PersonRepository personRepository;

    @Transactional
    public void transactionalTestSucess(Person person1, Person person2) {
        personRepository.save(person1);
        personRepository.save(person2);
    }

    @Transactional
    public void transactionalTestRollback(Person person1, Person person2) {
        personRepository.save(person1);
        personRepository.save(person2);
        throw new RuntimeException("error; force roll-back");
    }

}
