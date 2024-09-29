package com.project.kafkas.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.kafkas.model.Venda;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class VendaDeserializer implements Deserializer<Venda> {

    @Override
    public Venda deserialize(String topic, byte[] venda) {
        try {
            return new ObjectMapper().readValue(venda,Venda.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
