package com.swagger.configuration;


import org.springframework.http.HttpHeaders;

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
        title = "API CLUBES",
        description = "Our app provides a concise listing of football team names",
        termsOfService = "www.example.com/term_of_Serivce",
        version = "1.0.0",
        contact = @Contact(
            name = "Diego Ortiz",
            url = "https://diegoortiz27.github.io/MyRepository-Client-/",
            email = "example@gmail.com"

        ),
        license = @License(
            name = "Use License Example",
            url = "www.example.com/license"
        )
    ),
    servers = {
        @Server(
            url =  "http://localhost:8080",
            description = "DEV SERVER"
        ),
        @Server(
            url =  "https:prod-enviroment.com:8080",
            description = "PROD SERVER"
        )
    },
    security = @SecurityRequirement(
        name = "Security token"
    )
)
@SecurityScheme(
    name = "Security token",
    description =  "Access Token For My API",
    type = SecuritySchemeType.HTTP,
    paramName = HttpHeaders.AUTHORIZATION,
    in = SecuritySchemeIn.HEADER,
    scheme = "bearer",
    bearerFormat = "JWT"
)
public class SwaggerConfig {


}
