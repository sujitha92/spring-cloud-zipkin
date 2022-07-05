package com.spring.zipkindemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ZipkinDemoApplication {
	
	private static final Logger LOG = LoggerFactory.getLogger(ZipkinDemoApplication.class);
	
	@Autowired
	private RestTemplate template;

	@GetMapping(value="/zipkin1")
    public String zipkinService1() {
		
		LOG.info("Inside zipkinService 1..");
		
		return "Inside zipkinService 1..";
		
	}
	
	@GetMapping(value="/zipkin2")
    public String zipkinService2() {
		
		LOG.info("Inside zipkinService 2..");
		
		return template.getForObject("http://localhost:8080/zipkin1", String.class);
		
	}

	public static void main(String[] args) {
		SpringApplication.run(ZipkinDemoApplication.class, args);
	}

}
