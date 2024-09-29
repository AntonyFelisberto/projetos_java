package com.project.kafkas.resources;

import com.project.kafkas.model.Venda;
import com.project.kafkas.serializer.VendaDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;


public class KafkaRecebimento {

    KafkaConsumer<String, Venda> consumer;

    public  KafkaRecebimento() {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, VendaDeserializer.class.getName());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "group-process");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        properties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "10");
        consumer = new KafkaConsumer<>(properties);
    }

    public void receber() {
        try {
            consumer.subscribe(Arrays.asList("testejava"));
            while (true) {
                ConsumerRecords<String, Venda> vendas = consumer.poll(Duration.ofSeconds(1));
                for (ConsumerRecord<String, Venda> record : vendas) {
                    Venda venda = record.value();
                    if(new Random().nextBoolean()){
                        venda.setStatus("Aprovado");
                    }else{
                        venda.setStatus("Reprovado");
                    }
                    Thread.sleep(500);
                    System.out.println(venda);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

}
