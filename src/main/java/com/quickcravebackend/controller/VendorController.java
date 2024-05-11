package com.quickcravebackend.controller;

import com.quickcravebackend.model.User;
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
    public Integer insert(String name, String password){
        return vendorService_Imp.insert(name,password);
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

    @DeleteMapping("/delete")
    public Integer delete(Long id){
        return vendorService_Imp.delete(id);
    }

    @DeleteMapping("/deleteAll")
    public Integer deleteAll(){
        return vendorService_Imp.deleteAll();
    }

    @PutMapping("/update")
    public Integer update(Long id){
        return vendorService_Imp.update(id);
    }

    @GetMapping("/login")
    public ResponseEntity<Vendor> Login(Vendor vendor){
        Vendor newVendor = selectByName(vendor.getName());
        if(newVendor != null && Objects.equals(newVendor.getPassword(), vendor.getPassword())){
            return ResponseEntity.ok(newVendor);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/signup")
    public ResponseEntity<Vendor> Register(@RequestBody Vendor vendor) {
        if(vendor.getName() != null && vendor.getPassword() != null && selectByName(vendor.getName()) == null){
            insert(vendor.getName(),vendor.getPassword());
            Vendor newVendor = selectByName(vendor.getName());
            return ResponseEntity.ok(newVendor);
        }
        return ResponseEntity.badRequest().build();
    }
}
