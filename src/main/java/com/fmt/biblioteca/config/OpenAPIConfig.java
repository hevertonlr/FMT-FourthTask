package com.fmt.biblioteca.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI myOpenAPI(){
        Info info = new Info()
                .title("Biblioteca")
                .version("1.0")
                .description("Este é um exemplo de API que simula uma biblioteca.");
        return new OpenAPI().info(info);
    }
}
