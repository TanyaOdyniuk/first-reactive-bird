package com.education.service;

import com.education.model.Person;

import java.util.List;


public interface PersonService {
    Person savePerson(Person person);

    Person getPersonById(String id);

    List<Person> getPersonsByQuery(String query);
}
