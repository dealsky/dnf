package com.dealsky.dnf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dealsky.dnf.dao")
public class DnfApplication {

	public static void main(String[] args) {
		SpringApplication.run(DnfApplication.class, args);
	}
}
