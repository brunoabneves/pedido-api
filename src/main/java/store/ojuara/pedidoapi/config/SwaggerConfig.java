package store.ojuara.pedidoapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

    @Value(value = "${swagger.app-version}")
    private String appVersion;
    @Value(value = "${swagger.app-description}")
    private String appDescription;
    @Value(value = "${swagger.contact-email}")
    private String contactEmail;
    @Value(value = "${swagger.contact-name}")
    private String contactName;
    @Value(value = "${swagger.contact-url}")
    private String contacUrl;

    private Contact contact() {
        Contact contact = new Contact();
        contact.setEmail(contactEmail);
        contact.setName(contactName);
        contact.setUrl(contacUrl);
        return contact;
    }
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("pedido-api")
                        .version(appVersion)
                        .description(appDescription)
                        .contact(this.contact())
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
