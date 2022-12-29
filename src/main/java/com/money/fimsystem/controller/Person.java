package com.money.fimsystem.controller;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "person")
public class Person {

    private String username;
    private Integer age;

}
