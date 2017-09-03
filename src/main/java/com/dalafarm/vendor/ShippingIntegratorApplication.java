package com.dalafarm.vendor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShippingIntegratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShippingIntegratorApplication.class, args);
	}
//
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/v1/provinces").allowedOrigins("https://dalafarm.com.vn","http://preview.dalafarm.com.vn","http://localhost:1313");
//                registry.addMapping("/v1/province/**/districts").allowedOrigins("https://dalafarm.com.vn","http://preview.dalafarm.com.vn","http://localhost:1313");
////                registry.addMapping("/v1/logistic/shipping-fee").allowedOrigins("https://dalafarm.com.vn","http://preview.dalafarm.com.vn","http://localhost:1313");
//                registry.addMapping("/v1/logistic/shipping-fee").allowedOrigins("*");
//                registry.addMapping("/v1/orders").allowedOrigins("https://dalafarm.com.vn","http://preview.dalafarm.com.vn","http://localhost:1313");
//                registry.addMapping("/v1/order/**/*").allowedOrigins("https://dalafarm.com.vn","http://preview.dalafarm.com.vn","http://localhost:1313");
//            }
//        };
//    }
}
