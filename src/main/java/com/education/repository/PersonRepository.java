package com.education.repository;

import com.education.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PersonRepository {

    private JdbcTemplate jdbcTemplate;

    private String GET_PERSON_BY_ID_QUERY = "select * from person where id = ?";
    private String INSERT_PERSON_QUERY = "insert into person (id, name, surname) values (?, ?, ?)";

    public PersonRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Person savePerson(Person person) {
        jdbcTemplate.update(
                INSERT_PERSON_QUERY,
                person.getId(),
                person.getName(),
                person.getSurname());
        return person;
    }

    public Person getPersonById(String id) {
        return jdbcTemplate.query(
                GET_PERSON_BY_ID_QUERY,
                new Object[]{id},
                (rs, rowNum) -> new Person(rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("surname"))
        ).iterator().next();

    }


    public List<Person> getPersonsByQuery(String query) {
        return jdbcTemplate.query(
                query,
                (rs, rowNum) -> new Person(rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("surname"))
        );
    }

}
