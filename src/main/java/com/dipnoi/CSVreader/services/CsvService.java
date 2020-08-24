package com.dipnoi.CSVreader.services;


import com.dipnoi.CSVreader.model.Person;
import com.dipnoi.CSVreader.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service, used to add single, or retrieve all Persons from database
 */
@Service
public class CsvService {

    private final PersonRepository personRepository;

    @Autowired
    public CsvService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public void insertPerson(Person person){
        personRepository.save(person);
    }

    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }
}

