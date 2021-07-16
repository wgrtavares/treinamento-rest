package br.com.cwi.treinamentorest.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class AdicionarDiretorRequest implements Serializable {

    private static final long serialVersionUID = 3138285270587022556L;

    private String nome;
}
