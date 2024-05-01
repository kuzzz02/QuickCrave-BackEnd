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
public class User{
    @Id
    private Long id;

    private String username;
    private String password;

/**
 * TODO:more fields to be added
 */
}
