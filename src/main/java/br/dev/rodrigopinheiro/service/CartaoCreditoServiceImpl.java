package br.dev.rodrigopinheiro.service;

import br.dev.rodrigopinheiro.dto.CartaoCreditoDTO;
import br.dev.rodrigopinheiro.dto.ContaDTO;
import br.dev.rodrigopinheiro.dto.TransacaoDTO;
import br.dev.rodrigopinheiro.mapper.CartaoCreditoMapper;
import br.dev.rodrigopinheiro.model.CartaoCredito;
import br.dev.rodrigopinheiro.model.Conta;
import br.dev.rodrigopinheiro.model.TipoTransacao;
import br.dev.rodrigopinheiro.repository.CartaoCreditoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartaoCreditoServiceImpl implements CartaoCreditoService {


    private CartaoCreditoRepository cartaoCreditoRepository;
    private CartaoCreditoMapper cartaoCreditoMapper;

    @Override
    public CartaoCredito createCartaoCredito(CartaoCreditoDTO cartaoCreditoDTO) {
        return cartaoCreditoRepository.save(cartaoCreditoMapper.fromDTO(cartaoCreditoDTO));
    }

    @Override
    public CartaoCredito getCartaoCreditoById(UUID id) {
        Optional<CartaoCredito> cartaoCreditoOptional = cartaoCreditoRepository.findById(id);
        return cartaoCreditoOptional.get();
    }

    @Override
    public List<CartaoCredito> getAllCartaoCreditos() {
        return cartaoCreditoRepository.findAll();
    }

    @Override
    public CartaoCredito updateCartaoCredito(CartaoCreditoDTO cartaoCreditoDTO) {
        return getCartaoCredito(cartaoCreditoDTO);
    }

    private CartaoCredito getCartaoCredito(CartaoCreditoDTO cartaoCreditoDTO) {
        CartaoCredito cartaoCreditoExistente = cartaoCreditoRepository.findById(cartaoCreditoDTO.getUuid()).get();
        CartaoCredito cartaoCreditoAtualizado = CartaoCreditoMapper.INSTANCE.fromDTO(cartaoCreditoDTO);


        return cartaoCreditoRepository.save(atualizaCampos(cartaoCreditoExistente, cartaoCreditoAtualizado));
    }

    public CartaoCredito updateCartaoCredito(CartaoCredito cartaoCredito) {
        return getCartaoCredito(cartaoCredito);
    }

    private CartaoCredito getCartaoCredito(CartaoCredito cartaoCredito) {
        CartaoCredito cartaoCreditoExistente = cartaoCreditoRepository.findById(cartaoCredito.getUuid()).get();
        return cartaoCreditoRepository.save(atualizaCampos(cartaoCreditoExistente, cartaoCredito));
    }


    @Override
    public void deleteCartaoCredito(UUID id) {
        cartaoCreditoRepository.deleteById(id);
    }


    private CartaoCredito atualizaCampos(CartaoCredito cartaoCreditoExistente, CartaoCredito cartaoCreditoAtualizado) {
        cartaoCreditoExistente.setUuid(cartaoCreditoAtualizado.getUuid());
        cartaoCreditoExistente.setNome(cartaoCreditoAtualizado.getNome());
        cartaoCreditoExistente.setLimite(cartaoCreditoAtualizado.getLimite());
        cartaoCreditoExistente.setDiaFechamento(cartaoCreditoAtualizado.getDiaFechamento());
        cartaoCreditoExistente.setDiaVencimento(cartaoCreditoAtualizado.getDiaVencimento());

        return cartaoCreditoExistente;
    }

}
