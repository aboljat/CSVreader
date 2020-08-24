package com.dipnoi.CSVreader.repository;

import com.dipnoi.CSVreader.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Person repository
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
