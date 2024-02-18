package br.dev.rodrigopinheiro.mapper;

import br.dev.rodrigopinheiro.dto.CategoriaDTO;
import br.dev.rodrigopinheiro.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    public Categoria fromDTO(CategoriaDTO CategoriaDTO);

    public CategoriaDTO toDTO(Categoria Categoria);

  
}
