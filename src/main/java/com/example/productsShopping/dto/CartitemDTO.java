package com.example.productsShopping.dto;

import lombok.Data;

@Data
public class CartitemDTO {
    private Long id;
    private Long productId;
    private String brand;
    private String model;
    private String category;
    private String description;
    private double price;
    private double rate;
    private String imageUrl;
    private Integer quantity;
}
