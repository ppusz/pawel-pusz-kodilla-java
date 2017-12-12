package com.kodilla.spring;

import com.kodilla.spring.reader.Book;
import com.kodilla.spring.reader.ReaderConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringRunner.class, args);

	}
}
