package com.gotcha.part_time_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import java.lang.System;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PartTimeManagementApplication {

	public static void main(String[] args) {
        java.lang.System.out.println("hello.");
		SpringApplication.run(PartTimeManagementApplication.class, args);
	}

}
