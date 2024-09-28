package com.example.joinqueryspring.service;

import com.example.joinqueryspring.dto.OrderDTO;
import com.example.joinqueryspring.model.Customer;
import com.example.joinqueryspring.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    public Customer addService(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> findAllOrders() {
        return customerRepository.findAll();
    }

    public List<OrderDTO> findOrderDTO() {
        return customerRepository.getJoinInformation();
    }

}
