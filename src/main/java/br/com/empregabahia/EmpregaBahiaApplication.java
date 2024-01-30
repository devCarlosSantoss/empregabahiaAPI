package br.com.empregabahia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.empregabahia")
public class EmpregaBahiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpregaBahiaApplication.class, args);
	}

}
