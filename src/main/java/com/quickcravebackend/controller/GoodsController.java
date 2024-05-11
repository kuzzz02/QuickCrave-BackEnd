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
    public Integer insert(String name, String description, String image, String state, String date, String price, String category, String quantity, String discount){
        return goodsService_Imp.insert(name, description, image, state, date, price, category, quantity, discount);
    }

    @DeleteMapping("/delete")
    public Integer delete(Long id){
        return goodsService_Imp.delete(id);
    }

    @DeleteMapping("/deleteAll")
    public Integer deleteAll(){
        return goodsService_Imp.deleteAll();
    }

    @GetMapping("/selectAll")
    public List<Goods> selectAll(){
        return goodsService_Imp.selectAll();
    }

    @GetMapping("/selectById")
    public Goods selectById(Long id){
        return goodsService_Imp.selectById(id);
    }

    @GetMapping("/selectByName")
    public Goods selectByName(String name){
        return goodsService_Imp.selectByName(name);
    }

    @GetMapping("/selectByCategory")
    public List<Goods> selectByCategory(String category){
        return goodsService_Imp.selectByCategory(category);
    }

    @PutMapping("/update")
    public Integer update(Long id) {
        return goodsService_Imp.update(id);
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

    @PutMapping("/updateState")
    public Integer updateState(Long id, String state){
        return goodsService_Imp.updateState(id, state);
    }

    @PutMapping("/updateDate")
    public Integer updateDate(Long id, String date){
        return goodsService_Imp.updateDate(id, date);
    }

    @PutMapping("/updatePrice")
    public Integer updatePrice(Long id, String price){
        return goodsService_Imp.updatePrice(id, price);
    }

    @PutMapping("/updateCategory")
    public Integer updateCategory(Long id, String category){
        return goodsService_Imp.updateCategory(id, category);
    }

    @PutMapping("/updateDiscount")
    public Integer updateDiscount(Long id, String discount){
        return goodsService_Imp.updateDiscount(id, discount);
    }

    @PutMapping("/updateQuantity")
    public Integer updateQuantity(Long id, String quantity){
        return goodsService_Imp.updateQuantity(id, quantity);
    }
}
