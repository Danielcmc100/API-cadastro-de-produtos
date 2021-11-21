package com.tech4me.cadastroprodutosms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tech4me.cadastroprodutosms.model.Produto;
import com.tech4me.cadastroprodutosms.repository.ProdutoRepository;
import com.tech4me.cadastroprodutosms.shared.ProdutoDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
    private ProdutoRepository repository;

    ModelMapper mapper = new ModelMapper();
    
    @Override
    public List<ProdutoDto> obterTodos() {
        List<Produto> produtos = repository.findAll();
        List<ProdutoDto> produtoDtos = produtos.stream()
        .map(p -> mapper.map(p, ProdutoDto.class))
        .collect(Collectors.toList());
        return produtoDtos;
    }

    @Override
    public ProdutoDto adicionarMuica(ProdutoDto produtoDto) {
        Produto produto = mapper.map(produtoDto, Produto.class);
        produto = repository.save(produto);
        produtoDto = mapper.map(produto, produtoDto.getClass());
        return produtoDto;
    }

    @Override
    public void removerProduto(String id) {
        repository.deleteById(id);
    }

    @Override
    public ProdutoDto alterarProduto(String id, ProdutoDto produtoDto) {
        Produto produto = mapper.map(produtoDto, Produto.class);
        produto.setCodgo(id);
        repository.save(produto);
        produtoDto = mapper.map(produto, ProdutoDto.class);
        return produtoDto;
    }

    @Override
    public Optional<ProdutoDto> obterPorId(String id) {
        Optional<Produto> produto = repository.findById(id);
        if(produto.isPresent()){
            Optional<ProdutoDto> produtoDto = Optional.of(mapper.map(produto.get(), ProdutoDto.class));
            return produtoDto;
        }
        return Optional.empty();
    }

    @Override
    public Optional<ProdutoDto> obterProdutoPorCodgo(String codgo) {
        Produto produto = repository.findByCodgo(codgo).get(0);
        if(produto != null){
            ProdutoDto produtoDto = mapper.map(produto, ProdutoDto.class);
            return Optional.of(produtoDto);
        }
        return Optional.empty();
    }
}
