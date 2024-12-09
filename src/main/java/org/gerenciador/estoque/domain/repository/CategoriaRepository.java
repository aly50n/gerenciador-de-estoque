package org.gerenciador.estoque.domain.repository;

import org.gerenciador.estoque.domain.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
