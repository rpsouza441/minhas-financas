package br.dev.rodrigopinheiro.service;

import br.dev.rodrigopinheiro.dto.TransacaoDTO;
import br.dev.rodrigopinheiro.model.Conta;
import br.dev.rodrigopinheiro.model.TipoTransacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransacaoService {


    private final ContaServiceImpl contaService;

    @Autowired
    private TransacaoService(ContaServiceImpl contaService) {
        this.contaService = contaService;
    }

    public void efetivarTransacao(TransacaoDTO t) {
        Optional<Conta> contaOptional = contaService.getContaById(t.getConta().getId());
        Conta conta= new Conta();
        if (contaOptional.isPresent()) {
            conta = contaOptional.get();
            if (t.getTipoTransacao().equals(TipoTransacao.CREDIT)) {
                conta.getSaldo().subtract(t.getValor());
            }
            contaService.saveConta(conta);
        }


    }

}
