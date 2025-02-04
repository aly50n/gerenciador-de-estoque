package org.gerenciador.estoque.domain.exception;

public class CategoriaExistenteException extends RuntimeException {
    public CategoriaExistenteException(String nome) {
        super("Já existe uma categoria com o nome: " + nome);
    }
}