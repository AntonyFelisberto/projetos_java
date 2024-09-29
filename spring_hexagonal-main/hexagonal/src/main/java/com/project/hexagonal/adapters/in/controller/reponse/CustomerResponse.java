package com.project.hexagonal.adapters.in.controller.reponse;

import lombok.Data;

@Data
public class CustomerResponse {

    private String name;
    private AddressResponse address;
    private String cpf;
    private Boolean isValidCpf;

}
