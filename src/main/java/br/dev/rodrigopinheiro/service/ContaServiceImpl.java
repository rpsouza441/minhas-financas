package br.dev.rodrigopinheiro.service;

import br.dev.rodrigopinheiro.dto.ContaDTO;
import br.dev.rodrigopinheiro.mapper.ContaMapper;
import br.dev.rodrigopinheiro.model.Conta;
import br.dev.rodrigopinheiro.repository.ContaRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContaServiceImpl implements ContaService{


    private ContaRepository contaRepository;
    private ContaMapper contaMapper;

    @Override
    public Conta createConta(ContaDTO contaDTO) {
        return contaRepository.save(contaMapper.fromDTO(contaDTO));
    }

    @Override
    public Conta getContaById(UUID id) {
        Optional<Conta> contaOptional = contaRepository.findById(id);
        return  contaOptional.get();
    }
    @Override
    public List<Conta> getAllContas() {
        return contaRepository.findAll();
    }

    @Override
    public Conta updateConta(ContaDTO contaDTO) {
        Conta contaExistente = contaRepository.findById(contaDTO.getUuid()).get();
        Conta contaFromDTO = contaMapper.fromDTO(contaDTO);

//        contaExistente.
//        contaExistente.setFirstName(conta.getFirstName());
//        contaExistente.setLastName(conta.getLastName());
//        contaExistente.setEmail(conta.getEmail());
        Conta  contaAtualizada = contaRepository.save(contaExistente);
        return contaAtualizada;
    }





    @Override
    public void deleteConta(UUID id) {
        repository.deleteById(id);
    }

}
