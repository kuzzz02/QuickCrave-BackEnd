package com.quickcravebackend.model;

import jakarta.persistence.Entity;

@Entity
public class Vendor extends Base{
    private Long time;
    private Long fee;
    private String quantity;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
