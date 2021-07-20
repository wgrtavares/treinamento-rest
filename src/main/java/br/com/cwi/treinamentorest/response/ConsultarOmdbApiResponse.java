package br.com.cwi.treinamentorest.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultarOmdbApiResponse implements Serializable {

    private static final long serialVersionUID = -7419144246628911824L;

    @JsonProperty("Title")
    private String titulo;

    @JsonProperty("Year")
    private String ano;

    @JsonProperty("Released")
    private String dataLancamento;

    @JsonProperty("Runtime")
    private String duracao;

    @JsonProperty("Genre")
    private String genero;

}
