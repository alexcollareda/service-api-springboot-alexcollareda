package br.com.alexcollareda.service.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * Main class to run springboot API, where expose controllers and run swagger
 * @author alexc
 *
 */
@SpringBootApplication
@EnableConfigurationProperties
@EnableSwagger2
public class ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

}