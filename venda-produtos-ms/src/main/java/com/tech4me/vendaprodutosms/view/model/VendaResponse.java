package com.tech4me.vendaprodutosms.view.model;

import java.time.LocalDate;

import com.tech4me.vendaprodutosms.shared.Produto;

public class VendaResponse {
    private Produto produto;
    private int quantidade;
    private LocalDate data;

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
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
}
