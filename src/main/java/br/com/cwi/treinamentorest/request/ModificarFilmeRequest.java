package br.com.cwi.treinamentorest.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ModificarFilmeRequest implements Serializable {
    private static final long serialVersionUID = 2890081244466441916L;
    private String titulo;
    private Long idDiretor;
    private List<Long> idsAtores;
}
