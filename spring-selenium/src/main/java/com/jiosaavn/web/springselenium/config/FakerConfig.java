package com.jiosaavn.web.springselenium.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;

public class FakerConfig {


    @Bean
    public Faker getFaker(){
        return new Faker();
    }

}
