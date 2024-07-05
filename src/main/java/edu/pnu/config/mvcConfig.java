package edu.pnu.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class mvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://192.168.0.164:3000","http://localhost:3000","http://10.125.121.155:5000","http://localhost:9090","http://192.168.56.1:9090")
                .allowedMethods("OPTIONS", "GET", "POST", "PUT", "DELETE","REQUESTS");
    }
}