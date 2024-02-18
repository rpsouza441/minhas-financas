package br.dev.rodrigopinheiro.repository;

import br.dev.rodrigopinheiro.model.CartaoCredito;
import br.dev.rodrigopinheiro.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {



}
