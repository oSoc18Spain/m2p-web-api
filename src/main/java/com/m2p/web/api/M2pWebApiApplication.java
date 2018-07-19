package com.m2p.web.api;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class M2pWebApiApplication {
	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC")); //GMT+2 
	}
	
	public static void main(String[] args) {
		SpringApplication.run(M2pWebApiApplication.class, args);
	}
}