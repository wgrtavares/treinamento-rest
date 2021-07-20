package br.com.cwi.treinamentorest.service;

import br.com.cwi.treinamentorest.mapper.ConsultarOmdbResponseMapper;
import br.com.cwi.treinamentorest.response.ConsultarOmdbApiResponse;
import br.com.cwi.treinamentorest.response.ConsultarOmdbResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import static java.util.Objects.isNull;

@Service
@Slf4j
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

    public ConsultarOmdbResponse consultarPorTitulo(String titulo) {

        try {
            return new ConsultarOmdbResponseMapper().apply(
                    restTemplate.getForEntity(montarUrlTitulo(titulo), ConsultarOmdbApiResponse.class).getBody()
            );
        } catch (final HttpStatusCodeException hsce) {
            log.error("Erro na chamada para OMDB API", hsce);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, hsce.getResponseBodyAsString());
        }
    }

    private String montarUrlTitulo(String titulo) {
        return String.format(urlTitulo, apiKey, titulo);
    }
}
