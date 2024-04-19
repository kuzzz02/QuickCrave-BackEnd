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

// create database qcdb;
// create user 'qc'@'%' identified by 'qc123456';
// grant all on qcdb.* to 'qc'@'%';
