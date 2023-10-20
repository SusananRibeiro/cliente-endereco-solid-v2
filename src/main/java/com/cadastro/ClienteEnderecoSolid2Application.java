package com.cadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cadastro")
public class ClienteEnderecoSolid2Application {

	public static void main(String[] args) {
		SpringApplication.run(ClienteEnderecoSolid2Application.class, args);
	}

}
