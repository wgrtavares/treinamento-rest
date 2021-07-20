package br.com.cwi.treinamentorest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TreinamentoRestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TreinamentoRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
