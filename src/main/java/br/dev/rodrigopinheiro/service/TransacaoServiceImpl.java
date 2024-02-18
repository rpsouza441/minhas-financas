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

@RequiredArgsConstructor
@Service
public class TransacaoServiceImpl implements TransacaoService {


    private final TransacaoRepository transacaoRepository;

    private final TransacaoMapper transacaoMapper;




    @Override
    public Transacao createTransacao(TransacaoDTO transacaoDTO) {
        Transacao transacao = transacaoMapper.fromDTO(transacaoDTO);

        return transacaoRepository.save(transacao);

    }

    @Override
    public Transacao getTransacaoById(UUID transacaoUuid) {

        return transacaoRepository.findById(transacaoUuid).get();
    }

    @Override
    public List<Transacao> getAllTransacoes() {
        return transacaoRepository.findAll();
    }

    @Override
    public Transacao updateTransacao(TransacaoDTO transacaoDTO) {
        Transacao transacaoExistente = transacaoRepository.findById(transacaoDTO.getUuid()).get();

        transacaoExistente.setDescricao(transacaoDTO.getDescricao());
        transacaoExistente.setObservacao(transacaoDTO.getObservacao());
        transacaoExistente.setValor(transacaoDTO.getValor());
        transacaoExistente.setTipoTransacao(transacaoDTO.getTipoTransacao());
        transacaoExistente.setRecorrente(transacaoDTO.isRecorrente());
        transacaoExistente.setEfetivada(transacaoDTO.isEfetivada());
        transacaoExistente.setDataVencimento(transacaoDTO.getDataVencimento());
        transacaoExistente.setDataLancamento(transacaoDTO.getDataLancamento());


        return transacaoExistente;
    }

    @Override
    public void deleteTransacao(UUID transacaoUuid) {

        transacaoRepository.deleteById(transacaoUuid);

    }


}
