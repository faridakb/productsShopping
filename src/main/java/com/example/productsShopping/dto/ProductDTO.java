package com.example.productsShopping.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String brand;
    private String model;
    private String category;
    private int description;
    private String price;
    private int rate;
    private String imageUrl;

}
