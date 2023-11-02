package com.test;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringCloudApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context= SpringApplication.run(SpringCloudApplication.class, args);
    }
}
