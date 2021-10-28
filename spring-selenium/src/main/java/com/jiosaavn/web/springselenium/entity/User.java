package com.jiosaavn.web.springselenium.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private String firstName;
    private String lastName;
    private String customerEmail;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return customerEmail;
    }

    public void setEmailAddress(String emailAddress) {
        this.customerEmail = customerEmail;
    }



}
