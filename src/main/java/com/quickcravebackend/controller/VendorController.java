package com.quickcravebackend.controller;

import com.quickcravebackend.Utility.Response;
import com.quickcravebackend.model.Vendor;
import com.quickcravebackend.service.VendorService_Imp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/vendor")
public class VendorController {
    @Autowired
    private VendorService_Imp vendorService_Imp;

    @PostMapping("/insert")
    public Integer insert(String name, String password, String phone, String address, String portrait, String description, String image, String category){
        return vendorService_Imp.insert(name, password, phone, address, portrait, description, image, category);
    }

    @GetMapping("/selectAll")
    public List<Vendor> selectAll() {
        return vendorService_Imp.selectAll();
    }
    @GetMapping("/selectByName")
    public Vendor selectByName(String name) {
        return vendorService_Imp.selectByName(name);
    }

    @GetMapping("/selectById")
    public Vendor selectById(Long id){
        return vendorService_Imp.selectById(id);
    }

    @GetMapping("/selectByCategory")
    public List<Vendor> selectByCategory(String category){
        return vendorService_Imp.selectByCategory(category);
    }

    @GetMapping("/selectVendorWithGoods")
    public List<Vendor> selectVendorWithGoods(Long id){
        return vendorService_Imp.selectVendorWithGoods(id);
    }

    @DeleteMapping("/delete")
    public Integer delete(Long id){
        return vendorService_Imp.delete(id);
    }

    @DeleteMapping("/deleteAll")
    public Integer deleteAll(){
        return vendorService_Imp.deleteAll();
    }

    @PutMapping("/updateName")
    public Integer updateName(Long id, String name){
        return vendorService_Imp.updateName(id, name);
    }

    @PutMapping("/updatePassword")
    public Integer updatePassword(Long id, String password){
        return vendorService_Imp.updatePassword(id, password);
    }

    @PutMapping("/updateEmail")
    public Integer updateEmail(Long id, String email){
        return vendorService_Imp.updateEmail(id, email);
    }

    @PutMapping("/updatePhone")
    public Integer updatePhone(Long id, String phone){
        return vendorService_Imp.updatePhone(id, phone);
    }

    @PutMapping("/updateAddress")
    public Integer updateAddress(Long id, String address){
        return vendorService_Imp.updateAddress(id, address);
    }

    @PutMapping("/updateState")
    public Integer updateState(Long id, String state){
        return vendorService_Imp.updateState(id, state);
    }

    @PutMapping("/updateDate")
    public Integer updateDate(Long id, String date){
        return vendorService_Imp.updateDate(id, date);
    }

    @PutMapping("/updatePortrait")
    public Integer updatePortrait(Long id, String portrait){
        return vendorService_Imp.updatePortrait(id, portrait);
    }

    @PutMapping("/updateDescription")
    public Integer updateDescription(Long id, String description){
        return vendorService_Imp.updateDescription(id, description);
    }

    @PutMapping("/updateImage")
    public Integer updateImage(Long id, String image){
        return vendorService_Imp.updateImage(id, image);
    }

    @PutMapping("/updateCategory")
    public Integer updateCategory(Long id, String category){
        return vendorService_Imp.updateCategory(id, category);
    }

    @PutMapping("/updateTime")
    public Integer updateTime(Long id, Long time){
        return vendorService_Imp.updateTime(id, time);
    }

    @PutMapping("/updateFee")
    public Integer updateFee(Long id, Long fee){
        return vendorService_Imp.updateFee(id, fee);
    }

    @PutMapping("/updateQuantity")
    public Integer updateQuantity(Long id, String quantity){
        return vendorService_Imp.updateQuantity(id, quantity);
    }

    @PostMapping("/login")
    public ResponseEntity<Response> Login(@RequestBody Vendor vendor){
        Vendor newVendor = selectByName(vendor.getName());
        if(newVendor != null && Objects.equals(newVendor.getPassword(), vendor.getPassword())){
            return ResponseEntity.ok(new Response("success login"));
        }
        else {
            return ResponseEntity.ok(new Response("fail to login"));
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<Response> Register(@RequestBody Vendor vendor) {
        if(vendor.getName() != null && vendor.getPassword() != null && selectByName(vendor.getName()) == null){
            insert(vendor.getName(), vendor.getPassword(), vendor.getPhone(), vendor.getAddress(), vendor.getPortrait(), vendor.getDescription(), vendor.getImage(), vendor.getCategory());
            return ResponseEntity.ok(new Response("success login"));
        }
        else {
            return ResponseEntity.ok(new Response("fail to login"));
        }
    }

}
