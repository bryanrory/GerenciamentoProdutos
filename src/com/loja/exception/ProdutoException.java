package com.loja.exception;

/**
 * Classe de exceção personalizada para erros relacionados aos produtos.
 *
 * A classe `ProdutoException` é uma exceção de tempo de execução (unchecked) que
 * serve para tratar erros específicos no contexto de operações com produtos,
 * como falhas de validação ou problemas internos de processamento relacionados
 * a produtos.
 *
 * Esta classe estende `RuntimeException`, o que significa que não é necessário
 * declarar explicitamente o lançamento desta exceção em métodos, permitindo uma
 * manipulação mais flexível.
 *
 * @since 2024
 */
public class ProdutoException extends RuntimeException {

    /**
     * Construtor que inicializa a exceção com uma mensagem personalizada.
     *
     * Este construtor cria uma nova instância da exceção `ProdutoException` com a
     * mensagem fornecida, que será exibida quando a exceção for lançada.
     *
     * @param mensagem A mensagem de erro que descreve o motivo da exceção.
     */
    public ProdutoException(String mensagem) {
        super(mensagem);
    }
}

