DROP TABLE IF EXISTS person;
CREATE TABLE app_user (
    person_id BIGINT PRIMARY KEY auto_increment,
    person_name VARCHAR(128),
    person_surname VARCHAR(128),
    date_of_birth DATE
);s