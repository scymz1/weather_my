package com.example.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}

}

//@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@RestController
//public class ConfigApplication {
//	@Value("${config.name}")
//	String name = "World";
//
//	@RequestMapping("/")
//	public String home() {
//		return "Hello " + name;
//	}
//	public static void main(String[] args) {
//		SpringApplication.run(ConfigApplication.class, args);
//	}
//
//}