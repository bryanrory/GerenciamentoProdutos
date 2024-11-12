package com.loja.gerenciador;

import com.loja.exception.ProdutoException;
import com.loja.exception.ValidacaoException;
import com.loja.modelo.Produto;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Classe responsável pelo gerenciamento de produtos.
 *
 * O Gerenciador de Produtos fornece métodos para criar, buscar, listar,
 * atualizar, deletar e realizar buscas específicas (por nome e por categoria)
 * de produtos, além de realizar validações nas entradas de dados.
 *
 * Utiliza uma lista interna para armazenar os produtos e garante que o
 * produto esteja correto antes de ser adicionado ou atualizado.
 *
 * @since 2024
 */
public class GerenciadorProdutos {

    // Lista interna para armazenar os produtos
    private static List<Produto> produtos = new ArrayList<>();

    // Caminho onde salva os produtos cadastrados
    private static final String CAMINHO = System.getProperty("user.dir") + File.separator + "produtos.txt";

    // ID do próximo produto a ser atribuído
    private static int proximoId = 1;

    /**
     * Cria um novo produto e o adiciona à lista.
     *
     * Este método atribui um ID único ao produto, valida os dados e, se válidos,
     * adiciona o produto à lista interna de produtos.
     *
     * @param produto O produto a ser criado e adicionado.
     * @throws ProdutoException Se o produto não passar nas validações (nome, preço, etc.).
     */
    public static void criar(Produto produto) {
        produto.setId(proximoId++);
        validarProduto(produto);
        produtos.add(produto);
    }

