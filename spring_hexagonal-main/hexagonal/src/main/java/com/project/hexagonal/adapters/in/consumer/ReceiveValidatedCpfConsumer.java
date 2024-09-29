package com.project.hexagonal.adapters.in.consumer;

import com.project.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.project.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.project.hexagonal.application.ports.in.UpdateCustomerInputPort;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReceiveValidatedCpfConsumer {

    private UpdateCustomerInputPort updateCustomerInputPort;

    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated",groupId = "arantes")
    public void receive(CustomerMessage customerMessage){
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer,customerMessage.getZipCode());
    }

}
