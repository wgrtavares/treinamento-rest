package br.com.cwi.treinamentorest.controller.api;

import br.com.cwi.treinamentorest.request.CadastrarFilmeRequest;
import br.com.cwi.treinamentorest.request.ModificarFilmeRequest;
import br.com.cwi.treinamentorest.response.ListarFilmesResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Operações com filmes")
public interface FilmesControllerAPI {

    @ApiOperation(value = "Obter a lista de filmes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de filmes cadastrados"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Proibido"),
            @ApiResponse(code = 404, message = "Não encontrado"),
    })
    ListarFilmesResponse listarFilmes();

    @PostMapping("/")
    void cadastrarFilme(@RequestBody final CadastrarFilmeRequest request);

    @PutMapping("/{id}")
    void modificarFilme(@PathVariable Long id, @RequestBody final ModificarFilmeRequest request);

    @DeleteMapping("/{id}")
    void deletarFilme(@PathVariable final Long id);

}
