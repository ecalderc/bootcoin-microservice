package com.nttdata.bootcamp.bootcoin;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Bootcoin API", version = "1.0", description = "Documentation Bootcoin API v1.0"))
public class BootcoinApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootcoinApplication.class, args);
    }

}
