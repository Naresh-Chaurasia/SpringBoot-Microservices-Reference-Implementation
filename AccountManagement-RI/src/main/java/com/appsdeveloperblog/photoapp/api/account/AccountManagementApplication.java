package com.appsdeveloperblog.photoapp.api.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AccountManagementApplication {

	public static void main(String[] args) {
		System.out.println("Current JVM version - " + System.getProperty("java.version"));
		SpringApplication.run(AccountManagementApplication.class, args);
	}

}
