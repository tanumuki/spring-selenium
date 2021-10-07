package com.jiosaavn.web.springselenium.kelvin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy
@Service
public class LoggerService {

    @Bean
    public Logger getLogger() {
        Logger logger = LoggerFactory.getLogger(LoggerService.class);
        return logger;
    }
}
