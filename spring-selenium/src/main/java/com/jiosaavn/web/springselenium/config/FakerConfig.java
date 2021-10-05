package com.jiosaavn.web.springselenium.config;

import com.github.javafaker.Faker;
import com.jiosaavn.web.springselenium.annotations.LazyConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@LazyConfiguration
public class FakerConfig {


    @Bean
    public Faker getFaker(){
        return new Faker();
    }

}
