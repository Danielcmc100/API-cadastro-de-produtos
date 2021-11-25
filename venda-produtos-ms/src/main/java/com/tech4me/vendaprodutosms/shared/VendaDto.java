package com.tech4me.vendaprodutosms.shared;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VendaDto {
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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

    /* public void setData(String data) {
        this.data = LocalDate.parse(data,formato);
    } */

    public void setData(LocalDate data) {
        this.data = data;
    }
}
