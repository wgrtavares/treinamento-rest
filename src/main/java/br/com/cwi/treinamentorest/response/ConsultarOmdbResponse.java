package br.com.cwi.treinamentorest.response;

import br.com.cwi.treinamentorest.domain.Ator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsultarOmdbResponse implements Serializable {

    private static final long serialVersionUID = 8715856817808328471L;

    private String titulo;

    private String ano;

    private String dataLancamento;

    private String duracao;

    private String genero;

    private List<Ator> atores;

}
