package com.tech4me.cadastroprodutosms.service;

import java.util.List;
import java.util.Optional;

import com.tech4me.cadastroprodutosms.shared.ProdutoDto;

public interface ProdutoService {
    List<ProdutoDto>obterTodos();
    Optional<ProdutoDto>obterPorId(String id);
    ProdutoDto adicionarMuica(ProdutoDto produtoDto);
    void removerProduto(String id);
    ProdutoDto alterarProduto(String id, ProdutoDto produtoDto);
}