    /**
     * Busca um produto pelo seu ID.
     *
     * Este método percorre a lista de produtos e retorna o primeiro produto
     * encontrado com o ID especificado, ou retorna null se o produto não for encontrado.
     *
     * @param id O ID do produto a ser buscado.
     * @return O produto encontrado ou null se não houver produto com o ID fornecido.
     */
    public Produto buscarPorId(int id) {
        return produtos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    /**
     * Retorna uma lista com todos os produtos ordenados por ID.
     *
     * Este método retorna uma nova lista com todos os produtos cadastrados
     * na lista interna, garantindo que a lista interna não seja manipulada diretamente.
     *
     * @return A lista de todos os produtos.
     */
    public List<Produto> listarTodosPorID() {
        return new ArrayList<>(produtos);
    }

    /**
     * Retorna uma lista com todos os produtos ordenados por Preço.
     *
     * Este método retorna uma nova lista com todos os produtos cadastrados
     * na lista interna, garantindo que a lista interna não seja manipulada diretamente.
     *
     * @return A lista de todos os produtos.
     */
    public List<Produto> listarTodosPorPreco() {
        new ArrayList<>(produtos);
        Collections.sort(produtos, Comparator.comparingDouble(Produto::getPreco));
        return produtos;
    }

    /**
     * Retorna uma lista com todos os produtos ordenados por Nome.
     *
     * Este método retorna uma nova lista com todos os produtos cadastrados
     * na lista interna, garantindo que a lista interna não seja manipulada diretamente.
     *
     * @return A lista de todos os produtos.
     */
    public List<Produto> listarTodosPorNome() {
        new ArrayList<>(produtos);
        Collections.sort(produtos, Comparator.comparing(Produto::getNome));
        return produtos;
    }

    /**
     * Atualiza um produto existente.
     *
     * Este método busca o produto pelo ID e, caso encontrado, atualiza seus dados
     * (nome, preço, quantidade em estoque e categoria).
     *
     * @param produto O produto com os novos dados a serem atualizados.
     * @return true se o produto foi atualizado com sucesso, false se o produto não foi encontrado.
     */
    public boolean atualizar(Produto produto) {
        Produto existente = buscarPorId(produto.getId());
        if (existente != null) {
            existente.setNome(produto.getNome());
            existente.setPreco(produto.getPreco());
            existente.setQuantidadeEstoque(produto.getQuantidadeEstoque());
            existente.setCategoria(produto.getCategoria());
            return true;
        }
        return false;
    }

    /**
     * Deleta um produto pelo ID.
     *
     * Este método remove o produto com o ID especificado da lista interna.
     *
     * @param id O ID do produto a ser deletado.
     * @return true se o produto foi removido com sucesso, false se o produto não foi encontrado.
     */
    public boolean deletar(int id) {
        return produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * Busca produtos pelo nome (case insensitive).
     *
     * Este método retorna uma lista de produtos cujo nome contenha a string
     * fornecida, ignorando diferenças de maiúsculas e minúsculas.
     *
     * @param nome O nome ou parte do nome do produto a ser buscado.
     * @return A lista de produtos cujo nome contenha a string fornecida.
     */
    public List<Produto> buscarPorNome(String nome) {
        return produtos.stream()
                .filter(p -> p.getNome().toLowerCase().contains(nome.toLowerCase()))
                .toList();
    }

    /**
     * Busca produtos pela categoria (case insensitive).
     *
     * Este método retorna uma lista de produtos que pertençam à categoria fornecida,
     * ignorando diferenças de maiúsculas e minúsculas.
     *
     * @param categoria A categoria do produto a ser buscado.
     * @return A lista de produtos pertencentes à categoria fornecida.
     */
    public List<Produto> buscarPorCategoria(String categoria) {
        return produtos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                .toList();
    }

    /**
     * Busca produtos dentro de uma faixa de preço específica.
     *
     * @param precoMinimo O preço mínimo da faixa.
     * @param precoMaximo O preço máximo da faixa.
     * @return Lista de produtos dentro da faixa de preço.
     */
    public List<Produto> buscarPorFaixaDePreco(double precoMinimo, double precoMaximo) {
        List<Produto> resultado = new ArrayList<>();

        for (Produto produto : produtos) {
            if (produto.getPreco() >= precoMinimo && produto.getPreco() <= precoMaximo) {
                resultado.add(produto);
            }
        }

        return resultado;
    }

    /**
     * Valida as informações de um produto antes de ser adicionado ou atualizado.
     *
     * Este método realiza validações nos atributos do produto, como o nome, preço,
     * quantidade em estoque e categoria. Se algum atributo não atender aos critérios
     * estabelecidos, uma exceção é lançada.
     *
     * @param produto O produto a ser validado.
     * @throws ProdutoException Se algum atributo do produto não for válido.
     */
    private static void validarProduto(Produto produto) {
        if (produto.getNome() == null || produto.getNome().trim().length() < 2) {
            throw new ProdutoException("O nome do produto deve conter pelo menos 2 caracteres.");
        }

        if (produto.getPreco() <= 0) {
            throw new ProdutoException("O preço do produto deve ser maior que zero.");
        }

        if (produto.getQuantidadeEstoque() < 0) {
            throw new ProdutoException("A quantidade em estoque não pode ser negativa.");
        }

        if (produto.getCategoria() == null || produto.getCategoria().trim().isEmpty()) {
            throw new ProdutoException("A categoria do produto não pode estar vazia.");
        }
    }

    /**
     * Salva os produtos em um arquivo de texto.
     */
    public static void salvarProdutosEmArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO))) {
            for (Produto produto : produtos) {
                writer.write(produto.getId() + "," + produto.getNome() + "," + produto.getPreco() + ","
                        + produto.getQuantidadeEstoque() + "," + produto.getCategoria());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new ValidacaoException("Erro ao salvar os produtos no arquivo." + e);
        }
    }

    /**
     * Carrega os produtos de um arquivo de texto.
     */
    public static void carregarProdutosDeArquivo() {
        File arquivo = new File(CAMINHO);

        // Verifica se o arquivo existe, caso contrário cria um arquivo em branco
        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile(); // Cria o arquivo em branco se não existir
                System.out.println("Arquivo não encontrado, criado arquivo vazio: " + CAMINHO);
            } catch (IOException e) {
                System.out.println("Erro ao criar o arquivo: " + CAMINHO);
                e.printStackTrace();
            }
        }

        // Tenta carregar os produtos do arquivo
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 5) {
                    String nome = dados[1];
                    double preco = Double.parseDouble(dados[2]);
                    int quantidadeEstoque = Integer.parseInt(dados[3]);
                    String categoria = dados[4];

                    Produto produto = new Produto(nome, preco, quantidadeEstoque, categoria);
                    criar(produto);
                }
            }
        } catch (IOException e) {
            throw new ValidacaoException("Erro ao carregar os produtos no arquivo." + e);
        }
    }
}
