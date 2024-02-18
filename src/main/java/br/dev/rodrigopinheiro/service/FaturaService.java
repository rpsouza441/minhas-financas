package br.dev.rodrigopinheiro.service;

import br.dev.rodrigopinheiro.dto.FaturaDTO;
import br.dev.rodrigopinheiro.model.Fatura;

import java.util.List;
import java.util.UUID;

public interface FaturaService {
    Fatura createFatura(FaturaDTO faturaDTO);

    Fatura getFaturaById(UUID faturaUuid);

    List<Fatura> getAllFaturas();

    Fatura updateFatura(FaturaDTO faturaDTO);

    void deleteFatura(UUID faturaUuid);
}
