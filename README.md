# Gerenciador de Estoque

Este é o projeto de encerramento do bootcamp, onde apliquei tudo o que aprendi ao longo da jornada. Aqui estão as principais tecnologias que utilizei:

## Principais Tecnologias
Java 17: Optei pela versão 17 do Java para aproveitar ao máximo as inovações que essa linguagem, que é robusta e amplamente utilizada, oferece.
Spring Boot 3: Utilizei a versão mais recente do Spring Boot, que traz uma grande produtividade ao desenvolvedor, especialmente com sua abordagem de autoconfiguração.
Spring Data JPA: Explorei como essa ferramenta facilita a camada de acesso a dados, simplificando a integração com bancos de dados SQL e tornando o processo mais ágil.
OpenAPI (Swagger): Implementei uma documentação de API clara e acessível com a OpenAPI (Swagger), alinhando essa ferramenta com a alta produtividade que o Spring Boot proporciona.
Railway: Usei o Railway para facilitar o deploy e monitoramento da aplicação na nuvem, além de contar com serviços como bancos de dados e pipelines de CI/CD.

## Diagrama de Classes (Domínio da API)
```MERMAID
classDiagram
    Lote "1" --> "N" Produto : possui
    Lote "1" --> "N" ItemVenda : contém
    Produto "1" --> "N" Lote : tem
    Produto "1" --> "N" ItemVenda : é vendido em
    Produto "1" --> "0..1" Categoria : pertence a
    Categoria "1" --> "*" Produto : contém
    Venda "1" --> "N" ItemVenda : contém
    ItemVenda "1" --> "1" Lote : pertence a
    ItemVenda "1" --> "1" Produto : refere
    ItemVenda "1" --> "1" Venda : pertence a

    class Lote {
        Long id
        Produto produto
        int quantidadeComprada
        int quantidadeDisponivel
        BigDecimal precoDeCompra
        LocalDate dataCompra
        List<ItemVenda> itensVendas
    }

    class Produto {
        Long id
        String nome
        BigDecimal precoDeVenda
        List<Lote> lotes
        Categoria categoria
    }

    class Categoria {
        Long id
        String nome
        List<Produto> produtos
    }

    class Venda {
        Long id
        LocalDate dataVenda
        List<ItemVenda> itens
        BigDecimal lucroTotal
    }

    class ItemVenda {
        Long id
        Produto produto
        int quantidadeVendida
        BigDecimal precoUnitario
        BigDecimal valorTotalVenda
        Venda venda
        Lote lote
    }

    class Relatorio {
        BigDecimal calcularLucro(LocalDate dataInicial, LocalDate dataFinal)
    }
```