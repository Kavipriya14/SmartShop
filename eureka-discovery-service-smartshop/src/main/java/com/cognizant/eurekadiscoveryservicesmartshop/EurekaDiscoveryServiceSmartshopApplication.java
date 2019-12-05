package com.cognizant.eurekadiscoveryservicesmartshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDiscoveryServiceSmartshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaDiscoveryServiceSmartshopApplication.class, args);
	}

}
