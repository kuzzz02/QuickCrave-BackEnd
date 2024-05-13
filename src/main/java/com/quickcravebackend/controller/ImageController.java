package com.quickcravebackend.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@RestController
@CrossOrigin
@RequestMapping("/image")
public class ImageController {
//    private final String baseUrl  = "/src/main/resources/static";
    private final String baseUrl = "/usr/local/java/static";
    @GetMapping(value = "/vendor")
    public ResponseEntity<Resource> getVendorImage(String imageName) throws IOException {
        String Url = baseUrl + "/vendor/" + imageName;
        File file = new File(Url);
        Resource resource = new UrlResource(file.toURI());
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(resource);
    }

    @GetMapping(value = "/goods")
    public ResponseEntity<Resource> getGoodsImage(String imageName) throws IOException {
        String Url = baseUrl + "/goods/" + imageName;
        File file = new File(Url);
        Resource resource = new UrlResource(file.toURI());
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(resource);
    }

    @GetMapping(value = "/user")
    public ResponseEntity<Resource> getUserImage(String imageName) throws IOException {
        String Url = baseUrl + "/user/" + imageName;
        File file = new File(Url);
        Resource resource = new UrlResource(file.toURI());
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(resource);
    }

    @GetMapping(value = "/delivery")
    public ResponseEntity<Resource> getDeliveryImage(String imageName) throws IOException {
        String Url = baseUrl + "/delivery/" + imageName;
        File file = new File(Url);
        Resource resource = new UrlResource(file.toURI());
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(resource);
    }


//        public void sentImage(HttpServletResponse response, InputStream in) throws IOException {
//        try {
//            response.setContentType(MediaType.IMAGE_PNG_VALUE);
//            OutputStream out = response.getOutputStream();
//
//            byte[] buffer = new byte[1024];
//            int bytesRead = 0;
//            while ((bytesRead = in.read(buffer)) != -1) {
//                out.write(buffer, 0, bytesRead);
//                out.flush();
//            }
//            in.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

//    @GetMapping(value = "/vendor", produces = MediaType.IMAGE_PNG_VALUE)
//    public void getVendorImage(String imageName, HttpServletResponse response) throws IOException {
//        InputStream image = getClass().getResourceAsStream("/static/vendor/" + imageName);
//        if (image != null) {
//            sentImage(response, image);
//        }
//    }

}
