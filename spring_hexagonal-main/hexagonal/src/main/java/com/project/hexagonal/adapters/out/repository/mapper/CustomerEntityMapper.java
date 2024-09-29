package com.project.hexagonal.adapters.out.repository.mapper;

import com.project.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.project.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    @Mapping(target = "addressEntity", source = "address")
    CustomerEntity toCustomerEntity(Customer customer);

    @Mapping(target = "address", source = "addressEntity")
    Customer toCustomer(CustomerEntity customerEntity);

}
