package com.tech4me.cadastroprodutosms.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

import com.tech4me.cadastroprodutosms.model.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
    
    public List<Produto> findByCodgo(String codgo);
}
