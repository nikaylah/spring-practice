package com.example;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import com.example.jwtfilter.AuthFilter;

@SpringBootApplication
@PropertySource("classpath:dbconfig.properties")
public class JwtDemoApplication {

	@Bean
	public FilterRegistrationBean jwtFilter() {
		FilterRegistrationBean<Filter> b = new FilterRegistrationBean<Filter>();
		
		b.setFilter(new AuthFilter());
		b.addUrlPatterns("/api/v1/*");
		
		return b;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(JwtDemoApplication.class, args);
	}

}
