package com.money.fimsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.money.fimsystem.business")
@SpringBootApplication
public class FimsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FimsystemApplication.class, args);
	}

}
