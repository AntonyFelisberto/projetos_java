package com.project.kafka.consumer.payments.listener;

import com.project.kafka.consumer.payments.model.Payment;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Log4j2
@Component
@RequiredArgsConstructor
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic",groupId = "create-group",containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment){
        log.info("Pagamento recebido {}",payment.toString());
        log.info("validando fraude");
        sleep(2000);
        log.info("compra aprovada");
        sleep(3000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic",groupId = "pdf-group",containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment){
        log.info("gerando pdf do produto id {}",payment.getId());
        sleep(2000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic",groupId = "email-group",containerFactory = "jsonContainerFactory")
    public void sendEmail(){
        sleep(7000);
        log.info("enviando e-mail");
    }
}
