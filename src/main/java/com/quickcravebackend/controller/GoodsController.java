package com.quickcravebackend.controller;

import com.quickcravebackend.model.Goods;
import com.quickcravebackend.service.GoodsService_Imp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService_Imp goodsService_Imp;

    @PostMapping("/insert")
    public Integer insert(String name, String description, String image, String number, String price, String discount, Long vendor_id){
        return goodsService_Imp.insert(name, description, image, number, price, discount, vendor_id);
    }

    @GetMapping("/selectAll")
    public List<Goods> selectAll(){
        return goodsService_Imp.selectAll();
    }

    @GetMapping("/selectByName")
    public Goods selectByName(String name){
        return goodsService_Imp.selectByName(name);
    }

    @GetMapping("/selectById")
    public Goods selectById(Long id){
        return goodsService_Imp.selectById(id);
    }

    @DeleteMapping("/delete")
    public Integer delete(Long id){
        return goodsService_Imp.delete(id);
    }

    @DeleteMapping("/deleteAll")
    public Integer deleteAll(){
        return goodsService_Imp.deleteAll();
    }

    @PutMapping("/updateName")
    public Integer updateName(Long id, String name){
        return goodsService_Imp.updateName(id, name);
    }

    @PutMapping("/updateDescription")
    public Integer updateDescription(Long id, String description){
        return goodsService_Imp.updateDescription(id, description);
    }

    @PutMapping("/updateImage")
    public Integer updateImage(Long id, String image){
        return goodsService_Imp.updateImage(id, image);
    }

    @PutMapping("/updateNumber")
    public Integer updateNumber(Long id, String number){
        return goodsService_Imp.updateNumber(id, number);
    }

    @PutMapping("/updatePrice")
    public Integer updatePrice(Long id, String price){
        return goodsService_Imp.updatePrice(id, price);
    }

    @PutMapping("/updateDiscount")
    public Integer updateDiscount(Long id, String discount){
        return goodsService_Imp.updateDiscount(id, discount);
    }

    @PutMapping("/updateVendor")
    public Integer updateVendor(Long id, Long vendor_id){
        return goodsService_Imp.updateVendor(id, vendor_id);
    }
}
