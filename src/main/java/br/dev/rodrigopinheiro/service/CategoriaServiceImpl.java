package br.dev.rodrigopinheiro.service;

import br.dev.rodrigopinheiro.dto.CategoriaDTO;
import br.dev.rodrigopinheiro.mapper.CategoriaMapper;
import br.dev.rodrigopinheiro.model.Categoria;
import br.dev.rodrigopinheiro.model.Conta;
import br.dev.rodrigopinheiro.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {


    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;


    @Override
    public Categoria createCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaMapper.fromDTO(categoriaDTO);
        return categoriaRepository.save(categoria);

    }

    @Override
    public Categoria getCategoriaById(UUID categoriaUuid) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(categoriaUuid);
        return categoriaOptional.get();
    }

    @Override
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria updateCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoriaExistente = categoriaRepository.findById(categoriaDTO.getUuid()).get();
        categoriaExistente.setNome(categoriaDTO.getNome());

        return categoriaRepository.save(categoriaExistente);
    }

    @Override
    public void deleteCategoria(UUID categoriaUuid) {
        categoriaRepository.deleteById(categoriaUuid);
    }


}
