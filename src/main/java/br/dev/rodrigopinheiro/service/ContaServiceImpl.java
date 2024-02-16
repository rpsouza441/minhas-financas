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
        contaExistente.setUuid(contaDTO.getUuid());
        contaExistente.setNome(contaDTO.getNome());
        contaExistente.setSaldo(contaDTO.getSaldo());
        return contaRepository.save(contaExistente);
    }

    public Conta updateConta(Conta conta) {
        Conta contaExistente = contaRepository.findById(conta.getUuid()).get();
        contaExistente.setUuid(conta.getUuid());
        contaExistente.setNome(conta.getNome());
        contaExistente.setSaldo(conta.getSaldo());
        return contaRepository.save(contaExistente);
    }


    @Override
    public void deleteConta(UUID id) {
        contaRepository.deleteById(id);
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
}
