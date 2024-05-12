package com.quickcravebackend.model;

import jakarta.persistence.Entity;

@Entity
public class Vendor extends Base{
    private String category;

    /**  time单位 min  **/
    private Long time;
    private Long fee;
    private String quantity;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

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
