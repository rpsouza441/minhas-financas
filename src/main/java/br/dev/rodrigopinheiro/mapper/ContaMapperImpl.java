package br.dev.rodrigopinheiro.mapper;

import br.dev.rodrigopinheiro.dto.ContaDTO;
import br.dev.rodrigopinheiro.model.Conta;

public class ContaMapperImpl implements ContaMapper{
    @Override
    public ContaDTO toDTO(Conta conta) {
        return ContaDTO.builder()
                .uuid(conta.getUuid())
                .nome(conta.getNome())
                .saldo(conta.getSaldo())
                .transacaoList(conta.getTransacaoList())
                .build();
    }

    @Override
    public Conta fromDTO(ContaDTO contaDTO) {
        return Conta.builder()
                .uuid(contaDTO.getUuid())
                .nome(contaDTO.getNome())
                .saldo(contaDTO.getSaldo())
                .transacaoList(contaDTO.getTransacaoList())
                .build();
    }
}
