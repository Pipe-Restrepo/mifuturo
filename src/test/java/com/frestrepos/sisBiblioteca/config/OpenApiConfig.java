package com.frestrepos.sisBiblioteca.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Documentación de la API para el sistema de biblioteca",
                version = "1.0",
                description = "A continuación la documentación de la API de mi sistema de biblioteca."
        )
)
public class OpenApiConfig {
}