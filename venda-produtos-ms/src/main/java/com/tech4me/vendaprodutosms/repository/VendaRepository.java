package com.tech4me.vendaprodutosms.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.List;

import com.tech4me.vendaprodutosms.model.Venda;

public interface VendaRepository extends MongoRepository<Venda, String> {
    @Query(value = "{ $and: [ { 'data' : { $gte: ?0 } }, { 'data' : { $lte : ?1 } } ] }")
    List<Venda> obterPorPeriodoData(LocalDate data_inicial, LocalDate data_final);
}
