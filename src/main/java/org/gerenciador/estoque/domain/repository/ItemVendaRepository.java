package org.gerenciador.estoque.domain.repository;

import org.gerenciador.estoque.domain.models.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long> {
}
