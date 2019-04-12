package com.education.service.impl;

import com.education.model.Person;
import com.education.repository.PersonRepository;
import com.education.service.PersonService;

import java.util.List;


public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.savePerson(person);
    }

    @Override
    public Person getPersonById(String id) {
        return personRepository.getPersonById(id);
    }

    @Override
    public List<Person> getPersonsByQuery(String query) {
        return personRepository.getPersonsByQuery(query);
    }
}
