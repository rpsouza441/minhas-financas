package br.dev.rodrigopinheiro.dao;

import br.dev.rodrigopinheiro.model.Conta;
import br.dev.rodrigopinheiro.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository(value = "contaDAO")
public class ContaDAO {


    ContaRepository repository;

    @Autowired
    public ContaDAO(ContaRepository repository) {
        this.repository = repository;
    }

    public Conta getConta(UUID id) {
        Optional<Conta> contaOptional = repository.findById(id);
        return contaOptional.stream().findFirst().orElse(null);
    }
}
