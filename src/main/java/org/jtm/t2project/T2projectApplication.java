package org.jtm.t2project;

import java.util.Arrays;

import org.jtm.t2project.controller.LibraryController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan
public class T2projectApplication {

	public static void main(String[] args) {
		SpringApplication.run(T2projectApplication.class, args);
	}

}
