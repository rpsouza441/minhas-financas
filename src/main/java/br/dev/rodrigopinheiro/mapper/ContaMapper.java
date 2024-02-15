package br.dev.rodrigopinheiro.mapper;

import br.dev.rodrigopinheiro.dto.ContaDTO;
import br.dev.rodrigopinheiro.model.Conta;

public interface ContaMapper {

    ContaDTO toDTO(Conta conta);

    Conta fromDTO(ContaDTO contaDTO);
}
