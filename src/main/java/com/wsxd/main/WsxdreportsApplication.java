package com.wsxd.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.wsxd.main.dao")
@EnableScheduling
public class WsxdreportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsxdreportsApplication.class, args);
	}
}
