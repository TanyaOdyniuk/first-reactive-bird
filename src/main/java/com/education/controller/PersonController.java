package com.education.controller;

import com.education.model.Person;
import com.education.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/person")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable("id") String id) {
        return personService.getPersonById(id);
    }

    @GetMapping
    public List<Person> getPersonsByQuery(@RequestParam("query") String query) {
        return personService.getPersonsByQuery(query);
    }

    @PostMapping
    public Person savePerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

}
