package com.tech4me.cadastroprodutosms.view.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class ProdutoRequest {
    @NotEmpty(message = "O códgo do produto dever ser preenchido")
    @NotBlank(message = "O códgo não pode estar em branco")
    private String codgo;
    @NotEmpty(message = "O nome do produto dever ser preenchido")
    @NotBlank(message = "O nome não pode estar em branco")
    private String nome;
    @Positive(message = "O preço dever ser maior que zero")
    private float preco;
    @Positive(message = "A quantidade dever ser maior que zero")
    private int quantidade;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCodgo() {
        return codgo;
    }
    public void setCodgo(String codgo) {
        this.codgo = codgo;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
