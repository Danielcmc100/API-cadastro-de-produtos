package com.tech4me.vendaprodutosms.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.tech4me.vendaprodutosms.model.Venda;

public interface VendaRepository extends MongoRepository<Venda, String> {
    
}
