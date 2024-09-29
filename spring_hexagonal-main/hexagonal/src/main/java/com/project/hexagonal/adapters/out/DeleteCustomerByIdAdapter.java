package com.project.hexagonal.adapters.out;

import com.project.hexagonal.adapters.out.repository.CustomerRepository;
import com.project.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {

    private final CustomerRepository custumerRepository;

    @Override
    public void delete(String id){
        custumerRepository.deleteById(id);
    }

}
