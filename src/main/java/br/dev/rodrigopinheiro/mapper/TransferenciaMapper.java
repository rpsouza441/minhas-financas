package br.dev.rodrigopinheiro.mapper;

import br.dev.rodrigopinheiro.dto.TransferenciaDTO;
import br.dev.rodrigopinheiro.model.Transferencia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TransferenciaMapper {
    TransferenciaMapper INSTANCE = Mappers.getMapper(TransferenciaMapper.class);
    public Transferencia fromDTO(TransferenciaDTO transferenciaDTO);

    public TransferenciaDTO toDTO(Transferencia transferencia);
}
