package br.dev.rodrigopinheiro.service;

import br.dev.rodrigopinheiro.dto.ContaDTO;
import br.dev.rodrigopinheiro.model.Conta;

import java.util.List;
import java.util.UUID;

public interface ContaService {
    Conta createConta(ContaDTO contaDTO);

    Conta getContaById(UUID contaUuid);

    List<Conta> getAllContas();

    Conta updateConta(ContaDTO contaDTO);

    void deleteConta(UUID contaUuid);
}
