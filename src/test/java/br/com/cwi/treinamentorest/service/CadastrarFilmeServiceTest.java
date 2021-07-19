package br.com.cwi.treinamentorest.service;

import br.com.cwi.treinamentorest.domain.Diretor;
import br.com.cwi.treinamentorest.domain.Filme;
import br.com.cwi.treinamentorest.repository.AtorRepository;
import br.com.cwi.treinamentorest.repository.DiretorRepository;
import br.com.cwi.treinamentorest.repository.FilmeRepository;
import br.com.cwi.treinamentorest.request.CadastrarFilmeRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

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

    @Captor
    private ArgumentCaptor<Filme> filmeCaptor;

    private CadastrarFilmeRequest request;

    @BeforeEach
    private void setup(){
        request = CadastrarFilmeRequest.builder()
                .titulo("titulo teste")
                .idDiretor(ID_DIRETOR)
                .idsAtores(IDS_ATORES)
                .build();
    }

    @Test
    public void excecaoQuandoDiretorNull(){
        try {
            cadastrarFilmeService.cadastrarFilme(request);
        } catch(ResponseStatusException  rse) {
            assertEquals(HttpStatus.NOT_FOUND, rse.getStatus());
        } finally {
            verify(diretorRepository).findById(ID_DIRETOR);
            verifyNoInteractions(atorRepository, filmeRepository);
        }
    }

    @Test
    public void okDiretorExisteAtoresVazio() {

        final Diretor diretorEsperado = Diretor.builder()
                .nome("Nome teste")
                .id(ID_DIRETOR)
                .build();

        // mockando resultado para o findById
        when(diretorRepository.findById(ID_DIRETOR)).thenReturn(Optional.of(diretorEsperado));

        // executando para realizar os injects
        cadastrarFilmeService.cadastrarFilme(request);

        // verificando se diretorRepository.findById foi chamado com ID_DIRETOR
        verify(diretorRepository).findById(ID_DIRETOR);

        // Verificando se atorRepository.findByIdIn foi chamado com request.getIdsAtores()
        verify(atorRepository).findByIdIn(request.getIdsAtores());

        // Capturando objeto salvo em filmeRepository.save para testes logo abaixo
        verify(filmeRepository).save(filmeCaptor.capture());

        Filme queFoiSalvo = filmeCaptor.getValue();
        assertEquals(request.getTitulo(), queFoiSalvo.getTitulo());
        assertEquals(diretorEsperado, queFoiSalvo.getDiretor());
        assertTrue(queFoiSalvo.getAtores().isEmpty());

    }
}