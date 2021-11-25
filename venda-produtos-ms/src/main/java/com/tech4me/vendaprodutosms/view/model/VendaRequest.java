package com.tech4me.vendaprodutosms.view.model;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class VendaRequest {
    @NotNull(message = "O produto não pode estar em branco")
    private String codgoProduto;
    @NotNull(message = "A quandtidade não pode estar em branco")
    @Min(1)
    private int quantidade;
    @NotNull(message = "A data não pode estar em branco")
    private LocalDate data;
    
    public String getCodgoProduto() {
        return codgoProduto;
    }
    public void setCodgoProduto(String codgoProduto) {
        this.codgoProduto = codgoProduto;
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
    public void setData(LocalDate date) {
        data = date; 
    }

    
}
