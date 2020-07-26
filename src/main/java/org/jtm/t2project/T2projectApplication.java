package org.jtm.t2project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class T2projectApplication {

    public static void main(String[] args) {
        SpringApplication.run(T2projectApplication.class, args);
    }

}