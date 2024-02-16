package br.dev.rodrigopinheiro.repository;

import br.dev.rodrigopinheiro.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, UUID> {


}
