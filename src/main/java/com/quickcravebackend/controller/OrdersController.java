package com.quickcravebackend.controller;

import com.quickcravebackend.model.Orders;
import com.quickcravebackend.service.OrdersService_Imp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService_Imp ordersService_Imp;

    @PostMapping("/insert")
    public Integer insert(Long id, Long goods_id, Long user_id, Long vendor_id, Long delivery_id, String state, String date, String address, String price, String total){
        return ordersService_Imp.insert(id, goods_id, user_id, vendor_id, delivery_id, state, date, address, price, total);
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

    @GetMapping("/selectById")
    public Orders selectById(Long id){
        return ordersService_Imp.selectById(id);
    }
}
