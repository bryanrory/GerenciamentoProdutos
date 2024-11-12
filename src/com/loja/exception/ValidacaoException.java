package com.loja.exception;

/**
 * Classe de exceção personalizada para erros de validação de dados.
 *
 * A classe `ValidacaoException` é uma exceção de tempo de execução (unchecked)
 * que é utilizada para indicar falhas nas validações de dados no sistema,
 * como entradas inválidas ou dados que não atendem aos critérios necessários.
 *
 * Esta classe estende `RuntimeException`, permitindo maior flexibilidade na
 * manipulação da exceção sem a necessidade de declarações explícitas de `throws`
 * em métodos.
 *
 * @since 2024
 */
public class ValidacaoException extends RuntimeException {

    /**
     * Construtor que inicializa a exceção com uma mensagem personalizada.
     *
     * Este construtor cria uma nova instância da exceção `ValidacaoException` com
     * a mensagem fornecida, que será exibida quando a exceção for lançada.
     *
     * @param mensagem A mensagem de erro que descreve o motivo da exceção.
     */
    public ValidacaoException(String mensagem) {
        super(mensagem);
    }
}