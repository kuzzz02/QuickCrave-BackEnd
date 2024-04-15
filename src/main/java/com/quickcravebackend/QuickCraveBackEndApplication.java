package com.quickcravebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//(exclude= {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class QuickCraveBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuickCraveBackEndApplication.class, args);
    }

}
