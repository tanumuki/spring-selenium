package com.jiosaavn.web.springselenium.annotations;


import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Lazy
@Component
@Scope("prototype")
public @interface Page {
}
