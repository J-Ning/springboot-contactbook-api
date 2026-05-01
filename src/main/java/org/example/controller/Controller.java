package org.example.controller;

import org.example.entity.Person;
import org.example.service.ContactBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jpa")
public class Controller {

    private final ContactBookService contactBookService;

    @Autowired
    public Controller(ContactBookService contactBookService) {
        this.contactBookService=contactBookService;
    }

    @PostMapping("/create")
    public List<Person> create(@RequestBody Person person) { return contactBookService.create(person); }

    @GetMapping("/read")
    public List<Person> readAll() { return contactBookService.readAll(); }

    @GetMapping("/readByName")
    public Optional<Person> readByName(@RequestParam String name) { return contactBookService.readByName(name); }

    @GetMapping("/readByNameReturnPhone")
    public String readByNameReturnPhone(@RequestParam String name){
        return contactBookService.readByNameReturnPhone(name);
    }

    @GetMapping("/readByPhone")
    public Optional<Person> readByPhone(@RequestParam String phone) { return contactBookService.readByPhone(phone); }

    @DeleteMapping("/deleteByName")
    public List<Person> deleteByName(@RequestParam String name) { return contactBookService.deleteByName(name); }

    @DeleteMapping("/deleteByPhone")
    public List<Person> deleteByPhone(@RequestParam String phone) { return contactBookService.deleteByPhone(phone); }

    @PutMapping("/updatePhoneNumber")
    public Optional<Person> updatePhoneNumber(@RequestParam String name, @RequestBody String phone){
        return contactBookService.updatePhoneNumber(name, phone);
    }

    /* temp ~~~~~~
    @PostMapping ("/add")
    public HashMap<String, Integer> add(@RequestBody NameNumber nameNumber){
        return contactBookService.add(nameNumber.name, nameNumber.value);

    }

    @PostMapping ("/delete")
    public HashMap<String, Integer> delete(@RequestBody NameNumber nameNumber){
        return contactBookService.delete(nameNumber.name);

    }

    @PostMapping ("/change")
    public HashMap<String, Integer> change(@RequestBody NameNumber nameNumber){
        return contactBookService.change(nameNumber.name, nameNumber.value);

    }

    @PostMapping ("/search")
    public Integer search(@RequestBody NameNumber nameNumber){
        return contactBookService.search(nameNumber.name);

    }
    */

//    @PostMapping
//    public void sort(@RequestBody List<Integer> x) {
////        sortService.SortService();
//        System.out.println("hi there");
//    }
}

//10.208.68.223
