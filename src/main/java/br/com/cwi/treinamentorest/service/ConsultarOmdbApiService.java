package br.com.cwi.treinamentorest.service;

import br.com.cwi.treinamentorest.response.ConsultarOmdbApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static java.util.Objects.isNull;

@Service
public class ConsultarOmdbApiService {

    @Bean
    public  RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @Value("${omdb.apikey}")
    private String apiKey;
    private final String url = "http://www.omdbapi.com/?apikey=%s";
    private final String urlTitulo = String.join("&", url,  "t=%s");

    public ResponseEntity<ConsultarOmdbApiResponse> consultarApi(String titulo) {

        final String urlChamar = montarUrlTitulo(titulo);

        final ResponseEntity<ConsultarOmdbApiResponse> retornoApi =
                restTemplate.getForEntity(
                        urlChamar, ConsultarOmdbApiResponse.class
                );

        return retornoApi;
    }

    private String montarUrlTitulo(String titulo) {
        return String.format(urlTitulo, apiKey, titulo);
    }

}
