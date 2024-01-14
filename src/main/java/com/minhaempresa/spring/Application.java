package com.minhaempresa.spring;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Spring WS - API", version = "1.0", description = "Serviços disponíveis"))
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
