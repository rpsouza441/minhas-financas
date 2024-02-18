package br.dev.rodrigopinheiro.service;

import br.dev.rodrigopinheiro.dto.TransferenciaDTO;
import br.dev.rodrigopinheiro.model.Transferencia;

import java.util.List;
import java.util.UUID;

public interface TransferenciaService {
    Transferencia createTransferencia(TransferenciaDTO transferenciaDTO);

    Transferencia getTransferenciaById(UUID transacaoUuid);

    List<Transferencia> getAllTransacoes();

    Transferencia updateTransferencia(TransferenciaDTO transferenciaDTO);

    void deleteTransferencia(UUID TransferenciaUuid);
}
