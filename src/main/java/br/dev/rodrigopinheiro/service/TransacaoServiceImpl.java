package br.dev.rodrigopinheiro.service;

import br.dev.rodrigopinheiro.dto.TransacaoDTO;
import br.dev.rodrigopinheiro.mapper.TransacaoMapper;
import br.dev.rodrigopinheiro.model.Conta;
import br.dev.rodrigopinheiro.model.Transacao;
import br.dev.rodrigopinheiro.repository.ContaRepository;
import br.dev.rodrigopinheiro.repository.TransacaoRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class TransacaoServiceImpl implements TransacaoService {


    private final ContaServiceImpl contaService;

    private final TransacaoRepository transacaoRepository;

    private final TransacaoMapper transacaoMapper;

    @Autowired
    public TransacaoServiceImpl(ContaServiceImpl contaService, TransacaoRepository transacaoRepository, TransacaoMapper transacaoMapper) {
        this.contaService = contaService;
        this.transacaoRepository = transacaoRepository;
        this.transacaoMapper = transacaoMapper;
    }


    @Override
    public Transacao createTransacao(TransacaoDTO transacaoDTO) {
        Transacao transacao = transacaoMapper.fromDTO(transacaoDTO);
        transacao.setConta(contaService.atualizarSaldo(transacaoDTO));

        return transacaoRepository.save(transacao);

    }

    @Override
    public Transacao getTransacaoById(UUID transacaoUuid) {
        return null;
    }

    @Override
    public List<Transacao> getAllTransacoes() {
        return null;
    }

    @Override
    public Transacao updateTransacao(TransacaoDTO TransacaoDTO) {
        return null;
    }

    @Override
    public void deleteTransacao(UUID TransacaoUuid) {

    }


}
