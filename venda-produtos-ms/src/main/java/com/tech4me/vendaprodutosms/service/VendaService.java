package com.tech4me.vendaprodutosms.service;

import java.util.List;

import com.tech4me.vendaprodutosms.shared.VendaDto;

public interface VendaService {
    List<VendaDto>obterTodos();
    VendaDto adicionarMuica(VendaDto vendaDto);
    void removerVenda(String id);
    VendaDto alterarVenda(String id, VendaDto vendaDto);
}
