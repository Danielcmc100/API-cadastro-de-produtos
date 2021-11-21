package com.tech4me.cadastroprodutosms.view.model;

public class ProdutoResponse {
    private String codgo;
    private String nome;
    private int preco;
    private int quantidade;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public String getCodgo() {
        return codgo;
    }
    public void setCodgo(String codgo) {
        this.codgo = codgo;
    }
    public int getPreco() {
        return preco;
    }
    public void setPreco(int preco) {
        this.preco = preco;
    }   
    
}