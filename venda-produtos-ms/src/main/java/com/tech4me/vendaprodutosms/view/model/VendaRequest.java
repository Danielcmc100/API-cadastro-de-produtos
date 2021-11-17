package com.tech4me.vendaprodutosms.view.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class VendaRequest {
    @NotBlank(message = "O produto não pode estar em branco")
    @NotEmpty(message = "O produto tem que ser preenchido")
    private String produto;
    @Min(1)
    private int quantidade;
    @NotBlank(message = "A data não pode estar em branco")
    @NotEmpty(message = "a data tem que ser preenchida")
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
