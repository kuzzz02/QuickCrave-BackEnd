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

    /**
     * orders_id: OrderNo, at least 16 figures
     */
    private String orders_id;
    private String goods_id;
    private Long user_id;
    private Long vendor_id;
    private Long delivery_id;

    private String state;
    private String date;
    private String address;
    private String phone;
    private String payment;
    private String total;
}
