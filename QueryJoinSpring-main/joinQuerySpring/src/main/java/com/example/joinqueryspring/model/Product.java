package com.example.joinqueryspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    private int productId;
    private String productName;
    private int quantity;
    private int price;

}
