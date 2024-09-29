package com.project.kafka.consumer.payments.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Payment implements Serializable {
    private Long id;
    private Long idUser;
    private Long idProduct;
    private String cardNumber;
}
