package com.jiosaavn.web.springselenium.kelvin.config;

import com.github.javafaker.Faker;
import com.jiosaavn.web.springselenium.kelvin.annotations.LazyConfiguration;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class FakerConfig {


    @Bean
    public Faker getFaker(){
        return new Faker();
    }

}
