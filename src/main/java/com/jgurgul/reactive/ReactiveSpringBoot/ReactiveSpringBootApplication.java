package com.jgurgul.reactive.ReactiveSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class ReactiveSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveSpringBootApplication.class, args);
    }


}
