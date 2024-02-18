package br.dev.rodrigopinheiro.service;

import br.dev.rodrigopinheiro.dto.DespesaCartaoDTO;
import br.dev.rodrigopinheiro.dto.TransacaoDTO;
import br.dev.rodrigopinheiro.mapper.DespesaCartaoMapper;
import br.dev.rodrigopinheiro.model.DespesaCartao;
import br.dev.rodrigopinheiro.model.TipoTransacao;
import br.dev.rodrigopinheiro.repository.DespesaCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DespesaCartaoServiceImpl implements DespesaCartaoService {


    private DespesaCartaoRepository despesaCartaoRepository;
    private DespesaCartaoMapper contaMapper;

    @Override
    public DespesaCartao createDespesaCartao(DespesaCartaoDTO despesaCartaoDTO) {
        return despesaCartaoRepository.save(contaMapper.fromDTO(despesaCartaoDTO));
    }

    @Override
    public DespesaCartao getDespesaCartaoById(UUID uuid) {
        Optional<DespesaCartao> contaOptional = despesaCartaoRepository.findById(uuid);
        return contaOptional.get();
    }

    @Override
    public List<DespesaCartao> getAllDespesaCartaos() {
        return despesaCartaoRepository.findAll();
    }

    @Override
    public DespesaCartao updateDespesaCartao(DespesaCartaoDTO despesaCartaoDTO) {
        DespesaCartao despesaCartaoExistente = despesaCartaoRepository.findById(despesaCartaoDTO.getUuid()).get();
        
        return despesaCartaoRepository.save(atualizaCampos(despesaCartaoExistente, contaMapper.fromDTO(despesaCartaoDTO)));
    }

    public DespesaCartao updateDespesaCartao(DespesaCartao despesaCartao) {
        DespesaCartao despesaCartaoExistente = despesaCartaoRepository.findById(despesaCartao.getUuid()).get();
    
        return despesaCartaoRepository.save(atualizaCampos(despesaCartaoExistente, despesaCartao));
    }


    @Override
    public void deleteDespesaCartao(UUID uuid) {
        despesaCartaoRepository.deleteById(uuid);
    }


    
    private DespesaCartao atualizaCampos(DespesaCartao despesaCartaoExistente, DespesaCartao despesaCartaoAtualizada){
        despesaCartaoExistente.setDescricao(despesaCartaoAtualizada.getDescricao());
        despesaCartaoExistente.setObservacao(despesaCartaoAtualizada.getObservacao());
        despesaCartaoExistente.setValor(despesaCartaoAtualizada.getValor());
        despesaCartaoExistente.setEfetivada(despesaCartaoAtualizada.isEfetivada());
        despesaCartaoExistente.setRecorrente(despesaCartaoAtualizada.isRecorrente());
        despesaCartaoExistente.setMesAnoFatura(despesaCartaoAtualizada.getMesAnoFatura());
        despesaCartaoExistente.setDataLancamento(despesaCartaoAtualizada.getDataLancamento());

        return despesaCartaoExistente;
    }
}
