package com.jiosaavn.web.springselenium.LibraryTests;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@PropertySource("classpath:data/labels.properties")
public class LibraryDetails {


    @Value("${myLibrary.label}")
    private List<String> libraryLabels;

    public List<String> getLibraryLabels() {
        return libraryLabels;
    }

}
