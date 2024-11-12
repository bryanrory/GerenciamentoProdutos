package com.loja;

import com.loja.ui.MenuProdutos;
import com.loja.gerenciador.GerenciadorProdutos;

/**
 * Classe principal do sistema de Gerenciamento de Produtos.
 *
 * Esta classe inicializa o sistema, cria uma instância do menu principal
 * e executa o loop de interação com o usuário para as operações de CRUD
 * e gerenciamento de produtos.
 *
 * Estrutura do Sistema:
 * - modelo: Contém a classe Produto e outras entidades de dados.
 * - gerenciador: Gerencia as operações de CRUD com uma lista de produtos.
 * - ui: Interface de interação com o usuário através do console.
 * - util: Contém classes utilitárias (não implementado neste exemplo).
 * - exception: Definição de exceções personalizadas para o sistema.
 *
 * @since 2024
 */
public class Main {
    /**
     * Método principal que inicializa o sistema de gerenciamento de produtos.
     *
     * Este método cria uma instância de MenuProdutos, que gerencia a interação
     * com o usuário por meio de um menu no console. O método {@code exibirMenu()}
     * do MenuProdutos inicia o loop principal, onde o usuário pode realizar
     * operações como cadastro, atualização, busca e remoção de produtos.
     *
     * @param args Argumentos de linha de comando (não utilizados neste programa).
     */
    public static void main(String[] args) {
        GerenciadorProdutos.carregarProdutosDeArquivo();
        MenuProdutos menu = new MenuProdutos();
        menu.exibirMenu();
    }
}
