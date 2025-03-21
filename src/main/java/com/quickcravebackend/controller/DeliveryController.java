package com.quickcravebackend.controller;

import com.quickcravebackend.utility.Response;
import com.quickcravebackend.model.Delivery;
import com.quickcravebackend.service.DeliveryService_Imp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    private DeliveryService_Imp deliveryService_Imp;
    
    @PostMapping("/insert")
    public Integer insert(String name, String password, String address, String phone){
        return deliveryService_Imp.insert(name,password,address,phone);
    }

    @PostMapping("/login")
    public ResponseEntity<Response> Login(@RequestBody Delivery delivery) {
        Delivery newDelivery = selectByName(delivery.getName());
        if(newDelivery != null && Objects.equals(newDelivery.getPassword(), delivery.getPassword())){
            return ResponseEntity.ok(new Response("success login"));
        }
        else {
            return ResponseEntity.ok(new Response("fail to login"));
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<Response> Register(@RequestBody Delivery delivery) {
        if(delivery.getName() != null && delivery.getPassword() != null && selectByName(delivery.getName()) == null){
            insert(delivery.getName(),delivery.getPassword(),delivery.getAddress(),delivery.getPhone());
            return ResponseEntity.ok(new Response("success login"));
        }
        else {
            return ResponseEntity.ok(new Response("fail to login"));
        }
    }
    
    @GetMapping("/selectAll")
    public List<Delivery> selectAll() {
        return deliveryService_Imp.selectAll();
    }
    
    @GetMapping("/selectByName")
    public Delivery selectByName(String name) {
        return deliveryService_Imp.selectByName(name);
    }

    @GetMapping("/selectById")
    public Delivery selectById(Long id){
        return deliveryService_Imp.selectById(id);
    }

    @GetMapping("/selectByState")
    public List<Delivery> selectByState(String state){
        return deliveryService_Imp.selectByState(state);
    }

    @DeleteMapping("/delete")
    public Integer delete(Long id){
        return deliveryService_Imp.delete(id);
    }

    @DeleteMapping("/deleteAll")
    public Integer deleteAll(){
        return deliveryService_Imp.deleteAll();
    }

    @PutMapping("/update")
    public Integer update(Long id, String name, String password){
        return deliveryService_Imp.update(id, name, password);
    }

    @PutMapping("/updateState")
    public Integer updateState(Long id, String state){
        return deliveryService_Imp.updateState(id, state);
    }

}
