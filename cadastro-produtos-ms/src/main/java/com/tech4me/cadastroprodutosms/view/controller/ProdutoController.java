package com.tech4me.cadastroprodutosms.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.tech4me.cadastroprodutosms.service.ProdutoService;
import com.tech4me.cadastroprodutosms.shared.ProdutoDto;
import com.tech4me.cadastroprodutosms.view.model.ProdutoRequest;
import com.tech4me.cadastroprodutosms.view.model.ProdutoResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    private ModelMapper mapper = new ModelMapper();
    
    //Listagem de produtos
    @GetMapping
    private ResponseEntity<List<ProdutoResponse>> obterTodos(){
        List<ProdutoDto> produtoDto = service.obterTodos();
        List<ProdutoResponse> produtoResponses = produtoDto.
        stream().
        map(m -> mapper.map(m, ProdutoResponse.class)).
        collect(Collectors.toList());
        return new ResponseEntity<>(produtoResponses,HttpStatus.OK);
    }

    //Incluir produto
    @PostMapping
    private ResponseEntity<ProdutoResponse> criarProduto(@RequestBody @Valid ProdutoRequest produtoRequest){
        if(service.obterProdutoPorCodgo(produtoRequest.getCodgo()).isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        ProdutoDto produtoDto = mapper.map(produtoRequest, ProdutoDto.class);
        produtoDto = service.adicionarMuica(produtoDto);
        ProdutoResponse produtoResponse = mapper.map(produtoDto, ProdutoResponse.class);
        return new ResponseEntity<>(produtoResponse,HttpStatus.ACCEPTED);
    }
    
    @DeleteMapping(value="/{id}")
    private ResponseEntity<String> removerProduto(@PathVariable String id){
        service.removerProduto(id);
        return new ResponseEntity<>("Removida com sucesso",HttpStatus.OK);
    }

    @PutMapping(value="/{id}")
    private ResponseEntity<Optional<ProdutoResponse>> alterarProduto(@PathVariable String id, @RequestBody @Valid ProdutoRequest produtorRequest) {
        ProdutoDto produtoDto = mapper.map(produtorRequest, ProdutoDto.class);
        produtoDto = service.alterarProduto(id,produtoDto);
        Optional<ProdutoResponse> produtoResponse = Optional.of(mapper.map(produtoDto, ProdutoResponse.class));
        return new ResponseEntity<>(produtoResponse,HttpStatus.OK);
    }
    
    //Consultar produto
    @GetMapping("/{id}")
    private ResponseEntity<Optional<ProdutoResponse>> obterPorCodgo(@PathVariable String id){
        Optional<ProdutoDto> optional = service.obterProdutoPorCodgo(id);
        if(optional.isPresent()){
            Optional<ProdutoResponse> retorno = Optional.of(mapper.map(optional.get(), ProdutoResponse.class));
            return new ResponseEntity<>(retorno,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/codgo/{codgo}")
    private ResponseEntity<Optional<String>> obterIdPorCodgo(@PathVariable String codgo){
        Optional<ProdutoDto> optional = service.obterProdutoPorCodgo(codgo);
        if(optional.isPresent()){
            return new ResponseEntity<>(Optional.of(optional.get().getId()),HttpStatus.OK);
        }
        return new ResponseEntity<>(Optional.empty() ,HttpStatus.NOT_FOUND);
    }
}
