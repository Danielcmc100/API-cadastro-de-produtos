package com.tech4me.vendaprodutosms.HTTPClient;

import java.util.ArrayList;
import java.util.List;

import com.tech4me.vendaprodutosms.shared.ProdutoDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "cadastro-produtos-ms", fallback = CadastroFeignClientFallback.class)
public interface CadastroFeignClient {
    @GetMapping(path = "/api/produtos")
    List<ProdutoDto> ObterProdutos();
}

@Component
class CadastroFeignClientFallback implements CadastroFeignClient{

    @Override
    public
    List<ProdutoDto> ObterProdutos(){
        return new ArrayList<>();
    }
}

