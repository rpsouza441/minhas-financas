package br.dev.rodrigopinheiro.repository;

import br.dev.rodrigopinheiro.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContaRepository extends JpaRepository<Conta, UUID> {



}
