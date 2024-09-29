package com.projeto.kafka.payment.resource.impl;

import com.projeto.kafka.payment.model.Payment;
import com.projeto.kafka.payment.services.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Log4j2
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @Override
    @SneakyThrows
    public void sendPayment(Payment payment) {
        log.info("PAYMENT SERVICE IMPL >>> RECEBIDO PAGAMENTO {}",payment);
        Thread.sleep(1000);
        log.info("Enviando Pagamento");
        kafkaTemplate.send("payment-topic",payment);
    }

}
