package com.quickcravebackend.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@RestController
@CrossOrigin
@RequestMapping("/image")
public class ImageController {
    private void sentImage(HttpServletResponse response, InputStream in) throws IOException {
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        OutputStream out = response.getOutputStream();

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        in.close();
    }

    @GetMapping(value = "/vendor/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void getVendorImage(@PathVariable String imageName, HttpServletResponse response) throws IOException {
        InputStream image = getClass().getResourceAsStream("/static/vendor/" + imageName);
        if (image != null) {
            sentImage(response, image);
        }
    }

    @GetMapping(value = "/goods/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void getGoodsImage(@PathVariable String imageName, HttpServletResponse response) throws IOException {
        InputStream image = getClass().getResourceAsStream("/static/goods/" + imageName);
        if (image != null) {
            sentImage(response, image);
        }
    }

    @GetMapping(value = "/user/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void getUserImage(@PathVariable String imageName, HttpServletResponse response) throws IOException {
        InputStream image = getClass().getResourceAsStream("/static/user/" + imageName);
        if (image != null) {
            sentImage(response, image);
        }
    }

    @GetMapping(value = "/delivery/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void getDeliveryImage(@PathVariable String imageName, HttpServletResponse response) throws IOException {
        InputStream image = getClass().getResourceAsStream("/static/delivery/" + imageName);
        if (image != null) {
            sentImage(response, image);
        }
    }
}
