package com.example.joinqueryspring.controller;

import com.example.joinqueryspring.dto.OrderDTO;
import com.example.joinqueryspring.model.Customer;
import com.example.joinqueryspring.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class OrdemController {

    private CustomerService customerService;

    @PostMapping("/insertOrder")
    public ResponseEntity<Customer> insertOrder(@RequestBody Customer customer) {
        Customer newCustomer = customerService.addService(customer);
        return ResponseEntity.ok().body(newCustomer);
    }

    @GetMapping("/findAllOrders")
    public ResponseEntity<List<Customer>> findAllOrders(){
        List<Customer> newCustomer = customerService.findAllOrders();
        return new ResponseEntity<>(newCustomer, HttpStatus.OK);
    }

    @GetMapping("/findByDTO")
    public ResponseEntity<List<OrderDTO>> findOrderDTO(){
        List<OrderDTO> orderDTO = customerService.findOrderDTO();
        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }

}
