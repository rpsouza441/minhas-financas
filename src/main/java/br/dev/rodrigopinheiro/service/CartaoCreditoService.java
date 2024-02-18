package br.dev.rodrigopinheiro.service;

import br.dev.rodrigopinheiro.dto.CartaoCreditoDTO;
import br.dev.rodrigopinheiro.dto.ContaDTO;
import br.dev.rodrigopinheiro.model.CartaoCredito;
import br.dev.rodrigopinheiro.model.Conta;

import java.util.List;
import java.util.UUID;

public interface CartaoCreditoService {
    CartaoCredito createCartaoCredito(CartaoCreditoDTO cartaoCreditoDTO);

    CartaoCredito getCartaoCreditoById(UUID cartaoCreditoUuid);

    List<CartaoCredito> getAllCartaoCreditos();

    CartaoCredito updateCartaoCredito(CartaoCreditoDTO cartaoCreditoDTO);

    void deleteCartaoCredito(UUID cartaoCreditoUuid);
}
