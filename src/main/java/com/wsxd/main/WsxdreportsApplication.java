package com.wsxd.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wsxd.main.dao")
public class WsxdreportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsxdreportsApplication.class, args);
	}
}
