package com.quickcravebackend.controller;

import com.quickcravebackend.model.Vendor;
import com.quickcravebackend.service.VendorService_Imp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Objects;

@Controller
public class VendorController {
    @Autowired
    private VendorService_Imp vendorService_Imp;

    @PostMapping("/vendor/insert")
    public Integer insert(String name, String password){
        return vendorService_Imp.insert(name,password);
    }

    @GetMapping("/vendor/selectAll")
    public List<Vendor> selectAll() {
        return vendorService_Imp.selectAll();
    }
    @GetMapping("/vendor/selectByName")
    public Vendor selectByName(String name) {
        return vendorService_Imp.selectByName(name);
    }

    @DeleteMapping("/vendor/delete")
    public Integer delete(Long id){
        return vendorService_Imp.delete(id);
    }

    @PutMapping("/vendor/update")
    public Integer update(Long id){
        return vendorService_Imp.update(id);
    }

    @GetMapping("vendor/login")
    public String Login(String name, String password){
        if(selectByName(name) != null){
            Vendor vendor = selectByName(name);
            String cur_name = vendor.getName();
            String cur_password = vendor.getPassword();
            if((Objects.equals(cur_name,name)) && (Objects.equals(cur_password,password))){
                return "success";
            }
        }
        return "fail";
    }

    @PostMapping("vendor/signup")
    public String Register(String name, String password){
        if(selectByName(name) != null) {
            insert(name,password);
            return "success";
        }
        return "fail";
    }
}
