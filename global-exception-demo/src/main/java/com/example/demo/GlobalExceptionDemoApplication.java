package com.example.demo;

import com.example.demo.exception.BadRequestException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@SpringBootApplication
@RestController
public class GlobalExceptionDemoApplication {

    @GetMapping("/index")
	public String index(String name){
        if (null == name) {
            throw new BadRequestException("index","请求400，模拟异常！");
        }
		return Instant.now().toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(GlobalExceptionDemoApplication.class, args);
	}
}
