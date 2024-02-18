package br.dev.rodrigopinheiro.service;

import br.dev.rodrigopinheiro.dto.TransferenciaDTO;
import br.dev.rodrigopinheiro.mapper.TransferenciaMapper;
import br.dev.rodrigopinheiro.model.Fatura;
import br.dev.rodrigopinheiro.model.Transferencia;
import br.dev.rodrigopinheiro.repository.TransferenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TransferenciaServiceImpl implements TransferenciaService {



    private final TransferenciaRepository transacaoRepository;

    private final TransferenciaMapper transacaoMapper;



    @Override
    public Transferencia createTransferencia(TransferenciaDTO transacaoDTO) {
        Transferencia transacao = transacaoMapper.fromDTO(transacaoDTO);

        return transacaoRepository.save(transacao);

    }

    @Override
    public Transferencia getTransferenciaById(UUID transacaoUuid) {
        Optional<Transferencia> transferenciaOptional = transacaoRepository.findById(transacaoUuid);
        return transferenciaOptional.get();
    }

    @Override
    public List<Transferencia> getAllTransacoes() {
        return transacaoRepository.findAll();
    }

    @Override
    public Transferencia updateTransferencia(TransferenciaDTO transferenciaDTO) {


        //TO-DO efetivar entre contas
        Transferencia transferenciaExistente = transacaoRepository.findById(transferenciaDTO.getUuid()).get();

        transferenciaExistente.setDescricao(transferenciaDTO.getDescricao());
        transferenciaExistente.setObservacao(transferenciaDTO.getObservacao());
        transferenciaExistente.setValor(transferenciaDTO.getValor());
        transferenciaExistente.setRecorrente(transferenciaDTO.isRecorrente());
        transferenciaExistente.setEfetivada(transferenciaDTO.isEfetivada());
        transferenciaExistente.setDataVencimento(transferenciaDTO.getDataVencimento());
        transferenciaExistente.setDataEfetivado(transferenciaDTO.getDataEfetivado());


        return transferenciaExistente;
    }

    @Override
    public void deleteTransferencia(UUID transferenciaUuid) {

        transacaoRepository.deleteById(transferenciaUuid);
    }


}
