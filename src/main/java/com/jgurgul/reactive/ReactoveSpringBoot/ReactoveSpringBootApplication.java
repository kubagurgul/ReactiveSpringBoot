package com.jgurgul.reactive.ReactoveSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static java.lang.invoke.VarHandle.AccessMode.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class ReactoveSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactoveSpringBootApplication.class, args);
	}

}
