package com.rw.eyeGov.config;

import org.springframework.context.annotation.Configuration;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
@Configuration
@SecurityScheme(name = "Bearer Authentication", type = SecuritySchemeType.HTTP, bearerFormat = "JWT", scheme = "bearer")
@OpenAPIDefinition(info = @Info(title = "EYE GOV API", version = "1.0", description = "EYE GOV api docs", contact = @Contact(url = "EYE GOV", name = "Dean Daryl MURENZI", email = "d.murenzi@alustudent.com")))
public class OpenAPI30Configuration {

}