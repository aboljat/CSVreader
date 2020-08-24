package com.dipnoi.CSVreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.dipnoi.CSVreader")
@SpringBootApplication
@EnableJpaRepositories("com.dipnoi.CSVreader.repository")
@EntityScan("com.dipnoi.CSVreader.model")
@ComponentScan(basePackages = {"com.dipnoi.CSVreader.*"})
public class CsvReaderApplication {
	public static void main(String[] args) {
		SpringApplication.run(CsvReaderApplication.class, args);
	}
}
