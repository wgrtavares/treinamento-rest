package br.com.cwi.treinamentorest.functional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Classe criada apenas para a aula 7 sobre java funcional.
 * Os exemplos da aula estão no teste desta classe.
 */
public class Functional {

    /**
     * Filtrando por TipoUsuario.ALUNO.
     * @param turma
     * @return
     */
    public static List<Usuario> exemploFilter(List<Usuario> turma) {

        return turma.stream()
                .filter(usuario -> TipoUsuario.ALUNO.equals(usuario.getTipo()))
                .collect(Collectors.toList());

    }

    /**
     * Transformando lista de usuário e lista de nomes de usuários.
     * @param turma
     * @return
     */
    public static List<String> exemploMap(List<Usuario> turma) {

        return turma.stream()
                .map(usuario -> usuario.getNome())
                .collect(Collectors.toList());

    }

    /**
     * Removendo repetições com o distinct.
     * @param numeros
     * @return
     */
    public static List<Integer> exemploDistinct(List<Integer> numeros) {
        return numeros.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Utilizando optional para evitar NullPointerException.
     *
     * @param i
     * @return
     */
    public static int exemploOptional(Optional<Integer> i) {
        return i.orElseThrow(() -> new RuntimeException());
    }

    /**
     * Utilizando optional para evitar NullPointerException.
     *
     * @param i
     * @return
     */
    public static int exemploOptional1(Optional<Integer> i, Integer intIfNull) {
        return i.orElse(intIfNull);
    }

    /**
     * Utilizando collect para criar um map.
     * @return
     */
    public static Map<TipoUsuario, List<Usuario>> exemploCollect(List<Usuario> usuarios) {
        return usuarios.stream()
                .collect(Collectors.groupingBy(usuario -> usuario.getTipo()));
    }

}
