package com.tech4me.vendaprodutosms.shared;

public class ProdutoDto {
    private String id;
    private String nome;
    private String codgo;
    private int preco;
    private int quantidade;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
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
    public void setPreco(int preco){
        this.preco = preco;
    }
}

