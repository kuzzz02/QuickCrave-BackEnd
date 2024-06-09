package com.quickcravebackend.controller;

import com.quickcravebackend.model.Orders;
import com.quickcravebackend.service.OrdersService_Imp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService_Imp ordersService_Imp;

    @PostMapping("/insert")
    public Integer insert(String orders_id, String goods_id, Long user_id, Long vendor_id, Long delivery_id, String state, String date, String address, String phone, String payment, String total){
        return ordersService_Imp.insert(orders_id, goods_id, user_id, vendor_id, delivery_id, state, date, address, phone, payment, total);
    }

    @PostMapping("/create")
    public ResponseEntity<Orders> create(@RequestBody Orders orders) {
        Orders newOrders = selectByOrdersId(orders.getOrders_id());
        if (newOrders != null) {
            insert(orders.getOrders_id(), orders.getGoods_id(), orders.getUser_id(), orders.getVendor_id(), orders.getDelivery_id(), orders.getState(), orders.getDate(), orders.getAddress(), orders.getPhone(), orders.getPayment(), orders.getTotal());
            return ResponseEntity.ok(newOrders);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete")
    public Integer delete(Long id){
        return ordersService_Imp.delete(id);
    }

    @DeleteMapping("/deleteAll")
    public Integer deleteAll(){
        return ordersService_Imp.deleteAll();
    }

    @GetMapping("/selectAll")
    public List<Orders> selectAll(){
        return ordersService_Imp.selectAll();
    }

    @GetMapping("/selectByOrdersId")
    public Orders selectByOrdersId(String orders_id){
        return ordersService_Imp.selectByOrdersId(orders_id);
    }

    @PutMapping("/updateState")
    public Integer updateState(Long id, String state){
        return ordersService_Imp.updateState(id, state);
    }
}
