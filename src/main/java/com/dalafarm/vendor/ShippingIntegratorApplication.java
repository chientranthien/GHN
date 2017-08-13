package com.dalafarm.vendor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class ShippingIntegratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShippingIntegratorApplication.class, args);
	}

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/v1/provinces").allowedOrigins("https://dalafarm.com.vn","http://preview.dalafarm.com.vn","http://localhost:1313");
                registry.addMapping("/v1/province/**/districts").allowedOrigins("https://dalafarm.com.vn","http://preview.dalafarm.com.vn","http://localhost:1313");
                registry.addMapping("/v1/logistic/shipping-fee").allowedOrigins("https://dalafarm.com.vn","http://preview.dalafarm.com.vn","http://localhost:1313");
                registry.addMapping("/v1/orders").allowedOrigins("https://dalafarm.com.vn","http://preview.dalafarm.com.vn","http://localhost:1313");
                registry.addMapping("/v1/order/**/*").allowedOrigins("https://dalafarm.com.vn","http://preview.dalafarm.com.vn","http://localhost:1313");
            }
        };
    }
}
