package org.gerenciador.estoque.controller;

import lombok.RequiredArgsConstructor;
import org.gerenciador.estoque.domain.models.Categoria;
import org.gerenciador.estoque.service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    public Categoria criarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.criarCategoria(categoria);
    }

    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaService.listarCategorias();
    }

    @GetMapping("/{nome}")
    public Categoria buscarCategoriaPorNome(@PathVariable String nome) {
        return categoriaService.buscarCategoriaPorNome(nome);
    }

    @PutMapping("/atualizar/{nomeAtual}")
    public Categoria atualizarCategoria(@PathVariable String nomeAtual, @RequestBody Categoria categoriaAtualizada) {
        return categoriaService.atualizarNomeCategoria(nomeAtual, categoriaAtualizada);
    }

    @DeleteMapping("/{id}")
    public void deletarCategoria(@PathVariable Long id) {
        categoriaService.deletarCategoriaPorId(id);
    }
    @DeleteMapping("/{nome}")
    public void deletarCategoriaPorNome(@PathVariable String nome) {
        categoriaService.deletarCategoriaPorNome(nome);
    }

}
