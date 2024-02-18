package br.dev.rodrigopinheiro.mapper;


import br.dev.rodrigopinheiro.dto.CartaoCreditoDTO;
import br.dev.rodrigopinheiro.model.CartaoCredito;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CartaoCreditoMapper {

    CartaoCreditoMapper INSTANCE = Mappers.getMapper(CartaoCreditoMapper.class);
    CartaoCredito fromDTO(CartaoCreditoDTO cartaoCreditoDTO);

    CartaoCreditoDTO toDTO(CartaoCredito cartaoCredito);
}
