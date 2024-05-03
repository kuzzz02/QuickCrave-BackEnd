package com.quickcravebackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    @Id
    private Long id;

    private String name;
    private String description;
    private String image;
    private String state;
    private String date;

    private String price;
    private String category;
    private String quantity;
    private String discount;

}
