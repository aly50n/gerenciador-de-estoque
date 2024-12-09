package org.gerenciador.estoque.domain.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Lote {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @Column(nullable = false)
    private int quantidadeComprada;

    private int quantidadeDisponivel; //criar construtor qntDisp = qntComp;

    private BigDecimal precoDeCompra;

    @OneToMany(mappedBy = "lote", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemVenda> itensVendas = new ArrayList<>();

    @Column(nullable = false)
    private LocalDate dataCompra;

    @Column(nullable = false)
    private LocalDate dataDeRegistro;

}
