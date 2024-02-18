package br.dev.rodrigopinheiro.service;

import br.dev.rodrigopinheiro.dto.DespesaCartaoDTO;
import br.dev.rodrigopinheiro.model.DespesaCartao;

import java.util.List;
import java.util.UUID;

public interface DespesaCartaoService {
    DespesaCartao createDespesaCartao(DespesaCartaoDTO despesaCartaoDTO);

    DespesaCartao getDespesaCartaoById(UUID despesaCartaoUuid);

    List<DespesaCartao> getAllDespesaCartaos();

    DespesaCartao updateDespesaCartao(DespesaCartaoDTO despesaCartaoDTO);

    void deleteDespesaCartao(UUID despesaCartaoUuid);
}
