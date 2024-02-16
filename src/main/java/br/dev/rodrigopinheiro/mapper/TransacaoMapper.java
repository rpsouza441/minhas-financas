package br.dev.rodrigopinheiro.mapper;

import br.dev.rodrigopinheiro.dto.TransacaoDTO;
import br.dev.rodrigopinheiro.model.Transacao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TransacaoMapper {
    TransacaoMapper INSTANCE = Mappers.getMapper(TransacaoMapper.class);
    public Transacao fromDTO(TransacaoDTO transacaoDTO);

    @Mapping(target = "contaUuid", source = "transacao.conta.uuid")
    public TransacaoDTO toDTO(Transacao transacao);
}
