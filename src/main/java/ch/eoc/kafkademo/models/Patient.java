package ch.eoc.kafkademo.models;

import java.util.Date;


public class Patient {

    private String firstName;
    private String lastName;
    private Date birthDate;

    public Patient(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
}