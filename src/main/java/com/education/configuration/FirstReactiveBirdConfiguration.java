package com.education.configuration;

import com.education.repository.PersonRepository;
import com.education.service.PersonService;
import com.education.service.impl.PersonServiceImpl;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class FirstReactiveBirdConfiguration {

    @Bean
    DataSource dataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost/postgres?user=postgres&password=password");
        dataSource.setUser("postgres");
        dataSource.setPassword("password");
        dataSource.setDatabaseName("postgres");
        return dataSource;
    }

    @Bean
    JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    PersonRepository personRepository(JdbcTemplate jdbcTemplate) {
        return new PersonRepository(jdbcTemplate);
    }

    @Bean
    PersonService personService(PersonRepository personRepository) {
        return new PersonServiceImpl(personRepository);
    }

}
