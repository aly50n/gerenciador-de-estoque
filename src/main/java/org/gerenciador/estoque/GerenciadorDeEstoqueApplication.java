package org.gerenciador.estoque;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(servers= {@Server(url="/", description = "defult server URL")})
public class GerenciadorDeEstoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorDeEstoqueApplication.class, args);
	}

}
