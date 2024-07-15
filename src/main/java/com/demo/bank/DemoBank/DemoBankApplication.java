package com.demo.bank.DemoBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootApplication
public class DemoBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoBankApplication.class, args);
		String password = BCrypt.hashpw("User1@123", BCrypt.gensalt());
		System.out.println(password);
	}

}
