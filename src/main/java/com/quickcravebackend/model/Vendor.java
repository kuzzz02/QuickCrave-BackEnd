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
public class Vendor {
    @Id
    private Long id;

    private String name;
    private String password;

    private String email;
    private String phone;
    private String address;
    private String state;
    private String description;
    private String image;
}
