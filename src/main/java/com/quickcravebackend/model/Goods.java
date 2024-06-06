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
    private String number;

    private String price;
    private String discount;

    private Long vendor_id;

}
