package com.quickcravebackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin
@RequestMapping("/upload")
public class FileUploadController {
//    private static final String baseUrl = "D:\\Document\\QuickCrave-BackEnd\\src\\main\\resources\\static";
    private static final String baseUrl = "/usr/local/java/static";

    @PostMapping("/vendor")
    public ResponseEntity<String> uploadVendorFile(@RequestParam("files") MultipartFile[] files) {
        if (files.length == 0) {
            return new ResponseEntity<>("Please select a file to upload.", HttpStatus.BAD_REQUEST);
        }
        try {
            boolean flag = false;
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    saveVendorFile(file);
                    flag = true;
                }
            }
            if (!flag) {
                return new ResponseEntity<>("Please select a file to upload.", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("File uploaded successfully.", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("File uploaded fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void saveVendorFile(MultipartFile file) throws IOException {
        Path filepath = Paths.get(baseUrl+"/vendor", file.getOriginalFilename());
        file.transferTo(new File(filepath.toString()));
    }

    @PostMapping("/goods")
    public ResponseEntity<String> uploadGoodsFile(@RequestParam("files") MultipartFile[] files) {
        if (files.length == 0) {
            return new ResponseEntity<>("Please select a file to upload.", HttpStatus.BAD_REQUEST);
        }
        try {
            boolean flag = false;
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    saveGoodsFile(file);
                    flag = true;
                }
            }
            if (!flag) {
                return new ResponseEntity<>("Please select a file to upload.", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("File uploaded successfully.", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("File uploaded fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void saveGoodsFile(MultipartFile file) throws IOException {
        Path filepath = Paths.get(baseUrl+"/goods", file.getOriginalFilename());
        file.transferTo(new File(filepath.toString()));
    }

    @PostMapping("/user")
    public ResponseEntity<String> uploadUserFile(@RequestParam("files") MultipartFile[] files) {
        if (files.length == 0) {
            return new ResponseEntity<>("Please select a file to upload.", HttpStatus.BAD_REQUEST);
        }
        try {
            boolean flag = false;
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    saveUserFile(file);
                    flag = true;
                }
            }
            if (!flag) {
                return new ResponseEntity<>("Please select a file to upload.", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("File uploaded successfully.", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("File uploaded fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void saveUserFile(MultipartFile file) throws IOException {
        Path filepath = Paths.get(baseUrl+"/user", file.getOriginalFilename());
        file.transferTo(new File(filepath.toString()));
    }

    @PostMapping("/delivery")
    public ResponseEntity<String> uploadDeliveryFile(@RequestParam("files") MultipartFile[] files) {
        if (files.length == 0) {
            return new ResponseEntity<>("Please select a file to upload.", HttpStatus.BAD_REQUEST);
        }
        try {
            boolean flag = false;
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    saveDeliveryFile(file);
                    flag = true;
                }
            }
            if (!flag) {
                return new ResponseEntity<>("Please select a file to upload.", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("File uploaded successfully.", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("File uploaded fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void saveDeliveryFile(MultipartFile file) throws IOException {
        Path filepath = Paths.get(baseUrl+"/delivery", file.getOriginalFilename());
        file.transferTo(new File(filepath.toString()));
    }

}