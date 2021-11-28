package com.job4all.profile;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import lombok.extern.log4j.Log4j2;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ImportResource("classpath:spring/application-context.xml")
@EnableSwagger2
@Log4j2
public class UserprofileApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(UserprofileApplication.class, args);
	}

	@Bean
	public Docket productApi() {
	   return new Docket(DocumentationType.SWAGGER_2).select()
	      .apis(RequestHandlerSelectors.basePackage("com.job4all.profile.candidate.controller")).build();
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Application is running");
		log.info(">>>>>>>>>>>>>>>>>>>> Application is running");
		//throw new Exception("Bug");
	}
}