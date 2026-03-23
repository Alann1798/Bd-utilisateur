package alann.spr.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger {
    @Bean
    public OpenAPI customOpenAPI(){
        return  new OpenAPI()
                .info(new Info()
                        .title("Gestion des etulisateurs ")
                        .version("1.01")
                        .description("Documentation de L'API CRUD des utilisateur "));
    }

}
