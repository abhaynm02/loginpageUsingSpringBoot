package com.firstproject.loginpage;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoginPageApplication {

	public static void main(String[] args) {

		SpringApplication.run(LoginPageApplication.class, args);

		System.out.println("hey this abhay nm ");
	}


}
