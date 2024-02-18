package br.dev.rodrigopinheiro.service;

import br.dev.rodrigopinheiro.dto.CategoriaDTO;
import br.dev.rodrigopinheiro.model.Categoria;

import java.util.List;
import java.util.UUID;

public interface CategoriaService {
    Categoria createCategoria(CategoriaDTO categoriaDTO);

    Categoria getCategoriaById(UUID categoriaUuid);

    List<Categoria> getAllCategorias();

    Categoria updateCategoria(CategoriaDTO categoriaDTO);

    void deleteCategoria(UUID categoriaUuid);
}
