package br.dev.rodrigopinheiro.service;

import br.dev.rodrigopinheiro.dto.FaturaDTO;
import br.dev.rodrigopinheiro.mapper.FaturaMapper;
import br.dev.rodrigopinheiro.model.Fatura;
import br.dev.rodrigopinheiro.repository.FaturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FaturaServiceImpl implements FaturaService {


    private final FaturaRepository faturaRepository;
    private final FaturaMapper faturaMapper;


    @Override
    public Fatura createFatura(FaturaDTO faturaDTO) {
        Fatura fatura = faturaMapper.fromDTO(faturaDTO);
        return faturaRepository.save(fatura);
    }

    @Override
    public Fatura getFaturaById(UUID faturaUuid) {
        Optional<Fatura> faturaOptional = faturaRepository.findById(faturaUuid);
        return faturaOptional.get();
    }

    @Override
    public List<Fatura> getAllFaturas() {
        return faturaRepository.findAll();
    }

    @Override
    public Fatura updateFatura(FaturaDTO faturaDTO) {
        Fatura faturaExistente = faturaRepository.findById(faturaDTO.getUuid()).get();
        faturaExistente.setAno(faturaDTO.getAno());
        faturaExistente.setMes(faturaDTO.getMes());

        return faturaRepository.save(faturaExistente);
    }

    @Override
    public void deleteFatura(UUID faturaUuid) {
        faturaRepository.deleteById(faturaUuid);
    }


}
