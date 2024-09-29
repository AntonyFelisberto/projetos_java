package com.project.kafka.consumer.listeners;

import com.project.kafka.consumer.custom.StrConsumerCustomListener;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class StrConsumerListener {

    @SneakyThrows
    @StrConsumerCustomListener(groupId = "group-1")
    public void listener(String message){
        log.info("Received message {}",message);
        throw new IllegalArgumentException("Exception");
    }

    @SneakyThrows
    @StrConsumerCustomListener(groupId = "group-1")
    public void log(String message){
        log.info("log Received message {}",message);
        throw new IllegalArgumentException("Exception");
    }

    @KafkaListener(groupId = "group-2", topics = "str-topic",containerFactory = "validMessageContainerFactory")
    public void validate(String message){
        log.info("validate Received message {}",message);
    }

}
