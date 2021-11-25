package com.tech4me.vendaprodutosms.service;

import java.time.LocalDate;
import java.util.List;

import com.tech4me.vendaprodutosms.shared.VendaDto;

public interface VendaService {
    List<VendaDto>obterTodos();
    VendaDto adicionarVenda(VendaDto vendaDto);
    void removerVenda(String id);
    VendaDto alterarVenda(String id, VendaDto vendaDto);
    List<VendaDto>vendasPorPeriodo(LocalDate data_inicial, LocalDate data_final);
}
