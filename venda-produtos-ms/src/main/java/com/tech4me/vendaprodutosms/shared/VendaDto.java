package com.tech4me.vendaprodutosms.shared;

public class VendaDto {
    private String produto;
    private int quantidade;
    private String data;
    
    public String getProduto() {
        return produto;
    }
    public void setProduto(String produto) {
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

