package com.loja.util;

import java.util.Scanner;

/**
 * Classe utilitária que fornece métodos para ler entradas do usuário
 * de forma segura e com validação de dados.
 *
 * Esta classe oferece métodos para ler entradas de diferentes tipos de dados
 * (String, double, int) no console, tratando possíveis erros de formatação
 * e garantindo que a entrada seja válida antes de retornar o valor.
 *
 * @since 2024
 */

public class Util {

    // Instância do scanner para capturar entradas do usuário
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Lê uma entrada de texto (String) do usuário.
     *
     * Este método exibe uma mensagem no console e aguarda que o usuário
     * digite uma entrada de texto. A entrada é retornada após ser
     * limpa de espaços extras no início e fim da string.
     *
     * @param mensagem A mensagem a ser exibida ao usuário solicitando a entrada.
     * @return A entrada de texto fornecida pelo usuário.
     */
    public static String lerEntradaString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine().trim();
    }

    /**
     * Lê uma entrada de número decimal (double) do usuário.
     *
     * Este método exibe uma mensagem no console e aguarda que o usuário
     * forneça um número decimal. Se o usuário fornecer um valor inválido,
     * o método solicita uma nova entrada até que um valor válido seja informado.
     *
     * @param mensagem A mensagem a ser exibida ao usuário solicitando a entrada.
     * @return O número decimal informado pelo usuário.
     */
    public static double lerEntradaDouble(String mensagem) {
        double valor = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print(mensagem);
            try {
                valor = Double.parseDouble(scanner.nextLine().trim());
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número decimal válido.");
            }
        }

        return valor;
    }

    /**
     * Lê uma entrada de número inteiro (int) do usuário.
     *
     * Este método exibe uma mensagem no console e aguarda que o usuário
     * forneça um número inteiro. Se o usuário fornecer um valor inválido,
     * o método solicita uma nova entrada até que um valor válido seja informado.
     *
     * @param mensagem A mensagem a ser exibida ao usuário solicitando a entrada.
     * @return O número inteiro informado pelo usuário.
     */
    public static int lerEntradaInteira(String mensagem) {
        int valor = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print(mensagem);
            try {
                valor = Integer.parseInt(scanner.nextLine().trim());
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro válido.");
            }
        }

        return valor;
    }
}
