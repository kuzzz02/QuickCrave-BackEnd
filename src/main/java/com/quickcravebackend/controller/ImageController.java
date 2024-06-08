package com.quickcravebackend.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.*;

@RestController
@CrossOrigin
@RequestMapping("/image")
public class ImageController {
//    private static final String baseUrl = "src/main/resources/static";
    private static final String baseUrl = "/usr/local/java/static";

    private ResponseEntity<StreamingResponseBody> getResponseEntity(String Url) throws IOException {
        File file = new File(Url);
        InputStream in = new FileInputStream(file);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(out -> {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                    in.close();
                });
    }

    @GetMapping(value = "/vendor")
//    Response
    public ResponseEntity<StreamingResponseBody> getVendorImage(String imageName) throws IOException {
        String Url = baseUrl + "/vendor/" + imageName;
        return getResponseEntity(Url);
    }

    @GetMapping(value = "/goods")
    public ResponseEntity<StreamingResponseBody> getGoodsImage(String imageName) throws IOException {
        String Url = baseUrl + "/goods/" + imageName;
        return getResponseEntity(Url);
    }

    @GetMapping(value = "/user")
    public ResponseEntity<StreamingResponseBody> getUserImage(String imageName) throws IOException {
        String Url = baseUrl + "/user/" + imageName;
        return getResponseEntity(Url);
    }

    @GetMapping(value = "/delivery")
    public ResponseEntity<StreamingResponseBody> getDeliveryImage(String imageName) throws IOException {
        String Url = baseUrl + "/delivery/" + imageName;
        return getResponseEntity(Url);
    }
}
