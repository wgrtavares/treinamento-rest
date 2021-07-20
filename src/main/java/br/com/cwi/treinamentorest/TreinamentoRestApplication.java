package br.com.cwi.treinamentorest;

import br.com.cwi.treinamentorest.response.ConsultarOmdbApiResponse;
import br.com.cwi.treinamentorest.service.ConsultarOmdbApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TreinamentoRestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TreinamentoRestApplication.class, args);
	}

	@Autowired
	private ConsultarOmdbApiService consultarOmdbApiService;

	@Override
	public void run(String... args) throws Exception {
		ResponseEntity<ConsultarOmdbApiResponse> resultadoConsulta =
				consultarOmdbApiService.consultarApi("Avengers");
	}
}
