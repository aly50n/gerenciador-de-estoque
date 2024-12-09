package org.gerenciador.estoque.domain.repository;

import org.gerenciador.estoque.domain.models.Lote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoteRepository extends JpaRepository<Lote, Long> {
}
