package inaf.boris.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(){

        return new OpenAPI()
                .info(new Info()
                        .title("API Gestion Utilisateur")
                        .contact(new Contact()
                                .name("651668174")
                                .email("bovour@gmail.com"))
                        .description("Documentation de l'API CRUD des Utilisateurs"));
    }

    }
