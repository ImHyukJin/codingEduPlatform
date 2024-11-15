package com.project.cep;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.project.cep.repository")
public class Cep1Application {

	public static void main(String[] args) {
		try {
            SpringApplication.run(Cep1Application.class, args);
        } catch (Exception e) {
            e.printStackTrace();  // 예외를 출력하여 어디서 발생하는지 확인
        }
	}

}
