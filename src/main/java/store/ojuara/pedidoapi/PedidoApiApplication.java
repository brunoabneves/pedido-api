package store.ojuara.pedidoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
//@EnableFeignClients
public class PedidoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedidoApiApplication.class, args);
	}

}
