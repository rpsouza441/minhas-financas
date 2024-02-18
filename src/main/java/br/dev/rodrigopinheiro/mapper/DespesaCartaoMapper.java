package br.dev.rodrigopinheiro.mapper;

import br.dev.rodrigopinheiro.dto.DespesaCartaoDTO;
import br.dev.rodrigopinheiro.model.DespesaCartao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface DespesaCartaoMapper {

    DespesaCartaoMapper INSTANCE = Mappers.getMapper(DespesaCartaoMapper.class);

    public DespesaCartao fromDTO(DespesaCartaoDTO despesaCartaoDTO);

    public DespesaCartaoDTO toDTO(DespesaCartao despesaCartao);


}
