package com.example.ShareVault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ShareVaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShareVaultApplication.class, args);
	}
	@GetMapping("/Hello")
		public String sayHello(){
			return "Hello this is a document sharing portal";
		}
	}


