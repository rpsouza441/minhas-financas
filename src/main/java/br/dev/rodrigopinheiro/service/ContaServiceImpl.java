package br.dev.rodrigopinheiro.service;

import br.dev.rodrigopinheiro.dto.ContaDTO;
import br.dev.rodrigopinheiro.dto.TransacaoDTO;
import br.dev.rodrigopinheiro.mapper.ContaMapper;
import br.dev.rodrigopinheiro.model.Conta;
import br.dev.rodrigopinheiro.model.TipoTransacao;
import br.dev.rodrigopinheiro.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContaServiceImpl implements ContaService {


    private ContaRepository contaRepository;
    private ContaMapper contaMapper;

    @Override
    public Conta createConta(ContaDTO contaDTO) {
        return contaRepository.save(contaMapper.fromDTO(contaDTO));
    }

    @Override
    public Conta getContaById(UUID id) {
        Optional<Conta> contaOptional = contaRepository.findById(id);
        return contaOptional.get();
    }

    @Override
    public List<Conta> getAllContas() {
        return contaRepository.findAll();
    }

    @Override
    public Conta updateConta(ContaDTO contaDTO) {
        Conta contaExistente = contaRepository.findById(contaDTO.getUuid()).get();

        return contaRepository.save(atualizaCampos(contaExistente, contaMapper.fromDTO(contaDTO)));
    }

    public Conta updateConta(Conta conta) {
        Conta contaExistente = contaRepository.findById(conta.getUuid()).get();

        return contaRepository.save(atualizaCampos(contaExistente, conta));
    }


    @Override
    public void deleteConta(UUID uuid) {
        contaRepository.deleteById(uuid);
    }

    public Conta atualizarSaldo(TransacaoDTO transacaoDTO) {
        Conta conta = getContaById(transacaoDTO.getContaUuid());
        switch (transacaoDTO.getTipoTransacao()) {
            case TipoTransacao.DEBIT -> {
                conta.setSaldo( conta.getSaldo().subtract(transacaoDTO.getValor()));
            }
            case TipoTransacao.CREDIT -> {
                conta.setSaldo(conta.getSaldo().add(transacaoDTO.getValor()));
            }
        }
        return contaRepository.save(conta);
    }


    private Conta atualizaCampos(Conta contaExistente, Conta contaAtualizada){
        contaExistente.setUuid(contaAtualizada.getUuid());
        contaExistente.setNome(contaAtualizada.getNome());
        contaExistente.setSaldo(contaAtualizada.getSaldo());
        return contaExistente;
    }
}
