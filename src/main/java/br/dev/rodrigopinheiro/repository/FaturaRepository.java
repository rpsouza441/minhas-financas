package br.dev.rodrigopinheiro.repository;

import br.dev.rodrigopinheiro.model.Conta;
import br.dev.rodrigopinheiro.model.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, UUID> {



}
