package com.tech4me.vendaprodutosms.HTTPClient;

import java.util.Optional;

import com.tech4me.vendaprodutosms.shared.Produto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "cadastro-produtos-ms", fallback = CadastroFeignClientFallback.class)
public interface CadastroFeignClient {
    @GetMapping(path = "/api/produtos/{codgo}")
    Optional<Produto> ObterProdutoPorCodgo(@PathVariable String codgo);
    @PutMapping(path = "/api/produtos/{id}")
    Optional<Produto> RetirarEstoque(@PathVariable String id, @RequestBody Produto produto);
    @GetMapping(path = "/api/produtos/codgo/{id}")
    Optional<String> ObterIdPorCodgo(@PathVariable String id);
}

@Component
class CadastroFeignClientFallback implements CadastroFeignClient{
    @Override
    public Optional<Produto> ObterProdutoPorCodgo(@PathVariable String codgo){
        return Optional.empty();
    }
    @Override
    public Optional<Produto> RetirarEstoque(@PathVariable String id, @RequestBody Produto produto){
        return Optional.empty();
    }
    @Override
    public Optional<String> ObterIdPorCodgo(String id) {
        return Optional.empty();
    }
}

