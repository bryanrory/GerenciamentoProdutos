package com.loja.modelo;

import java.util.Objects;

/**
 * Representa um produto no sistema.
 *
 * A classe `Produto` encapsula as informações de um produto, incluindo seu ID,
 * nome, preço, quantidade em estoque e categoria. Ela oferece métodos para acessar
 * e modificar esses atributos, além de métodos auxiliares como `toString()`, `equals()`,
 * e `hashCode()` para facilitar a exibição, comparação e manipulação de objetos do tipo
 * `Produto` dentro de coleções.
 *
 * A classe é utilizada no sistema de gerenciamento de produtos, podendo ser cadastrada,
 * atualizada, buscada e deletada, além de ser exibida de forma legível no menu.
 *
 * @since 2024
 */
public class Produto {
    // Atributos
    private Integer id;
    private String nome;
    private double preco;
    private int quantidadeEstoque;
    private String categoria;

    /**
     * Constrói um objeto Produto com o nome, preço, quantidade em estoque e categoria fornecidos.
     *
     * @param nome Nome do produto.
     * @param preco Preço do produto.
     * @param quantidadeEstoque Quantidade em estoque do produto.
     * @param categoria Categoria do produto.
     */
    public Produto(String nome, double preco, int quantidadeEstoque, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
    }

    /**
     * Retorna o ID do produto.
     *
     * @return ID do produto.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o ID do produto.
     *
     * @param id ID do produto.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retorna o nome do produto.
     *
     * @return Nome do produto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do produto.
     *
     * @param nome Nome do produto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o preço do produto.
     *
     * @return Preço do produto.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o preço do produto.
     *
     * @param preco Preço do produto.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Retorna a quantidade em estoque do produto.
     *
     * @return Quantidade em estoque do produto.
     */
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    /**
     * Define a quantidade em estoque do produto.
     *
     * @param quantidadeEstoque Quantidade em estoque do produto.
     */
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    /**
     * Retorna a categoria do produto.
     *
     * @return Categoria do produto.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Define a categoria do produto.
     *
     * @param categoria Categoria do produto.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Retorna uma representação em formato de string do produto, incluindo
     * o ID, nome, preço, quantidade em estoque e categoria.
     *
     * @return String com as informações do produto.
     */
    @Override
    public String toString() {
        return "ID: " + id +
                " | Nome: " + nome +
                " | Preço: R$ " + preco +
                " | Estoque: " + quantidadeEstoque +
                " | Categoria: " + categoria;
    }

    /**
     * Verifica se dois produtos são iguais, comparando seus IDs.
     *
     * @param o Objeto a ser comparado com o produto atual.
     * @return true se os produtos tiverem o mesmo ID, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    /**
     * Retorna o código de hash do produto com base no ID.
     *
     * @return Código de hash do produto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
