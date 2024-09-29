package com.projeto.kafka.payment.services;


import com.projeto.kafka.payment.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);

}
