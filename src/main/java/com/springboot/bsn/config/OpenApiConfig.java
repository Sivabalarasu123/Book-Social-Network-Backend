package com.springboot.bsn.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(name = "Siva",
                        email = "siva@email.com"),
                description = "OpenAPI documentation for Spring Security",
                title = "OpenAPI Specification - Siva",
                version = "1.0.0",
                license = @License(name = "License name"),
                termsOfService = "Terms of Service"
        ),
        servers = {
                @Server(description = "Local ENV",
                        url = "http://localhost:8080/api/v1"),
                @Server(description = "Prod ENV",
                        url = "https://book-social-network.com")
        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearerToken",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER)
public class OpenApiConfig {
}

