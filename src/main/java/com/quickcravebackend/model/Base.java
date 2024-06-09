package com.quickcravebackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Base {
    @Id
    protected Long id;

    protected String name;
    protected String password;

    protected String email;
    protected String phone;
    protected String address;
    protected String state;
    protected String date;

/**
    image/portrait 指图片/头像
 **/
    protected String portrait;
    protected String description;
    protected String image;
}