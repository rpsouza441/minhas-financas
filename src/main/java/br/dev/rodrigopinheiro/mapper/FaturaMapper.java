package br.dev.rodrigopinheiro.mapper;

import br.dev.rodrigopinheiro.dto.FaturaDTO;
import br.dev.rodrigopinheiro.model.Fatura;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface FaturaMapper {
    FaturaMapper INSTANCE = Mappers.getMapper(FaturaMapper.class);
    public Fatura fromDTO(FaturaDTO transacaoDTO);

    public FaturaDTO toDTO(Fatura transacao);
}
