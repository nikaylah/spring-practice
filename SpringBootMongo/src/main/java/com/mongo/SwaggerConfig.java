package com.mongo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()								//Builder
				.paths(PathSelectors.ant("/students/**")) 	//Can also use regex for pathSelectors
				.apis(RequestHandlerSelectors.basePackage("com.mongo"))
				.build()								//Docket
				.apiInfo(getApiInfo());					//Configuring api information
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
		.title("student Catalog API")
		.build();
	}

}
