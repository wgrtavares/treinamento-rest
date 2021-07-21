package br.com.cwi.treinamentorest.functional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.AssertionErrors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class FunctionalTest {

    private List<Usuario> turma;

    @BeforeEach
    void setUp() {
         turma = Arrays.asList(
                new Usuario("Adriano", TipoUsuario.ALUNO),
                new Usuario("Bruna", TipoUsuario.ALUNO),
                new Usuario("Fabricio", TipoUsuario.ALUNO),
                new Usuario("Gabriel", TipoUsuario.ALUNO),
                new Usuario("Giovana", TipoUsuario.MASTER),
                new Usuario("Lucas", TipoUsuario.INSTRUTOR),
                new Usuario("Mateus", TipoUsuario.INSTRUTOR),
                new Usuario("Murilo", TipoUsuario.ALUNO),
                new Usuario("Rafael", TipoUsuario.ALUNO),
                new Usuario("Werner", TipoUsuario.ALUNO)
        );
    }

    @Test
    public void exemploFilterTest() {

        assertEquals(10, turma.size());

        List<Usuario> alunos = Functional.exemploFilter(turma);

        assertEquals(7, alunos.size());

        alunos.forEach(usuario -> assertEquals(TipoUsuario.ALUNO, usuario.getTipo()));
    }

    @Test
    public void exemploMapTest() {

        List<String> nomes = Functional.exemploMap(turma);

        assertEquals(turma.size(), nomes.size());

        for (int i = 0; i < turma.size(); i++) {
            assertEquals(turma.get(i).getNome(), nomes.get(i));
        }
    }

    @Test
    public void exemploDistinctTest() {

        List<Integer> numerosComRepeticao = Arrays.asList(1, 1, 2, 3, 4);

        List<Integer> numerosSemRepeticao = Functional.exemploDistinct(numerosComRepeticao);

        List<Integer> numerosEsperados = Arrays.asList(1, 2, 3, 4);

        assertEquals(numerosEsperados.size(), numerosSemRepeticao.size());

        for (int i = 0; i < numerosEsperados.size(); i++) {
            assertEquals(numerosEsperados.get(i), numerosSemRepeticao.get(i));
        }
    }

    @Test
    public void exemploOptionalTest() {

        int resultado = Functional.exemploOptional(Optional.of(1));

        assertEquals(1, resultado);

        try {
            resultado = Functional.exemploOptional(Optional.of(null));
        } catch (RuntimeException re) {
            assertEquals(1, resultado);
        }
    }

    @Test
    public void exemploOptional1Test() {

        int resultado = Functional.exemploOptional1(
                Optional.ofNullable(1), 2
        );

        assertEquals(1, resultado);

        resultado = Functional.exemploOptional1(
                Optional.ofNullable(null), 2
        );

        assertEquals(2, resultado);
    }

    @Test
    public void exemploCollectTest() {

        Map<TipoUsuario, List<Usuario>> resultado =
                Functional.exemploCollect(turma);

        List<Usuario> alunos = resultado.get(TipoUsuario.ALUNO);
        List<Usuario> instrutores = resultado.get(TipoUsuario.INSTRUTOR);
        List<Usuario> masters = resultado.get(TipoUsuario.MASTER);

        assertEquals(7, alunos.size());
        assertEquals(2, instrutores.size());
        assertEquals(1, masters.size());
    }

}