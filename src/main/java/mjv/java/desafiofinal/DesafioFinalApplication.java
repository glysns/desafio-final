package mjv.java.desafiofinal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import mjv.java.desafiofinal.sample.ApplicationSample;

@SpringBootApplication
public class DesafioFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioFinalApplication.class, args);
		System.out.println("Zezinho ... ");
	}
	
	@Bean
    public CommandLineRunner run(ApplicationSample bean) throws Exception {
        return args -> {
           //bean.cadastroSample();
        };
    }
}
