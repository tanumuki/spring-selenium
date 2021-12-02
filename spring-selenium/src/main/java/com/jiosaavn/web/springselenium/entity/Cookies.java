package com.jiosaavn.web.springselenium.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cookies {

    @Id
    private String name;
    private String value;
    private String domain;

    public Cookies(){}

    public Cookies(String name, String value, String domain) {
        this.name = name;
        this.value = value;
        this.domain = domain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

//    public String getDomain() {
//        return domain;
//    }
//
//    public void setDomain(String domain) {
//        this.domain = domain;
//    }

}
