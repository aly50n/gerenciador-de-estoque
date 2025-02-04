package org.gerenciador.estoque.domain.repository;

import org.gerenciador.estoque.domain.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByNome(String nome);

    void deleteByNome(String nome);
}
