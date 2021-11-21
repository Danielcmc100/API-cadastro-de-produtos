package com.tech4me.vendaprodutosms.service;

import java.util.List;
import java.util.stream.Collectors;

import com.tech4me.vendaprodutosms.model.Venda;
import com.tech4me.vendaprodutosms.repository.VendaRepository;
import com.tech4me.vendaprodutosms.shared.VendaDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaServiceImpl implements VendaService{

    @Autowired
    private VendaRepository repository;

    ModelMapper mapper = new ModelMapper();
    
    @Override
    public List<VendaDto> obterTodos() {
        List<Venda> vendas = repository.findAll();
        List<VendaDto> vendaDtos = vendas.stream()
        .map(p -> mapper.map(p, VendaDto.class))
        .collect(Collectors.toList());
        return vendaDtos;
    }

    @Override
    public VendaDto adicionarVenda(VendaDto vendaDto) {
        Venda venda = mapper.map(vendaDto, Venda.class);
        venda = repository.save(venda);
        vendaDto = mapper.map(venda, vendaDto.getClass());
        return vendaDto;
    }

    @Override
    public void removerVenda(String id) {
        repository.deleteById(id);
    }

    @Override
    public VendaDto alterarVenda(String id, VendaDto vendaDto) {
        Venda venda = mapper.map(vendaDto, Venda.class);
        venda.setId(id);
        repository.save(venda);
        vendaDto = mapper.map(venda, VendaDto.class);
        return vendaDto;
    } 
    
}
