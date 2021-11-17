package com.tech4me.cadastroprodutosms.view.controller;

import java.util.List;
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

    @GetMapping
    private ResponseEntity<List<ProdutoResponse>> obterTodos(){
        List<ProdutoDto> produtoDto = service.obterTodos();
        List<ProdutoResponse> produtoResponses = produtoDto.
        stream().
        map(m -> mapper.map(m, ProdutoResponse.class)).
        collect(Collectors.toList());
        return new ResponseEntity<>(produtoResponses,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<List<ProdutoResponse>> obterPorId(@PathVariable String id){
        List<ProdutoDto> produtoDto = service.obterTodos();
        List<ProdutoResponse> produtoResponses = produtoDto.
        stream().
        map(m -> mapper.map(m, ProdutoResponse.class)).
        collect(Collectors.toList());
        return new ResponseEntity<>(produtoResponses,HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<ProdutoResponse> criarProduto(@RequestBody @Valid ProdutoRequest produtoRequest){
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
    private ResponseEntity<ProdutoResponse> alterarProduto(@PathVariable String id, @RequestBody @Valid ProdutoRequest produtorRequest) {
        ProdutoDto produtoDto = mapper.map(produtorRequest, ProdutoDto.class);
        produtoDto = service.adicionarMuica(produtoDto);
        ProdutoResponse produtoResponse = mapper.map(produtoDto, ProdutoResponse.class);
        return new ResponseEntity<>(produtoResponse,HttpStatus.OK);
    }
    
    
}
