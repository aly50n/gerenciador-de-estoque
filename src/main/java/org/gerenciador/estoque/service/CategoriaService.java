package org.gerenciador.estoque.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.gerenciador.estoque.domain.exception.CategoriaExistenteException;
import org.gerenciador.estoque.domain.models.Categoria;
import org.gerenciador.estoque.domain.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public Categoria criarCategoria(Categoria categoria) {
        if(categoriaRepository.findByNome(categoria.getNome()).isPresent()){
            throw new CategoriaExistenteException(categoria.getNome());
        }
        categoria.setNome(categoria.getNome().toUpperCase());
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarCategoriaPorNome(String nome) {
        return categoriaRepository.findByNome(nome)
                .orElseThrow(() -> new EntityNotFoundException("Categoria com nome '" + nome + "' não encontrada!"));
    }

    public Categoria atualizarNomeCategoria(String nomeAtual, Categoria categoriaAtualizada) {
        return categoriaRepository.findByNome(nomeAtual)
                .map(categoria -> {
                    categoria.setNome(categoriaAtualizada.getNome());
                    return categoriaRepository.save(categoria);
                }).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    public void deletarCategoriaPorId(Long id) {
        categoriaRepository.deleteById(id);
    }

    public void deletarCategoriaPorNome(String nome) {
        categoriaRepository.deleteByNome(nome);
    }
}
