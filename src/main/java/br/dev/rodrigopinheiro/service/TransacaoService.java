package br.dev.rodrigopinheiro.service;

import br.dev.rodrigopinheiro.dto.ContaDTO;
import br.dev.rodrigopinheiro.dto.TransacaoDTO;
import br.dev.rodrigopinheiro.model.Conta;
import br.dev.rodrigopinheiro.model.Transacao;

import java.util.List;
import java.util.UUID;

public interface TransacaoService {
    Transacao createTransacao(TransacaoDTO transacaoDTO);

    Transacao getTransacaoById(UUID transacaoUuid);

    List<Transacao> getAllTransacoes();

    Transacao updateTransacao(TransacaoDTO transacaoDTO);

    void deleteTransacao(UUID TransacaoUuid);
}
