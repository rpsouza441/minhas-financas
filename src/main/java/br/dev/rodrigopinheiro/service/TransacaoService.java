package br.dev.rodrigopinheiro.service;

import br.dev.rodrigopinheiro.dao.ContaDAO;
import br.dev.rodrigopinheiro.dto.ContaDTO;
import br.dev.rodrigopinheiro.dto.TransacaoDTO;
import br.dev.rodrigopinheiro.model.Conta;
import br.dev.rodrigopinheiro.model.TipoTransacao;
import br.dev.rodrigopinheiro.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {


    private final ContaDAO contaDAO;

    @Autowired
    private TransacaoService(ContaDAO contaDAO) {
        this.contaDAO = contaDAO;
    }

    public void efetivarTransacao(TransacaoDTO t) {
        Conta conta = contaDAO.getConta(t.getConta().getId());
        if (t.getTipoTransacao().equals(TipoTransacao.CREDIT)) {
            conta.getSaldo().subtract(t.getValor());

        }

    }

}
