package com.mydemoapp.mydemoapp;

// this consists of : @EnableAutoConfiguration (enable spring's auto-config support), @ComponentScan (enables component scanning), @Configuration (able to register extra beans with @beans)
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MydemoappApplication {

	// this bootstraps the entire application
	// spring boot searches recursively for packages to register them under com.mydemoapp.mydemoapp, anything outside this folder will not be added to the project
	// You can add packages manually by scanBasePackages
	public static void main(String[] args) {
		SpringApplication.run(MydemoappApplication.class, args);
	}

}
