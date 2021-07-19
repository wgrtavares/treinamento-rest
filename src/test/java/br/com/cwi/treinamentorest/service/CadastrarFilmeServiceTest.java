package br.com.cwi.treinamentorest.service;

import br.com.cwi.treinamentorest.repository.AtorRepository;
import br.com.cwi.treinamentorest.repository.DiretorRepository;
import br.com.cwi.treinamentorest.repository.FilmeRepository;
import br.com.cwi.treinamentorest.request.CadastrarFilmeRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

@ExtendWith({MockitoExtension.class})
public class CadastrarFilmeServiceTest {

    private static final Long ID_DIRETOR = 1L;
    private static final List<Long> IDS_ATORES = Arrays.asList(1L, 2L);

    @InjectMocks
    private CadastrarFilmeService cadastrarFilmeService;

    @Mock
    private FilmeRepository filmeRepository;

    @Mock
    private DiretorRepository diretorRepository;

    @Mock
    private AtorRepository atorRepository;

    private CadastrarFilmeRequest cadastrarFilmeRequest;

    @BeforeEach
    private void setup(){
        cadastrarFilmeRequest = CadastrarFilmeRequest.builder()
                .titulo("titulo teste")
                .idDiretor(ID_DIRETOR)
                .idsAtores(IDS_ATORES)
                .build();
    }

    @Test
    public void excecaoQuandoDiretorNull(){
        try {
            cadastrarFilmeService.cadastrarFilme(cadastrarFilmeRequest);
        } catch(ResponseStatusException  rse) {
            assertEquals(HttpStatus.NOT_FOUND, rse.getStatus());
            throw rse;
        } finally {
            verify(diretorRepository).findById(ID_DIRETOR);
            verifyNoInteractions(atorRepository, filmeRepository);
        }
    }
}