package com.dipnoi.CSVreader.resources;

import com.dipnoi.CSVreader.model.Person;
import com.dipnoi.CSVreader.services.CsvService;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


@Component
@Path("/")
/**
 * Class is used as REST resource, for inserting and viewing all person in application
 */
public class PersonResource {

    private final CsvService csvService;

    @Autowired
    PersonResource(CsvService csvService) {
        this.csvService = csvService;
    }

    /**
     *Method receives one csv file as attachment, and reads all persons from file, and inserts them in database.
     * In case of exception while reading or parsing file 400 BAD REQUEST IS RETURNED
     */
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA_VALUE)
    @Path("/insert")
    public Response insertPersons(@FormDataParam("file") InputStream uploadedInputStream,
                                    @FormDataParam("file") FormDataContentDisposition fileDetails) {

        try (
                Reader reader = new InputStreamReader(uploadedInputStream);
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withHeader("Name", "Surname", "Date")
                        .withFirstRecordAsHeader()
                        .withTrim());
        ) {
            for (CSVRecord csvRecord : csvParser) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date date = sdf.parse(csvRecord.get("Date"));
                java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
                Person person = Person.builder().name(csvRecord.get("Name")).surname(csvRecord.get("Surname")).dateOfBirth(sqlStartDate).build();
                csvService.insertPerson(person);
            }
        } catch (IOException | ParseException e) {
            Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @Path("/getPersons")
    public Response insertPersons() {

        List<Person> allPersons = csvService.getAllPersons();
        return Response.status(Response.Status.OK)
                .entity(allPersons)
                .build();

    }
}
