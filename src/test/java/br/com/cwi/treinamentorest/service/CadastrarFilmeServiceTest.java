package br.com.cwi.treinamentorest.service;

import br.com.cwi.treinamentorest.domain.Ator;
import br.com.cwi.treinamentorest.domain.Diretor;
import br.com.cwi.treinamentorest.domain.Filme;
import br.com.cwi.treinamentorest.repository.AtorRepository;
import br.com.cwi.treinamentorest.repository.DiretorRepository;
import br.com.cwi.treinamentorest.repository.FilmeRepository;
import br.com.cwi.treinamentorest.request.CadastrarFilmeRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class})
public class CadastrarFilmeServiceTest {

    private Long idDiretor = 1L;
    private List<Long> idsAtores = Arrays.asList(1L, 2L);

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

    private Diretor diretorEsperado;
    private List<Ator> atoresEsperados;

    @BeforeEach
    private void setup(){

        idDiretor = 1L;
        idsAtores = Arrays.asList(1L, 2L);

        request = CadastrarFilmeRequest.builder()
                .titulo("titulo teste")
                .idDiretor(idDiretor)
                .idsAtores(idsAtores)
                .build();

        diretorEsperado = Diretor.builder()
                .nome("Nome teste")
                .id(idDiretor)
                .build();

        atoresEsperados = Arrays.asList(
                new Ator(1L, "Ator Um"),
                new Ator(2L, "Ator Dois")
        );
    }

    @Test
    public void excecaoQuandoDiretorNull(){
        try {
            cadastrarFilmeService.cadastrarFilme(request);
        } catch(EntityNotFoundException enfe) {
            assertEquals("Diretor não encontrado.", enfe.getMessage());
        } finally {
            verify(diretorRepository).findById(idDiretor);
            verifyNoInteractions(atorRepository, filmeRepository);
        }
    }

    @Test
    public void excecaoQuandoTodosAtoresNaoEncontrados() {
        when(diretorRepository.findById(idDiretor)).thenReturn(Optional.of(diretorEsperado));

        try {
            cadastrarFilmeService.cadastrarFilme(request);
        } catch (EntityNotFoundException enfe) {
            assertEquals("Ator(es) não encontrado(s). id=[1, 2]", enfe.getMessage());
        } finally {
            verify(diretorRepository).findById(idDiretor);
            verify(atorRepository).findByIdIn(idsAtores);
            verifyNoInteractions(filmeRepository);
        }
    }

    @Test
    public void excecaoQuandoUmAtorNaoEncontrado() {

        when(diretorRepository.findById(idDiretor))
                .thenReturn(
                        Optional.of(diretorEsperado));
        when(atorRepository.findByIdIn(idsAtores))
                .thenReturn(
                        Collections.singletonList(new Ator(1L, "Ator teste")));

        try {

            cadastrarFilmeService.cadastrarFilme(request);

        } catch (EntityNotFoundException enfe) {
            assertEquals("Ator(es) não encontrado(s). id=[2]", enfe.getMessage());
        } finally {
            verify(diretorRepository).findById(idDiretor);
            verify(atorRepository).findByIdIn(idsAtores);
            verifyNoInteractions(filmeRepository);
        }
    }

    @Test
    public void okDiretorExisteAtoresVazio() {

        request.setIdsAtores(new ArrayList<>());

        // mockando resultado para o findById
        when(diretorRepository.findById(idDiretor)).thenReturn(Optional.of(diretorEsperado));

        // executando para realizar os injects
        cadastrarFilmeService.cadastrarFilme(request);

        // verificando se diretorRepository.findById foi chamado com ID_DIRETOR
        verify(diretorRepository).findById(idDiretor);

        // Verificando se atorRepository.findByIdIn foi chamado com request.getIdsAtores()
        verify(atorRepository).findByIdIn(request.getIdsAtores());

        // Capturando objeto salvo em filmeRepository.save para testes logo abaixo
        verify(filmeRepository).save(filmeCaptor.capture());

        Filme queFoiSalvo = filmeCaptor.getValue();
        assertEquals(request.getTitulo(), queFoiSalvo.getTitulo());
        assertEquals(diretorEsperado, queFoiSalvo.getDiretor());
        assertTrue(queFoiSalvo.getAtores().isEmpty());

    }

    @Test
    public void okDiretorExisteAtorExiste() {

        // mockando resultado para o findById
        when(diretorRepository.findById(idDiretor)).thenReturn(Optional.of(diretorEsperado));
        when(atorRepository.findByIdIn(idsAtores)).thenReturn(atoresEsperados);

        // executando para realizar os injects
        cadastrarFilmeService.cadastrarFilme(request);

        // verificando se diretorRepository.findById foi chamado com ID_DIRETOR
        verify(diretorRepository).findById(idDiretor);

        // Verificando se atorRepository.findByIdIn foi chamado com request.getIdsAtores()
        verify(atorRepository).findByIdIn(request.getIdsAtores());

        // Capturando objeto salvo em filmeRepository.save para testes logo abaixo
        verify(filmeRepository).save(filmeCaptor.capture());

        Filme queFoiSalvo = filmeCaptor.getValue();
        assertEquals(request.getTitulo(), queFoiSalvo.getTitulo());
        assertEquals(diretorEsperado, queFoiSalvo.getDiretor());
        assertEquals(atoresEsperados.size(), queFoiSalvo.getAtores().size());
        for (int i = 0; i < atoresEsperados.size(); i++) {
            assertEquals(atoresEsperados.get(i).getId(), queFoiSalvo.getAtores().get(i).getId());
        }

    }
}