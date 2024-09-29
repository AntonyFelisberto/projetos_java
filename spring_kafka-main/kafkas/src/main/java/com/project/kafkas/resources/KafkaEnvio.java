package com.project.kafkas.resources;

import com.project.kafkas.model.Venda;
import com.project.kafkas.serializer.VendaSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;


public class KafkaEnvio {

    KafkaProducer<String, Venda> producer;

    public  KafkaEnvio() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, VendaSerializer.class.getName());
        producer =  new KafkaProducer<>(properties);
    }

    public void enviar(Venda venda) {
        try {
            while (true){
                ProducerRecord<String, Venda> record = new ProducerRecord<>("venda-ingressos", venda);
                producer.send(record);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
