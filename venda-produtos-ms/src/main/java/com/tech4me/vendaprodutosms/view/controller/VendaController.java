package com.tech4me.vendaprodutosms.view.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.tech4me.vendaprodutosms.HTTPClient.CadastroFeignClient;
import com.tech4me.vendaprodutosms.service.VendaService;
import com.tech4me.vendaprodutosms.shared.ProdutoDto;
import com.tech4me.vendaprodutosms.shared.VendaDto;
import com.tech4me.vendaprodutosms.view.model.VendaRequest;
import com.tech4me.vendaprodutosms.view.model.VendaResponse;

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
@RequestMapping("/api/vendas")
public class VendaController {

    @Autowired
    private VendaService service;

    private ModelMapper mapper = new ModelMapper();

    @Autowired
    private CadastroFeignClient cFeignClient;

    
    @GetMapping
    private ResponseEntity<List<VendaResponse>> obterTodos(){
        List<VendaDto> vendaDto = service.obterTodos();
        List<VendaResponse> vendaResponses = vendaDto.
        stream().
        map(m -> mapper.map(m, VendaResponse.class)).
        collect(Collectors.toList());
        return new ResponseEntity<>(vendaResponses,HttpStatus.OK);
    }

    @GetMapping("/teste")
    private ResponseEntity<List<ProdutoDto>> obterProdutos(){
        List<ProdutoDto> vendaResponses = cFeignClient.ObterProdutos();
        return new ResponseEntity<>(vendaResponses,HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<VendaResponse> criarVenda(@RequestBody @Valid VendaRequest vendaRequest){
        VendaDto vendaDto = mapper.map(vendaRequest, VendaDto.class);
        vendaDto = service.adicionarMuica(vendaDto);
        VendaResponse vendaResponse = mapper.map(vendaDto, VendaResponse.class);
        return new ResponseEntity<>(vendaResponse,HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value="/{id}")
    private ResponseEntity<String> removerVenda(@PathVariable String id){
        service.removerVenda(id);
        return new ResponseEntity<>("Removida com sucesso",HttpStatus.OK);
    }

    @PutMapping(value="/{id}")
    private ResponseEntity<VendaResponse> alterarVenda(@PathVariable String id, @RequestBody @Valid VendaRequest vendarRequest) {
        VendaDto vendaDto = mapper.map(vendarRequest, VendaDto.class);
        vendaDto = service.adicionarMuica(vendaDto);
        VendaResponse vendaResponse = mapper.map(vendaDto, VendaResponse.class);
        return new ResponseEntity<>(vendaResponse,HttpStatus.OK);
    }
    
    
}
