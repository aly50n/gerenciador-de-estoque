package org.gerenciador.estoque.domain.models;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;
    private int quantidadeVendida;
    private BigDecimal precoUnitario;
    private BigDecimal valorTotalVenda;
    @ManyToOne
    @JoinColumn(name = "venda_id", nullable = false)
    private Venda venda;
    @ManyToOne
    @JoinColumn(name = "lote_id", nullable = false)
    private Lote lote;



    public BigDecimal getValorTotalVenda(){
        return this.getPrecoUnitario().multiply(new BigDecimal(this.getQuantidadeVendida()));
    }

}
