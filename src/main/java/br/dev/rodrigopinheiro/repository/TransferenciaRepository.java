package br.dev.rodrigopinheiro.repository;

import br.dev.rodrigopinheiro.model.Fatura;
import br.dev.rodrigopinheiro.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, UUID> {



}
