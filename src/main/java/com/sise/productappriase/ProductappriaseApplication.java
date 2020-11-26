package com.sise.productappriase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.sise.productappriase.dao")
public class ProductappriaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductappriaseApplication.class, args);
	}

}
