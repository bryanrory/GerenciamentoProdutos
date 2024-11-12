package com.loja.ui;

import com.loja.gerenciador.GerenciadorProdutos;
import com.loja.modelo.Produto;
import com.loja.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que exibe o menu de opções para o gerenciamento de produtos.
 *
 * A classe `MenuProdutos` é responsável por apresentar as opções do sistema de
 * gerenciamento de produtos ao usuário, interagindo com o usuário para realizar
 * operações como cadastrar, buscar, listar, atualizar e excluir produtos.
 * Além disso, fornece funcionalidades de busca por nome e categoria, permitindo
 * a consulta de produtos específicos.
 *
 * A classe interage diretamente com a classe `GerenciadorProdutos`, que gerencia
 * as operações no conjunto de produtos, e a classe `Util`, que fornece métodos
 * auxiliares para ler entradas do usuário.
 *
 * @since 2024
 */
public class MenuProdutos {

    // Instância do gerenciador de produtos
    private final GerenciadorProdutos gerenciador = new GerenciadorProdutos();

    /**
     * Exibe o menu de opções para o gerenciamento de produtos e executa as
     * ações correspondentes conforme a escolha do usuário.
     */
    public void exibirMenu() {
        int opcao;
        do {
            // Exibe as opções do menu
            System.out.println("");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Buscar Produto por ID");
            System.out.println("3. Listar Todos os Produtos (Por ID)");
            System.out.println("4. Listar Todos os Produtos (Por Nome)");
            System.out.println("5. Listar Todos os Produtos (Por Preço)");
            System.out.println("6. Atualizar Produto");
            System.out.println("7. Deletar Produto");
            System.out.println("8. Buscar por Nome");
            System.out.println("9. Buscar por Categoria");
            System.out.println("10. Buscar por Faixa de Preço");
            System.out.println("11. Sair");
            System.out.println("");
            opcao = Util.lerEntradaInteira("Escolha uma opção: ");
            System.out.println("");

            // Executa a opção escolhida
            switch (opcao) {
                case 1 -> cadastrarProduto();
                case 2 -> buscarProduto();
                case 3 -> listarProdutosPorID();
                case 4 -> listarProdutosPorNome();
                case 5 -> listarProdutosPorPreco();
                case 6 -> atualizarProduto();
                case 7 -> deletarProduto();
                case 8 -> buscarPorNome();
                case 9 -> buscarPorCategoria();
                case 10 -> buscarPorFaixaDePreco();
                case 11 -> {
                    System.out.println("Saindo...");
                    GerenciadorProdutos.salvarProdutosEmArquivo();
                    break;
                }
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 11);
    }

    /**
     * Realiza o cadastro de um novo produto.
     *
     * Solicita ao usuário as informações do produto (nome, preço, quantidade
     * em estoque e categoria), cria um novo objeto `Produto` e o adiciona
     * ao gerenciador de produtos.
     */
    private void cadastrarProduto() {
        System.out.println("=== Cadastro de Produto ===");
        String nome = Util.lerEntradaString("Digite o nome do produto: ");
        double preco = Util.lerEntradaDouble("Digite o preço do produto: ");
        int quantidadeEstoque = Util.lerEntradaInteira("Digite a quantidade em estoque: ");
        String categoria = Util.lerEntradaString("Digite a categoria do produto: ");

        Produto produto = new Produto(nome, preco, quantidadeEstoque, categoria);

        gerenciador.criar(produto);
        System.out.println("Produto cadastrado com sucesso! ID: " + produto.getId());
    }

    /**
     * Realiza a busca de um produto pelo seu ID.
     *
     * Solicita ao usuário o ID do produto a ser buscado e, se encontrado,
     * exibe as informações do produto. Caso contrário, informa que o produto
     * não foi encontrado.
     */
    private void buscarProduto() {
        System.out.println("=== Busca de Produto ===");
        int id = Util.lerEntradaInteira("Digite o ID do produto: ");
        Produto produto = gerenciador.buscarPorId(id);
        if (produto != null) {
            System.out.println("Produto encontrado: " + produto);
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }

    /**
     * Exibe todos os produtos cadastrados ordenados por ID.
     *
     * Lista todos os produtos no sistema ordenando por ID, exibindo suas informações. Se não
     * houver produtos cadastrados, uma mensagem informando isso será mostrada.
     */
    private void listarProdutosPorID() {
        System.out.println("=== Lista de Produtos (Ordenados por ID) ===");
        List<Produto> produtos = gerenciador.listarTodosPorID();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            produtos.forEach(System.out::println);
        }
    }

    /**
     * Exibe todos os produtos cadastrados ordenados por Nome.
     *
     * Lista todos os produtos no sistema ordenando por Nome, exibindo suas informações. Se não
     * houver produtos cadastrados, uma mensagem informando isso será mostrada.
     */
    private void listarProdutosPorNome() {
        System.out.println("=== Lista de Produtos (Ordenados por Nome) ===");
        List<Produto> produtos = gerenciador.listarTodosPorNome();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            produtos.forEach(System.out::println);
        }
    }

