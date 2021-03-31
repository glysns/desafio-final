package com.mjv.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableFeignClients
public class DesafioApplication {
	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner run(ApplicationSample bean) throws Exception {
//		return args -> {
//			bean.criarCadastro();
//		};
//	}

}
