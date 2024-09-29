package com.project.hexagonal.adapters.out;

import com.project.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.project.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.project.hexagonal.application.core.domain.Address;
import com.project.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    private final FindAddressByZipCodeClient findAddressByZipCodeClient;

    private final AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }

}
