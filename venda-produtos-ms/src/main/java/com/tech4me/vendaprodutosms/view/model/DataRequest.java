package com.tech4me.vendaprodutosms.view.model;

import java.time.LocalDate;

public class DataRequest {
    LocalDate data_inicial;
    LocalDate data_final;
    public LocalDate getData_inicial() {
        return data_inicial;
    }
    public void setData_inicial(LocalDate data_inicial) {
        this.data_inicial = data_inicial;
    }
    public LocalDate getData_final() {
        return data_final;
    }
    public void setData_final(LocalDate data_final) {
        this.data_final = data_final;
    }

    
}
