package com.example.joinqueryspring.repository;

import com.example.joinqueryspring.dto.OrderDTO;
import com.example.joinqueryspring.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query("SELECT new com.example.joinqueryspring.dto.OrderDTO(c.name ,p.productName,p.productId) FROM Customer c JOIN c.products p")
    public List<OrderDTO> getJoinInformation();

}
/*
    EXPLICAÇÃO QUERY

    @Query("SELECT new com.example.joinqueryspring.dto.OrderDTO(c.name ,p.productName,p.productId) FROM Customer c JOIN c.products p")
            | CONVERTENDO OS DADOS RECUPERADOS PARA O DTO      | SELECIONANDO OS DADOS           | TABELA CLIENTE  | USANDO O DADO DA TABELA DE CLIENTES PARA FAZER UM JOIN
*/