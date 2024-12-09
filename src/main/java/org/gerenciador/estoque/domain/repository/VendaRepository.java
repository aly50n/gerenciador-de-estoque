package org.gerenciador.estoque.domain.repository;

import org.gerenciador.estoque.domain.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
