package com.tech4me.vendaprodutosms.view.model;

import com.tech4me.vendaprodutosms.shared.Produto;

public class VendaResponse {
    private Produto produto;
    private int quantidade;
    private String data;

    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
}
