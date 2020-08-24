package com.dipnoi.CSVreader.model;

import lombok.*;
import javax.persistence.*;
import java.sql.Date;
import org.springframework.stereotype.Component;


/**
 * Object that represents single person
 */
@Getter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "person")
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Component
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id", nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(name = "person_name")
    private String name;

    @Column(name = "person_surname")
    private String surname;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;
}
