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
public class Orders {
    @Id
    private Long id;

    private String name;
    private String description;
    private String image;
    private String state;
    private String date;

    private String customer;
    private String vendor;
    private String delivery;
    private String payment;
    private String total;

}
