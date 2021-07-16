package br.com.cwi.treinamentorest.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class InserirAtorRequest implements Serializable {
    private static final long serialVersionUID = -1629083219601006387L;
    private String nome;
}
