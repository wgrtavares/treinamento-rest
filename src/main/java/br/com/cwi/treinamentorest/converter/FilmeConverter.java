package br.com.cwi.treinamentorest.converter;

import br.com.cwi.treinamentorest.domain.Filme;
import br.com.cwi.treinamentorest.entity.FilmeEntity;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FilmeConverter implements GenericConverter {

    private static final ConvertiblePair DOMAIN_TO_ENTITY = new ConvertiblePair(Filme.class, FilmeEntity.class);
    private static final ConvertiblePair ENTITY_TO_DOMAIN = new ConvertiblePair(FilmeEntity.class, Filme.class);
    private static final Set<ConvertiblePair> CONVERTIBLE_TYPES = new HashSet<>(Arrays.asList(
            DOMAIN_TO_ENTITY,
            ENTITY_TO_DOMAIN
    ));

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return CONVERTIBLE_TYPES;
    }

    @Override
    public Object convert(Object o, TypeDescriptor typeDescriptorSrc, TypeDescriptor typeDescriptorDst) {

        ConvertiblePair par = new ConvertiblePair(typeDescriptorSrc.getType(), typeDescriptorDst.getType());

        if (DOMAIN_TO_ENTITY.equals(par)) {
            return domainToEntity((Filme) o);
        }

        if (ENTITY_TO_DOMAIN.equals(par)) {
            return entityToDomain((FilmeEntity) o);
        }

        return null;
    }

    public static FilmeEntity domainToEntity(Filme filme) {
        return FilmeEntity.builder()
                .id(filme.getId())
                .titulo(filme.getTitulo())
                .build();
    }

    public static Filme entityToDomain(FilmeEntity filmeEntity) {
        return Filme.builder()
                .id(filmeEntity.getId())
                .titulo(filmeEntity.getTitulo())
                .build();
    }

    public static List<FilmeEntity> domainToEntity (List<Filme> domainList) {
        return
                domainList.stream()
                    .map(filme -> domainToEntity(filme))
                    .collect(Collectors.toList());
    }

    public static List<Filme> entityToDomain (List<FilmeEntity> entityList) {
        return
                entityList.stream()
                        .map(entity -> entityToDomain(entity))
                        .collect(Collectors.toList());
    }

}