    /**
     * Exibe todos os produtos cadastrados ordenados por Preço.
     *
     * Lista todos os produtos no sistema ordenando por Preço, exibindo suas informações. Se não
     * houver produtos cadastrados, uma mensagem informando isso será mostrada.
     */
    private void listarProdutosPorPreco() {
        System.out.println("=== Lista de Produtos (Ordenados por Preço) ===");
        List<Produto> produtos = gerenciador.listarTodosPorPreco();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            produtos.forEach(System.out::println);
        }
    }

    /**
     * Realiza a atualização de um produto existente.
     *
     * Solicita ao usuário o ID do produto a ser atualizado, e em seguida
     * permite que o usuário altere o nome, preço, quantidade em estoque e
     * categoria. Se o produto for encontrado e atualizado com sucesso,
     * uma mensagem de sucesso é exibida.
     */
    private void atualizarProduto() {
        System.out.println("=== Atualização de Produto ===");
        int id = Util.lerEntradaInteira("Digite o ID do produto a ser atualizado: ");
        Produto produtoExistente = gerenciador.buscarPorId(id);
        if (produtoExistente != null) {
            String novoNome = Util.lerEntradaString("Digite o novo nome do produto (atual: " + produtoExistente.getNome() + "): ");
            double novoPreco = Util.lerEntradaDouble("Digite o novo preço (atual: " + produtoExistente.getPreco() + "): ");
            int novaQuantidade = Util.lerEntradaInteira("Digite a nova quantidade em estoque (atual: " + produtoExistente.getQuantidadeEstoque() + "): ");
            String novaCategoria = Util.lerEntradaString("Digite a nova categoria (atual: " + produtoExistente.getCategoria() + "): ");

            Produto produtoAtualizado = new Produto(novoNome, novoPreco, novaQuantidade, novaCategoria);
            produtoAtualizado.setId(id); // Mantém o ID do produto existente
            if (gerenciador.atualizar(produtoAtualizado)) {
                System.out.println("Produto atualizado com sucesso!");
            } else {
                System.out.println("Falha ao atualizar o produto.");
            }
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }

    /**
     * Realiza a exclusão de um produto pelo ID.
     *
     * Solicita ao usuário o ID do produto a ser excluído. Se o produto for
     * encontrado e removido com sucesso, uma mensagem de sucesso é exibida.
     * Caso contrário, informa que o produto não foi encontrado.
     */
    private void deletarProduto() {
        System.out.println("=== Exclusão de Produto ===");
        int id = Util.lerEntradaInteira("Digite o ID do produto a ser deletado: ");
        if (gerenciador.deletar(id)) {
            System.out.println("Produto deletado com sucesso.");
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }

    /**
     * Realiza a busca de produtos por nome.
     *
     * Solicita ao usuário o nome (ou parte do nome) do produto e exibe todos
     * os produtos cujo nome contenha a string fornecida. Se nenhum produto for
     * encontrado, uma mensagem informando isso será exibida.
     */
    private void buscarPorNome() {
        System.out.println("=== Busca de Produtos por Nome ===");
        String nome = Util.lerEntradaString("Digite o nome ou parte do nome do produto: ");
        List<Produto> produtos = gerenciador.buscarPorNome(nome);
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado com o nome \"" + nome + "\".");
        } else {
            produtos.forEach(System.out::println);
        }
    }

    /**
     * Realiza a busca de produtos por categoria.
     *
     * Solicita ao usuário a categoria do produto e exibe todos os produtos
     * pertencentes a essa categoria. Se nenhum produto for encontrado, uma
     * mensagem informando isso será exibida.
     */
    private void buscarPorCategoria() {
        System.out.println("=== Busca de Produtos por Categoria ===");
        String categoria = Util.lerEntradaString("Digite a categoria do produto: ");
        List<Produto> produtos = gerenciador.buscarPorCategoria(categoria);
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado na categoria \"" + categoria + "\".");
        } else {
            produtos.forEach(System.out::println);
        }
    }

    /**
     * Realiza a busca de produtos por faixa de preço.
     *
     * Solicita ao usuário o preço inicial e o preço final e exibe todos os produtos
     * pertencentes a essa faixa de preço. Se nenhum produto for encontrado, uma
     * mensagem informando isso será exibida.
     */
    private void buscarPorFaixaDePreco() {
        System.out.println("=== Busca de Produtos por Faixa de Preço ===");
        Double precoIni = Util.lerEntradaDouble("Digite o preço inicial: ");
        Double precoFin = Util.lerEntradaDouble("Digite o preço final: ");
        List<Produto> produtos = gerenciador.buscarPorFaixaDePreco(precoIni, precoFin);

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado na faixa de preço entre \"" + String.valueOf(precoIni) + "\" e \"" + String.valueOf(precoFin) + "\".");
        } else {
            produtos.forEach(System.out::println);
        }
    }
}
