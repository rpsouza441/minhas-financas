package br.dev.rodrigopinheiro.repository;

import br.dev.rodrigopinheiro.model.Categoria;
import br.dev.rodrigopinheiro.model.DespesaCartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DespesaCartaoRepository extends JpaRepository<DespesaCartao, UUID> {



}
